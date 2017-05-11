/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianDianSheZhi;

import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipGraphic;
import cn.tst.sbjxzzglxt.viewmodel.BaseViewModel;
import java.util.List;

/**
 *
 * @author Aaron-PC-i3-4130
 */
public class ViewModel extends BaseViewModel {
    private List<LTEquipBasic> equipmentList;
    
    private LTEquipBasic currentEquipment;
    
    private LTEquipGraphic currentGraphic;

    public List<LTEquipBasic> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<LTEquipBasic> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public LTEquipBasic getCurrentEquipment() {
        return currentEquipment;
    }

    public void setCurrentEquipment(LTEquipBasic currentEquipment) {
        this.currentEquipment = currentEquipment;
    }

    public LTEquipGraphic getCurrentGraphic() {
        return currentGraphic;
    }

    public void setCurrentGraphic(LTEquipGraphic currentGraphic) {
        this.currentGraphic = currentGraphic;
    }
}
