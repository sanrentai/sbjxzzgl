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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import cn.tst.sbjxzzglxt.common.SepE;

/**
 * 职能表
 * 
 * @author ps_xy@pscp.co.jp
 */
@Entity
@Table(name = "mst_zhi_neng")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstZhiNeng.findAll", query = "SELECT m FROM MstZhiNeng m")
})
public class MstZhiNeng extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Size(min = 1, max = 8)
    @Column(name = "zhi_neng_id")
    private String zhiNengId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "zhi_wu_ming")
    private String zhiWuMing;
    @Size(max = 2147483647)
    @Column(name = "zhi_neng_gai_yao")
    private String zhiNengGaiYao;

    public MstZhiNeng() {
    }

    public MstZhiNeng(String zhiNengId) {
        this.zhiNengId = zhiNengId;
    }

    public MstZhiNeng(String zhiNengId, String zhiWuMing, String insRep, Date insDate, String updRep,
            Date updDate, SepE.Flag delFlg, int version) {
        super(insRep, insDate, updRep, updDate, delFlg, version);
        this.zhiNengId = zhiNengId;
        this.zhiWuMing = zhiWuMing;
    }

    public String getZhiNengId() {
        return zhiNengId;
    }

    public void setZhiNengId(String zhiNengId) {
        this.zhiNengId = zhiNengId;
    }

    public String getZhiWuMing() {
        return zhiWuMing;
    }

    public void setZhiWuMing(String zhiWuMing) {
        this.zhiWuMing = zhiWuMing;
    }

    public String getZhiNengGaiYao() {
        return zhiNengGaiYao;
    }

    public void setZhiNengGaiYao(String zhiNengGaiYao) {
        this.zhiNengGaiYao = zhiNengGaiYao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zhiNengId != null ? zhiNengId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstZhiNeng)) {
            return false;
        }
        MstZhiNeng other = (MstZhiNeng) object;
        if ((this.zhiNengId == null && other.zhiNengId != null) || (this.zhiNengId != null && !this.zhiNengId.equals(other.zhiNengId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.pscp.material.materialmg.entity.MstZhiNeng[ zhiNengId=" + zhiNengId + " ]";
    }

}
