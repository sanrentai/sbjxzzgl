package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import cn.tst.sbjxzzglxt.common.SepE;

/**
 * 员工角色表
 *
 * @author ps_xy@pscp.co.jp
 */
@Entity
@Table(name = "dat_yuangong_role")
@XmlRootElement
@NamedQueries({})
public class DatYuangongRole extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DatYuangongRolePK pk;

    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "you_xiao")
    private String youXiao;

    public DatYuangongRole() {
    }

    public DatYuangongRole(DatYuangongRolePK datYuangongRolePK) {
        this.pk = datYuangongRolePK;
    }

    public DatYuangongRole(DatYuangongRolePK datYuangongRolePK, String youXiao,
        String insRep, Date insDate, String updRep, Date updDate, SepE.Flag delFlg, int version) {
        super(insRep, insDate, updRep, updDate, delFlg, version);
        this.pk = datYuangongRolePK;
        this.youXiao = youXiao;
    }

    public DatYuangongRole(String yuanGongId, String roleId) {
        this.pk = new DatYuangongRolePK(yuanGongId, roleId);
    }

    public DatYuangongRolePK getPk() {
        return pk;
    }

    public void setPk(DatYuangongRolePK pk) {
        this.pk = pk;
    }

    public String getYouXiao() {
        return youXiao;
    }

    public void setYouXiao(String youXiao) {
        this.youXiao = youXiao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pk != null ? pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatYuangongRole)) {
            return false;
        }
        DatYuangongRole other = (DatYuangongRole) object;
        if ((this.pk == null && other.pk != null)
            || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.pscp.material.materialmg.entity.DatYuangongRole[ datYuangongRolePK=" + pk + " ]";
    }

    //***********************************************************************************************
    //                                  自定义关系的追加
    //***********************************************************************************************
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", insertable = false, updatable = false)
    private MstRoleInfo role;
    
    @ManyToOne
    @JoinColumn(name = "yuan_gong_id", referencedColumnName = "yuan_gong_id", insertable = false, updatable = false)
    private MstYuanGong yuangong;

    public MstRoleInfo getRole() {
        return role;
    }

    public void setRole(MstRoleInfo role) {
        this.role = role;
    }

    public boolean isYouXiaoB() {
        return SepE.Flag.YES.getValue().equals(this.youXiao);
    }

    public void setYouXiaoB(boolean flg) {
        this.youXiao = flg ? SepE.Flag.YES.getValue() : SepE.Flag.NO.getValue();
    }

    public MstYuanGong getYuangong() {
        return yuangong;
    }

    public void setYuangong(MstYuanGong yuangong) {
        this.yuangong = yuangong;
    }
}
