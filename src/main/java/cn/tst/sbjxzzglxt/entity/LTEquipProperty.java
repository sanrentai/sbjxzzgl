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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "LT_Equip_Property")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LTEquipProperty.findAll", query = "SELECT l FROM LTEquipProperty l")
    , @NamedQuery(name = "LTEquipProperty.findById", query = "SELECT l FROM LTEquipProperty l WHERE l.id = :id AND l.delFlg = :delFlg")
    , @NamedQuery(name = "LTEquipProperty.findByEditUser", query = "SELECT l FROM LTEquipProperty l WHERE l.editUser = :editUser")
    , @NamedQuery(name = "LTEquipProperty.findByInsRep", query = "SELECT l FROM LTEquipProperty l WHERE l.insRep = :insRep")
    , @NamedQuery(name = "LTEquipProperty.findByInsDate", query = "SELECT l FROM LTEquipProperty l WHERE l.insDate = :insDate")
    , @NamedQuery(name = "LTEquipProperty.findByUpdRep", query = "SELECT l FROM LTEquipProperty l WHERE l.updRep = :updRep")
    , @NamedQuery(name = "LTEquipProperty.findByUpdDate", query = "SELECT l FROM LTEquipProperty l WHERE l.updDate = :updDate")
    , @NamedQuery(name = "LTEquipProperty.findByDelFlg", query = "SELECT l FROM LTEquipProperty l WHERE l.delFlg = :delFlg")
    , @NamedQuery(name = "LTEquipProperty.findByVersion", query = "SELECT l FROM LTEquipProperty l WHERE l.version = :version")})
public class LTEquipProperty extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Size(max = 250)
    @Column(name = "P_Nmae")
    private String pNmae;
    @Size(max = 50)
    @Column(name = "P_Type")
    private String pType;
    @Size(max = 250)
    @Column(name = "P_Default")
    private String pDefault;
    @Size(max = 250)
    @Column(name = "P_SM")
    private String pSm;
    @Column(name = "P_Empt")
    private Integer pEmpt;
    @Column(name = "Del_YN")
    private Integer delYN;
    @Column(name = "Del_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date delDate;
    @Column(name = "Del_User")
    private Long delUser;
    @Column(name = "State")
    private Integer state;
    @Column(name = "State_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stateDate;
    @Column(name = "State_User")
    private Long stateUser;
    @Column(name = "Add_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addDate;
    @Column(name = "Add_User")
    private Long addUser;
    @Column(name = "Edit_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date editDate;
    @Column(name = "Edit_User")
    private Long editUser;

    public LTEquipProperty() {
    }

    public LTEquipProperty(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPNmae() {
        return pNmae;
    }

    public void setPNmae(String pNmae) {
        this.pNmae = pNmae;
    }

    public String getPType() {
        return pType;
    }

    public void setPType(String pType) {
        this.pType = pType;
    }

    public String getPDefault() {
        return pDefault;
    }

    public void setPDefault(String pDefault) {
        this.pDefault = pDefault;
    }

    public String getPSm() {
        return pSm;
    }

    public void setPSm(String pSm) {
        this.pSm = pSm;
    }

    public Integer getPEmpt() {
        return pEmpt;
    }

    public void setPEmpt(Integer pEmpt) {
        this.pEmpt = pEmpt;
    }

    public Integer getDelYN() {
        return delYN;
    }

    public void setDelYN(Integer delYN) {
        this.delYN = delYN;
    }

    public Date getDelDate() {
        return delDate;
    }

    public void setDelDate(Date delDate) {
        this.delDate = delDate;
    }

    public Long getDelUser() {
        return delUser;
    }

    public void setDelUser(Long delUser) {
        this.delUser = delUser;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getStateDate() {
        return stateDate;
    }

    public void setStateDate(Date stateDate) {
        this.stateDate = stateDate;
    }

    public Long getStateUser() {
        return stateUser;
    }

    public void setStateUser(Long stateUser) {
        this.stateUser = stateUser;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Long getAddUser() {
        return addUser;
    }

    public void setAddUser(Long addUser) {
        this.addUser = addUser;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public Long getEditUser() {
        return editUser;
    }

    public void setEditUser(Long editUser) {
        this.editUser = editUser;
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
        if (!(object instanceof LTEquipProperty)) {
            return false;
        }
        LTEquipProperty other = (LTEquipProperty) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.LTEquipProperty[ id=" + id + " ]";
    }

    @Transient
    private boolean selected;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    

    
    
}
