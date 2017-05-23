package cn.tst.sbjxzzglxt.controller.equipment;

import cn.tst.sbjxzzglxt.bizlogic.EQP0005BizLogic;
import cn.tst.sbjxzzglxt.common.EquipmentTree;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import static cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.SheBeiGuZhangDingYi.Controller.createEqpTree;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipFitting;
import cn.tst.sbjxzzglxt.entity.LTEquipWarn;
import cn.tst.sbjxzzglxt.viewmodel.EQP0005ViewModel;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 * 设备提醒管理
 *
 * @author ps_xy@pscp.co.jp
 */
@ViewScoped
@Named(SepC.ControllerID.EQP0005)
public class EQP0005Controller extends BusinessBaseController {

    private LTEquipWarn equipWarn;
    private Date date;
    ///选中的节点
    private TreeNode selectedNode;
    ///视图模型
    private EQP0005ViewModel vm;

    @EJB
    private EQP0005BizLogic bizLogic;

    /**
     *
     */
    @PostConstruct
    public void init() {

        ///初始化视图模型
        this.vm = new EQP0005ViewModel();

        this.bizLogic.loadEQP0005ViewModel(vm);
        vm.setEquipTreeRoot(createEqpTree(vm.getEquipBasicList()));

    }

    //*****************************************************************
    //                        公有函数定义
    //*****************************************************************
    /**
     * 配件修改
     *
     *
     * @param equipWarnList
     */
    public void onEditEquip(LTEquipWarn equipWarnList) {
        vm.setEquipWarn(equipWarnList);
    }

    //xhtml新建监控的事件
    public void onAddTargetData() {
        vm.setEquipWarn(new LTEquipWarn());
        vm.getEquipWarn().setTTyoe(SepE.ReminderTime.YEAR);
        vm.getEquipWarn().setXhYn(SepE.Whether.YES);
        vm.getEquipWarn().setEId(vm.getSelectedEquipBasic().getId());
    }

    /**
     * 选中节点时
     *
     * @param event
     */
    public void onNodeSelect(NodeSelectEvent event) {
        this.selectedNode = event.getTreeNode();
        Long selectedId = ((LTEquipBasic) selectedNode.getData()).getId();
        vm.setSelectedEquipBasic(bizLogic.findSelectedEqp(selectedId));
        onAddTargetData();
    }

    /**
     * 保存数据
     *
     */
    public void onSaveData() {
        //采用执行模式，如果我的ID是空的，那么要么创建，要么修改
        SepE.ExecuteMode mode = this.vm.getEquipWarn().getId() == null
                ? SepE.ExecuteMode.INSERT : SepE.ExecuteMode.UPDATE;
        //调用接口中的装备故障方法，把模型和视图（里面实体类）传进去
        ExecuteResult result = this.bizLogic.onEquipWarn(mode, vm);

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
        vm.setEquipWarn(null);

    }

    /**
     * 删除记录
     *
     * @param equipWarnList
     */
    public void onDeleteEquip(LTEquipWarn equipWarnList) {
        ///删除模式
        SepE.ExecuteMode mode = SepE.ExecuteMode.DELETE;
        vm.setEquipWarn(equipWarnList);

        ///执行更新
        ExecuteResult result = this.bizLogic.onEquipWarn(mode, vm);

        if (result.isSuccess()) {
            putInfoMessage("删除成功");
            vm.setEquipWarn(null);

        } else {
            putErrorMessage("删除失败");
        }
    }

    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }

    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();

        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }

    //*****************************************************************
    //                        Getter Setter
    //*****************************************************************
    public LTEquipWarn getEquipWarn() {
        return equipWarn;
    }

    public void setEquipWarn(LTEquipWarn equipWarn) {
        this.equipWarn = equipWarn;
    }

    public EQP0005ViewModel getVm() {
        return vm;
    }

    public void setVm(EQP0005ViewModel vm) {
        this.vm = vm;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public EQP0005BizLogic getBizLogic() {
        return bizLogic;
    }

    public void setBizLogic(EQP0005BizLogic bizLogic) {
        this.bizLogic = bizLogic;
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

}
