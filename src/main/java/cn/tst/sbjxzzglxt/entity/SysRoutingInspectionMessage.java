/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 巡检信息列表实体类
 *
 * @author Administrator
 */
@Entity
@Table(name = "sys_routing_inspection_message")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysRoutingInspectionMessage.findAll", query = "SELECT s FROM SysRoutingInspectionMessage s")
    , @NamedQuery(name = "SysRoutingInspectionMessage.findBySuoshushebeiID", query = "SELECT s FROM SysRoutingInspectionMessage s WHERE s.suoshushebeiID = :suoshushebeiID AND s.delFlg = :delFlg")
    , @NamedQuery(name = "SysRoutingInspectionMessage.findByXunJianDianId", query = "SELECT s FROM SysRoutingInspectionMessage s WHERE s.xunJianDianId = :xunJianDianId")
    , @NamedQuery(name = "SysRoutingInspectionMessage.findByXunJianDianXiangMuId", query = "SELECT s FROM SysRoutingInspectionMessage s WHERE s.xunJianDianXiangMuId = :xunJianDianXiangMuId")
    , @NamedQuery(name = "SysRoutingInspectionMessage.findByXunJianRenId", query = "SELECT s FROM SysRoutingInspectionMessage s WHERE s.xunJianRenId = :xunJianRenId")
    , @NamedQuery(name = "SysRoutingInspectionMessage.findByXunJianShiJian", query = "SELECT s FROM SysRoutingInspectionMessage s WHERE s.xunJianShiJian = :xunJianShiJian")
    , @NamedQuery(name = "SysRoutingInspectionMessage.findByXunJianZhuangTai", query = "SELECT s FROM SysRoutingInspectionMessage s WHERE s.xunJianZhuangTai = :xunJianZhuangTai")
    , @NamedQuery(name = "SysRoutingInspectionMessage.findByXunJianWenTi", query = "SELECT s FROM SysRoutingInspectionMessage s WHERE s.xunJianWenTi = :xunJianWenTi")
    , @NamedQuery(name = "SysRoutingInspectionMessage.findByCanShuZhi", query = "SELECT s FROM SysRoutingInspectionMessage s WHERE s.canShuZhi = :canShuZhi")
    , @NamedQuery(name = "SysRoutingInspectionMessage.findByLuRuRen", query = "SELECT s FROM SysRoutingInspectionMessage s WHERE s.luRuRen = :luRuRen")
    , @NamedQuery(name = "SysRoutingInspectionMessage.findByInsRep", query = "SELECT s FROM SysRoutingInspectionMessage s WHERE s.insRep = :insRep")
    , @NamedQuery(name = "SysRoutingInspectionMessage.findByInsDate", query = "SELECT s FROM SysRoutingInspectionMessage s WHERE s.insDate = :insDate")
    , @NamedQuery(name = "SysRoutingInspectionMessage.findByUpdRep", query = "SELECT s FROM SysRoutingInspectionMessage s WHERE s.updRep = :updRep")
    , @NamedQuery(name = "SysRoutingInspectionMessage.findByUpdDate", query = "SELECT s FROM SysRoutingInspectionMessage s WHERE s.updDate = :updDate")
    , @NamedQuery(name = "SysRoutingInspectionMessage.findByDelFlg", query = "SELECT s FROM SysRoutingInspectionMessage s WHERE s.delFlg = :delFlg")
    , @NamedQuery(name = "SysRoutingInspectionMessage.findByVersion", query = "SELECT s FROM SysRoutingInspectionMessage s WHERE s.version = :version")})
public class SysRoutingInspectionMessage extends BaseEntity implements Serializable {

    @Column(name = "suo_shu_she_bei_ID")
    private Long suoshushebeiID;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xun_jian_dian_id")
    private Long xunJianDianId;
     @Size(max = 255)
    @Column(name = "xun_jian_dian_xiang_mu_id")
    private String xunJianDianXiangMuId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xun_jian_ren_id")
    private int xunJianRenId;
    @Column(name = "xun_jian_shi_jian")
    @Temporal(TemporalType.DATE)
    private Date xunJianShiJian;
    @Column(name = "xun_jian_zhuang_tai")
    private Integer xunJianZhuangTai;
    @Size(max = 255)
    @Column(name = "xun_jian_wen_ti")
    private String xunJianWenTi;
    @Column(name = "can_shu_zhi")
    private Integer canShuZhi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lu_ru_ren")
    private int luRuRen;
    
      //使用多对一的方式连表并且使用懒加载
    @ManyToOne(fetch = FetchType.LAZY)
   //连表 插入列的名字 与引用列的名字
    @JoinColumn(name = "suo_shu_she_bei_id", referencedColumnName = "E_Num", insertable = false, updatable = false)
   //通过分装需要连表的实体类，完成页面的调用
    private LTEquipBasic equip;
    
     //这个连表主要用于取项目名称
    @OneToOne(mappedBy = "message")
    private SysRoutingInspectionItems routingInspectionItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getXunJianDianId() {
        return xunJianDianId;
    }

    public void setXunJianDianId(Long xunJianDianId) {
        this.xunJianDianId = xunJianDianId;
    }

    public String getXunJianDianXiangMuId() {
        return xunJianDianXiangMuId;
    }

    public void setXunJianDianXiangMuId(String xunJianDianXiangMuId) {
        this.xunJianDianXiangMuId = xunJianDianXiangMuId;
    }

    public int getXunJianRenId() {
        return xunJianRenId;
    }

    public void setXunJianRenId(int xunJianRenId) {
        this.xunJianRenId = xunJianRenId;
    }

    public Date getXunJianShiJian() {
        return xunJianShiJian;
    }

    public void setXunJianShiJian(Date xunJianShiJian) {
        this.xunJianShiJian = xunJianShiJian;
    }

    public Integer getXunJianZhuangTai() {
        return xunJianZhuangTai;
    }

    public void setXunJianZhuangTai(Integer xunJianZhuangTai) {
        this.xunJianZhuangTai = xunJianZhuangTai;
    }

    public String getXunJianWenTi() {
        return xunJianWenTi;
    }

    public void setXunJianWenTi(String xunJianWenTi) {
        this.xunJianWenTi = xunJianWenTi;
    }

    public Integer getCanShuZhi() {
        return canShuZhi;
    }

    public void setCanShuZhi(Integer canShuZhi) {
        this.canShuZhi = canShuZhi;
    }

    public int getLuRuRen() {
        return luRuRen;
    }

    public void setLuRuRen(int luRuRen) {
        this.luRuRen = luRuRen;
    }

    public LTEquipBasic getEquip() {
        return equip;
    }

    public void setEquip(LTEquipBasic equip) {
        this.equip = equip;
    }

    public SysRoutingInspectionItems getRoutingInspectionItems() {
        return routingInspectionItems;
    }

    public void setRoutingInspectionItems(SysRoutingInspectionItems routingInspectionItems) {
        this.routingInspectionItems = routingInspectionItems;
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
        if (!(object instanceof SysRoutingInspectionMessage)) {
            return false;
        }
        SysRoutingInspectionMessage other = (SysRoutingInspectionMessage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.SysRoutingInspectionMessage[ id=" + id + " ]";
    }

    public SysRoutingInspectionMessage() {
    }

    public Long getSuoshushebeiID() {
        return suoshushebeiID;
    }

    public void setSuoshushebeiID(Long suoshushebeiID) {
        this.suoshushebeiID = suoshushebeiID;
    }
    
}
