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
    , @NamedQuery(name = "LTEquipCheckPoint.findByEquipmentId", query = "SELECT l FROM LTEquipCheckPoint l WHERE l.equipmentId = :equipmentId AND l.delFlg = :delFlg")
    , @NamedQuery(name = "LTEquipCheckPoint.findByX", query = "SELECT l FROM LTEquipCheckPoint l WHERE l.x = :x")
    , @NamedQuery(name = "LTEquipCheckPoint.findByY", query = "SELECT l FROM LTEquipCheckPoint l WHERE l.y = :y")
    , @NamedQuery(name = "LTEquipCheckPoint.findByName", query = "SELECT l FROM LTEquipCheckPoint l WHERE l.name = :name")
    , @NamedQuery(name = "LTEquipCheckPoint.findByCheckOrder", query = "SELECT l FROM LTEquipCheckPoint l WHERE l.checkOrder = :checkOrder")
    , @NamedQuery(name = "LTEquipCheckPoint.findBySpecification", query = "SELECT l FROM LTEquipCheckPoint l WHERE l.specification = :specification")
    , @NamedQuery(name = "LTEquipCheckPoint.findByInsRep", query = "SELECT l FROM LTEquipCheckPoint l WHERE l.insRep = :insRep")
    , @NamedQuery(name = "LTEquipCheckPoint.findByInsDate", query = "SELECT l FROM LTEquipCheckPoint l WHERE l.insDate = :insDate")
    , @NamedQuery(name = "LTEquipCheckPoint.findByUpdRep", query = "SELECT l FROM LTEquipCheckPoint l WHERE l.updRep = :updRep")
    , @NamedQuery(name = "LTEquipCheckPoint.findByUpdDate", query = "SELECT l FROM LTEquipCheckPoint l WHERE l.updDate = :updDate")
    , @NamedQuery(name = "LTEquipCheckPoint.findByDelFlg", query = "SELECT l FROM LTEquipCheckPoint l WHERE l.delFlg = :delFlg")
    , @NamedQuery(name = "LTEquipCheckPoint.findByVersion", query = "SELECT l FROM LTEquipCheckPoint l WHERE l.version = :version")})
public class LTEquipCheckPoint extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "equipmentId")
    private Long equipmentId;
    @Column(name = "x")
    private Integer x;
    @Column(name = "y")
    private Integer y;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Column(name = "checkOrder")
    private Integer checkOrder;
    @Size(max = 50)
    @Column(name = "specification")
    private String specification;

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

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCheckOrder() {
        return checkOrder;
    }

    public void setCheckOrder(Integer checkOrder) {
        this.checkOrder = checkOrder;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
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
     
}
