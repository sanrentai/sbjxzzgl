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
@Table(name = "sys_User")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysUser.findAll", query = "SELECT s FROM SysUser s")
    , @NamedQuery(name = "SysUser.findById", query = "SELECT s FROM SysUser s WHERE s.id = :id")
    , @NamedQuery(name = "SysUser.findByOpenid", query = "SELECT s FROM SysUser s WHERE s.openid = :openid")
    , @NamedQuery(name = "SysUser.findByNickname", query = "SELECT s FROM SysUser s WHERE s.nickname = :nickname")
    , @NamedQuery(name = "SysUser.findBySex", query = "SELECT s FROM SysUser s WHERE s.sex = :sex")
    , @NamedQuery(name = "SysUser.findByCity", query = "SELECT s FROM SysUser s WHERE s.city = :city")
    , @NamedQuery(name = "SysUser.findByCountry", query = "SELECT s FROM SysUser s WHERE s.country = :country")
    , @NamedQuery(name = "SysUser.findByProvince", query = "SELECT s FROM SysUser s WHERE s.province = :province")
    , @NamedQuery(name = "SysUser.findByLanguage", query = "SELECT s FROM SysUser s WHERE s.language = :language")
    , @NamedQuery(name = "SysUser.findByHeadimgurl", query = "SELECT s FROM SysUser s WHERE s.headimgurl = :headimgurl")
    , @NamedQuery(name = "SysUser.findBySubscribeTime", query = "SELECT s FROM SysUser s WHERE s.subscribeTime = :subscribeTime")
    , @NamedQuery(name = "SysUser.findByRemark", query = "SELECT s FROM SysUser s WHERE s.remark = :remark")
    , @NamedQuery(name = "SysUser.findByGroupid", query = "SELECT s FROM SysUser s WHERE s.groupid = :groupid")
    , @NamedQuery(name = "SysUser.findBySceneStr", query = "SELECT s FROM SysUser s WHERE s.sceneStr = :sceneStr")
    , @NamedQuery(name = "SysUser.findByTagID", query = "SELECT s FROM SysUser s WHERE s.tagID = :tagID")
    , @NamedQuery(name = "SysUser.findByProComID", query = "SELECT s FROM SysUser s WHERE s.proComID = :proComID")
    , @NamedQuery(name = "SysUser.findByAreaID", query = "SELECT s FROM SysUser s WHERE s.areaID = :areaID")
    , @NamedQuery(name = "SysUser.findBySouID", query = "SELECT s FROM SysUser s WHERE s.souID = :souID")
    , @NamedQuery(name = "SysUser.findByInsRep", query = "SELECT s FROM SysUser s WHERE s.insRep = :insRep")
    , @NamedQuery(name = "SysUser.findByInsDate", query = "SELECT s FROM SysUser s WHERE s.insDate = :insDate")
    , @NamedQuery(name = "SysUser.findByUpdRep", query = "SELECT s FROM SysUser s WHERE s.updRep = :updRep")
    , @NamedQuery(name = "SysUser.findByUpdDate", query = "SELECT s FROM SysUser s WHERE s.updDate = :updDate")
    , @NamedQuery(name = "SysUser.findByDelFlg", query = "SELECT s FROM SysUser s WHERE s.delFlg = :delFlg")
    , @NamedQuery(name = "SysUser.findByVersion", query = "SELECT s FROM SysUser s WHERE s.version = :version")})
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "openid")
    private String openid;
    @Size(max = 200)
    @Column(name = "nickname")
    private String nickname;
    @Size(max = 50)
    @Column(name = "sex")
    private String sex;
    @Size(max = 50)
    @Column(name = "city")
    private String city;
    @Size(max = 50)
    @Column(name = "country")
    private String country;
    @Size(max = 50)
    @Column(name = "province")
    private String province;
    @Size(max = 50)
    @Column(name = "language")
    private String language;
    @Size(max = 1073741823)
    @Column(name = "headimgurl")
    private String headimgurl;
    @Column(name = "subscribe_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date subscribeTime;
    @Size(max = 50)
    @Column(name = "remark")
    private String remark;
    @Column(name = "groupid")
    private Integer groupid;
    @Size(max = 50)
    @Column(name = "scene_str")
    private String sceneStr;
    @Size(max = 2147483647)
    @Column(name = "TagID")
    private String tagID;
    @Column(name = "ProComID")
    private Long proComID;
    @Column(name = "AreaID")
    private Long areaID;
    @Column(name = "SouID")
    private Long souID;
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

    public SysUser() {
    }

    public SysUser(Integer id) {
        this.id = id;
    }

    public SysUser(Integer id, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public Date getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Date subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getSceneStr() {
        return sceneStr;
    }

    public void setSceneStr(String sceneStr) {
        this.sceneStr = sceneStr;
    }

    public String getTagID() {
        return tagID;
    }

    public void setTagID(String tagID) {
        this.tagID = tagID;
    }

    public Long getProComID() {
        return proComID;
    }

    public void setProComID(Long proComID) {
        this.proComID = proComID;
    }

    public Long getAreaID() {
        return areaID;
    }

    public void setAreaID(Long areaID) {
        this.areaID = areaID;
    }

    public Long getSouID() {
        return souID;
    }

    public void setSouID(Long souID) {
        this.souID = souID;
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
        if (!(object instanceof SysUser)) {
            return false;
        }
        SysUser other = (SysUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.SysUser[ id=" + id + " ]";
    }
    
}
