/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianJueSeGuanLi;

import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.MstXunJianRole;
import cn.tst.sbjxzzglxt.entity.XunJianGuiZe;
import java.util.List;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Aaron-PC-i3-4130
 */
public class ViewModel {
    private List<MstXunJianRole> roleList;
    
    private MstXunJianRole roleInEdit;
    
    private MstXunJianRole currentRole;

    public MstXunJianRole getCurrentRole() {
        return currentRole;
    }

    public void setCurrentRole(MstXunJianRole currentRole) {
        this.currentRole = currentRole;
    }
    
    private XunJianGuiZe xunJianGuiZeInEdit;
    
    private TreeNode equipmentNodeRoot;
    
    private TreeNode[] selectedEquipmentNodeArray;

    public TreeNode[] getSelectedEquipmentNodeArray() {
        return selectedEquipmentNodeArray;
    }

    public void setSelectedEquipmentNodeArray(TreeNode[] selectedEquipmentNodeArray) {
        this.selectedEquipmentNodeArray = selectedEquipmentNodeArray;
    }

    public TreeNode getEquipmentNodeRoot() {
        return equipmentNodeRoot;
    }

    public void setEquipmentNodeRoot(TreeNode equipmentNodeRoot) {
        this.equipmentNodeRoot = equipmentNodeRoot;
    }

    public XunJianGuiZe getXunJianGuiZeInEdit() {
        return xunJianGuiZeInEdit;
    }

    public void setXunJianGuiZeInEdit(XunJianGuiZe xunJianGuiZeInEdit) {
        this.xunJianGuiZeInEdit = xunJianGuiZeInEdit;
    }

    public MstXunJianRole getRoleInEdit() {
        return roleInEdit;
    }

    public void setRoleInEdit(MstXunJianRole roleInEdit) {
        this.roleInEdit = roleInEdit;
    }

    public List<MstXunJianRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<MstXunJianRole> roleList) {
        this.roleList = roleList;
    }
    
    public SepE.XunJianXunHuanFangShi[] getXunJianXunHuanFangShi() {
        return SepE.XunJianXunHuanFangShi.values();
    }
}
