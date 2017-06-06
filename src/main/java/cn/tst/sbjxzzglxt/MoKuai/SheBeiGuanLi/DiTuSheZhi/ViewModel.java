/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.SheBeiGuanLi.DiTuSheZhi;

import cn.tst.sbjxzzglxt.entity.MapSetting;
import cn.tst.sbjxzzglxt.entity.Uptown;

/**
 *
 * @author Aaron-PC-i3-4130
 */
public class ViewModel {
    private MapSetting mapSettingInEdit;
    
    private Uptown uptownInEdit;

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
