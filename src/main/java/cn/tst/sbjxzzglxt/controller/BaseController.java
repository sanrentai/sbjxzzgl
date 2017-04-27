package cn.tst.sbjxzzglxt.controller;

import java.io.Serializable;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 * 控制器抽象基类
 *
 * @author ps_xy@pscp.co.jp
 */
public abstract class BaseController implements Serializable {

    /**
     * FacesContext
     *
     * @return FacesContext的实例
     */
    protected FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    /**
     * ContextPath
     *
     * @return 请求对象物理Path
     */
    protected String getRequestContextPath() {
        return this.getExternalContext().getRequestContextPath();
    }

    /**
     * 是否为Postback处理
     *
     * @return true：是postback処理 false：非postback处理
     */
    protected boolean isPostBack() {
        return this.getFacesContext().isPostback();
    }

    /**
     * 取得当前ViewId
     *
     * @return ViewId
     */
    protected String getViewID() {
        return this.getFacesContext().getViewRoot().getViewId();
    }

    /**
     * 取得ExternalContext对象
     *
     * @return ExternalContext的实例
     */
    protected ExternalContext getExternalContext() {
        return this.getFacesContext().getExternalContext();
    }

    /**
     * 取得ServletContext对象
     *
     * @return ServletContext的实例
     */
    protected ServletContext getServletContext() {
        return (ServletContext) this.getExternalContext().getContext();
    }

    /**
     * 取得Request Parameter
     *
     * @return RequestParamterMap
     */
    protected Map<String, String> getRequestParameterMap() {
        return this.getExternalContext().getRequestParameterMap();
    }

    /**
     * 取得Request Map
     *
     * @return RequestMap 的实例
     */
    protected Map<String, Object> getRequestMap() {
        return this.getExternalContext().getRequestMap();
    }

    /**
     * 取得HttpServletResponse对象
     *
     * @return HttpServletResponse 的实例
     */
    protected HttpServletResponse getResponse() {
        return (HttpServletResponse) this.getExternalContext().getResponse();
    }

    /**
     * 取得HttpServletRequest对象
     *
     * @return HttpServletRequest的实例
     */
    protected HttpServletRequest getRequest() {
        return (HttpServletRequest) this.getExternalContext().getRequest();
    }

    /**
     * 取得ViewMap
     *
     * @return ViewMap 对象
     */
    protected Map<String, Object> getViewMap() {
        return this.getFacesContext().getViewRoot().getViewMap();
    }

    /**
     * 取得当前HttpSession
     *
     * @return HttpSession的对象
     */
    public HttpSession getUserSession() {
        return getUserSession(true);
    }

    /**
     * 取得当前HttpSession
     *
     * @param create 当没有Session时是否创建
     * @return HttpSession的对象
     */
    public HttpSession getUserSession(boolean create) {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(create);
    }

    /**
     * PrimeFaces 错误Message追加
     *
     * @param facesMessage メッセージインスタンス
     */
    protected void addMessage(FacesMessage facesMessage) {
        //client: validation 参考 master_page.xhmtl 便签定义
        this.addMessage(null, facesMessage);
//        RequestContext req = RequestContext.getCurrentInstance();
//        req.execute("PAGE_COM.buttonShortCutKeyInvoke('frmMain:btnValidationPanel');");
    }

    /**
     * PrimeFaces 追加消息
     *
     * @param msgBoxId MessageBoxId
     * @param facesMessage FacesMessage的实例
     */
    protected void addMessage(String msgBoxId, FacesMessage facesMessage) {
        this.getFacesContext().addMessage(msgBoxId, facesMessage);
    }

    /**
     * 添加全局弹出框消息
     *
     * @param facesMessage 消息内容
     */
    protected void addToGlobalGrowl(FacesMessage facesMessage) {
        //client:updating 参考 master_page.xhmtl 便签定义
        this.addMessage("updating", facesMessage);
//        RequestContext req = RequestContext.getCurrentInstance();
        // update不管用
//        req.update("frmMain:ovPnlValidation, frmMain:msgValidation, frmMain:growlMessage, frmMain:btnValidationPanel");
//        req.execute("PAGE_COM.buttonShortCutKeyInvoke('frmMain:btnValidationPanel');");
    }
    
    protected RequestContext getRequestContext() {
        return RequestContext.getCurrentInstance();
    }
    
    protected void execute(String cmd) {
        getRequestContext().execute(cmd);
    }
}
