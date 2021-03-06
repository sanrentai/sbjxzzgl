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
 * @author Aaron-PC-i3-4130
 */
@Entity
@Table(name = "Employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e WHERE e.delFlg = :delFlg")
    , @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id")
    , @NamedQuery(name = "Employee.findByCountOfWorkList", query = "SELECT e FROM Employee e WHERE e.countOfWorkList = :countOfWorkList")
    , @NamedQuery(name = "Employee.findByPhoneNumber", query = "SELECT e FROM Employee e WHERE e.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "Employee.findByName", query = "SELECT e FROM Employee e WHERE e.name = :name")
    , @NamedQuery(name = "Employee.findByLongtitude", query = "SELECT e FROM Employee e WHERE e.longtitude = :longtitude")
    , @NamedQuery(name = "Employee.findByLatitude", query = "SELECT e FROM Employee e WHERE e.latitude = :latitude")
    , @NamedQuery(name = "Employee.findByInsRep", query = "SELECT e FROM Employee e WHERE e.insRep = :insRep")
    , @NamedQuery(name = "Employee.findByInsDate", query = "SELECT e FROM Employee e WHERE e.insDate = :insDate")
    , @NamedQuery(name = "Employee.findByUpdRep", query = "SELECT e FROM Employee e WHERE e.updRep = :updRep")
    , @NamedQuery(name = "Employee.findByUpdDate", query = "SELECT e FROM Employee e WHERE e.updDate = :updDate")
    , @NamedQuery(name = "Employee.findByDelFlg", query = "SELECT e FROM Employee e WHERE e.delFlg = :delFlg")
    , @NamedQuery(name = "Employee.findByVersion", query = "SELECT e FROM Employee e WHERE e.version = :version")})
public class Employee extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "countOfWorkList")
    private Integer countOfWorkList;
    @Size(max = 16)
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Size(max = 16)
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "longtitude")
    private Double longtitude;
    @Column(name = "latitude")
    private Double latitude;

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Employee(Integer id, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
        this.id = id;
        this.insRep = insRep;
        this.insDate = insDate;
        this.updRep = updRep;
        this.updDate = updDate;
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCountOfWorkList() {
        return countOfWorkList;
    }

    public void setCountOfWorkList(Integer countOfWorkList) {
        this.countOfWorkList = countOfWorkList;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.Employee[ id=" + id + " ]";
    }
    
}
