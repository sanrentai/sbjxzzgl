/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.bizlogic;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.viewmodel.EQP0004ViewModel;
/**
 *
 * @author Aaron-PC-i3-4130
 */
public interface EQP0004BizLogic {
    void loadEQP0004ViewModel(EQP0004ViewModel vm);
    
    void onSaveData(EQP0004ViewModel vm);
    
    void onCancelEdit(EQP0004ViewModel vm);
    
}
