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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "mst_yuan_gong_xun_jian_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstYuanGongXunJianRole.findAll", query = "SELECT m FROM MstYuanGongXunJianRole m")
    , @NamedQuery(name = "MstYuanGongXunJianRole.findByYuanGongId", query = "SELECT m FROM MstYuanGongXunJianRole m WHERE m.mstYuanGongXunJianRolePK.yuanGongId = :yuanGongId")
    , @NamedQuery(name = "MstYuanGongXunJianRole.findByRoleId", query = "SELECT m FROM MstYuanGongXunJianRole m WHERE m.mstYuanGongXunJianRolePK.roleId = :roleId")
    , @NamedQuery(name = "MstYuanGongXunJianRole.findByYouXiao", query = "SELECT m FROM MstYuanGongXunJianRole m WHERE m.youXiao = :youXiao")
    , @NamedQuery(name = "MstYuanGongXunJianRole.findByInsRep", query = "SELECT m FROM MstYuanGongXunJianRole m WHERE m.insRep = :insRep")
    , @NamedQuery(name = "MstYuanGongXunJianRole.findByInsDate", query = "SELECT m FROM MstYuanGongXunJianRole m WHERE m.insDate = :insDate")
    , @NamedQuery(name = "MstYuanGongXunJianRole.findByUpdRep", query = "SELECT m FROM MstYuanGongXunJianRole m WHERE m.updRep = :updRep")
    , @NamedQuery(name = "MstYuanGongXunJianRole.findByUpdDate", query = "SELECT m FROM MstYuanGongXunJianRole m WHERE m.updDate = :updDate")
    , @NamedQuery(name = "MstYuanGongXunJianRole.findByDelFlg", query = "SELECT m FROM MstYuanGongXunJianRole m WHERE m.delFlg = :delFlg")
    , @NamedQuery(name = "MstYuanGongXunJianRole.findByVersion", query = "SELECT m FROM MstYuanGongXunJianRole m WHERE m.version = :version")})
public class MstYuanGongXunJianRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MstYuanGongXunJianRolePK mstYuanGongXunJianRolePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "you_xiao")
    private Character youXiao;
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

    public MstYuanGongXunJianRole() {
    }

    public MstYuanGongXunJianRole(MstYuanGongXunJianRolePK mstYuanGongXunJianRolePK) {
        this.mstYuanGongXunJianRolePK = mstYuanGongXunJianRolePK;
    }

    public MstYuanGongXunJianRole(MstYuanGongXunJianRolePK mstYuanGongXunJianRolePK, Character youXiao, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
        this.mstYuanGongXunJianRolePK = mstYuanGongXunJianRolePK;
        this.youXiao = youXiao;
        this.insRep = insRep;
        this.insDate = insDate;
        this.updRep = updRep;
        this.updDate = updDate;
        this.delFlg = delFlg;
        this.version = version;
    }

    public MstYuanGongXunJianRole(String yuanGongId, int roleId) {
        this.mstYuanGongXunJianRolePK = new MstYuanGongXunJianRolePK(yuanGongId, roleId);
    }

    public MstYuanGongXunJianRolePK getMstYuanGongXunJianRolePK() {
        return mstYuanGongXunJianRolePK;
    }

    public void setMstYuanGongXunJianRolePK(MstYuanGongXunJianRolePK mstYuanGongXunJianRolePK) {
        this.mstYuanGongXunJianRolePK = mstYuanGongXunJianRolePK;
    }

    public Character getYouXiao() {
        return youXiao;
    }

    public void setYouXiao(Character youXiao) {
        this.youXiao = youXiao;
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
        hash += (mstYuanGongXunJianRolePK != null ? mstYuanGongXunJianRolePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstYuanGongXunJianRole)) {
            return false;
        }
        MstYuanGongXunJianRole other = (MstYuanGongXunJianRole) object;
        if ((this.mstYuanGongXunJianRolePK == null && other.mstYuanGongXunJianRolePK != null) || (this.mstYuanGongXunJianRolePK != null && !this.mstYuanGongXunJianRolePK.equals(other.mstYuanGongXunJianRolePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.MstYuanGongXunJianRole[ mstYuanGongXunJianRolePK=" + mstYuanGongXunJianRolePK + " ]";
    }
    
}
