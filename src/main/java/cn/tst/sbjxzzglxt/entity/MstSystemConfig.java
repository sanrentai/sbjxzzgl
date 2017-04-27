package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;

/**
 * 物系统配置信息
 *
 * @author ps_xy@pscp.co.jp
 */
@Entity
@Table(name = "mst_system_config")
@XmlRootElement
@NamedQueries({})
public class MstSystemConfig extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "sys_id")
    private String sysId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inv_level")
    private int invLevel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "db_name")
    private String dbName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "company_name")
    private String companyName;

    public MstSystemConfig() {
    }

    public MstSystemConfig(String sysId) {
        this.sysId = sysId;
    }

    public MstSystemConfig(String sysId, String color, String title, int invLevel,
        String insRep, Date insDate, String updRep, Date updDate, SepE.Flag delFlg, int version) {
        super(insRep, insDate, updRep, updDate, delFlg, version);
        this.sysId = sysId;
        this.color = color;
        this.title = title;
        this.invLevel = invLevel;
    }

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getInvLevel() {
        return invLevel;
    }

    public void setInvLevel(int invLevel) {
        this.invLevel = invLevel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sysId != null ? sysId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstSystemConfig)) {
            return false;
        }
        MstSystemConfig other = (MstSystemConfig) object;
        if ((this.sysId == null && other.sysId != null) || (this.sysId != null && !this.sysId.equals(other.sysId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.pscp.material.materialmg.entity.MstSystemConfig[ sysId=" + sysId + " ]";
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    public boolean isMainDb() {
        return SepC.PERSISTENCE_UNIT.equals(this.dbName);
    }

}
