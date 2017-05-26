/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.common;

import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import java.io.Serializable;

/**
 *
 * @author Aaron-PC-i3-4130
 */
public class EquipmentNodeData implements Serializable, Comparable<EquipmentNodeData> {
    private String name;
    
    private Integer roleId;
    
    private Long checkPointId;
    
    private LTEquipBasic equipment;

    public LTEquipBasic getEquipment() {
        return equipment;
    }

    public void setEquipment(LTEquipBasic equipment) {
        this.equipment = equipment;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Long getCheckPointId() {
        return checkPointId;
    }

    public void setCheckPointId(Long checkPointId) {
        this.checkPointId = checkPointId;
    }
    
    public EquipmentNodeData(String name, Integer roleId, Long checkPointId) {
        this.name = name;
        this.roleId = roleId;
        this.checkPointId = checkPointId;
    }
    
    public EquipmentNodeData(String name, LTEquipBasic equipment) {
        this.name = name;
        this.equipment = equipment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EquipmentNodeData other = (EquipmentNodeData) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return name;
    }
    @Override
    public int compareTo(EquipmentNodeData otherNodeData) {
        return this.getName().compareTo(otherNodeData.getName());
    }
}
