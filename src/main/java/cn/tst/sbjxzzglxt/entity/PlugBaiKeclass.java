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
@Table(name = "Plug_BaiKe_class")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlugBaiKeclass.findAll", query = "SELECT p FROM PlugBaiKeclass p")
    , @NamedQuery(name = "PlugBaiKeclass.findByCId", query = "SELECT p FROM PlugBaiKeclass p WHERE p.cId = :cId")
    , @NamedQuery(name = "PlugBaiKeclass.findByCClassName", query = "SELECT p FROM PlugBaiKeclass p WHERE p.cClassName = :cClassName")
    , @NamedQuery(name = "PlugBaiKeclass.findByCBeizhu", query = "SELECT p FROM PlugBaiKeclass p WHERE p.cBeizhu = :cBeizhu")
    , @NamedQuery(name = "PlugBaiKeclass.findByCOrder", query = "SELECT p FROM PlugBaiKeclass p WHERE p.cOrder = :cOrder")
    , @NamedQuery(name = "PlugBaiKeclass.findByInsRep", query = "SELECT p FROM PlugBaiKeclass p WHERE p.insRep = :insRep")
    , @NamedQuery(name = "PlugBaiKeclass.findByInsDate", query = "SELECT p FROM PlugBaiKeclass p WHERE p.insDate = :insDate")
    , @NamedQuery(name = "PlugBaiKeclass.findByUpdRep", query = "SELECT p FROM PlugBaiKeclass p WHERE p.updRep = :updRep")
    , @NamedQuery(name = "PlugBaiKeclass.findByUpdDate", query = "SELECT p FROM PlugBaiKeclass p WHERE p.updDate = :updDate")
    , @NamedQuery(name = "PlugBaiKeclass.findByDelFlg", query = "SELECT p FROM PlugBaiKeclass p WHERE p.delFlg = :delFlg")
    , @NamedQuery(name = "PlugBaiKeclass.findByVersion", query = "SELECT p FROM PlugBaiKeclass p WHERE p.version = :version")})
public class PlugBaiKeclass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_id")
    private Integer cId;
    @Size(max = 50)
    @Column(name = "c_ClassName")
    private String cClassName;
    @Size(max = 50)
    @Column(name = "c_Beizhu")
    private String cBeizhu;
    @Column(name = "c_Order")
    private Integer cOrder;
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

    public PlugBaiKeclass() {
    }

    public PlugBaiKeclass(Integer cId) {
        this.cId = cId;
    }

    public PlugBaiKeclass(Integer cId, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
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

    public String getCBeizhu() {
        return cBeizhu;
    }

    public void setCBeizhu(String cBeizhu) {
        this.cBeizhu = cBeizhu;
    }

    public Integer getCOrder() {
        return cOrder;
    }

    public void setCOrder(Integer cOrder) {
        this.cOrder = cOrder;
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
        if (!(object instanceof PlugBaiKeclass)) {
            return false;
        }
        PlugBaiKeclass other = (PlugBaiKeclass) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.PlugBaiKeclass[ cId=" + cId + " ]";
    }
    
}
