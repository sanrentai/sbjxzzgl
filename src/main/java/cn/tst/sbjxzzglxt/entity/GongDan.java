/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@Entity
@Table(name = "GongDan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GongDan.findAll", query = "SELECT g FROM GongDan g")
    , @NamedQuery(name = "GongDan.findByGongDanId", query = "SELECT g FROM GongDan g WHERE g.gongDanId = :gongDanId")
    , @NamedQuery(name = "GongDan.findByShuQiuLaiYuan", query = "SELECT g FROM GongDan g WHERE g.shuQiuLaiYuan = :shuQiuLaiYuan")
    , @NamedQuery(name = "GongDan.findByDengJi", query = "SELECT g FROM GongDan g WHERE g.dengJi = :dengJi")
    , @NamedQuery(name = "GongDan.findByChuLiZhuangTai", query = "SELECT g FROM GongDan g WHERE g.chuLiZhuangTai = :chuLiZhuangTai")
    , @NamedQuery(name = "GongDan.findByGongDanBianHao", query = "SELECT g FROM GongDan g WHERE g.gongDanBianHao = :gongDanBianHao")
    , @NamedQuery(name = "GongDan.findByGongDanFenLei", query = "SELECT g FROM GongDan g WHERE g.gongDanFenLei = :gongDanFenLei")
    , @NamedQuery(name = "GongDan.findByGongDanXiangMu", query = "SELECT g FROM GongDan g WHERE g.gongDanXiangMu = :gongDanXiangMu")
    , @NamedQuery(name = "GongDan.findByHuRuShiJian", query = "SELECT g FROM GongDan g WHERE g.huRuShiJian = :huRuShiJian")
    , @NamedQuery(name = "GongDan.findByDengJiRenId", query = "SELECT g FROM GongDan g WHERE g.dengJiRenId = :dengJiRenId")
    , @NamedQuery(name = "GongDan.findByDengJiShiJian", query = "SELECT g FROM GongDan g WHERE g.dengJiShiJian = :dengJiShiJian")
    , @NamedQuery(name = "GongDan.findByYuYueShiJian", query = "SELECT g FROM GongDan g WHERE g.yuYueShiJian = :yuYueShiJian")
    , @NamedQuery(name = "GongDan.findByChuLiShiXian", query = "SELECT g FROM GongDan g WHERE g.chuLiShiXian = :chuLiShiXian")
    , @NamedQuery(name = "GongDan.findByJieDanBuMen", query = "SELECT g FROM GongDan g WHERE g.jieDanBuMen = :jieDanBuMen")
    , @NamedQuery(name = "GongDan.findByJieDanShiJian", query = "SELECT g FROM GongDan g WHERE g.jieDanShiJian = :jieDanShiJian")
    , @NamedQuery(name = "GongDan.findByKeHuMingCheng", query = "SELECT g FROM GongDan g WHERE g.keHuMingCheng = :keHuMingCheng")
    , @NamedQuery(name = "GongDan.findByLaiDianHaoMa", query = "SELECT g FROM GongDan g WHERE g.laiDianHaoMa = :laiDianHaoMa")
    , @NamedQuery(name = "GongDan.findByLianXiDianHua", query = "SELECT g FROM GongDan g WHERE g.lianXiDianHua = :lianXiDianHua")
    , @NamedQuery(name = "GongDan.findByKeHuDiZhi", query = "SELECT g FROM GongDan g WHERE g.keHuDiZhi = :keHuDiZhi")
    , @NamedQuery(name = "GongDan.findByKeHuMiaoShu", query = "SELECT g FROM GongDan g WHERE g.keHuMiaoShu = :keHuMiaoShu")
    , @NamedQuery(name = "GongDan.findByOwnerid", query = "SELECT g FROM GongDan g WHERE g.ownerid = :ownerid")
    , @NamedQuery(name = "GongDan.findByJieShuShiJian", query = "SELECT g FROM GongDan g WHERE g.jieShuShiJian = :jieShuShiJian")
    , @NamedQuery(name = "GongDan.findByFuZeRenId", query = "SELECT g FROM GongDan g WHERE g.fuZeRenId = :fuZeRenId")
    , @NamedQuery(name = "GongDan.findByChuLiJieGuo", query = "SELECT g FROM GongDan g WHERE g.chuLiJieGuo = :chuLiJieGuo")
    , @NamedQuery(name = "GongDan.findByChuLiNeiRong", query = "SELECT g FROM GongDan g WHERE g.chuLiNeiRong = :chuLiNeiRong")
    , @NamedQuery(name = "GongDan.findByCaiLiaoFei", query = "SELECT g FROM GongDan g WHERE g.caiLiaoFei = :caiLiaoFei")
    , @NamedQuery(name = "GongDan.findByFuWuFei", query = "SELECT g FROM GongDan g WHERE g.fuWuFei = :fuWuFei")
    , @NamedQuery(name = "GongDan.findByZongShouFei", query = "SELECT g FROM GongDan g WHERE g.zongShouFei = :zongShouFei")
    , @NamedQuery(name = "GongDan.findByHuiFangShiJian", query = "SELECT g FROM GongDan g WHERE g.huiFangShiJian = :huiFangShiJian")
    , @NamedQuery(name = "GongDan.findByHuiFangRenId", query = "SELECT g FROM GongDan g WHERE g.huiFangRenId = :huiFangRenId")
    , @NamedQuery(name = "GongDan.findByFuWuPingJia", query = "SELECT g FROM GongDan g WHERE g.fuWuPingJia = :fuWuPingJia")
    , @NamedQuery(name = "GongDan.findByHuiFangJieGuo", query = "SELECT g FROM GongDan g WHERE g.huiFangJieGuo = :huiFangJieGuo")
    , @NamedQuery(name = "GongDan.findByHaiXinId", query = "SELECT g FROM GongDan g WHERE g.haiXinId = :haiXinId")
    , @NamedQuery(name = "GongDan.findByCirId", query = "SELECT g FROM GongDan g WHERE g.cirId = :cirId")
    , @NamedQuery(name = "GongDan.findByInsRep", query = "SELECT g FROM GongDan g WHERE g.insRep = :insRep")
    , @NamedQuery(name = "GongDan.findByInsDate", query = "SELECT g FROM GongDan g WHERE g.insDate = :insDate")
    , @NamedQuery(name = "GongDan.findByUpdRep", query = "SELECT g FROM GongDan g WHERE g.updRep = :updRep")
    , @NamedQuery(name = "GongDan.findByUpdDate", query = "SELECT g FROM GongDan g WHERE g.updDate = :updDate")
    , @NamedQuery(name = "GongDan.findByDelFlg", query = "SELECT g FROM GongDan g WHERE g.delFlg = :delFlg")
    , @NamedQuery(name = "GongDan.findByVersion", query = "SELECT g FROM GongDan g WHERE g.version = :version")})
