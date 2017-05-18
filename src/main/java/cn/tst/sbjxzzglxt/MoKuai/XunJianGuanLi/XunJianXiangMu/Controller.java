package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXiangMu;

import cn.tst.sbjxzzglxt.controller.equipment.*;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.sbjxzzglxt.bizlogic.EQP0006BizLogic;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import static cn.tst.sbjxzzglxt.controller.equipment.EQP0001Controller.createEqpTree;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipError;
import cn.tst.sbjxzzglxt.entity.LTEquipWarn;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionItems;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.EQP0006ViewModel;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
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
        vm.setEquipTreeRoot(createEqpTree(vm.getEquipBasicList()));

    }

    //*****************************************************************
    //                        公有函数定义
    //*****************************************************************
    //*****************************************************************
    //                        私有函数定义
    //*****************************************************************
    /**
     * 创建仓库树
     *
     * @param equipBasicList 传入设备列表
     * @return 返回设备树
     */
    static public DefaultTreeNode createEqpTree(List<LTEquipBasic> equipBasicList) {
        ///根节点
        DefaultTreeNode result = new DefaultTreeNode("Root", null);
        for (LTEquipBasic item : equipBasicList) {
            TreeNode subNode = new DefaultTreeNode(item, result);
            subNode.setExpanded(false);
            createRelationTree(subNode, item);
        }
        return result;
    }

    /**
     * 创建下一层节点
     *
     *
     *
     */
    static private void createRelationTree(TreeNode node, LTEquipBasic data) {
        createRelationTree(node, data, false);
    }

    /**
     * 创建下一层节点
     *
     *
     *
     */
    static private void createRelationTree(TreeNode node, LTEquipBasic data, boolean isNeedExpand) {

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
                    ///递归展
                    createRelationTree(subNode, c, isNeedExpand);

                }
            });
        }
    }

    /**
     * 选中节点时
     */
    public void onNodeSelect(NodeSelectEvent event) {

        this.selectedNode = event.getTreeNode();

        vm.setEquipBasic((LTEquipBasic) selectedNode.getData());

        LOG.info(vm.getEquipBasic().getENmae());

        LOG.info(vm.getEquipBasic().getEquipErrorList().size());
        vm.setSelectEquipBasicList(new ArrayList());
        vm.getSelectEquipBasicList().add(vm.getEquipBasic());
        for (LTEquipBasic item : vm.getEquipBasic().getChildren()) {
            vm.getSelectEquipBasicList().add(item);
        }
        //选中节点的时候开始初始化新建表里面的信息
        vm.setRoutingInspectionItems(new SysRoutingInspectionItems());
    }
//    /**
//     * 用于设备名称选择的监听
//     *
//     * 
//     * @param items
//     */

    public void onListnener(LTEquipBasic equipBasic) {
        vm.setEquipBasic(equipBasic);
    }

    /**
     * 修改巡检项目记录
     *
     *
     */
    public void onEditEquip(SysRoutingInspectionItems routingInspectionItems) {
        vm.setRoutingInspectionItems(routingInspectionItems);
    }

    //在新建的时候会监听
    public void onAddTargetData() {

    }

    /**
     * 保存数据
     *
     */
    public void onSaveData() {
        //采用执行模式，如果我的ID是空的，那么要么创建，要么修改
        LOG.info(1);
        SepE.ExecuteMode mode = this.vm.getRoutingInspectionItems().getId() == null
                ? SepE.ExecuteMode.INSERT : SepE.ExecuteMode.UPDATE;
        //调用接口中的装备故障方法，把模型和视图（里面实体类）传进去
        ExecuteResult result = this.bizLogic.onXunJianXiangMu(mode, vm);
        LOG.info(vm.getRoutingInspectionItems().getId());
        this.addMessage(result.createMessage());
        if (result.isSuccess()) {
            onCancelEdit();
        }
    }

    /**
     * 編集取消
     */
    public void onCancelEdit() {

        selectedNode = null;
        vm.setEquipTreeRoot(createEqpTree(vm.getEquipBasicList()));
        vm.setRoutingInspectionItems(null);

    }

    /**
     * 取消树选择
     */
    public void onCancelShuXuanZhe() {
        vm.setEquipBasic(null);
        selectedNode = null;
    }

    /**
     * 删除故障提醒的记录
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

    /**
     * 弹窗数据存到视图中
     *
     * @param selectequipError
     * @return
     */
    public List<LTEquipError> setSelectEquipBasic(LTEquipError selectequipError) {
        //创建一个新的集合，用于存放每次存放进来的数据
        ArrayList list = new ArrayList();
        //判断故障是否选中
        if (!selectequipError.isSelected()) {
            //如果是选中状态就添加到集合内
            list.add(selectequipError);
        }
        return list;//返回给yemian
    }

    public void onXuanZe(SysRoutingInspectionItems routingInspectionItems){
        int a = routingInspectionItems.getXunJianFangShi();
        switch(a){
            case 0:
	    break;
	    case 1:
	    break;
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
