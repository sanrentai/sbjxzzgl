package cn.tst.sbjxzzglxt.bizlogic.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.bizlogic.MST0007BizLogic;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.DatYuangongRole;
import cn.tst.sbjxzzglxt.entity.DatYuangongRolePK;
import cn.tst.sbjxzzglxt.entity.MstGnShiYongQuanXian;
import cn.tst.sbjxzzglxt.entity.MstYuanGong;
import cn.tst.sbjxzzglxt.lazymodel.MstYuanGongLazyModel;
import cn.tst.sbjxzzglxt.service.impl.DatYuangongRoleFacade;
import cn.tst.sbjxzzglxt.service.impl.MstGnShiYongQuanXianFacade;
import cn.tst.sbjxzzglxt.service.impl.MstRoleInfoFacade;
import cn.tst.sbjxzzglxt.service.impl.MstYuanGongFacade;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.MST0007ViewModel;
import org.primefaces.model.LazyDataModel;

/**
 * 角色信息
 *
 * @author ps_xy@pscp.co.jp
 */
@Stateless
public class MST0007BizLogicImpl extends BaseBizLogic implements MST0007BizLogic {

    private final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(MST0007BizLogicImpl.class);

    ///员工信息Facade
    @EJB
    private MstYuanGongFacade yuanGongService;

    ///员工角色Facade
    @EJB
    private DatYuangongRoleFacade ygRoleService;

    ///功能权限Facade
    @EJB
    private MstGnShiYongQuanXianFacade quanXianService;

    ///角色Facade
    @EJB
    private MstRoleInfoFacade roleService;

    @Override
    public void loadMST0007ViewModel(MST0007ViewModel vm) {

        ///取得所有员工信息
        LazyDataModel<MstYuanGong> yuanGongList = new MstYuanGongLazyModel(this.yuanGongService);

        vm.setYuanGongList(yuanGongList);
    }

    @Override
    public void refreshYuanGongRole(MST0007ViewModel vm) {

        ///选中的员工
        MstYuanGong selectedYuanGong = vm.getEditingYuanGong();

        ///获取所有角色
        List<DatYuangongRole> ygRoles = ygRoleService.findYuanGongRoles(selectedYuanGong.getYuanGongId());

        ///设置角色
        vm.setYuanGongRoleList(ygRoles);
    }

    @Override
    public void refreshRoleGongNeng(MST0007ViewModel vm) {

        ///选中的角色
        DatYuangongRole selectedRole = vm.getSelectedYuanGongRole();

        ///获取角色可用权限信息
        List<MstGnShiYongQuanXian> quanXianList = quanXianService.findUsableQuanXian(selectedRole.getPk().getRoleId());

        vm.setUsableQuanXian(quanXianList);
    }

    @Override
    public ExecuteResult saveYuanGongRole(MST0007ViewModel vm) {

        ExecuteResult result = new ExecuteResult(SepE.ExecuteMode.UPDATE);

        try {

            MstYuanGong yuanGong = vm.getEditingYuanGong();

            ///删除全部角色
            this.ygRoleService.removeAllRoleByYuanGong(yuanGong.getYuanGongId());

            vm.getYuanGongRoleList()
                .stream()
                .filter(r -> r.isYouXiaoB())
                .forEach(r -> {
                    r.setPk(new DatYuangongRolePK(yuanGong.getYuanGongId(), r.getRole().getRoleId()));
                    ygRoleService.create(r);
                });

            result.setSuccess(true);

        } catch (Exception e) {
            result.anylizeException(e);
            result.setSuccess(false);
            LOG.error(e);
        }

        return result;
    }

}
