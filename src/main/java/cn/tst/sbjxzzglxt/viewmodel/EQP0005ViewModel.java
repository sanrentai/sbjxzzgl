package cn.tst.sbjxzzglxt.viewmodel;

import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipProperty;
import java.util.List;
import cn.tst.sbjxzzglxt.entity.LTEquipWarn;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.TreeNode;

/**
 * 仓库管理
 *
 * @author ps_xy@pscp.co.jp
 */
public class EQP0005ViewModel extends BaseViewModel {
      private List<LTEquipBasic> equipBasicList;
    private List<LTEquipWarn> equipWarnList;//在查询全部的时候，需要使用List接收
    private LTEquipWarn equipWarn;//设备提醒的实体类对象
    private TreeNode equipTreeRoot;//tree节点
    private List<LTEquipWarn> selectEquipWarnList;
    private LTEquipWarn selectedEquipWarn;
    private LTEquipWarn rootEqp;
    private LTEquipWarn editingEquipWarn;

    public List<LTEquipWarn> getEquipWarnList() {
        return equipWarnList;
    }

    public void setEquipWarnList(List<LTEquipWarn> equipWarnList) {
        this.equipWarnList = equipWarnList;
    }

    public LTEquipWarn getEquipWarn() {
        return equipWarn;
    }

    public void setEquipWarn(LTEquipWarn equipWarn) {
        this.equipWarn = equipWarn;
    }

    public TreeNode getEquipTreeRoot() {
        return equipTreeRoot;
    }

    public void setEquipTreeRoot(TreeNode equipTreeRoot) {
        this.equipTreeRoot = equipTreeRoot;
    }

    public List<LTEquipWarn> getSelectEquipWarnList() {
        return selectEquipWarnList;
    }

    public void setSelectEquipWarnList(List<LTEquipWarn> selectEquipWarnList) {
        this.selectEquipWarnList = selectEquipWarnList;
    }

    public LTEquipWarn getSelectedEquipWarn() {
        return selectedEquipWarn;
    }

    public void setSelectedEquipWarn(LTEquipWarn selectedEquipWarn) {
        this.selectedEquipWarn = selectedEquipWarn;
    }

    public LTEquipWarn getRootEqp() {
        return rootEqp;
    }

    public void setRootEqp(LTEquipWarn rootEqp) {
        this.rootEqp = rootEqp;
    }

    public LTEquipWarn getEditingEquipWarn() {
        return editingEquipWarn;
    }

    public void setEditingEquipWarn(LTEquipWarn editingEquipWarn) {
        this.editingEquipWarn = editingEquipWarn;
    }

    public List<LTEquipBasic> getEquipBasicList() {
        return equipBasicList;
    }

    public void setEquipBasicList(List<LTEquipBasic> equipBasicList) {
        this.equipBasicList = equipBasicList;
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
}
