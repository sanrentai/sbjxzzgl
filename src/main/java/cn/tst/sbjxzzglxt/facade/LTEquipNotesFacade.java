/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.facade;

import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipNotes;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@Stateless
public class LTEquipNotesFacade extends AbstractFacade<LTEquipNotes> {

    public LTEquipNotesFacade() {
        super(LTEquipNotes.class);
    }
 
    //根据设备ID进行查询
    public List<LTEquipNotes> findByEquipId(Long equipId) {
        Query query = getEntityManager().createNamedQuery("LTEquipNotes.findByENum");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("eNum", equipId);
         System.out.println(6);
        return query.getResultList();
        
    }

    //根据设备ID和维修保养查询
    public List<LTEquipNotes> sheBeiHeWeiXiu(Long equipId, Integer weiXiuBaoYang) {
        Query query = getEntityManager().createNamedQuery("SELECT l FROM LTEquipNotes l WHERE l.eNum = :equipId AND l.tType = :weiXiuBaoYang AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("eNum", equipId);
        query.setParameter("tType", weiXiuBaoYang);
         System.out.println(7);
        return query.getResultList();
    }

    //根据设备和负责人查询
    public List<LTEquipNotes> sheBeiHefuZeRen(Long equipId, String fuZeRen) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.eNum = :equipId AND l.fuZeRen= :fuZeRen AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("eNum", equipId);
        query.setParameter("fuZeRen", fuZeRen);
         System.out.println(8);
        return query.getResultList();
    }
    //根据设备和时间查询

    public List<LTEquipNotes> sheBeiHeShiJian(Long equipId, Date chaXunShiJian) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.eNum = :equipId AND l.chaXunShiJian =:chaXunShiJian AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("eNum", equipId);
        query.setParameter("chaXunShiJian", chaXunShiJian);
         System.out.println(9);
        return query.getResultList();
    }

    //查询设备，维修记录，负责人
    public List<LTEquipNotes> sheBeiWeiXiufuZeRen(Long equipId, Integer weiXiuBaoYang, String fuZeRen) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.eNum = :equipId AND l.tType = :weiXiuBaoYang AND l.fuZeRen= :fuZeRen AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("eNum", equipId);
        query.setParameter("tType", weiXiuBaoYang);
        query.setParameter("fuZeRen", fuZeRen);
         System.out.println(10);
        return query.getResultList();
    }

    //查询设备，维修记录，负责人，时间
    public List<LTEquipNotes> sheBeiHeWeiXiufuZeRenShiJian(Long equipId, Integer weiXiuBaoYang, String fuZeRen, Date chaXunShiJian) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.eNum = :equipId AND l.tType = :weiXiuBaoYang AND l.fuZeRen = :fuZeRen AND l.chaXunShiJian=;chaXunShiJian AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("eNum", equipId);
        query.setParameter("tType", weiXiuBaoYang);
        query.setParameter("fuZeRen", fuZeRen);
        query.setParameter("chaXunShiJian", chaXunShiJian);
         System.out.println(11);
        return query.getResultList();
    }

    //查询维修记录
    public List<LTEquipNotes> findByTType(Integer weiXiuBaoYang) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.tType = :weiXiuBaoYang AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("tType", weiXiuBaoYang);
        System.out.println(12);
        return query.getResultList();
    }

    //查询维修记录和负责人
    public List<LTEquipNotes> weiXiuHefuZeRen(Integer weiXiuBaoYang, String fuZeRen) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.tType = :weiXiuBaoYang AND l.fuZeRen = :fuZeRen AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("tType", weiXiuBaoYang);
        query.setParameter("fuZeRen", fuZeRen);
         System.out.println(13);
        return query.getResultList();
    }

    //查询维修记录，负责人，时间
    public List<LTEquipNotes> weiXiufuZeRenShiJian(Integer weiXiuBaoYang, String fuZeRen, Date chaXunShiJian) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.tType = :weiXiuBaoYang AND l.fuZeRen = :fuZeRen AND l.chaXunShiJian = :chaXunShiJian AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("tType", weiXiuBaoYang);
        query.setParameter("fuZeRen", fuZeRen);
        query.setParameter("chaXunShiJian", chaXunShiJian);
         System.out.println(14);
        return query.getResultList();
    }

    //查询负责人
    public List<LTEquipNotes> findByfuZeRen(String fuZeRen) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.fuZeRen = :fuZeRen AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("fuZeRen", fuZeRen);
         System.out.println(15);
        return query.getResultList();
    }

    //查询负责人和时间
    public List<LTEquipNotes> fuZeRenShiJian(String fuZeRen, Date chaXunShiJian) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.fuZeRen = :fuZeRen AND l.chaXunShiJian = :chaXunShiJian AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("fuZeRen", fuZeRen);
        query.setParameter("chaXunShiJian", chaXunShiJian);
         System.out.println(16);
        return query.getResultList();
    }

    //查询时间
    public List<LTEquipNotes> chaXunShiJian(Date chaXunShiJian) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.chaXunShiJian = :chaXunShiJian AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("chaXunShiJian", chaXunShiJian);
         System.out.println(17);
        return query.getResultList();
    }

}
