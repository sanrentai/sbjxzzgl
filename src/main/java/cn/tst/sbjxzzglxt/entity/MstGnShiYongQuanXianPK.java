package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author andysilver
 */
@Embeddable
public class MstGnShiYongQuanXianPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "role_id")
    private String roleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "gong_neng_id")
    private String gongNengId;

    public MstGnShiYongQuanXianPK() {
    }

    public MstGnShiYongQuanXianPK(String roleId, String gongNengId) {
        this.roleId = roleId;
        this.gongNengId = gongNengId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getGongNengId() {
        return gongNengId;
    }

    public void setGongNengId(String gongNengId) {
        this.gongNengId = gongNengId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        hash += (gongNengId != null ? gongNengId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstGnShiYongQuanXianPK)) {
            return false;
        }
        MstGnShiYongQuanXianPK other = (MstGnShiYongQuanXianPK) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        if ((this.gongNengId == null && other.gongNengId != null) || (this.gongNengId != null && !this.gongNengId.equals(other.gongNengId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.pscp.material.materialmg.entity.MstGnShiYongQuanXianPK[ roleId=" + roleId + ", gongNengId=" + gongNengId + " ]";
    }

}
