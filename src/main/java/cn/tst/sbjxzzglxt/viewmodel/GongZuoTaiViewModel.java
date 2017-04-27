package cn.tst.sbjxzzglxt.viewmodel;

import java.util.Date;

/**
 * 工作台数据模型
 *
 * @author ps_xy@pscp.co.jp
 */
public class GongZuoTaiViewModel {
    
    private boolean hasNew = true;
    
    /// 最后更新时间
    private Date updateTime;
    
    /// 更新时间间隔（单位：秒）
    private int updateInterval;
    
    /// 申请领货
    private int shenQingLingHuo = 0;
    /// 物资申请审批
    private int wuZiShenQingShenPi = 0;
    /// 购买申请审批
    private int gouMaiShenQingShenPi = 0;
    /// 采购计划审批
    private int caiGouJiHuaShenPi = 0;
    /// 采购合同审批
    private int caiGouHeTongShenPi = 0;
    /// 支付计划审批
    private int zhiFuJiHuaShenPi = 0;
    /// 物资申请受理
    private int wuZiShenQingShouLi = 0;
    /// 物资调配
    private int wuZiTiaoPei = 0;
    /// 备货确认
    private int beiHuoQueRen = 0;
    
    /// TODO
    private int wuZiDiaoBoShenQingShouLi = 0;
    /// 被驳回物资申请
    private int beiBoHuiWuZiShenQing = 0;
    /// 被驳回购买申请
    private int beiBoHuiGouMaiShenQing = 0;
    /// 被驳回采购计划
    private int beiBoHuiCaiGouJiHua = 0;
    /// 物资入库
    private int wuZiRuKu = 0;
    /// 物资出库
    private int wuZiChuKu = 0;
    /// 采购计划制定
    private int caiGouJiHuaZhiDing = 0;
    /// 分配采购任务
    private int fenPeiCaiGouRenWu = 0;
    /// 采购计划执行
    private int caiGouJiHuaZhiXing = 0;
    /// 物资库存数超过警戒值
    private int kuCunShuChaoGuoJingJieZhi = 0;
    
    /// 车辆计划
    private int cheLiangJiHua = 0;

