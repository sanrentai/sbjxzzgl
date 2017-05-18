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
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
@Embeddable
public class MstYuanGongXunJianRolePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "yuan_gong_id")
    private String yuanGongId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "role_id")
    private int roleId;

    public MstYuanGongXunJianRolePK() {
    }

    public MstYuanGongXunJianRolePK(String yuanGongId, int roleId) {
        this.yuanGongId = yuanGongId;
        this.roleId = roleId;
    }

    public String getYuanGongId() {
        return yuanGongId;
    }

    public void setYuanGongId(String yuanGongId) {
        this.yuanGongId = yuanGongId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (yuanGongId != null ? yuanGongId.hashCode() : 0);
        hash += (int) roleId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstYuanGongXunJianRolePK)) {
            return false;
        }
        MstYuanGongXunJianRolePK other = (MstYuanGongXunJianRolePK) object;
        if ((this.yuanGongId == null && other.yuanGongId != null) || (this.yuanGongId != null && !this.yuanGongId.equals(other.yuanGongId))) {
            return false;
        }
        if (this.roleId != other.roleId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.MstYuanGongXunJianRolePK[ yuanGongId=" + yuanGongId + ", roleId=" + roleId + " ]";
    }
    
}
