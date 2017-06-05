package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXiangMuGuanLi;

import cn.tst.sbjxzzglxt.common.EquipmentNodeData;
import cn.tst.sbjxzzglxt.common.EquipmentTree;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.TreeNode;

@ViewScoped
@Named(SepC.ControllerID.XUN_JIAN_XIANG_MU_GUAN_LI_CONTROLLER_NAME)
public class Controller extends BusinessBaseController {
    private ViewModel vm;

    @EJB
    private BizLogic bizLogic;

    @PostConstruct
    public void init() {
        this.vm = new ViewModel();
        this.bizLogic.loadViewModel(vm);
    }

    public ViewModel getVm() {
        return vm;
    }

    public void setVm(ViewModel vm) {
        this.vm = vm;
    }
    
    public void onNodeSelect(NodeSelectEvent event) {
        bizLogic.onNodeSelect(vm, event);
    }
    
    public void onAddNewItem() {
        bizLogic.onAddNewItem(vm);
    }
    
    public void onXunJianFangShiChange() {
        bizLogic.onXunJianFangShiChange(vm);
    }
}
