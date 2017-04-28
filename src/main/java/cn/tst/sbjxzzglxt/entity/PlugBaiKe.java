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
@Table(name = "Plug_BaiKe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlugBaiKe.findAll", query = "SELECT p FROM PlugBaiKe p")
    , @NamedQuery(name = "PlugBaiKe.findByPId", query = "SELECT p FROM PlugBaiKe p WHERE p.pId = :pId")
    , @NamedQuery(name = "PlugBaiKe.findByPClassId", query = "SELECT p FROM PlugBaiKe p WHERE p.pClassId = :pClassId")
    , @NamedQuery(name = "PlugBaiKe.findByPTitle", query = "SELECT p FROM PlugBaiKe p WHERE p.pTitle = :pTitle")
    , @NamedQuery(name = "PlugBaiKe.findByPPic", query = "SELECT p FROM PlugBaiKe p WHERE p.pPic = :pPic")
    , @NamedQuery(name = "PlugBaiKe.findByPUrl", query = "SELECT p FROM PlugBaiKe p WHERE p.pUrl = :pUrl")
    , @NamedQuery(name = "PlugBaiKe.findByPOpen", query = "SELECT p FROM PlugBaiKe p WHERE p.pOpen = :pOpen")
    , @NamedQuery(name = "PlugBaiKe.findByPDel", query = "SELECT p FROM PlugBaiKe p WHERE p.pDel = :pDel")
    , @NamedQuery(name = "PlugBaiKe.findByPisPic", query = "SELECT p FROM PlugBaiKe p WHERE p.pisPic = :pisPic")
    , @NamedQuery(name = "PlugBaiKe.findByInsRep", query = "SELECT p FROM PlugBaiKe p WHERE p.insRep = :insRep")
    , @NamedQuery(name = "PlugBaiKe.findByInsDate", query = "SELECT p FROM PlugBaiKe p WHERE p.insDate = :insDate")
    , @NamedQuery(name = "PlugBaiKe.findByUpdRep", query = "SELECT p FROM PlugBaiKe p WHERE p.updRep = :updRep")
    , @NamedQuery(name = "PlugBaiKe.findByUpdDate", query = "SELECT p FROM PlugBaiKe p WHERE p.updDate = :updDate")
    , @NamedQuery(name = "PlugBaiKe.findByDelFlg", query = "SELECT p FROM PlugBaiKe p WHERE p.delFlg = :delFlg")
    , @NamedQuery(name = "PlugBaiKe.findByVersion", query = "SELECT p FROM PlugBaiKe p WHERE p.version = :version")})
public class PlugBaiKe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "p_Id")
    private Integer pId;
    @Column(name = "p_ClassId")
    private Integer pClassId;
    @Size(max = 255)
    @Column(name = "p_Title")
    private String pTitle;
    @Size(max = 1073741823)
    @Column(name = "p_Pic")
    private String pPic;
    @Size(max = 1073741823)
    @Column(name = "p_Url")
    private String pUrl;
    @Column(name = "p_Open")
    private Integer pOpen;
    @Column(name = "p_Del")
    private Integer pDel;
    @Column(name = "p_isPic")
    private Integer pisPic;
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

    public PlugBaiKe() {
    }

    public PlugBaiKe(Integer pId) {
        this.pId = pId;
    }

    public PlugBaiKe(Integer pId, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
        this.pId = pId;
        this.insRep = insRep;
        this.insDate = insDate;
        this.updRep = updRep;
        this.updDate = updDate;
        this.delFlg = delFlg;
        this.version = version;
    }

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public Integer getPClassId() {
        return pClassId;
    }

    public void setPClassId(Integer pClassId) {
        this.pClassId = pClassId;
    }

    public String getPTitle() {
        return pTitle;
    }

    public void setPTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public String getPPic() {
        return pPic;
    }

    public void setPPic(String pPic) {
        this.pPic = pPic;
    }

    public String getPUrl() {
        return pUrl;
    }

    public void setPUrl(String pUrl) {
        this.pUrl = pUrl;
    }

    public Integer getPOpen() {
        return pOpen;
    }

    public void setPOpen(Integer pOpen) {
        this.pOpen = pOpen;
    }

    public Integer getPDel() {
        return pDel;
    }

    public void setPDel(Integer pDel) {
        this.pDel = pDel;
    }

    public Integer getPisPic() {
        return pisPic;
    }

    public void setPisPic(Integer pisPic) {
        this.pisPic = pisPic;
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
        hash += (pId != null ? pId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlugBaiKe)) {
            return false;
        }
        PlugBaiKe other = (PlugBaiKe) object;
        if ((this.pId == null && other.pId != null) || (this.pId != null && !this.pId.equals(other.pId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.PlugBaiKe[ pId=" + pId + " ]";
    }
    
}
