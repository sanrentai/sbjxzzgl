/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.SheBeiGuanLi.AddingBlockCoord;

import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import cn.tst.sbjxzzglxt.entity.Uptown;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@ViewScoped
@Named("AddingBlockCoordController")
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
        bizLogic.init();
        viewModel = new ViewModel();
        bizLogic.loadViewModel(viewModel);
    }
    
    public void onAddingOrEditingBlockCoordButtonClick(Uptown uptown) {
        bizLogic.onAddingOrEditingBlockCoordButtonClick(viewModel, uptown);
    }
    
    public void onOKButtonClick() {
        bizLogic.onOKButtonClick(viewModel);
    }
}
