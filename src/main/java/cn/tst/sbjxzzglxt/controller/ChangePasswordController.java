package cn.tst.sbjxzzglxt.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import cn.tst.sbjxzzglxt.bizlogic.ChangePasswordBizLogic;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.controller.login.LoginInfo;
import cn.tst.sbjxzzglxt.viewmodel.ChangePasswordViewModel;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;

/**
 * 密码变更控制器
 *
 * @author ps_xy@pscp.co.jp
 */
@Named(SepC.ControllerID.CHANGE_PASSWORD)
@RequestScoped
public class ChangePasswordController extends BusinessBaseController {

    private ChangePasswordViewModel vm;

    @EJB
    private ChangePasswordBizLogic bizLogic;

    @PostConstruct
    public void init() {
        this.vm = new ChangePasswordViewModel();
    }

    /**
     * 保存密码变更
     */
    public String onSaveModify() {

        ///如果两次输入的密码不一致
        if (!this.vm.isSameInputValueBetween2Password()) {
            this.addMessage(new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "两次输入的密码不一致"));
            return null;
        }

        LoginInfo loginInfo = this.accountManager.getLoginInfo();

        ///更新密码
        ExecuteResult result = this.bizLogic.saveChange(loginInfo, this.vm.getPassword());

        this.addMessage(result.createMessage());

        if (result.isSuccess()) {
            loginInfo.setIsFirstTimeLogin(false);
            return "/views/index.xhtml?faces-redirect=true";
        }

        return null;
    }

    public ChangePasswordViewModel getVm() {
        return vm;
    }

    public void setVm(ChangePasswordViewModel vm) {
        this.vm = vm;
    }
}
