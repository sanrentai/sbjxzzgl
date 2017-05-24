package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.SheBeiGuZhangDingYi;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.sbjxzzglxt.common.EquipmentTree;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipError;
import cn.tst.sbjxzzglxt.entity.LTEquipErrorMessage;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import java.util.List;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 * 设备故障定义
 *
 * @author ps_xy@pscp.co.jp
 */
@ViewScoped
@Named(SepC.ControllerID.SHE_BEI_GU_ZHANG_DING_YI_CONTROLLER_NAME)
public class Controller extends BusinessBaseController {

    private List<LTEquipError> equipErrorList;
    private LTEquipError equipError;
    ///视图模型
    private ViewModel vm;
    ///选中的节点
    private TreeNode selectedNode;
    @EJB
    private BizLogic bizLogic;

    @PostConstruct
    public void init() {

        ///初始化视图模型
        this.vm = new ViewModel();

        this.bizLogic.loadEQP0006ViewModel(vm);
        vm.setEquipTreeRoot(EquipmentTree.createEqpTree(vm.getEquipBasicList()));

    }

    //*****************************************************************
    //                        公有函数定义
    //*****************************************************************
    //*****************************************************************
    //                        私有函数定义
    //*****************************************************************
    /**
     * 修改故障提醒的记录
     *
     *
     * @param equip
     */
    public void onEditEquip(LTEquipError equip) {
        vm.setEquipError(equip);
    }

    public void onAddTargetData() {
        vm.setEquipError(new LTEquipError());
        vm.getEquipError().setENum(vm.getSelectedEquipBasic().getId());
    }

    /**
     * 保存数据
     *
     */
    public void onSaveData() {
        //采用执行模式，如果我的ID是空的，那么要么创建，要么修改
        SepE.ExecuteMode mode = this.vm.getEquipError().getId() == null
                ? SepE.ExecuteMode.INSERT : SepE.ExecuteMode.UPDATE;
        //调用接口中的装备故障方法，把模型和视图（里面实体类）传进去
        ExecuteResult result = this.bizLogic.onEquipError(mode, vm);

        this.addMessage(result.createMessage());
        if (result.isSuccess()) {

        }
    }

    /**
     * 删除故障提醒的记录
     *
     * @param equip
     */
    public void onDeleteEquip(LTEquipError equip) {
        ///删除模式
        SepE.ExecuteMode mode = SepE.ExecuteMode.DELETE;
        vm.setEquipError(equip);

        ///执行更新
        ExecuteResult result = this.bizLogic.onEquipError(mode, vm);

        if (result.isSuccess()) {
            putInfoMessage("删除成功");
            vm.setEquipError(null);

        } else {
            putErrorMessage("删除失败");
        }
    }

    /**
     * 选中节点时
     */
    public void onNodeSelect(NodeSelectEvent event) {
        this.selectedNode = event.getTreeNode();
        Long selectedId = ((LTEquipBasic) selectedNode.getData()).getId();
        vm.setSelectedEquipBasic(bizLogic.findSelectedEqp(selectedId));
        onAddTargetData();
    }

    //修改故障名称信息
    public void onErrorMessage(LTEquipErrorMessage errorMessage) {
        vm.setErrorMessage(errorMessage);
    }

    /**
     * 删除故障表的记录
     *
     * @param equipError
     */
    public void onDeleteErrorMessage(LTEquipErrorMessage errorMessage) {
        ///删除模式
        SepE.ExecuteMode mode = SepE.ExecuteMode.DELETE;
        vm.setErrorMessage(errorMessage);

        ///执行更新
        ExecuteResult result = this.bizLogic.onErrorMessage(mode, vm);

        if (result.isSuccess()) {
            putInfoMessage("删除成功");
            vm.setErrorMessage(null);

        } else {
            putErrorMessage("删除失败");
        }
    }

    public void onAddErrorMessage() {
        vm.setErrorMessage(new LTEquipErrorMessage());

    }

    /**
     * 保存数据
     *
     */
    public void onSaveErrorMessage() {
        //初始化实体类的对象

        //当页面调用方法的时候，查看EquipWarn是否为空。
        SepE.ExecuteMode mode = this.vm.getErrorMessage().getId() == null
                //如果为空就执行模型的插入方法，如果非空就修改。
                ? SepE.ExecuteMode.INSERT : SepE.ExecuteMode.UPDATE;
        //本类调用接口实现方法，并把执行后的结果放进result中
        ExecuteResult result = this.bizLogic.onErrorMessage(mode, vm);
        //本类调用添加消息的方法，添加执行结果创建的信息
        Controller.addMessage(result.createMessage());
        if (result.isSuccess()) {
            onCancelEdit();
        }
    }

    /**
     * 編集取消
     */
    public void onCancelEdit() {
        vm.setEquipError(null);
        vm.setErrorMessage(null);

    }

//*****************************************************************
//                        Getter Setter
//*****************************************************************
    public List<LTEquipError> getEquipErrorList() {
        return equipErrorList;
    }

    public void setEquipErrorList(List<LTEquipError> equipErrorList) {
        this.equipErrorList = equipErrorList;
    }

    public LTEquipError getEquipError() {
        return equipError;
    }

    public void setEquipError(LTEquipError equipError) {
        this.equipError = equipError;
    }

    public ViewModel getVm() {
        return vm;
    }

    public void setVm(ViewModel vm) {
        this.vm = vm;
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public BizLogic getBizLogic() {
        return bizLogic;
    }

    public void setBizLogic(BizLogic bizLogic) {
        this.bizLogic = bizLogic;
    }

}
