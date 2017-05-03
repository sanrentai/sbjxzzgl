package cn.tst.sbjxzzglxt.controller.equipment;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.sbjxzzglxt.bizlogic.EQP0001BizLogic;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipProRule;
import cn.tst.sbjxzzglxt.entity.LTEquipProperty;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.EQP0001ViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 * 仓库管理
 *
 * @author ps_xy@pscp.co.jp
 */
@ViewScoped
@Named(SepC.ControllerID.EQP0001)
public class EQP0001Controller extends BusinessBaseController {

    private final String T_ROOT = "T_ROOT";

    ///设备Tree
    private TreeNode equipTree;

    ///选中的节点
    private TreeNode selectedNode;

    ///视图模型
    private EQP0001ViewModel vm;

    @EJB
    private EQP0001BizLogic bizLogic;

    @PostConstruct
    public void init() {

        ///初始化视图模型
        this.vm = new EQP0001ViewModel();

        this.bizLogic.loadEQP0001ViewModel(vm);

        ///初始化设备树
        this.createEqpTree();
    }

    //*****************************************************************
    //                        公有函数定义
    //*****************************************************************
    /**
     * 选中节点时
     */
    public void onNodeSelect(NodeSelectEvent event) {

        this.selectedNode = event.getTreeNode();

        vm.setSelectedEquipBasic((LTEquipBasic) selectedNode.getData());

        ///是否为邮件菜单点击事件
//        this.onStartNodeEditing();
    }

    /**
     * 菜单右击选中
     *
     * @param type
     */
    public void onStartNodeEditing() {

        if (selectedNode == null) {
            return;
        }

        this.switchStatus2Editing();

    }

    /**
     * 删除节点
     *
     * @param type
     */
    public void onDeleteNode(String type) {

    }

    public void onAddTargetData() {
        vm.setEditingEquipBasic(new LTEquipBasic());
        if (selectedNode == null) {
            vm.getEditingEquipBasic().setcId(new Long(SepC.EQP_ROOT));
        } else {
//            LTEquipBasic l = (LTEquipBasic) selectedNode.getData();
//            vm.getEditingEquipBasic().setcId(l.getId());
            vm.getEditingEquipBasic().setcId(vm.getSelectedEquipBasic().getId());
        }
    }

    public void onAddPorperty() {
        vm.setEditingEquipProperty(new LTEquipProperty());
    }

    /**
     * 編集取消
     */
    public void onCancelEdit() {

        ///初始化状态
//        this.switchStatus2Init();
        ///无模式
//        this.switchEditMode2None();
        vm.setEditingEquipBasic(null);
        selectedNode = null;
        createEqpTree();
    }

    /**
     * 保存数据
     *
     * @param type 更新对象
     */
    public void onSaveData() {

        SepE.ExecuteMode mode = this.vm.getEditingEquipBasic().getId() == null
                ? SepE.ExecuteMode.INSERT : SepE.ExecuteMode.UPDATE;

        ExecuteResult result = this.bizLogic.onSaveEquipment(mode, vm);

        this.addMessage(result.createMessage());

        if (result.isSuccess()) {
            onCancelEdit();
        }
    }

    public void onSaveProperty() {

        SepE.ExecuteMode mode = this.vm.getEditingEquipProperty().getId() == null
                ? SepE.ExecuteMode.INSERT : SepE.ExecuteMode.UPDATE;

        ExecuteResult result = this.bizLogic.onSaveProperty(mode, vm);

        this.addMessage(result.createMessage());

        if (result.isSuccess()) {
            vm.setEditingEquipProperty(null);
        }
    }

    public void changeCanShuSelection(LTEquipProperty item) {
        LTEquipBasic selectedEquipBasic = vm.getSelectedEquipBasic();
        if (selectedEquipBasic.getEquipProRuleList() == null) {
            selectedEquipBasic.setEquipProRuleList(new ArrayList<>());
        } else {
            
            LTEquipProRule newProRule = new LTEquipProRule();
            newProRule.setENum(vm.getSelectedEquipBasic().getENum());
            newProRule.setPId(item.getId());
            newProRule.setEquipProperty(item);
            selectedEquipBasic.getEquipProRuleList().add(newProRule);
        }
    }

    public void onDeleteCanShu(LTEquipProRule row) {
        vm.getSelectedEquipBasic().getEquipProRuleList().remove(row);
    }

    //*****************************************************************
    //                        私有函数定义
    //*****************************************************************
    /**
     * 创建仓库树
     */
    private void createEqpTree() {

        ///根节点
        equipTree = new DefaultTreeNode("Root", null);
        for (LTEquipBasic item : vm.getEquipBasicList()) {
            TreeNode subNode = new DefaultTreeNode(item, equipTree);
            subNode.setExpanded(false);
            this.createRelationTree(subNode, item);
        }

    }

    /**
     * 创建下一层节点
     *
     * @param node 品类关系节点
     * @param data 节点数据
     */
    private void createRelationTree(TreeNode node, LTEquipBasic data) {
        this.createRelationTree(node, data, false);
    }

    /**
     * 创建下一层节点
     *
     * @param node 品类关系节点
     * @param data 节点数据
     * @param isNeedExpand 节点是否展开
     */
    private void createRelationTree(TreeNode node, LTEquipBasic data, boolean isNeedExpand) {

        ///取得当前节点的所有子节点
        Set<LTEquipBasic> children = data.getChildren();

        ///如果存在子节点
        if (children != null && !children.isEmpty()) {
            ///遍历所有子节点
            children.forEach(c -> {

                ///当前节点ID
                String currentNodeId = c.getId().toString();

                ///如果不是根节点,怎创建子节点
                if (!SepC.EQP_ROOT.equals(currentNodeId)) {
                    TreeNode subNode = new DefaultTreeNode(c, node);
                    subNode.setExpanded(isNeedExpand);

//                    if (c.getPinLei().isLeibie()) {
//                        /// 设置假的子节点表示用于表示该节点下有品类
//                        long count = bizLogic.getChildrenCount(c);
//                        if (count != 0) {
//                            TreeNode tmpNode = new DefaultTreeNode(null, subNode);
//                            tmpNode.setExpanded(false);
//                        }
//                    }
                    ///递归展
                    this.createRelationTree(subNode, c, isNeedExpand);

                }
            });
        }
    }
    //*****************************************************************
    //                        Getter Setter
    //*****************************************************************

    public EQP0001ViewModel getVm() {
        return vm;
    }

    public void setVm(EQP0001ViewModel vm) {
        this.vm = vm;
    }

    public TreeNode getEquipTree() {
        return equipTree;
    }

    public void setEquipTree(TreeNode equipTree) {
        this.equipTree = equipTree;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

}
