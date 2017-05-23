package cn.tst.sbjxzzglxt.viewmodel;

import java.util.List;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipCheckPoint;
import cn.tst.sbjxzzglxt.entity.LTEquipProRule;
import cn.tst.sbjxzzglxt.entity.LTEquipProperty;
import cn.tst.sbjxzzglxt.entity.MstBuMen;
import cn.tst.sbjxzzglxt.entity.MstYuanGong;
import org.primefaces.model.TreeNode;

/**
 * 仓库管理
 *
 * @author ps_xy@pscp.co.jp
 */
public class EQP0001ViewModel extends BaseViewModel {
    private List<LTEquipCheckPoint> selectCheckpointList;
    private LTEquipCheckPoint selectCheckpoint;
    private List<LTEquipProperty> equipPropertyList;
    private List<LTEquipBasic> equipBasicList;
    private List<LTEquipBasic> selectEquipBasicList;
    private LTEquipBasic selectedEquipBasic;
    private LTEquipBasic editingEquipBasic;
    private LTEquipBasic rootEqp;
    private List<MstYuanGong> yuanGongList;
    private List<MstBuMen> buMenList;

    private LTEquipProRule editingEquipProRule;
    ///新建参数
    private LTEquipProperty editingEquipProperty;

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

    public LTEquipBasic getEditingEquipBasic() {
        return editingEquipBasic;
    }

    public void setEditingEquipBasic(LTEquipBasic editingEquipBasic) {
        this.editingEquipBasic = editingEquipBasic;
    }

    public LTEquipBasic getRootEqp() {
        return rootEqp;
    }

    public void setRootEqp(LTEquipBasic rootEqp) {
        this.rootEqp = rootEqp;
    }

    public LTEquipProRule getEditingEquipProRule() {
        return editingEquipProRule;
    }

    public void setEditingEquipProRule(LTEquipProRule editingEquipProRule) {
        this.editingEquipProRule = editingEquipProRule;
    }

    public LTEquipProperty getEditingEquipProperty() {
        return editingEquipProperty;
    }

    public void setEditingEquipProperty(LTEquipProperty editingEquipProperty) {
        this.editingEquipProperty = editingEquipProperty;
    }

    public List<LTEquipProperty> getEquipPropertyList() {
        return equipPropertyList;
    }

    public void setEquipPropertyList(List<LTEquipProperty> equipPropertyList) {
        this.equipPropertyList = equipPropertyList;
    }

    public List<MstYuanGong> getYuanGongList() {
        return yuanGongList;
    }

    public void setYuanGongList(List<MstYuanGong> yuanGongList) {
        this.yuanGongList = yuanGongList;
    }

    public List<MstBuMen> getBuMenList() {
        return buMenList;
    }

    public void setBuMenList(List<MstBuMen> buMenList) {
        this.buMenList = buMenList;
    }

    public List<LTEquipBasic> getSelectEquipBasicList() {
        return selectEquipBasicList;
    }

    public void setSelectEquipBasicList(List<LTEquipBasic> selectEquipBasicList) {
        this.selectEquipBasicList = selectEquipBasicList;
    }

    public List<LTEquipCheckPoint> getSelectCheckpointList() {
        return selectCheckpointList;
    }

    public void setSelectCheckpointList(List<LTEquipCheckPoint> selectCheckpointList) {
        this.selectCheckpointList = selectCheckpointList;
    }

    public LTEquipCheckPoint getSelectCheckpoint() {
        return selectCheckpoint;
    }

    public void setSelectCheckpoint(LTEquipCheckPoint selectCheckpoint) {
        this.selectCheckpoint = selectCheckpoint;
    }

}
