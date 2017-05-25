/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.LuRuXunJianJieGuo;

import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipCheckPoint;
import java.util.List;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Aaron-PC-i3-4130
 */
public class ViewModel {
    private TreeNode equipmentTreeRoot;
    
    private List<LTEquipBasic> equipmentList;
    
    private List<LTEquipCheckPoint> currentCheckPointList;
    
    private LTEquipBasic currentEquipment;
    
    private LTEquipCheckPoint currentCheckPoint;

    public List<LTEquipCheckPoint> getCurrentCheckPointList() {
        return currentCheckPointList;
    }

    public void setCurrentCheckPointList(List<LTEquipCheckPoint> currentCheckPointList) {
        this.currentCheckPointList = currentCheckPointList;
    }

    public LTEquipCheckPoint getCurrentCheckPoint() {
        return currentCheckPoint;
    }

    public void setCurrentCheckPoint(LTEquipCheckPoint currentCheckPoint) {
        this.currentCheckPoint = currentCheckPoint;
    }

    public List<LTEquipBasic> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<LTEquipBasic> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public TreeNode getEquipmentTreeRoot() {
        return equipmentTreeRoot;
    }

    public void setEquipmentTreeRoot(TreeNode equipmentTreeRoot) {
        this.equipmentTreeRoot = equipmentTreeRoot;
    }

    public LTEquipBasic getCurrentEquipment() {
        return currentEquipment;
    }

    public void setCurrentEquipment(LTEquipBasic currentEquipment) {
        this.currentEquipment = currentEquipment;
    }
}
