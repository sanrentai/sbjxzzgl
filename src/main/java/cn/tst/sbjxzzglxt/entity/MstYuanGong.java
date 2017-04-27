package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import cn.tst.sbjxzzglxt.common.CConst;
import cn.tst.sbjxzzglxt.common.CStringUtils;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import org.apache.commons.lang3.StringUtils;

/**
 * 员工表
 *
 * @author ps_xy@pscp.co.jp
 */
@Entity
@Table(name = "mst_yuan_gong")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstYuanGong.findByInYuanGongIdList", query = "SELECT y FROM MstYuanGong y"
        + " WHERE y.delFlg = :delFlg AND y.yuanGongId IN :yuanGongIdList"),
    @NamedQuery(name = "MstYuanGong.findByRoleId", query = "SELECT m FROM MstYuanGong m, DatYuangongRole y"
        + " WHERE y.delFlg = :delFlg "
            + "AND m.delFlg = :delFlg "
            + "AND m.yuanGongId = y.pk.yuanGongId "
            + "AND y.pk.roleId = :roleId")
})
public class MstYuanGong extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Size(min = 1, max = 10)
    @Column(name = "yuan_gong_id")
    private String yuanGongId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "xing")
    private String xing;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "xing_fayin")
    private String xingFayin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "ming")
    private String ming;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ming_fayin")
    private String mingFayin;
    @Size(max = 24)
    @Column(name = "bie_ming")
    private String bieMing;
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "shen_fen_zheng")
    private String shenFenZheng;
    @Size(max = 10)
    @Column(name = "you_bian")
    private String youBian;
    @Size(max = 2147483647)
    @Column(name = "zhu_zhi")
    private String zhuZhi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xing_bie")
    private String xingBie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "chu_sheng_ri_qi")
    @Temporal(TemporalType.DATE)
    private Date chuShengRiQi;
    @Size(max = 12)
    @Column(name = "dian_hua")
    private String dianHua;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="無効な電子メール")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(name = "email")
    private String email;
    @Size(max = 2147483647)
    @Column(name = "zhao_pian_lu_jing")
    private String zhaoPianLuJing;

    public MstYuanGong() {
    }

    public MstYuanGong(String yuanGongId) {
        this.yuanGongId = yuanGongId;
    }

    public MstYuanGong(String yuanGongId, String xing, String xingFayin, String ming, String mingFayin, String xingBie,
        String shenFenZheng, Date chuShengRiQi,
        String insRep, Date insDate, String updRep, Date updDate, SepE.Flag delFlg, int version) {
        super(insRep, insDate, updRep, updDate, delFlg, version);
        this.yuanGongId = yuanGongId;
        this.xing = xing;
        this.xingFayin = xingFayin;
        this.ming = ming;
        this.mingFayin = mingFayin;
        this.xingBie = xingBie;
        this.shenFenZheng = shenFenZheng;
        this.chuShengRiQi = chuShengRiQi;
    }

    public String getYuanGongId() {
        return yuanGongId;
    }

    public void setYuanGongId(String yuanGongId) {
        this.yuanGongId = yuanGongId;
    }

    public String getXing() {
        return xing;
    }

    public void setXing(String xing) {
        this.xing = xing;
    }

    public String getXingFayin() {
        return xingFayin;
    }

    public void setXingFayin(String xingFayin) {
        this.xingFayin = xingFayin;
    }

    public String getMing() {
        return ming;
    }

    public void setMing(String ming) {
        this.ming = ming;
    }

    public String getMingFayin() {
        return mingFayin;
    }

    public void setMingFayin(String mingFayin) {
        this.mingFayin = mingFayin;
    }

    public String getBieMing() {
        return bieMing;
    }

    public void setBieMing(String bieMing) {
        this.bieMing = bieMing;
    }

    public String getYouBian() {
        return youBian;
    }

    public void setYouBian(String youBian) {
        this.youBian = youBian;
    }

    public String getZhuZhi() {
        return zhuZhi;
    }

    public void setZhuZhi(String zhuZhi) {
        this.zhuZhi = zhuZhi;
    }

    public String getXingBie() {
        return xingBie;
    }

    public void setXingBie(String xingBie) {
        this.xingBie = xingBie;
    }

    public String getShenFenZheng() {
        return shenFenZheng;
    }

    public void setShenFenZheng(String shenFenZheng) {
        this.shenFenZheng = shenFenZheng;
    }

    public Date getChuShengRiQi() {
        return chuShengRiQi;
    }

    public void setChuShengRiQi(Date chuShengRiQi) {
        this.chuShengRiQi = chuShengRiQi;
    }

    public String getDianHua() {
        return dianHua;
    }

    public void setDianHua(String dianHua) {
        this.dianHua = dianHua;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZhaoPianLuJing() {
        return zhaoPianLuJing;
    }

    public void setZhaoPianLuJing(String zhaoPianLuJing) {
        this.zhaoPianLuJing = zhaoPianLuJing;
    }

    public String getName() {
        return this.xing + this.ming;
    }

    public String getNameZ() {
        return this.xing + "" + this.ming;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (yuanGongId != null ? yuanGongId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstYuanGong)) {
            return false;
        }
        MstYuanGong other = (MstYuanGong) object;
        if ((this.yuanGongId == null && other.yuanGongId != null) || (this.yuanGongId != null && !this.yuanGongId.equals(other.yuanGongId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.pscp.material.materialmg.entity.MstYuanGong[ yuanGongId=" + yuanGongId + " ]";
    }

    //***********************************************************************************************
    //                                  自定义关系的追加
    //***********************************************************************************************
    @OneToOne
    @JoinColumn(name = "yuan_gong_id", referencedColumnName = "yuangong_id", insertable = false, updatable = false)
    private DatLoginInfo loginInfo;
    
    @OneToMany(mappedBy = "yuangong")
    private List<DatYuangongRole> yuangongRoleList;
    
    @OneToMany(mappedBy = "yuanGong")
    private List<DatYuanGongSuoShu> yuanGongSuoShuList;

    public DatLoginInfo getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(DatLoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }
    
    @Transient
    public long dangQianRenWuShu = 0;

    public long getDangQianRenWuShu() {
        return dangQianRenWuShu;
    }

    public void setDangQianRenWuShu(long dangQianRenWuShu) {
        this.dangQianRenWuShu = dangQianRenWuShu;
    }

    /**
     * 性别表示
     *
     * @return 性别
     */
    public String getSexName() {
        return SepE.Sex.parse(this.xingBie).getName();
    }

    /**
     * 格式化邮编
     *
     * @return 格式化后的邮编
     */
    public String getFormatYouBian() {
        return CStringUtils.formatZip(this.youBian);
    }

    /**
     * 格式化电话
     *
     * @return 格式化后的电话
     */
    public String getFormatDianHua() {
        return CStringUtils.formatMobileNo(this.dianHua);
    }

    /**
     * 预览用图片路径
     *
     * @return 预览图片的路径
     */
    public String getPreviewPictureURL() {
        return this.getPictureURL("p");
    }

    /**
     * 压缩后图片路径
     *
     * @return 压缩后图片路径
     */
    public String getCompressedPictureURL() {

        return this.getPictureURL("c");
    }

    /**
     * 原图片路径
     *
     * @return 原图片路径
     */
    public String getOriginalPictureURL() {
        return this.getPictureURL("o");
    }

    /**
     * 是否是系统用户
     *
     * @return true:是 false:否
     */
    public boolean isExistsLoginUser() {
        if (this.loginInfo == null) {
            return false;
        }
        if (StringUtils.isEmpty(this.loginInfo.insRep)) {
            return false;
        }
        return true;
    }

    /**
     * 是否登录邮箱地址
     *
     * @return true:已登录 false:未登录
     */
    public boolean isHasInsertEmail() {
        return !StringUtils.isEmpty(this.email);
    }

    /**
     * 是否有别名
     *
     * @return true:有 false:无
     */
    public boolean isHasBieMing() {
        return !StringUtils.isEmpty(this.bieMing);
    }

    /**
     * 登录ID
     *
     * @return 登录ID
     */
    public String getTempLoginId() {
        return this.yuanGongId.substring(3);
    }

    /**
     * 默认密码<br/>
     * 身份证号码为空,或者不满18位则以出身年月日作为密码<br/>
     * 否则以身份证号码的后六位作为密码
     *
     * @return 返回默认密码
     */
    public String getDefaultPassword() {
//        if (StringUtils.isEmpty(this.shenFenZheng) || this.shenFenZheng.length() < 18) {
//            return CStringUtils.formatDate(this.chuShengRiQi, "yyMMdd");
//        }
//        return this.shenFenZheng.substring(12);
        /// 暂时使用固定默认密码
        return SepC.DEFAULT_LOGIN_PASSWORD;
    }

    /**
     * 得到图片的路径
     *
     * @param fileType 类型   <br/>
     * /uploadFiles/图片名/p  <br/>
     * /uploadFiles/图片名/c  <br/>
     * /uploadFiles/图片名/o
     * @return 图片路径 p:预览图, c:压缩图, o:原图
     */
    private String getPictureURL(String fileType) {

        return "/uploadFiles/"  + "/profile/" + (StringUtils.isEmpty(this.zhaoPianLuJing)
            ? SepC.UploadFileDefaultName.PROFILE : this.zhaoPianLuJing
            .concat(CConst.SLASH)
            .concat(fileType));
    }
    
    
    @Transient
    private MstBuMen bumen;
    
    @Transient
    private MstZhiNeng zhineng;

    public MstBuMen getBumen() {
        return bumen;
    }

    public void setBumen(MstBuMen bumen) {
        this.bumen = bumen;
    }

    public MstZhiNeng getZhineng() {
        return zhineng;
    }

    public void setZhineng(MstZhiNeng zhineng) {
        this.zhineng = zhineng;
    }

    public List<DatYuangongRole> getYuangongRoleList() {
        return yuangongRoleList;
    }

    public void setYuangongRoleList(List<DatYuangongRole> yuangongRoleList) {
        this.yuangongRoleList = yuangongRoleList;
    }

    public List<DatYuanGongSuoShu> getYuanGongSuoShuList() {
        return yuanGongSuoShuList;
    }

    public void setYuanGongSuoShuList(List<DatYuanGongSuoShu> yuanGongSuoShuList) {
        this.yuanGongSuoShuList = yuanGongSuoShuList;
    }
    
    public String getYiFenJueSe() {
        if (yuangongRoleList == null || yuangongRoleList.isEmpty()) {
            return "";
        }
        List<String> result = new ArrayList<>();
        
        for (DatYuangongRole yuangongRole : yuangongRoleList) {
            result.add(yuangongRole.getRole().getRoleName());
        }
        
        return String.join(CConst.COMMA, result);
    }
    
    public DatYuanGongSuoShu getYuanGongSuoShu() {
        if (yuanGongSuoShuList == null || yuanGongSuoShuList.isEmpty()) {
            return null;
        }
        
        for (DatYuanGongSuoShu yuanGongSuoShu : yuanGongSuoShuList) {
            if (yuanGongSuoShu.isZaiZhi() && yuanGongSuoShu.getDelFlg() == SepE.Flag.NO) {
                return yuanGongSuoShu;
            }
        }
        return null;
    }
}
