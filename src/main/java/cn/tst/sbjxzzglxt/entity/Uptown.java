/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author Aaron-PC-i3-4130
 */
@Entity
@Table(name = "Uptown")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uptown.findAll", query = "SELECT u FROM Uptown u WHERE u.delFlg = :delFlg")
    , @NamedQuery(name = "Uptown.findByUptownId", query = "SELECT u FROM Uptown u WHERE u.uptownId = :uptownId AND u.delFlg = :delFlg")
    , @NamedQuery(name = "Uptown.findByName", query = "SELECT u FROM Uptown u WHERE u.name = :name AND u.delFlg = :delFlg")
    , @NamedQuery(name = "Uptown.findByAppendix", query = "SELECT u FROM Uptown u WHERE u.appendix = :appendix AND u.delFlg = :delFlg")
    , @NamedQuery(name = "Uptown.findBySerialNum", query = "SELECT u FROM Uptown u WHERE u.serialNum = :serialNum AND u.delFlg = :delFlg")
    , @NamedQuery(name = "Uptown.findByPermit", query = "SELECT u FROM Uptown u WHERE u.permit = :permit AND u.delFlg = :delFlg")
    , @NamedQuery(name = "Uptown.findByUseID", query = "SELECT u FROM Uptown u WHERE u.useID = :useID AND u.delFlg = :delFlg")
    , @NamedQuery(name = "Uptown.findByAddress", query = "SELECT u FROM Uptown u WHERE u.address = :address AND u.delFlg = :delFlg")
    , @NamedQuery(name = "Uptown.findByTranssign", query = "SELECT u FROM Uptown u WHERE u.transsign = :transsign AND u.delFlg = :delFlg")
    , @NamedQuery(name = "Uptown.findBySegmentID", query = "SELECT u FROM Uptown u WHERE u.segmentID = :segmentID AND u.delFlg = :delFlg")
    , @NamedQuery(name = "Uptown.findByRegisterDate", query = "SELECT u FROM Uptown u WHERE u.registerDate = :registerDate AND u.delFlg = :delFlg")
    , @NamedQuery(name = "Uptown.findByIfXz", query = "SELECT u FROM Uptown u WHERE u.ifXz = :ifXz AND u.delFlg = :delFlg")
    , @NamedQuery(name = "Uptown.findByIfCqlw", query = "SELECT u FROM Uptown u WHERE u.ifCqlw = :ifCqlw AND u.delFlg = :delFlg")
    , @NamedQuery(name = "Uptown.findByInsRep", query = "SELECT u FROM Uptown u WHERE u.insRep = :insRep AND u.delFlg = :delFlg")
    , @NamedQuery(name = "Uptown.findByInsDate", query = "SELECT u FROM Uptown u WHERE u.insDate = :insDate AND u.delFlg = :delFlg")
    , @NamedQuery(name = "Uptown.findByUpdRep", query = "SELECT u FROM Uptown u WHERE u.updRep = :updRep AND u.delFlg = :delFlg")
    , @NamedQuery(name = "Uptown.findByUpdDate", query = "SELECT u FROM Uptown u WHERE u.updDate = :updDate AND u.delFlg = :delFlg")
    , @NamedQuery(name = "Uptown.findByDelFlg", query = "SELECT u FROM Uptown u WHERE u.delFlg = :delFlg")
    , @NamedQuery(name = "Uptown.findByVersion", query = "SELECT u FROM Uptown u WHERE u.version = :version AND u.delFlg = :delFlg")
    , @NamedQuery(name = "Uptown.findByLongtitude", query = "SELECT u FROM Uptown u WHERE u.longtitude = :longtitude AND u.delFlg = :delFlg")
    , @NamedQuery(name = "Uptown.findByLatitude", query = "SELECT u FROM Uptown u WHERE u.latitude = :latitude AND u.delFlg = :delFlg")})
public class Uptown extends BaseEntity implements Serializable {
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "longtitude")
    private Double longtitude;
    @Column(name = "latitude")
    private Double latitude;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "countOfListToAdd")
    private Integer countOfListToAdd;
    @Column(name = "countOfListToReply")
    private Integer countOfListToReply;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "UptownId")
    private String uptownId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Appendix")
    private String appendix;
    @Size(max = 6)
    @Column(name = "serialNum")
    private String serialNum;
    @Size(max = 40)
    @Column(name = "permit")
    private String permit;
    @Size(max = 40)
    @Column(name = "useID")
    private String useID;
    @Size(max = 40)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "transsign")
    private Character transsign;
    @Column(name = "segmentID")
    private Character segmentID;
    @Column(name = "register_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;
    @Column(name = "if_xz")
    private Character ifXz;
    @Column(name = "if_cqlw")
    private Character ifCqlw;

    public Uptown() {
    }

    public Uptown(String uptownId) {
        this.uptownId = uptownId;
    }

    public String getUptownId() {
        return uptownId;
    }

    public void setUptownId(String uptownId) {
        this.uptownId = uptownId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppendix() {
        return appendix;
    }

    public void setAppendix(String appendix) {
        this.appendix = appendix;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getPermit() {
        return permit;
    }

    public void setPermit(String permit) {
        this.permit = permit;
    }

    public String getUseID() {
        return useID;
    }

    public void setUseID(String useID) {
        this.useID = useID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Character getTranssign() {
        return transsign;
    }

    public void setTranssign(Character transsign) {
        this.transsign = transsign;
    }

    public Character getSegmentID() {
        return segmentID;
    }

    public void setSegmentID(Character segmentID) {
        this.segmentID = segmentID;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Character getIfXz() {
        return ifXz;
    }

    public void setIfXz(Character ifXz) {
        this.ifXz = ifXz;
    }

    public Character getIfCqlw() {
        return ifCqlw;
    }

    public void setIfCqlw(Character ifCqlw) {
        this.ifCqlw = ifCqlw;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uptownId != null ? uptownId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uptown)) {
            return false;
        }
        Uptown other = (Uptown) object;
        if ((this.uptownId == null && other.uptownId != null) || (this.uptownId != null && !this.uptownId.equals(other.uptownId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.Uptown[ uptownId=" + uptownId + " ]";
    }

    public Integer getCountOfListToAdd() {
        return countOfListToAdd;
    }

    public void setCountOfListToAdd(Integer countOfListToAdd) {
        this.countOfListToAdd = countOfListToAdd;
    }

    public Integer getCountOfListToReply() {
        return countOfListToReply;
    }

    public void setCountOfListToReply(Integer countOfListToReply) {
        this.countOfListToReply = countOfListToReply;
    }

    public Double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
