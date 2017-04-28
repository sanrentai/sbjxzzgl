/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
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
 * @author Administrator
 */
@Entity
@Table(name = "sys_Config")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysConfig.findAll", query = "SELECT s FROM SysConfig s")
    , @NamedQuery(name = "SysConfig.findById", query = "SELECT s FROM SysConfig s WHERE s.id = :id")
    , @NamedQuery(name = "SysConfig.findByWeiXinName", query = "SELECT s FROM SysConfig s WHERE s.weiXinName = :weiXinName")
    , @NamedQuery(name = "SysConfig.findByOpenName", query = "SELECT s FROM SysConfig s WHERE s.openName = :openName")
    , @NamedQuery(name = "SysConfig.findByWeiXinOpenID", query = "SELECT s FROM SysConfig s WHERE s.weiXinOpenID = :weiXinOpenID")
    , @NamedQuery(name = "SysConfig.findByWeiXinType", query = "SELECT s FROM SysConfig s WHERE s.weiXinType = :weiXinType")
    , @NamedQuery(name = "SysConfig.findByWeixinAvatar", query = "SELECT s FROM SysConfig s WHERE s.weixinAvatar = :weixinAvatar")
    , @NamedQuery(name = "SysConfig.findByVerify", query = "SELECT s FROM SysConfig s WHERE s.verify = :verify")
    , @NamedQuery(name = "SysConfig.findByAppId", query = "SELECT s FROM SysConfig s WHERE s.appId = :appId")
    , @NamedQuery(name = "SysConfig.findByAppsecret", query = "SELECT s FROM SysConfig s WHERE s.appsecret = :appsecret")
    , @NamedQuery(name = "SysConfig.findByToken", query = "SELECT s FROM SysConfig s WHERE s.token = :token")
    , @NamedQuery(name = "SysConfig.findByAccesstoken", query = "SELECT s FROM SysConfig s WHERE s.accesstoken = :accesstoken")
    , @NamedQuery(name = "SysConfig.findByMchId", query = "SELECT s FROM SysConfig s WHERE s.mchId = :mchId")
    , @NamedQuery(name = "SysConfig.findByApiKey", query = "SELECT s FROM SysConfig s WHERE s.apiKey = :apiKey")
    , @NamedQuery(name = "SysConfig.findByTokenTime", query = "SELECT s FROM SysConfig s WHERE s.tokenTime = :tokenTime")
    , @NamedQuery(name = "SysConfig.findByJsapiTicket", query = "SELECT s FROM SysConfig s WHERE s.jsapiTicket = :jsapiTicket")
    , @NamedQuery(name = "SysConfig.findByTicketTime", query = "SELECT s FROM SysConfig s WHERE s.ticketTime = :ticketTime")
    , @NamedQuery(name = "SysConfig.findByExpiresIn", query = "SELECT s FROM SysConfig s WHERE s.expiresIn = :expiresIn")
    , @NamedQuery(name = "SysConfig.findByDiyMenu", query = "SELECT s FROM SysConfig s WHERE s.diyMenu = :diyMenu")
    , @NamedQuery(name = "SysConfig.findByAlipayPartner", query = "SELECT s FROM SysConfig s WHERE s.alipayPartner = :alipayPartner")
    , @NamedQuery(name = "SysConfig.findByAlipaySeller", query = "SELECT s FROM SysConfig s WHERE s.alipaySeller = :alipaySeller")
    , @NamedQuery(name = "SysConfig.findByAlipayKey", query = "SELECT s FROM SysConfig s WHERE s.alipayKey = :alipayKey")
    , @NamedQuery(name = "SysConfig.findByInsRep", query = "SELECT s FROM SysConfig s WHERE s.insRep = :insRep")
    , @NamedQuery(name = "SysConfig.findByInsDate", query = "SELECT s FROM SysConfig s WHERE s.insDate = :insDate")
    , @NamedQuery(name = "SysConfig.findByUpdRep", query = "SELECT s FROM SysConfig s WHERE s.updRep = :updRep")
    , @NamedQuery(name = "SysConfig.findByUpdDate", query = "SELECT s FROM SysConfig s WHERE s.updDate = :updDate")
    , @NamedQuery(name = "SysConfig.findByDelFlg", query = "SELECT s FROM SysConfig s WHERE s.delFlg = :delFlg")
    , @NamedQuery(name = "SysConfig.findByVersion", query = "SELECT s FROM SysConfig s WHERE s.version = :version")})
