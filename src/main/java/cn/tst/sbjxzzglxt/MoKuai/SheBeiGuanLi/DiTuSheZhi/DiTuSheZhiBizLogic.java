/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.SheBeiGuanLi.DiTuSheZhi;

import cn.tst.sbjxzzglxt.bizlogic.impl.BaseBizLogic;
import cn.tst.sbjxzzglxt.entity.MapSetting;
import cn.tst.sbjxzzglxt.facade.MapSettingFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@Stateless
public class DiTuSheZhiBizLogic extends BaseBizLogic implements BizLogic {
    public static final double DEFAULT_LONGTITUDE = 116.404;
    
    public static final double DEFAULT_LATITUDE = 39.915;
    
    public static final int DEFAULT_ZOOM = 15;
    @EJB
    private MapSettingFacade mapSettingFacade;

    public MapSettingFacade getMapSettingFacade() {
        return mapSettingFacade;
    }

    public void setMapSettingFacade(MapSettingFacade mapSettingFacade) {
        this.mapSettingFacade = mapSettingFacade;
    }
    @Override
    public void loadViewModel(ViewModel viewModel) {
        List<MapSetting> mapSettingInEditList = mapSettingFacade.findAll();
        if(mapSettingInEditList.isEmpty()) {
            MapSetting mapSetting = new MapSetting();
            mapSetting.setInitialLongtitude(DEFAULT_LONGTITUDE);
            mapSetting.setInitialLatitude(DEFAULT_LATITUDE);
            mapSetting.setZoom(DEFAULT_ZOOM);
            viewModel.setMapSettingInEdit(mapSetting);
            mapSettingFacade.create(mapSetting);
        } else {
            viewModel.setMapSettingInEdit(mapSettingInEditList.get(0));
        }
    }
    @Override
    public void onOKButtonClickInMapCenterSettingDialog(ViewModel viewModel) {
        mapSettingFacade.edit(viewModel.getMapSettingInEdit());
    }
}
