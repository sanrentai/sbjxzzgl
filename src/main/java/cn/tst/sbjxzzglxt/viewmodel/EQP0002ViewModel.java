/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.viewmodel;
import cn.tst.sbjxzzglxt.entity.*;
/**
 *
 * @author Aaron-PC-i3-4130
 */
public class EQP0002ViewModel extends BaseViewModel {
    private LTEquipBasic equipSelected;

    public LTEquipBasic getEquipSelected() {
        return equipSelected;
    }

    public void setEquipSelected(LTEquipBasic equipSelected) {
        this.equipSelected = equipSelected;
    }
    
    private LTEquipFitting equipFittingEdited;

    public LTEquipFitting getEquipFittingEdited() {
        return equipFittingEdited;
    }

    public void setEquipFittingEdited(LTEquipFitting equipFittingEdited) {
        this.equipFittingEdited = equipFittingEdited;
    }
}
