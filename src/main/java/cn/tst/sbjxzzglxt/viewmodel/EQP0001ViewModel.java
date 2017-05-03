package cn.tst.sbjxzzglxt.viewmodel;

import java.util.List;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipProRule;
import cn.tst.sbjxzzglxt.entity.LTEquipProperty;

/**
 * 仓库管理
 *
 * @author ps_xy@pscp.co.jp
 */
public class EQP0001ViewModel extends BaseViewModel {

    private List<LTEquipProperty> equipPropertyList;
    private List<LTEquipBasic> equipBasicList;
    private LTEquipBasic selectedEquipBasic;
    private LTEquipBasic editingEquipBasic;
    private LTEquipBasic rootEqp;

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

}
