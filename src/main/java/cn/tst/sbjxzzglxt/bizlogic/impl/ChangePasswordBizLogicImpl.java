package cn.tst.sbjxzzglxt.bizlogic.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.bizlogic.ChangePasswordBizLogic;
import cn.tst.sbjxzzglxt.common.SecurityUtils;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.controller.login.LoginInfo;
import cn.tst.sbjxzzglxt.entity.DatLoginInfo;
import cn.tst.sbjxzzglxt.facade.DatLoginInfoFacade;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;

/**
 *
 * @author andysilver
 */
@Stateless
public class ChangePasswordBizLogicImpl extends BaseBizLogic implements ChangePasswordBizLogic {

    @EJB
    private DatLoginInfoFacade loginService;

    @Override
    public ExecuteResult saveChange(LoginInfo loginInfo, String newPasswrod) {

        ExecuteResult result = new ExecuteResult(SepE.ExecuteMode.UPDATE);

        try {

            DatLoginInfo updateTarget = loginService.findByLoginId(loginInfo.getLoginId());

            ///取消初次登录标志
            updateTarget.setFirstTimeLogin(SepE.Flag.NO.getValue());

            ///设置新密码
            updateTarget.setPassword(SecurityUtils.MD5(newPasswrod));

            ///更新密码
            loginService.edit(updateTarget);

            result.setSuccess(true);

        } catch (Exception e) {
            result.anylizeException(e);
            result.setSuccess(false);
        }

        return result;
    }

}
