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
 * 仓库管理
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

        vm.setEquipError(new LTEquipError());
    }

    //*****************************************************************
    //                        公有函数定义
    //*****************************************************************
   
    /**
     * 保存数据
     *
     */
    public void onSaveData() {

        SepE.ExecuteMode mode = this.vm.getEquipError().getId() == null
                ? SepE.ExecuteMode.INSERT : SepE.ExecuteMode.UPDATE;

        ExecuteResult result = this.bizLogic.onSaveEquipError(mode, vm);

        this.addMessage(result.createMessage());

      
    }

    //*****************************************************************
    //                        私有函数定义
    //*****************************************************************
   
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
