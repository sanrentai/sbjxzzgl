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
@Table(name = "LT_Inspe_Content")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LTInspeContent.findAll", query = "SELECT l FROM LTInspeContent l")
    , @NamedQuery(name = "LTInspeContent.findById", query = "SELECT l FROM LTInspeContent l WHERE l.id = :id")
    , @NamedQuery(name = "LTInspeContent.findByDNmae", query = "SELECT l FROM LTInspeContent l WHERE l.dNmae = :dNmae")
    , @NamedQuery(name = "LTInspeContent.findByDAdd", query = "SELECT l FROM LTInspeContent l WHERE l.dAdd = :dAdd")
    , @NamedQuery(name = "LTInspeContent.findByDTel", query = "SELECT l FROM LTInspeContent l WHERE l.dTel = :dTel")
    , @NamedQuery(name = "LTInspeContent.findByDCoordinate", query = "SELECT l FROM LTInspeContent l WHERE l.dCoordinate = :dCoordinate")
    , @NamedQuery(name = "LTInspeContent.findByDBhour", query = "SELECT l FROM LTInspeContent l WHERE l.dBhour = :dBhour")
    , @NamedQuery(name = "LTInspeContent.findByDCont", query = "SELECT l FROM LTInspeContent l WHERE l.dCont = :dCont")
    , @NamedQuery(name = "LTInspeContent.findByDelYN", query = "SELECT l FROM LTInspeContent l WHERE l.delYN = :delYN")
    , @NamedQuery(name = "LTInspeContent.findByDelDate", query = "SELECT l FROM LTInspeContent l WHERE l.delDate = :delDate")
    , @NamedQuery(name = "LTInspeContent.findByDelUser", query = "SELECT l FROM LTInspeContent l WHERE l.delUser = :delUser")
    , @NamedQuery(name = "LTInspeContent.findByState", query = "SELECT l FROM LTInspeContent l WHERE l.state = :state")
    , @NamedQuery(name = "LTInspeContent.findByStateDate", query = "SELECT l FROM LTInspeContent l WHERE l.stateDate = :stateDate")
    , @NamedQuery(name = "LTInspeContent.findByStateUser", query = "SELECT l FROM LTInspeContent l WHERE l.stateUser = :stateUser")
    , @NamedQuery(name = "LTInspeContent.findByAddDate", query = "SELECT l FROM LTInspeContent l WHERE l.addDate = :addDate")
    , @NamedQuery(name = "LTInspeContent.findByAddUser", query = "SELECT l FROM LTInspeContent l WHERE l.addUser = :addUser")
    , @NamedQuery(name = "LTInspeContent.findByEditDate", query = "SELECT l FROM LTInspeContent l WHERE l.editDate = :editDate")
    , @NamedQuery(name = "LTInspeContent.findByEditUser", query = "SELECT l FROM LTInspeContent l WHERE l.editUser = :editUser")
    , @NamedQuery(name = "LTInspeContent.findByInsRep", query = "SELECT l FROM LTInspeContent l WHERE l.insRep = :insRep")
    , @NamedQuery(name = "LTInspeContent.findByInsDate", query = "SELECT l FROM LTInspeContent l WHERE l.insDate = :insDate")
    , @NamedQuery(name = "LTInspeContent.findByUpdRep", query = "SELECT l FROM LTInspeContent l WHERE l.updRep = :updRep")
    , @NamedQuery(name = "LTInspeContent.findByUpdDate", query = "SELECT l FROM LTInspeContent l WHERE l.updDate = :updDate")
    , @NamedQuery(name = "LTInspeContent.findByDelFlg", query = "SELECT l FROM LTInspeContent l WHERE l.delFlg = :delFlg")
    , @NamedQuery(name = "LTInspeContent.findByVersion", query = "SELECT l FROM LTInspeContent l WHERE l.version = :version")})
public class LTInspeContent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 50)
    @Column(name = "D_Nmae")
    private String dNmae;
    @Size(max = 250)
    @Column(name = "D_Add")
    private String dAdd;
    @Size(max = 50)
    @Column(name = "D_Tel")
    private String dTel;
    @Size(max = 200)
    @Column(name = "D_Coordinate")
    private String dCoordinate;
    @Size(max = 200)
    @Column(name = "D_Bhour")
    private String dBhour;
    @Size(max = 2147483647)
    @Column(name = "D_Cont")
    private String dCont;
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

    public LTInspeContent() {
    }

    public LTInspeContent(Long id) {
        this.id = id;
    }

    public LTInspeContent(Long id, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
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

    public String getDNmae() {
        return dNmae;
    }

    public void setDNmae(String dNmae) {
        this.dNmae = dNmae;
    }

    public String getDAdd() {
        return dAdd;
    }

    public void setDAdd(String dAdd) {
        this.dAdd = dAdd;
    }

    public String getDTel() {
        return dTel;
    }

    public void setDTel(String dTel) {
        this.dTel = dTel;
    }

    public String getDCoordinate() {
        return dCoordinate;
    }

    public void setDCoordinate(String dCoordinate) {
        this.dCoordinate = dCoordinate;
    }

    public String getDBhour() {
        return dBhour;
    }

    public void setDBhour(String dBhour) {
        this.dBhour = dBhour;
    }

    public String getDCont() {
        return dCont;
    }

    public void setDCont(String dCont) {
        this.dCont = dCont;
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
        if (!(object instanceof LTInspeContent)) {
            return false;
        }
        LTInspeContent other = (LTInspeContent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.LTInspeContent[ id=" + id + " ]";
    }
    
}
