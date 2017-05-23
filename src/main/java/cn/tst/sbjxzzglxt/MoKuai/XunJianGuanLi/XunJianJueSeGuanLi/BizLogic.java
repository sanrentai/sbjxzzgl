/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianJueSeGuanLi;

import cn.tst.sbjxzzglxt.entity.MstXunJianRole;

/**
 *
 * @author Aaron-PC-i3-4130
 */
public interface BizLogic {
    void loadViewModel(ViewModel vm);
    
    void onSubmitNewRole(ViewModel vm);
    
    void onEditXunJianGuiZeDialogSubmit(ViewModel vm);
    
    void onEditXunJianFanWeiDialogSubmit(ViewModel vm);
    
    void onEditXunJianFanWei(ViewModel vm, MstXunJianRole currentRole);
    
    void onDeleteRole(ViewModel vm, MstXunJianRole role);
    
    void onEditXunJianGuiZe(ViewModel vm);
    
    void onEditRole(ViewModel vm);
    
    void onEditRoleSubmit(ViewModel vm);
}
