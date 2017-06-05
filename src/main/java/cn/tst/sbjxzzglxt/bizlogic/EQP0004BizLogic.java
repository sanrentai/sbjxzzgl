/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.bizlogic;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipNotes;
import cn.tst.sbjxzzglxt.viewmodel.EQP0004ViewModel;
import java.util.List;
/**
 *
 * @author Aaron-PC-i3-4130
 */
public interface EQP0004BizLogic {
    //查询消息
    List<LTEquipNotes> chaXunGongNeng(EQP0004ViewModel vm);
    
    void loadEQP0004ViewModel(EQP0004ViewModel vm);
    
    void onSaveData(EQP0004ViewModel vm);
    
    void onCancelEdit(EQP0004ViewModel vm);
    //选择设备
    public void setCurrentEquipment(EQP0004ViewModel vm, Integer currentEquipmentId);

    
}
