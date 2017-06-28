/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.SheBeiGuanLi.AddingBlockCoord;

import cn.tst.sbjxzzglxt.bizlogic.impl.BaseBizLogic;
import cn.tst.sbjxzzglxt.entity.MapSetting;
import cn.tst.sbjxzzglxt.entity.Uptown;
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
public class AddingBlockCoordBizLogic extends BaseBizLogic implements BizLogic {
    @EJB
    private UptownFacade uptownFacade;
    
    @EJB
    private MapSettingFacade mapSettingFacade;
    @Override
    public void init() {
        MapSetting mapSetting = mapSettingFacade.findAll().get(0);
        List<Uptown> uptownList = uptownFacade.findAll();
        for(Uptown uptown: uptownList) {
            if(uptown.getLongtitude() == null) {
                uptown.setLongtitude(mapSetting.getInitialLongtitude());
            }
            if(uptown.getLatitude()== null) {
                uptown.setLatitude(mapSetting.getInitialLatitude());
            }
        }
    }
    @Override
    public void loadViewModel(ViewModel viewModel) {
        viewModel.setUptownList(uptownFacade.findAll());
        Uptown uptownInEdit = new Uptown();
        uptownInEdit.setLongtitude(Double.MIN_VALUE);
        uptownInEdit.setLatitude(Double.MIN_VALUE);
        viewModel.setUptownInEdit(new Uptown());
        
        viewModel.setMapSettingList(mapSettingFacade.findAll());
    }
    @Override
    public void onAddingOrEditingBlockCoordButtonClick(ViewModel viewModel, Uptown uptown) {
        viewModel.setUptownInEdit(uptown);
    }
    @Override
    public void onOKButtonClick(ViewModel viewModel) {
        uptownFacade.edit(viewModel.getUptownInEdit());
    }
}
