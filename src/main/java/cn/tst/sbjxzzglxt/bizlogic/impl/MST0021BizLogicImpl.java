package cn.tst.sbjxzzglxt.bizlogic.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.bizlogic.MST0021BizLogic;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.MstXunJianRole;
import cn.tst.sbjxzzglxt.facade.LTEquipBasicFacade;
import cn.tst.sbjxzzglxt.facade.MstXunJianRoleFacade;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.MST0021ViewModel;

/**
 * 巡检角色登记
 *
 * @author 曹春
 */
@Stateless
public class MST0021BizLogicImpl extends BaseBizLogic implements MST0021BizLogic {

    private final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(MST0021BizLogicImpl.class);
//
//    @EJB
//    private MstCheLiangFacade cheLiangDao;
//    
    @EJB
    private LTEquipBasicFacade equipBasicDao;
//
    @EJB
    private MstXunJianRoleFacade xunJianRoleDao;
//
//    @EJB
//    private MstYuanGongFacade mstYuanGongDao;

    @Override
    public void loadMST0021ViewModel(MST0021ViewModel vm) {
        refreshXunJianRole(vm);
    }

    @Override
    public void refreshXunJianRole(MST0021ViewModel vm) {
        List<MstXunJianRole> xunJianRoleList = xunJianRoleDao.findAll();
        vm.setXunJianRoleList(xunJianRoleList);
        chaXunXunJianDian(vm);
    }

    @Override
    public ExecuteResult saveXunJianRoleJiLu(SepE.ExecuteMode mode, MST0021ViewModel vm) {

        ExecuteResult result = new ExecuteResult(mode);

        try {

            MstXunJianRole target = vm.getEditingXunJianRole();

            switch (mode) {
                case INSERT:
                    xunJianRoleDao.create(target);
                    break;
                case UPDATE:
                    /// 更新库存数
                    xunJianRoleDao.edit(target);
                    break;
                case DELETE:
                    xunJianRoleDao.remove(target);
                    break;
            }
            vm.setXunJianRoleList(xunJianRoleDao.findAll());
            result.setSuccess(true);
        } catch (Exception e) {
            result.anylizeException(e);
            result.setSuccess(false);
            e.printStackTrace();
            LOG.error(e);
        }
        return result;
    }

    @Override
    public void chaXunXunJianDian(MST0021ViewModel vm) {
        List<LTEquipBasic> sheBeiList = equipBasicDao.findByCId(new Long(SepC.EQP_ROOT));
        vm.setSheBeiList(sheBeiList);
    }

}
