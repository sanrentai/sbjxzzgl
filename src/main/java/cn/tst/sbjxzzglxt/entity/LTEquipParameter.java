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
@Table(name = "LT_Equip_Parameter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LTEquipParameter.findAll", query = "SELECT l FROM LTEquipParameter l")
    , @NamedQuery(name = "LTEquipParameter.findById", query = "SELECT l FROM LTEquipParameter l WHERE l.id = :id")
    , @NamedQuery(name = "LTEquipParameter.findByENum", query = "SELECT l FROM LTEquipParameter l WHERE l.eNum = :eNum")
    , @NamedQuery(name = "LTEquipParameter.findByDelYN", query = "SELECT l FROM LTEquipParameter l WHERE l.delYN = :delYN")
    , @NamedQuery(name = "LTEquipParameter.findByDelDate", query = "SELECT l FROM LTEquipParameter l WHERE l.delDate = :delDate")
    , @NamedQuery(name = "LTEquipParameter.findByDelUser", query = "SELECT l FROM LTEquipParameter l WHERE l.delUser = :delUser")
    , @NamedQuery(name = "LTEquipParameter.findByState", query = "SELECT l FROM LTEquipParameter l WHERE l.state = :state")
    , @NamedQuery(name = "LTEquipParameter.findByStateDate", query = "SELECT l FROM LTEquipParameter l WHERE l.stateDate = :stateDate")
    , @NamedQuery(name = "LTEquipParameter.findByStateUser", query = "SELECT l FROM LTEquipParameter l WHERE l.stateUser = :stateUser")
    , @NamedQuery(name = "LTEquipParameter.findByAddDate", query = "SELECT l FROM LTEquipParameter l WHERE l.addDate = :addDate")
    , @NamedQuery(name = "LTEquipParameter.findByAddUser", query = "SELECT l FROM LTEquipParameter l WHERE l.addUser = :addUser")
    , @NamedQuery(name = "LTEquipParameter.findByEditDate", query = "SELECT l FROM LTEquipParameter l WHERE l.editDate = :editDate")
    , @NamedQuery(name = "LTEquipParameter.findByEditUser", query = "SELECT l FROM LTEquipParameter l WHERE l.editUser = :editUser")
    , @NamedQuery(name = "LTEquipParameter.findByInsRep", query = "SELECT l FROM LTEquipParameter l WHERE l.insRep = :insRep")
    , @NamedQuery(name = "LTEquipParameter.findByInsDate", query = "SELECT l FROM LTEquipParameter l WHERE l.insDate = :insDate")
    , @NamedQuery(name = "LTEquipParameter.findByUpdRep", query = "SELECT l FROM LTEquipParameter l WHERE l.updRep = :updRep")
    , @NamedQuery(name = "LTEquipParameter.findByUpdDate", query = "SELECT l FROM LTEquipParameter l WHERE l.updDate = :updDate")
    , @NamedQuery(name = "LTEquipParameter.findByDelFlg", query = "SELECT l FROM LTEquipParameter l WHERE l.delFlg = :delFlg")
    , @NamedQuery(name = "LTEquipParameter.findByVersion", query = "SELECT l FROM LTEquipParameter l WHERE l.version = :version")})
public class LTEquipParameter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ins_rep")
    private String insRep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ins_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "upd_rep")
    private String updRep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "upd_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "del_flg")
    private Character delFlg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private int version;

    public LTEquipParameter() {
    }

    public LTEquipParameter(Long id) {
        this.id = id;
    }

    public LTEquipParameter(Long id, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
        this.id = id;
        this.insRep = insRep;
        this.insDate = insDate;
        this.updRep = updRep;
        this.updDate = updDate;
        this.delFlg = delFlg;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getInsRep() {
        return insRep;
    }

    public void setInsRep(String insRep) {
        this.insRep = insRep;
    }

    public Date getInsDate() {
        return insDate;
    }

    public void setInsDate(Date insDate) {
        this.insDate = insDate;
    }

    public String getUpdRep() {
        return updRep;
    }

    public void setUpdRep(String updRep) {
        this.updRep = updRep;
    }

    public Date getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Date updDate) {
        this.updDate = updDate;
    }

    public Character getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Character delFlg) {
        this.delFlg = delFlg;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
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
        if (!(object instanceof LTEquipParameter)) {
            return false;
        }
        LTEquipParameter other = (LTEquipParameter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.LTEquipParameter[ id=" + id + " ]";
    }
    
}
