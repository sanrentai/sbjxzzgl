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
import cn.tst.sbjxzzglxt.facade.LTEquipBasicFacade;
import cn.tst.sbjxzzglxt.facade.LTEquipNotesFacade;
import cn.tst.sbjxzzglxt.viewmodel.EQP0004ViewModel;
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

    //查询条件判断
    @Override
    public List<LTEquipNotes> chaXunGongNeng(EQP0004ViewModel vm) {
         System.out.println(2);
        //设备ID,维修保养,负责人，时间的值
        Long equipId = vm.getEquipNotesInEditing().getENum();
        Integer weiXiuBaoYang = vm.getEquipNotesInEditing().getTType();
        String fuZeRen = vm.getEquipNotesInEditing().getFuZeRen();
        Date chaXunShiJian = vm.getEquipNotesInEditing().getChaXunShiJian();
        LOG.info(equipId.toString());
        LOG.info(weiXiuBaoYang.toString());
        LOG.info(fuZeRen);
        LOG.info(chaXunShiJian.toString());
         System.out.println(3);
        //一、如果设备ID不为空，取出设备ID
        if (equipId != null) {
            //通过DAO查询设备ID
            return equipmentNotesDao.findByEquipId(equipId);

            //查询设备ID和维修保养
        } else if (equipId != null && weiXiuBaoYang != null) {
            return equipmentNotesDao.sheBeiHeWeiXiu(equipId, weiXiuBaoYang);
            //查询设备ID，负责人
        } else if (equipId != null && fuZeRen != null) {
            return equipmentNotesDao.sheBeiHefuZeRen(equipId, fuZeRen);
            //查询设备ID,时间
        } else if (equipId != null && chaXunShiJian != null) {
            return equipmentNotesDao.sheBeiHeShiJian(equipId, chaXunShiJian);
            //查询设备ID，维护记录，负责人
        } else if (equipId != null && weiXiuBaoYang != null && fuZeRen != null) {
            return equipmentNotesDao.sheBeiWeiXiufuZeRen(equipId, weiXiuBaoYang, fuZeRen);
            //查询设备ID，维修保养，负责人，时间
        } else if (equipId != null && weiXiuBaoYang != null && fuZeRen != null && chaXunShiJian != null) {
            return equipmentNotesDao.sheBeiHeWeiXiufuZeRenShiJian(equipId, weiXiuBaoYang, fuZeRen, chaXunShiJian);
        } else {
            //查询全部
             equipmentNotesDao.findAll();
        }
         System.out.println(3);

        //二、根据记录类型查询
        if (weiXiuBaoYang != null) {
            //查询维修保养记录
            return equipmentNotesDao.findByTType(weiXiuBaoYang);
        } else if (weiXiuBaoYang != null && fuZeRen != null) {
            //查询维修保养记录，负责人
            return equipmentNotesDao.weiXiuHefuZeRen(weiXiuBaoYang, fuZeRen);
        } else if (weiXiuBaoYang != null && fuZeRen != null && chaXunShiJian != null) {
            //查询维护保养记录，负责人，时间
            return equipmentNotesDao.weiXiufuZeRenShiJian(weiXiuBaoYang, fuZeRen, chaXunShiJian);
        }
         System.out.println(4);
        //三、根据负责人查询
        if (fuZeRen != null) {
            //查询负责人
            return equipmentNotesDao.findByfuZeRen(fuZeRen);
        } else if (fuZeRen != null && chaXunShiJian != null) {
            //查询负责人和时间
            return equipmentNotesDao.fuZeRenShiJian(fuZeRen, chaXunShiJian);
        }
         System.out.println(5);
        //四、根据工作时间查询
        if (chaXunShiJian != null) {
            //查询时间
            return equipmentNotesDao.chaXunShiJian(chaXunShiJian);
        }
        return null;
    }

}
