/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.SheBeiGuanLi.WenDangJiTuPianGuanLi;

import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipGraphic;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Aaron-PC-i3-4130
 */
public interface BizLogic {
    void loadViewModel(ViewModel vm);
    
    void onEditNewDocument(ViewModel vm);
    
    void onEditNewDocumentSubmit(ViewModel vm);
    
    void onEquipmentNodeSelect(ViewModel vm, LTEquipBasic equipment);
    
    void onFileSelectToUpload(ViewModel vm, FileUploadEvent event);
    
    void onEditDocumentToUpdate(ViewModel vm, LTEquipGraphic document);
    
    void onEditDocumentToUpdateSubmit(ViewModel vm);
}
