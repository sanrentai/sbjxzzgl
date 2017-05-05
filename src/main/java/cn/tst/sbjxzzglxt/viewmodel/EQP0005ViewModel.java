package cn.tst.sbjxzzglxt.viewmodel;

import java.util.List;
import cn.tst.sbjxzzglxt.entity.LTEquipWarn;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 * 仓库管理
 *
 * @author ps_xy@pscp.co.jp
 */
public class EQP0005ViewModel extends BaseViewModel {
    private List<LTEquipWarn> equipWarnList;//在查询全部的时候，需要使用List接收
    private LTEquipWarn equipWarn;//设备提醒的实体类对象
 
    private Date tdate;//页面中时间设置的对象

    public LTEquipWarn getEquipWarn() {
        return equipWarn;
    }

    public void setEquipWarn(LTEquipWarn equipWarn) {
        this.equipWarn = equipWarn;
    }

    public Date getTdate() {
        return tdate;
    }

    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }


      public List<LTEquipWarn> getEquipWarnList() {
        return equipWarnList;
    }

    public void setEquipWarnList(List<LTEquipWarn> equipWarnList) {
        this.equipWarnList = equipWarnList;
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
