package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author zero
 */
@Embeddable
public class MstBuMenSuoShuPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "bu_men_id")
    private String buMenId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "suo_shu_bu_men_id")
    private String suoShuBuMenId;

    public MstBuMenSuoShuPK() {
    }

    public MstBuMenSuoShuPK(String buMenId, String suoShuBuMenId) {
        this.buMenId = buMenId;
        this.suoShuBuMenId = suoShuBuMenId;
    }

    public String getBuMenId() {
        return buMenId;
    }

    public void setBuMenId(String buMenId) {
        this.buMenId = buMenId;
    }

    public String getSuoShuBuMenId() {
        return suoShuBuMenId;
    }

    public void setSuoShuBuMenId(String suoShuBuMenId) {
        this.suoShuBuMenId = suoShuBuMenId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (buMenId != null ? buMenId.hashCode() : 0);
        hash += (suoShuBuMenId != null ? suoShuBuMenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstBuMenSuoShuPK)) {
            return false;
        }
        MstBuMenSuoShuPK other = (MstBuMenSuoShuPK) object;
        if ((this.buMenId == null && other.buMenId != null) || (this.buMenId != null && !this.buMenId.equals(other.buMenId))) {
            return false;
        }
        if ((this.suoShuBuMenId == null && other.suoShuBuMenId != null) || (this.suoShuBuMenId != null && !this.suoShuBuMenId.equals(other.suoShuBuMenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.pscp.material.materialmg.entity.MstBuMenSuoShuPK[ buMenId=" + buMenId + ", suoShuBuMenId=" + suoShuBuMenId + " ]";
    }
    
}
