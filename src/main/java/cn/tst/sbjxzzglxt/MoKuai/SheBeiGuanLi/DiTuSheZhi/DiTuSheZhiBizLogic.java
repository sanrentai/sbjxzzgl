/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.SheBeiGuanLi.DiTuSheZhi;

import cn.tst.sbjxzzglxt.bizlogic.impl.BaseBizLogic;
import cn.tst.sbjxzzglxt.entity.MapSetting;
import cn.tst.sbjxzzglxt.entity.Uptown;
import cn.tst.sbjxzzglxt.facade.EmployeeFacade;
import cn.tst.sbjxzzglxt.facade.MapSettingFacade;
import cn.tst.sbjxzzglxt.facade.UptownFacade;
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
    
    @EJB
    private UptownFacade uptownFacade;

    public UptownFacade getUptownFacade() {
        return uptownFacade;
    }

    public void setUptownFacade(UptownFacade uptownFacade) {
        this.uptownFacade = uptownFacade;
    }

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
        viewModel.setUptownList(uptownFacade.findAll());
        Uptown uptown = new Uptown();
        uptown.setUptownId("");
        uptown.setAppendix("");
        uptown.setTranssign('c');
        viewModel.setUptownInEdit(uptown);
    }
    @Override
    public void onOKButtonClickInMapCenterSettingDialog(ViewModel viewModel) {
        mapSettingFacade.edit(viewModel.getMapSettingInEdit());
    }
    @Override
    public void onOKButtonClickInBlockAddingEditDialog(ViewModel viewModel) {
        uptownFacade.create(viewModel.getUptownInEdit());
    }
}
