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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "Blocks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Blocks.findAll", query = "SELECT b FROM Blocks b WHERE b.delFlg = :delFlg")
    , @NamedQuery(name = "Blocks.findById", query = "SELECT b FROM Blocks b WHERE b.id = :id AND b.delFlg = :delFlg")
    , @NamedQuery(name = "Blocks.findByName", query = "SELECT b FROM Blocks b WHERE b.name = :name AND b.delFlg = :delFlg")
    , @NamedQuery(name = "Blocks.findByAddress", query = "SELECT b FROM Blocks b WHERE b.address = :address AND b.delFlg = :delFlg")
    , @NamedQuery(name = "Blocks.findByLongtitude", query = "SELECT b FROM Blocks b WHERE b.longtitude = :longtitude AND b.delFlg = :delFlg")
    , @NamedQuery(name = "Blocks.findByLatitude", query = "SELECT b FROM Blocks b WHERE b.latitude = :latitude AND b.delFlg = :delFlg")
    , @NamedQuery(name = "Blocks.findByInsRep", query = "SELECT b FROM Blocks b WHERE b.insRep = :insRep AND b.delFlg = :delFlg")
    , @NamedQuery(name = "Blocks.findByInsDate", query = "SELECT b FROM Blocks b WHERE b.insDate = :insDate AND b.delFlg = :delFlg")
    , @NamedQuery(name = "Blocks.findByUpdRep", query = "SELECT b FROM Blocks b WHERE b.updRep = :updRep AND b.delFlg = :delFlg")
    , @NamedQuery(name = "Blocks.findByUpdDate", query = "SELECT b FROM Blocks b WHERE b.updDate = :updDate AND b.delFlg = :delFlg")
    , @NamedQuery(name = "Blocks.findByDelFlg", query = "SELECT b FROM Blocks b WHERE b.delFlg = :delFlg")
    , @NamedQuery(name = "Blocks.findByVersion", query = "SELECT b FROM Blocks b WHERE b.version = :version AND b.delFlg = :delFlg")})
public class Blocks extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Size(max = 30)
    @Column(name = "name")
    private String name;
    @Size(max = 40)
    @Column(name = "address")
    private String address;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "longtitude")
    private Double longtitude;
    @Column(name = "latitude")
    private Double latitude;

    public Blocks() {
    }

    public Blocks(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Blocks)) {
            return false;
        }
        Blocks other = (Blocks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.Blocks[ id=" + id + " ]";
    }
}
