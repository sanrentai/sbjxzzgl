package cn.tst.sbjxzzglxt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import cn.tst.sbjxzzglxt.bizlogic.LoginBizLogic;
import cn.tst.sbjxzzglxt.common.BizConfig;
import cn.tst.sbjxzzglxt.common.SecurityUtils;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.controller.login.GlobalLoginManager;
import cn.tst.sbjxzzglxt.controller.login.LoginInfo;
import cn.tst.sbjxzzglxt.entity.DatLoginInfo;
import cn.tst.sbjxzzglxt.entity.DatYuanGongSuoShu;
import cn.tst.sbjxzzglxt.entity.MstBuMen;
import cn.tst.sbjxzzglxt.entity.MstSystemConfig;
import cn.tst.sbjxzzglxt.exception.LoginException;
import org.apache.log4j.Logger;

/**
 * 登录页面控制器
 *
 * @author ps_xy@pscp.co.jp
 */
@Named(SepC.ControllerID.LOGIN)
//@RequestScoped
//@SessionScoped
@ViewScoped
public class LoginController extends BusinessBaseController {

    private static final Logger LOG = Logger.getLogger(LoginController.class.getName());

    ///用户名
    private String loginId;
    ///密码
    private String password;
    ///登录次数计数
    private int loginCounter = 0;
    ///错误信息
    private String loginErrorMsg;

    @Inject
    private BizConfig bizConfig;

    @EJB
    private LoginBizLogic bizLogic;

    @Inject
    private GlobalLoginManager glm;
    
//    private List<MstGongChengXiangMu> buMenXiangMuList;
    
    private List<MstSystemConfig> gongSiList;
    
    private MstSystemConfig selectedGongSi;
    
    private String selectedSysId;
    
    private List<MstBuMen> buMenList;
    
    private List<DatLoginInfo> loginInfoList;
    
    private MstBuMen selectedBuMen;
    
    private String selectedBuMenId;
    
//    private StreamedContent file;
    
    /**
     * 页面初始化
     */
    @PostConstruct
    public void init() {
        gongSiList = bizLogic.getGongSi();
        if (!gongSiList.isEmpty()) {
            selectedGongSi = gongSiList.get(0);
            selectedSysId = selectedGongSi.getSysId();
        } else {
            selectedGongSi = new MstSystemConfig();
            selectedGongSi.setSysId("material");
            selectedGongSi.setCompanyName("本溪华兴");
            selectedGongSi.setDbName(SepC.PERSISTENCE_UNIT);
            selectedSysId = selectedGongSi.getSysId();
        }
        
        changeGongSiEvent();
//        loadFileDownloadView();
    }
    
//    public void loadFileDownloadView() {
//        InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/app/android.apk");
//        file = new DefaultStreamedContent(stream, "application/vnd.android.package-archive", "wuZiGuanLi.apk");
//    }
//
//    public StreamedContent getFile() {
//        return file;
//    }
    
    public void changeGongSiEvent() {
        for (MstSystemConfig gongSi : gongSiList) {
            if (gongSi.getSysId().equals(selectedSysId)) {
                selectedGongSi = gongSi;
            }
        }
        /// 设置公司情报
        accountManager.setSystemConfig(selectedGongSi);
        buMenList = bizLogic.getBuMen(selectedGongSi);
        if (!buMenList.isEmpty()) {
            MstBuMen buMen = buMenList.get(0);
            selectedBuMenId = buMen.getBuMenId();
            changeBuMen(buMen);
        }
    }
    
    /**
     * 改变部门事件
     */
    public void changeBuMenEvent() {
        for (MstBuMen buMen : buMenList) {
            if (buMen.getBuMenId().equals(selectedBuMenId)) {
                selectedBuMen = buMen;
            }
        }
        changeBuMen(selectedBuMen);
    }
    
    /**
     * 改变部门事件
     * @param buMen 改变后的部门
     */
    public void changeBuMen(MstBuMen buMen) {
        LOG.info(buMen);
        loginInfoList = new ArrayList<>();
        List<DatYuanGongSuoShu> yuanGongSuoShuList = buMen.getYuanGongSuoShuList();
        for (DatYuanGongSuoShu yuanGongSuoShu : yuanGongSuoShuList) {
            if (yuanGongSuoShu.getDelFlg() == SepE.Flag.YES || !yuanGongSuoShu.isZaiZhi()) {
                continue;
            }
            LOG.info(yuanGongSuoShu);
            LOG.info(yuanGongSuoShu.getYuanGong());
            DatLoginInfo loginInfo = yuanGongSuoShu.getYuanGong().getLoginInfo();
            if (loginInfo != null && !loginInfoList.contains(loginInfo)) {
                loginInfoList.add(loginInfo);
            }
        }
    }

