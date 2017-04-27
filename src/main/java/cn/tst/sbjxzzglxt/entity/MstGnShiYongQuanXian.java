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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.common.SepE.QuanXian;

/**
 * 功能权限
 *
 * @author ps_xy@pscp.co.jp
 */
@Entity
@Table(name = "mst_gn_shi_yong_quan_xian")
@XmlRootElement
@NamedQueries({})
public class MstGnShiYongQuanXian extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MstGnShiYongQuanXianPK pk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quan_xian")
    private int quanXian;

    public MstGnShiYongQuanXian() {
    }

    public MstGnShiYongQuanXian(MstGnShiYongQuanXianPK mstGnShiYongQuanXianPK) {
        this.pk = mstGnShiYongQuanXianPK;
    }

    public MstGnShiYongQuanXian(MstGnShiYongQuanXianPK mstGnShiYongQuanXianPK, int quanXian,
        String insRep, Date insDate, String updRep, Date updDate, SepE.Flag delFlg, int version) {
        super(insRep, insDate, updRep, updDate, delFlg, version);
        this.pk = mstGnShiYongQuanXianPK;
        this.quanXian = quanXian;

    }

    public MstGnShiYongQuanXian(String roleId, String gongNengId) {
        this.pk = new MstGnShiYongQuanXianPK(roleId, gongNengId);
    }

    public MstGnShiYongQuanXianPK getPk() {
        return pk;
    }

    public void setPk(MstGnShiYongQuanXianPK pk) {
        this.pk = pk;
    }

    public int getQuanXian() {
        return quanXian;
    }

    public void setQuanXian(int quanXian) {
        this.quanXian = quanXian;
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
        if (!(object instanceof MstGnShiYongQuanXian)) {
            return false;
        }
        MstGnShiYongQuanXian other = (MstGnShiYongQuanXian) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.pscp.material.materialmg.entity.MstGnShiYongQuanXian[ mstGnShiYongQuanXianPK=" + pk + " ]";
    }

    //***********************************************************************************************
    //                                  自定义关系的追加
    //***********************************************************************************************
    // 系统功能表
    @JoinColumn(name = "gong_neng_id", referencedColumnName = "gong_neng_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private MstXiTongGongNeng gongNeng;

    public MstXiTongGongNeng getGongNeng() {
        return gongNeng;
    }

    public void setGongNeng(MstXiTongGongNeng gongNeng) {
        this.gongNeng = gongNeng;
    }

    public void setQuanXianB(boolean v) {
        this.quanXian = v ? QuanXian.YES.getValue() : QuanXian.NO.getValue();
    }

    public boolean getQuanXianB() {
        return this.quanXian == QuanXian.YES.getValue();
    }
}
