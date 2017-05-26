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
 * @author Aaron-PC-i3-4130
 */
@Entity
@Table(name = "gu_zhang_shi_li")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GuZhangShiLi.findAll", query = "SELECT g FROM GuZhangShiLi g")
    , @NamedQuery(name = "GuZhangShiLi.findById", query = "SELECT g FROM GuZhangShiLi g WHERE g.id = :id")
    , @NamedQuery(name = "GuZhangShiLi.findByXiangMuId", query = "SELECT g FROM GuZhangShiLi g WHERE g.xiangMuId = :xiangMuId")
    , @NamedQuery(name = "GuZhangShiLi.findByGuZhangId", query = "SELECT g FROM GuZhangShiLi g WHERE g.guZhangId = :guZhangId")
    , @NamedQuery(name = "GuZhangShiLi.findByInsRep", query = "SELECT g FROM GuZhangShiLi g WHERE g.insRep = :insRep")
    , @NamedQuery(name = "GuZhangShiLi.findByInsDate", query = "SELECT g FROM GuZhangShiLi g WHERE g.insDate = :insDate")
    , @NamedQuery(name = "GuZhangShiLi.findByUpdRep", query = "SELECT g FROM GuZhangShiLi g WHERE g.updRep = :updRep")
    , @NamedQuery(name = "GuZhangShiLi.findByUpdDate", query = "SELECT g FROM GuZhangShiLi g WHERE g.updDate = :updDate")
    , @NamedQuery(name = "GuZhangShiLi.findByDelFlg", query = "SELECT g FROM GuZhangShiLi g WHERE g.delFlg = :delFlg")
    , @NamedQuery(name = "GuZhangShiLi.findByVersion", query = "SELECT g FROM GuZhangShiLi g WHERE g.version = :version")})
public class GuZhangShiLi extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xiang_mu_id")
    private int xiangMuId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gu_zhang_id")
    private int guZhangId;

    public GuZhangShiLi() {
    }

    public GuZhangShiLi(Long id) {
        this.id = id;
    }

    public GuZhangShiLi(Long id, int xiangMuId, int guZhangId, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
        this.id = id;
        this.xiangMuId = xiangMuId;
        this.guZhangId = guZhangId;
        this.insRep = insRep;
        this.insDate = insDate;
        this.updRep = updRep;
        this.updDate = updDate;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getXiangMuId() {
        return xiangMuId;
    }

    public void setXiangMuId(int xiangMuId) {
        this.xiangMuId = xiangMuId;
    }

    public int getGuZhangId() {
        return guZhangId;
    }

    public void setGuZhangId(int guZhangId) {
        this.guZhangId = guZhangId;
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
        if (!(object instanceof GuZhangShiLi)) {
            return false;
        }
        GuZhangShiLi other = (GuZhangShiLi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.GuZhangShiLi[ id=" + id + " ]";
    }
    
}
