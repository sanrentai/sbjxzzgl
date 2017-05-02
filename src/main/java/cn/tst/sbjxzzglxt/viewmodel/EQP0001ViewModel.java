package cn.tst.sbjxzzglxt.viewmodel;

import java.util.List;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import org.primefaces.model.TreeNode;

/**
 * 仓库管理
 *
 * @author ps_xy@pscp.co.jp
 */
public class EQP0001ViewModel extends BaseViewModel {

    private List<LTEquipBasic> equipBasicList;
    private LTEquipBasic selectedEquipBasic;
    private LTEquipBasic editingEquipBasic;
    private LTEquipBasic rootEqp;
    
    private TreeNode equipTreeRoot;

    public TreeNode getEquipTreeRoot() {
        return equipTreeRoot;
    }

    public void setEquipTreeRoot(TreeNode equipTreeRoot) {
        this.equipTreeRoot = equipTreeRoot;
    }

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

}
