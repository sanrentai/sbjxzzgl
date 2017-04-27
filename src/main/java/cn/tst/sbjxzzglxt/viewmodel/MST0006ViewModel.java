package cn.tst.sbjxzzglxt.viewmodel;

import cn.tst.sbjxzzglxt.entity.MstYuanGong;
import org.primefaces.model.LazyDataModel;

/**
 * 系统用户信息ViewModel
 *
 * @author ps_xy@pscp.co.jp
 */
public class MST0006ViewModel extends BaseViewModel {

    ///员工一览
    private LazyDataModel<MstYuanGong> yuanGongList;

    ///编辑中的员工
    private MstYuanGong editingYuanGong;
    
    private String loginId;

    public MST0006ViewModel() {

    }

    public LazyDataModel<MstYuanGong> getYuanGongList() {
        return yuanGongList;
    }

    public void setYuanGongList(LazyDataModel<MstYuanGong> yuanGongList) {
        this.yuanGongList = yuanGongList;
    }

    public MstYuanGong getEditingYuanGong() {
        return editingYuanGong;
    }

    public void setEditingYuanGong(MstYuanGong editingYuanGong) {
        this.editingYuanGong = editingYuanGong;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

}
