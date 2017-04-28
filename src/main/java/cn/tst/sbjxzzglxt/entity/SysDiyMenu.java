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
@Table(name = "sys_DiyMenu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysDiyMenu.findAll", query = "SELECT s FROM SysDiyMenu s")
    , @NamedQuery(name = "SysDiyMenu.findByPId", query = "SELECT s FROM SysDiyMenu s WHERE s.pId = :pId")
    , @NamedQuery(name = "SysDiyMenu.findByPTitle", query = "SELECT s FROM SysDiyMenu s WHERE s.pTitle = :pTitle")
    , @NamedQuery(name = "SysDiyMenu.findByPType", query = "SELECT s FROM SysDiyMenu s WHERE s.pType = :pType")
    , @NamedQuery(name = "SysDiyMenu.findByPMenuCode", query = "SELECT s FROM SysDiyMenu s WHERE s.pMenuCode = :pMenuCode")
    , @NamedQuery(name = "SysDiyMenu.findByPWxMenuID", query = "SELECT s FROM SysDiyMenu s WHERE s.pWxMenuID = :pWxMenuID")
    , @NamedQuery(name = "SysDiyMenu.findByPGroupId", query = "SELECT s FROM SysDiyMenu s WHERE s.pGroupId = :pGroupId")
    , @NamedQuery(name = "SysDiyMenu.findByPSex", query = "SELECT s FROM SysDiyMenu s WHERE s.pSex = :pSex")
    , @NamedQuery(name = "SysDiyMenu.findByPCountry", query = "SELECT s FROM SysDiyMenu s WHERE s.pCountry = :pCountry")
    , @NamedQuery(name = "SysDiyMenu.findByPProvince", query = "SELECT s FROM SysDiyMenu s WHERE s.pProvince = :pProvince")
    , @NamedQuery(name = "SysDiyMenu.findByPCity", query = "SELECT s FROM SysDiyMenu s WHERE s.pCity = :pCity")
    , @NamedQuery(name = "SysDiyMenu.findByPClientplatformtype", query = "SELECT s FROM SysDiyMenu s WHERE s.pClientplatformtype = :pClientplatformtype")
    , @NamedQuery(name = "SysDiyMenu.findByPIsPost", query = "SELECT s FROM SysDiyMenu s WHERE s.pIsPost = :pIsPost")
    , @NamedQuery(name = "SysDiyMenu.findByPAddtime", query = "SELECT s FROM SysDiyMenu s WHERE s.pAddtime = :pAddtime")
    , @NamedQuery(name = "SysDiyMenu.findByPTagId", query = "SELECT s FROM SysDiyMenu s WHERE s.pTagId = :pTagId")
    , @NamedQuery(name = "SysDiyMenu.findByInsRep", query = "SELECT s FROM SysDiyMenu s WHERE s.insRep = :insRep")
    , @NamedQuery(name = "SysDiyMenu.findByInsDate", query = "SELECT s FROM SysDiyMenu s WHERE s.insDate = :insDate")
    , @NamedQuery(name = "SysDiyMenu.findByUpdRep", query = "SELECT s FROM SysDiyMenu s WHERE s.updRep = :updRep")
    , @NamedQuery(name = "SysDiyMenu.findByUpdDate", query = "SELECT s FROM SysDiyMenu s WHERE s.updDate = :updDate")
    , @NamedQuery(name = "SysDiyMenu.findByDelFlg", query = "SELECT s FROM SysDiyMenu s WHERE s.delFlg = :delFlg")
    , @NamedQuery(name = "SysDiyMenu.findByVersion", query = "SELECT s FROM SysDiyMenu s WHERE s.version = :version")})
public class SysDiyMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "p_Id")
    private Integer pId;
    @Size(max = 255)
    @Column(name = "p_Title")
    private String pTitle;
    @Size(max = 255)
    @Column(name = "p_Type")
    private String pType;
    @Size(max = 1073741823)
    @Column(name = "p_MenuCode")
    private String pMenuCode;
    @Size(max = 255)
    @Column(name = "p_Wx_MenuID")
    private String pWxMenuID;
    @Size(max = 255)
    @Column(name = "p_Group_Id")
    private String pGroupId;
    @Size(max = 255)
    @Column(name = "p_Sex")
    private String pSex;
    @Size(max = 255)
    @Column(name = "p_Country")
    private String pCountry;
    @Size(max = 255)
    @Column(name = "p_Province")
    private String pProvince;
    @Size(max = 255)
    @Column(name = "p_City")
    private String pCity;
    @Size(max = 255)
    @Column(name = "p_Client_platform_type")
    private String pClientplatformtype;
    @Size(max = 255)
    @Column(name = "p_IsPost")
    private String pIsPost;
    @Column(name = "p_Addtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pAddtime;
    @Size(max = 255)
    @Column(name = "p_Tag_Id")
    private String pTagId;
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

    public SysDiyMenu() {
    }

    public SysDiyMenu(Integer pId) {
        this.pId = pId;
    }

    public SysDiyMenu(Integer pId, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
        this.pId = pId;
        this.insRep = insRep;
        this.insDate = insDate;
        this.updRep = updRep;
        this.updDate = updDate;
        this.delFlg = delFlg;
        this.version = version;
    }

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public String getPTitle() {
        return pTitle;
    }

    public void setPTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public String getPType() {
        return pType;
    }

    public void setPType(String pType) {
        this.pType = pType;
    }

    public String getPMenuCode() {
        return pMenuCode;
    }

    public void setPMenuCode(String pMenuCode) {
        this.pMenuCode = pMenuCode;
    }

    public String getPWxMenuID() {
        return pWxMenuID;
    }

    public void setPWxMenuID(String pWxMenuID) {
        this.pWxMenuID = pWxMenuID;
    }

    public String getPGroupId() {
        return pGroupId;
    }

    public void setPGroupId(String pGroupId) {
        this.pGroupId = pGroupId;
    }

    public String getPSex() {
        return pSex;
    }

    public void setPSex(String pSex) {
        this.pSex = pSex;
    }

    public String getPCountry() {
        return pCountry;
    }

    public void setPCountry(String pCountry) {
        this.pCountry = pCountry;
    }

    public String getPProvince() {
        return pProvince;
    }

    public void setPProvince(String pProvince) {
        this.pProvince = pProvince;
    }

    public String getPCity() {
        return pCity;
    }

    public void setPCity(String pCity) {
        this.pCity = pCity;
    }

    public String getPClientplatformtype() {
        return pClientplatformtype;
    }

    public void setPClientplatformtype(String pClientplatformtype) {
        this.pClientplatformtype = pClientplatformtype;
    }

    public String getPIsPost() {
        return pIsPost;
    }

    public void setPIsPost(String pIsPost) {
        this.pIsPost = pIsPost;
    }

    public Date getPAddtime() {
        return pAddtime;
    }

    public void setPAddtime(Date pAddtime) {
        this.pAddtime = pAddtime;
    }

    public String getPTagId() {
        return pTagId;
    }

    public void setPTagId(String pTagId) {
        this.pTagId = pTagId;
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
        hash += (pId != null ? pId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysDiyMenu)) {
            return false;
        }
        SysDiyMenu other = (SysDiyMenu) object;
        if ((this.pId == null && other.pId != null) || (this.pId != null && !this.pId.equals(other.pId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.SysDiyMenu[ pId=" + pId + " ]";
    }
    
}
