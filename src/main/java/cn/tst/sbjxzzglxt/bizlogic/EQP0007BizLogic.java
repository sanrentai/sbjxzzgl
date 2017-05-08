/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.bizlogic;

import cn.tst.sbjxzzglxt.viewmodel.EQP0007ViewModel;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Aaron-PC-i3-4130
 */
public interface EQP0007BizLogic {
    void loadViewModel(EQP0007ViewModel vm);
    
    void onFileUploaded(FileUploadEvent event, String fileUploadPath, EQP0007ViewModel vm);
    
    void onSaveData(EQP0007ViewModel vm);
}
