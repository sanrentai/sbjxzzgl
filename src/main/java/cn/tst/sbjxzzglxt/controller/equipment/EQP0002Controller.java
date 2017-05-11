package cn.tst.sbjxzzglxt.controller.equipment;

import cn.tst.sbjxzzglxt.bizlogic.EQP0002BizLogic;
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
import cn.tst.sbjxzzglxt.entity.LTEquipFitting;
import cn.tst.sbjxzzglxt.entity.LTEquipWarn;
import cn.tst.sbjxzzglxt.viewmodel.EQP0002ViewModel;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.EQP0006ViewModel;
import java.util.List;
import java.util.Set;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 * 装备配件定义
 *
 * @author ps_xy@pscp.co.jp
 */
@ViewScoped
@Named(SepC.ControllerID.EQP0002)
public class EQP0002Controller extends BusinessBaseController {

    private List<LTEquipFitting> fittingList;//配件实体类集合
    private LTEquipFitting fitting;//配件实体类
    ///视图模型
    private EQP0002ViewModel vm;

    @EJB
    private EQP0002BizLogic bizLogic;

    @PostConstruct
    public void init() {

        ///初始化视图模型
        this.vm = new EQP0002ViewModel();

        this.bizLogic.loadEQP0002ViewModel(vm);

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
     * @param Fitting
     */
    public void onEditEquip(LTEquipFitting fitting) {
        vm.setFitting(fitting);
    }
    //xhtml新建监控的事件
    public void onAddTargetData() {
        vm.setFitting(new LTEquipFitting());
     
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
        ExecuteResult result = this.bizLogic.onEquipFitting(mode, vm);

        this.addMessage(result.createMessage());
        
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
     * @param fitting
     */
    public void onDeleteEquip(LTEquipFitting fitting) {
        ///删除模式
        SepE.ExecuteMode mode = SepE.ExecuteMode.DELETE;
        vm.setFitting(fitting);

        ///执行更新
        ExecuteResult result = this.bizLogic.onEquipFitting(mode, vm);

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

    public List<LTEquipFitting> getFittingList() {
        return fittingList;
    }

    public void setFittingList(List<LTEquipFitting> fittingList) {
        this.fittingList = fittingList;
    }

    public LTEquipFitting getFitting() {
        return fitting;
    }

    public void setFitting(LTEquipFitting fitting) {
        this.fitting = fitting;
    }

    public EQP0002ViewModel getVm() {
        return vm;
    }

    public void setVm(EQP0002ViewModel vm) {
        this.vm = vm;
    }
   
}
