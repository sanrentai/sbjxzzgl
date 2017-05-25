package cn.tst.sbjxzzglxt.controller.equipment;

import cn.tst.sbjxzzglxt.bizlogic.EQP0002BizLogic;
import cn.tst.sbjxzzglxt.common.EquipmentNodeData;
import cn.tst.sbjxzzglxt.common.EquipmentTree;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipFitting;
import cn.tst.sbjxzzglxt.viewmodel.EQP0002ViewModel;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.TreeNode;

/**
 * 装备配件定义
 *
 * @author ps_xy@pscp.co.jp
 */
@ViewScoped
@Named(SepC.ControllerID.EQP0002)
public class EQP0002Controller extends BusinessBaseController {

    ///视图模型
    private EQP0002ViewModel vm;

    ///选中的节点
    private TreeNode selectedNode;

    @EJB
    private EQP0002BizLogic bizLogic;

    @PostConstruct
    public void init() {

        ///初始化视图模型
        this.vm = new EQP0002ViewModel();

        this.bizLogic.loadEQP0002ViewModel(vm);

        //初始化树结构并把设备的值挂在树节点上
        vm.setEquipTreeRoot(EquipmentTree.createEqpTree(vm.getEquipBasicList()));
    }

    //*****************************************************************
    //                        公有函数定义
    //*****************************************************************
    //*****************************************************************
    //                        私有函数定义
    //*****************************************************************
    /**
     * 配件修改
     *
     *
     * @param fitting
     */
    public void onEditEquip(LTEquipFitting fitting) {
        vm.setFitting(fitting);
    }

    //xhtml新建监控的事件
    public void onAddTargetData() {
        vm.setFitting(new LTEquipFitting());
        vm.getFitting().setENum(vm.getSelectedEquipBasic().getId());
    }

    /**
     * 选中节点时
     *
     * @param event
     */
    public void onNodeSelect(NodeSelectEvent event) {
        this.selectedNode = event.getTreeNode();
        Long selectedId = ((EquipmentNodeData) selectedNode.getData()).getEquipment().getId();
        vm.setSelectedEquipBasic(bizLogic.findSelectedEqp(selectedId));
        onAddTargetData();
    }

    /**
     * 保存数据
     *
     */
    public void onSaveData() {
        //采用执行模式，如果我的ID是空的，那么要么创建，要么修改
        SepE.ExecuteMode mode = this.vm.getFitting().getId() == null
                ? SepE.ExecuteMode.INSERT : SepE.ExecuteMode.UPDATE;
        //调用接口中的装备故障方法，把模型和视图（里面实体类）传进去
        ExecuteResult result = this.bizLogic.onSaveEquipFitting(mode, vm);

        this.addMessage(result.createMessage());
        if (result.isSuccess()) {
            onAddTargetData();
        }
    }

    /**
     * 編集取消
     */
    public void onCancelEdit() {

        ///初始化状态
//        this.switchStatus2Init();
        ///无模式
//        this.switchEditMode2None();
        vm.setFitting(null);

    }

    /**
     * 删除记录
     *
     * @param fitting
     */
    public void onDeleteEquip(LTEquipFitting fitting) {
        ///删除模式
        SepE.ExecuteMode mode = SepE.ExecuteMode.DELETE;
        vm.setFitting(fitting);

        ///执行更新
        ExecuteResult result = this.bizLogic.onSaveEquipFitting(mode, vm);

        if (result.isSuccess()) {
            putInfoMessage("删除成功");
            vm.setFitting(null);

        } else {
            putErrorMessage("删除失败");
        }
    }

    //*****************************************************************
    //                        Getter Setter
    //*****************************************************************
    public EQP0002ViewModel getVm() {
        return vm;
    }

    public void setVm(EQP0002ViewModel vm) {
        this.vm = vm;
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

}
