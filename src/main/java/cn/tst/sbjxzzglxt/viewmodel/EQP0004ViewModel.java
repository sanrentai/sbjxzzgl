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
 * @author Aaron-PC-i3-4130
 */
public class EQP0004ViewModel extends BaseViewModel {

    private LTEquipBasic selectedEquipBasic;
    private LTEquipBasic equipBasic;
    private List<LTEquipBasic> equipBasicList;
    private List<LTEquipBasic> equipmentList = new ArrayList();

    private LTEquipNotes equipNotesInEditing;

    private List<LTEquipNotes> equipNoteList;

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
}
