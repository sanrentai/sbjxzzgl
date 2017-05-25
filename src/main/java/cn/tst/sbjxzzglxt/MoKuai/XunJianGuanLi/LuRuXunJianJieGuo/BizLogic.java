/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.LuRuXunJianJieGuo;

import cn.tst.sbjxzzglxt.entity.LTEquipBasic;

/**
 *
 * @author Aaron-PC-i3-4130
 */
public interface BizLogic {
    void loadViewModel(ViewModel vm);
    
    void onEquipmentNodeSelect(ViewModel vm, LTEquipBasic equipment);
}
