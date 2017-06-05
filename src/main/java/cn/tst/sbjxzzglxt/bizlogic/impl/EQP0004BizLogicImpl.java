/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.bizlogic.impl;

import cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianDianSheZhi.ViewModel;
import cn.tst.sbjxzzglxt.bizlogic.EQP0004BizLogic;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipNotes;
import javax.ejb.*;
import cn.tst.sbjxzzglxt.facade.LTEquipBasicFacade;
import cn.tst.sbjxzzglxt.facade.LTEquipNotesFacade;
import cn.tst.sbjxzzglxt.viewmodel.EQP0004ViewModel;
import java.util.Calendar;
import java.util.Date;
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
    private LTEquipBasicFacade equipmentFacade;
    @EJB
    private LTEquipBasicFacade equipmentDao;
    @EJB
    private LTEquipNotesFacade equipNotesFacadeDao;
    
   

    @Override
    public void loadEQP0004ViewModel(EQP0004ViewModel vm) {
        List<LTEquipBasic> equipmentList = equipmentDao.findAll();
        vm.setEquipmentList(equipmentList);
        vm.setEquipBasic(new LTEquipBasic());
        vm.getEquipBasic().setNotesList(equipNotesFacadeDao.findAll());
        
    }

    @Override
    public void onSaveData(EQP0004ViewModel vm) {
        LTEquipNotes equipNotesInEditing = vm.getEquipNotesInEditing();
        equipNotesFacadeDao.create(equipNotesInEditing);
//        loadEQP0004ViewModel(vm);
        vm.getEquipBasic().setNotesList(equipNotesFacadeDao.findAll());
        vm.setEquipNotesInEditing(null);
    }

    @Override
    public void onCancelEdit(EQP0004ViewModel vm) {
        vm.setEquipNotesInEditing(null);
    }

    //查询条件判断
    @Override
    public List<LTEquipNotes> chaXunGongNeng(EQP0004ViewModel vm) {
        System.out.println(2);
        //设备ID,维修保养,负责人，时间的值
        Long eNum = vm.getENum();
        Integer tType = vm.getTType();
        String fuZeRen = vm.getFuZeRen();
        Date dangQianBaoYangRiQi = vm.getDangQianBaoYangRiQi();
        Date xiaCiBaoYangRiQi = vm.getXiaCiBaoYangRiQi();
        LOG.info(eNum);
        LOG.info(tType);
        LOG.info(fuZeRen);
        LOG.info(dangQianBaoYangRiQi);
        LOG.info(xiaCiBaoYangRiQi);

        System.out.println(3);
        //一、如果设备ID不为空，取出设备ID
        if (eNum != null && tType == null && fuZeRen == null && dangQianBaoYangRiQi == null && xiaCiBaoYangRiQi == null) {
           vm.getEquipBasic().setNotesList(equipNotesFacadeDao.findByEquipId(eNum));
           
            //查询设备ID和维修保养
        } else if(eNum != null && tType != null && fuZeRen == null && dangQianBaoYangRiQi == null && xiaCiBaoYangRiQi == null) {
            vm.getEquipBasic().setNotesList(equipNotesFacadeDao.sheBeiHeWeiXiu(eNum, tType));
            
            //查询设备ID，负责人
        }else if (eNum != null && tType == null && fuZeRen != null && dangQianBaoYangRiQi == null && xiaCiBaoYangRiQi == null) {
            vm.getEquipBasic().setNotesList(equipNotesFacadeDao.sheBeiHefuZeRen(eNum, fuZeRen));
            
            //查询设备ID,当前保养时间
        }else if (eNum != null && tType == null && fuZeRen == null && dangQianBaoYangRiQi != null && xiaCiBaoYangRiQi == null) {
            vm.getEquipBasic().setNotesList(equipNotesFacadeDao.sheBeiHeKaiShiShiJian(eNum, dangQianBaoYangRiQi));
       
           //查询设备和下次保养时间
        }else if (eNum != null && tType == null && fuZeRen == null && dangQianBaoYangRiQi == null && xiaCiBaoYangRiQi != null) {
            vm.getEquipBasic().setNotesList(equipNotesFacadeDao.sheBeiHeJieShuShiJian(eNum, xiaCiBaoYangRiQi));
        
          //查询设备ID ，当前保养时间，下次保养时间
        }else if (eNum != null && tType == null && fuZeRen == null && dangQianBaoYangRiQi != null && xiaCiBaoYangRiQi != null) {
            vm.getEquipBasic().setNotesList(equipNotesFacadeDao.sheBeiHeKaiShiJieShuShiJian(eNum, dangQianBaoYangRiQi, xiaCiBaoYangRiQi)); 
        
         //查询设备ID，维护记录，负责人
        }else if (eNum != null && tType != null && fuZeRen != null && dangQianBaoYangRiQi == null && xiaCiBaoYangRiQi == null) {
            vm.getEquipBasic().setNotesList(equipNotesFacadeDao.sheBeiWeiXiufuZeRen(eNum, tType, fuZeRen));
      
         //查询设备ID，维修保养，负责人，当前保养时间
        }else if(eNum != null && tType != null && fuZeRen != null && dangQianBaoYangRiQi != null && xiaCiBaoYangRiQi == null) {
            vm.getEquipBasic().setNotesList(equipNotesFacadeDao.sheBeiHeWeiXiufuZeRenKaiShiShiJian(eNum, tType, fuZeRen, dangQianBaoYangRiQi));
        
        //查询设备，维修保养，负责人，当前保养时间，下次保养时间
        }else if (eNum != null && tType != null && fuZeRen != null && dangQianBaoYangRiQi != null && xiaCiBaoYangRiQi != null) {
            vm.getEquipBasic().setNotesList(equipNotesFacadeDao.sheBeiHeWeiXiufuZeRenKaiShiJieShuShiJian(eNum, tType, fuZeRen, dangQianBaoYangRiQi, xiaCiBaoYangRiQi));
       
        
        }else if(eNum == null && tType == null && fuZeRen == null && dangQianBaoYangRiQi == null && xiaCiBaoYangRiQi == null){
            vm.getEquipBasic().setNotesList(null);
        }
        
       

        //二、根据记录类型查询
        if (eNum == null && tType != null && fuZeRen == null && dangQianBaoYangRiQi == null && xiaCiBaoYangRiQi == null) {
            vm.getEquipBasic().setNotesList(equipNotesFacadeDao.findByTType(tType));
        
            //查询维护类型和负责人
        }else if (eNum == null && tType != null && fuZeRen != null && dangQianBaoYangRiQi == null && xiaCiBaoYangRiQi == null) {
            vm.getEquipBasic().setNotesList(equipNotesFacadeDao.weiXiuHefuZeRen(tType, fuZeRen));
       
            //查询维护类型，负责人，当前保养时间
        }else if (eNum == null && tType != null && fuZeRen != null && dangQianBaoYangRiQi != null && xiaCiBaoYangRiQi == null) {
            vm.getEquipBasic().setNotesList(equipNotesFacadeDao.weiXiufuZeRenKaiShiShiJian(tType, fuZeRen, dangQianBaoYangRiQi));
        
         //查询维护保养记录，负责人，下次保养时间
        }else if (eNum == null && tType != null && fuZeRen != null && dangQianBaoYangRiQi == null && xiaCiBaoYangRiQi != null) {
            vm.getEquipBasic().setNotesList(equipNotesFacadeDao.weiXiufuZeRenJieShuShiJian(tType, fuZeRen, xiaCiBaoYangRiQi));
    
            //查询维修保养记录，负责人，当前保养和下次保养时间
        }else if (eNum == null && tType != null && fuZeRen != null && dangQianBaoYangRiQi != null && xiaCiBaoYangRiQi != null) {
            vm.getEquipBasic().setNotesList(equipNotesFacadeDao.weiXiufuZeRenKaiShiJieShuShiJian(tType, fuZeRen, dangQianBaoYangRiQi, xiaCiBaoYangRiQi));
       
        
        }else if(eNum == null && tType == null && fuZeRen == null && dangQianBaoYangRiQi == null && xiaCiBaoYangRiQi == null){
            vm.getEquipBasic().setNotesList(null);
        }
       
        //三、根据负责人查询
        if (eNum == null && tType == null && fuZeRen != null && dangQianBaoYangRiQi == null && xiaCiBaoYangRiQi == null) {
            vm.getEquipBasic().setNotesList(equipNotesFacadeDao.findByfuZeRen(fuZeRen));
       
            //查询负责人和开始时间
        }else if (eNum == null && tType == null && fuZeRen != null && dangQianBaoYangRiQi != null && xiaCiBaoYangRiQi == null) {
            vm.getEquipBasic().setNotesList(equipNotesFacadeDao.fuZeRenKaiShiShiJian(fuZeRen, dangQianBaoYangRiQi));
       
         //负责人和结束时间
        }else if (eNum == null && tType == null && fuZeRen != null && dangQianBaoYangRiQi == null && xiaCiBaoYangRiQi != null) {
            vm.getEquipBasic().setNotesList(equipNotesFacadeDao.fuZeRenJieShuShiJian(fuZeRen, xiaCiBaoYangRiQi));
        
        //负责人，开始和结束时间
        }else if (eNum == null && tType == null && fuZeRen != null && dangQianBaoYangRiQi != null && xiaCiBaoYangRiQi != null) {
            vm.getEquipBasic().setNotesList(equipNotesFacadeDao.fuZeRenKaiShiJieShuShiJian(fuZeRen, dangQianBaoYangRiQi, xiaCiBaoYangRiQi));
       
        }else if(eNum == null && tType == null && fuZeRen == null && dangQianBaoYangRiQi == null && xiaCiBaoYangRiQi == null){
            vm.getEquipBasic().setNotesList(null);
        }
       
        //四、根据工作时间查询
        if (eNum == null && tType == null && fuZeRen == null && dangQianBaoYangRiQi != null && xiaCiBaoYangRiQi == null) {
            vm.getEquipBasic().setNotesList(equipNotesFacadeDao.dangQianBaoYangRiQi(dangQianBaoYangRiQi));
        
        //查询下次保养时间
        }else if (eNum == null && tType == null && fuZeRen == null && dangQianBaoYangRiQi == null && xiaCiBaoYangRiQi != null) {
            vm.getEquipBasic().setNotesList(equipNotesFacadeDao.dangQianBaoYangRiQi(xiaCiBaoYangRiQi));
       
        //查询当前保养时间和下次保养时间
        }else if(eNum == null && tType == null && fuZeRen == null && dangQianBaoYangRiQi != null && xiaCiBaoYangRiQi != null){
            vm.getEquipBasic().setNotesList(equipNotesFacadeDao.dangQianBaoYangRiQiAndEndDate(dangQianBaoYangRiQi, xiaCiBaoYangRiQi));
       
        }else if(eNum == null && tType == null && fuZeRen == null && dangQianBaoYangRiQi == null && xiaCiBaoYangRiQi == null){
            vm.getEquipBasic().setNotesList(null);
        }
        return null;
    }

    @Override
    public void setCurrentEquipment(EQP0004ViewModel vm, Integer currentEquipmentId) {
        vm.setCurrentEquipment(equipmentFacade.find(currentEquipmentId.longValue()));
    }

}
