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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "dat_xun_jian_fan_wei")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatXunJianFanWei.findAll", query = "SELECT d FROM DatXunJianFanWei d")
    , @NamedQuery(name = "DatXunJianFanWei.findByRoleId", query = "SELECT d FROM DatXunJianFanWei d WHERE d.datXunJianFanWeiPK.roleId = :roleId")
    , @NamedQuery(name = "DatXunJianFanWei.findByXunJianDianId", query = "SELECT d FROM DatXunJianFanWei d WHERE d.datXunJianFanWeiPK.xunJianDianId = :xunJianDianId")
    , @NamedQuery(name = "DatXunJianFanWei.findByInsRep", query = "SELECT d FROM DatXunJianFanWei d WHERE d.insRep = :insRep")
    , @NamedQuery(name = "DatXunJianFanWei.findByInsDate", query = "SELECT d FROM DatXunJianFanWei d WHERE d.insDate = :insDate")
    , @NamedQuery(name = "DatXunJianFanWei.findByUpdRep", query = "SELECT d FROM DatXunJianFanWei d WHERE d.updRep = :updRep")
    , @NamedQuery(name = "DatXunJianFanWei.findByUpdDate", query = "SELECT d FROM DatXunJianFanWei d WHERE d.updDate = :updDate")
    , @NamedQuery(name = "DatXunJianFanWei.findByDelFlg", query = "SELECT d FROM DatXunJianFanWei d WHERE d.delFlg = :delFlg")
    , @NamedQuery(name = "DatXunJianFanWei.findByVersion", query = "SELECT d FROM DatXunJianFanWei d WHERE d.version = :version")})
public class DatXunJianFanWei implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DatXunJianFanWeiPK datXunJianFanWeiPK;
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

    public DatXunJianFanWei() {
    }

    public DatXunJianFanWei(DatXunJianFanWeiPK datXunJianFanWeiPK) {
        this.datXunJianFanWeiPK = datXunJianFanWeiPK;
    }

    public DatXunJianFanWei(DatXunJianFanWeiPK datXunJianFanWeiPK, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
        this.datXunJianFanWeiPK = datXunJianFanWeiPK;
        this.insRep = insRep;
        this.insDate = insDate;
        this.updRep = updRep;
        this.updDate = updDate;
        this.delFlg = delFlg;
        this.version = version;
    }

    public DatXunJianFanWei(int roleId, int xunJianDianId) {
        this.datXunJianFanWeiPK = new DatXunJianFanWeiPK(roleId, xunJianDianId);
    }

    public DatXunJianFanWeiPK getDatXunJianFanWeiPK() {
        return datXunJianFanWeiPK;
    }

    public void setDatXunJianFanWeiPK(DatXunJianFanWeiPK datXunJianFanWeiPK) {
        this.datXunJianFanWeiPK = datXunJianFanWeiPK;
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
        hash += (datXunJianFanWeiPK != null ? datXunJianFanWeiPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatXunJianFanWei)) {
            return false;
        }
        DatXunJianFanWei other = (DatXunJianFanWei) object;
        if ((this.datXunJianFanWeiPK == null && other.datXunJianFanWeiPK != null) || (this.datXunJianFanWeiPK != null && !this.datXunJianFanWeiPK.equals(other.datXunJianFanWeiPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.DatXunJianFanWei[ datXunJianFanWeiPK=" + datXunJianFanWeiPK + " ]";
    }
    
}
