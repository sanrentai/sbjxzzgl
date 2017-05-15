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
 *
 * @author Administrator
 */
@Entity
@Table(name = "dat_xun_jian_gui_ze")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatXunJianGuiZe.findAll", query = "SELECT d FROM DatXunJianGuiZe d")
    , @NamedQuery(name = "DatXunJianGuiZe.findByRoleId", query = "SELECT d FROM DatXunJianGuiZe d WHERE d.roleId = :roleId")
    , @NamedQuery(name = "DatXunJianGuiZe.findByXunHuaFangShi", query = "SELECT d FROM DatXunJianGuiZe d WHERE d.xunHuaFangShi = :xunHuaFangShi")
    , @NamedQuery(name = "DatXunJianGuiZe.findByStartDate", query = "SELECT d FROM DatXunJianGuiZe d WHERE d.startDate = :startDate")
    , @NamedQuery(name = "DatXunJianGuiZe.findByEndDate", query = "SELECT d FROM DatXunJianGuiZe d WHERE d.endDate = :endDate")
    , @NamedQuery(name = "DatXunJianGuiZe.findByInsRep", query = "SELECT d FROM DatXunJianGuiZe d WHERE d.insRep = :insRep")
    , @NamedQuery(name = "DatXunJianGuiZe.findByInsDate", query = "SELECT d FROM DatXunJianGuiZe d WHERE d.insDate = :insDate")
    , @NamedQuery(name = "DatXunJianGuiZe.findByUpdRep", query = "SELECT d FROM DatXunJianGuiZe d WHERE d.updRep = :updRep")
    , @NamedQuery(name = "DatXunJianGuiZe.findByUpdDate", query = "SELECT d FROM DatXunJianGuiZe d WHERE d.updDate = :updDate")
    , @NamedQuery(name = "DatXunJianGuiZe.findByDelFlg", query = "SELECT d FROM DatXunJianGuiZe d WHERE d.delFlg = :delFlg")
    , @NamedQuery(name = "DatXunJianGuiZe.findByVersion", query = "SELECT d FROM DatXunJianGuiZe d WHERE d.version = :version")})
public class DatXunJianGuiZe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "role_id")
    private Integer roleId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xun_hua_fang_shi")
    private int xunHuaFangShi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ins_rep")
    private String insRep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ins_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "upd_rep")
    private String updRep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "upd_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "del_flg")
    private Character delFlg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private int version;

    public DatXunJianGuiZe() {
    }

    public DatXunJianGuiZe(Integer roleId) {
        this.roleId = roleId;
    }

    public DatXunJianGuiZe(Integer roleId, int xunHuaFangShi, Date startDate, Date endDate, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
        this.roleId = roleId;
        this.xunHuaFangShi = xunHuaFangShi;
        this.startDate = startDate;
        this.endDate = endDate;
        this.insRep = insRep;
        this.insDate = insDate;
        this.updRep = updRep;
        this.updDate = updDate;
        this.delFlg = delFlg;
        this.version = version;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public int getXunHuaFangShi() {
        return xunHuaFangShi;
    }

    public void setXunHuaFangShi(int xunHuaFangShi) {
        this.xunHuaFangShi = xunHuaFangShi;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getInsRep() {
        return insRep;
    }

    public void setInsRep(String insRep) {
        this.insRep = insRep;
    }

    public Date getInsDate() {
        return insDate;
    }

    public void setInsDate(Date insDate) {
        this.insDate = insDate;
    }

    public String getUpdRep() {
        return updRep;
    }

    public void setUpdRep(String updRep) {
        this.updRep = updRep;
    }

    public Date getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Date updDate) {
        this.updDate = updDate;
    }

    public Character getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Character delFlg) {
        this.delFlg = delFlg;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatXunJianGuiZe)) {
            return false;
        }
        DatXunJianGuiZe other = (DatXunJianGuiZe) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.DatXunJianGuiZe[ roleId=" + roleId + " ]";
    }
    
}
