package cn.tst.sbjxzzglxt.bizlogic;

import cn.tst.sbjxzzglxt.controller.login.LoginInfo;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;

/**
 * 密码变更
 *
 * @author ps_xy@pscp.co.jp
 */
public interface ChangePasswordBizLogic {

    /**
     * 密码变更
     *
     * @param loginInfo 登录用户
     * @param newPasswrod 新密码
     * @return 执行结果
     */
    ExecuteResult saveChange(LoginInfo loginInfo, String newPasswrod);

}
