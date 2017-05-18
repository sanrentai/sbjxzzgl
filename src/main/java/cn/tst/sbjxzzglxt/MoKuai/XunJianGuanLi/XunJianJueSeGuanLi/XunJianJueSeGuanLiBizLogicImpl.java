/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianJueSeGuanLi;

import cn.tst.sbjxzzglxt.bizlogic.impl.BaseBizLogic;
import cn.tst.sbjxzzglxt.facade.MstXunJianRoleFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@Stateless
public class XunJianJueSeGuanLiBizLogicImpl extends BaseBizLogic implements BizLogic {
    @EJB
    private MstXunJianRoleFacade xunJianRoleFacade;

    public MstXunJianRoleFacade getXunJianRoleFacade() {
        return xunJianRoleFacade;
    }

    public void setXunJianRoleFacade(MstXunJianRoleFacade xunJianRoleFacade) {
        this.xunJianRoleFacade = xunJianRoleFacade;
    }
    
    @Override
    public void loadViewModel(ViewModel vm) {
        vm.setRoleList(xunJianRoleFacade.findAll());
    }
    @Override 
    public void onSubmitNewRole(ViewModel vm) {
        xunJianRoleFacade.create(vm.getRoleInEdit());
        loadViewModel(vm);
        vm.setRoleInEdit(null);
    }
}
