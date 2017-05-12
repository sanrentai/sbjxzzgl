package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import cn.tst.sbjxzzglxt.common.SepE;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 菜单实体
 *
 * @author ps_xy@pscp.co.jp
 */
@Entity
@Table(name = "mst_cai_dan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstCaiDan.findAll", query = "SELECT m FROM MstCaiDan m WHERE m.delFlg = :delFlg")
})
public class MstCaiDan extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "caidan_id")
    private String caidanId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "caidan_name")
    private String caidanName;
    @Size(max = 50)
    @Column(name = "icon_name")
    private String iconName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paixu")
    private int paixu;

    public MstCaiDan() {
    }

    public MstCaiDan(String caidanId) {
        this.caidanId = caidanId;
    }

    public MstCaiDan(String caidanId, String caidanName, int paixu,
        String insRep, Date insDate, String updRep, Date updDate, SepE.Flag delFlg, int version) {

        super(insRep, insDate, updRep, updDate, delFlg, version);

        this.caidanId = caidanId;
        this.caidanName = caidanName;
        this.paixu = paixu;
    }

    public String getCaidanId() {
        return caidanId;
    }

    public void setCaidanId(String caidanId) {
        this.caidanId = caidanId;
    }

    public String getCaidanName() {
        return caidanName;
    }

    public void setCaidanName(String caidanName) {
        this.caidanName = caidanName;
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
        hash += (caidanId != null ? caidanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MstCaiDan)) {
            return false;
        }
        MstCaiDan other = (MstCaiDan) object;
        if ((this.caidanId == null && other.caidanId != null)
            || (this.caidanId != null && !this.caidanId.equals(other.caidanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.pscp.material.materialmg.entity.MstCaiDan[ caidanId=" + caidanId + " ]";
    }

    //***********************************************************************************************
    //                                  自定义关系的追加
    //***********************************************************************************************
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "menu")
    @OrderBy("paixu ASC")
    private List<MstCaiDanXiangMu> menuItems;

    public void setMenuItems(List<MstCaiDanXiangMu> menuItems) {
        this.menuItems = menuItems;
    }

    public List<MstCaiDanXiangMu> getMenuItems() {
        return menuItems;
    }

    // 系统功能表
    @JoinColumn(name = "caidan_id", referencedColumnName = "hua_mian_id", insertable = false, updatable = false)
    @OneToOne
    private MstXiTongGongNeng xiTongGongNeng;

    public MstXiTongGongNeng getXiTongGongNeng() {
        return xiTongGongNeng;
    }

    public void setXiTongGongNeng(MstXiTongGongNeng xiTongGongNeng) {
        this.xiTongGongNeng = xiTongGongNeng;
    }
}
