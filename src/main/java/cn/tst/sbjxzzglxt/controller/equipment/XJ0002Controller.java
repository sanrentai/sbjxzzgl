package cn.tst.sbjxzzglxt.controller.equipment;

import cn.tst.sbjxzzglxt.bizlogic.EQP0005BizLogic;
import cn.tst.sbjxzzglxt.bizlogic.XJ0002BizLogic;
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
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionItems;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionMessage;
import cn.tst.sbjxzzglxt.viewmodel.EQP0005ViewModel;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.XJ0001ViewModel;
import cn.tst.sbjxzzglxt.viewmodel.XJ0002ViewModel;
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
 * 巡检信息列表
 *
 * @author ps_xy@pscp.co.jp
 */
@ViewScoped
@Named(SepC.ControllerID.XJ0002)
public class XJ0002Controller extends BusinessBaseController {

   private SysRoutingInspectionMessage messageList;//巡检信息列表集合
   private SysRoutingInspectionMessage message;//巡检信息列表对象

    ///视图模型
    private XJ0002ViewModel vm;

    @EJB
    private XJ0002BizLogic bizLogic;

    /**
     *
     */
    @PostConstruct
    public void init() {

        ///初始化视图模型
        this.vm = new XJ0002ViewModel();

        this.bizLogic.loadXJ0002ViewModel(vm);
        

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
  
    //*****************************************************************
    //                        私有函数定义
    //*****************************************************************
    /**
     * 修改巡检信息列表
     *
     * @param message
     * 
     */
    public void onUpdateMessage(SysRoutingInspectionMessage message) {
        vm.setMessage(message);
    }

    /**
     * 删除巡检信息列表
     */
    public void onDeleteMessage(SysRoutingInspectionMessage row) {
        ///删除模式
        SepE.ExecuteMode mode = SepE.ExecuteMode.DELETE;
        vm.setMessage(row);

        ///执行更新
        ExecuteResult result = this.bizLogic.onRoutingInspectionMessage(mode, vm);

        if (result.isSuccess()) {
            putInfoMessage("删除成功");
            vm.setMessage(null);

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
        vm.setMessage(null);

    }

    /**
     * 保存数据
     *
     */
    public void onSaveData() {
        //初始化实体类的对象

        //当页面调用方法的时候，查看EquipWarn是否为空。
        SepE.ExecuteMode mode = this.vm.getMessage() == null
                //如果为空就执行模型的插入方法，如果非空就修改。
                ? SepE.ExecuteMode.INSERT : SepE.ExecuteMode.UPDATE;
        //本类调用接口实现方法，并把执行后的结果放进result中
        ExecuteResult result = this.bizLogic.onRoutingInspectionMessage(mode, vm);
        //本类调用添加消息的方法，添加执行结果创建的信息
        this.addMessage(result.createMessage());

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
        vm.setMessage(new SysRoutingInspectionMessage());
       
    }

    //*****************************************************************
    //                        Getter Setter
    //*****************************************************************
  public SysRoutingInspectionMessage getMessageList() {
        return messageList;
    }

    public void setMessageList(SysRoutingInspectionMessage messageList) {
        this.messageList = messageList;
    }

    public SysRoutingInspectionMessage getMessage() {
        return message;
    }

    public void setMessage(SysRoutingInspectionMessage message) {
        this.message = message;
    }

    public XJ0002ViewModel getVm() {
        return vm;
    }

    public void setVm(XJ0002ViewModel vm) {
        this.vm = vm;
    }

    public XJ0002BizLogic getBizLogic() {
        return bizLogic;
    }

    public void setBizLogic(XJ0002BizLogic bizLogic) {
        this.bizLogic = bizLogic;
    }
}
