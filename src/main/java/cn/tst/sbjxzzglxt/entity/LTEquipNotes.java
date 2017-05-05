/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.entity;

import cn.tst.sbjxzzglxt.common.SepE.RecordType;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "LT_Equip_Notes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LTEquipNotes.findAll", query = "SELECT l FROM LTEquipNotes l")
    , @NamedQuery(name = "LTEquipNotes.findById", query = "SELECT l FROM LTEquipNotes l WHERE l.id = :id")
    , @NamedQuery(name = "LTEquipNotes.findByENum", query = "SELECT l FROM LTEquipNotes l WHERE l.eNum = :eNum")
    , @NamedQuery(name = "LTEquipNotes.findByTType", query = "SELECT l FROM LTEquipNotes l WHERE l.tType = :tType")
    , @NamedQuery(name = "LTEquipNotes.findByDelYN", query = "SELECT l FROM LTEquipNotes l WHERE l.delYN = :delYN")
    , @NamedQuery(name = "LTEquipNotes.findByDelDate", query = "SELECT l FROM LTEquipNotes l WHERE l.delDate = :delDate")
    , @NamedQuery(name = "LTEquipNotes.findByDelUser", query = "SELECT l FROM LTEquipNotes l WHERE l.delUser = :delUser")
    , @NamedQuery(name = "LTEquipNotes.findByState", query = "SELECT l FROM LTEquipNotes l WHERE l.state = :state")
    , @NamedQuery(name = "LTEquipNotes.findByStateDate", query = "SELECT l FROM LTEquipNotes l WHERE l.stateDate = :stateDate")
    , @NamedQuery(name = "LTEquipNotes.findByStateUser", query = "SELECT l FROM LTEquipNotes l WHERE l.stateUser = :stateUser")
    , @NamedQuery(name = "LTEquipNotes.findByAddDate", query = "SELECT l FROM LTEquipNotes l WHERE l.addDate = :addDate")
    , @NamedQuery(name = "LTEquipNotes.findByAddUser", query = "SELECT l FROM LTEquipNotes l WHERE l.addUser = :addUser")
    , @NamedQuery(name = "LTEquipNotes.findByEditDate", query = "SELECT l FROM LTEquipNotes l WHERE l.editDate = :editDate")
    , @NamedQuery(name = "LTEquipNotes.findByEditUser", query = "SELECT l FROM LTEquipNotes l WHERE l.editUser = :editUser")
    , @NamedQuery(name = "LTEquipNotes.findByInsRep", query = "SELECT l FROM LTEquipNotes l WHERE l.insRep = :insRep")
    , @NamedQuery(name = "LTEquipNotes.findByInsDate", query = "SELECT l FROM LTEquipNotes l WHERE l.insDate = :insDate")
    , @NamedQuery(name = "LTEquipNotes.findByUpdRep", query = "SELECT l FROM LTEquipNotes l WHERE l.updRep = :updRep")
    , @NamedQuery(name = "LTEquipNotes.findByUpdDate", query = "SELECT l FROM LTEquipNotes l WHERE l.updDate = :updDate")
    , @NamedQuery(name = "LTEquipNotes.findByDelFlg", query = "SELECT l FROM LTEquipNotes l WHERE l.delFlg = :delFlg")
    , @NamedQuery(name = "LTEquipNotes.findByVersion", query = "SELECT l FROM LTEquipNotes l WHERE l.version = :version")})
public class LTEquipNotes extends BaseEntity implements Serializable {

    @Column(name = "T_Type")
    private Integer tType;

    @Column(name = "State")
    private Integer state;

    @Column(name = "Edit_User")
    private Long editUser;
    @Column(name = "DangQianBaoYangRiQi")
    @Temporal(TemporalType.DATE)
    private Date dangQianBaoYangRiQi;
    @Column(name = "XiaCiBaoYangRiQi")
    @Temporal(TemporalType.DATE)
    private Date xiaCiBaoYangRiQi;
    @Size(max = 255)
    @Column(name = "YiLiuWenTi")
    private String yiLiuWenTi;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Size(max = 250)
    @Column(name = "E_Num")
    private String eNum;
    @Column(name = "Del_YN")
    private Integer delYN;
    @Column(name = "Del_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date delDate;
    @Column(name = "Del_User")
    private Long delUser;
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

    public String geteNum() {
        return eNum;
    }

    public void seteNum(String eNum) {
        this.eNum = eNum;
    }

    public Integer getTType() {
        return tType;
    }

    public void setTType(Integer tType) {
        this.tType = tType;
    }

    public LTEquipNotes() {
    }

    public LTEquipNotes(Long id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LTEquipNotes)) {
            return false;
        }
        LTEquipNotes other = (LTEquipNotes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.LTEquipNotes[ id=" + id + " ]";
    }

    public Date getDangQianBaoYangRiQi() {
        return dangQianBaoYangRiQi;
    }

    public void setDangQianBaoYangRiQi(Date dangQianBaoYangRiQi) {
        this.dangQianBaoYangRiQi = dangQianBaoYangRiQi;
    }

    public Date getXiaCiBaoYangRiQi() {
        return xiaCiBaoYangRiQi;
    }

    public void setXiaCiBaoYangRiQi(Date xiaCiBaoYangRiQi) {
        this.xiaCiBaoYangRiQi = xiaCiBaoYangRiQi;
    }

    public String getYiLiuWenTi() {
        return yiLiuWenTi;
    }

    public void setYiLiuWenTi(String yiLiuWenTi) {
        this.yiLiuWenTi = yiLiuWenTi;
    }

    public Long getEditUser() {
        return editUser;
    }

    public void setEditUser(Long editUser) {
        this.editUser = editUser;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    
    public String getRecordType() {
        RecordType type = RecordType.create(this.getTType());
        return type.getString();
    }
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "E_Num", referencedColumnName = "E_Num", insertable = false, updatable = false)
    private  LTEquipBasic equip;

    public LTEquipBasic getEquip() {
        return equip;
    }

    public void setEquip(LTEquipBasic equip) {
        this.equip = equip;
    }
}
