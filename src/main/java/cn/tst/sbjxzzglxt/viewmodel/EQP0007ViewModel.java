/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.viewmodel;

import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipGraphic;
import java.util.List;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Aaron-PC-i3-4130
 */
public class EQP0007ViewModel extends BaseViewModel {
    private LTEquipGraphic equipGraphicEntityInEdit;
    
    private List<LTEquipBasic> equipmentList;
    
    private LTEquipBasic currentEquipment;
    
    private List<LTEquipGraphic> selectEquipGraphicList;
    
    private String fileName;

    public LTEquipGraphic getEquipGraphicEntityInEdit() {
        return equipGraphicEntityInEdit;
    }

    public void setEquipGraphicEntityInEdit(LTEquipGraphic equipGraphicEntityInEdit) {
        this.equipGraphicEntityInEdit = equipGraphicEntityInEdit;
    }

    public List<LTEquipBasic> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<LTEquipBasic> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public List<LTEquipGraphic> getSelectEquipGraphicList() {
        return selectEquipGraphicList;
    }

    public void setSelectEquipGraphicList(List<LTEquipGraphic> selectEquipGraphicList) {
        this.selectEquipGraphicList = selectEquipGraphicList;
    }

    public LTEquipBasic getCurrentEquipment() {
        return currentEquipment;
    }

    public void setCurrentEquipment(LTEquipBasic currentEquipment) {
        this.currentEquipment = currentEquipment;
        equipGraphicEntityInEdit.setENum(currentEquipment.getENum());
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
