/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.entity;

import cn.tst.sbjxzzglxt.common.SepE;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "LT_Equip_Notes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LTEquipNotes.findAll", query = "SELECT l FROM LTEquipNotes l")
    , @NamedQuery(name = "LTEquipNotes.findById", query = "SELECT l FROM LTEquipNotes l WHERE l.id = :id")
    , @NamedQuery(name = "LTEquipNotes.findByENum", query = "SELECT l FROM LTEquipNotes l WHERE l.eNum = :eNum AND l.delFlg = :delFlg")
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
    , @NamedQuery(name = "LTEquipNotes.findByVersion", query = "SELECT l FROM LTEquipNotes l WHERE l.version = :version")
    , @NamedQuery(name = "LTEquipNotes.findByDangQianBaoYangRiQi", query = "SELECT l FROM LTEquipNotes l WHERE l.dangQianBaoYangRiQi = :dangQianBaoYangRiQi")
    , @NamedQuery(name = "LTEquipNotes.findByXiaCiBaoYangRiQi", query = "SELECT l FROM LTEquipNotes l WHERE l.xiaCiBaoYangRiQi = :xiaCiBaoYangRiQi")
    , @NamedQuery(name = "LTEquipNotes.findByYiLiuWenTi", query = "SELECT l FROM LTEquipNotes l WHERE l.yiLiuWenTi = :yiLiuWenTi")
    , @NamedQuery(name = "LTEquipNotes.findByTType", query = "SELECT l FROM LTEquipNotes l WHERE l.tType = :tType AND l.delFlg = :delFlg")
    , @NamedQuery(name = "LTEquipNotes.findByGongZuoNeiRong", query = "SELECT l FROM LTEquipNotes l WHERE l.gongZuoNeiRong = :gongZuoNeiRong")
    , @NamedQuery(name = "LTEquipNotes.findByFuZeRen", query = "SELECT l FROM LTEquipNotes l WHERE l.fuZeRen = :fuZeRen AND l.delFlg = :delFlg")
    , @NamedQuery(name = "LTEquipNotes.findByChaXunShiJian", query = "SELECT l FROM LTEquipNotes l WHERE l.chaXunShiJian = :chaXunShiJian AND l.delFlg = :delFlg")})
public class LTEquipNotes extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "E_Num")
    private Long eNum;
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
   
    @Column(name = "DangQianBaoYangRiQi")
    @Temporal(TemporalType.DATE)
    private Date dangQianBaoYangRiQi;
    @Column(name = "XiaCiBaoYangRiQi")
    @Temporal(TemporalType.DATE)
    private Date xiaCiBaoYangRiQi;
    @Size(max = 255)
    @Column(name = "YiLiuWenTi")
    private String yiLiuWenTi;
    @Column(name = "T_Type")
    private Integer tType;
    @Size(max = 255)
    @Column(name = "GongZuoNeiRong")
    private String gongZuoNeiRong;
    @Size(max = 50)
    @Column(name = "FuZeRen")
    private String fuZeRen;
    @Column(name = "ChaXunShiJian")
    @Temporal(TemporalType.DATE)
    private Date chaXunShiJian;

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

    public Long getENum() {
        return eNum;
    }

    public void setENum(Long eNum) {
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

    public SepE.WeiXiuBaoYang getTType() {
        return SepE.WeiXiuBaoYang.parse(tType);
    }

    public void setTType(SepE.WeiXiuBaoYang tType) {
        this.tType = tType.getValue();
    }

    public String getGongZuoNeiRong() {
        return gongZuoNeiRong;
    }

    public void setGongZuoNeiRong(String gongZuoNeiRong) {
        this.gongZuoNeiRong = gongZuoNeiRong;
    }

    public String getFuZeRen() {
        return fuZeRen;
    }

    public void setFuZeRen(String fuZeRen) {
        this.fuZeRen = fuZeRen;
    }

    public Date getChaXunShiJian() {
        return chaXunShiJian;
    }

    public void setChaXunShiJian(Date chaXunShiJian) {
        this.chaXunShiJian = chaXunShiJian;
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
    
    // 设备表
     @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "E_Num", referencedColumnName = "ID", insertable = false, updatable = false)
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
