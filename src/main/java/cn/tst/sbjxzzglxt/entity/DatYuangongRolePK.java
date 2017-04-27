package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 员工角色主键
 *
 * @author ps_xy@pscp.co.jp
 */
@Embeddable
public class DatYuangongRolePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "yuan_gong_id")
    private String yuanGongId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "role_id")
    private String roleId;

    public DatYuangongRolePK() {
    }

    public DatYuangongRolePK(String yuanGongId, String roleId) {
        this.yuanGongId = yuanGongId;
        this.roleId = roleId;
    }

    public String getYuanGongId() {
        return yuanGongId;
    }

    public void setYuanGongId(String yuanGongId) {
        this.yuanGongId = yuanGongId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (yuanGongId != null ? yuanGongId.hashCode() : 0);
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatYuangongRolePK)) {
            return false;
        }
        DatYuangongRolePK other = (DatYuangongRolePK) object;
        if ((this.yuanGongId == null && other.yuanGongId != null) || (this.yuanGongId != null && !this.yuanGongId.equals(other.yuanGongId))) {
            return false;
        }
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.pscp.material.materialmg.entity.DatYuangongRolePK[ yuanGongId=" + yuanGongId + ", roleId=" + roleId + " ]";
    }

}
