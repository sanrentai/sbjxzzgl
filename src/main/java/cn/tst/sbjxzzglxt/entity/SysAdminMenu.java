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
@Table(name = "sys_Admin_Menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysAdminMenu.findAll", query = "SELECT s FROM SysAdminMenu s")
    , @NamedQuery(name = "SysAdminMenu.findById", query = "SELECT s FROM SysAdminMenu s WHERE s.id = :id")
    , @NamedQuery(name = "SysAdminMenu.findByTitle", query = "SELECT s FROM SysAdminMenu s WHERE s.title = :title")
    , @NamedQuery(name = "SysAdminMenu.findByUrl", query = "SELECT s FROM SysAdminMenu s WHERE s.url = :url")
    , @NamedQuery(name = "SysAdminMenu.findByFollowid", query = "SELECT s FROM SysAdminMenu s WHERE s.followid = :followid")
    , @NamedQuery(name = "SysAdminMenu.findByMenuid", query = "SELECT s FROM SysAdminMenu s WHERE s.menuid = :menuid")
    , @NamedQuery(name = "SysAdminMenu.findByOrdnum", query = "SELECT s FROM SysAdminMenu s WHERE s.ordnum = :ordnum")
    , @NamedQuery(name = "SysAdminMenu.findByIslock", query = "SELECT s FROM SysAdminMenu s WHERE s.islock = :islock")
    , @NamedQuery(name = "SysAdminMenu.findByInsRep", query = "SELECT s FROM SysAdminMenu s WHERE s.insRep = :insRep")
    , @NamedQuery(name = "SysAdminMenu.findByInsDate", query = "SELECT s FROM SysAdminMenu s WHERE s.insDate = :insDate")
    , @NamedQuery(name = "SysAdminMenu.findByUpdRep", query = "SELECT s FROM SysAdminMenu s WHERE s.updRep = :updRep")
    , @NamedQuery(name = "SysAdminMenu.findByUpdDate", query = "SELECT s FROM SysAdminMenu s WHERE s.updDate = :updDate")
    , @NamedQuery(name = "SysAdminMenu.findByDelFlg", query = "SELECT s FROM SysAdminMenu s WHERE s.delFlg = :delFlg")
    , @NamedQuery(name = "SysAdminMenu.findByVersion", query = "SELECT s FROM SysAdminMenu s WHERE s.version = :version")})
public class SysAdminMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "title")
    private String title;
    @Size(max = 1073741823)
    @Column(name = "url")
    private String url;
    @Column(name = "followid")
    private Integer followid;
    @Column(name = "menuid")
    private Integer menuid;
    @Column(name = "ordnum")
    private Integer ordnum;
    @Column(name = "islock")
    private Integer islock;
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

    public SysAdminMenu() {
    }

    public SysAdminMenu(Integer id) {
        this.id = id;
    }

    public SysAdminMenu(Integer id, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getFollowid() {
        return followid;
    }

    public void setFollowid(Integer followid) {
        this.followid = followid;
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public Integer getOrdnum() {
        return ordnum;
    }

    public void setOrdnum(Integer ordnum) {
        this.ordnum = ordnum;
    }

    public Integer getIslock() {
        return islock;
    }

    public void setIslock(Integer islock) {
        this.islock = islock;
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
        if (!(object instanceof SysAdminMenu)) {
            return false;
        }
        SysAdminMenu other = (SysAdminMenu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.SysAdminMenu[ id=" + id + " ]";
    }
    
}
