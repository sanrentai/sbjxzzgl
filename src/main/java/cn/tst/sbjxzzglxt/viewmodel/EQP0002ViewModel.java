package cn.tst.sbjxzzglxt.viewmodel;

import java.util.List;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipError;
import cn.tst.sbjxzzglxt.entity.LTEquipFitting;
import org.primefaces.model.TreeNode;

/**
 * 装备配件视图
 *
 * @author ps_xy@pscp.co.jp
 */
public class EQP0002ViewModel extends BaseViewModel {

    private List<LTEquipBasic> equipBasicList;
   private List<LTEquipFitting> fittingList;//配件实体类集合
    private LTEquipFitting fitting;//配件实体类

    public List<LTEquipFitting> getFittingList() {
        return fittingList;
    }

    public void setFittingList(List<LTEquipFitting> fittingList) {
        this.fittingList = fittingList;
    }

    public LTEquipFitting getFitting() {
        return fitting;
    }

    public void setFitting(LTEquipFitting fitting) {
        this.fitting = fitting;
    }

    public List<LTEquipBasic> getEquipBasicList() {
        return equipBasicList;
    }

    public void setEquipBasicList(List<LTEquipBasic> equipBasicList) {
        this.equipBasicList = equipBasicList;
    }

   


}
