/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.SheBeiGuanLi.WenDangJiTuPianGuanLi;

import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipGraphic;
import java.util.List;
import org.primefaces.model.TreeNode;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Aaron-PC-i3-4130
 */
public class ViewModel {
    private LTEquipGraphic equipmentDocumentInEdit;
    
    private List<LTEquipBasic> equipmentList;
    
    private LTEquipBasic currentEquipment;
    
    private List<LTEquipGraphic> selectedEquipmentDocumentList;
    
    private UploadedFile currentUploadedFile;
    
    private TreeNode equipmentTreeRoot;
    
    private TreeNode selectedEquipmentNode;

    public UploadedFile getCurrentUploadedFile() {
        return currentUploadedFile;
    }

    public void setCurrentUploadedFile(UploadedFile currentUploadedFile) {
        this.currentUploadedFile = currentUploadedFile;
    }

    public List<LTEquipGraphic> getSelectedEquipmentDocumentList() {
        return selectedEquipmentDocumentList;
    }

    public void setSelectedEquipmentDocumentList(List<LTEquipGraphic> selectedEquipmentDocumentList) {
        this.selectedEquipmentDocumentList = selectedEquipmentDocumentList;
    }

    public TreeNode getSelectedEquipmentNode() {
        return selectedEquipmentNode;
    }

    public void setSelectedEquipmentNode(TreeNode selectedEquipmentNode) {
        this.selectedEquipmentNode = selectedEquipmentNode;
    }

    public TreeNode getEquipmentTreeRoot() {
        return equipmentTreeRoot;
    }

    public void setEquipmentTreeRoot(TreeNode equipmentTreeRoot) {
        this.equipmentTreeRoot = equipmentTreeRoot;
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

    public LTEquipGraphic getEquipmentDocumentInEdit() {
        return equipmentDocumentInEdit;
    }

    public void setEquipmentDocumentInEdit(LTEquipGraphic equipmentDocumentInEdit) {
        this.equipmentDocumentInEdit = equipmentDocumentInEdit;
    }
}
