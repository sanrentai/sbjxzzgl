package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.SheBeiGuZhangDingYi;

import java.util.List;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipError;
import cn.tst.sbjxzzglxt.entity.LTEquipErrorMessage;
import cn.tst.sbjxzzglxt.viewmodel.BaseViewModel;
import org.primefaces.model.TreeNode;

/**
 * 仓库管理
 *
 * @author ps_xy@pscp.co.jp
 */
public class ViewModel extends BaseViewModel {
    private List<LTEquipErrorMessage> errorMessageList;//故障名称表实体集合
    private LTEquipErrorMessage errorMessage;//故障名称表对象
    private List<LTEquipBasic> equipBasicList;
    private List<LTEquipError> equipErrorList;//故障实体类集合
    private LTEquipError equipError;//故障实体类
    private LTEquipBasic selectedEquipBasic;
    private LTEquipBasic editingEquipBasic;

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

   

    
    public LTEquipBasic getEditingEquipBasic() {
        return editingEquipBasic;
    }

    public void setEditingEquipBasic(LTEquipBasic editingEquipBasic) {
        this.editingEquipBasic = editingEquipBasic;
    }
    
    
    
    public LTEquipBasic getSelectedEquipBasic() {
        return selectedEquipBasic;
    }

    public void setSelectedEquipBasic(LTEquipBasic selectedEquipBasic) {
        this.selectedEquipBasic = selectedEquipBasic;
    }

    
    public List<LTEquipError> getEquipErrorList() {
        return equipErrorList;
    }

    public void setEquipErrorList(List<LTEquipError> equipErrorList) {
        this.equipErrorList = equipErrorList;
    }

    public LTEquipError getEquipError() {
        return equipError;
    }

    public void setEquipError(LTEquipError equipError) {
        this.equipError = equipError;
    }

    public List<LTEquipBasic> getEquipBasicList() {
        return equipBasicList;
    }

    public void setEquipBasicList(List<LTEquipBasic> equipBasicList) {
        this.equipBasicList = equipBasicList;
    }

}
