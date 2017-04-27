package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import cn.tst.sbjxzzglxt.common.SepE;

/**
 * Login 实体
 *
 * @author ps_xy@pscp.co.jp
 */
@Entity
@Table(name = "dat_login_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatLoginInfo.findByLoginId", query = "SELECT d FROM DatLoginInfo d WHERE d.delFlg = :delFlg AND d.loginId = :loginId"),
    @NamedQuery(name = "DatLoginInfo.findByIdAndPw", query = "SELECT d FROM DatLoginInfo d WHERE d.delFlg = :delFlg AND d.loginId = :loginId AND d.password = :md5passwd"),
    @NamedQuery(name = "DatLoginInfo.findAll", query = "SELECT d FROM DatLoginInfo d WHERE d.delFlg = :delFlg")
})
public class DatLoginInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "login_id")
    private String loginId;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "yuangong_id")
    private String yuangongId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lock")
    private String lock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "first_time_login")
    private String firstTimeLogin;

    public DatLoginInfo() {
    }

    public DatLoginInfo(String loginId) {
        this.loginId = loginId;
    }

    public DatLoginInfo(String loginId, String yuangongId, String password, String lock,
        String insRep, Date insDate, String updRep, Date updDate, SepE.Flag delFlg, int version) {

        super(insRep, insDate, updRep, updDate, delFlg, version);
        this.loginId = loginId;
        this.yuangongId = yuangongId;
        this.password = password;
        this.lock = lock;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getYuangongId() {
        return yuangongId;
    }

    public void setYuangongId(String yuangongId) {
        this.yuangongId = yuangongId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLock() {
        return lock;
    }

    public void setLock(String lock) {
        this.lock = lock;
    }

    public String getFirstTimeLogin() {
        return firstTimeLogin;
    }

    public void setFirstTimeLogin(String firstTimeLogin) {
        this.firstTimeLogin = firstTimeLogin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loginId != null ? loginId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DatLoginInfo)) {
            return false;
        }
        DatLoginInfo other = (DatLoginInfo) object;
        if ((this.loginId == null && other.loginId != null)
            || (this.loginId != null && !this.loginId.equals(other.loginId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.pscp.material.materialmg.entity.DatLoginInfo[ loginId=" + loginId + " ]";
    }

    //***********************************************************************************************
    //                                  自定义关系的追加
    //***********************************************************************************************
    @Transient
    private String randomTempPassword;

    public String getRandomTempPassword() {
        return randomTempPassword;
    }

    public void setRandomTempPassword(String randomTempPassword) {
        this.randomTempPassword = randomTempPassword;
    }

    /**
     * 用户初次登录
     *
     * @return true: 是初次登录 false: 非初次登录
     */
    public boolean isUserFirstTimeLogin() {
//        TODO 暂时屏蔽初次登录功能
//        return SepE.Flag.YES.getValue().equals(this.firstTimeLogin);
        return false;
    }
    
    @OneToOne
    @JoinColumn(name = "yuangong_id", referencedColumnName = "yuan_gong_id", insertable = false, updatable = false)
    private MstYuanGong yuanGong;

    public MstYuanGong getYuanGong() {
        return yuanGong;
    }

    public void setYuanGong(MstYuanGong yuanGong) {
        this.yuanGong = yuanGong;
    }
}
