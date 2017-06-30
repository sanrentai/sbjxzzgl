/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.SheBeiGuanLi.DiTu;

import cn.tst.sbjxzzglxt.entity.Uptown;

/**
 *
 * @author Aaron-PC-i3-4130
 */
public interface BizLogic {
    void loadViewModel(ViewModel viewModel);
    
    void onOKButtonClickInMapCenterSettingDialog(ViewModel viewModel);
    
    void onBlockButtonClickInBlockListDialog(ViewModel viewModel, Uptown uptown);
    
    void onOKButtonClickInBlockCoordAddingEditDialog(ViewModel viewModel);
}
