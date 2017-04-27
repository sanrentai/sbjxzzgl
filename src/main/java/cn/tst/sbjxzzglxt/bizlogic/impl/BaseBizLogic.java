package cn.tst.sbjxzzglxt.bizlogic.impl;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import cn.tst.sbjxzzglxt.controller.login.AccountManager;
import cn.tst.sbjxzzglxt.entity.MstYuanGong;

/**
 * 业务逻辑基类
 *
 * @author ps_xy@pscp.co.jp
 */
//@Interceptors(BizLogicInterceptor.class)
public class BaseBizLogic {
    @Inject
    protected AccountManager am;
    
    protected String getYuanGongId() {
        return am.getLoginInfo().getYuanGong().getYuanGongId();
    }
    
    protected MstYuanGong getYuanGong() {
        return am.getLoginInfo().getYuanGong();
    }
    
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

}
