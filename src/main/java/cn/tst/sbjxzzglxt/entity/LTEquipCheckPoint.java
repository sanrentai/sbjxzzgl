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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "LT_Equip_CheckPoint")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LTEquipCheckPoint.findAll", query = "SELECT l FROM LTEquipCheckPoint l")
    , @NamedQuery(name = "LTEquipCheckPoint.findById", query = "SELECT l FROM LTEquipCheckPoint l WHERE l.id = :id")
    , @NamedQuery(name = "LTEquipCheckPoint.findByX", query = "SELECT l FROM LTEquipCheckPoint l WHERE l.x = :x")
    , @NamedQuery(name = "LTEquipCheckPoint.findByY", query = "SELECT l FROM LTEquipCheckPoint l WHERE l.y = :y")
    , @NamedQuery(name = "LTEquipCheckPoint.findByEquipmentId", query = "SELECT l FROM LTEquipCheckPoint l WHERE l.equipmentId = :equipmentId")})
public class LTEquipCheckPoint extends BaseEntity implements Serializable {

    @Column(name = "equipmentId")
    private Integer equipmentId;

    @Column(name = "x")
    private Integer x;
    @Column(name = "y")
    private Integer y;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    public LTEquipCheckPoint() {
    }

    public LTEquipCheckPoint(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof LTEquipCheckPoint)) {
            return false;
        }
        LTEquipCheckPoint other = (LTEquipCheckPoint) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.LTEquipCheckPoint[ id=" + id + " ]";
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "equipmentId", referencedColumnName = "ID", insertable = false, updatable = false)
        ,
        @JoinColumn(name = "del_flg", referencedColumnName = "del_flg", insertable = false, updatable = false)
    })
    private LTEquipBasic equipment;

    public LTEquipBasic getEquipment() {
        return equipment;
    }

    public void setEquipment(LTEquipBasic equipment) {
        this.equipment = equipment;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }
}
