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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
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
 * 巡检项目问题实体类
 *
 * @author Administrator
 */
@Entity
@Table(name = "sys_routing_inspection_problem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysRoutingInspectionProblem.findAll", query = "SELECT s FROM SysRoutingInspectionProblem s")
    , @NamedQuery(name = "SysRoutingInspectionProblem.findBySuoShuSheBeiId", query = "SELECT s FROM SysRoutingInspectionProblem s WHERE s.suoShuSheBeiId = :suoShuSheBeiId AND s.delFlg = :delFlg")
    , @NamedQuery(name = "SysRoutingInspectionProblem.findBySuoShuXunJianDianId", query = "SELECT s FROM SysRoutingInspectionProblem s WHERE s.suoShuXunJianDianId = :suoShuXunJianDianId")
    , @NamedQuery(name = "SysRoutingInspectionProblem.findBySuoShuXiangMuId", query = "SELECT s FROM SysRoutingInspectionProblem s WHERE s.suoShuXiangMuId = :suoShuXiangMuId")
    , @NamedQuery(name = "SysRoutingInspectionProblem.findByGuZhangBianHao", query = "SELECT s FROM SysRoutingInspectionProblem s WHERE s.guZhangBianHao = :guZhangBianHao")
    , @NamedQuery(name = "SysRoutingInspectionProblem.findByInsRep", query = "SELECT s FROM SysRoutingInspectionProblem s WHERE s.insRep = :insRep")
    , @NamedQuery(name = "SysRoutingInspectionProblem.findByInsDate", query = "SELECT s FROM SysRoutingInspectionProblem s WHERE s.insDate = :insDate")
    , @NamedQuery(name = "SysRoutingInspectionProblem.findByUpdRep", query = "SELECT s FROM SysRoutingInspectionProblem s WHERE s.updRep = :updRep")
    , @NamedQuery(name = "SysRoutingInspectionProblem.findByUpdDate", query = "SELECT s FROM SysRoutingInspectionProblem s WHERE s.updDate = :updDate")
    , @NamedQuery(name = "SysRoutingInspectionProblem.findByDelFlg", query = "SELECT s FROM SysRoutingInspectionProblem s WHERE s.delFlg = :delFlg")
    , @NamedQuery(name = "SysRoutingInspectionProblem.findByVersion", query = "SELECT s FROM SysRoutingInspectionProblem s WHERE s.version = :version")})
public class SysRoutingInspectionProblem extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")

    private Long id;
    @Size(max = 255)
    @Column(name = "suo_shu_she_bei_id")
    private String suoShuSheBeiId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suo_shu_xun_jian_dian_id")
    private Long suoShuXunJianDianId;
    @Size(max = 255)
    @Column(name = "suo_shu_xiang_mu_id")
    private String suoShuXiangMuId;
    @Size(max = 255)
    @Column(name = "gu_zhang_bian_hao")
    private String guZhangBianHao;
    
    //这个连表用于页面区设备名称
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "suo_shu_she_bei_id", referencedColumnName = "E_Num", insertable = false, updatable = false)
    private LTEquipBasic equip;
    
    //这个连表主要用于取项目名称
    @OneToOne(mappedBy = "routingInspectionProblem")
    private SysRoutingInspectionItems routingInspectionItems;

    public SysRoutingInspectionItems getRoutingInspectionItems() {
        return routingInspectionItems;
    }

    public void setRoutingInspectionItems(SysRoutingInspectionItems routingInspectionItems) {
        this.routingInspectionItems = routingInspectionItems;
    }

   
    
    
    
    public LTEquipBasic getEquip() {
        return equip;
    }

    public void setEquip(LTEquipBasic equip) {
        this.equip = equip;
    }

    public SysRoutingInspectionProblem() {
    }

    public SysRoutingInspectionProblem(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSuoShuSheBeiId() {
        return suoShuSheBeiId;
    }

    public void setSuoShuSheBeiId(String suoShuSheBeiId) {
        this.suoShuSheBeiId = suoShuSheBeiId;
    }

    public Long getSuoShuXunJianDianId() {
        return suoShuXunJianDianId;
    }

    public void setSuoShuXunJianDianId(Long suoShuXunJianDianId) {
        this.suoShuXunJianDianId = suoShuXunJianDianId;
    }

    public String getSuoShuXiangMuId() {
        return suoShuXiangMuId;
    }

    public void setSuoShuXiangMuId(String suoShuXiangMuId) {
        this.suoShuXiangMuId = suoShuXiangMuId;
    }

    public String getGuZhangBianHao() {
        return guZhangBianHao;
    }

    public void setGuZhangBianHao(String guZhangBianHao) {
        this.guZhangBianHao = guZhangBianHao;
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
        if (!(object instanceof SysRoutingInspectionProblem)) {
            return false;
        }
        SysRoutingInspectionProblem other = (SysRoutingInspectionProblem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.SysRoutingInspectionProblem[ id=" + id + " ]";
    }

}
