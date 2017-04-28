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
@Table(name = "Plug")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plug.findAll", query = "SELECT p FROM Plug p")
    , @NamedQuery(name = "Plug.findByPId", query = "SELECT p FROM Plug p WHERE p.pId = :pId")
    , @NamedQuery(name = "Plug.findByPNum", query = "SELECT p FROM Plug p WHERE p.pNum = :pNum")
    , @NamedQuery(name = "Plug.findByPName", query = "SELECT p FROM Plug p WHERE p.pName = :pName")
    , @NamedQuery(name = "Plug.findByPTitle", query = "SELECT p FROM Plug p WHERE p.pTitle = :pTitle")
    , @NamedQuery(name = "Plug.findByPInfo", query = "SELECT p FROM Plug p WHERE p.pInfo = :pInfo")
    , @NamedQuery(name = "Plug.findByPType", query = "SELECT p FROM Plug p WHERE p.pType = :pType")
    , @NamedQuery(name = "Plug.findByPApi", query = "SELECT p FROM Plug p WHERE p.pApi = :pApi")
    , @NamedQuery(name = "Plug.findByPAdminUrl", query = "SELECT p FROM Plug p WHERE p.pAdminUrl = :pAdminUrl")
    , @NamedQuery(name = "Plug.findByPAdminApi", query = "SELECT p FROM Plug p WHERE p.pAdminApi = :pAdminApi")
    , @NamedQuery(name = "Plug.findByPIsLock", query = "SELECT p FROM Plug p WHERE p.pIsLock = :pIsLock")
    , @NamedQuery(name = "Plug.findByPAuthor", query = "SELECT p FROM Plug p WHERE p.pAuthor = :pAuthor")
    , @NamedQuery(name = "Plug.findByPVersion", query = "SELECT p FROM Plug p WHERE p.pVersion = :pVersion")
    , @NamedQuery(name = "Plug.findByPHomeWeb", query = "SELECT p FROM Plug p WHERE p.pHomeWeb = :pHomeWeb")
    , @NamedQuery(name = "Plug.findByInsRep", query = "SELECT p FROM Plug p WHERE p.insRep = :insRep")
    , @NamedQuery(name = "Plug.findByInsDate", query = "SELECT p FROM Plug p WHERE p.insDate = :insDate")
    , @NamedQuery(name = "Plug.findByUpdRep", query = "SELECT p FROM Plug p WHERE p.updRep = :updRep")
    , @NamedQuery(name = "Plug.findByUpdDate", query = "SELECT p FROM Plug p WHERE p.updDate = :updDate")
    , @NamedQuery(name = "Plug.findByDelFlg", query = "SELECT p FROM Plug p WHERE p.delFlg = :delFlg")
    , @NamedQuery(name = "Plug.findByVersion", query = "SELECT p FROM Plug p WHERE p.version = :version")})
public class Plug implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "p_id")
    private Integer pId;
    @Column(name = "p_num")
    private Integer pNum;
    @Size(max = 50)
    @Column(name = "p_Name")
    private String pName;
    @Size(max = 50)
    @Column(name = "p_Title")
    private String pTitle;
    @Size(max = 50)
    @Column(name = "p_Info")
    private String pInfo;
    @Column(name = "p_Type")
    private Integer pType;
    @Size(max = 1073741823)
    @Column(name = "p_Api")
    private String pApi;
    @Size(max = 1073741823)
    @Column(name = "p_Admin_Url")
    private String pAdminUrl;
    @Size(max = 1073741823)
    @Column(name = "p_Admin_Api")
    private String pAdminApi;
    @Size(max = 50)
    @Column(name = "p_IsLock")
    private String pIsLock;
    @Size(max = 50)
    @Column(name = "p_Author")
    private String pAuthor;
    @Size(max = 50)
    @Column(name = "p_Version")
    private String pVersion;
    @Size(max = 1073741823)
    @Column(name = "p_HomeWeb")
    private String pHomeWeb;
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

    public Plug() {
    }

    public Plug(Integer pId) {
        this.pId = pId;
    }

    public Plug(Integer pId, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
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

    public Integer getPNum() {
        return pNum;
    }

    public void setPNum(Integer pNum) {
        this.pNum = pNum;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public String getPTitle() {
        return pTitle;
    }

    public void setPTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public String getPInfo() {
        return pInfo;
    }

    public void setPInfo(String pInfo) {
        this.pInfo = pInfo;
    }

    public Integer getPType() {
        return pType;
    }

    public void setPType(Integer pType) {
        this.pType = pType;
    }

    public String getPApi() {
        return pApi;
    }

    public void setPApi(String pApi) {
        this.pApi = pApi;
    }

    public String getPAdminUrl() {
        return pAdminUrl;
    }

    public void setPAdminUrl(String pAdminUrl) {
        this.pAdminUrl = pAdminUrl;
    }

    public String getPAdminApi() {
        return pAdminApi;
    }

    public void setPAdminApi(String pAdminApi) {
        this.pAdminApi = pAdminApi;
    }

    public String getPIsLock() {
        return pIsLock;
    }

    public void setPIsLock(String pIsLock) {
        this.pIsLock = pIsLock;
    }

    public String getPAuthor() {
        return pAuthor;
    }

    public void setPAuthor(String pAuthor) {
        this.pAuthor = pAuthor;
    }

    public String getPVersion() {
        return pVersion;
    }

    public void setPVersion(String pVersion) {
        this.pVersion = pVersion;
    }

    public String getPHomeWeb() {
        return pHomeWeb;
    }

    public void setPHomeWeb(String pHomeWeb) {
        this.pHomeWeb = pHomeWeb;
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
        if (!(object instanceof Plug)) {
            return false;
        }
        Plug other = (Plug) object;
        if ((this.pId == null && other.pId != null) || (this.pId != null && !this.pId.equals(other.pId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.Plug[ pId=" + pId + " ]";
    }
    
}
