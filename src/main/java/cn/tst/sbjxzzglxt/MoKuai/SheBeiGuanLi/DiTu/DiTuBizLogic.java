/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.SheBeiGuanLi.DiTu;

import cn.tst.sbjxzzglxt.bizlogic.impl.BaseBizLogic;
import cn.tst.sbjxzzglxt.entity.MapSetting;
import cn.tst.sbjxzzglxt.entity.Uptown;
import cn.tst.sbjxzzglxt.facade.EmployeeFacade;
import cn.tst.sbjxzzglxt.facade.MapSettingFacade;
import cn.tst.sbjxzzglxt.facade.UptownFacade;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@Stateless
public class DiTuBizLogic extends BaseBizLogic implements BizLogic {
    public static final double DEFAULT_LONGTITUDE = 116.404;
    
    public static final double DEFAULT_LATITUDE = 39.915;
    
    public static final int DEFAULT_ZOOM = 15;
    @EJB
    private UptownFacade uptownFacade;
    
    @EJB
    private MapSettingFacade mapSettingFacade;
    
    @EJB
    private EmployeeFacade employeeFacade;
    
    @Override
    /**
     * @目的意图：创建默认的viewModel属性
     * @步骤：1. 创建mapSettingInEdit属性
    */
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
        viewModel.setMapSettingList(mapSettingFacade.findAll());
        viewModel.setEmployeeList(employeeFacade.findAll());
        
        Uptown uptown = new Uptown();
        uptown.setName("");
        uptown.setLongtitude(DEFAULT_LONGTITUDE);
        uptown.setLatitude(DEFAULT_LATITUDE);
        viewModel.setUptownInEdit(uptown);
    }
    @Override
    public void onOKButtonClickInMapCenterSettingDialog(ViewModel viewModel) {
        mapSettingFacade.edit(viewModel.getMapSettingInEdit());
    }
    @Override
    public void onBlockButtonClickInBlockListDialog(ViewModel viewModel, Uptown uptown) {
        viewModel.setUptownInEdit(uptown);
    }
    @Override
    public void onOKButtonClickInBlockCoordAddingEditDialog(ViewModel viewModel) {
        uptownFacade.edit(viewModel.getUptownInEdit());
    }
}
