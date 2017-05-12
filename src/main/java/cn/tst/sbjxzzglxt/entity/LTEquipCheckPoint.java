/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
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
    , @NamedQuery(name = "LTEquipCheckPoint.findByGraphicId", query = "SELECT l FROM LTEquipCheckPoint l WHERE l.graphicId = :graphicId")})
public class LTEquipCheckPoint extends BaseEntity implements Serializable {

    @Column(name = "x")
    private Integer x;
    @Column(name = "y")
    private Integer y;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "graphicId")
    private Integer graphicId;

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

    public Integer getGraphicId() {
        return graphicId;
    }

    public void setGraphicId(Integer graphicId) {
        this.graphicId = graphicId;
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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name = "graphicId", referencedColumnName = "ID", insertable = false, updatable = false)
        ,
        @JoinColumn(name = "del_flg", referencedColumnName = "del_flg", insertable = false, updatable = false)
    })
    private LTEquipGraphic graphic;

    public LTEquipGraphic getGraphic() {
        return graphic;
    }

    public void setGraphic(LTEquipGraphic graphic) {
        this.graphic = graphic;
    }
}
