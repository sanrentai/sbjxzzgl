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
@Table(name = "sys_Source")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysSource.findAll", query = "SELECT s FROM SysSource s")
    , @NamedQuery(name = "SysSource.findById", query = "SELECT s FROM SysSource s WHERE s.id = :id")
    , @NamedQuery(name = "SysSource.findBySource", query = "SELECT s FROM SysSource s WHERE s.source = :source")
    , @NamedQuery(name = "SysSource.findBySContent", query = "SELECT s FROM SysSource s WHERE s.sContent = :sContent")
    , @NamedQuery(name = "SysSource.findByQrcode", query = "SELECT s FROM SysSource s WHERE s.qrcode = :qrcode")
    , @NamedQuery(name = "SysSource.findByAddDate", query = "SELECT s FROM SysSource s WHERE s.addDate = :addDate")
    , @NamedQuery(name = "SysSource.findByState", query = "SELECT s FROM SysSource s WHERE s.state = :state")
    , @NamedQuery(name = "SysSource.findByInsRep", query = "SELECT s FROM SysSource s WHERE s.insRep = :insRep")
    , @NamedQuery(name = "SysSource.findByInsDate", query = "SELECT s FROM SysSource s WHERE s.insDate = :insDate")
    , @NamedQuery(name = "SysSource.findByUpdRep", query = "SELECT s FROM SysSource s WHERE s.updRep = :updRep")
    , @NamedQuery(name = "SysSource.findByUpdDate", query = "SELECT s FROM SysSource s WHERE s.updDate = :updDate")
    , @NamedQuery(name = "SysSource.findByDelFlg", query = "SELECT s FROM SysSource s WHERE s.delFlg = :delFlg")
    , @NamedQuery(name = "SysSource.findByVersion", query = "SELECT s FROM SysSource s WHERE s.version = :version")})
public class SysSource implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 50)
    @Column(name = "Source")
    private String source;
    @Size(max = 2147483647)
    @Column(name = "S_Content")
    private String sContent;
    @Size(max = 150)
    @Column(name = "Qrcode")
    private String qrcode;
    @Column(name = "Add_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addDate;
    @Column(name = "State")
    private Integer state;
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

    public SysSource() {
    }

    public SysSource(Long id) {
        this.id = id;
    }

    public SysSource(Long id, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
        this.id = id;
        this.insRep = insRep;
        this.insDate = insDate;
        this.updRep = updRep;
        this.updDate = updDate;
        this.delFlg = delFlg;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSContent() {
        return sContent;
    }

    public void setSContent(String sContent) {
        this.sContent = sContent;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
        if (!(object instanceof SysSource)) {
            return false;
        }
        SysSource other = (SysSource) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.SysSource[ id=" + id + " ]";
    }
    
}
