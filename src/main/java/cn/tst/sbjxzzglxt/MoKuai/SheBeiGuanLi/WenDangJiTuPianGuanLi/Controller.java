/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.SheBeiGuanLi.WenDangJiTuPianGuanLi;

import cn.tst.sbjxzzglxt.common.CConst;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipGraphic;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@ViewScoped
@Named(SepC.ControllerID.WEN_DANG_JI_TU_PIAN_GUAN_LI_CONTROLLER_NAME)
@ManagedBean
public class Controller extends BusinessBaseController {
    public static final String FILE_UPLOAD_PATH
            = getServletContext().getInitParameter(SepC.INIT_PARAM_UPLOAD_DIRECTORY).concat(CConst.SLASH).concat(SepC.EQUIPMENT_DOCUMENTS_DIRECTORY_NAME);

    @PostConstruct
    public void init() {
        vm = new ViewModel();
        bizLogic.loadViewModel(vm);
    }
    @EJB
    private BizLogic bizLogic;

    private ViewModel vm;

    public ViewModel getVm() {
        return vm;
    }

    public void setVm(ViewModel vm) {
        this.vm = vm;
    }

    public BizLogic getBizLogic() {
        return bizLogic;
    }

    public void setBizLogic(BizLogic bizLogic) {
        this.bizLogic = bizLogic;
    }

    public void onEditNewDocument() {
        bizLogic.onEditNewDocument(vm);
        this.switchStatus2Editing();
    }

    public void onEditNewDocumentSubmit() {
        this.bizLogic.onEditNewDocumentSubmit(vm);
        this.switchStatus2Init();
    }

    public void onCancelEdit() {
        this.switchStatus2Init();
    }
    
    public void onEquipmentNodeSelect(LTEquipBasic equipment) {
        bizLogic.onEquipmentNodeSelect(vm, equipment);
    }
    
    public void onFileSelectToUpload(FileUploadEvent event) {
        bizLogic.onFileSelectToUpload(vm, event);
    }
    
    public void onEditDocumentToUpdate(LTEquipGraphic document) {
        bizLogic.onEditDocumentToUpdate(vm, document);
    }
    
    public void onEditDocumentToUpdateSubmit() {
        bizLogic.onEditDocumentToUpdateSubmit(vm);
    }
}
