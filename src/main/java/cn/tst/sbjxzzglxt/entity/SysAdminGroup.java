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
@Table(name = "sys_Admin_Group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysAdminGroup.findAll", query = "SELECT s FROM SysAdminGroup s")
    , @NamedQuery(name = "SysAdminGroup.findById", query = "SELECT s FROM SysAdminGroup s WHERE s.id = :id")
    , @NamedQuery(name = "SysAdminGroup.findByGroupname", query = "SELECT s FROM SysAdminGroup s WHERE s.groupname = :groupname")
    , @NamedQuery(name = "SysAdminGroup.findByGroupdesc", query = "SELECT s FROM SysAdminGroup s WHERE s.groupdesc = :groupdesc")
    , @NamedQuery(name = "SysAdminGroup.findByPagelever", query = "SELECT s FROM SysAdminGroup s WHERE s.pagelever = :pagelever")
    , @NamedQuery(name = "SysAdminGroup.findByCatearray", query = "SELECT s FROM SysAdminGroup s WHERE s.catearray = :catearray")
    , @NamedQuery(name = "SysAdminGroup.findByCatelever", query = "SELECT s FROM SysAdminGroup s WHERE s.catelever = :catelever")
    , @NamedQuery(name = "SysAdminGroup.findByCreatedate", query = "SELECT s FROM SysAdminGroup s WHERE s.createdate = :createdate")
    , @NamedQuery(name = "SysAdminGroup.findByInsRep", query = "SELECT s FROM SysAdminGroup s WHERE s.insRep = :insRep")
    , @NamedQuery(name = "SysAdminGroup.findByInsDate", query = "SELECT s FROM SysAdminGroup s WHERE s.insDate = :insDate")
    , @NamedQuery(name = "SysAdminGroup.findByUpdRep", query = "SELECT s FROM SysAdminGroup s WHERE s.updRep = :updRep")
    , @NamedQuery(name = "SysAdminGroup.findByUpdDate", query = "SELECT s FROM SysAdminGroup s WHERE s.updDate = :updDate")
    , @NamedQuery(name = "SysAdminGroup.findByDelFlg", query = "SELECT s FROM SysAdminGroup s WHERE s.delFlg = :delFlg")
    , @NamedQuery(name = "SysAdminGroup.findByVersion", query = "SELECT s FROM SysAdminGroup s WHERE s.version = :version")})
public class SysAdminGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "groupname")
    private String groupname;
    @Size(max = 50)
    @Column(name = "groupdesc")
    private String groupdesc;
    @Size(max = 1073741823)
    @Column(name = "pagelever")
    private String pagelever;
    @Size(max = 1073741823)
    @Column(name = "catearray")
    private String catearray;
    @Size(max = 1073741823)
    @Column(name = "catelever")
    private String catelever;
    @Column(name = "createdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
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

    public SysAdminGroup() {
    }

    public SysAdminGroup(Integer id) {
        this.id = id;
    }

    public SysAdminGroup(Integer id, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
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

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getGroupdesc() {
        return groupdesc;
    }

    public void setGroupdesc(String groupdesc) {
        this.groupdesc = groupdesc;
    }

    public String getPagelever() {
        return pagelever;
    }

    public void setPagelever(String pagelever) {
        this.pagelever = pagelever;
    }

    public String getCatearray() {
        return catearray;
    }

    public void setCatearray(String catearray) {
        this.catearray = catearray;
    }

    public String getCatelever() {
        return catelever;
    }

    public void setCatelever(String catelever) {
        this.catelever = catelever;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
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
        if (!(object instanceof SysAdminGroup)) {
            return false;
        }
        SysAdminGroup other = (SysAdminGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.SysAdminGroup[ id=" + id + " ]";
    }
    
}
