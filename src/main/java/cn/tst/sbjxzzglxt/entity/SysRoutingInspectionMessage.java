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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *  巡检信息列表实体类
 * @author Administrator
 */
@Entity
@Table(name = "sys_routing_inspection_message")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysRoutingInspectionMessage.findAll", query = "SELECT s FROM SysRoutingInspectionMessage s")
    , @NamedQuery(name = "SysRoutingInspectionMessage.findBySuoshushebeiID", query = "SELECT s FROM SysRoutingInspectionMessage s WHERE s.suoshushebeiID = :suoshushebeiID")
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

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suo_shu_she_bei_ID")
    private int suoshushebeiID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xun_jian_dian_id")
    private int xunJianDianId;
    @Column(name = "xun_jian_dian_xiang_mu_id")
    private Integer xunJianDianXiangMuId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xun-jian_ren_id")
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
    @Column(name = "lu-ru_ren")
    private int luRuRen;
    
    public SysRoutingInspectionMessage() {
    }

    public SysRoutingInspectionMessage(Long id) {
        this.id = id;
    }

 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSuoshushebeiID() {
        return suoshushebeiID;
    }

    public void setSuoshushebeiID(int suoshushebeiID) {
        this.suoshushebeiID = suoshushebeiID;
    }

    public int getXunJianDianId() {
        return xunJianDianId;
    }

    public void setXunJianDianId(int xunJianDianId) {
        this.xunJianDianId = xunJianDianId;
    }

    public Integer getXunJianDianXiangMuId() {
        return xunJianDianXiangMuId;
    }

    public void setXunJianDianXiangMuId(Integer xunJianDianXiangMuId) {
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

}