    /**
     * 登录处理
     *
     * @return
     */
    public String login() {

        // ログインエラーメッセージの初期化
        this.loginErrorMsg = "";

        try {

            /// ログイン情報を検索する。
            LoginInfo loginInfo = bizLogic.searchLoginInfo(selectedGongSi, this.loginId, SecurityUtils.MD5(this.password));

            ///Login成功 or 失败
            this.accountManager.setLoginIsSuccess(loginInfo != null);

            ///Login者
            this.accountManager.setLoginInfo(loginInfo);

        } catch (LoginException ex) {
            this.loginErrorMsg = "[" + ex.getErrorCode() + "]: " + ex.getErrorMessage();
            this.accountManager.setLoginIsSuccess(false);
            return null;
        }

        // ユーザID,パスワードがミスの場合
        if (!this.accountManager.isLoginIsSuccess()) {
            this.loginErrorMsg = bizConfig.getText("login_id_or_pass_miss");
            this.addMessage(new FacesMessage(FacesMessage.SEVERITY_ERROR, null, this.getLoginResultMessage()));
            LOG.info("--------------登录失败-------------用户名密码错误");
            return null;
        }

        /// 是否为冻结的用户
        if (this.accountManager.getLoginInfo().isIsLockUser()) {
            this.loginErrorMsg = bizConfig.getText("login_is_locked");
            this.addMessage(new FacesMessage(FacesMessage.SEVERITY_ERROR, null, this.getLoginResultMessage()));
            LOG.info("--------------登录失败-------------用户被冻结,无法使用");
            return null;
        }

        // 別の場所のログイン有無をチェックする(遷移先画面が
        // 要検討、別の場所のログインを殺すか、確認か？
//        if (glm.loginInApplication(loginId)) {
//            LOG.info("--------------登录失败-------------已经在别处登录");
//            this.accountManager.setMultiLoginMsg(glm.deleteOtherSession(loginId)
//                ? bizConfig.getText("multiLoginMessage") : "");
//            return null;
//        }
        return "/views/index.xhtml?faces-redirect=true";
    }

    /**
     * 登出处理
     *
     * @return 登入路径
     */
    public String logOut() {

        LOG.info("セッション破棄する前");
        this.getExternalContext().invalidateSession();
        LOG.info("セッション破棄した後");

        return "/login.xhtml?faces-redirect=true";
    }

    public int getLoginCounter() {
        return loginCounter;
    }

    /**
     * ログイン回数をカウントする
     *
     * @param loginCounter
     */
    public void setLoginCounter(int loginCounter) {
        this.loginCounter = loginCounter + 1;
    }

    /**
     * ログイン結果の取得
     *
     * @return
     */
    private String getLoginResultMessage() {
        String resultMsg = this.loginErrorMsg;
        if (this.loginCounter > 0 && !this.accountManager.isLoginIsSuccess()) {

            // ログイン回数と残ログイン可能回数の設定
            resultMsg = "\n" + bizConfig.getText("loginResultMsg",
                this.loginCounter,
                "" + (SepC.MAX_ERROR_LOGIN_COUNT - this.loginCounter));
        }
        return resultMsg;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginId() {
        return this.loginId;
    }

    public String getPassword() {
        return this.password;
    }

    public List<DatLoginInfo> getLoginInfoList() {
        return loginInfoList;
    }

    public void setLoginInfoList(List<DatLoginInfo> loginInfoList) {
        this.loginInfoList = loginInfoList;
    }

    public MstBuMen getSelectedBuMen() {
        return selectedBuMen;
    }

    public void setSelectedBuMen(MstBuMen selectedBuMen) {
        this.selectedBuMen = selectedBuMen;
    }

    public String getSelectedBuMenId() {
        return selectedBuMenId;
    }

    public void setSelectedBuMenId(String selectedBuMenId) {
        this.selectedBuMenId = selectedBuMenId;
    }

    public List<MstBuMen> getBuMenList() {
        return buMenList;
    }

    public void setBuMenList(List<MstBuMen> buMenList) {
        this.buMenList = buMenList;
    }

    public List<MstSystemConfig> getGongSiList() {
        return gongSiList;
    }

    public void setGongSiList(List<MstSystemConfig> gongSiList) {
        this.gongSiList = gongSiList;
    }

    public MstSystemConfig getSelectedGongSi() {
        return selectedGongSi;
    }

    public void setSelectedGongSi(MstSystemConfig selectedGongSi) {
        this.selectedGongSi = selectedGongSi;
    }

    public String getSelectedSysId() {
        return selectedSysId;
    }

    public void setSelectedSysId(String selectedSysId) {
        this.selectedSysId = selectedSysId;
    }

}
