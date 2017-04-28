/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * @author Administrator
 */
@Entity
@Table(name = "LT_Equip_Basic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LTEquipBasic.findAll", query = "SELECT l FROM LTEquipBasic l")
    , @NamedQuery(name = "LTEquipBasic.findById", query = "SELECT l FROM LTEquipBasic l WHERE l.id = :id")
    , @NamedQuery(name = "LTEquipBasic.findByENmae", query = "SELECT l FROM LTEquipBasic l WHERE l.eNmae = :eNmae")
    , @NamedQuery(name = "LTEquipBasic.findByCId", query = "SELECT l FROM LTEquipBasic l WHERE l.cId = :cId AND l.delFlg = :delFlg")
    , @NamedQuery(name = "LTEquipBasic.findByDelFlg", query = "SELECT l FROM LTEquipBasic l WHERE l.delFlg = :delFlg")
    , @NamedQuery(name = "LTEquipBasic.findByVersion", query = "SELECT l FROM LTEquipBasic l WHERE l.version = :version")})
public class LTEquipBasic extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 250)
    @Column(name = "E_Nmae")
    private String eNmae;
    @Column(name = "C_ID")
    private Long cId;
    @Size(max = 50)
    @Column(name = "E_Num")
    private String eNum;
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

    public LTEquipBasic() {
    }

    public LTEquipBasic(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getENmae() {
        return eNmae;
    }

    public void setENmae(String eNmae) {
        this.eNmae = eNmae;
    }

    public Long getCId() {
        return cId;
    }

    public void setCId(Long cId) {
        this.cId = cId;
    }

    public String getENum() {
        return eNum;
    }

    public void setENum(String eNum) {
        this.eNum = eNum;
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
        if (!(object instanceof LTEquipBasic)) {
            return false;
        }
        LTEquipBasic other = (LTEquipBasic) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "cn.tst.sbjxzzglxt.entity.LTEquipBasic[ id=" + id + " ]";
        return eNmae;
    }

    ///父节点
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "C_ID", insertable = false, updatable = false)
    private LTEquipBasic parent;

    ///子节点
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private Set<LTEquipBasic> children;

    public LTEquipBasic getParent() {
        return parent;
    }

    public void setParent(LTEquipBasic parent) {
        this.parent = parent;
    }

    public Set<LTEquipBasic> getChildren() {
        return children;
    }

    public void setChildren(Set<LTEquipBasic> children) {
        this.children = children;
    }

}