public class GongDan extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "gong_dan_id")
    private Integer gongDanId;
    @Column(name = "shu_qiu_lai_yuan")
    private Integer shuQiuLaiYuan;
    @Column(name = "deng_ji")
    private Integer dengJi;
    @Column(name = "chu_li_zhuang_tai")
    private Integer chuLiZhuangTai;
    @Size(max = 20)
    @Column(name = "gong_dan_bian_hao")
    private String gongDanBianHao;
    @Size(max = 50)
    @Column(name = "gong_dan_fen_lei")
    private String gongDanFenLei;
    @Size(max = 50)
    @Column(name = "gong_dan_xiang_mu")
    private String gongDanXiangMu;
    @Column(name = "hu_ru_shi_jian")
    @Temporal(TemporalType.TIMESTAMP)
    private Date huRuShiJian;
    @Size(max = 6)
    @Column(name = "deng_ji_ren_id")
    private String dengJiRenId;
    @Column(name = "deng_ji_shi_jian")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dengJiShiJian;
    @Column(name = "yu_yue_shi_jian")
    @Temporal(TemporalType.TIMESTAMP)
    private Date yuYueShiJian;
    @Column(name = "chu_li_shi_xian")
    @Temporal(TemporalType.TIMESTAMP)
    private Date chuLiShiXian;
    @Size(max = 40)
    @Column(name = "jie_dan_bu_men")
    private String jieDanBuMen;
    @Column(name = "jie_dan_shi_jian")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jieDanShiJian;
    @Size(max = 50)
    @Column(name = "ke_hu_ming_cheng")
    private String keHuMingCheng;
    @Size(max = 20)
    @Column(name = "lai_dian_hao_ma")
    private String laiDianHaoMa;
    @Size(max = 20)
    @Column(name = "lian_xi_dian_hua")
    private String lianXiDianHua;
    @Size(max = 500)
    @Column(name = "ke_hu_di_zhi")
    private String keHuDiZhi;
    @Size(max = 2147483647)
    @Column(name = "ke_hu_miao_shu")
    private String keHuMiaoShu;
    @Size(max = 14)
    @Column(name = "ownerid")
    private String ownerid;
    @Column(name = "jie_shu_shi_jian")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jieShuShiJian;
    @Size(max = 6)
    @Column(name = "fu_ze_ren_id")
    private String fuZeRenId;
    @Size(max = 2147483647)
    @Column(name = "chu_li_jie_guo")
    private String chuLiJieGuo;
    @Size(max = 2147483647)
    @Column(name = "chu_li_nei_rong")
    private String chuLiNeiRong;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cai_liao_fei")
    private BigDecimal caiLiaoFei;
    @Column(name = "fu_wu_fei")
    private BigDecimal fuWuFei;
    @Column(name = "zong_shou_fei")
    private BigDecimal zongShouFei;
    @Column(name = "hui_fang_shi_jian")
    @Temporal(TemporalType.TIMESTAMP)
    private Date huiFangShiJian;
    @Size(max = 6)
    @Column(name = "hui_fang_ren_id")
    private String huiFangRenId;
    @Size(max = 20)
    @Column(name = "fu_wu_ping_jia")
    private String fuWuPingJia;
    @Size(max = 2147483647)
    @Column(name = "hui_fang_jie_guo")
    private String huiFangJieGuo;
    @Size(max = 40)
    @Column(name = "hai_xin_id")
    private String haiXinId;
    @Size(max = 40)
    @Column(name = "cir_id")
    private String cirId;

    public GongDan() {
    }

    public GongDan(Integer gongDanId) {
        this.gongDanId = gongDanId;
    }

    public GongDan(Integer gongDanId, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
        this.gongDanId = gongDanId;
        this.insRep = insRep;
        this.insDate = insDate;
        this.updRep = updRep;
        this.updDate = updDate;
        this.version = version;
    }

    public Integer getGongDanId() {
        return gongDanId;
    }

    public void setGongDanId(Integer gongDanId) {
        this.gongDanId = gongDanId;
    }

    public Integer getShuQiuLaiYuan() {
        return shuQiuLaiYuan;
    }

    public void setShuQiuLaiYuan(Integer shuQiuLaiYuan) {
        this.shuQiuLaiYuan = shuQiuLaiYuan;
    }

    public Integer getDengJi() {
        return dengJi;
    }

    public void setDengJi(Integer dengJi) {
        this.dengJi = dengJi;
    }

    public Integer getChuLiZhuangTai() {
        return chuLiZhuangTai;
    }

    public void setChuLiZhuangTai(Integer chuLiZhuangTai) {
        this.chuLiZhuangTai = chuLiZhuangTai;
    }

    public String getGongDanBianHao() {
        return gongDanBianHao;
    }

    public void setGongDanBianHao(String gongDanBianHao) {
        this.gongDanBianHao = gongDanBianHao;
    }

    public String getGongDanFenLei() {
        return gongDanFenLei;
    }

    public void setGongDanFenLei(String gongDanFenLei) {
        this.gongDanFenLei = gongDanFenLei;
    }

    public String getGongDanXiangMu() {
        return gongDanXiangMu;
    }

    public void setGongDanXiangMu(String gongDanXiangMu) {
        this.gongDanXiangMu = gongDanXiangMu;
    }

    public Date getHuRuShiJian() {
        return huRuShiJian;
    }

    public void setHuRuShiJian(Date huRuShiJian) {
        this.huRuShiJian = huRuShiJian;
    }

    public String getDengJiRenId() {
        return dengJiRenId;
    }

    public void setDengJiRenId(String dengJiRenId) {
        this.dengJiRenId = dengJiRenId;
    }

    public Date getDengJiShiJian() {
        return dengJiShiJian;
    }

    public void setDengJiShiJian(Date dengJiShiJian) {
        this.dengJiShiJian = dengJiShiJian;
    }

    public Date getYuYueShiJian() {
        return yuYueShiJian;
    }

    public void setYuYueShiJian(Date yuYueShiJian) {
        this.yuYueShiJian = yuYueShiJian;
    }

    public Date getChuLiShiXian() {
        return chuLiShiXian;
    }

    public void setChuLiShiXian(Date chuLiShiXian) {
        this.chuLiShiXian = chuLiShiXian;
    }

    public String getJieDanBuMen() {
        return jieDanBuMen;
    }

    public void setJieDanBuMen(String jieDanBuMen) {
        this.jieDanBuMen = jieDanBuMen;
    }

    public Date getJieDanShiJian() {
        return jieDanShiJian;
    }

    public void setJieDanShiJian(Date jieDanShiJian) {
        this.jieDanShiJian = jieDanShiJian;
    }

    public String getKeHuMingCheng() {
        return keHuMingCheng;
    }

    public void setKeHuMingCheng(String keHuMingCheng) {
        this.keHuMingCheng = keHuMingCheng;
    }

    public String getLaiDianHaoMa() {
        return laiDianHaoMa;
    }

    public void setLaiDianHaoMa(String laiDianHaoMa) {
        this.laiDianHaoMa = laiDianHaoMa;
    }

    public String getLianXiDianHua() {
        return lianXiDianHua;
    }

    public void setLianXiDianHua(String lianXiDianHua) {
        this.lianXiDianHua = lianXiDianHua;
    }

    public String getKeHuDiZhi() {
        return keHuDiZhi;
    }

    public void setKeHuDiZhi(String keHuDiZhi) {
        this.keHuDiZhi = keHuDiZhi;
    }

    public String getKeHuMiaoShu() {
        return keHuMiaoShu;
    }

    public void setKeHuMiaoShu(String keHuMiaoShu) {
        this.keHuMiaoShu = keHuMiaoShu;
    }

    public String getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }

    public Date getJieShuShiJian() {
        return jieShuShiJian;
    }

    public void setJieShuShiJian(Date jieShuShiJian) {
        this.jieShuShiJian = jieShuShiJian;
    }

    public String getFuZeRenId() {
        return fuZeRenId;
    }

    public void setFuZeRenId(String fuZeRenId) {
        this.fuZeRenId = fuZeRenId;
    }

    public String getChuLiJieGuo() {
        return chuLiJieGuo;
    }

    public void setChuLiJieGuo(String chuLiJieGuo) {
        this.chuLiJieGuo = chuLiJieGuo;
    }

    public String getChuLiNeiRong() {
        return chuLiNeiRong;
    }

    public void setChuLiNeiRong(String chuLiNeiRong) {
        this.chuLiNeiRong = chuLiNeiRong;
    }

    public BigDecimal getCaiLiaoFei() {
        return caiLiaoFei;
    }

    public void setCaiLiaoFei(BigDecimal caiLiaoFei) {
        this.caiLiaoFei = caiLiaoFei;
    }

    public BigDecimal getFuWuFei() {
        return fuWuFei;
    }

    public void setFuWuFei(BigDecimal fuWuFei) {
        this.fuWuFei = fuWuFei;
    }

    public BigDecimal getZongShouFei() {
        return zongShouFei;
    }

    public void setZongShouFei(BigDecimal zongShouFei) {
        this.zongShouFei = zongShouFei;
    }

    public Date getHuiFangShiJian() {
        return huiFangShiJian;
    }

    public void setHuiFangShiJian(Date huiFangShiJian) {
        this.huiFangShiJian = huiFangShiJian;
    }

    public String getHuiFangRenId() {
        return huiFangRenId;
    }

    public void setHuiFangRenId(String huiFangRenId) {
        this.huiFangRenId = huiFangRenId;
    }

    public String getFuWuPingJia() {
        return fuWuPingJia;
    }

    public void setFuWuPingJia(String fuWuPingJia) {
        this.fuWuPingJia = fuWuPingJia;
    }

    public String getHuiFangJieGuo() {
        return huiFangJieGuo;
    }

    public void setHuiFangJieGuo(String huiFangJieGuo) {
        this.huiFangJieGuo = huiFangJieGuo;
    }

    public String getHaiXinId() {
        return haiXinId;
    }

    public void setHaiXinId(String haiXinId) {
        this.haiXinId = haiXinId;
    }

    public String getCirId() {
        return cirId;
    }

    public void setCirId(String cirId) {
        this.cirId = cirId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gongDanId != null ? gongDanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GongDan)) {
            return false;
        }
        GongDan other = (GongDan) object;
        if ((this.gongDanId == null && other.gongDanId != null) || (this.gongDanId != null && !this.gongDanId.equals(other.gongDanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.GongDan[ gongDanId=" + gongDanId + " ]";
    }
    
}
