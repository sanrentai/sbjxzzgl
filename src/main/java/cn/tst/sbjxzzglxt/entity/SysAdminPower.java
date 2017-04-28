/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "sys_Admin_Power")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysAdminPower.findAll", query = "SELECT s FROM SysAdminPower s")
    , @NamedQuery(name = "SysAdminPower.findById", query = "SELECT s FROM SysAdminPower s WHERE s.id = :id")
    , @NamedQuery(name = "SysAdminPower.findByPowerName", query = "SELECT s FROM SysAdminPower s WHERE s.powerName = :powerName")
    , @NamedQuery(name = "SysAdminPower.findByPowerNum", query = "SELECT s FROM SysAdminPower s WHERE s.powerNum = :powerNum")
    , @NamedQuery(name = "SysAdminPower.findBySuperNum", query = "SELECT s FROM SysAdminPower s WHERE s.superNum = :superNum")})
public class SysAdminPower implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 50)
    @Column(name = "Power_Name")
    private String powerName;
    @Size(max = 50)
    @Column(name = "Power_Num")
    private String powerNum;
    @Column(name = "Super_Num")
    private Long superNum;

    public SysAdminPower() {
    }

    public SysAdminPower(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    public String getPowerNum() {
        return powerNum;
    }

    public void setPowerNum(String powerNum) {
        this.powerNum = powerNum;
    }

    public Long getSuperNum() {
        return superNum;
    }

    public void setSuperNum(Long superNum) {
        this.superNum = superNum;
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
        if (!(object instanceof SysAdminPower)) {
            return false;
        }
        SysAdminPower other = (SysAdminPower) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.SysAdminPower[ id=" + id + " ]";
    }
    
}
