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
    protected static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    /**
     * ContextPath
     *
     * @return 请求对象物理Path
     */
    protected static String getRequestContextPath() {
        return getExternalContext().getRequestContextPath();
    }

    /**
     * 是否为Postback处理
     *
     * @return true：是postback処理 false：非postback处理
     */
    protected static boolean isPostBack() {
        return getFacesContext().isPostback();
    }

    /**
     * 取得当前ViewId
     *
     * @return ViewId
     */
    protected static String getViewID() {
        return getFacesContext().getViewRoot().getViewId();
    }

    /**
     * 取得ExternalContext对象
     *
     * @return ExternalContext的实例
     */
    protected static ExternalContext getExternalContext() {
        return getFacesContext().getExternalContext();
    }

    /**
     * 取得ServletContext对象
     *
     * @return ServletContext的实例
     */
    protected static ServletContext getServletContext() {
        return (ServletContext)getExternalContext().getContext();
    }

    /**
     * 取得Request Parameter
     *
     * @return RequestParamterMap
     */
    protected static Map<String, String> getRequestParameterMap() {
        return getExternalContext().getRequestParameterMap();
    }

    /**
     * 取得Request Map
     *
     * @return RequestMap 的实例
     */
    protected static Map<String, Object> getRequestMap() {
        return getExternalContext().getRequestMap();
    }

    /**
     * 取得HttpServletResponse对象
     *
     * @return HttpServletResponse 的实例
     */
    protected static HttpServletResponse getResponse() {
        return (HttpServletResponse)getExternalContext().getResponse();
    }

    /**
     * 取得HttpServletRequest对象
     *
     * @return HttpServletRequest的实例
     */
    protected static HttpServletRequest getRequest() {
        return (HttpServletRequest)getExternalContext().getRequest();
    }

    /**
     * 取得ViewMap
     *
     * @return ViewMap 对象
     */
    protected static Map<String, Object> getViewMap() {
        return getFacesContext().getViewRoot().getViewMap();
    }

    /**
     * 取得当前HttpSession
     *
     * @return HttpSession的对象
     */
    public static HttpSession getUserSession() {
        return getUserSession(true);
    }

    /**
     * 取得当前HttpSession
     *
     * @param create 当没有Session时是否创建
     * @return HttpSession的对象
     */
    public static HttpSession getUserSession(boolean create) {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(create);
    }

    /**
     * PrimeFaces 错误Message追加
     *
     * @param facesMessage メッセージインスタンス
     */
    protected static void addMessage(FacesMessage facesMessage) {
        //client: validation 参考 master_page.xhmtl 便签定义
        addMessage(null, facesMessage);
//        RequestContext req = RequestContext.getCurrentInstance();
//        req.execute("PAGE_COM.buttonShortCutKeyInvoke('frmMain:btnValidationPanel');");
    }

    /**
     * PrimeFaces 追加消息
     *
     * @param msgBoxId MessageBoxId
     * @param facesMessage FacesMessage的实例
     */
    protected static void addMessage(String msgBoxId, FacesMessage facesMessage) {
        getFacesContext().addMessage(msgBoxId, facesMessage);
    }

    /**
     * 添加全局弹出框消息
     *
     * @param facesMessage 消息内容
     */
    protected static void addToGlobalGrowl(FacesMessage facesMessage) {
        //client:updating 参考 master_page.xhmtl 便签定义
        addMessage("updating", facesMessage);
//        RequestContext req = RequestContext.getCurrentInstance();
        // update不管用
//        req.update("frmMain:ovPnlValidation, frmMain:msgValidation, frmMain:growlMessage, frmMain:btnValidationPanel");
//        req.execute("PAGE_COM.buttonShortCutKeyInvoke('frmMain:btnValidationPanel');");
    }
    
    protected static RequestContext getRequestContext() {
        return RequestContext.getCurrentInstance();
    }
    
    protected static void execute(String cmd) {
        getRequestContext().execute(cmd);
    }
}
