package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import cn.tst.sbjxzzglxt.common.SepE;

/**
 * 系统功能表
 * 
 * @author ps_xy@pscp.co.jp
 */
@Entity
@Table(name = "mst_xi_tong_gong_neng")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstXiTongGongNeng.findAll", query = "SELECT m FROM MstXiTongGongNeng m")
})
public class MstXiTongGongNeng extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Size(min = 1, max = 8)
    @Column(name = "gong_neng_id")
    private String gongNengId;
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "hua_mian_id")
    private String huaMianId;
    @Size(max = 2147483647)
    @Column(name = "gai_yao")
    private String gaiYao;

    public MstXiTongGongNeng() {
    }

    public MstXiTongGongNeng(String gongNengId) {
        this.gongNengId = gongNengId;
    }

    public MstXiTongGongNeng(String gongNengId, String insRep, Date insDate, String updRep,
            Date updDate, SepE.Flag delFlg, int version) {
        super(insRep, insDate, updRep, updDate, delFlg, version);
        this.gongNengId = gongNengId;
    }

    public String getGongNengId() {
        return gongNengId;
    }

    public void setGongNengId(String gongNengId) {
        this.gongNengId = gongNengId;
    }

    public String getHuaMianId() {
        return huaMianId;
    }

    public void setHuaMianId(String huaMianId) {
        this.huaMianId = huaMianId;
    }

    public String getGaiYao() {
        return gaiYao;
    }

    public void setGaiYao(String gaiYao) {
        this.gaiYao = gaiYao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gongNengId != null ? gongNengId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstXiTongGongNeng)) {
            return false;
        }
        MstXiTongGongNeng other = (MstXiTongGongNeng) object;
        if ((this.gongNengId == null && other.gongNengId != null) || (this.gongNengId != null && !this.gongNengId.equals(other.gongNengId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.pscp.material.materialmg.entity.MstXiTongGongNeng[ gongNengId=" + gongNengId + " ]";
    }

    //***********************************************************************************************
    //                                  自定义关系的追加
    //***********************************************************************************************
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "hua_mian_id", referencedColumnName = "xiang_mu_id")
    private MstCaiDanXiangMu xiangMu;

    public MstCaiDanXiangMu getXiangMu() {
        return xiangMu;
    }

    public void setXiangMu(MstCaiDanXiangMu xiangMu) {
        this.xiangMu = xiangMu;
    }
}
