package cn.tst.sbjxzzglxt.viewmodel;

import java.util.List;
import cn.tst.sbjxzzglxt.entity.DatYuangongRole;
import cn.tst.sbjxzzglxt.entity.MstGnShiYongQuanXian;
import cn.tst.sbjxzzglxt.entity.MstYuanGong;
import org.primefaces.model.LazyDataModel;

/**
 * 角色信息管理
 *
 * @author ps_xy@pscp.co.jp
 */
public class MST0007ViewModel extends BaseViewModel {

    ///员工角色一览
    private List<DatYuangongRole> yuanGongRoleList;

    ///员工一览
    private LazyDataModel<MstYuanGong> yuanGongList;

    ///编辑中的员工
    private MstYuanGong editingYuanGong;

    ///角色可用权限
    private List<MstGnShiYongQuanXian> usableQuanXian;

    ///选中的角色
    private DatYuangongRole selectedYuanGongRole;

    public LazyDataModel<MstYuanGong> getYuanGongList() {
        return yuanGongList;
    }

    public void setYuanGongList(LazyDataModel<MstYuanGong> yuanGongList) {
        this.yuanGongList = yuanGongList;
    }

    public List<DatYuangongRole> getYuanGongRoleList() {
        return yuanGongRoleList;
    }

    public void setYuanGongRoleList(List<DatYuangongRole> yuanGongRoleList) {
        this.yuanGongRoleList = yuanGongRoleList;
    }

    public MstYuanGong getEditingYuanGong() {
        return editingYuanGong;
    }

    public void setEditingYuanGong(MstYuanGong editingYuanGong) {
        this.editingYuanGong = editingYuanGong;
    }

    public List<MstGnShiYongQuanXian> getUsableQuanXian() {
        return usableQuanXian;
    }

    public void setUsableQuanXian(List<MstGnShiYongQuanXian> usableQuanXian) {
        this.usableQuanXian = usableQuanXian;
    }

    public DatYuangongRole getSelectedYuanGongRole() {
        return selectedYuanGongRole;
    }

    public void setSelectedYuanGongRole(DatYuangongRole selectedYuanGongRole) {
        this.selectedYuanGongRole = selectedYuanGongRole;
    }
}
