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
@Table(name = "sys_Menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysMenu.findAll", query = "SELECT s FROM SysMenu s")
    , @NamedQuery(name = "SysMenu.findById", query = "SELECT s FROM SysMenu s WHERE s.id = :id")
    , @NamedQuery(name = "SysMenu.findByClassName", query = "SELECT s FROM SysMenu s WHERE s.className = :className")
    , @NamedQuery(name = "SysMenu.findByFid", query = "SELECT s FROM SysMenu s WHERE s.fid = :fid")
    , @NamedQuery(name = "SysMenu.findByTypes", query = "SELECT s FROM SysMenu s WHERE s.types = :types")
    , @NamedQuery(name = "SysMenu.findByKeyword", query = "SELECT s FROM SysMenu s WHERE s.keyword = :keyword")
    , @NamedQuery(name = "SysMenu.findByUrl", query = "SELECT s FROM SysMenu s WHERE s.url = :url")
    , @NamedQuery(name = "SysMenu.findByNum", query = "SELECT s FROM SysMenu s WHERE s.num = :num")
    , @NamedQuery(name = "SysMenu.findByInsRep", query = "SELECT s FROM SysMenu s WHERE s.insRep = :insRep")
    , @NamedQuery(name = "SysMenu.findByInsDate", query = "SELECT s FROM SysMenu s WHERE s.insDate = :insDate")
    , @NamedQuery(name = "SysMenu.findByUpdRep", query = "SELECT s FROM SysMenu s WHERE s.updRep = :updRep")
    , @NamedQuery(name = "SysMenu.findByUpdDate", query = "SELECT s FROM SysMenu s WHERE s.updDate = :updDate")
    , @NamedQuery(name = "SysMenu.findByDelFlg", query = "SELECT s FROM SysMenu s WHERE s.delFlg = :delFlg")
    , @NamedQuery(name = "SysMenu.findByVersion", query = "SELECT s FROM SysMenu s WHERE s.version = :version")})
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "ClassName")
    private String className;
    @Column(name = "Fid")
    private Integer fid;
    @Size(max = 50)
    @Column(name = "Types")
    private String types;
    @Size(max = 50)
    @Column(name = "Keyword")
    private String keyword;
    @Size(max = 1073741823)
    @Column(name = "Url")
    private String url;
    @Column(name = "Num")
    private Integer num;
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

    public SysMenu() {
    }

    public SysMenu(Integer id) {
        this.id = id;
    }

    public SysMenu(Integer id, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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
        if (!(object instanceof SysMenu)) {
            return false;
        }
        SysMenu other = (SysMenu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.SysMenu[ id=" + id + " ]";
    }
    
}
