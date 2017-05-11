/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianDianSheZhi;

import cn.tst.sbjxzzglxt.bizlogic.impl.BaseBizLogic;
import cn.tst.sbjxzzglxt.service.impl.LTEquipBasicFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@Stateless
public class BizLogicImplementation extends BaseBizLogic implements BizLogic {
    @EJB
    private LTEquipBasicFacade equipmentFacade;
    @Override
    public void loadViewModel(ViewModel vm) {
        vm.setEquipmentList(equipmentFacade.findAll());
    }
}
