/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.SheBeiGuanLi.DiTu;

import cn.tst.sbjxzzglxt.entity.Employee;
import cn.tst.sbjxzzglxt.entity.MapSetting;
import cn.tst.sbjxzzglxt.entity.Uptown;
import cn.tst.sbjxzzglxt.entity.SomeClass1;
import java.util.List;

/**
 *
 * @author Aaron-PC-i3-4130
 */
public class ViewModel {
    private List<Uptown> uptownList;
    
    private List<MapSetting> mapSettingList;
    
    private List<Employee> employeeList;
    
    private List<SomeClass1> someClass1List;

    public List<SomeClass1> getSomeClass1List() {
        return someClass1List;
    }

    public void setSomeClass1List(List<SomeClass1> someClass1List) {
        this.someClass1List = someClass1List;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<MapSetting> getMapSettingList() {
        return mapSettingList;
    }

    public void setMapSettingList(List<MapSetting> mapSettingList) {
        this.mapSettingList = mapSettingList;
    }

    public List<Uptown> getUptownList() {
        return uptownList;
    }

    public void setUptownList(List<Uptown> uptownList) {
        this.uptownList = uptownList;
    }
}
