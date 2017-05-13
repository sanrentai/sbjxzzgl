package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXinXiJiLu;

import cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXiangMuWenTi.*;
import cn.tst.sbjxzzglxt.controller.equipment.*;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.sbjxzzglxt.bizlogic.EQP0006BizLogic;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipError;
import cn.tst.sbjxzzglxt.entity.LTEquipWarn;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionMessage;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionProblem;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.EQP0006ViewModel;
import java.util.List;
import java.util.Set;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 * 巡检信息记录
 *
 * @author ps_xy@pscp.co.jp
 */
@ViewScoped
@Named(SepC.ControllerID.XUN_JIAN_XIN_XI_JI_LU_CONTROLLER_NAME)
public class Controller extends BusinessBaseController {
    
   private List<SysRoutingInspectionMessage> routingInspectionMessageList;//巡检记录实体类集合
    private SysRoutingInspectionMessage routingInspectionMessage;//巡检记录实体类
    ///视图模型
    private ViewModel vm;
    
    @EJB
    private BizLogic bizLogic;
  
    @PostConstruct
    public void init() {

        ///初始化视图模型
        this.vm = new ViewModel();

        this.bizLogic.loadViewModel(vm);

    }

    //*****************************************************************
    //                        公有函数定义
    //*****************************************************************
    //*****************************************************************
    //                        私有函数定义
    //*****************************************************************
    /**
     * 修改巡检信息记录
     *
     * 
     *
     * @param message
     */
    public void onEditEquip(SysRoutingInspectionMessage message) {
        vm.setRoutingInspectionMessage(message);
    }
    //XHTML监听用于修改显示
    public void onAddTargetData() {
        vm.setRoutingInspectionMessage(new SysRoutingInspectionMessage());
     
    }

    /**
     * 保存数据
     *
     */
    public void onSaveData() {
        //采用执行模式，如果我的ID是空的，那么要么创建，要么修改
        SepE.ExecuteMode mode = this.vm.getRoutingInspectionMessage().getId() == null
                ? SepE.ExecuteMode.INSERT : SepE.ExecuteMode.UPDATE;
        //调用接口中的装备故障方法，把模型和视图（里面实体类）传进去
        ExecuteResult result = this.bizLogic.onXunJianJiLu(mode, vm);

        Controller.addMessage(result.createMessage());
         if (result.isSuccess()) {
            onCancelEdit();
        }
    }
    
      /**
     * 編集取消
     */
    public void onCancelEdit() {
        vm.setRoutingInspectionMessage(null);

    }

    /**
     * 删除故障提醒的记录
     * @param message
     */
    public void onDeleteEquip(SysRoutingInspectionMessage message) {
        ///删除模式
        SepE.ExecuteMode mode = SepE.ExecuteMode.DELETE;
        vm.setRoutingInspectionMessage(message);

        ///执行更新
        ExecuteResult result = this.bizLogic.onXunJianJiLu(mode, vm);

        if (result.isSuccess()) {
            putInfoMessage("删除成功");
            vm.setRoutingInspectionMessage(null);
           
        } else {
            putErrorMessage("删除失败");
        }
    }

    //*****************************************************************
    //                        Getter Setter
    //*****************************************************************

    public List<SysRoutingInspectionMessage> getRoutingInspectionMessageList() {
        return routingInspectionMessageList;
    }

    public void setRoutingInspectionMessageList(List<SysRoutingInspectionMessage> routingInspectionMessageList) {
        this.routingInspectionMessageList = routingInspectionMessageList;
    }

    public SysRoutingInspectionMessage getRoutingInspectionMessage() {
        return routingInspectionMessage;
    }

    public void setRoutingInspectionMessage(SysRoutingInspectionMessage routingInspectionMessage) {
        this.routingInspectionMessage = routingInspectionMessage;
    }

    public cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXinXiJiLu.ViewModel getVm() {
        return vm;
    }

    public void setVm(cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXinXiJiLu.ViewModel vm) {
        this.vm = vm;
    }

    public cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXinXiJiLu.BizLogic getBizLogic() {
        return bizLogic;
    }

    public void setBizLogic(cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXinXiJiLu.BizLogic bizLogic) {
        this.bizLogic = bizLogic;
    }

  
  

}
