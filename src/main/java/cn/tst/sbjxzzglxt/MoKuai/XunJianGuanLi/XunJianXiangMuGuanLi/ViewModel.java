package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXiangMuGuanLi;

import cn.tst.sbjxzzglxt.entity.LTEquipCheckPoint;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionItems;
import java.util.List;
import org.primefaces.model.TreeNode;

public class ViewModel {
    private TreeNode equipmentTreeRootNode;
    
    private LTEquipCheckPoint selectedCheckPoint;
    
    private List<SysRoutingInspectionItems> itemList;
    
    private SysRoutingInspectionItems itemInEdit;

    public SysRoutingInspectionItems getItemInEdit() {
        return itemInEdit;
    }

    public void setItemInEdit(SysRoutingInspectionItems itemInEdit) {
        this.itemInEdit = itemInEdit;
    }

    public List<SysRoutingInspectionItems> getItemList() {
        return itemList;
    }

    public void setItemList(List<SysRoutingInspectionItems> itemList) {
        this.itemList = itemList;
    }

    public LTEquipCheckPoint getSelectedCheckPoint() {
        return selectedCheckPoint;
    }

    public void setSelectedCheckPoint(LTEquipCheckPoint selectedCheckPoint) {
        this.selectedCheckPoint = selectedCheckPoint;
    }

    public TreeNode getEquipmentTreeRootNode() {
        return equipmentTreeRootNode;
    }

    public void setEquipmentTreeRootNode(TreeNode equipmentTreeRootNode) {
        this.equipmentTreeRootNode = equipmentTreeRootNode;
    }
}
