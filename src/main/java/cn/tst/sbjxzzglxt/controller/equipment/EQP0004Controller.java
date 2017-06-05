/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.controller.equipment;

import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.sbjxzzglxt.viewmodel.EQP0004ViewModel;
import cn.tst.sbjxzzglxt.bizlogic.EQP0004BizLogic;
import cn.tst.sbjxzzglxt.bizlogic.impl.EQP0001BizLogicImpl;
import cn.tst.sbjxzzglxt.bizlogic.impl.EQP0004BizLogicImpl;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipNotes;
import static java.time.Clock.system;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ws.rs.core.Request;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@ViewScoped
@Named(SepC.ControllerID.EQP0004)
public class EQP0004Controller extends BusinessBaseController {

    private static final Logger LOG = Logger.getLogger(EQP0004BizLogicImpl.class.getName());
    private EQP0004ViewModel vm;
    @EJB
    private EQP0004BizLogic bizLogic;

    @PostConstruct
    public void init() {
        vm = new EQP0004ViewModel();
        bizLogic.loadEQP0004ViewModel(vm);
        vm.setEquipNotesInEditing(new LTEquipNotes());
//        vm.setEquipBasic(new LTEquipBasic());
//        vm.getEquipBasic().setNotesList(vm.getEquipBasic().getNotesList());
    }

    //查询功能
    public void chaXunGongNeng() {
        vm.setENum(vm.getENum());
        vm.setTType(vm.getTType());
        vm.setFuZeRen(vm.getFuZeRen());
        vm.setDangQianBaoYangRiQi(vm.getDangQianBaoYangRiQi());
        vm.setXiaCiBaoYangRiQi(vm.getXiaCiBaoYangRiQi());
        bizLogic.chaXunGongNeng(vm);
        vm.setENum(null);
        vm.setTType(null);
        vm.setFuZeRen(null);
        vm.setDangQianBaoYangRiQi(null);
        vm.setXiaCiBaoYangRiQi(null);
        vm.setEquipNotesInEditing(null);
    }

    private Integer currentEquipmentId;

    public Integer getCurrentEquipmentId() {
        return currentEquipmentId;
    }

    public void setCurrentEquipmentId(Integer currentEquipmentId) {
        this.currentEquipmentId = currentEquipmentId;
        LOG.info(currentEquipmentId);
        vm.setENum(currentEquipmentId.longValue());
        bizLogic.setCurrentEquipment(vm, currentEquipmentId);
    }

    public EQP0004ViewModel getVm() {
        return vm;
    }

    public void setVm(EQP0004ViewModel vm) {
        this.vm = vm;
    }

    public void onAddTargetData() {
        vm.setEquipNotesInEditing(new LTEquipNotes());
    }

    public EQP0004BizLogic getBizLogic() {
        return bizLogic;
    }

    public void setBizLogic(EQP0004BizLogic bizLogic) {
        this.bizLogic = bizLogic;
    }

    public void onSaveData() {
        bizLogic.onSaveData(vm);
    }
}
