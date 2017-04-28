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
@Table(name = "Plug_PicMsg")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlugPicMsg.findAll", query = "SELECT p FROM PlugPicMsg p")
    , @NamedQuery(name = "PlugPicMsg.findByPId", query = "SELECT p FROM PlugPicMsg p WHERE p.pId = :pId")
    , @NamedQuery(name = "PlugPicMsg.findByPClassId", query = "SELECT p FROM PlugPicMsg p WHERE p.pClassId = :pClassId")
    , @NamedQuery(name = "PlugPicMsg.findByPTitle", query = "SELECT p FROM PlugPicMsg p WHERE p.pTitle = :pTitle")
    , @NamedQuery(name = "PlugPicMsg.findByPInfo", query = "SELECT p FROM PlugPicMsg p WHERE p.pInfo = :pInfo")
    , @NamedQuery(name = "PlugPicMsg.findByPPic", query = "SELECT p FROM PlugPicMsg p WHERE p.pPic = :pPic")
    , @NamedQuery(name = "PlugPicMsg.findByPType", query = "SELECT p FROM PlugPicMsg p WHERE p.pType = :pType")
    , @NamedQuery(name = "PlugPicMsg.findByPContent", query = "SELECT p FROM PlugPicMsg p WHERE p.pContent = :pContent")
    , @NamedQuery(name = "PlugPicMsg.findByPUrlType", query = "SELECT p FROM PlugPicMsg p WHERE p.pUrlType = :pUrlType")
    , @NamedQuery(name = "PlugPicMsg.findByPUrl", query = "SELECT p FROM PlugPicMsg p WHERE p.pUrl = :pUrl")
    , @NamedQuery(name = "PlugPicMsg.findByPHits", query = "SELECT p FROM PlugPicMsg p WHERE p.pHits = :pHits")
    , @NamedQuery(name = "PlugPicMsg.findByPAddtime", query = "SELECT p FROM PlugPicMsg p WHERE p.pAddtime = :pAddtime")
    , @NamedQuery(name = "PlugPicMsg.findByProComID", query = "SELECT p FROM PlugPicMsg p WHERE p.proComID = :proComID")
    , @NamedQuery(name = "PlugPicMsg.findByAreaID", query = "SELECT p FROM PlugPicMsg p WHERE p.areaID = :areaID")
    , @NamedQuery(name = "PlugPicMsg.findByMaketID", query = "SELECT p FROM PlugPicMsg p WHERE p.maketID = :maketID")
    , @NamedQuery(name = "PlugPicMsg.findByHtID", query = "SELECT p FROM PlugPicMsg p WHERE p.htID = :htID")
    , @NamedQuery(name = "PlugPicMsg.findByInsRep", query = "SELECT p FROM PlugPicMsg p WHERE p.insRep = :insRep")
    , @NamedQuery(name = "PlugPicMsg.findByInsDate", query = "SELECT p FROM PlugPicMsg p WHERE p.insDate = :insDate")
    , @NamedQuery(name = "PlugPicMsg.findByUpdRep", query = "SELECT p FROM PlugPicMsg p WHERE p.updRep = :updRep")
    , @NamedQuery(name = "PlugPicMsg.findByUpdDate", query = "SELECT p FROM PlugPicMsg p WHERE p.updDate = :updDate")
    , @NamedQuery(name = "PlugPicMsg.findByDelFlg", query = "SELECT p FROM PlugPicMsg p WHERE p.delFlg = :delFlg")
    , @NamedQuery(name = "PlugPicMsg.findByVersion", query = "SELECT p FROM PlugPicMsg p WHERE p.version = :version")})
public class PlugPicMsg implements Serializable {

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
    @Column(name = "p_Info")
    private String pInfo;
    @Size(max = 1073741823)
    @Column(name = "p_Pic")
    private String pPic;
    @Size(max = 50)
    @Column(name = "p_Type")
    private String pType;
    @Size(max = 1073741823)
    @Column(name = "p_Content")
    private String pContent;
    @Size(max = 50)
    @Column(name = "p_UrlType")
    private String pUrlType;
    @Size(max = 1073741823)
    @Column(name = "p_Url")
    private String pUrl;
    @Column(name = "p_Hits")
    private Integer pHits;
    @Column(name = "p_Addtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pAddtime;
    @Column(name = "ProComID")
    private Long proComID;
    @Column(name = "AreaID")
    private Long areaID;
    @Column(name = "MaketID")
    private Long maketID;
    @Column(name = "HtID")
    private Long htID;
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

    public PlugPicMsg() {
    }

    public PlugPicMsg(Integer pId) {
        this.pId = pId;
    }

    public PlugPicMsg(Integer pId, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
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

    public String getPInfo() {
        return pInfo;
    }

    public void setPInfo(String pInfo) {
        this.pInfo = pInfo;
    }

    public String getPPic() {
        return pPic;
    }

    public void setPPic(String pPic) {
        this.pPic = pPic;
    }

    public String getPType() {
        return pType;
    }

    public void setPType(String pType) {
        this.pType = pType;
    }

    public String getPContent() {
        return pContent;
    }

    public void setPContent(String pContent) {
        this.pContent = pContent;
    }

    public String getPUrlType() {
        return pUrlType;
    }

    public void setPUrlType(String pUrlType) {
        this.pUrlType = pUrlType;
    }

    public String getPUrl() {
        return pUrl;
    }

    public void setPUrl(String pUrl) {
        this.pUrl = pUrl;
    }

    public Integer getPHits() {
        return pHits;
    }

    public void setPHits(Integer pHits) {
        this.pHits = pHits;
    }

    public Date getPAddtime() {
        return pAddtime;
    }

    public void setPAddtime(Date pAddtime) {
        this.pAddtime = pAddtime;
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

    public Long getMaketID() {
        return maketID;
    }

    public void setMaketID(Long maketID) {
        this.maketID = maketID;
    }

    public Long getHtID() {
        return htID;
    }

    public void setHtID(Long htID) {
        this.htID = htID;
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
        if (!(object instanceof PlugPicMsg)) {
            return false;
        }
        PlugPicMsg other = (PlugPicMsg) object;
        if ((this.pId == null && other.pId != null) || (this.pId != null && !this.pId.equals(other.pId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.PlugPicMsg[ pId=" + pId + " ]";
    }
    
}
