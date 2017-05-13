package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXiangMuWenTi;

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
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionProblem;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.EQP0006ViewModel;
import java.util.List;
import java.util.Set;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 * 巡检故障定义
 *
 * @author ps_xy@pscp.co.jp
 */
@ViewScoped
@Named(SepC.ControllerID.XUN_JIAN_XIANG_MU_WEN_TI_CONTROLLER_NAME)
public class Controller extends BusinessBaseController {
    
    private List<SysRoutingInspectionProblem> ProblemList;
    private SysRoutingInspectionProblem Problem;
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
     * 修改巡检故障的记录
     *
     * 
     *
     * @param Problem
     */
    public void onEditEquip(SysRoutingInspectionProblem Problem) {
        vm.setRoutingInspectionProblem(Problem);
    }
    //XHTML监听用于修改显示
    public void onAddTargetData() {
        vm.setRoutingInspectionProblem(new SysRoutingInspectionProblem());
     
    }

    /**
     * 保存数据
     *
     */
    public void onSaveData() {
        //采用执行模式，如果我的ID是空的，那么要么创建，要么修改
        SepE.ExecuteMode mode = this.vm.getRoutingInspectionProblem().getId() == null
                ? SepE.ExecuteMode.INSERT : SepE.ExecuteMode.UPDATE;
        //调用接口中的装备故障方法，把模型和视图（里面实体类）传进去
        ExecuteResult result = this.bizLogic.onXiangMuWenTi(mode, vm);

        Controller.addMessage(result.createMessage());
         if (result.isSuccess()) {
            onCancelEdit();
        }
    }
    
      /**
     * 編集取消
     */
    public void onCancelEdit() {
        vm.setRoutingInspectionProblem(null);

    }

    /**
     * 删除故障提醒的记录
     * @param Problem
     */
    public void onDeleteEquip(SysRoutingInspectionProblem Problem) {
        ///删除模式
        SepE.ExecuteMode mode = SepE.ExecuteMode.DELETE;
        vm.setRoutingInspectionProblem(Problem);

        ///执行更新
        ExecuteResult result = this.bizLogic.onXiangMuWenTi(mode, vm);

        if (result.isSuccess()) {
            putInfoMessage("删除成功");
            vm.setRoutingInspectionProblem(null);
           
        } else {
            putErrorMessage("删除失败");
        }
    }

    //*****************************************************************
    //                        Getter Setter
    //*****************************************************************

    public List<SysRoutingInspectionProblem> getProblemList() {
        return ProblemList;
    }

    public void setProblemList(List<SysRoutingInspectionProblem> ProblemList) {
        this.ProblemList = ProblemList;
    }

    public SysRoutingInspectionProblem getProblem() {
        return Problem;
    }

    public void setProblem(SysRoutingInspectionProblem Problem) {
        this.Problem = Problem;
    }

    public ViewModel getVm() {
        return vm;
    }

    public void setVm(ViewModel vm) {
        this.vm = vm;
    }
   
}
