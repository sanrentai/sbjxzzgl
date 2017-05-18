package cn.tst.sbjxzzglxt.viewmodel;

import org.primefaces.model.TreeNode;

/**
 * ViewModel 基础类
 *
 * @author 曹春
 */
public abstract class BaseViewModel {

    private TreeNode equipTreeRoot;

    public TreeNode getEquipTreeRoot() {
        return equipTreeRoot;
    }

    public void setEquipTreeRoot(TreeNode equipTreeRoot) {
        this.equipTreeRoot = equipTreeRoot;
    }

}
