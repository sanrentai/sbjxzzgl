/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.LuRuXunJianJieGuo;

import cn.tst.sbjxzzglxt.bizlogic.impl.BaseBizLogic;
import cn.tst.sbjxzzglxt.common.EquipmentTree;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.facade.LTEquipBasicFacade;
import cn.tst.sbjxzzglxt.facade.LTEquipCheckPointFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@Stateless
public class LuRuXunJianJieGuoBizLogicImpl extends BaseBizLogic implements BizLogic {
    @EJB
    private LTEquipBasicFacade equipmentFacade;
    
    @EJB
    private LTEquipCheckPointFacade checkPointFacade;
    
    @Override
    public void loadViewModel(ViewModel vm) {
        vm.setEquipmentList(equipmentFacade.findAll());
        vm.setEquipmentTreeRoot(EquipmentTree.createEqpTree(vm.getEquipmentList()));
    }
    
    @Override
    public void onEquipmentNodeSelect(ViewModel vm, LTEquipBasic equipment) {
        vm.setCurrentEquipment(equipment);
        vm.setCurrentCheckPointList(checkPointFacade.findByEquipmentId(equipment.getId()));
    }
}