public class SysConfig implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "WeiXinName")
    private String weiXinName;
    @Size(max = 50)
    @Column(name = "OpenName")
    private String openName;
    @Size(max = 50)
    @Column(name = "WeiXinOpenID")
    private String weiXinOpenID;
    @Size(max = 50)
    @Column(name = "WeiXinType")
    private String weiXinType;
    @Size(max = 1073741823)
    @Column(name = "WeixinAvatar")
    private String weixinAvatar;
    @Size(max = 50)
    @Column(name = "Verify")
    private String verify;
    @Size(max = 255)
    @Column(name = "AppId")
    private String appId;
    @Size(max = 1073741823)
    @Column(name = "Appsecret")
    private String appsecret;
    @Size(max = 1073741823)
    @Column(name = "Token")
    private String token;
    @Size(max = 1073741823)
    @Column(name = "Access_token")
    private String accesstoken;
    @Size(max = 50)
    @Column(name = "mch_id")
    private String mchId;
    @Size(max = 50)
    @Column(name = "ApiKey")
    private String apiKey;
    @Column(name = "Token_Time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tokenTime;
    @Size(max = 1073741823)
    @Column(name = "Jsapi_Ticket")
    private String jsapiTicket;
    @Column(name = "Ticket_Time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ticketTime;
    @Column(name = "Expires_In")
    private Integer expiresIn;
    @Size(max = 1073741823)
    @Column(name = "diyMenu")
    private String diyMenu;
    @Size(max = 50)
    @Column(name = "alipay_partner")
    private String alipayPartner;
    @Size(max = 50)
    @Column(name = "alipay_seller")
    private String alipaySeller;
    @Size(max = 50)
    @Column(name = "alipay_key")
    private String alipayKey;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ins_rep")
    private String insRep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ins_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "upd_rep")
    private String updRep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "upd_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "del_flg")
    private Character delFlg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private int version;

    public SysConfig() {
    }

    public SysConfig(Integer id) {
        this.id = id;
    }

    public SysConfig(Integer id, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
        this.id = id;
        this.insRep = insRep;
        this.insDate = insDate;
        this.updRep = updRep;
        this.updDate = updDate;
        this.delFlg = delFlg;
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWeiXinName() {
        return weiXinName;
    }

    public void setWeiXinName(String weiXinName) {
        this.weiXinName = weiXinName;
    }

    public String getOpenName() {
        return openName;
    }

    public void setOpenName(String openName) {
        this.openName = openName;
    }

    public String getWeiXinOpenID() {
        return weiXinOpenID;
    }

    public void setWeiXinOpenID(String weiXinOpenID) {
        this.weiXinOpenID = weiXinOpenID;
    }

    public String getWeiXinType() {
        return weiXinType;
    }

    public void setWeiXinType(String weiXinType) {
        this.weiXinType = weiXinType;
    }

    public String getWeixinAvatar() {
        return weixinAvatar;
    }

    public void setWeixinAvatar(String weixinAvatar) {
        this.weixinAvatar = weixinAvatar;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Date getTokenTime() {
        return tokenTime;
    }

    public void setTokenTime(Date tokenTime) {
        this.tokenTime = tokenTime;
    }

    public String getJsapiTicket() {
        return jsapiTicket;
    }

    public void setJsapiTicket(String jsapiTicket) {
        this.jsapiTicket = jsapiTicket;
    }

    public Date getTicketTime() {
        return ticketTime;
    }

    public void setTicketTime(Date ticketTime) {
        this.ticketTime = ticketTime;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getDiyMenu() {
        return diyMenu;
    }

    public void setDiyMenu(String diyMenu) {
        this.diyMenu = diyMenu;
    }

    public String getAlipayPartner() {
        return alipayPartner;
    }

    public void setAlipayPartner(String alipayPartner) {
        this.alipayPartner = alipayPartner;
    }

    public String getAlipaySeller() {
        return alipaySeller;
    }

    public void setAlipaySeller(String alipaySeller) {
        this.alipaySeller = alipaySeller;
    }

    public String getAlipayKey() {
        return alipayKey;
    }

    public void setAlipayKey(String alipayKey) {
        this.alipayKey = alipayKey;
    }

    public String getInsRep() {
        return insRep;
    }

    public void setInsRep(String insRep) {
        this.insRep = insRep;
    }

    public Date getInsDate() {
        return insDate;
    }

    public void setInsDate(Date insDate) {
        this.insDate = insDate;
    }

    public String getUpdRep() {
        return updRep;
    }

    public void setUpdRep(String updRep) {
        this.updRep = updRep;
    }

    public Date getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Date updDate) {
        this.updDate = updDate;
    }

    public Character getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Character delFlg) {
        this.delFlg = delFlg;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysConfig)) {
            return false;
        }
        SysConfig other = (SysConfig) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.SysConfig[ id=" + id + " ]";
    }
    
}
