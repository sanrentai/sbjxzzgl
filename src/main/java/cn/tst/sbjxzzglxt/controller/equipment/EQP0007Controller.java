/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.controller.equipment;

import cn.tst.sbjxzzglxt.bizlogic.EQP0007BizLogic;
import cn.tst.sbjxzzglxt.common.CConst;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipGraphic;
import cn.tst.sbjxzzglxt.viewmodel.EQP0007ViewModel;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@ViewScoped
@Named(SepC.ControllerID.EQP0007)
@ManagedBean
public class EQP0007Controller extends BusinessBaseController {
    public static final String FILE_UPLOAD_PATH
            = getServletContext().getInitParameter(SepC.INIT_PARAM_UPLOAD_DIRECTORY).concat(CConst.SLASH).concat(SepC.DEVICE_DOCUMENTS_DIRECTORY_NAME);
    private static final Logger LOG = Logger.getLogger(EQP0007Controller.class.getName());

    @PostConstruct
    public void init() {
        vm = new EQP0007ViewModel();
        bizLogic.loadViewModel(vm);
    }
    @EJB
    private EQP0007BizLogic bizLogic;

    private EQP0007ViewModel vm;

    public EQP0007ViewModel getVm() {
        return vm;
    }

    public void setVm(EQP0007ViewModel vm) {
        this.vm = vm;
    }

    public EQP0007BizLogic getBizLogic() {
        return bizLogic;
    }

    public void setBizLogic(EQP0007BizLogic bizLogic) {
        this.bizLogic = bizLogic;
    }

    public void onFileUploaded(FileUploadEvent event) {
        this.bizLogic.onFileUploaded(event, FILE_UPLOAD_PATH, vm);
    }

    public void onAddTargetData() {
        vm.setEquipGraphicEntityInEdit(new LTEquipGraphic());
        this.switchStatus2Editing();
    }

    public void onSaveData() {
        this.bizLogic.onSaveData(vm);
        this.switchStatus2Init();
    }

    public void onCancelEdit() {
        this.switchStatus2Init();
    }
    
    public void setCurrentEquipment(LTEquipBasic equipment) {
        vm.setCurrentEquipment(equipment);
        LOG.info("setCurrentEquipment");
    }
}
