/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.viewmodel;

import java.util.*;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipNotes;

/**
 * 维修保养视图模型
 *
 * @author Aaron-PC-i3-4130
 */
public class EQP0004ViewModel extends BaseViewModel {

    private LTEquipBasic selectedEquipBasic;
    private LTEquipBasic equipBasic;
    private List<LTEquipBasic> equipBasicList;
    private List<LTEquipBasic> equipmentList = new ArrayList();
    private LTEquipNotes equipNotesInEditing;
    private List<LTEquipNotes> equipNoteList;
    private String fuZeRen;
    private Date dangQianBaoYangRiQi;
    private Date xiaCiBaoYangRiQi;
    private Integer tType;
    private Long eNum;
    private LTEquipBasic currentEquipment;

    public void setTType(Integer tType) {
        this.tType = tType;
    }

    public void setENum(Long eNum) {
        this.eNum = eNum;
    }

    public Integer getTType() {
        return tType;
    }

    public Long getENum() {
        return eNum;
    }

    /**
     * 日期范围
     */
    private String riQiFanWei;

    public String getRiQiFanWei() {
        return riQiFanWei;
    }

    public void setRiQiFanWei(String riQiFanWei) {
        this.riQiFanWei = riQiFanWei;
    }

    public Date getDangQianBaoYangRiQi() {
        return dangQianBaoYangRiQi;
    }

    public void setDangQianBaoYangRiQi(Date dangQianBaoYangRiQi) {
        this.dangQianBaoYangRiQi = dangQianBaoYangRiQi;
    }

    public Date getXiaCiBaoYangRiQi() {
        return xiaCiBaoYangRiQi;
    }

    public void setXiaCiBaoYangRiQi(Date xiaCiBaoYangRiQi) {
        this.xiaCiBaoYangRiQi = xiaCiBaoYangRiQi;
    }

    public LTEquipBasic getSelectedEquipBasic() {
        return selectedEquipBasic;
    }

    public void setSelectedEquipBasic(LTEquipBasic selectedEquipBasic) {
        this.selectedEquipBasic = selectedEquipBasic;
    }

    public List<LTEquipBasic> getEquipBasicList() {
        return equipBasicList;
    }

    public void setEquipBasicList(List<LTEquipBasic> equipBasicList) {
        this.equipBasicList = equipBasicList;
    }

    public List<LTEquipNotes> getEquipNoteList() {
        return equipNoteList;
    }

    public LTEquipBasic getEquipBasic() {
        return equipBasic;
    }

    public void setEquipBasic(LTEquipBasic equipBasic) {
        this.equipBasic = equipBasic;
    }

    public void setEquipNoteList(List<LTEquipNotes> equipNoteList) {
        this.equipNoteList = equipNoteList;
    }

    public LTEquipNotes getEquipNotesInEditing() {
        return equipNotesInEditing;
    }

    public void setEquipNotesInEditing(LTEquipNotes equipNotesInEditing) {
        this.equipNotesInEditing = equipNotesInEditing;
    }

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

    public String getFuZeRen() {
        return fuZeRen;
    }

    public void setFuZeRen(String fuZeRen) {
        this.fuZeRen = fuZeRen;
    }

}
