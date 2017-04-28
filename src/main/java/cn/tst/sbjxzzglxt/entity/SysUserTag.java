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
@Table(name = "sys_User_Tag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysUserTag.findAll", query = "SELECT s FROM SysUserTag s")
    , @NamedQuery(name = "SysUserTag.findById", query = "SELECT s FROM SysUserTag s WHERE s.id = :id")
    , @NamedQuery(name = "SysUserTag.findByTagID", query = "SELECT s FROM SysUserTag s WHERE s.tagID = :tagID")
    , @NamedQuery(name = "SysUserTag.findByTagName", query = "SELECT s FROM SysUserTag s WHERE s.tagName = :tagName")
    , @NamedQuery(name = "SysUserTag.findByTagCount", query = "SELECT s FROM SysUserTag s WHERE s.tagCount = :tagCount")
    , @NamedQuery(name = "SysUserTag.findByInsRep", query = "SELECT s FROM SysUserTag s WHERE s.insRep = :insRep")
    , @NamedQuery(name = "SysUserTag.findByInsDate", query = "SELECT s FROM SysUserTag s WHERE s.insDate = :insDate")
    , @NamedQuery(name = "SysUserTag.findByUpdRep", query = "SELECT s FROM SysUserTag s WHERE s.updRep = :updRep")
    , @NamedQuery(name = "SysUserTag.findByUpdDate", query = "SELECT s FROM SysUserTag s WHERE s.updDate = :updDate")
    , @NamedQuery(name = "SysUserTag.findByDelFlg", query = "SELECT s FROM SysUserTag s WHERE s.delFlg = :delFlg")
    , @NamedQuery(name = "SysUserTag.findByVersion", query = "SELECT s FROM SysUserTag s WHERE s.version = :version")})
public class SysUserTag implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Column(name = "TagID")
    private Integer tagID;
    @Size(max = 50)
    @Column(name = "TagName")
    private String tagName;
    @Column(name = "TagCount")
    private Integer tagCount;
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

    public SysUserTag() {
    }

    public SysUserTag(Integer id) {
        this.id = id;
    }

    public SysUserTag(Integer id, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
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

    public Integer getTagID() {
        return tagID;
    }

    public void setTagID(Integer tagID) {
        this.tagID = tagID;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getTagCount() {
        return tagCount;
    }

    public void setTagCount(Integer tagCount) {
        this.tagCount = tagCount;
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
        if (!(object instanceof SysUserTag)) {
            return false;
        }
        SysUserTag other = (SysUserTag) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.SysUserTag[ id=" + id + " ]";
    }
    
}
