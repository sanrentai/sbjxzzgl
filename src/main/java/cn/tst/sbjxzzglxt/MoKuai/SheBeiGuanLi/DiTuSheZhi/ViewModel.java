/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.SheBeiGuanLi.DiTuSheZhi;

import cn.tst.sbjxzzglxt.entity.Employee;
import cn.tst.sbjxzzglxt.entity.MapSetting;
import cn.tst.sbjxzzglxt.entity.Uptown;
import java.util.List;

/**
 *
 * @author Aaron-PC-i3-4130
 */
public class ViewModel {
    private MapSetting mapSettingInEdit;
    
    private Uptown uptownInEdit;
    
    private List<Uptown> uptownList;
    
    private List<MapSetting> mapSettingList;

    public List<Uptown> getUptownList() {
        return uptownList;
    }

    public void setUptownList(List<Uptown> uptownList) {
        this.uptownList = uptownList;
    }

    public List<MapSetting> getMapSettingList() {
        return mapSettingList;
    }

    public void setMapSettingList(List<MapSetting> mapSettingList) {
        this.mapSettingList = mapSettingList;
    }

    public Uptown getUptownInEdit() {
        return uptownInEdit;
    }

    public void setUptownInEdit(Uptown uptownInEdit) {
        this.uptownInEdit = uptownInEdit;
    }

    public MapSetting getMapSettingInEdit() {
        return mapSettingInEdit;
    }

    public void setMapSettingInEdit(MapSetting mapSettingInEdit) {
        this.mapSettingInEdit = mapSettingInEdit;
    }
}
