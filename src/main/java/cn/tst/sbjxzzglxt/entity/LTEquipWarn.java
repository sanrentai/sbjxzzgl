/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.entity;

import cn.tst.sbjxzzglxt.common.SepE;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "LT_Equip_Warn")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LTEquipWarn.findAll", query = "SELECT l FROM LTEquipWarn l")
    , @NamedQuery(name = "LTEquipWarn.findById", query = "SELECT l FROM LTEquipWarn l WHERE l.id = :id")
    , @NamedQuery(name = "LTEquipWarn.findByEId", query = "SELECT l FROM LTEquipWarn l WHERE l.eId = :eId AND l.delFlg = :delFlg")
    , @NamedQuery(name = "LTEquipWarn.findByTTitle", query = "SELECT l FROM LTEquipWarn l WHERE l.tTitle = :tTitle")
    , @NamedQuery(name = "LTEquipWarn.findByTContent", query = "SELECT l FROM LTEquipWarn l WHERE l.tContent = :tContent")
    , @NamedQuery(name = "LTEquipWarn.findByTDate", query = "SELECT l FROM LTEquipWarn l WHERE l.tDate = :tDate")
    , @NamedQuery(name = "LTEquipWarn.findByTTyoe", query = "SELECT l FROM LTEquipWarn l WHERE l.tTyoe = :tTyoe AND l.delFlg = :delFlg")
    , @NamedQuery(name = "LTEquipWarn.findByXhYn", query = "SELECT l FROM LTEquipWarn l WHERE l.xhYn = :xhYn")
    , @NamedQuery(name = "LTEquipWarn.findByDCont", query = "SELECT l FROM LTEquipWarn l WHERE l.dCont = :dCont")
    , @NamedQuery(name = "LTEquipWarn.findByDelYN", query = "SELECT l FROM LTEquipWarn l WHERE l.delYN = :delYN")
    , @NamedQuery(name = "LTEquipWarn.findByDelDate", query = "SELECT l FROM LTEquipWarn l WHERE l.delDate = :delDate")
    , @NamedQuery(name = "LTEquipWarn.findByDelUser", query = "SELECT l FROM LTEquipWarn l WHERE l.delUser = :delUser")
    , @NamedQuery(name = "LTEquipWarn.findByState", query = "SELECT l FROM LTEquipWarn l WHERE l.state = :state")
    , @NamedQuery(name = "LTEquipWarn.findByStateDate", query = "SELECT l FROM LTEquipWarn l WHERE l.stateDate = :stateDate")
    , @NamedQuery(name = "LTEquipWarn.findByStateUser", query = "SELECT l FROM LTEquipWarn l WHERE l.stateUser = :stateUser")
    , @NamedQuery(name = "LTEquipWarn.findByAddDate", query = "SELECT l FROM LTEquipWarn l WHERE l.addDate = :addDate")
    , @NamedQuery(name = "LTEquipWarn.findByAddUser", query = "SELECT l FROM LTEquipWarn l WHERE l.addUser = :addUser")
    , @NamedQuery(name = "LTEquipWarn.findByEditDate", query = "SELECT l FROM LTEquipWarn l WHERE l.editDate = :editDate")
    , @NamedQuery(name = "LTEquipWarn.findByEditUser", query = "SELECT l FROM LTEquipWarn l WHERE l.editUser = :editUser")
    , @NamedQuery(name = "LTEquipWarn.findByInsRep", query = "SELECT l FROM LTEquipWarn l WHERE l.insRep = :insRep")
    , @NamedQuery(name = "LTEquipWarn.findByInsDate", query = "SELECT l FROM LTEquipWarn l WHERE l.insDate = :insDate")
    , @NamedQuery(name = "LTEquipWarn.findByUpdRep", query = "SELECT l FROM LTEquipWarn l WHERE l.updRep = :updRep")
    , @NamedQuery(name = "LTEquipWarn.findByUpdDate", query = "SELECT l FROM LTEquipWarn l WHERE l.updDate = :updDate")
    , @NamedQuery(name = "LTEquipWarn.findByDelFlg", query = "SELECT l FROM LTEquipWarn l WHERE l.delFlg = :delFlg")
    , @NamedQuery(name = "LTEquipWarn.findByVersion", query = "SELECT l FROM LTEquipWarn l WHERE l.version = :version")})
public class LTEquipWarn extends BaseEntity implements Serializable {

    private static final Logger LOG = Logger.getLogger(LTEquipWarn.class.getName());
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "E_ID")
    private Long eId;
    @Size(max = 250)
    @Column(name = "T_Title")
    private String tTitle;
    @Size(max = 2147483647)
    @Column(name = "T_Content")
    private String tContent;
    @Column(name = "T_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tDate;
    @Column(name = "T_Tyoe")
    private Long tTyoe;
    @Column(name = "XH_YN")
    private Integer xhYn;
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

    public LTEquipWarn() {
    }

    public LTEquipWarn(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEId() {
        return eId;
    }

    public void setEId(Long eId) {
        this.eId = eId;
    }

    public String getTTitle() {
        return tTitle;
    }

    public void setTTitle(String tTitle) {
        this.tTitle = tTitle;
    }

    public String getTContent() {
        return tContent;
    }

    public void setTContent(String tContent) {
        this.tContent = tContent;
    }

    public Date getTDate() {
        return tDate;
    }

    public void setTDate(Date tDate) {
        this.tDate = tDate;
    }

//    public Long getTTyoe() {
//        return tTyoe;
//    }
//
//    public void setTTyoe(Long tTyoe) {
//        this.tTyoe = tTyoe;
//    }
    public SepE.ReminderTime getTTyoe() {
//        LOG.info(tTyoe);
//        LOG.info(tTyoe.intValue());
        return SepE.ReminderTime.parse(tTyoe.intValue());
    }

    public void setTTyoe(SepE.ReminderTime tTyoe) {
        if (tTyoe != null) {
        this.tTyoe = (long) tTyoe.getValue();
        }
    }

    public SepE.Whether getXhYn() {
        return SepE.Whether.parse(xhYn.intValue());
    }

    public void setXhYn(SepE.Whether xhYn) {
        this.xhYn = xhYn.getValue();
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LTEquipWarn)) {
            return false;
        }
        LTEquipWarn other = (LTEquipWarn) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.LTEquipWarn[ id=" + id + " ]";
    }

    //用于取设备表设备名称
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "E_ID", referencedColumnName = "ID", insertable = false, updatable = false)
        ,
        @JoinColumn(name = "del_flg", referencedColumnName = "del_flg", insertable = false, updatable = false)
    })
    private LTEquipBasic equipBasic;

    public LTEquipBasic getEquipBasic() {
        return equipBasic;
    }

    public void setEquipBasic(LTEquipBasic equipBasic) {
        this.equipBasic = equipBasic;
    }

}
