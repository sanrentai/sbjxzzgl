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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "LT_Equip_Fitting")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LTEquipFitting.findAll", query = "SELECT l FROM LTEquipFitting l")
    , @NamedQuery(name = "LTEquipFitting.findById", query = "SELECT l FROM LTEquipFitting l WHERE l.id = :id AND l.delFlg = :delFlg")
    , @NamedQuery(name = "LTEquipFitting.findByPNmae", query = "SELECT l FROM LTEquipFitting l WHERE l.pNmae = :pNmae")
    , @NamedQuery(name = "LTEquipFitting.findByENum", query = "SELECT l FROM LTEquipFitting l WHERE l.eNum = :eNum AND l.delFlg = :delFlg")
    , @NamedQuery(name = "LTEquipFitting.findByPNum", query = "SELECT l FROM LTEquipFitting l WHERE l.pNum = :pNum")
    , @NamedQuery(name = "LTEquipFitting.findByDelYN", query = "SELECT l FROM LTEquipFitting l WHERE l.delYN = :delYN")
    , @NamedQuery(name = "LTEquipFitting.findByDelDate", query = "SELECT l FROM LTEquipFitting l WHERE l.delDate = :delDate")
    , @NamedQuery(name = "LTEquipFitting.findByDelUser", query = "SELECT l FROM LTEquipFitting l WHERE l.delUser = :delUser")
    , @NamedQuery(name = "LTEquipFitting.findByState", query = "SELECT l FROM LTEquipFitting l WHERE l.state = :state")
    , @NamedQuery(name = "LTEquipFitting.findByStateDate", query = "SELECT l FROM LTEquipFitting l WHERE l.stateDate = :stateDate")
    , @NamedQuery(name = "LTEquipFitting.findByStateUser", query = "SELECT l FROM LTEquipFitting l WHERE l.stateUser = :stateUser")
    , @NamedQuery(name = "LTEquipFitting.findByAddDate", query = "SELECT l FROM LTEquipFitting l WHERE l.addDate = :addDate")
    , @NamedQuery(name = "LTEquipFitting.findByAddUser", query = "SELECT l FROM LTEquipFitting l WHERE l.addUser = :addUser")
    , @NamedQuery(name = "LTEquipFitting.findByEditDate", query = "SELECT l FROM LTEquipFitting l WHERE l.editDate = :editDate")
    , @NamedQuery(name = "LTEquipFitting.findByEditUser", query = "SELECT l FROM LTEquipFitting l WHERE l.editUser = :editUser")
    , @NamedQuery(name = "LTEquipFitting.findByInsRep", query = "SELECT l FROM LTEquipFitting l WHERE l.insRep = :insRep")
    , @NamedQuery(name = "LTEquipFitting.findByInsDate", query = "SELECT l FROM LTEquipFitting l WHERE l.insDate = :insDate")
    , @NamedQuery(name = "LTEquipFitting.findByUpdRep", query = "SELECT l FROM LTEquipFitting l WHERE l.updRep = :updRep")
    , @NamedQuery(name = "LTEquipFitting.findByUpdDate", query = "SELECT l FROM LTEquipFitting l WHERE l.updDate = :updDate")
    , @NamedQuery(name = "LTEquipFitting.findByDelFlg", query = "SELECT l FROM LTEquipFitting l WHERE l.delFlg = :delFlg")
    , @NamedQuery(name = "LTEquipFitting.findByVersion", query = "SELECT l FROM LTEquipFitting l WHERE l.version = :version")})
public class LTEquipFitting extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Size(max = 50)
    @Column(name = "P_Nmae")
    private String pNmae;
    @Column(name = "E_Num")
    private Long eNum;
    @Size(max = 50)
    @Column(name = "P_Num")
    private String pNum;
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
    @Size(max = 20)
    @Column(name = "gui_ge")
    private String guiGe;
    @Size(max = 20)
    @Column(name = "xing_hao")
    private String xingHao;
    @Size(max = 50)
    @Column(name = "chang_jia")
    private String changJia;

    public String getpNmae() {
        return pNmae;
    }

    public void setpNmae(String pNmae) {
        this.pNmae = pNmae;
    }

    public Long geteNum() {
        return eNum;
    }

    public void seteNum(Long eNum) {
        this.eNum = eNum;
    }

    public String getpNum() {
        return pNum;
    }

    public void setpNum(String pNum) {
        this.pNum = pNum;
    }

    public LTEquipFitting() {
    }

    public LTEquipFitting(Long id) {
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

    public Long getENum() {
        return eNum;
    }

    public void setENum(Long eNum) {
        this.eNum = eNum;
    }

    public String getPNum() {
        return pNum;
    }

    public void setPNum(String pNum) {
        this.pNum = pNum;
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

    
    public String getGuiGe() {
        return guiGe;
    }

    public void setGuiGe(String guiGe) {
        this.guiGe = guiGe;
    }

    public String getXingHao() {
        return xingHao;
    }

    public void setXingHao(String xingHao) {
        this.xingHao = xingHao;
    }

    public String getChangJia() {
        return changJia;
    }

    public void setChangJia(String changJia) {
        this.changJia = changJia;
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
        if (!(object instanceof LTEquipFitting)) {
            return false;
        }
        LTEquipFitting other = (LTEquipFitting) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.LTEquipFitting[ id=" + id + " ]";
    }

    @ManyToOne
    @JoinColumn(name = "E_Num", referencedColumnName = "ID", insertable = false, updatable = false)
    private LTEquipBasic equipBasic;

    public LTEquipBasic getEquipBasic() {
        return equipBasic;
    }

    public void setEquipBasic(LTEquipBasic equipBasic) {
        this.equipBasic = equipBasic;
    }

}
