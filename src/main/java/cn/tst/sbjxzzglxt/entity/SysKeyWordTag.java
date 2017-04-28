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
@Table(name = "sys_KeyWord_Tag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysKeyWordTag.findAll", query = "SELECT s FROM SysKeyWordTag s")
    , @NamedQuery(name = "SysKeyWordTag.findById", query = "SELECT s FROM SysKeyWordTag s WHERE s.id = :id")
    , @NamedQuery(name = "SysKeyWordTag.findByKKeyword", query = "SELECT s FROM SysKeyWordTag s WHERE s.kKeyword = :kKeyword")
    , @NamedQuery(name = "SysKeyWordTag.findByKId", query = "SELECT s FROM SysKeyWordTag s WHERE s.kId = :kId")
    , @NamedQuery(name = "SysKeyWordTag.findByKkeyType", query = "SELECT s FROM SysKeyWordTag s WHERE s.kkeyType = :kkeyType")
    , @NamedQuery(name = "SysKeyWordTag.findByKkeyTypenum", query = "SELECT s FROM SysKeyWordTag s WHERE s.kkeyTypenum = :kkeyTypenum")
    , @NamedQuery(name = "SysKeyWordTag.findByKHit", query = "SELECT s FROM SysKeyWordTag s WHERE s.kHit = :kHit")
    , @NamedQuery(name = "SysKeyWordTag.findByKNum", query = "SELECT s FROM SysKeyWordTag s WHERE s.kNum = :kNum")
    , @NamedQuery(name = "SysKeyWordTag.findByCoupID", query = "SELECT s FROM SysKeyWordTag s WHERE s.coupID = :coupID")
    , @NamedQuery(name = "SysKeyWordTag.findByCoupDate", query = "SELECT s FROM SysKeyWordTag s WHERE s.coupDate = :coupDate")
    , @NamedQuery(name = "SysKeyWordTag.findByInsRep", query = "SELECT s FROM SysKeyWordTag s WHERE s.insRep = :insRep")
    , @NamedQuery(name = "SysKeyWordTag.findByInsDate", query = "SELECT s FROM SysKeyWordTag s WHERE s.insDate = :insDate")
    , @NamedQuery(name = "SysKeyWordTag.findByUpdRep", query = "SELECT s FROM SysKeyWordTag s WHERE s.updRep = :updRep")
    , @NamedQuery(name = "SysKeyWordTag.findByUpdDate", query = "SELECT s FROM SysKeyWordTag s WHERE s.updDate = :updDate")
    , @NamedQuery(name = "SysKeyWordTag.findByDelFlg", query = "SELECT s FROM SysKeyWordTag s WHERE s.delFlg = :delFlg")
    , @NamedQuery(name = "SysKeyWordTag.findByVersion", query = "SELECT s FROM SysKeyWordTag s WHERE s.version = :version")})
public class SysKeyWordTag implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "k_keyword")
    private String kKeyword;
    @Column(name = "k_id")
    private Integer kId;
    @Size(max = 50)
    @Column(name = "k_keyType")
    private String kkeyType;
    @Column(name = "k_keyType_num")
    private Integer kkeyTypenum;
    @Column(name = "k_hit")
    private Integer kHit;
    @Column(name = "k_num")
    private Integer kNum;
    @Column(name = "Coup_ID")
    private Long coupID;
    @Column(name = "Coup_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date coupDate;
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

    public SysKeyWordTag() {
    }

    public SysKeyWordTag(Integer id) {
        this.id = id;
    }

    public SysKeyWordTag(Integer id, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
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

    public String getKKeyword() {
        return kKeyword;
    }

    public void setKKeyword(String kKeyword) {
        this.kKeyword = kKeyword;
    }

    public Integer getKId() {
        return kId;
    }

    public void setKId(Integer kId) {
        this.kId = kId;
    }

    public String getKkeyType() {
        return kkeyType;
    }

    public void setKkeyType(String kkeyType) {
        this.kkeyType = kkeyType;
    }

    public Integer getKkeyTypenum() {
        return kkeyTypenum;
    }

    public void setKkeyTypenum(Integer kkeyTypenum) {
        this.kkeyTypenum = kkeyTypenum;
    }

    public Integer getKHit() {
        return kHit;
    }

    public void setKHit(Integer kHit) {
        this.kHit = kHit;
    }

    public Integer getKNum() {
        return kNum;
    }

    public void setKNum(Integer kNum) {
        this.kNum = kNum;
    }

    public Long getCoupID() {
        return coupID;
    }

    public void setCoupID(Long coupID) {
        this.coupID = coupID;
    }

    public Date getCoupDate() {
        return coupDate;
    }

    public void setCoupDate(Date coupDate) {
        this.coupDate = coupDate;
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
        if (!(object instanceof SysKeyWordTag)) {
            return false;
        }
        SysKeyWordTag other = (SysKeyWordTag) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.SysKeyWordTag[ id=" + id + " ]";
    }
    
}
