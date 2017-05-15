package cn.tst.sbjxzzglxt.viewmodel;

import java.util.Date;
import java.util.List;
import cn.tst.sbjxzzglxt.entity.MstXunJianRole;


/**
 * 违章登记视图模型
 *
 * @author 曹春
 */
public class MST0021ViewModel extends BaseViewModel {

    /**
     * 开始日期
     */
    private Date startDate;

    /**
     * 结束日期
     */
    private Date endDate;
    
    /**
     * 日期范围
     */
    private String riQiFanWei;

    private String yueFen;

    private List<String> yueFenList;
    
    ///编辑中的违章记录
    private MstXunJianRole editingWeiZhang;

    ///车辆违章一览
    private List<MstXunJianRole> weiZhangList;

    ///车辆一览
//    private List<MstCheLiang> cheLiangList;
    
    ///司机一览
//    private List<MstSiJi> siJiList;

    public MST0021ViewModel() {
    }


    public String getYueFen() {
        return yueFen;
    }

    public void setYueFen(String yueFen) {
        this.yueFen = yueFen;
    }

    public List<String> getYueFenList() {
        return yueFenList;
    }

    public void setYueFenList(List<String> yueFenList) {
        this.yueFenList = yueFenList;
    }

  
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRiQiFanWei() {
        return riQiFanWei;
    }

    public void setRiQiFanWei(String riQiFanWei) {
        this.riQiFanWei = riQiFanWei;
    }

    public MstXunJianRole getEditingWeiZhang() {
        return editingWeiZhang;
    }

    public void setEditingWeiZhang(MstXunJianRole editingWeiZhang) {
        this.editingWeiZhang = editingWeiZhang;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List<MstXunJianRole> getWeiZhangList() {
        return weiZhangList;
    }

    public void setWeiZhangList(List<MstXunJianRole> weiZhangList) {
        this.weiZhangList = weiZhangList;
    }

}
