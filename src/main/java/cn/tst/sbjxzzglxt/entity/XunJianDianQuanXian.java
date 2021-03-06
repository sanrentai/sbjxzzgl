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
@Table(name = "XunJianDianQuanXian")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XunJianDianQuanXian.findAll", query = "SELECT x FROM XunJianDianQuanXian x WHERE x.delFlg=:delFlg")
    , @NamedQuery(name = "XunJianDianQuanXian.findById", query = "SELECT x FROM XunJianDianQuanXian x WHERE x.id = :id AND x.delFlg=:delFlg")
    , @NamedQuery(name = "XunJianDianQuanXian.findByRoleId", query = "SELECT x FROM XunJianDianQuanXian x WHERE x.roleId = :roleId AND x.delFlg=:delFlg")
    , @NamedQuery(name = "XunJianDianQuanXian.findByCheckPointId", query = "SELECT x FROM XunJianDianQuanXian x WHERE x.checkPointId = :checkPointId AND x.delFlg=:delFlg")
    , @NamedQuery(name = "XunJianDianQuanXian.findByInsRep", query = "SELECT x FROM XunJianDianQuanXian x WHERE x.insRep = :insRep AND x.delFlg=:delFlg")
    , @NamedQuery(name = "XunJianDianQuanXian.findByInsDate", query = "SELECT x FROM XunJianDianQuanXian x WHERE x.insDate = :insDate AND x.delFlg=:delFlg")
    , @NamedQuery(name = "XunJianDianQuanXian.findByUpdRep", query = "SELECT x FROM XunJianDianQuanXian x WHERE x.updRep = :updRep AND x.delFlg=:delFlg")
    , @NamedQuery(name = "XunJianDianQuanXian.findByUpdDate", query = "SELECT x FROM XunJianDianQuanXian x WHERE x.updDate = :updDate AND x.delFlg=:delFlg")
    , @NamedQuery(name = "XunJianDianQuanXian.findByDelFlg", query = "SELECT x FROM XunJianDianQuanXian x WHERE x.delFlg = :delFlg")
    , @NamedQuery(name = "XunJianDianQuanXian.findByVersion", query = "SELECT x FROM XunJianDianQuanXian x WHERE x.version = :version AND x.delFlg=:delFlg")})
public class XunJianDianQuanXian extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "roleId")
    private int roleId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "checkPointId")
    private int checkPointId;

    public XunJianDianQuanXian() {
    }

    public XunJianDianQuanXian(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getCheckPointId() {
        return checkPointId;
    }

    public void setCheckPointId(int checkPointId) {
        this.checkPointId = checkPointId;
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
        if (!(object instanceof XunJianDianQuanXian)) {
            return false;
        }
        XunJianDianQuanXian other = (XunJianDianQuanXian) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.XunJianDianQuanXian[ id=" + id + " ]";
    }
}
