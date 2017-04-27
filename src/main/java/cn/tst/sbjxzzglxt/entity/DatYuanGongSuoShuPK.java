package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author zero
 */
@Embeddable
public class DatYuanGongSuoShuPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "yuan_gong_id")
    private String yuanGongId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "bu_men_id")
    private String buMenId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "zhi_neng_id")
    private String zhiNengId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shang_ren_rq")
    @Temporal(TemporalType.DATE)
    private Date shangRenRq;

    public DatYuanGongSuoShuPK() {
    }

    public DatYuanGongSuoShuPK(String yuanGongId, String buMenId, String zhiNengId) {
        this.yuanGongId = yuanGongId;
        this.buMenId = buMenId;
        this.zhiNengId = zhiNengId;
    }

    public String getYuanGongId() {
        return yuanGongId;
    }

    public void setYuanGongId(String yuanGongId) {
        this.yuanGongId = yuanGongId;
    }

    public String getBuMenId() {
        return buMenId;
    }

    public void setBuMenId(String buMenId) {
        this.buMenId = buMenId;
    }

    public String getZhiNengId() {
        return zhiNengId;
    }

    public void setZhiNengId(String zhiNengId) {
        this.zhiNengId = zhiNengId;
    }

    public Date getShangRenRq() {
        return shangRenRq;
    }

    public void setShangRenRq(Date shangRenRq) {
        this.shangRenRq = shangRenRq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (yuanGongId != null ? yuanGongId.hashCode() : 0);
        hash += (buMenId != null ? buMenId.hashCode() : 0);
        hash += (zhiNengId != null ? zhiNengId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatYuanGongSuoShuPK)) {
            return false;
        }
        DatYuanGongSuoShuPK other = (DatYuanGongSuoShuPK) object;
        if ((this.yuanGongId == null && other.yuanGongId != null) || (this.yuanGongId != null && !this.yuanGongId.equals(other.yuanGongId))) {
            return false;
        }
        if ((this.buMenId == null && other.buMenId != null) || (this.buMenId != null && !this.buMenId.equals(other.buMenId))) {
            return false;
        }
        if ((this.zhiNengId == null && other.zhiNengId != null) || (this.zhiNengId != null && !this.zhiNengId.equals(other.zhiNengId))) {
            return false;
        }

        if ((this.shangRenRq == null && other.shangRenRq != null) || (this.shangRenRq != null && !this.shangRenRq.equals(other.shangRenRq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.pscp.material.materialmg.entity.DatYuanGongSuoShuPK[ yuanGongId=" + yuanGongId + ", buMenId=" + buMenId + ", zhiNengId=" + zhiNengId + " ]";
    }

}
