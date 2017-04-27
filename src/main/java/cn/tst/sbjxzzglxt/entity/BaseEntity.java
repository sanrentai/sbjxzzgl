package cn.tst.sbjxzzglxt.entity;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import cn.tst.sbjxzzglxt.common.SepE;

/**
 * 实现类基类
 *
 * @author ps_xy@pscp.co.jp
 */
@MappedSuperclass
public class BaseEntity {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ins_rep")
    protected String insRep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ins_date")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date insDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "upd_rep")
    protected String updRep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "upd_date")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "del_flg")
    protected String delFlg;
//    @Version
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    protected int version;

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

    public SepE.Flag getDelFlg() {
        return SepE.Flag.parse(delFlg);
    }

    public void setDelFlg(SepE.Flag delFlg) {
        this.delFlg = delFlg.getValue();
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public BaseEntity() {
        /// 在插入db时赋值，构造函数不做处理
//        //当前时间作为默认创建和更新时间
//        Date updateDate = new Date();
//        this.insDate = updateDate;
//        this.updDate = updateDate;
//        this.insRep = SepC.DEFAULT_CREATOR_ID;
//        this.updRep = SepC.DEFAULT_CREATOR_ID;
//        this.delFlg = SepE.Flag.NO.getValue();
//        this.version = 0;
    }

    public BaseEntity(String insRep, Date insDate, String updRep, Date updDate, SepE.Flag delFlg, int version) {
        this.insRep = insRep;
        this.insDate = insDate;
        this.updRep = updRep;
        this.updDate = updDate;
        this.delFlg = delFlg.getValue();
        this.version = version;
    }

    public void setCreateInfo(String yuanGongId) {
        //当前时间作为默认创建和更新时间
        Date now = new Date();
        this.insDate = now;
        this.updDate = now;
        this.insRep = yuanGongId;
        this.updRep = yuanGongId;
        this.delFlg = SepE.Flag.NO.getValue();
        this.version = 0;
    }

    public void setUpdateInfo(String yuanGongId) {
        Date now = new Date();
        this.updDate = now;
        this.updRep = yuanGongId;
    }

    // 员工表
    @JoinColumn(name = "ins_rep", referencedColumnName = "yuan_gong_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private MstYuanGong insUserInfo;

    public MstYuanGong getInsUserInfo() {
        return insUserInfo;
    }

    public void setInsUserInfo(MstYuanGong insUserInfo) {
        this.insUserInfo = insUserInfo;
    }
    
    @Transient
    private MstSystemConfig systemConfig;

    public MstSystemConfig getSystemConfig() {
        return systemConfig;
    }

    public void setSystemConfig(MstSystemConfig systemConfig) {
        this.systemConfig = systemConfig;
    }
    
    public boolean isDeleted() {
        return this.getDelFlg() == SepE.Flag.YES;
    }
}
