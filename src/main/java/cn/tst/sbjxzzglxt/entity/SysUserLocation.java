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
@Table(name = "sys_User_Location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysUserLocation.findAll", query = "SELECT s FROM SysUserLocation s")
    , @NamedQuery(name = "SysUserLocation.findById", query = "SELECT s FROM SysUserLocation s WHERE s.id = :id")
    , @NamedQuery(name = "SysUserLocation.findByOpenId", query = "SELECT s FROM SysUserLocation s WHERE s.openId = :openId")
    , @NamedQuery(name = "SysUserLocation.findByLatitude", query = "SELECT s FROM SysUserLocation s WHERE s.latitude = :latitude")
    , @NamedQuery(name = "SysUserLocation.findByLongitude", query = "SELECT s FROM SysUserLocation s WHERE s.longitude = :longitude")
    , @NamedQuery(name = "SysUserLocation.findByPrecision", query = "SELECT s FROM SysUserLocation s WHERE s.precision = :precision")
    , @NamedQuery(name = "SysUserLocation.findByAddTime", query = "SELECT s FROM SysUserLocation s WHERE s.addTime = :addTime")
    , @NamedQuery(name = "SysUserLocation.findByPosition", query = "SELECT s FROM SysUserLocation s WHERE s.position = :position")
    , @NamedQuery(name = "SysUserLocation.findByInsRep", query = "SELECT s FROM SysUserLocation s WHERE s.insRep = :insRep")
    , @NamedQuery(name = "SysUserLocation.findByInsDate", query = "SELECT s FROM SysUserLocation s WHERE s.insDate = :insDate")
    , @NamedQuery(name = "SysUserLocation.findByUpdRep", query = "SELECT s FROM SysUserLocation s WHERE s.updRep = :updRep")
    , @NamedQuery(name = "SysUserLocation.findByUpdDate", query = "SELECT s FROM SysUserLocation s WHERE s.updDate = :updDate")
    , @NamedQuery(name = "SysUserLocation.findByDelFlg", query = "SELECT s FROM SysUserLocation s WHERE s.delFlg = :delFlg")
    , @NamedQuery(name = "SysUserLocation.findByVersion", query = "SELECT s FROM SysUserLocation s WHERE s.version = :version")})
public class SysUserLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "OpenId")
    private String openId;
    @Size(max = 50)
    @Column(name = "Latitude")
    private String latitude;
    @Size(max = 50)
    @Column(name = "Longitude")
    private String longitude;
    @Size(max = 50)
    @Column(name = "Precision")
    private String precision;
    @Column(name = "AddTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addTime;
    @Size(max = 1073741823)
    @Column(name = "Position ")
    private String position;
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

    public SysUserLocation() {
    }

    public SysUserLocation(Integer id) {
        this.id = id;
    }

    public SysUserLocation(Integer id, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
        this.id = id;
        this.insRep = insRep;
        this.insDate = insDate;
        this.updRep = updRep;
        this.updDate = updDate;
        this.delFlg = delFlg;
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysUserLocation)) {
            return false;
        }
        SysUserLocation other = (SysUserLocation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.SysUserLocation[ id=" + id + " ]";
    }
    
}
