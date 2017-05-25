/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.entity;

import cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXiangMu.XiangMuBizLogicImplementation;
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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.log4j.Logger;

/**
 * 巡检项目实体类
 *
 * @author Administrator
 */
@Entity
@Table(name = "sys_routing_inspection_items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysRoutingInspectionItems.findAll", query = "SELECT s FROM SysRoutingInspectionItems s")
    , @NamedQuery(name = "SysRoutingInspectionItems.findBySuoShuSheBeiId", query = "SELECT s FROM SysRoutingInspectionItems s WHERE s.suoShuSheBeiId = :suoShuSheBeiId AND s.delFlg = :delFlg")
    , @NamedQuery(name = "SysRoutingInspectionItems.findBySuoShuXunJianDianId", query = "SELECT s FROM SysRoutingInspectionItems s WHERE s.suoShuXunJianDianId = :suoShuXunJianDianId")
    , @NamedQuery(name = "SysRoutingInspectionItems.findByXiangMuMingCheng", query = "SELECT s FROM SysRoutingInspectionItems s WHERE s.xiangMuMingCheng = :xiangMuMingCheng")
    , @NamedQuery(name = "SysRoutingInspectionItems.findByXunJianFangShi", query = "SELECT s FROM SysRoutingInspectionItems s WHERE s.xunJianFangShi = :xunJianFangShi")
    , @NamedQuery(name = "SysRoutingInspectionItems.findByXunJianShunXu", query = "SELECT s FROM SysRoutingInspectionItems s WHERE s.xunJianShunXu = :xunJianShunXu")
    , @NamedQuery(name = "SysRoutingInspectionItems.findByXiangMuShuoMing", query = "SELECT s FROM SysRoutingInspectionItems s WHERE s.xiangMuShuoMing = :xiangMuShuoMing")
    , @NamedQuery(name = "SysRoutingInspectionItems.findByInsRep", query = "SELECT s FROM SysRoutingInspectionItems s WHERE s.insRep = :insRep")
    , @NamedQuery(name = "SysRoutingInspectionItems.findByInsDate", query = "SELECT s FROM SysRoutingInspectionItems s WHERE s.insDate = :insDate")
    , @NamedQuery(name = "SysRoutingInspectionItems.findByUpdRep", query = "SELECT s FROM SysRoutingInspectionItems s WHERE s.updRep = :updRep")
    , @NamedQuery(name = "SysRoutingInspectionItems.findByUpdDate", query = "SELECT s FROM SysRoutingInspectionItems s WHERE s.updDate = :updDate")
    , @NamedQuery(name = "SysRoutingInspectionItems.findByDelFlg", query = "SELECT s FROM SysRoutingInspectionItems s WHERE s.delFlg = :delFlg")
    , @NamedQuery(name = "SysRoutingInspectionItems.findByVersion", query = "SELECT s FROM SysRoutingInspectionItems s WHERE s.version = :version")})
public class SysRoutingInspectionItems extends BaseEntity implements Serializable {
 private static final Logger LOG = Logger.getLogger(XiangMuBizLogicImplementation.class.getName());
 
