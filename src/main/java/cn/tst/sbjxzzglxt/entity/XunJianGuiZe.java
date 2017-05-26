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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "XunJianGuiZe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XunJianGuiZe.findAll", query = "SELECT x FROM XunJianGuiZe x")
    , @NamedQuery(name = "XunJianGuiZe.findById", query = "SELECT x FROM XunJianGuiZe x WHERE x.id = :id")
    , @NamedQuery(name = "XunJianGuiZe.findByRoleId", query = "SELECT x FROM XunJianGuiZe x WHERE x.roleId = :roleId")
    , @NamedQuery(name = "XunJianGuiZe.findByXunHuanFangShi", query = "SELECT x FROM XunJianGuiZe x WHERE x.xunHuanFangShi = :xunHuanFangShi")
    , @NamedQuery(name = "XunJianGuiZe.findByKaiShiShiJian", query = "SELECT x FROM XunJianGuiZe x WHERE x.kaiShiShiJian = :kaiShiShiJian")
    , @NamedQuery(name = "XunJianGuiZe.findByJieShuShiJian", query = "SELECT x FROM XunJianGuiZe x WHERE x.jieShuShiJian = :jieShuShiJian")
    , @NamedQuery(name = "XunJianGuiZe.findByInsRep", query = "SELECT x FROM XunJianGuiZe x WHERE x.insRep = :insRep")
    , @NamedQuery(name = "XunJianGuiZe.findByInsDate", query = "SELECT x FROM XunJianGuiZe x WHERE x.insDate = :insDate")
    , @NamedQuery(name = "XunJianGuiZe.findByUpdRep", query = "SELECT x FROM XunJianGuiZe x WHERE x.updRep = :updRep")
    , @NamedQuery(name = "XunJianGuiZe.findByUpdDate", query = "SELECT x FROM XunJianGuiZe x WHERE x.updDate = :updDate")
    , @NamedQuery(name = "XunJianGuiZe.findByDelFlg", query = "SELECT x FROM XunJianGuiZe x WHERE x.delFlg = :delFlg")
    , @NamedQuery(name = "XunJianGuiZe.findByVersion", query = "SELECT x FROM XunJianGuiZe x WHERE x.version = :version")})
public class XunJianGuiZe extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "roleId")
    private Integer roleId;
    @Column(name = "xunHuanFangShi")
    private Integer xunHuanFangShi;
    @Column(name = "kaiShiShiJian")
    @Temporal(TemporalType.TIMESTAMP)
    private Date kaiShiShiJian;
    @Column(name = "jieShuShiJian")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jieShuShiJian;

    public XunJianGuiZe() {
    }

    public XunJianGuiZe(Integer id) {
        this.id = id;
    }

    public XunJianGuiZe(Integer id, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
        this.id = id;
        this.insRep = insRep;
        this.insDate = insDate;
        this.updRep = updRep;
        this.updDate = updDate;
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getXunHuanFangShi() {
        return xunHuanFangShi;
    }

    public void setXunHuanFangShi(Integer xunHuanFangShi) {
        this.xunHuanFangShi = xunHuanFangShi;
    }

    public Date getKaiShiShiJian() {
        return kaiShiShiJian;
    }

    public void setKaiShiShiJian(Date kaiShiShiJian) {
        this.kaiShiShiJian = kaiShiShiJian;
    }

    public Date getJieShuShiJian() {
        return jieShuShiJian;
    }

    public void setJieShuShiJian(Date jieShuShiJian) {
        this.jieShuShiJian = jieShuShiJian;
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
        if (!(object instanceof XunJianGuiZe)) {
            return false;
        }
        XunJianGuiZe other = (XunJianGuiZe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.XunJianGuiZe[ id=" + id + " ]";
    }
}
