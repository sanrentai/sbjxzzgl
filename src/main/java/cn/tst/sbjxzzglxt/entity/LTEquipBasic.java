/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "LT_Equip_Basic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LTEquipBasic.findAll", query = "SELECT l FROM LTEquipBasic l")
    , @NamedQuery(name = "LTEquipBasic.findById", query = "SELECT l FROM LTEquipBasic l WHERE l.id = :id")
    , @NamedQuery(name = "LTEquipBasic.findByENmae", query = "SELECT l FROM LTEquipBasic l WHERE l.eNmae = :eNmae")
    , @NamedQuery(name = "LTEquipBasic.findByCId", query = "SELECT l FROM LTEquipBasic l WHERE l.cId = :cId AND l.delFlg = :delFlg")
    , @NamedQuery(name = "LTEquipBasic.findByDelFlg", query = "SELECT l FROM LTEquipBasic l WHERE l.delFlg = :delFlg")
    , @NamedQuery(name = "LTEquipBasic.findByVersion", query = "SELECT l FROM LTEquipBasic l WHERE l.version = :version")})
public class LTEquipBasic extends BaseEntity implements Serializable {

    @Size(max = 250)
    @Column(name = "zhi_zhao_guo_bie")
    private String zhiZhaoGuoBie;
    @Size(max = 250)
    @Column(name = "xing_hao")
    private String xingHao;
    @Size(max = 250)
    @Column(name = "gui_ge")
    private String guiGe;
    @Size(max = 250)
    @Column(name = "sheng_can_shang")
    private String shengCanShang;
    @Column(name = "jin_cang_ri_qi")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jinCangRiQi;
    @Column(name = "chu_cang_ri_qi")
    @Temporal(TemporalType.TIMESTAMP)
    private Date chuCangRiQi;
    @Size(max = 250)
    @Column(name = "an_zhuang_di_dian")
    private String anZhuangDiDian;
    @Column(name = "an_zhuang_shi_jian")
    @Temporal(TemporalType.TIMESTAMP)
    private Date anZhuangShiJian;
    @Column(name = "shi_yong_shi_jian")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shiYongShiJian;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "zong_zhi_liang")
    private BigDecimal zongZhiLiang;
    @Column(name = "zhi_bao_ri_qi")
    @Temporal(TemporalType.TIMESTAMP)
    private Date zhiBaoRiQi;
    @Column(name = "bao_fei_ri_qi")
    @Temporal(TemporalType.TIMESTAMP)
    private Date baoFeiRiQi;
    @Size(max = 250)
    @Column(name = "wai_guan_chi_cun")
    private String waiGuanChiCun;
    @Size(max = 250)
    @Column(name = "xing_neng_miao_shu")
    private String xingNengMiaoShu;
    @Size(max = 250)
    @Column(name = "xin_xi_fu_jian")
    private String xinXiFuJian;
    @Size(max = 250)
    @Column(name = "gou_zhi_fang_shi")
    private String gouZhiFangShi;
    @Column(name = "gou_zhi_ri_qi")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gouZhiRiQi;
    @Column(name = "zhi_chan_yuan_zhi")
    private BigDecimal zhiChanYuanZhi;
    @Size(max = 10)
    @Column(name = "gou_ru_fu_zhe_ren_id")
    private String gouRuFuZheRenId;
    @Size(max = 8)
    @Column(name = "ying_yong_bu_men_id")
    private String yingYongBuMenId;
    @Size(max = 10)
    @Column(name = "ying_yong_fu_zhe_ren_id")
    private String yingYongFuZheRenId;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Size(max = 250)
    @Column(name = "E_Nmae")
    private String eNmae;
    @Column(name = "C_ID")
    private Long cId;
    @Size(max = 50)
    @Column(name = "E_Num")
    private String eNum;
    @Column(name = "Del_YN")
    private Integer delYN;
    @Column(name = "Del_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date delDate;
    @Column(name = "Del_User")
    private Long delUser;
    @Column(name = "State")
    private Integer state;
    @Column(name = "State_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stateDate;
    @Column(name = "State_User")
    private Long stateUser;
    @Column(name = "Add_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addDate;
    @Column(name = "Add_User")
    private Long addUser;
    @Column(name = "Edit_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date editDate;
    @Column(name = "Edit_User")
    private Long editUser;

    public LTEquipBasic() {
    }

    public LTEquipBasic(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getENmae() {
        return eNmae;
    }

    public void setENmae(String eNmae) {
        this.eNmae = eNmae;
    }

    public String getENum() {
        return eNum;
    }

    public void setENum(String eNum) {
        this.eNum = eNum;
    }

    public Integer getDelYN() {
        return delYN;
    }

    public void setDelYN(Integer delYN) {
        this.delYN = delYN;
    }

    public Date getDelDate() {
        return delDate;
    }

    public void setDelDate(Date delDate) {
        this.delDate = delDate;
    }

    public Long getDelUser() {
        return delUser;
    }

    public void setDelUser(Long delUser) {
        this.delUser = delUser;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getStateDate() {
        return stateDate;
    }

    public void setStateDate(Date stateDate) {
        this.stateDate = stateDate;
    }

    public Long getStateUser() {
        return stateUser;
    }

    public void setStateUser(Long stateUser) {
        this.stateUser = stateUser;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Long getAddUser() {
        return addUser;
    }

    public void setAddUser(Long addUser) {
        this.addUser = addUser;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public Long getEditUser() {
        return editUser;
    }

    public void setEditUser(Long editUser) {
        this.editUser = editUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LTEquipBasic)) {
            return false;
        }
        LTEquipBasic other = (LTEquipBasic) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "cn.tst.sbjxzzglxt.entity.LTEquipBasic[ id=" + id + " ]";
        return eNmae;
    }

    ///父节点
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name = "C_ID", referencedColumnName = "ID", insertable = false, updatable = false),
        @JoinColumn(name = "del_flg", referencedColumnName = "del_flg", insertable = false, updatable = false)
    })
//    @JoinColumn(name = "C_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private LTEquipBasic parent;

    ///子节点
    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
    private Set<LTEquipBasic> children;

    public LTEquipBasic getParent() {
        return parent;
    }

    public void setParent(LTEquipBasic parent) {
        this.parent = parent;
    }

    public Set<LTEquipBasic> getChildren() {
        return this.children;
    }

    public void setChildren(Set<LTEquipBasic> children) {
        this.children = children;
    }

    @OneToMany(mappedBy = "equipBasic", fetch = FetchType.LAZY)
    private List<LTEquipFitting> equipFittingList;

    public List<LTEquipFitting> getEquipFittingList() {
        return equipFittingList;
    }

    public void setEquipFittingList(List<LTEquipFitting> equipFittingList) {
        this.equipFittingList = equipFittingList;
    }
    
    
    @OneToMany(mappedBy = "equip", fetch = FetchType.LAZY)
    private List<LTEquipProRule> equipProRuleList;

    public List<LTEquipProRule> getEquipProRuleList() {
        return equipProRuleList;
    }

    public void setEquipProRuleList(List<LTEquipProRule> equipProRuleList) {
        this.equipProRuleList = equipProRuleList;
    }

    public String getZhiZhaoGuoBie() {
        return zhiZhaoGuoBie;
    }

    public void setZhiZhaoGuoBie(String zhiZhaoGuoBie) {
        this.zhiZhaoGuoBie = zhiZhaoGuoBie;
    }

    public String getXingHao() {
        return xingHao;
    }

    public void setXingHao(String xingHao) {
        this.xingHao = xingHao;
    }

    public String getGuiGe() {
        return guiGe;
    }

    public void setGuiGe(String guiGe) {
        this.guiGe = guiGe;
    }

    public String getShengCanShang() {
        return shengCanShang;
    }

    public void setShengCanShang(String shengCanShang) {
        this.shengCanShang = shengCanShang;
    }

    public Date getJinCangRiQi() {
        return jinCangRiQi;
    }

    public void setJinCangRiQi(Date jinCangRiQi) {
        this.jinCangRiQi = jinCangRiQi;
    }

    public Date getChuCangRiQi() {
        return chuCangRiQi;
    }

    public void setChuCangRiQi(Date chuCangRiQi) {
        this.chuCangRiQi = chuCangRiQi;
    }

    public String getAnZhuangDiDian() {
        return anZhuangDiDian;
    }

    public void setAnZhuangDiDian(String anZhuangDiDian) {
        this.anZhuangDiDian = anZhuangDiDian;
    }

    public Date getAnZhuangShiJian() {
        return anZhuangShiJian;
    }

    public void setAnZhuangShiJian(Date anZhuangShiJian) {
        this.anZhuangShiJian = anZhuangShiJian;
    }

    public BigDecimal getZongZhiLiang() {
        return zongZhiLiang;
    }

    public void setZongZhiLiang(BigDecimal zongZhiLiang) {
        this.zongZhiLiang = zongZhiLiang;
    }

    public Date getZhiBaoRiQi() {
        return zhiBaoRiQi;
    }

    public void setZhiBaoRiQi(Date zhiBaoRiQi) {
        this.zhiBaoRiQi = zhiBaoRiQi;
    }

    public Date getBaoFeiRiQi() {
        return baoFeiRiQi;
    }

    public void setBaoFeiRiQi(Date baoFeiRiQi) {
        this.baoFeiRiQi = baoFeiRiQi;
    }

    public String getWaiGuanChiCun() {
        return waiGuanChiCun;
    }

    public void setWaiGuanChiCun(String waiGuanChiCun) {
        this.waiGuanChiCun = waiGuanChiCun;
    }

    public String getXingNengMiaoShu() {
        return xingNengMiaoShu;
    }

    public void setXingNengMiaoShu(String xingNengMiaoShu) {
        this.xingNengMiaoShu = xingNengMiaoShu;
    }

    public String getXinXiFuJian() {
        return xinXiFuJian;
    }

    public void setXinXiFuJian(String xinXiFuJian) {
        this.xinXiFuJian = xinXiFuJian;
    }

    public String getGouZhiFangShi() {
        return gouZhiFangShi;
    }

    public void setGouZhiFangShi(String gouZhiFangShi) {
        this.gouZhiFangShi = gouZhiFangShi;
    }

    public Date getGouZhiRiQi() {
        return gouZhiRiQi;
    }

    public void setGouZhiRiQi(Date gouZhiRiQi) {
        this.gouZhiRiQi = gouZhiRiQi;
    }

    public BigDecimal getZhiChanYuanZhi() {
        return zhiChanYuanZhi;
    }

    public void setZhiChanYuanZhi(BigDecimal zhiChanYuanZhi) {
        this.zhiChanYuanZhi = zhiChanYuanZhi;
    }

    public String getGouRuFuZheRenId() {
        return gouRuFuZheRenId;
    }

    public void setGouRuFuZheRenId(String gouRuFuZheRenId) {
        this.gouRuFuZheRenId = gouRuFuZheRenId;
    }

    public String getYingYongBuMenId() {
        return yingYongBuMenId;
    }

    public void setYingYongBuMenId(String yingYongBuMenId) {
        this.yingYongBuMenId = yingYongBuMenId;
    }

    public String getYingYongFuZheRenId() {
        return yingYongFuZheRenId;
    }

    public void setYingYongFuZheRenId(String yingYongFuZheRenId) {
        this.yingYongFuZheRenId = yingYongFuZheRenId;
    }

    public Date getShiYongShiJian() {
        return shiYongShiJian;
    }

    public void setShiYongShiJian(Date shiYongShiJian) {
        this.shiYongShiJian = shiYongShiJian;
    }

}
