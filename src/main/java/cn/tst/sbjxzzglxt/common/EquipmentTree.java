/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.common;

import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import java.util.List;
import java.util.Set;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Aaron-PC-i3-4130
 */
public class EquipmentTree {
    static public DefaultTreeNode createEqpTree(List<LTEquipBasic> equipBasicList) {
        ///根节点
        DefaultTreeNode result = new DefaultTreeNode("Root", null);
        for (LTEquipBasic item : equipBasicList) {
            TreeNode subNode = new DefaultTreeNode(item, result);
            subNode.setExpanded(false);
            createRelationTree(subNode, item);
        }
        return result;
    }

    /**
     * 创建下一层节点
     *
     * @param node 品类关系节点
     * @param data 节点数据
     */
    static private void createRelationTree(TreeNode node, LTEquipBasic data) {
        createRelationTree(node, data, false);
    }
    
    /**
     * 创建下一层节点
     *
     * @param node 品类关系节点
     * @param data 节点数据
     * @param isNeedExpand 节点是否展开
     */
    static private void createRelationTree(TreeNode node, LTEquipBasic data, boolean isNeedExpand) {

        ///取得当前节点的所有子节点
        Set<LTEquipBasic> children = data.getChildren();
        
        ///如果存在子节点
        if (children != null && !children.isEmpty()) {
            ///遍历所有子节点
            children.forEach(c -> {

                ///当前节点ID
                String currentNodeId = c.getId().toString();
                
                ///如果不是根节点,怎创建子节点
                if (!SepC.EQP_ROOT.equals(currentNodeId)) {
                    TreeNode subNode = new DefaultTreeNode(c, node);
                    subNode.setExpanded(isNeedExpand);

//                    if (c.getPinLei().isLeibie()) {
//                        /// 设置假的子节点表示用于表示该节点下有品类
//                        long count = bizLogic.getChildrenCount(c);
//                        if (count != 0) {
//                            TreeNode tmpNode = new DefaultTreeNode(null, subNode);
//                            tmpNode.setExpanded(false);
//                        }
//                    }
                    ///递归展
                    createRelationTree(subNode, c, isNeedExpand);

                }
            });
        }
    }
}
