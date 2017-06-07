/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.SheBeiGuanLi.DiTu;

import cn.tst.sbjxzzglxt.bizlogic.impl.BaseBizLogic;
import cn.tst.sbjxzzglxt.facade.EmployeeFacade;
import cn.tst.sbjxzzglxt.facade.MapSettingFacade;
import cn.tst.sbjxzzglxt.facade.UptownFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@Stateless
public class DiTuBizLogic extends BaseBizLogic implements BizLogic {
    @EJB
    private UptownFacade uptownFacade;
    
    @EJB
    private MapSettingFacade mapSettingFacade;
    
    @EJB
    private EmployeeFacade employeeFacade;
    
    @Override
    public void loadViewModel(ViewModel viewModel) {
        viewModel.setUptownList(uptownFacade.findAll());
        viewModel.setMapSettingList(mapSettingFacade.findAll());
        viewModel.setEmployeeList(employeeFacade.findAll());
    }
}
