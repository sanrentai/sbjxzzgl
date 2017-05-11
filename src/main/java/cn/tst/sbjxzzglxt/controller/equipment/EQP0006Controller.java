package cn.tst.sbjxzzglxt.controller.equipment;

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
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.EQP0006ViewModel;
import java.util.List;
import java.util.Set;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 * 设备故障定义
 *
 * @author ps_xy@pscp.co.jp
 */
@ViewScoped
@Named(SepC.ControllerID.EQP0006)
public class EQP0006Controller extends BusinessBaseController {

    private List<LTEquipError> equipErrorList;
    private LTEquipError equipError;
    ///视图模型
    private EQP0006ViewModel vm;

    @EJB
    private EQP0006BizLogic bizLogic;

    @PostConstruct
    public void init() {

        ///初始化视图模型
        this.vm = new EQP0006ViewModel();

        this.bizLogic.loadEQP0006ViewModel(vm);

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
     * @param equipError
     */
    public void onEditEquip(LTEquipError equipError) {
        vm.setEquipError(equipError);
    }

    public void onAddTargetData() {
        vm.setEquipError(new LTEquipError());
        vm.getEquipError().setDiJiGuZhang(SepE.Whether.YES);
//        vm.getEquipError().setEquip(vm.getEquipError().getEquip());
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
        
    }
    
      /**
     * 編集取消
     */
    public void onCancelEdit() {

        ///初始化状态
//        this.switchStatus2Init();
        ///无模式
//        this.switchEditMode2None();
        vm.setEquipError(null);

    }

    /**
     * 删除故障提醒的记录
     */
    public void onDeleteEquip(LTEquipError row) {
        ///删除模式
        SepE.ExecuteMode mode = SepE.ExecuteMode.DELETE;
        vm.setEquipError(row);

        ///执行更新
        ExecuteResult result = this.bizLogic.onEquipError(mode, vm);

        if (result.isSuccess()) {
            putInfoMessage("删除成功");
            vm.setEquipError(null);
            
        } else {
            putErrorMessage("删除失败");
        }
    }

    //*****************************************************************
    //                        Getter Setter
    //*****************************************************************
    public EQP0006ViewModel getVm() {
        return vm;
    }

    public void setVm(EQP0006ViewModel vm) {
        this.vm = vm;
    }

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
}
