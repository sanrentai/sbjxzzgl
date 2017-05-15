/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Administrator
 */
@Embeddable
public class DatXunJianFanWeiPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "role_id")
    private int roleId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xun_jian_dian_id")
    private int xunJianDianId;

    public DatXunJianFanWeiPK() {
    }

    public DatXunJianFanWeiPK(int roleId, int xunJianDianId) {
        this.roleId = roleId;
        this.xunJianDianId = xunJianDianId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getXunJianDianId() {
        return xunJianDianId;
    }

    public void setXunJianDianId(int xunJianDianId) {
        this.xunJianDianId = xunJianDianId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) roleId;
        hash += (int) xunJianDianId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatXunJianFanWeiPK)) {
            return false;
        }
        DatXunJianFanWeiPK other = (DatXunJianFanWeiPK) object;
        if (this.roleId != other.roleId) {
            return false;
        }
        if (this.xunJianDianId != other.xunJianDianId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.DatXunJianFanWeiPK[ roleId=" + roleId + ", xunJianDianId=" + xunJianDianId + " ]";
    }
    
}
