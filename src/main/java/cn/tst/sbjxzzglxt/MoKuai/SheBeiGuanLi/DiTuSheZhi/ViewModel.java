/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.SheBeiGuanLi.DiTuSheZhi;

import cn.tst.sbjxzzglxt.entity.Blocks;
import cn.tst.sbjxzzglxt.entity.MapSetting;

/**
 *
 * @author Aaron-PC-i3-4130
 */
public class ViewModel {
    private MapSetting mapSettingInEdit;
    
    private Blocks blockInEdit;

    public Blocks getBlockInEdit() {
        return blockInEdit;
    }

    public void setBlockInEdit(Blocks blockInEdit) {
        this.blockInEdit = blockInEdit;
    }

    public MapSetting getMapSettingInEdit() {
        return mapSettingInEdit;
    }

    public void setMapSettingInEdit(MapSetting mapSettingInEdit) {
        this.mapSettingInEdit = mapSettingInEdit;
    }
}
