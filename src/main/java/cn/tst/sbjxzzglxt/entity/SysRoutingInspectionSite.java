/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *巡检点实体类
 * @author Administrator
 */
@Entity
@Table(name = "sys_routing_inspection_site")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysRoutingInspectionSite.findAll", query = "SELECT s FROM SysRoutingInspectionSite s")
    , @NamedQuery(name = "SysRoutingInspectionSite.findBySuoShuSheBeiId", query = "SELECT s FROM SysRoutingInspectionSite s WHERE s.suoShuSheBeiId = :suoShuSheBeiId")
    , @NamedQuery(name = "SysRoutingInspectionSite.findByXunJianDianMing", query = "SELECT s FROM SysRoutingInspectionSite s WHERE s.xunJianDianMing = :xunJianDianMing")
    , @NamedQuery(name = "SysRoutingInspectionSite.findByDingWeiZuoBiao", query = "SELECT s FROM SysRoutingInspectionSite s WHERE s.dingWeiZuoBiao = :dingWeiZuoBiao")
    , @NamedQuery(name = "SysRoutingInspectionSite.findByXunJianShunXu", query = "SELECT s FROM SysRoutingInspectionSite s WHERE s.xunJianShunXu = :xunJianShunXu")
    , @NamedQuery(name = "SysRoutingInspectionSite.findByXunJianDianShuoMing", query = "SELECT s FROM SysRoutingInspectionSite s WHERE s.xunJianDianShuoMing = :xunJianDianShuoMing")
    , @NamedQuery(name = "SysRoutingInspectionSite.findByInsRep", query = "SELECT s FROM SysRoutingInspectionSite s WHERE s.insRep = :insRep")
    , @NamedQuery(name = "SysRoutingInspectionSite.findByInsDate", query = "SELECT s FROM SysRoutingInspectionSite s WHERE s.insDate = :insDate")
    , @NamedQuery(name = "SysRoutingInspectionSite.findByUpdRep", query = "SELECT s FROM SysRoutingInspectionSite s WHERE s.updRep = :updRep")
    , @NamedQuery(name = "SysRoutingInspectionSite.findByUpdDate", query = "SELECT s FROM SysRoutingInspectionSite s WHERE s.updDate = :updDate")
    , @NamedQuery(name = "SysRoutingInspectionSite.findByDelFlg", query = "SELECT s FROM SysRoutingInspectionSite s WHERE s.delFlg = :delFlg")
    , @NamedQuery(name = "SysRoutingInspectionSite.findByVersion", query = "SELECT s FROM SysRoutingInspectionSite s WHERE s.version = :version")})
public class SysRoutingInspectionSite extends BaseEntity implements Serializable {

       private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suo_shu_she_bei_id")
    private int suoShuSheBeiId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "xun_jian_dian_ming")
    private String xunJianDianMing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ding_wei_zuo_biao")
    private int dingWeiZuoBiao;
    @Column(name = "xun_jian_shun_xu")
    private Integer xunJianShunXu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "xun_jian_dian_shuo_ming")
    private String xunJianDianShuoMing;
    
  

    public SysRoutingInspectionSite() {
    }

    public SysRoutingInspectionSite(Long id) {
        this.id = id;
    }

   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSuoShuSheBeiId() {
        return suoShuSheBeiId;
    }

    public void setSuoShuSheBeiId(int suoShuSheBeiId) {
        this.suoShuSheBeiId = suoShuSheBeiId;
    }

    public String getXunJianDianMing() {
        return xunJianDianMing;
    }

    public void setXunJianDianMing(String xunJianDianMing) {
        this.xunJianDianMing = xunJianDianMing;
    }

    public int getDingWeiZuoBiao() {
        return dingWeiZuoBiao;
    }

    public void setDingWeiZuoBiao(int dingWeiZuoBiao) {
        this.dingWeiZuoBiao = dingWeiZuoBiao;
    }

    public Integer getXunJianShunXu() {
        return xunJianShunXu;
    }

    public void setXunJianShunXu(Integer xunJianShunXu) {
        this.xunJianShunXu = xunJianShunXu;
    }

    public String getXunJianDianShuoMing() {
        return xunJianDianShuoMing;
    }

    public void setXunJianDianShuoMing(String xunJianDianShuoMing) {
        this.xunJianDianShuoMing = xunJianDianShuoMing;
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
        if (!(object instanceof SysRoutingInspectionSite)) {
            return false;
        }
        SysRoutingInspectionSite other = (SysRoutingInspectionSite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.SysRoutingInspectionSite[ id=" + id + " ]";
    }

//     //设备表
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "suo_shu_she_bei_id", referencedColumnName = "ID", insertable = false, updatable = false)
//    private LTEquipBasic equip;
//
//    public LTEquipBasic getEquip() {
//        return equip;
//    }
//
//    public void setEquip(LTEquipBasic equip) {
//        this.equip = equip;
//    }

    
    
  
}
