package cn.tst.sbjxzzglxt.bizlogic.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import cn.tst.sbjxzzglxt.bizlogic.LoginBizLogic;
import cn.tst.sbjxzzglxt.common.BizConfig;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.controller.login.AccountManager;
import cn.tst.sbjxzzglxt.controller.login.LoginInfo;
import cn.tst.sbjxzzglxt.entity.DatLoginInfo;
import cn.tst.sbjxzzglxt.entity.DatYuanGongSuoShu;
import cn.tst.sbjxzzglxt.entity.MstBuMen;
import cn.tst.sbjxzzglxt.entity.MstRoleInfo;
import cn.tst.sbjxzzglxt.entity.MstSystemConfig;
import cn.tst.sbjxzzglxt.entity.MstYuanGong;
import cn.tst.sbjxzzglxt.exception.LoginException;
import cn.tst.sbjxzzglxt.service.impl.DatLoginFacade;
import cn.tst.sbjxzzglxt.service.impl.DatYuanGongSuoShuFacade;
import cn.tst.sbjxzzglxt.service.impl.MstBuMenFacade;
import cn.tst.sbjxzzglxt.service.impl.MstRoleInfoFacade;
import cn.tst.sbjxzzglxt.service.impl.MstSystemConfigFacade;
import cn.tst.sbjxzzglxt.service.impl.MstYuanGongFacade;

/**
 *
 * @author andysilver
 */
@Stateless
public class LoginBizLogicImpl implements LoginBizLogic {

    @Inject
    private BizConfig bizConfig;

    @EJB
    private MstYuanGongFacade yuanGongService;      ///员工

    @EJB
    private DatLoginFacade loginService;            ///登录

    @EJB
    private DatYuanGongSuoShuFacade ygssService;    ///员工所属关系
    
    @EJB
    private MstBuMenFacade mstBuMenDao;
    
    @EJB
    private MstSystemConfigFacade mstSystemConfigDao;
    
    @EJB
    private MstRoleInfoFacade mstRoleInfoDao;
    
    @Inject
    protected AccountManager am;

    @Override
    public LoginInfo searchLoginInfo(MstSystemConfig gongSi, String loginId, String password) throws LoginException {

        ///获取LoginInfo
        DatLoginInfo loginInfo = null;

        loginInfo = loginService.findLoginInfo(gongSi.getDbName(), loginId, password);

        ///不存在login信息
        if (loginInfo == null) {
            return null;
        }

        ///获取员工信息
        MstYuanGong yuanGong = loginInfo.getYuanGong();

        ///员工的信息不存
        if (yuanGong == null || yuanGong.isDeleted()) {
            // データの整合性問題があり、社員情報はない。
            throw new LoginException("login_err_001", bizConfig.getText("login_err_001"));
        }

        ///获取员工所属
        DatYuanGongSuoShu suoShu = ygssService.findYuanGongSuoShu(gongSi.getDbName(), yuanGong.getYuanGongId());

        LoginInfo result = new LoginInfo();

        ///员工信息
        result.setYuanGong(yuanGong);

        if (suoShu != null) {
            ///部门信息
            result.setBuMen(suoShu.getBuMen());

            ///职能信息
            result.setZhiNeng(suoShu.getZhiNeng());
        }

        ///是否为第一次登录
        result.setIsFirstTimeLogin(loginInfo.isUserFirstTimeLogin());

        ///是否为冻结的用户
        result.setIsLockUser(SepE.Flag.YES.getValue().equals(loginInfo.getLock()));

        ///登录用ID
        result.setLoginId(loginInfo.getLoginId());
        
        ///获取员工拥有的角色
        List<MstRoleInfo> roleList = mstRoleInfoDao.findByYuanGongId(yuanGong.getYuanGongId());
        result.setRoleList(roleList);
        
        return result;
    }

    @Override
    public List<MstBuMen> getBuMen(MstSystemConfig gongSi) {
        return mstBuMenDao.findAllByGongSi(gongSi.getDbName());
    }

    @Override
    public List<MstSystemConfig> getGongSi() {
        List<MstSystemConfig> resultList = mstSystemConfigDao.findAll();
//        for (MstSystemConfig mstSystemConfig : resultList) {
//            am.setSystemConfig(mstSystemConfig);
//        }
        am.setSystemConfig(resultList.get(0));
        for (MstSystemConfig systemConfig : resultList) {
            if (SepC.PERSISTENCE_UNIT.equals(systemConfig.getDbName())) {
                am.setSystemConfig(systemConfig);
            }
        }
        return resultList;
    }
}
