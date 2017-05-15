/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianDianSheZhi;

import cn.tst.sbjxzzglxt.bizlogic.impl.BaseBizLogic;
import cn.tst.sbjxzzglxt.entity.LTEquipCheckPoint;
import cn.tst.sbjxzzglxt.facade.LTEquipBasicFacade;
import cn.tst.sbjxzzglxt.facade.LTEquipCheckPointFacade;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.primefaces.model.DefaultStreamedContent;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@Stateless
public class BizLogicImplementation extends BaseBizLogic implements BizLogic {
    @EJB
    private LTEquipBasicFacade equipmentFacade;
    @EJB
    private LTEquipCheckPointFacade checkPointFacade;
    @Override
    public void loadViewModel(ViewModel vm) {
        vm.setEquipmentList(equipmentFacade.findAll());
    }
    @Override
    public void onCoordConfirmDialogAccepted(ViewModel vm) {
        LTEquipCheckPoint checkPoint = new LTEquipCheckPoint();
        checkPoint.setEquipmentId(vm.getCurrentEquipment().getId().intValue());
        checkPoint.setX(vm.getX());
        checkPoint.setY(vm.getY());
        checkPointFacade.create(checkPoint);
    }
    @Override
    public void onMoveCoordConfirmDialogAccepted(ViewModel vm) {
        LTEquipCheckPoint checkPoint = checkPointFacade.find(vm.getCheckPointId());
        checkPoint.setX(vm.getX());
        checkPoint.setY(vm.getY());
        checkPointFacade.edit(checkPoint);
    }
}
