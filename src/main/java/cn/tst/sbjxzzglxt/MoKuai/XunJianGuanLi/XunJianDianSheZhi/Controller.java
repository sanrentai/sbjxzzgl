/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianDianSheZhi;

import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import cn.tst.sbjxzzglxt.entity.LTEquipCheckPoint;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@ViewScoped
@Named(SepC.ControllerID.XUN_JIAN_DIAN_SHE_ZHI_CONTROLLER_NAME)
public class Controller extends BusinessBaseController {
    private ViewModel vm;
    
    @EJB
    private BizLogic bizLogic;

    public ViewModel getVm() {
        return vm;
    }
    
    private Integer currentEquipmentId;

    public Integer getCurrentEquipmentId() {
        return currentEquipmentId;
    }

    public void setCurrentEquipmentId(Integer currentEquipmentId) {
        this.currentEquipmentId = currentEquipmentId;
        bizLogic.setCurrentEquipment(vm, currentEquipmentId);
    }
    
    @PostConstruct
    public void init() {
        vm = new ViewModel();
        bizLogic.loadViewModel(vm);
    }

    public void setVm(ViewModel vm) {
        this.vm = vm;
    }

    public BizLogic getBizLogic() {
        return bizLogic;
    }

    public void setBizLogic(BizLogic bizLogic) {
        this.bizLogic = bizLogic;
    }
    
    public void onCoordConfirmDialogAccepted() {
        bizLogic.onCoordConfirmDialogAccepted(vm);
        updateViewModel();
    }
    
    public void updateViewModel() {
        bizLogic.loadViewModel(vm);
        if(getCurrentEquipmentId() != null) {
            this.setCurrentEquipmentId(getCurrentEquipmentId());
        }
    }
    
    public void onMoveCoordConfirmDialogAccepted() {
        bizLogic.onMoveCoordConfirmDialogAccepted(vm);
        updateViewModel();
    }
    
    public void onCkeckPointRemoveConfirmDialogAccepted() {
        bizLogic.onCkeckPointRemoveConfirmDialogAccepted(vm);
        updateViewModel();
    }
    
    public void onCheckPointEditConfirmDialogAccepted() {
        bizLogic.onCheckPointEditConfirmDialogAccepted(vm);
        updateViewModel();
    }
}
