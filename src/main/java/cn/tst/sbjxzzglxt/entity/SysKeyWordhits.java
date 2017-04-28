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
@Table(name = "sys_KeyWord_hits")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysKeyWordhits.findAll", query = "SELECT s FROM SysKeyWordhits s")
    , @NamedQuery(name = "SysKeyWordhits.findById", query = "SELECT s FROM SysKeyWordhits s WHERE s.id = :id")
    , @NamedQuery(name = "SysKeyWordhits.findByKId", query = "SELECT s FROM SysKeyWordhits s WHERE s.kId = :kId")
    , @NamedQuery(name = "SysKeyWordhits.findByOpenID", query = "SELECT s FROM SysKeyWordhits s WHERE s.openID = :openID")
    , @NamedQuery(name = "SysKeyWordhits.findByAddtime", query = "SELECT s FROM SysKeyWordhits s WHERE s.addtime = :addtime")
    , @NamedQuery(name = "SysKeyWordhits.findByInsRep", query = "SELECT s FROM SysKeyWordhits s WHERE s.insRep = :insRep")
    , @NamedQuery(name = "SysKeyWordhits.findByInsDate", query = "SELECT s FROM SysKeyWordhits s WHERE s.insDate = :insDate")
    , @NamedQuery(name = "SysKeyWordhits.findByUpdRep", query = "SELECT s FROM SysKeyWordhits s WHERE s.updRep = :updRep")
    , @NamedQuery(name = "SysKeyWordhits.findByUpdDate", query = "SELECT s FROM SysKeyWordhits s WHERE s.updDate = :updDate")
    , @NamedQuery(name = "SysKeyWordhits.findByDelFlg", query = "SELECT s FROM SysKeyWordhits s WHERE s.delFlg = :delFlg")
    , @NamedQuery(name = "SysKeyWordhits.findByVersion", query = "SELECT s FROM SysKeyWordhits s WHERE s.version = :version")})
public class SysKeyWordhits implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "k_id")
    private Integer kId;
    @Size(max = 255)
    @Column(name = "OpenID")
    private String openID;
    @Column(name = "addtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addtime;
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

    public SysKeyWordhits() {
    }

    public SysKeyWordhits(Integer id) {
        this.id = id;
    }

    public SysKeyWordhits(Integer id, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
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

    public Integer getKId() {
        return kId;
    }

    public void setKId(Integer kId) {
        this.kId = kId;
    }

    public String getOpenID() {
        return openID;
    }

    public void setOpenID(String openID) {
        this.openID = openID;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
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
        if (!(object instanceof SysKeyWordhits)) {
            return false;
        }
        SysKeyWordhits other = (SysKeyWordhits) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.SysKeyWordhits[ id=" + id + " ]";
    }
    
}
