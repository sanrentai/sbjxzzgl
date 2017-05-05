/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.bizlogic.impl;

import cn.tst.sbjxzzglxt.bizlogic.EQP0004BizLogic;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipNotes;
import javax.ejb.*;
import cn.tst.sbjxzzglxt.service.impl.LTEquipBasicFacade;
import cn.tst.sbjxzzglxt.service.impl.LTEquipNotesFacade;
import cn.tst.sbjxzzglxt.viewmodel.EQP0004ViewModel;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@Stateless
public class EQP0004BizLogicImpl extends BaseBizLogic implements EQP0004BizLogic {

    private static final Logger LOG = Logger.getLogger(EQP0001BizLogicImpl.class.getName());
    @EJB
    private LTEquipBasicFacade equipmentDao;
    @EJB
    private LTEquipNotesFacade equipmentNotesDao;

    @Override
    public void loadEQP0004ViewModel(EQP0004ViewModel vm) {
        List<LTEquipBasic> equipmentList = equipmentDao.findAll();
        vm.setEquipmentList(equipmentList);
        vm.setEquipNoteList(equipmentNotesDao.findAll());
    }

    @Override
    public void onSaveData(EQP0004ViewModel vm) {
        LTEquipNotes equipNotesInEditing = vm.getEquipNotesInEditing();
        equipmentNotesDao.create(equipNotesInEditing);
//        loadEQP0004ViewModel(vm);
        vm.setEquipNoteList(equipmentNotesDao.findAll());
        vm.setEquipNotesInEditing(null);
    }

    @Override
    public void onCancelEdit(EQP0004ViewModel vm) {
        vm.setEquipNotesInEditing(null);
    }
}
