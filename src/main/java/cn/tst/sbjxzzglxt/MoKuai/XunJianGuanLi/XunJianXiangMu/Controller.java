package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXiangMu;

import cn.tst.sbjxzzglxt.common.EquipmentNodeData;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.sbjxzzglxt.common.EquipmentTree;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import cn.tst.sbjxzzglxt.entity.LTEquipCheckPoint;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionItems;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.TreeNode;

/**
 * 巡检项目定义
 *
 * @author ps_xy@pscp.co.jp
 */
@ViewScoped
@Named(SepC.ControllerID.XUN_JIAN_XIANG_MU_CONTROLLER_NAME)
public class Controller extends BusinessBaseController {

    private static final Logger LOG = Logger.getLogger(Controller.class.getName());
    private List<SysRoutingInspectionItems> routingInspectionItemsList;//巡检项目实体类集合
    private SysRoutingInspectionItems routingInspectionItems;//巡检项目实体类
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

        this.bizLogic.loadViewModel(vm);

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
     * 调用common包下的EquipmentTree类中的静态方法，实现Tree功能的重复使用
     *
     * @param equipBasicList 传入设备列表
     * @return 返回设备树
     */
    /**
     * 修改项目
     *
     *
     * @param routingInspectionItems
     */
    public void onEditEquip(SysRoutingInspectionItems routingInspectionItems) {
        vm.setRoutingInspectionItems(routingInspectionItems);
    }

    //xhtml新建监控的事件
    public void onAddTargetData() {
        vm.setRoutingInspectionItems(new SysRoutingInspectionItems());
        vm.getRoutingInspectionItems().setSuoShuSheBeiId(vm.getSelectedEquipBasic().getId());
        vm.setEquipErrorList(vm.getSelectedEquipBasic().getErrorList());
        vm.getSelectedEquipBasic().setItemsList(routingInspectionItemsList);

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
        SepE.ExecuteMode mode = this.vm.getRoutingInspectionItems().getId() == null
                ? SepE.ExecuteMode.INSERT : SepE.ExecuteMode.UPDATE;
        //调用接口中的装备故障方法，把模型和视图（里面实体类）传进去
        ExecuteResult result = this.bizLogic.onXunJianXiangMu(mode, vm);
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
        vm.setRoutingInspectionItems(null);

    }

    /**
     * 删除记录
     *
     * @param routingInspectionItems
     */
    public void onDeleteEquip(SysRoutingInspectionItems routingInspectionItems) {
        ///删除模式
        SepE.ExecuteMode mode = SepE.ExecuteMode.DELETE;
        vm.setRoutingInspectionItems(routingInspectionItems);

        ///执行更新
        ExecuteResult result = this.bizLogic.onXunJianXiangMu(mode, vm);

        if (result.isSuccess()) {
            putInfoMessage("删除成功");
            vm.setRoutingInspectionItems(null);

        } else {
            putErrorMessage("删除失败");
        }
    }

    public void onXiangMuLieBiao(LTEquipCheckPoint row) {
        //选中巡检点，把页面传进来的值放进去
        vm.setSelectedCheckPoint(row);
        //取出来巡检点的ID
        int id = row.getId();
        //取出来设备ID
        Long equipmentId = row.getEquipmentId();
        //调用方法对项目进行初始化
        onAddTargetData();
        //把巡检点ID放入项目中的所属巡检点ID内
        vm.getRoutingInspectionItems().setSuoShuXunJianDianId(id);
        
        List l = new ArrayList();
        //把页面得到的集合便利后放到新创建的集合内
        for (Object list : vm.getSelectedEquipBasic().getCheckPointList()) {
            l.add(list);
        }
        //最后把新集合放到视图内
        vm.setCheckPointList(l);

    }

    public void setSelectError() {
         //采用执行模式，如果我的ID是空的，那么要么创建，要么修改
        SepE.ExecuteMode mode = this.vm.getRoutingInspectionItems().getId() == null
                ? SepE.ExecuteMode.INSERT : SepE.ExecuteMode.UPDATE;
        //调用接口中的装备故障方法，把模型和视图（里面实体类）传进去
        ExecuteResult result = this.bizLogic.onXunJianXiangMu(mode, vm);

        this.addMessage(result.createMessage());
        if (result.isSuccess()) {
            onAddTargetData();
        }
    }

    //*****************************************************************
    //                        Getter Setter
    //*****************************************************************
    public List<SysRoutingInspectionItems> getRoutingInspectionItemsList() {
        return routingInspectionItemsList;
    }

    public void setRoutingInspectionItemsList(List<SysRoutingInspectionItems> routingInspectionItemsList) {
        this.routingInspectionItemsList = routingInspectionItemsList;
    }

    public SysRoutingInspectionItems getRoutingInspectionItems() {
        return routingInspectionItems;
    }

    public void setRoutingInspectionItems(SysRoutingInspectionItems routingInspectionItems) {
        this.routingInspectionItems = routingInspectionItems;
    }

    public ViewModel getVm() {
        return vm;
    }

    public void setVm(ViewModel vm) {
        this.vm = vm;
    }

    public BizLogic getBizLogic() {
        return bizLogic;
    }

    public void setBizLogic(BizLogic bizLogic) {
        this.bizLogic = bizLogic;
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

}
