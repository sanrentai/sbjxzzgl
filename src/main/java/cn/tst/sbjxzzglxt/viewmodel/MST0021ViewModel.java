package cn.tst.sbjxzzglxt.viewmodel;

import cn.tst.sbjxzzglxt.entity.DatXunJianFanWei;
import cn.tst.sbjxzzglxt.entity.DatXunJianGuiZe;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import java.util.Date;
import java.util.List;
import cn.tst.sbjxzzglxt.entity.MstXunJianRole;


/**
 * 违章登记视图模型
 *
 * @author 曹春
 */
public class MST0021ViewModel extends BaseViewModel {

    
    ///编辑中的违章记录
    private MstXunJianRole editingXunJianRole;
    
    private DatXunJianFanWei editingXunJianFanWei;
    
    private DatXunJianGuiZe editingXunJianGuiZe;
   
    private List<LTEquipBasic> sheBeiList;
    
    ///车辆违章一览
    private List<MstXunJianRole> xunJianRoleList;

    ///车辆一览
//    private List<MstCheLiang> cheLiangList;
    
    ///司机一览
//    private List<MstSiJi> siJiList;

    public MST0021ViewModel() {
    }

    public MstXunJianRole getEditingXunJianRole() {
        return editingXunJianRole;
    }

    public void setEditingXunJianRole(MstXunJianRole editingXunJianRole) {
        this.editingXunJianRole = editingXunJianRole;
    }

    public List<MstXunJianRole> getXunJianRoleList() {
        return xunJianRoleList;
    }

    public void setXunJianRoleList(List<MstXunJianRole> xunJianRoleList) {
        this.xunJianRoleList = xunJianRoleList;
    }

    public DatXunJianFanWei getEditingXunJianFanWei() {
        return editingXunJianFanWei;
    }

    public void setEditingXunJianFanWei(DatXunJianFanWei editingXunJianFanWei) {
        this.editingXunJianFanWei = editingXunJianFanWei;
    }

    public DatXunJianGuiZe getEditingXunJianGuiZe() {
        return editingXunJianGuiZe;
    }

    public void setEditingXunJianGuiZe(DatXunJianGuiZe editingXunJianGuiZe) {
        this.editingXunJianGuiZe = editingXunJianGuiZe;
    }

    public List<LTEquipBasic> getSheBeiList() {
        return sheBeiList;
    }

    public void setSheBeiList(List<LTEquipBasic> sheBeiList) {
        this.sheBeiList = sheBeiList;
    }


}
