package cn.tst.sbjxzzglxt.bizlogic;

import java.util.List;
import cn.tst.sbjxzzglxt.controller.login.LoginInfo;
import cn.tst.sbjxzzglxt.entity.MstBuMen;
import cn.tst.sbjxzzglxt.entity.MstSystemConfig;
import cn.tst.sbjxzzglxt.exception.LoginException;

/**
 *
 * @author andysilver
 */
public interface LoginBizLogic {

    List<MstBuMen> getBuMen(MstSystemConfig gongSi);

    List<MstSystemConfig> getGongSi();

    /**
     * 获取登录信息
     *
     * @param gongSi
     * @param loginId loginId
     * @param password password
     * @return
     * @throws cn.tst.sbjxzzglxt.exception.LoginException
     */
    LoginInfo searchLoginInfo(MstSystemConfig gongSi, String loginId, String password) throws LoginException;
}
