/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.GuanLiZhe;

import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@ViewScoped
@Named(SepC.ControllerID.GUAN_LI_ZHE_CONTROLLER_NAME)
public class Controller extends BusinessBaseController {
    @EJB
    private BizLogic bizLogic;
    
    private ViewModel viewModel;

    public BizLogic getBizLogic() {
        return bizLogic;
    }

    public void setBizLogic(BizLogic bizLogic) {
        this.bizLogic = bizLogic;
    }

    public ViewModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }
    
    @PostConstruct
    public void init() {
        viewModel = new ViewModel();
        bizLogic.loadViewModel(viewModel);
    }
}
