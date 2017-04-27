package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import cn.tst.sbjxzzglxt.common.SepE;

/**
 *
 * @author zero
 */
@Entity
@Table(name = "dat_yuan_gong_suo_shu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatYuanGongSuoShu.findByYuanGongIdZaiZhiZt", query = "SELECT d FROM DatYuanGongSuoShu d "
        + " WHERE d.pk.yuanGongId = :yuanGongId "
        + " AND d.delFlg = :delFlg AND d.zaiZhiZt = :zaiZhiZt ORDER BY d.zhiWuYouXianHao")
})
public class DatYuanGongSuoShu extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DatYuanGongSuoShuPK pk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "zhi_wu_you_xian_hao")
    private int zhiWuYouXianHao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "zai_zhi_zt")
    private String zaiZhiZt;
    @Column(name = "xie_ren_rq")
    @Temporal(TemporalType.DATE)
    private Date xieRenRq;

    public DatYuanGongSuoShu() {
    }

    public DatYuanGongSuoShu(DatYuanGongSuoShuPK pk) {
        this.pk = pk;
    }

    public DatYuanGongSuoShu(DatYuanGongSuoShuPK pk, int zhiWuYouXianHao, String zaiZhiZt, Date xieRenRq,
        String insRep, Date insDate, String updRep, Date updDate, SepE.Flag delFlg, int version) {
        super(insRep, insDate, updRep, updDate, delFlg, version);
        this.pk = pk;
        this.zhiWuYouXianHao = zhiWuYouXianHao;
        this.xieRenRq = xieRenRq;
        this.zaiZhiZt = zaiZhiZt;
    }

    public DatYuanGongSuoShu(String yuanGongId, String buMenId, String zhiNengId) {
        this.pk = new DatYuanGongSuoShuPK(yuanGongId, buMenId, zhiNengId);
    }

    public DatYuanGongSuoShuPK getPk() {
        return pk;
    }

    public void setPk(DatYuanGongSuoShuPK pk) {
        this.pk = pk;
    }

    public int getZhiWuYouXianHao() {
        return zhiWuYouXianHao;
    }

    public void setZhiWuYouXianHao(int zhiWuYouXianHao) {
        this.zhiWuYouXianHao = zhiWuYouXianHao;
    }

    public String getZaiZhiZt() {
        return zaiZhiZt;
    }

    public void setZaiZhiZt(String zaiZhiZt) {
        this.zaiZhiZt = zaiZhiZt;
    }

    public Date getXieRenRq() {
        return xieRenRq;
    }

    public void setXieRenRq(Date xieRenRq) {
        this.xieRenRq = xieRenRq;
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
        if (!(object instanceof DatYuanGongSuoShu)) {
            return false;
        }
        DatYuanGongSuoShu other = (DatYuanGongSuoShu) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.pscp.material.materialmg.entity.DatYuanGongSuoShu[ pk=" + pk + " ]";
    }

    //***********************************************************************************************
    //                                  自定义关系的追加
    //***********************************************************************************************
    // 部门表
    @JoinColumn(name = "bu_men_id", referencedColumnName = "bu_men_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private MstBuMen buMen;

    // 职能表
    @JoinColumn(name = "zhi_neng_id", referencedColumnName = "zhi_neng_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private MstZhiNeng zhiNeng;
    
    @JoinColumn(name = "yuan_gong_id", referencedColumnName = "yuan_gong_id", insertable = false, updatable = false)
    @ManyToOne
    private MstYuanGong yuanGong;

    public MstBuMen getBuMen() {
        return buMen;
    }

    public void setBuMen(MstBuMen buMen) {
        this.buMen = buMen;
    }

    public MstZhiNeng getZhiNeng() {
        return zhiNeng;
    }

    public void setZhiNeng(MstZhiNeng zhiNeng) {
        this.zhiNeng = zhiNeng;
    }

    public MstYuanGong getYuanGong() {
        return yuanGong;
    }

    public void setYuanGong(MstYuanGong yuanGong) {
        this.yuanGong = yuanGong;
    }

    /**
     * 在职状态
     *
     * @return true: 在任 false:卸任
     */
    public boolean isZaiZhi() {
        return SepE.Flag.YES.getValue().equals(this.zaiZhiZt);
    }
}
