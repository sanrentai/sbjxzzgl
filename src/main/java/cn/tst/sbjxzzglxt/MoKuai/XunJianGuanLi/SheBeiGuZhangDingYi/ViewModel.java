package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.SheBeiGuZhangDingYi;

import java.util.List;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipError;
import cn.tst.sbjxzzglxt.entity.LTEquipErrorMessage;
import org.primefaces.model.TreeNode;

/**
 * 仓库管理
 *
 * @author ps_xy@pscp.co.jp
 */
public class ViewModel {
    private List<LTEquipErrorMessage> errorMessageList;//故障名称表实体集合
    
    private LTEquipErrorMessage errorMessage;//故障名称表对象
    
    private List<LTEquipBasic> equipmentList;
    
    private List<LTEquipError> equipErrorList;//故障实体类集合
    
    private LTEquipError errorInEdit;//故障实体类
    
    private LTEquipBasic selectedEquipment;
    
    private TreeNode equipmentTreeRootNode;

    public LTEquipBasic getSelectedEquipment() {
        return selectedEquipment;
    }

    public void setSelectedEquipment(LTEquipBasic selectedEquipment) {
        this.selectedEquipment = selectedEquipment;
    }

    public TreeNode getEquipmentTreeRootNode() {
        return equipmentTreeRootNode;
    }

    public void setEquipmentTreeRootNode(TreeNode equipmentTreeRootNode) {
        this.equipmentTreeRootNode = equipmentTreeRootNode;
    }

    public LTEquipErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(LTEquipErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<LTEquipErrorMessage> getErrorMessageList() {
        return errorMessageList;
    }

    public void setErrorMessageList(List<LTEquipErrorMessage> errorMessageList) {
        this.errorMessageList = errorMessageList;
    }
    
    public LTEquipBasic getSelectedEquipBasic() {
        return selectedEquipment;
    }

    public void setSelectedEquipBasic(LTEquipBasic selectedEquipBasic) {
        this.selectedEquipment = selectedEquipBasic;
    }

    
    public List<LTEquipError> getEquipErrorList() {
        return equipErrorList;
    }

    public void setEquipErrorList(List<LTEquipError> equipErrorList) {
        this.equipErrorList = equipErrorList;
    }

    public LTEquipError getErrorInEdit() {
        return errorInEdit;
    }

    public void setErrorInEdit(LTEquipError errorInEdit) {
        this.errorInEdit = errorInEdit;
    }

    public List<LTEquipBasic> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<LTEquipBasic> equipmentList) {
        this.equipmentList = equipmentList;
    }
}
