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
@Table(name = "Plug_PicMsgList")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlugPicMsgList.findAll", query = "SELECT p FROM PlugPicMsgList p")
    , @NamedQuery(name = "PlugPicMsgList.findByPId", query = "SELECT p FROM PlugPicMsgList p WHERE p.pId = :pId")
    , @NamedQuery(name = "PlugPicMsgList.findByPTitle", query = "SELECT p FROM PlugPicMsgList p WHERE p.pTitle = :pTitle")
    , @NamedQuery(name = "PlugPicMsgList.findByPIdList", query = "SELECT p FROM PlugPicMsgList p WHERE p.pIdList = :pIdList")
    , @NamedQuery(name = "PlugPicMsgList.findByPAddtime", query = "SELECT p FROM PlugPicMsgList p WHERE p.pAddtime = :pAddtime")
    , @NamedQuery(name = "PlugPicMsgList.findByInsRep", query = "SELECT p FROM PlugPicMsgList p WHERE p.insRep = :insRep")
    , @NamedQuery(name = "PlugPicMsgList.findByInsDate", query = "SELECT p FROM PlugPicMsgList p WHERE p.insDate = :insDate")
    , @NamedQuery(name = "PlugPicMsgList.findByUpdRep", query = "SELECT p FROM PlugPicMsgList p WHERE p.updRep = :updRep")
    , @NamedQuery(name = "PlugPicMsgList.findByUpdDate", query = "SELECT p FROM PlugPicMsgList p WHERE p.updDate = :updDate")
    , @NamedQuery(name = "PlugPicMsgList.findByDelFlg", query = "SELECT p FROM PlugPicMsgList p WHERE p.delFlg = :delFlg")
    , @NamedQuery(name = "PlugPicMsgList.findByVersion", query = "SELECT p FROM PlugPicMsgList p WHERE p.version = :version")})
public class PlugPicMsgList implements Serializable {

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
    @Column(name = "p_Addtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pAddtime;
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

    public PlugPicMsgList() {
    }

    public PlugPicMsgList(Integer pId) {
        this.pId = pId;
    }

    public PlugPicMsgList(Integer pId, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
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

    public Date getPAddtime() {
        return pAddtime;
    }

    public void setPAddtime(Date pAddtime) {
        this.pAddtime = pAddtime;
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
        if (!(object instanceof PlugPicMsgList)) {
            return false;
        }
        PlugPicMsgList other = (PlugPicMsgList) object;
        if ((this.pId == null && other.pId != null) || (this.pId != null && !this.pId.equals(other.pId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.PlugPicMsgList[ pId=" + pId + " ]";
    }
    
}