    public GongZuoTaiViewModel() {
        
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getUpdateInterval() {
        return updateInterval;
    }

    public void setUpdateInterval(int updateInterval) {
        this.updateInterval = updateInterval;
    }

    public int getShenQingLingHuo() {
        return shenQingLingHuo;
    }

    public void setShenQingLingHuo(int shenQingLingHuo) {
        this.shenQingLingHuo = shenQingLingHuo;
    }

    public int getWuZiShenQingShenPi() {
        return wuZiShenQingShenPi;
    }

    public void setWuZiShenQingShenPi(int wuZiShenQingShenPi) {
        this.wuZiShenQingShenPi = wuZiShenQingShenPi;
    }

    public int getGouMaiShenQingShenPi() {
        return gouMaiShenQingShenPi;
    }

    public void setGouMaiShenQingShenPi(int gouMaiShenQingShenPi) {
        this.gouMaiShenQingShenPi = gouMaiShenQingShenPi;
    }

    public int getCaiGouJiHuaShenPi() {
        return caiGouJiHuaShenPi;
    }

    public void setCaiGouJiHuaShenPi(int caiGouJiHuaShenPi) {
        this.caiGouJiHuaShenPi = caiGouJiHuaShenPi;
    }

    public int getWuZiShenQingShouLi() {
        return wuZiShenQingShouLi;
    }

    public void setWuZiShenQingShouLi(int wuZiShenQingShouLi) {
        this.wuZiShenQingShouLi = wuZiShenQingShouLi;
    }

    public int getWuZiTiaoPei() {
        return wuZiTiaoPei;
    }

    public void setWuZiTiaoPei(int wuZiTiaoPei) {
        this.wuZiTiaoPei = wuZiTiaoPei;
    }

    public int getBeiHuoQueRen() {
        return beiHuoQueRen;
    }

    public void setBeiHuoQueRen(int beiHuoQueRen) {
        this.beiHuoQueRen = beiHuoQueRen;
    }

    public int getWuZiDiaoBoShenQingShouLi() {
        return wuZiDiaoBoShenQingShouLi;
    }

    public void setWuZiDiaoBoShenQingShouLi(int wuZiDiaoBoShenQingShouLi) {
        this.wuZiDiaoBoShenQingShouLi = wuZiDiaoBoShenQingShouLi;
    }

    public int getBeiBoHuiWuZiShenQing() {
        return beiBoHuiWuZiShenQing;
    }

    public void setBeiBoHuiWuZiShenQing(int beiBoHuiWuZiShenQing) {
        this.beiBoHuiWuZiShenQing = beiBoHuiWuZiShenQing;
    }

    public int getBeiBoHuiGouMaiShenQing() {
        return beiBoHuiGouMaiShenQing;
    }

    public void setBeiBoHuiGouMaiShenQing(int beiBoHuiGouMaiShenQing) {
        this.beiBoHuiGouMaiShenQing = beiBoHuiGouMaiShenQing;
    }

    public int getBeiBoHuiCaiGouJiHua() {
        return beiBoHuiCaiGouJiHua;
    }

    public void setBeiBoHuiCaiGouJiHua(int beiBoHuiCaiGouJiHua) {
        this.beiBoHuiCaiGouJiHua = beiBoHuiCaiGouJiHua;
    }

    public int getWuZiRuKu() {
        return wuZiRuKu;
    }

    public void setWuZiRuKu(int wuZiRuKu) {
        this.wuZiRuKu = wuZiRuKu;
    }

    public int getWuZiChuKu() {
        return wuZiChuKu;
    }

    public void setWuZiChuKu(int wuZiChuKu) {
        this.wuZiChuKu = wuZiChuKu;
    }

    public int getCaiGouJiHuaZhiDing() {
        return caiGouJiHuaZhiDing;
    }

    public void setCaiGouJiHuaZhiDing(int caiGouJiHuaZhiDing) {
        this.caiGouJiHuaZhiDing = caiGouJiHuaZhiDing;
    }

    public int getFenPeiCaiGouRenWu() {
        return fenPeiCaiGouRenWu;
    }

    public void setFenPeiCaiGouRenWu(int fenPeiCaiGouRenWu) {
        this.fenPeiCaiGouRenWu = fenPeiCaiGouRenWu;
    }

    public int getCaiGouJiHuaZhiXing() {
        return caiGouJiHuaZhiXing;
    }

    public void setCaiGouJiHuaZhiXing(int caiGouJiHuaZhiXing) {
        this.caiGouJiHuaZhiXing = caiGouJiHuaZhiXing;
    }

    public int getCaiGouHeTongShenPi() {
        return caiGouHeTongShenPi;
    }

    public void setCaiGouHeTongShenPi(int caiGouHeTongShenPi) {
        this.caiGouHeTongShenPi = caiGouHeTongShenPi;
    }

    public int getZhiFuJiHuaShenPi() {
        return zhiFuJiHuaShenPi;
    }

    public void setZhiFuJiHuaShenPi(int zhiFuJiHuaShenPi) {
        this.zhiFuJiHuaShenPi = zhiFuJiHuaShenPi;
    }

    public boolean isHasNew() {
        return hasNew;
    }

    public void setHasNew(boolean hasNew) {
        this.hasNew = hasNew;
    }

    public int getKuCunShuChaoGuoJingJieZhi() {
        return kuCunShuChaoGuoJingJieZhi;
    }

    public void setKuCunShuChaoGuoJingJieZhi(int kuCunShuChaoGuoJingJieZhi) {
        this.kuCunShuChaoGuoJingJieZhi = kuCunShuChaoGuoJingJieZhi;
    }

    public int getCheLiangJiHua() {
        return cheLiangJiHua;
    }

    public void setCheLiangJiHua(int cheLiangJiHua) {
        this.cheLiangJiHua = cheLiangJiHua;
    }
    
    
}
