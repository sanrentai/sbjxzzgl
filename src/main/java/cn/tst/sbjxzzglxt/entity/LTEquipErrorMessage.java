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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "LT_Equip_ErrorMessage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LTEquipErrorMessage.findAll", query = "SELECT l FROM LTEquipErrorMessage l")
    , @NamedQuery(name = "LTEquipErrorMessage.findById", query = "SELECT l FROM LTEquipErrorMessage l WHERE l.id = :id AND l.delFlg = :delFlg")
    , @NamedQuery(name = "LTEquipErrorMessage.findByGuZhangMingCheng", query = "SELECT l FROM LTEquipErrorMessage l WHERE l.guZhangMingCheng = :guZhangMingCheng")
    , @NamedQuery(name = "LTEquipErrorMessage.findByInsRep", query = "SELECT l FROM LTEquipErrorMessage l WHERE l.insRep = :insRep")
    , @NamedQuery(name = "LTEquipErrorMessage.findByInsDate", query = "SELECT l FROM LTEquipErrorMessage l WHERE l.insDate = :insDate")
    , @NamedQuery(name = "LTEquipErrorMessage.findByUpdRep", query = "SELECT l FROM LTEquipErrorMessage l WHERE l.updRep = :updRep")
    , @NamedQuery(name = "LTEquipErrorMessage.findByUpdDate", query = "SELECT l FROM LTEquipErrorMessage l WHERE l.updDate = :updDate")
    , @NamedQuery(name = "LTEquipErrorMessage.findByDelFlg", query = "SELECT l FROM LTEquipErrorMessage l WHERE l.delFlg = :delFlg")
    , @NamedQuery(name = "LTEquipErrorMessage.findByVersion", query = "SELECT l FROM LTEquipErrorMessage l WHERE l.version = :version")})
public class LTEquipErrorMessage extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Size(max = 255)
    @Column(name = "gu_zhang_ming_cheng")
    private String guZhangMingCheng;
    

    public LTEquipErrorMessage() {
    }

    public LTEquipErrorMessage(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuZhangMingCheng() {
        return guZhangMingCheng;
    }

    public void setGuZhangMingCheng(String guZhangMingCheng) {
        this.guZhangMingCheng = guZhangMingCheng;
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
        if (!(object instanceof LTEquipErrorMessage)) {
            return false;
        }
        LTEquipErrorMessage other = (LTEquipErrorMessage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.LTEquipErrorMessage[ id=" + id + " ]";
    }
    
    //用于取故障表的故障名称
    @OneToOne
    @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "Err_Type")
    private LTEquipError equipError;

    public LTEquipError getEquipError() {
        return equipError;
    }

    public void setEquipError(LTEquipError equipError) {
        this.equipError = equipError;
    }

}
