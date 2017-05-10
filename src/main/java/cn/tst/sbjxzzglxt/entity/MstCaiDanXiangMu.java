package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import cn.tst.sbjxzzglxt.common.SepE;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 菜单项目实体
 *
 * @author ps_xy@pscp.co.jp
 */
@Entity
@Table(name = "mst_cai_dan_xiang_mu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstCaiDanXiangMu.findAll", query = "SELECT m FROM MstCaiDanXiangMu m WHERE m.delFlg = :delFlg ORDER BY m.paixu ASC")
})
public class MstCaiDanXiangMu extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MstCaiDanXiangMuPK pk;
    @Size(max = 20)
    @Column(name = "xiang_mu_ming")
    private String xiangMuMing;
    @Size(max = 50)
    @Column(name = "icon_name")
    private String iconName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paixu")
    private int paixu;

    public MstCaiDanXiangMu() {
    }

    public MstCaiDanXiangMu(MstCaiDanXiangMuPK pk) {
        this.pk = pk;
    }

    public MstCaiDanXiangMu(MstCaiDanXiangMuPK pk, int paixu,
        String insRep, Date insDate, String updRep, Date updDate, SepE.Flag delFlg, int version) {

        super(insRep, insDate, updRep, updDate, delFlg, version);
        this.pk = pk;
        this.paixu = paixu;
    }

    public MstCaiDanXiangMu(String moKuaiId, String caidanId, String xiangMuId) {
        this.pk = new MstCaiDanXiangMuPK(moKuaiId, caidanId, xiangMuId);
    }

    public MstCaiDanXiangMuPK getPk() {
        return pk;
    }

    public void setPk(MstCaiDanXiangMuPK pk) {
        this.pk = pk;
    }

    public String getXiangMuMing() {
        return xiangMuMing;
    }

    public void setXiangMuMing(String xiangMuMing) {
        this.xiangMuMing = xiangMuMing;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public int getPaixu() {
        return paixu;
    }

    public void setPaixu(int paixu) {
        this.paixu = paixu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pk != null ? pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MstCaiDanXiangMu)) {
            return false;
        }
        MstCaiDanXiangMu other = (MstCaiDanXiangMu) object;
        if ((this.pk == null && other.pk != null)
            || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.pscp.material.materialmg.entity.MstCaiDanXiangMu[ PK=" + pk + " ]";
    }

    //***********************************************************************************************
    //                                  自定义关系的追加
    //***********************************************************************************************
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "caidan_id", referencedColumnName = "caidan_id", insertable = false, updatable = false)
    private MstCaiDan menu;

    @OneToMany(mappedBy = "xiangMu")
    private List<MstXiTongGongNeng> gongNengList;

    public MstCaiDan getMenu() {
        return menu;
    }

    public void setMenu(MstCaiDan menu) {
        this.menu = menu;
    }

    public List<MstXiTongGongNeng> getGongNengList() {
        return gongNengList;
    }

    public void setGongNengList(List<MstXiTongGongNeng> gongNengList) {
        this.gongNengList = gongNengList;
    }
}
