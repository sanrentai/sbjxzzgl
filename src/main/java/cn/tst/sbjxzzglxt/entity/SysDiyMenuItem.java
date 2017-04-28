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
@Table(name = "sys_DiyMenu_Item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysDiyMenuItem.findAll", query = "SELECT s FROM SysDiyMenuItem s")
    , @NamedQuery(name = "SysDiyMenuItem.findByPId", query = "SELECT s FROM SysDiyMenuItem s WHERE s.pId = :pId")
    , @NamedQuery(name = "SysDiyMenuItem.findByPDiyMenuID", query = "SELECT s FROM SysDiyMenuItem s WHERE s.pDiyMenuID = :pDiyMenuID")
    , @NamedQuery(name = "SysDiyMenuItem.findByPTitle", query = "SELECT s FROM SysDiyMenuItem s WHERE s.pTitle = :pTitle")
    , @NamedQuery(name = "SysDiyMenuItem.findByPFid", query = "SELECT s FROM SysDiyMenuItem s WHERE s.pFid = :pFid")
    , @NamedQuery(name = "SysDiyMenuItem.findByPType", query = "SELECT s FROM SysDiyMenuItem s WHERE s.pType = :pType")
    , @NamedQuery(name = "SysDiyMenuItem.findByPKeyword", query = "SELECT s FROM SysDiyMenuItem s WHERE s.pKeyword = :pKeyword")
    , @NamedQuery(name = "SysDiyMenuItem.findByPUrl", query = "SELECT s FROM SysDiyMenuItem s WHERE s.pUrl = :pUrl")
    , @NamedQuery(name = "SysDiyMenuItem.findByPNum", query = "SELECT s FROM SysDiyMenuItem s WHERE s.pNum = :pNum")
    , @NamedQuery(name = "SysDiyMenuItem.findByInsRep", query = "SELECT s FROM SysDiyMenuItem s WHERE s.insRep = :insRep")
    , @NamedQuery(name = "SysDiyMenuItem.findByInsDate", query = "SELECT s FROM SysDiyMenuItem s WHERE s.insDate = :insDate")
    , @NamedQuery(name = "SysDiyMenuItem.findByUpdRep", query = "SELECT s FROM SysDiyMenuItem s WHERE s.updRep = :updRep")
    , @NamedQuery(name = "SysDiyMenuItem.findByUpdDate", query = "SELECT s FROM SysDiyMenuItem s WHERE s.updDate = :updDate")
    , @NamedQuery(name = "SysDiyMenuItem.findByDelFlg", query = "SELECT s FROM SysDiyMenuItem s WHERE s.delFlg = :delFlg")
    , @NamedQuery(name = "SysDiyMenuItem.findByVersion", query = "SELECT s FROM SysDiyMenuItem s WHERE s.version = :version")})
public class SysDiyMenuItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "p_Id")
    private Integer pId;
    @Column(name = "p_DiyMenuID")
    private Integer pDiyMenuID;
    @Size(max = 255)
    @Column(name = "p_Title")
    private String pTitle;
    @Column(name = "p_Fid")
    private Integer pFid;
    @Size(max = 255)
    @Column(name = "p_Type")
    private String pType;
    @Size(max = 255)
    @Column(name = "p_Keyword")
    private String pKeyword;
    @Size(max = 1073741823)
    @Column(name = "p_Url")
    private String pUrl;
    @Column(name = "p_Num")
    private Integer pNum;
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

    public SysDiyMenuItem() {
    }

    public SysDiyMenuItem(Integer pId) {
        this.pId = pId;
    }

    public SysDiyMenuItem(Integer pId, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
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

    public Integer getPDiyMenuID() {
        return pDiyMenuID;
    }

    public void setPDiyMenuID(Integer pDiyMenuID) {
        this.pDiyMenuID = pDiyMenuID;
    }

    public String getPTitle() {
        return pTitle;
    }

    public void setPTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public Integer getPFid() {
        return pFid;
    }

    public void setPFid(Integer pFid) {
        this.pFid = pFid;
    }

    public String getPType() {
        return pType;
    }

    public void setPType(String pType) {
        this.pType = pType;
    }

    public String getPKeyword() {
        return pKeyword;
    }

    public void setPKeyword(String pKeyword) {
        this.pKeyword = pKeyword;
    }

    public String getPUrl() {
        return pUrl;
    }

    public void setPUrl(String pUrl) {
        this.pUrl = pUrl;
    }

    public Integer getPNum() {
        return pNum;
    }

    public void setPNum(Integer pNum) {
        this.pNum = pNum;
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
        if (!(object instanceof SysDiyMenuItem)) {
            return false;
        }
        SysDiyMenuItem other = (SysDiyMenuItem) object;
        if ((this.pId == null && other.pId != null) || (this.pId != null && !this.pId.equals(other.pId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.SysDiyMenuItem[ pId=" + pId + " ]";
    }
    
}
