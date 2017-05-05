/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.controller.equipment;

import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import cn.tst.sbjxzzglxt.entity.*;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.NodeSelectEvent;
import cn.tst.sbjxzzglxt.viewmodel.*;
import javax.ejb.EJB;
import cn.tst.sbjxzzglxt.service.impl.*;
import java.util.List;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@ViewScoped
@Named(SepC.ControllerID.EQP0002)
public class EQP0002Controller extends BusinessBaseController {

    private EQP0002ViewModel vm = new EQP0002ViewModel();
    @EJB
    private LTFittingFacade service;

    public void onNodeSelect(NodeSelectEvent event) {
        LTEquipBasic equip = (LTEquipBasic) event.getTreeNode().getData();
        String eNum = equip.getENum();
        vm.setEquipSelected(equip);
        List<LTEquipFitting> fittingList = service.findByENum(eNum);
        equip.setEquipFittingList(fittingList);
    }

    public EQP0002ViewModel getVm() {
        return vm;
    }

    public void setVm(EQP0002ViewModel vm) {
        this.vm = vm;
    }

    public void onAddTargetData() {
        LTEquipFitting entity = new LTEquipFitting();
        vm.setEquipFittingEdited(entity);
        entity.setENum(vm.getEquipSelected().getENum());
    }

    public void onSaveData() {
        service.create(vm.getEquipFittingEdited());
        LTEquipBasic equip = vm.getEquipSelected();
        String eNum = equip.getENum();
        List<LTEquipFitting> fittingList = service.findByENum(eNum);
        equip.setEquipFittingList(fittingList);
        vm.setEquipFittingEdited(null);
    }

    public void onCancelEdit() {
        vm.setEquipFittingEdited(null);
    }
}
