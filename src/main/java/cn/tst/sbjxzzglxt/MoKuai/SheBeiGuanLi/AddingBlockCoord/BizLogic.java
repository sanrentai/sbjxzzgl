/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.SheBeiGuanLi.AddingBlockCoord;

import cn.tst.sbjxzzglxt.entity.Uptown;

/**
 *
 * @author Aaron-PC-i3-4130
 */
public interface BizLogic {
    void init();
    
    void loadViewModel(ViewModel viewModel);
    
    void onAddingOrEditingBlockCoordButtonClick(ViewModel viewModel, Uptown uptown);
    
    void onOKButtonClick(ViewModel viewModel);
}
