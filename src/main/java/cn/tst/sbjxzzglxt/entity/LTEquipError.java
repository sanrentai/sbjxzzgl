/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.entity;

import cn.tst.sbjxzzglxt.common.SepE;
import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author Administrator
 */
@Entity
@Table(name = "LT_Equip_Error")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LTEquipError.findAll", query = "SELECT l FROM LTEquipError l")
    , @NamedQuery(name = "LTEquipError.findById", query = "SELECT l FROM LTEquipError l WHERE l.id = :id")
    , @NamedQuery(name = "LTEquipError.findByENum", query = "SELECT l FROM LTEquipError l  WHERE l.eNum = :eNum AND l.delFlg = :delFlg")//  AND l.eName = :eName AND l.delFlg = :delFlg
//    , @NamedQuery(name = "LTEquipError.findByErrEName", query = "SELECT l FROM LTEquipError l WHERE l.equipBasic.eNmae = :eName AND l.delFlg = :delFlg ")
    , @NamedQuery(name = "LTEquipError.findByErrNum", query = "SELECT l FROM LTEquipError l WHERE l.errNum = :errNum")
    , @NamedQuery(name = "LTEquipError.findByErrTitle", query = "SELECT l FROM LTEquipError l WHERE l.errTitle = :errTitle")
    , @NamedQuery(name = "LTEquipError.findByErrWay", query = "SELECT l FROM LTEquipError l WHERE l.errWay = :errWay")
    , @NamedQuery(name = "LTEquipError.findByErrType", query = "SELECT l FROM LTEquipError l WHERE l.errType = :errType")
    , @NamedQuery(name = "LTEquipError.findByDelYN", query = "SELECT l FROM LTEquipError l WHERE l.delYN = :delYN")
    , @NamedQuery(name = "LTEquipError.findByDelDate", query = "SELECT l FROM LTEquipError l WHERE l.delDate = :delDate")
    , @NamedQuery(name = "LTEquipError.findByDelUser", query = "SELECT l FROM LTEquipError l WHERE l.delUser = :delUser")
    , @NamedQuery(name = "LTEquipError.findByState", query = "SELECT l FROM LTEquipError l WHERE l.state = :state")
    , @NamedQuery(name = "LTEquipError.findByStateDate", query = "SELECT l FROM LTEquipError l WHERE l.stateDate = :stateDate")
    , @NamedQuery(name = "LTEquipError.findByStateUser", query = "SELECT l FROM LTEquipError l WHERE l.stateUser = :stateUser")
    , @NamedQuery(name = "LTEquipError.findByAddDate", query = "SELECT l FROM LTEquipError l WHERE l.addDate = :addDate")
    , @NamedQuery(name = "LTEquipError.findByAddUser", query = "SELECT l FROM LTEquipError l WHERE l.addUser = :addUser")
    , @NamedQuery(name = "LTEquipError.findByEditDate", query = "SELECT l FROM LTEquipError l WHERE l.editDate = :editDate")
    , @NamedQuery(name = "LTEquipError.findByEditUser", query = "SELECT l FROM LTEquipError l WHERE l.editUser = :editUser")
    , @NamedQuery(name = "LTEquipError.findByInsRep", query = "SELECT l FROM LTEquipError l WHERE l.insRep = :insRep")
    , @NamedQuery(name = "LTEquipError.findByInsDate", query = "SELECT l FROM LTEquipError l WHERE l.insDate = :insDate")
    , @NamedQuery(name = "LTEquipError.findByUpdRep", query = "SELECT l FROM LTEquipError l WHERE l.updRep = :updRep")
    , @NamedQuery(name = "LTEquipError.findByUpdDate", query = "SELECT l FROM LTEquipError l WHERE l.updDate = :updDate")
    , @NamedQuery(name = "LTEquipError.findByDelFlg", query = "SELECT l FROM LTEquipError l WHERE l.delFlg = :delFlg")
    , @NamedQuery(name = "LTEquipError.findByVersion", query = "SELECT l FROM LTEquipError l WHERE l.version = :version")})
public class LTEquipError extends BaseEntity implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 50)
    @Column(name = "E_Num")
    private String eNum;
    @Column(name = "Err_Num")
    private Integer errNum;
    @Size(max = 50)
    @Column(name = "Err_Title")
    private String errTitle;
    @Size(max = 200)
    @Column(name = "Err_Way")
    private String errWay;
    @Size(max = 200)
    @Column(name = "Err_Type")
    private String errType;
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
    @Column(name = "FluctMax")
    private Integer fluctMax;
    @Column(name = "FluctMin")
    private Integer fluctMin;

    @Column(name = "suo_shu_gu_zhang")
    private Long suoShuGuZhang;
    @Column(name = "di_ji_gu_zhang")
    private Integer diJiGuZhang;

    public LTEquipError() {
    }

    public LTEquipError(Long id) {
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "E_Num", referencedColumnName = "E_Num", insertable = false, updatable = false),
        @JoinColumn(name = "del_flg", referencedColumnName = "del_flg", insertable = false, updatable = false)
    })
    private LTEquipBasic equip;

    public LTEquipBasic getEquip() {
        return equip;
    }

    public void setEquip(LTEquipBasic equip) {
        this.equip = equip;
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

    public Integer getErrNum() {
        return errNum;
    }

    public void setErrNum(Integer errNum) {
        this.errNum = errNum;
    }

    public String getErrTitle() {
        return errTitle;
    }

    public void setErrTitle(String errTitle) {
        this.errTitle = errTitle;
    }

    public String getErrWay() {
        return errWay;
    }

    public void setErrWay(String errWay) {
        this.errWay = errWay;
    }

    public String getErrType() {
        return errType;
    }

    public void setErrType(String errType) {
        this.errType = errType;
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

    public Integer getFluctMax() {
        return fluctMax;
    }

    public void setFluctMax(Integer fluctMax) {
        this.fluctMax = fluctMax;
    }

    public Integer getFluctMin() {
        return fluctMin;
    }

    public void setFluctMin(Integer fluctMin) {
        this.fluctMin = fluctMin;
    }

   

    public Long getSuoShuGuZhang() {
        return suoShuGuZhang;
    }

    public void setSuoShuGuZhang(Long suoShuGuZhang) {
        this.suoShuGuZhang = suoShuGuZhang;
    }
    //底层因为0是1否，所以采用枚举
    public SepE.Whether getDiJiGuZhang() {
        return SepE.Whether.parse(diJiGuZhang);
    }

    public void setDiJiGuZhang(SepE.Whether diJiGuZhang) {
        this.diJiGuZhang = diJiGuZhang.getValue();
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
        if (!(object instanceof LTEquipError)) {
            return false;
        }
        LTEquipError other = (LTEquipError) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.LTEquipError[ id=" + id + " ]";
    }



      
}
