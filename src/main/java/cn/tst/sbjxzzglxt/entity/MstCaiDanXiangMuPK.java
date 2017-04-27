package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 菜单项目主键
 *
 * @author ps_xy@pscp.co.jp
 */
@Embeddable
public class MstCaiDanXiangMuPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "mo_kuai_id")
    private String moKuaiId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "caidan_id")
    private String caidanId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "xiang_mu_id")
    private String xiangMuId;

    public MstCaiDanXiangMuPK() {
    }

    public MstCaiDanXiangMuPK(String moKuaiId, String caidanId, String xiangMuId) {
        this.caidanId = caidanId;
        this.xiangMuId = xiangMuId;
        this.moKuaiId = moKuaiId;
    }

    public String getCaidanId() {
        return caidanId;
    }

    public void setCaidanId(String caidanId) {
        this.caidanId = caidanId;
    }

    public String getXiangMuId() {
        return xiangMuId;
    }

    public void setXiangMuId(String xiangMuId) {
        this.xiangMuId = xiangMuId;
    }

    public String getMoKuaiId() {
        return moKuaiId;
    }

    public void setMoKuaiId(String moKuaiId) {
        this.moKuaiId = moKuaiId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (caidanId != null ? caidanId.hashCode() : 0);
        hash += (xiangMuId != null ? xiangMuId.hashCode() : 0);
        hash += (moKuaiId != null ? moKuaiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstCaiDanXiangMuPK)) {
            return false;
        }
        MstCaiDanXiangMuPK other = (MstCaiDanXiangMuPK) object;
        if ((this.moKuaiId == null && other.moKuaiId != null) || (this.moKuaiId != null && !this.moKuaiId.equals(other.moKuaiId))) {
            return false;
        }
        if ((this.caidanId == null && other.caidanId != null) || (this.caidanId != null && !this.caidanId.equals(other.caidanId))) {
            return false;
        }
        if ((this.xiangMuId == null && other.xiangMuId != null) || (this.xiangMuId != null && !this.xiangMuId.equals(other.xiangMuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.pscp.material.materialmg.entity.MstCaiDanXiangMuPK[ moKuaiId=" + moKuaiId + ", caidanId=" + caidanId + ", xiangMuId=" + xiangMuId + " ]";
    }
    
}
