package cn.tst.sbjxzzglxt.controller.equipment;

import cn.tst.sbjxzzglxt.bizlogic.EQP0005BizLogic;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import static cn.tst.sbjxzzglxt.controller.equipment.EQP0001Controller.createEqpTree;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
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

    }

    //*****************************************************************
    //                        公有函数定义
    //*****************************************************************
    /**
     *
     *
     *
     * }
     *
     * /**
     * 編集取消
     */
    public void onStartNodeEditing() {

        if (date == null) {
            return;
        } else {
        }

        this.switchStatus2Editing();

    }

    //*****************************************************************
    //                        私有函数定义
    //*****************************************************************
    /**
     * 修改故障提醒的记录
     *
     * @param equipwarn
     */
    public void onEditEquip(LTEquipWarn equipwarn) {
        vm.setEquipWarn(equipwarn);
    }

    /**
     * 删除故障提醒的记录
     */
    public void onDeleteEquip(LTEquipWarn row) {
        ///删除模式
        SepE.ExecuteMode mode = SepE.ExecuteMode.DELETE;
        vm.setEquipWarn(row);

        ///执行更新
        ExecuteResult result = this.bizLogic.onEquipWarn(mode, vm);

        if (result.isSuccess()) {
            putInfoMessage("删除成功");
            vm.setEquipWarn(null);

        } else {
            putErrorMessage("删除失败");
        }
    }

    /**
     * 删除节点
     *
     * @param type
     */
    public void onDeleteNode(String type) {

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
     * 保存数据
     *
     */
    public void onSaveData() {
        //初始化实体类的对象

        //当页面调用方法的时候，查看EquipWarn是否为空。
        SepE.ExecuteMode mode = this.vm.getEquipWarn().getId() == null
                //如果为空就执行模型的插入方法，如果非空就修改。
                ? SepE.ExecuteMode.INSERT : SepE.ExecuteMode.UPDATE;
        //本类调用接口实现方法，并把执行后的结果放进result中
        ExecuteResult result = this.bizLogic.onEquipWarn(mode, vm);
        //本类调用添加消息的方法，添加执行结果创建的信息
        this.addMessage(result.createMessage());
         if (result.isSuccess()) {
            onCancelEdit();
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

    public void onAddTargetData() {
        vm.setEquipWarn(new LTEquipWarn());
        vm.getEquipWarn().setTTyoe(SepE.ReminderTime.YEAR);
        vm.getEquipWarn().setXhYn(SepE.Whether.NO);
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
}
