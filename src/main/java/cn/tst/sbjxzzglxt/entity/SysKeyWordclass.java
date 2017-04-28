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
@Table(name = "sys_KeyWord_class")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysKeyWordclass.findAll", query = "SELECT s FROM SysKeyWordclass s")
    , @NamedQuery(name = "SysKeyWordclass.findByCId", query = "SELECT s FROM SysKeyWordclass s WHERE s.cId = :cId")
    , @NamedQuery(name = "SysKeyWordclass.findByCClassName", query = "SELECT s FROM SysKeyWordclass s WHERE s.cClassName = :cClassName")
    , @NamedQuery(name = "SysKeyWordclass.findByInsRep", query = "SELECT s FROM SysKeyWordclass s WHERE s.insRep = :insRep")
    , @NamedQuery(name = "SysKeyWordclass.findByInsDate", query = "SELECT s FROM SysKeyWordclass s WHERE s.insDate = :insDate")
    , @NamedQuery(name = "SysKeyWordclass.findByUpdRep", query = "SELECT s FROM SysKeyWordclass s WHERE s.updRep = :updRep")
    , @NamedQuery(name = "SysKeyWordclass.findByUpdDate", query = "SELECT s FROM SysKeyWordclass s WHERE s.updDate = :updDate")
    , @NamedQuery(name = "SysKeyWordclass.findByDelFlg", query = "SELECT s FROM SysKeyWordclass s WHERE s.delFlg = :delFlg")
    , @NamedQuery(name = "SysKeyWordclass.findByVersion", query = "SELECT s FROM SysKeyWordclass s WHERE s.version = :version")})
public class SysKeyWordclass implements Serializable {

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

    public SysKeyWordclass() {
    }

    public SysKeyWordclass(Integer cId) {
        this.cId = cId;
    }

    public SysKeyWordclass(Integer cId, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
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
        if (!(object instanceof SysKeyWordclass)) {
            return false;
        }
        SysKeyWordclass other = (SysKeyWordclass) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.SysKeyWordclass[ cId=" + cId + " ]";
    }
    
}
