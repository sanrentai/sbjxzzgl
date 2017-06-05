/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@Entity
@Table(name = "MapSetting")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MapSetting.findAll", query = "SELECT m FROM MapSetting m WHERE m.delFlg=:delFlg")
    , @NamedQuery(name = "MapSetting.findById", query = "SELECT m FROM MapSetting m WHERE m.id = :id AND m.delFlg=:delFlg")
    , @NamedQuery(name = "MapSetting.findByInitialLongtitude", query = "SELECT m FROM MapSetting m WHERE m.initialLongtitude = :initialLongtitude AND m.delFlg=:delFlg")
    , @NamedQuery(name = "MapSetting.findByInitialLatitude", query = "SELECT m FROM MapSetting m WHERE m.initialLatitude = :initialLatitude AND m.delFlg=:delFlg")
    , @NamedQuery(name = "MapSetting.findByInsDate", query = "SELECT m FROM MapSetting m WHERE m.insDate = :insDate AND m.delFlg=:delFlg")
    , @NamedQuery(name = "MapSetting.findByUpdRep", query = "SELECT m FROM MapSetting m WHERE m.updRep = :updRep AND m.delFlg=:delFlg")
    , @NamedQuery(name = "MapSetting.findByUpdDate", query = "SELECT m FROM MapSetting m WHERE m.updDate = :updDate AND m.delFlg=:delFlg")
    , @NamedQuery(name = "MapSetting.findByDelFlg", query = "SELECT m FROM MapSetting m WHERE m.delFlg = :delFlg")
    , @NamedQuery(name = "MapSetting.findByVersion", query = "SELECT m FROM MapSetting m WHERE m.version = :version AND m.delFlg=:delFlg")
    , @NamedQuery(name = "MapSetting.findByZoom", query = "SELECT m FROM MapSetting m WHERE m.zoom = :zoom AND m.delFlg=:delFlg")})
public class MapSetting extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "initialLongtitude")
    private Double initialLongtitude;
    @Column(name = "initialLatitude")
    private Double initialLatitude;
    @Column(name = "zoom")
    private Integer zoom;

    public MapSetting() {
    }

    public MapSetting(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getInitialLongtitude() {
        return initialLongtitude;
    }

    public void setInitialLongtitude(Double initialLongtitude) {
        this.initialLongtitude = initialLongtitude;
    }

    public Double getInitialLatitude() {
        return initialLatitude;
    }

    public void setInitialLatitude(Double initialLatitude) {
        this.initialLatitude = initialLatitude;
    }

    public Integer getZoom() {
        return zoom;
    }

    public void setZoom(Integer zoom) {
        this.zoom = zoom;
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
        if (!(object instanceof MapSetting)) {
            return false;
        }
        MapSetting other = (MapSetting) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.MapSetting[ id=" + id + " ]";
    }
    
}
