package cn.tst.sbjxzzglxt.viewmodel;

import java.util.List;
import cn.tst.sbjxzzglxt.entity.MstBuMen;
import cn.tst.sbjxzzglxt.entity.MstZhiNeng;


/**
 * 物资基本ViewModel
 *
 * @author ps_xy@pscp.co.jp
 */
public class MST0013ViewModel extends BaseViewModel {

    private MstBuMen editingBuMen;
    
    private List<MstBuMen> buMenList;
    
    private MstZhiNeng editingZhiNeng;

    private List<MstZhiNeng> zhiNengList;
    
    public MST0013ViewModel() {

    }

    public MstBuMen getEditingBuMen() {
        return editingBuMen;
    }

    public void setEditingBuMen(MstBuMen editingBuMen) {
        this.editingBuMen = editingBuMen;
    }

    public List<MstBuMen> getBuMenList() {
        return buMenList;
    }

    public void setBuMenList(List<MstBuMen> buMenList) {
        this.buMenList = buMenList;
    }

    public MstZhiNeng getEditingZhiNeng() {
        return editingZhiNeng;
    }

    public void setEditingZhiNeng(MstZhiNeng editingZhiNeng) {
        this.editingZhiNeng = editingZhiNeng;
    }

    public List<MstZhiNeng> getZhiNengList() {
        return zhiNengList;
    }

    public void setZhiNengList(List<MstZhiNeng> zhiNengList) {
        this.zhiNengList = zhiNengList;
    }
}
