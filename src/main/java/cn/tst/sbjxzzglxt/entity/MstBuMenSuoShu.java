package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import cn.tst.sbjxzzglxt.common.SepE;

/**
 *
 * @author zero
 */
@Entity
@Table(name = "mst_bu_men_suo_shu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstBuMenSuoShu.findAll", query = "SELECT m FROM MstBuMenSuoShu m")
})
public class MstBuMenSuoShu extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MstBuMenSuoShuPK pk;

    public MstBuMenSuoShu() {
    }

    public MstBuMenSuoShu(MstBuMenSuoShuPK mstBuMenSuoShuPK) {
        this.pk = mstBuMenSuoShuPK;
    }

    public MstBuMenSuoShu(MstBuMenSuoShuPK mstBuMenSuoShuPK, String insRep, Date insDate, String updRep, Date updDate, SepE.Flag delFlg, int version) {
        super(insRep, insDate, updRep, updDate, delFlg, version);
        this.pk = mstBuMenSuoShuPK;
    }

    public MstBuMenSuoShu(String buMenId, String suoShuBuMenId) {
        this.pk = new MstBuMenSuoShuPK(buMenId, suoShuBuMenId);
    }

    public MstBuMenSuoShuPK getPk() {
        return pk;
    }

    public void setPk(MstBuMenSuoShuPK pk) {
        this.pk = pk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pk != null ? pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstBuMenSuoShu)) {
            return false;
        }
        MstBuMenSuoShu other = (MstBuMenSuoShu) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.pscp.material.materialmg.entity.MstBuMenSuoShu[ mstBuMenSuoShuPK=" + pk + " ]";
    }

}
