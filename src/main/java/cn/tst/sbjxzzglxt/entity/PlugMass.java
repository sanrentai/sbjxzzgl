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
@Table(name = "Plug_Mass")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlugMass.findAll", query = "SELECT p FROM PlugMass p")
    , @NamedQuery(name = "PlugMass.findByPId", query = "SELECT p FROM PlugMass p WHERE p.pId = :pId")
    , @NamedQuery(name = "PlugMass.findByPTitle", query = "SELECT p FROM PlugMass p WHERE p.pTitle = :pTitle")
    , @NamedQuery(name = "PlugMass.findByPIdList", query = "SELECT p FROM PlugMass p WHERE p.pIdList = :pIdList")
    , @NamedQuery(name = "PlugMass.findByPText", query = "SELECT p FROM PlugMass p WHERE p.pText = :pText")
    , @NamedQuery(name = "PlugMass.findByPType", query = "SELECT p FROM PlugMass p WHERE p.pType = :pType")
    , @NamedQuery(name = "PlugMass.findByPStatus", query = "SELECT p FROM PlugMass p WHERE p.pStatus = :pStatus")
    , @NamedQuery(name = "PlugMass.findByPAddtime", query = "SELECT p FROM PlugMass p WHERE p.pAddtime = :pAddtime")
    , @NamedQuery(name = "PlugMass.findByPpostTime", query = "SELECT p FROM PlugMass p WHERE p.ppostTime = :ppostTime")
    , @NamedQuery(name = "PlugMass.findByPpicMsgInfo", query = "SELECT p FROM PlugMass p WHERE p.ppicMsgInfo = :ppicMsgInfo")
    , @NamedQuery(name = "PlugMass.findByPPreOpenid", query = "SELECT p FROM PlugMass p WHERE p.pPreOpenid = :pPreOpenid")
    , @NamedQuery(name = "PlugMass.findByPUserGroup", query = "SELECT p FROM PlugMass p WHERE p.pUserGroup = :pUserGroup")
    , @NamedQuery(name = "PlugMass.findByPMediaid", query = "SELECT p FROM PlugMass p WHERE p.pMediaid = :pMediaid")
    , @NamedQuery(name = "PlugMass.findByInsRep", query = "SELECT p FROM PlugMass p WHERE p.insRep = :insRep")
    , @NamedQuery(name = "PlugMass.findByInsDate", query = "SELECT p FROM PlugMass p WHERE p.insDate = :insDate")
    , @NamedQuery(name = "PlugMass.findByUpdRep", query = "SELECT p FROM PlugMass p WHERE p.updRep = :updRep")
    , @NamedQuery(name = "PlugMass.findByUpdDate", query = "SELECT p FROM PlugMass p WHERE p.updDate = :updDate")
    , @NamedQuery(name = "PlugMass.findByDelFlg", query = "SELECT p FROM PlugMass p WHERE p.delFlg = :delFlg")
    , @NamedQuery(name = "PlugMass.findByVersion", query = "SELECT p FROM PlugMass p WHERE p.version = :version")})
public class PlugMass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "p_Id")
    private Integer pId;
    @Size(max = 255)
    @Column(name = "p_Title")
    private String pTitle;
    @Size(max = 1073741823)
    @Column(name = "p_IdList")
    private String pIdList;
    @Size(max = 1073741823)
    @Column(name = "p_text")
    private String pText;
    @Size(max = 50)
    @Column(name = "p_type")
    private String pType;
    @Size(max = 50)
    @Column(name = "p_status")
    private String pStatus;
    @Column(name = "p_Addtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pAddtime;
    @Column(name = "p_postTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ppostTime;
    @Size(max = 1073741823)
    @Column(name = "p_picMsgInfo")
    private String ppicMsgInfo;
    @Size(max = 50)
    @Column(name = "p_PreOpenid")
    private String pPreOpenid;
    @Column(name = "p_UserGroup")
    private Integer pUserGroup;
    @Size(max = 1073741823)
    @Column(name = "p_Media_id")
    private String pMediaid;
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

    public PlugMass() {
    }

    public PlugMass(Integer pId) {
        this.pId = pId;
    }

    public PlugMass(Integer pId, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
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

    public String getPIdList() {
        return pIdList;
    }

    public void setPIdList(String pIdList) {
        this.pIdList = pIdList;
    }

    public String getPText() {
        return pText;
    }

    public void setPText(String pText) {
        this.pText = pText;
    }

    public String getPType() {
        return pType;
    }

    public void setPType(String pType) {
        this.pType = pType;
    }

    public String getPStatus() {
        return pStatus;
    }

    public void setPStatus(String pStatus) {
        this.pStatus = pStatus;
    }

    public Date getPAddtime() {
        return pAddtime;
    }

    public void setPAddtime(Date pAddtime) {
        this.pAddtime = pAddtime;
    }

    public Date getPpostTime() {
        return ppostTime;
    }

    public void setPpostTime(Date ppostTime) {
        this.ppostTime = ppostTime;
    }

    public String getPpicMsgInfo() {
        return ppicMsgInfo;
    }

    public void setPpicMsgInfo(String ppicMsgInfo) {
        this.ppicMsgInfo = ppicMsgInfo;
    }

    public String getPPreOpenid() {
        return pPreOpenid;
    }

    public void setPPreOpenid(String pPreOpenid) {
        this.pPreOpenid = pPreOpenid;
    }

    public Integer getPUserGroup() {
        return pUserGroup;
    }

    public void setPUserGroup(Integer pUserGroup) {
        this.pUserGroup = pUserGroup;
    }

    public String getPMediaid() {
        return pMediaid;
    }

    public void setPMediaid(String pMediaid) {
        this.pMediaid = pMediaid;
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
        if (!(object instanceof PlugMass)) {
            return false;
        }
        PlugMass other = (PlugMass) object;
        if ((this.pId == null && other.pId != null) || (this.pId != null && !this.pId.equals(other.pId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.PlugMass[ pId=" + pId + " ]";
    }
    
}
