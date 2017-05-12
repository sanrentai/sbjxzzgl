/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.entity;

import cn.tst.sbjxzzglxt.common.CConst;
import cn.tst.sbjxzzglxt.common.SepC;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Table(name = "LT_Equip_Graphic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LTEquipGraphic.findAll", query = "SELECT l FROM LTEquipGraphic l")
    , @NamedQuery(name = "LTEquipGraphic.findById", query = "SELECT l FROM LTEquipGraphic l WHERE l.id = :id")
    , @NamedQuery(name = "LTEquipGraphic.findByENum", query = "SELECT l FROM LTEquipGraphic l WHERE l.eNum = :eNum")
    , @NamedQuery(name = "LTEquipGraphic.findByOriginalName", query = "SELECT l FROM LTEquipGraphic l WHERE l.fOriginalName = :fOriginalName")
    , @NamedQuery(name = "LTEquipGraphic.findByFUrl", query = "SELECT l FROM LTEquipGraphic l WHERE l.fUrl = :fUrl")
    , @NamedQuery(name = "LTEquipGraphic.findByFVer", query = "SELECT l FROM LTEquipGraphic l WHERE l.fVer = :fVer")
    , @NamedQuery(name = "LTEquipGraphic.findByDelYN", query = "SELECT l FROM LTEquipGraphic l WHERE l.delYN = :delYN")
    , @NamedQuery(name = "LTEquipGraphic.findByDelDate", query = "SELECT l FROM LTEquipGraphic l WHERE l.delDate = :delDate")
    , @NamedQuery(name = "LTEquipGraphic.findByDelUser", query = "SELECT l FROM LTEquipGraphic l WHERE l.delUser = :delUser")
    , @NamedQuery(name = "LTEquipGraphic.findByState", query = "SELECT l FROM LTEquipGraphic l WHERE l.state = :state")
    , @NamedQuery(name = "LTEquipGraphic.findByStateDate", query = "SELECT l FROM LTEquipGraphic l WHERE l.stateDate = :stateDate")
    , @NamedQuery(name = "LTEquipGraphic.findByStateUser", query = "SELECT l FROM LTEquipGraphic l WHERE l.stateUser = :stateUser")
    , @NamedQuery(name = "LTEquipGraphic.findByAddDate", query = "SELECT l FROM LTEquipGraphic l WHERE l.addDate = :addDate")
    , @NamedQuery(name = "LTEquipGraphic.findByAddUser", query = "SELECT l FROM LTEquipGraphic l WHERE l.addUser = :addUser")
    , @NamedQuery(name = "LTEquipGraphic.findByEditDate", query = "SELECT l FROM LTEquipGraphic l WHERE l.editDate = :editDate")
    , @NamedQuery(name = "LTEquipGraphic.findByEditUser", query = "SELECT l FROM LTEquipGraphic l WHERE l.editUser = :editUser")
    , @NamedQuery(name = "LTEquipGraphic.findByInsRep", query = "SELECT l FROM LTEquipGraphic l WHERE l.insRep = :insRep")
    , @NamedQuery(name = "LTEquipGraphic.findByInsDate", query = "SELECT l FROM LTEquipGraphic l WHERE l.insDate = :insDate")
    , @NamedQuery(name = "LTEquipGraphic.findByUpdRep", query = "SELECT l FROM LTEquipGraphic l WHERE l.updRep = :updRep")
    , @NamedQuery(name = "LTEquipGraphic.findByUpdDate", query = "SELECT l FROM LTEquipGraphic l WHERE l.updDate = :updDate")
    , @NamedQuery(name = "LTEquipGraphic.findByDelFlg", query = "SELECT l FROM LTEquipGraphic l WHERE l.delFlg = :delFlg")
    , @NamedQuery(name = "LTEquipGraphic.findByVersion", query = "SELECT l FROM LTEquipGraphic l WHERE l.version = :version")})
public class LTEquipGraphic extends BaseEntity implements Serializable {
    @Size(max = 250)
    @Column(name = "F_OriginalName")
    private String fOriginalName;
    @Size(max = 255)
    @Column(name = "F_NameOnServer")
    private String fNameOnServer;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Size(max = 50)
    @Column(name = "E_Num")
    private String eNum;
    @Size(max = 350)
    @Column(name = "F_Url")
    private String fUrl;
    @Column(name = "F_Ver")
    private Integer fVer;
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

    public LTEquipGraphic() {
    }

    public LTEquipGraphic(Long id) {
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

    public String getFUrl() {
        return fUrl;
    }

    public void setFUrl(String fUrl) {
        this.fUrl = fUrl;
    }

    public Integer getFVer() {
        return fVer;
    }

    public void setFVer(Integer fVer) {
        this.fVer = fVer;
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
        if (!(object instanceof LTEquipGraphic)) {
            return false;
        }
        LTEquipGraphic other = (LTEquipGraphic) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.LTEquipGraphic[ id=" + id + " ]";
    }

    public String getFOriginalName() {
        return fOriginalName;
    }

    public void setFOriginalName(String fOriginalName) {
        this.fOriginalName = fOriginalName;
    }

    public String getFNameOnServer() {
        return fNameOnServer;
    }

    public void setFNameOnServer(String fNameOnServer) {
        this.fNameOnServer = fNameOnServer;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "E_NUM", referencedColumnName = "E_NUM", insertable = false, updatable = false),
        @JoinColumn(name = "del_flg", referencedColumnName = "del_flg", insertable = false, updatable = false)
    })
    private LTEquipBasic equipment;

    public String getfOriginalName() {
        return fOriginalName;
    }

    public void setfOriginalName(String fOriginalName) {
        this.fOriginalName = fOriginalName;
    }

    public String getfNameOnServer() {
        return fNameOnServer;
    }

    public void setfNameOnServer(String fNameOnServer) {
        this.fNameOnServer = fNameOnServer;
    }

    public String geteNum() {
        return eNum;
    }

    public void seteNum(String eNum) {
        this.eNum = eNum;
    }

    public String getfUrl() {
        return fUrl;
    }

    public void setfUrl(String fUrl) {
        this.fUrl = fUrl;
    }

    public Integer getfVer() {
        return fVer;
    }

    public void setfVer(Integer fVer) {
        this.fVer = fVer;
    }

    public LTEquipBasic getEquipment() {
        return equipment;
    }

    public void setEquipment(LTEquipBasic equipment) {
        this.equipment = equipment;
    }
    
    public String getPreviewFilePath() {
        String result = "/uploadFiles/".concat(CConst.SLASH)
                .concat(SepC.DEVICE_DOCUMENTS_DIRECTORY_NAME)
                .concat(CConst.SLASH)
                .concat(this.getFNameOnServer())
                .concat(CConst.SLASH)
                .concat("p");
        return result;
    }
    
    public String getOriginalFilePath() {
        String result = "/uploadFiles/".concat(CConst.SLASH)
                .concat(SepC.DEVICE_DOCUMENTS_DIRECTORY_NAME)
                .concat(CConst.SLASH)
                .concat(this.getFNameOnServer())
                .concat(CConst.SLASH)
                .concat("o");
        return result;
    }

    @OneToMany(mappedBy="graphic",fetch = FetchType.EAGER)
    private List<LTEquipCheckPoint> checkPointList;

    public List<LTEquipCheckPoint> getCheckPointList() {
        return checkPointList;
    }

    public void setCheckPointList(List<LTEquipCheckPoint> checkPointList) {
        this.checkPointList = checkPointList;
    }
}
