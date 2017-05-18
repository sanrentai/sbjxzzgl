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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
        //创建一个根节点
        DefaultTreeNode result = new DefaultTreeNode("Root", null);
        //通过循环遍历，把设备集合中的数据放到默认的Tree节点上
        equipBasicList.forEach((item) -> {
            TreeNode subNode = new DefaultTreeNode(item, result);
            subNode.setExpanded(false);
            //创建下一层Tree节点
            createRelationTree(subNode, item);
        });
        return result;
    }

    /**
     * 创建下一层节点
     *
     *
     *
     */
    private static void createRelationTree(TreeNode node, LTEquipBasic data) {
        ctreatRelationTree(node, data, false);
    }

    /**
     * 创建下一层节点
     *
     *
     *
     */
    private static void ctreatRelationTree(TreeNode node, LTEquipBasic data, boolean isNeedExpand) {
        //去当前所有节点的子节点,为了表面节点的重复，所以采用set进行存储
        Set<LTEquipBasic> children = data.getChildren();
        //判断当是否存在子节点
        if (children != null && children.isEmpty()) {
            //遍历所有子节点
            children.forEach(c -> {
                //当前节点ID
                String cid = c.getId().toString();
                //判断刚得到的当前ID是不是根节点，如果不是根节点，就创建子节点
                if (!SepC.EQP_ROOT.equals(cid)) {
                    //创建子节点
                    TreeNode subNode = new DefaultTreeNode(c, node);
                    //需要扩展
                    subNode.setExpanded(isNeedExpand);
                    //递归子节点展现
                    ctreatRelationTree(subNode, c, isNeedExpand);

                }
            });

        }
    }

    /**
     * 选中节点时
     */
    public void onNodeSelect(NodeSelectEvent event) {
        //传进来选择的节点
        this.selectedNode = event.getTreeNode();
        //拿到选中节点的值存到
        vm.setEquipBasic((LTEquipBasic) selectedNode.getData());
        //下面是把值放到一个List集合中，通过循环把子节点遍历出来
        vm.setSelectEquipBasicList(new ArrayList());
        vm.getSelectEquipBasicList().add(vm.getEquipBasic());
        for (LTEquipBasic item : vm.getEquipBasic().getChildren()) {
            vm.getSelectEquipBasicList().add(item);
        }
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
        vm.setRoutingInspectionItems(new SysRoutingInspectionItems());
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
            onCancelEdit();
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
