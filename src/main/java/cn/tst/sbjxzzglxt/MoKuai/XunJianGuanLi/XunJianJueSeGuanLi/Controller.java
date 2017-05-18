/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianJueSeGuanLi;

import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import cn.tst.sbjxzzglxt.entity.MstXunJianRole;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@ViewScoped
@Named(SepC.ControllerID.XUN_JIAN_JUE_SE_GUAN_LI_CONTROLLER_NAME)
public class Controller extends BusinessBaseController {
    @PostConstruct
    public void init() {
        vm = new ViewModel();
        bizLogic.loadViewModel(vm);
    }
    private ViewModel vm;
    
    @EJB
    private BizLogic bizLogic;

    public BizLogic getBizLogic() {
        return bizLogic;
    }

    public void setBizLogic(BizLogic bizLogic) {
        this.bizLogic = bizLogic;
    }

    public ViewModel getVm() {
        return vm;
    }

    public void setVm(ViewModel vm) {
        this.vm = vm;
    }
    
    public void onAddNewRole() {
        vm.setRoleInEdit(new MstXunJianRole());
    }
    
    public void onSubmitNewRole() {
        bizLogic.onSubmitNewRole(vm);
    }
    
    public void onEditXunJianFanWei(MstXunJianRole role) {
        
    }
    
    public void onEditXunJianGuiZe(MstXunJianRole role) {
        
    }
}
