package cn.tst.sbjxzzglxt.bizlogic.impl;

import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import cn.tst.sbjxzzglxt.bizlogic.MST0005BizLogic;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.controller.login.AccountManager;
import cn.tst.sbjxzzglxt.entity.MstCaiDanXiangMu;
import cn.tst.sbjxzzglxt.entity.MstGnShiYongQuanXian;
import cn.tst.sbjxzzglxt.entity.MstGnShiYongQuanXianPK;
import cn.tst.sbjxzzglxt.entity.MstRoleInfo;
import cn.tst.sbjxzzglxt.entity.MstXiTongGongNeng;
import cn.tst.sbjxzzglxt.service.impl.MstCaiDanXiangMuFacade;
import cn.tst.sbjxzzglxt.service.impl.MstGnShiYongQuanXianFacade;
import cn.tst.sbjxzzglxt.service.impl.MstRoleInfoFacade;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.MST0005ViewModel;

/**
 * 权限管理业务逻辑层实现
 *
 * @author ps_xy@pscp.co.jp
 */
@Stateless
public class MST0005BizLogicImpl extends BaseBizLogic implements MST0005BizLogic {

    private final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(MST0005BizLogicImpl.class);

    @Inject
    protected AccountManager accountManager;

    ///角色信息Facade
    @EJB
    private MstRoleInfoFacade roleService;

    @EJB
    private MstGnShiYongQuanXianFacade quanXianService;

    @EJB
    private MstCaiDanXiangMuFacade caiDanService;

    @Override
    public void loadMST0005ViewModel(MST0005ViewModel vm) {

        ///获取所有角色
        List<MstRoleInfo> roleList = roleService.findAll();

        vm.setRoleList(roleList);
        
    }

    @Override
    public void refreshAllQuanXian(MST0005ViewModel vm) {

        ///角色ID
        String roleId = vm.getSelectedRole().getRoleId();

        ///获取权限一览
        List<MstCaiDanXiangMu> caiDanList = caiDanService.findAllHasFunctionCaiDan();

        ///设置
        vm.setCaiDanList(caiDanList);

        ///清除权限一览
        vm.getQuanXianList().clear();

        for (MstCaiDanXiangMu cd : caiDanList) {
            for (MstXiTongGongNeng gn : cd.getGongNengList()) {

                ///功能ID
                String gongNengId = gn.getGongNengId();
                ///权限一览
                Map<String, MstGnShiYongQuanXian> qxMap = vm.getQuanXianList();
                ///检索对应权限
                MstGnShiYongQuanXian gnqx
                    = quanXianService.find(new MstGnShiYongQuanXianPK(roleId, gongNengId));

                ///如果数据库中没有权限数据则创建一个新的对象
                if (gnqx == null) {
                    gnqx = new MstGnShiYongQuanXian(roleId, gongNengId);
                    gnqx.setQuanXianB(false);
                    gnqx.setCreateInfo(accountManager.getLoginInfo().getYuanGong().getYuanGongId());
                }
                qxMap.put(gongNengId, gnqx);
            }
        }
        
    }

    @Override
    public ExecuteResult saveQuanXianData(MST0005ViewModel vm) {

        ExecuteResult result = new ExecuteResult();

//        EntityManager em = am.getEntityManager();
        try {
//            em.joinTransaction();
            
            /// 更新角色
            roleService.edit(vm.getSelectedRole());

            ///删除全部权限
            quanXianService.removeAllByBuMenZhiNeng(vm.getSelectedRole().getRoleId());

            ///追加权限
            for (MstGnShiYongQuanXian value : vm.getQuanXianList().values()) {
                quanXianService.create(value);
            }
//            vm.getQuanXianList().forEach((k, v) -> {
//                quanXianService.create(v);
//            });
            
            
            result.setSuccess(true);

        } catch (Exception e) {
            result.anylizeException(e);
            result.setSuccess(false);
            LOG.error(e);
        }

        return result;
    }

    @Override
    public ExecuteResult saveRoleData(SepE.ExecuteMode mode, MST0005ViewModel vm) {

        ExecuteResult result = new ExecuteResult(mode);

        try {

            MstRoleInfo targetRole = vm.getEditingRole();

            switch (mode) {
                case INSERT:
                    roleService.create(targetRole);
                    break;
                case UPDATE:
                    roleService.edit(targetRole);
                    break;
                case DELETE:
                    roleService.forceRemove(targetRole);
                    break;
            }

            result.setSuccess(true);
        } catch (Exception e) {
            result.anylizeException(e);
            result.setSuccess(false);
        }

        return result;
    }
}
