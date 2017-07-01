package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.SheBeiGuZhangDingYi;

import cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.LuRuRen.*;
import cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXiangMuGuanLi.*;
import cn.tst.sbjxzzglxt.entity.GuZhangShiLi;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipCheckPoint;
import cn.tst.sbjxzzglxt.entity.LTEquipError;
import cn.tst.sbjxzzglxt.entity.LTEquipErrorMessage;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionItems;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionMessage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.primefaces.model.TreeNode;

public class ViewModel {
    
    private List<LTEquipBasic> equipBasicList;

    private LTEquipBasic selectedEquipBasic;
    
    private LTEquipBasic equipBasic;

    private TreeNode equipTreeRoot;//tree节点

    private LTEquipCheckPoint selectedCheckPoint;

    private List<LTEquipCheckPoint> selectedCheckPointList;

    private List<SysRoutingInspectionItems> itemList;

    private SysRoutingInspectionItems itemInEdit;
    
    private SysRoutingInspectionItems examine;
    
    private LTEquipError equipError;
    
    private List<LTEquipError> equipErrorList;
    
    private LTEquipErrorMessage errorMessage;
    
    private List<LTEquipErrorMessage> errorMessageList;

    private String guZhangMingCheng;

    public String getGuZhangMingCheng() {
        return guZhangMingCheng;
    }

    public void setGuZhangMingCheng(String guZhangMingCheng) {
        this.guZhangMingCheng = guZhangMingCheng;
    }

   
    
    
    
    public List<LTEquipBasic> getEquipBasicList() {
        return equipBasicList;
    }

    public void setEquipBasicList(List<LTEquipBasic> equipBasicList) {
        this.equipBasicList = equipBasicList;
    }

    public LTEquipBasic getSelectedEquipBasic() {
        return selectedEquipBasic;
    }

    public void setSelectedEquipBasic(LTEquipBasic selectedEquipBasic) {
        this.selectedEquipBasic = selectedEquipBasic;
    }

    public LTEquipBasic getEquipBasic() {
        return equipBasic;
    }

    public void setEquipBasic(LTEquipBasic equipBasic) {
        this.equipBasic = equipBasic;
    }

    public TreeNode getEquipTreeRoot() {
        return equipTreeRoot;
    }

    public void setEquipTreeRoot(TreeNode equipTreeRoot) {
        this.equipTreeRoot = equipTreeRoot;
    }

    public LTEquipCheckPoint getSelectedCheckPoint() {
        return selectedCheckPoint;
    }

    public void setSelectedCheckPoint(LTEquipCheckPoint selectedCheckPoint) {
        this.selectedCheckPoint = selectedCheckPoint;
    }

    public List<LTEquipCheckPoint> getSelectedCheckPointList() {
        return selectedCheckPointList;
    }

    public void setSelectedCheckPointList(List<LTEquipCheckPoint> selectedCheckPointList) {
        this.selectedCheckPointList = selectedCheckPointList;
    }

    public List<SysRoutingInspectionItems> getItemList() {
        return itemList;
    }

    public void setItemList(List<SysRoutingInspectionItems> itemList) {
        this.itemList = itemList;
    }

    public SysRoutingInspectionItems getItemInEdit() {
        return itemInEdit;
    }

    public void setItemInEdit(SysRoutingInspectionItems itemInEdit) {
        this.itemInEdit = itemInEdit;
    }

    public SysRoutingInspectionItems getExamine() {
        return examine;
    }

    public void setExamine(SysRoutingInspectionItems examine) {
        this.examine = examine;
    }

    public List<LTEquipErrorMessage> getErrorMessageList() {
        return errorMessageList;
    }

    public void setErrorMessageList(List<LTEquipErrorMessage> errorMessageList) {
        this.errorMessageList = errorMessageList;
    }

    public LTEquipError getEquipError() {
        return equipError;
    }

    public void setEquipError(LTEquipError equipError) {
        this.equipError = equipError;
    }

    public List<LTEquipError> getEquipErrorList() {
        return equipErrorList;
    }

    public void setEquipErrorList(List<LTEquipError> equipErrorList) {
        this.equipErrorList = equipErrorList;
    }

    public LTEquipErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(LTEquipErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }
    

}
