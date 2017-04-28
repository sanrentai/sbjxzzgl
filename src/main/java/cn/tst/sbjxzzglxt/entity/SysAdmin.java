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
@Table(name = "sys_Admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysAdmin.findAll", query = "SELECT s FROM SysAdmin s")
    , @NamedQuery(name = "SysAdmin.findByAdminid", query = "SELECT s FROM SysAdmin s WHERE s.adminid = :adminid")
    , @NamedQuery(name = "SysAdmin.findByAdminname", query = "SELECT s FROM SysAdmin s WHERE s.adminname = :adminname")
    , @NamedQuery(name = "SysAdmin.findByAdminpass", query = "SELECT s FROM SysAdmin s WHERE s.adminpass = :adminpass")
    , @NamedQuery(name = "SysAdmin.findByGroupid", query = "SELECT s FROM SysAdmin s WHERE s.groupid = :groupid")
    , @NamedQuery(name = "SysAdmin.findByPenname", query = "SELECT s FROM SysAdmin s WHERE s.penname = :penname")
    , @NamedQuery(name = "SysAdmin.findByLogintimes", query = "SELECT s FROM SysAdmin s WHERE s.logintimes = :logintimes")
    , @NamedQuery(name = "SysAdmin.findByIslock", query = "SELECT s FROM SysAdmin s WHERE s.islock = :islock")
    , @NamedQuery(name = "SysAdmin.findByLastlogindate", query = "SELECT s FROM SysAdmin s WHERE s.lastlogindate = :lastlogindate")
    , @NamedQuery(name = "SysAdmin.findByLastloginip", query = "SELECT s FROM SysAdmin s WHERE s.lastloginip = :lastloginip")
    , @NamedQuery(name = "SysAdmin.findByOpenid", query = "SELECT s FROM SysAdmin s WHERE s.openid = :openid")
    , @NamedQuery(name = "SysAdmin.findByShID", query = "SELECT s FROM SysAdmin s WHERE s.shID = :shID")
    , @NamedQuery(name = "SysAdmin.findByInsRep", query = "SELECT s FROM SysAdmin s WHERE s.insRep = :insRep")
    , @NamedQuery(name = "SysAdmin.findByInsDate", query = "SELECT s FROM SysAdmin s WHERE s.insDate = :insDate")
    , @NamedQuery(name = "SysAdmin.findByUpdRep", query = "SELECT s FROM SysAdmin s WHERE s.updRep = :updRep")
    , @NamedQuery(name = "SysAdmin.findByUpdDate", query = "SELECT s FROM SysAdmin s WHERE s.updDate = :updDate")
    , @NamedQuery(name = "SysAdmin.findByDelFlg", query = "SELECT s FROM SysAdmin s WHERE s.delFlg = :delFlg")
    , @NamedQuery(name = "SysAdmin.findByVersion", query = "SELECT s FROM SysAdmin s WHERE s.version = :version")})
public class SysAdmin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "adminid")
    private Integer adminid;
    @Size(max = 20)
    @Column(name = "adminname")
    private String adminname;
    @Size(max = 20)
    @Column(name = "adminpass")
    private String adminpass;
    @Column(name = "groupid")
    private Integer groupid;
    @Size(max = 50)
    @Column(name = "penname")
    private String penname;
    @Column(name = "logintimes")
    private Integer logintimes;
    @Column(name = "islock")
    private Integer islock;
    @Column(name = "lastlogindate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastlogindate;
    @Size(max = 15)
    @Column(name = "lastloginip")
    private String lastloginip;
    @Size(max = 255)
    @Column(name = "openid")
    private String openid;
    @Column(name = "Sh_ID")
    private Long shID;
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

    public SysAdmin() {
    }

    public SysAdmin(Integer adminid) {
        this.adminid = adminid;
    }

    public SysAdmin(Integer adminid, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
        this.adminid = adminid;
        this.insRep = insRep;
        this.insDate = insDate;
        this.updRep = updRep;
        this.updDate = updDate;
        this.delFlg = delFlg;
        this.version = version;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getAdminpass() {
        return adminpass;
    }

    public void setAdminpass(String adminpass) {
        this.adminpass = adminpass;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getPenname() {
        return penname;
    }

    public void setPenname(String penname) {
        this.penname = penname;
    }

    public Integer getLogintimes() {
        return logintimes;
    }

    public void setLogintimes(Integer logintimes) {
        this.logintimes = logintimes;
    }

    public Integer getIslock() {
        return islock;
    }

    public void setIslock(Integer islock) {
        this.islock = islock;
    }

    public Date getLastlogindate() {
        return lastlogindate;
    }

    public void setLastlogindate(Date lastlogindate) {
        this.lastlogindate = lastlogindate;
    }

    public String getLastloginip() {
        return lastloginip;
    }

    public void setLastloginip(String lastloginip) {
        this.lastloginip = lastloginip;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Long getShID() {
        return shID;
    }

    public void setShID(Long shID) {
        this.shID = shID;
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
        hash += (adminid != null ? adminid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysAdmin)) {
            return false;
        }
        SysAdmin other = (SysAdmin) object;
        if ((this.adminid == null && other.adminid != null) || (this.adminid != null && !this.adminid.equals(other.adminid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.SysAdmin[ adminid=" + adminid + " ]";
    }
    
}
