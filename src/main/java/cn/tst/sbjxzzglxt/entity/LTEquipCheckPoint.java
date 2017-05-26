/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
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
    , @NamedQuery(name = "LTEquipCheckPoint.findByEquipmentId", query = "SELECT l FROM LTEquipCheckPoint l WHERE l.equipmentId = :equipmentId AND l.delFlg = :delFlg")})
public class LTEquipCheckPoint extends BaseEntity implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Column(name = "equipmentId")
    private Long equipmentId;
    @Size(max = 10)
    @Column(name = "name")
    private String name;
    @Column(name = "checkOrder")
    private Integer checkOrder;
    @Size(max = 50)
    @Column(name = "specification")
    private String specification;


    @Column(name = "x")
    private Integer x;
    @Column(name = "y")
    private Integer y;

    private static final long serialVersionUID = 1L;

    public LTEquipCheckPoint() {
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
    // 设备
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "equipmentId", referencedColumnName = "ID", insertable = false, updatable = false),
        @JoinColumn(name = "del_flg", referencedColumnName = "del_flg", insertable = false, updatable = false)
    })
    private LTEquipBasic equipment;

    public LTEquipBasic getEquipment() {
        return equipment;
    }

    public void setEquipment(LTEquipBasic equipment) {
        this.equipment = equipment;
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
    
    @OneToMany(mappedBy="checkPoint")
    @JoinColumns({
        @JoinColumn(name = "id", referencedColumnName = "suo_shu_xun_jian_dian_id", insertable = false, updatable = false),
        @JoinColumn(name = "del_flg", referencedColumnName = "del_flg", insertable = false, updatable = false)
    })
    private List<SysRoutingInspectionItems> itemList;

    public List<SysRoutingInspectionItems> getItemList() {
        return itemList;
    }

    public void setItemList(List<SysRoutingInspectionItems> itemList) {
        this.itemList = itemList;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public LTEquipCheckPoint(Long id) {
        this.id = id;
    }

    public LTEquipCheckPoint(Long id, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
        this.id = id;
        this.insRep = insRep;
        this.insDate = insDate;
        this.updRep = updRep;
        this.updDate = updDate;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
