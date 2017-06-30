package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.SheBeiGuZhangDingYi;

import cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.LuRuRen.*;
import cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXiangMuGuanLi.*;
import cn.tst.sbjxzzglxt.common.EquipmentNodeData;
import cn.tst.sbjxzzglxt.common.EquipmentTree;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import cn.tst.sbjxzzglxt.entity.LTEquipCheckPoint;
import cn.tst.sbjxzzglxt.entity.LTEquipError;
import cn.tst.sbjxzzglxt.entity.LTEquipErrorMessage;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionItems;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.TreeNode;

@ViewScoped
@Named(SepC.ControllerID.SHE_BEI_GU_ZHANG_DING_YI_CONTROLLER_NAME)
public class Controller extends BusinessBaseController {
    private static final Logger LOG = Logger.getLogger(Controller.class.getName());
    private ViewModel vm;
    ///选中的节点
    private TreeNode selectedNode;
    @EJB
    private BizLogic bizLogic;

    @PostConstruct
    public void init() {
        this.vm = new ViewModel();
        this.bizLogic.loadViewModel(vm);
        //初始化树结构并把设备的值挂在树节点上
        vm.setEquipTreeRoot(EquipmentTree.createEqpTree(vm.getEquipBasicList()));
    }

    /**
     * 选中节点时
     *
     * @param event
     */
    public void onNodeSelect(NodeSelectEvent event) {
        //选择的设备节点
        this.selectedNode = event.getTreeNode();
        //得到设备信息
        Long eNum = ((EquipmentNodeData) selectedNode.getData()).getEquipment().getId();
        LOG.info(eNum);
        vm.setSelectedEquipBasic(bizLogic.findSelectedEqp(eNum));
        LOG.info((bizLogic.findSelectedEqp(eNum)));
        //得到巡检点信息表
        vm.setEquipErrorList((bizLogic.chaGuZhangXinXi(vm, eNum)));
    }

    /**
     * 修改故障信息
     *
     *
     * @param error
     */
    public void xiuGai(LTEquipError error) {
        vm.setEquipError(error);
    }

    /**
     * 删除故障记录
     *
     *
     * @param error
     */
    public void shanChuGuZhangJiLu(LTEquipError error) {
        ///删除模式
        SepE.ExecuteMode mode = SepE.ExecuteMode.DELETE;
        vm.setEquipError(error);
      

        ///执行更新
        ExecuteResult result = this.bizLogic.onEquipError(mode, vm);

        if (result.isSuccess()) {
            putInfoMessage("删除成功");
            vm.setEquipError(null);
            vm.setEquipErrorList((bizLogic.chaGuZhangXinXi(vm, error.getId())));
        } else {
            putErrorMessage("删除失败");
        }
    }
    
    /**
     * 删除故障信息
     *
     *
     * @param errorMessage
     * @param error
     */
    public void shanChuGuZhangXinXi(LTEquipErrorMessage errorMessage) {
        ///删除模式
        SepE.ExecuteMode mode = SepE.ExecuteMode.DELETE;
        vm.setErrorMessage(errorMessage);
        ///执行更新
        ExecuteResult result = this.bizLogic.onErrorMessage(mode, vm);
        if (result.isSuccess()) {
            putInfoMessage("删除成功");
             vm.setErrorMessageList(vm.getErrorMessageList());
            vm.setErrorMessage(null);
        } else {
            putErrorMessage("删除失败");
        }
    }


    //保存故障记录
    public void onEquipError(){
        vm.getEquipError().setENum(vm.getSelectedEquipBasic().getId());
       //采用执行模式，如果我的ID是空的，那么要么创建，要么修改
        SepE.ExecuteMode mode = this.vm.getEquipError().getId() == null
                ? SepE.ExecuteMode.INSERT : SepE.ExecuteMode.UPDATE;
        //调用接口中的装备故障方法，把模型和视图（里面实体类）传进去
        ExecuteResult result = this.bizLogic.onEquipError(mode, vm);

        this.addMessage(result.createMessage());
        if (result.isSuccess()) {
         vm.setEquipErrorList(vm.getEquipErrorList());
         vm.setEquipError(null);
        }
    }
    //保存故障信息
    public void onErrorMessage(){
    //采用执行模式，如果我的ID是空的，那么要么创建，要么修改
        SepE.ExecuteMode mode = this.vm.getErrorMessage().getId() == null
                ? SepE.ExecuteMode.INSERT : SepE.ExecuteMode.UPDATE;
        //调用接口中的装备故障方法，把模型和视图（里面实体类）传进去
        ExecuteResult result = this.bizLogic.onErrorMessage(mode, vm);
        this.addMessage(result.createMessage());
        if (result.isSuccess()) {
         vm.setErrorMessageList(vm.getErrorMessageList());
         vm.setErrorMessage(null);
        }
    }
    

    //取消巡检项目
    public void onCancelEdit() {
        vm.setEquipError(null);
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

}
