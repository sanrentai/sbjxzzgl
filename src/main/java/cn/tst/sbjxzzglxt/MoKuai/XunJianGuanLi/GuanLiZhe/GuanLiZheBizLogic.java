/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.GuanLiZhe;

import cn.tst.sbjxzzglxt.bizlogic.impl.BaseBizLogic;
import cn.tst.sbjxzzglxt.facade.SysRoutingInspectionMessageFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@Stateless
public class GuanLiZheBizLogic extends BaseBizLogic implements BizLogic {
    @EJB
    private SysRoutingInspectionMessageFacade sysRoutingInspectionMessageFacade;
    @Override
    public void loadViewModel(ViewModel viewModel) {
        viewModel.setRoutingInspectionMessageList(sysRoutingInspectionMessageFacade.findAll());
    }
}
