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
 * @author Administrator
 */
@Entity
@Table(name = "mst_xun_jian_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstXunJianRole.findAll", query = "SELECT m FROM MstXunJianRole m")
    , @NamedQuery(name = "MstXunJianRole.findByRoleId", query = "SELECT m FROM MstXunJianRole m WHERE m.roleId = :roleId")
    , @NamedQuery(name = "MstXunJianRole.findByRoleName", query = "SELECT m FROM MstXunJianRole m WHERE m.roleName = :roleName")
    , @NamedQuery(name = "MstXunJianRole.findByRoleDescription", query = "SELECT m FROM MstXunJianRole m WHERE m.roleDescription = :roleDescription")
    , @NamedQuery(name = "MstXunJianRole.findByInsRep", query = "SELECT m FROM MstXunJianRole m WHERE m.insRep = :insRep")
    , @NamedQuery(name = "MstXunJianRole.findByInsDate", query = "SELECT m FROM MstXunJianRole m WHERE m.insDate = :insDate")
    , @NamedQuery(name = "MstXunJianRole.findByUpdRep", query = "SELECT m FROM MstXunJianRole m WHERE m.updRep = :updRep")
    , @NamedQuery(name = "MstXunJianRole.findByUpdDate", query = "SELECT m FROM MstXunJianRole m WHERE m.updDate = :updDate")
    , @NamedQuery(name = "MstXunJianRole.findByDelFlg", query = "SELECT m FROM MstXunJianRole m WHERE m.delFlg = :delFlg")
    , @NamedQuery(name = "MstXunJianRole.findByVersion", query = "SELECT m FROM MstXunJianRole m WHERE m.version = :version")})
public class MstXunJianRole extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "role_name")
    private String roleName;
    @Size(max = 400)
    @Column(name = "role_description")
    private String roleDescription;

    public MstXunJianRole() {
    }

    public MstXunJianRole(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstXunJianRole)) {
            return false;
        }
        MstXunJianRole other = (MstXunJianRole) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.MstXunJianRole[ roleId=" + roleId + " ]";
    }
}
