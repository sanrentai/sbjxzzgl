/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "sys_User_Group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysUserGroup.findAll", query = "SELECT s FROM SysUserGroup s")
    , @NamedQuery(name = "SysUserGroup.findById", query = "SELECT s FROM SysUserGroup s WHERE s.id = :id")
    , @NamedQuery(name = "SysUserGroup.findByGroupID", query = "SELECT s FROM SysUserGroup s WHERE s.groupID = :groupID")
    , @NamedQuery(name = "SysUserGroup.findByGroupName", query = "SELECT s FROM SysUserGroup s WHERE s.groupName = :groupName")
    , @NamedQuery(name = "SysUserGroup.findByGroupCount", query = "SELECT s FROM SysUserGroup s WHERE s.groupCount = :groupCount")})
public class SysUserGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Column(name = "GroupID")
    private Integer groupID;
    @Size(max = 50)
    @Column(name = "GroupName")
    private String groupName;
    @Column(name = "GroupCount")
    private Integer groupCount;

    public SysUserGroup() {
    }

    public SysUserGroup(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(Integer groupCount) {
        this.groupCount = groupCount;
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
        if (!(object instanceof SysUserGroup)) {
            return false;
        }
        SysUserGroup other = (SysUserGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.SysUserGroup[ id=" + id + " ]";
    }
    
}
