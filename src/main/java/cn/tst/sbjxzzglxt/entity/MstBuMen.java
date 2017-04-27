package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import cn.tst.sbjxzzglxt.common.SepE;

/**
 * 部门表
 * 
 * @author ps_lbin@pscp.co.jp
 */
@Entity
@Table(name = "mst_bu_men")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstBuMen.findAll",
            query = "SELECT m FROM MstBuMen m WHERE m.delFlg = :delFlg ORDER BY m.buMenBianHao ASC")
})
public class MstBuMen extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Size(min = 1, max = 8)
    @Column(name = "bu_men_id")
    private String buMenId;
    @Size(min = 1, max = 8)
    @Column(name = "suo_shu_bu_men_id")
    private String suoShuBuMenId;
    @Size(max = 10)
    @Column(name = "bu_men_bian_hao")
    private String buMenBianHao;
    @Size(max = 2147483647)
    @Column(name = "bu_men_ming")
    private String buMenMing;
    @Size(max = 10)
    @Column(name = "you_bian")
    private String youBian;
    @Size(max = 2147483647)
    @Column(name = "di_zhi")
    private String diZhi;
    @Size(max = 12)
    @Column(name = "dian_hua")
    private String dianHua;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="無効な電子メール")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(name = "email")
    private String email;

    public MstBuMen() {
    }

    public MstBuMen(String buMenId) {
        this.buMenId = buMenId;
    }

    public MstBuMen(String buMenId, String insRep, Date insDate, String updRep, Date updDate, SepE.Flag delFlg, int version) {
        super(insRep, insDate, updRep, updDate, delFlg, version);
        this.buMenId = buMenId;
    }

    public String getBuMenId() {
        return buMenId;
    }

    public void setBuMenId(String buMenId) {
        this.buMenId = buMenId;
    }

    public String getBuMenBianHao() {
        return buMenBianHao;
    }

    public void setBuMenBianHao(String buMenBianHao) {
        this.buMenBianHao = buMenBianHao;
    }

    public String getBuMenMing() {
        return buMenMing;
    }

    public String getSuoShuBuMenId() {
        return suoShuBuMenId;
    }

    public void setSuoShuBuMenId(String suoShuBuMenId) {
        this.suoShuBuMenId = suoShuBuMenId;
    }

    public void setBuMenMing(String buMenMing) {
        this.buMenMing = buMenMing;
    }

    public String getYouBian() {
        return youBian;
    }

    public void setYouBian(String youBian) {
        this.youBian = youBian;
    }

    public String getDiZhi() {
        return diZhi;
    }

    public void setDiZhi(String diZhi) {
        this.diZhi = diZhi;
    }

    public String getDianHua() {
        return dianHua;
    }

    public void setDianHua(String dianHua) {
        this.dianHua = dianHua;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (buMenId != null ? buMenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstBuMen)) {
            return false;
        }
        MstBuMen other = (MstBuMen) object;
        if ((this.buMenId == null && other.buMenId != null) || (this.buMenId != null && !this.buMenId.equals(other.buMenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.pscp.material.materialmg.entity.MstBuMen[ buMenId=" + buMenId + " ]";
    }

    //***********************************************************************************************
    //                                  自定义关系的追加
    //***********************************************************************************************
    //所属部门
    @JoinColumn(name = "suo_shu_bu_men_id", referencedColumnName = "bu_men_id", insertable = false, updatable = false)
    @ManyToOne
    private MstBuMen suoShuBuMen;
    
    @OneToMany(mappedBy = "buMen", fetch = FetchType.LAZY)
    private List<DatYuanGongSuoShu> yuanGongSuoShuList;

    public MstBuMen getSuoShuBuMen() {
        return suoShuBuMen;
    }

    public void setSuoShuBuMen(MstBuMen suoShuBuMen) {
        this.suoShuBuMen = suoShuBuMen;
    }

    public List<DatYuanGongSuoShu> getYuanGongSuoShuList() {
        return yuanGongSuoShuList;
    }

    public void setYuanGongSuoShuList(List<DatYuanGongSuoShu> yuanGongSuoShuList) {
        this.yuanGongSuoShuList = yuanGongSuoShuList;
    }
}
