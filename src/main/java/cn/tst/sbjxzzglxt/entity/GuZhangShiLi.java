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
import javax.persistence.OneToOne;
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
@Table(name = "gu_zhang_shi_li")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GuZhangShiLi.findAll", query = "SELECT g FROM GuZhangShiLi g")
    , @NamedQuery(name = "GuZhangShiLi.findById", query = "SELECT g FROM GuZhangShiLi g WHERE g.id = :id")
    , @NamedQuery(name = "GuZhangShiLi.findByXiangMuId", query = "SELECT g FROM GuZhangShiLi g WHERE g.xiangMuId = :xiangMuId")
    , @NamedQuery(name = "GuZhangShiLi.findByGuZhangId", query = "SELECT g FROM GuZhangShiLi g WHERE g.guZhangId = :guZhangId AND g.delFlg = :delFlg")
    , @NamedQuery(name = "GuZhangShiLi.findByInsRep", query = "SELECT g FROM GuZhangShiLi g WHERE g.insRep = :insRep")
    , @NamedQuery(name = "GuZhangShiLi.findByInsDate", query = "SELECT g FROM GuZhangShiLi g WHERE g.insDate = :insDate")
    , @NamedQuery(name = "GuZhangShiLi.findByUpdRep", query = "SELECT g FROM GuZhangShiLi g WHERE g.updRep = :updRep")
    , @NamedQuery(name = "GuZhangShiLi.findByUpdDate", query = "SELECT g FROM GuZhangShiLi g WHERE g.updDate = :updDate")
    , @NamedQuery(name = "GuZhangShiLi.findByDelFlg", query = "SELECT g FROM GuZhangShiLi g WHERE g.delFlg = :delFlg")
    , @NamedQuery(name = "GuZhangShiLi.findByVersion", query = "SELECT g FROM GuZhangShiLi g WHERE g.version = :version")})
public class GuZhangShiLi extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xiangMuId")
    private int xiangMuId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "guZhangId")
    private String guZhangId;
   

    public GuZhangShiLi() {
    }


    public int getXiangMuId() {
        return xiangMuId;
    }

    public void setXiangMuId(int xiangMuId) {
        this.xiangMuId = xiangMuId;
    }

    public String getGuZhangId() {
        return guZhangId;
    }

    public void setGuZhangId(String guZhangId) {
        this.guZhangId = guZhangId;
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
        if (!(object instanceof GuZhangShiLi)) {
            return false;
        }
        GuZhangShiLi other = (GuZhangShiLi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.GuZhangShiLi[ id=" + id + " ]";
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "guZhangId", referencedColumnName = "Err_Num", insertable = false, updatable = false),
        @JoinColumn(name = "del_flg", referencedColumnName = "del_flg", insertable = false, updatable = false)
    })  
    private LTEquipError equipError;

    public LTEquipError getEquipError() {
        return equipError;
    }

    public void setEquipError(LTEquipError equipError) {
        this.equipError = equipError;
    }
    

    public GuZhangShiLi(Integer id) {
        this.id = id;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "xiangMuId", referencedColumnName = "ID", insertable = false, updatable = false),
        @JoinColumn(name = "del_flg", referencedColumnName = "del_flg", insertable = false, updatable = false)
    })
    private SysRoutingInspectionItems selectItems;

    public SysRoutingInspectionItems getSelectItems() {
        return selectItems;
    }

    public void setSelectItems(SysRoutingInspectionItems selectItems) {
        this.selectItems = selectItems;
    }
}
