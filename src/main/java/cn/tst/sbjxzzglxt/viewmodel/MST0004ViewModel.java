package cn.tst.sbjxzzglxt.viewmodel;

import java.util.List;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.DatYuanGongSuoShu;
import cn.tst.sbjxzzglxt.entity.DatYuanGongSuoShuPK;
import cn.tst.sbjxzzglxt.entity.MstBuMen;
import cn.tst.sbjxzzglxt.entity.MstYuanGong;
import cn.tst.sbjxzzglxt.entity.MstZhiNeng;
import org.primefaces.model.LazyDataModel;

/**
 * 实体物资信息ViewModel
 *
 * @author ps_xy@pscp.co.jp
 */
public class MST0004ViewModel extends BaseViewModel {

    ///编辑中的员工
    private MstYuanGong editingYuanGong;

    ///编辑中的员工所属关系
    private DatYuanGongSuoShu editingSuoShu;

    ///部门
    private List<MstBuMen> buMenList;

    ///职能
    private List<MstZhiNeng> zhiNengList;

    ///员工所属历史
    private List<DatYuanGongSuoShu> suoShuList;

    ///员工一览
    private LazyDataModel<MstYuanGong> yuanGongList;

    public MST0004ViewModel() {
        this.initYuanGong();
    }

    public final void initYuanGong() {
        this.editingYuanGong = new MstYuanGong();
        ///设置性别为男
        this.editingYuanGong.setXingBie(SepE.Sex.MALE.getValue());

    }

    public final void initSuoShu(String yuanGongId) {
        ///初始化所属关系
        this.editingSuoShu = new DatYuanGongSuoShu(new DatYuanGongSuoShuPK(yuanGongId, null, null));
        this.editingSuoShu.setZaiZhiZt(SepE.Flag.YES.getValue());
    }

    public MstYuanGong getEditingYuanGong() {
        return editingYuanGong;
    }

    public void setEditingYuanGong(MstYuanGong editingYuanGong) {
        this.editingYuanGong = editingYuanGong;
    }

    public LazyDataModel<MstYuanGong> getYuanGongList() {
        return yuanGongList;
    }

    public void setYuanGongList(LazyDataModel<MstYuanGong> yuanGongList) {
        this.yuanGongList = yuanGongList;
    }

    public List<MstBuMen> getBuMenList() {
        return buMenList;
    }

    public void setBuMenList(List<MstBuMen> buMenList) {
        this.buMenList = buMenList;
    }

    public List<MstZhiNeng> getZhiNengList() {
        return zhiNengList;
    }

    public void setZhiNengList(List<MstZhiNeng> zhiNengList) {
        this.zhiNengList = zhiNengList;
    }

    public List<DatYuanGongSuoShu> getSuoShuList() {
        return suoShuList;
    }

    public void setSuoShuList(List<DatYuanGongSuoShu> suoShuList) {
        this.suoShuList = suoShuList;
    }

    public DatYuanGongSuoShu getEditingSuoShu() {
        return editingSuoShu;
    }

    public void setEditingSuoShu(DatYuanGongSuoShu editingSuoShu) {
        this.editingSuoShu = editingSuoShu;
    }
}
