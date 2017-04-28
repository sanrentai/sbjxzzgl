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
@Table(name = "Plug_PicMsg_class")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlugPicMsgclass.findAll", query = "SELECT p FROM PlugPicMsgclass p")
    , @NamedQuery(name = "PlugPicMsgclass.findByCId", query = "SELECT p FROM PlugPicMsgclass p WHERE p.cId = :cId")
    , @NamedQuery(name = "PlugPicMsgclass.findByCClassName", query = "SELECT p FROM PlugPicMsgclass p WHERE p.cClassName = :cClassName")
    , @NamedQuery(name = "PlugPicMsgclass.findByInsRep", query = "SELECT p FROM PlugPicMsgclass p WHERE p.insRep = :insRep")
    , @NamedQuery(name = "PlugPicMsgclass.findByInsDate", query = "SELECT p FROM PlugPicMsgclass p WHERE p.insDate = :insDate")
    , @NamedQuery(name = "PlugPicMsgclass.findByUpdRep", query = "SELECT p FROM PlugPicMsgclass p WHERE p.updRep = :updRep")
    , @NamedQuery(name = "PlugPicMsgclass.findByUpdDate", query = "SELECT p FROM PlugPicMsgclass p WHERE p.updDate = :updDate")
    , @NamedQuery(name = "PlugPicMsgclass.findByDelFlg", query = "SELECT p FROM PlugPicMsgclass p WHERE p.delFlg = :delFlg")
    , @NamedQuery(name = "PlugPicMsgclass.findByVersion", query = "SELECT p FROM PlugPicMsgclass p WHERE p.version = :version")})
public class PlugPicMsgclass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_id")
    private Integer cId;
    @Size(max = 50)
    @Column(name = "c_ClassName")
    private String cClassName;
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

    public PlugPicMsgclass() {
    }

    public PlugPicMsgclass(Integer cId) {
        this.cId = cId;
    }

    public PlugPicMsgclass(Integer cId, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
        this.cId = cId;
        this.insRep = insRep;
        this.insDate = insDate;
        this.updRep = updRep;
        this.updDate = updDate;
        this.delFlg = delFlg;
        this.version = version;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getCClassName() {
        return cClassName;
    }

    public void setCClassName(String cClassName) {
        this.cClassName = cClassName;
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
        hash += (cId != null ? cId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlugPicMsgclass)) {
            return false;
        }
        PlugPicMsgclass other = (PlugPicMsgclass) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.PlugPicMsgclass[ cId=" + cId + " ]";
    }
    
}
