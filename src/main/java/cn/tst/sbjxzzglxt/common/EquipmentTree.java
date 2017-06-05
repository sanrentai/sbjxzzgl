/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.common;

import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipCheckPoint;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Aaron-PC-i3-4130
 */
public class EquipmentTree {
    static public final String CHECK_POINT_TYPE = "checkPoint";
    
    static public TreeNode createEqpTree(List<LTEquipBasic> equipmentList) {
        TreeNode rootNode = new DefaultTreeNode(new EquipmentNodeData("Root", null), null);
        for(LTEquipBasic equipment: equipmentList) {
            if(equipment.getParent() == null)
                createNode(rootNode, equipment);
        }
        return rootNode;
    }
    
    private static void createNode(TreeNode parentNode, LTEquipBasic data) {
        TreeNode result = new DefaultTreeNode(new EquipmentNodeData(data.getENmae(), data), parentNode);
        if(data.getChildren() != null) {
            for(LTEquipBasic equipment: data.getChildren()) {
                createNode(result, equipment);
            }
        }
    }
    
    public static TreeNode createEquipmentTreeNodeWithCheckPoint(List<LTEquipBasic> equipmentList, Integer roleId) {
        TreeNode rootNode = new DefaultTreeNode(new EquipmentNodeData("设备检查点", roleId, SepC.INVALID_ID), null);
        for(LTEquipBasic equipment: equipmentList) {
            if(equipment.getParent() == null)
                createNode(rootNode, equipment, roleId);
        }
        return rootNode;
    }
    
    private static void createNode(TreeNode parentNode, LTEquipBasic data, Integer roleId) {
        TreeNode result = new DefaultTreeNode(new EquipmentNodeData(data.getENmae(), roleId, SepC.INVALID_ID), parentNode);
        for(LTEquipCheckPoint checkPoint: data.getCheckPointList()) {
            createCheckPointNode(result, checkPoint, roleId);
        }
        if(data.getChildren() != null) {
            for(LTEquipBasic equipment: data.getChildren()) {
                createNode(result, equipment, roleId);
            }
        }
    }
    
    private static void createCheckPointNode(TreeNode parentNode, LTEquipCheckPoint data, Integer roleId) {
        TreeNode result = new DefaultTreeNode("checkPoint", new EquipmentNodeData(data.getName(), roleId, data.getId()), parentNode);
    }
}
