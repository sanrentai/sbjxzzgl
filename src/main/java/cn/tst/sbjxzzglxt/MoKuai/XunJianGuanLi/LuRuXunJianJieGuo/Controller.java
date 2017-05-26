/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.LuRuXunJianJieGuo;

import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
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
@Named(SepC.ControllerID.LU_RU_XUN_JIAN_JIE_GUO_CONTROLLER_NAME)
public class Controller extends BusinessBaseController {
    private ViewModel vm;
    
    @EJB
    private BizLogic bizLogic;

    public ViewModel getVm() {
        return vm;
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
    
    @PostConstruct
    public void init() {
        vm = new ViewModel();
        bizLogic.loadViewModel(vm);
    }
    
    public void onEquipmentNodeSelect(LTEquipBasic equipment) {
        bizLogic.onEquipmentNodeSelect(vm, equipment);
    }
    
    public void onCheckPointSelect(LTEquipCheckPoint checkPoint) {
        bizLogic.onCheckPointSelect(vm, checkPoint);
    }
}