    @Column(name = "bo_dong_shang_xian")
    private Integer boDongShangXian;
    @Column(name = "bo_dong_xia_xian")
    private Integer boDongXiaXian; 
    @Column(name = "dui_ying_gu_zhang")
    private int duiYingGuZhang;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "suo_shu_she_bei_id")
    private Long suoShuSheBeiId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suo_shu_xun_jian_dian_id")
    private Long suoShuXunJianDianId;
    @Size(max = 255)
    @Column(name = "xiang_mu_ming_cheng")
    private String xiangMuMingCheng;
    @Column(name = "xun_jian_fang_shi")
    private Integer xunJianFangShi;
    @Column(name = "xun_jian_shun_xu")
    private Integer xunJianShunXu;
    @Size(max = 255)
    @Column(name = "xiang_mu_shuo_ming")
    private String xiangMuShuoMing;
    

    public SysRoutingInspectionMessage getMessage() {
        return message;
    }

    public void setMessage(SysRoutingInspectionMessage message) {
        this.message = message;
    }

    public SysRoutingInspectionProblem getRoutingInspectionProblem() {
        return routingInspectionProblem;
    }

    public void setRoutingInspectionProblem(SysRoutingInspectionProblem routingInspectionProblem) {
        this.routingInspectionProblem = routingInspectionProblem;
    }

    public LTEquipBasic getEquip() {
        return equip;
    }

    public void setEquip(LTEquipBasic equip) {
        this.equip = equip;
    }

    public SysRoutingInspectionItems() {
    }

    public SysRoutingInspectionItems(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSuoShuSheBeiId() {
        return suoShuSheBeiId;
    }

    public void setSuoShuSheBeiId(Long suoShuSheBeiId) {
        this.suoShuSheBeiId = suoShuSheBeiId;
    }

    public Long getSuoShuXunJianDianId() {
        return suoShuXunJianDianId;
    }

    public void setSuoShuXunJianDianId(Long suoShuXunJianDianId) {
        this.suoShuXunJianDianId = suoShuXunJianDianId;
    }

    public String getXiangMuMingCheng() {
        return xiangMuMingCheng;
    }

    public void setXiangMuMingCheng(String xiangMuMingCheng) {
        this.xiangMuMingCheng = xiangMuMingCheng;
    }

    public Integer getXunJianFangShi() {
        return xunJianFangShi;
    }

    public void setXunJianFangShi(Integer xunJianFangShi) {
        this.xunJianFangShi = xunJianFangShi;
    }

    public Integer getXunJianShunXu() {
        return xunJianShunXu;
    }

    public void setXunJianShunXu(Integer xunJianShunXu) {
        this.xunJianShunXu = xunJianShunXu;
    }

    public String getXiangMuShuoMing() {
        return xiangMuShuoMing;
    }

    public void setXiangMuShuoMing(String xiangMuShuoMing) {
        this.xiangMuShuoMing = xiangMuShuoMing;
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
        if (!(object instanceof SysRoutingInspectionItems)) {
            return false;
        }
        SysRoutingInspectionItems other = (SysRoutingInspectionItems) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.SysRoutingInspectionItems[ id=" + id + " ]";
    }

    public int getDuiYingGuZhang() {
        return duiYingGuZhang;
    }

    public void setDuiYingGuZhang(int duiYingGuZhang) {
        this.duiYingGuZhang = duiYingGuZhang;
    }

    public Integer getBoDongShangXian() {
        return boDongShangXian;
    }

    public void setBoDongShangXian(Integer boDongShangXian) {
        this.boDongShangXian = boDongShangXian;
    }

    public Integer getBoDongXiaXian() {
        return boDongXiaXian;
    }

    public void setBoDongXiaXian(Integer boDongXiaXian) {
        this.boDongXiaXian = boDongXiaXian;
    }

    //连表用于取设备名称
     @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "suo_shu_she_bei_id", referencedColumnName = "ID", insertable = false, updatable = false)
        ,
        @JoinColumn(name = "del_flg", referencedColumnName = "del_flg", insertable = false, updatable = false)
    }) 
    private LTEquipBasic equip;

    //这个对应的是SysRoutingInspectionProblem实体类，双向连表
    @OneToOne
    @PrimaryKeyJoinColumn(name = "xiang_mu_ming_cheng", referencedColumnName = "suo_shu_xiang_mu_id")
    private SysRoutingInspectionProblem routingInspectionProblem;

    //这个对应的是SysRoutingInspectionMessage实体类，双向连表
    @OneToOne
    @PrimaryKeyJoinColumn(name = "xiang_mu_ming_cheng", referencedColumnName = "xun_jian_dian_xiang_mu_id")
    private SysRoutingInspectionMessage message;
    
    //故障表格
     @OneToMany(mappedBy = "sysItems", fetch = FetchType.LAZY)
     private List<LTEquipError> errorList;

    public List<LTEquipError> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<LTEquipError> errorList) {
        this.errorList = errorList;
    }
   
   
}
