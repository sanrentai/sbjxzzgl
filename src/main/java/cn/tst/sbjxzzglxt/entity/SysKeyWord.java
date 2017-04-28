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
@Table(name = "sys_KeyWord")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysKeyWord.findAll", query = "SELECT s FROM SysKeyWord s")
    , @NamedQuery(name = "SysKeyWord.findByKId", query = "SELECT s FROM SysKeyWord s WHERE s.kId = :kId")
    , @NamedQuery(name = "SysKeyWord.findByKclassId", query = "SELECT s FROM SysKeyWord s WHERE s.kclassId = :kclassId")
    , @NamedQuery(name = "SysKeyWord.findByKkeyWord", query = "SELECT s FROM SysKeyWord s WHERE s.kkeyWord = :kkeyWord")
    , @NamedQuery(name = "SysKeyWord.findByKkeyWordbeizhu", query = "SELECT s FROM SysKeyWord s WHERE s.kkeyWordbeizhu = :kkeyWordbeizhu")
    , @NamedQuery(name = "SysKeyWord.findByKkeyType", query = "SELECT s FROM SysKeyWord s WHERE s.kkeyType = :kkeyType")
    , @NamedQuery(name = "SysKeyWord.findByKType", query = "SELECT s FROM SysKeyWord s WHERE s.kType = :kType")
    , @NamedQuery(name = "SysKeyWord.findByKText", query = "SELECT s FROM SysKeyWord s WHERE s.kText = :kText")
    , @NamedQuery(name = "SysKeyWord.findByKplugName", query = "SELECT s FROM SysKeyWord s WHERE s.kplugName = :kplugName")
    , @NamedQuery(name = "SysKeyWord.findByKplugParam", query = "SELECT s FROM SysKeyWord s WHERE s.kplugParam = :kplugParam")
    , @NamedQuery(name = "SysKeyWord.findByKHits", query = "SELECT s FROM SysKeyWord s WHERE s.kHits = :kHits")
    , @NamedQuery(name = "SysKeyWord.findByKAddtime", query = "SELECT s FROM SysKeyWord s WHERE s.kAddtime = :kAddtime")
    , @NamedQuery(name = "SysKeyWord.findByKNum", query = "SELECT s FROM SysKeyWord s WHERE s.kNum = :kNum")
    , @NamedQuery(name = "SysKeyWord.findByCoupID", query = "SELECT s FROM SysKeyWord s WHERE s.coupID = :coupID")
    , @NamedQuery(name = "SysKeyWord.findByCoupDate", query = "SELECT s FROM SysKeyWord s WHERE s.coupDate = :coupDate")
    , @NamedQuery(name = "SysKeyWord.findByInsRep", query = "SELECT s FROM SysKeyWord s WHERE s.insRep = :insRep")
    , @NamedQuery(name = "SysKeyWord.findByInsDate", query = "SELECT s FROM SysKeyWord s WHERE s.insDate = :insDate")
    , @NamedQuery(name = "SysKeyWord.findByUpdRep", query = "SELECT s FROM SysKeyWord s WHERE s.updRep = :updRep")
    , @NamedQuery(name = "SysKeyWord.findByUpdDate", query = "SELECT s FROM SysKeyWord s WHERE s.updDate = :updDate")
    , @NamedQuery(name = "SysKeyWord.findByDelFlg", query = "SELECT s FROM SysKeyWord s WHERE s.delFlg = :delFlg")
    , @NamedQuery(name = "SysKeyWord.findByVersion", query = "SELECT s FROM SysKeyWord s WHERE s.version = :version")})
public class SysKeyWord implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "k_id")
    private Integer kId;
    @Column(name = "k_classId")
    private Integer kclassId;
    @Size(max = 255)
    @Column(name = "k_keyWord")
    private String kkeyWord;
    @Size(max = 255)
    @Column(name = "k_keyWord_beizhu")
    private String kkeyWordbeizhu;
    @Size(max = 50)
    @Column(name = "k_keyType")
    private String kkeyType;
    @Size(max = 50)
    @Column(name = "k_type")
    private String kType;
    @Size(max = 1073741823)
    @Column(name = "k_text")
    private String kText;
    @Size(max = 50)
    @Column(name = "k_plugName")
    private String kplugName;
    @Size(max = 1073741823)
    @Column(name = "k_plugParam")
    private String kplugParam;
    @Column(name = "k_hits")
    private Integer kHits;
    @Column(name = "k_addtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date kAddtime;
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

    public SysKeyWord() {
    }

    public SysKeyWord(Integer kId) {
        this.kId = kId;
    }

    public SysKeyWord(Integer kId, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
        this.kId = kId;
        this.insRep = insRep;
        this.insDate = insDate;
        this.updRep = updRep;
        this.updDate = updDate;
        this.delFlg = delFlg;
        this.version = version;
    }

    public Integer getKId() {
        return kId;
    }

    public void setKId(Integer kId) {
        this.kId = kId;
    }

    public Integer getKclassId() {
        return kclassId;
    }

    public void setKclassId(Integer kclassId) {
        this.kclassId = kclassId;
    }

    public String getKkeyWord() {
        return kkeyWord;
    }

    public void setKkeyWord(String kkeyWord) {
        this.kkeyWord = kkeyWord;
    }

    public String getKkeyWordbeizhu() {
        return kkeyWordbeizhu;
    }

    public void setKkeyWordbeizhu(String kkeyWordbeizhu) {
        this.kkeyWordbeizhu = kkeyWordbeizhu;
    }

    public String getKkeyType() {
        return kkeyType;
    }

    public void setKkeyType(String kkeyType) {
        this.kkeyType = kkeyType;
    }

    public String getKType() {
        return kType;
    }

    public void setKType(String kType) {
        this.kType = kType;
    }

    public String getKText() {
        return kText;
    }

    public void setKText(String kText) {
        this.kText = kText;
    }

    public String getKplugName() {
        return kplugName;
    }

    public void setKplugName(String kplugName) {
        this.kplugName = kplugName;
    }

    public String getKplugParam() {
        return kplugParam;
    }

    public void setKplugParam(String kplugParam) {
        this.kplugParam = kplugParam;
    }

    public Integer getKHits() {
        return kHits;
    }

    public void setKHits(Integer kHits) {
        this.kHits = kHits;
    }

    public Date getKAddtime() {
        return kAddtime;
    }

    public void setKAddtime(Date kAddtime) {
        this.kAddtime = kAddtime;
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
        hash += (kId != null ? kId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysKeyWord)) {
            return false;
        }
        SysKeyWord other = (SysKeyWord) object;
        if ((this.kId == null && other.kId != null) || (this.kId != null && !this.kId.equals(other.kId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.SysKeyWord[ kId=" + kId + " ]";
    }
    
}
