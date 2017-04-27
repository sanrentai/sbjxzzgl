package cn.tst.sbjxzzglxt.controller.login;

import java.util.List;
import java.util.Map;
import cn.tst.sbjxzzglxt.entity.DatYuanGongSuoShu;
import cn.tst.sbjxzzglxt.entity.MstBuMen;
import cn.tst.sbjxzzglxt.entity.MstGnShiYongQuanXian;
import cn.tst.sbjxzzglxt.entity.MstRoleInfo;
import cn.tst.sbjxzzglxt.entity.MstXiTongGongNeng;
import cn.tst.sbjxzzglxt.entity.MstYuanGong;
import cn.tst.sbjxzzglxt.entity.MstZhiNeng;

/**
 * 業務画面の共通利用するログイン者の情報
 *
 * @author owner
 */
public class LoginInfo {

    private String loginId;

    private boolean isFirstTimeLogin;

    private boolean isLockUser;

    // 社員の個人情報
    private MstYuanGong yuanGong;
    
    private List<MstRoleInfo> roleList;

    // 部門名前選択リスト
    private List<DatYuanGongSuoShu> bumenList;

    // 表示用部門詳細情報
    private MstBuMen buMen;

    // 表示用職能詳細情報
    private MstZhiNeng zhiNeng;

    // 利用権限完全リスト
    private List<MstGnShiYongQuanXian> mgsyqList;

    // 登録者に関連する部門マスタ詳細情報
    private Map<String, MstBuMen> bumonMap;

    //　登録者に関する職能詳細情報
    private Map<String, MstZhiNeng> mznMap;

    // 登録者に関連する機能詳細情報
    private Map<String, MstXiTongGongNeng> mxtgnMap;

    /**
     * デフォルトコンストラクター
     */
    public LoginInfo() {
    }

    public int getQuanXian(String huaMianId) {
        MstGnShiYongQuanXian quanXian = mgsyqList.stream()
            .filter(m -> m.getGongNeng().getHuaMianId().equals(huaMianId)).findFirst().get();
        return quanXian == null ? null : quanXian.getQuanXian();
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public boolean isIsLockUser() {
        return isLockUser;
    }

    public void setIsLockUser(boolean isLockUser) {
        this.isLockUser = isLockUser;
    }

    public MstYuanGong getYuanGong() {
        return yuanGong;
    }

    public void setYuanGong(MstYuanGong yuanGong) {
        this.yuanGong = yuanGong;
    }

    public List<DatYuanGongSuoShu> getBumenList() {
        return bumenList;
    }

    public void setBumenList(List<DatYuanGongSuoShu> bumenList) {
        this.bumenList = bumenList;
    }

    public List<MstGnShiYongQuanXian> getMgsyqList() {
        return mgsyqList;
    }

    public void setMgsyqList(List<MstGnShiYongQuanXian> mgsyqList) {
        this.mgsyqList = mgsyqList;
    }

    public Map<String, MstBuMen> getBumonMap() {
        return bumonMap;
    }

    public void setBumonMap(Map<String, MstBuMen> bumonMap) {
        this.bumonMap = bumonMap;
    }

    public Map<String, MstZhiNeng> getMznMap() {
        return mznMap;
    }

    public void setMznMap(Map<String, MstZhiNeng> mznMap) {
        this.mznMap = mznMap;
    }

    public Map<String, MstXiTongGongNeng> getMxtgnMap() {
        return mxtgnMap;
    }

    public void setMxtgnMap(Map<String, MstXiTongGongNeng> mxtgnMap) {
        this.mxtgnMap = mxtgnMap;
    }

    public MstBuMen getBuMen() {
        return buMen;
    }

    public void setBuMen(MstBuMen buMen) {
        this.buMen = buMen;
    }

    public MstZhiNeng getZhiNeng() {
        return zhiNeng;
    }

    public void setZhiNeng(MstZhiNeng zhiNeng) {
        this.zhiNeng = zhiNeng;
    }

    public boolean isIsFirstTimeLogin() {
        return isFirstTimeLogin;
    }

    public void setIsFirstTimeLogin(boolean isFirstTimeLogin) {
        this.isFirstTimeLogin = isFirstTimeLogin;
    }

    public List<MstRoleInfo> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<MstRoleInfo> roleList) {
        this.roleList = roleList;
    }

    public String getLoginUserName() {
        return this.getYuanGong().getXing()
            + "" + this.getYuanGong().getMing();
    }
}
