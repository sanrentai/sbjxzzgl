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
    public List<LTEquipNotes> findByEquipId(Long eNum) {
        Query query = getEntityManager().createNamedQuery("LTEquipNotes.findByENum");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("eNum", eNum);
        System.out.println(6);
        return query.getResultList();

    }

    //根据设备ID和维修保养查询
    public List<LTEquipNotes> sheBeiHeWeiXiu(Long eNum, Integer tType) {
       Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.eNum = :eNum AND l.tType = :tType AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("eNum", eNum);
        query.setParameter("tType", tType);
        System.out.println(7);
        return query.getResultList();
    }

    //根据设备和负责人查询
    public List<LTEquipNotes> sheBeiHefuZeRen(Long eNum, String fuZeRen) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.eNum = :eNum AND l.fuZeRen = :fuZeRen AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("eNum", eNum);
        query.setParameter("fuZeRen", fuZeRen);
        System.out.println(8);
        return query.getResultList();
    }
    //查询设备和开始时间

    public List<LTEquipNotes> sheBeiHeKaiShiShiJian(Long eNum, Date dangQianBaoYangRiQi) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.eNum = :eNum AND l.dangQianBaoYangRiQi = :dangQianBaoYangRiQi AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("eNum", eNum);
        query.setParameter("dangQianBaoYangRiQi", dangQianBaoYangRiQi);
        System.out.println(9);
        return query.getResultList();
    }

    //查询设备，开始，结束时间
    public List<LTEquipNotes> sheBeiHeKaiShiJieShuShiJian(Long eNum, Date dangQianBaoYangRiQi, Date xiaCiBaoYangRiQi) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.eNum = :eNum AND l.dangQianBaoYangRiQi =:dangQianBaoYangRiQi AND l.xiaCiBaoYangRiQi = :xiaCiBaoYangRiQi  AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("eNum", eNum);
        query.setParameter("dangQianBaoYangRiQi", dangQianBaoYangRiQi);
        query.setParameter("xiaCiBaoYangRiQi", xiaCiBaoYangRiQi);
        return query.getResultList();
    }

    //查询设备，结束时间
    public List<LTEquipNotes> sheBeiHeJieShuShiJian(Long eNum, Date xiaCiBaoYangRiQi) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.eNum = :eNum AND l.xiaCiBaoYangRiQi = :xiaCiBaoYangRiQi  AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("eNum", eNum);
        query.setParameter("xiaCiBaoYangRiQi", xiaCiBaoYangRiQi);
        return query.getResultList();
    }

    //查询设备，维修记录，负责人
    public List<LTEquipNotes> sheBeiWeiXiufuZeRen(Long eNum, Integer tType, String fuZeRen) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.eNum = :eNum AND l.tType = :tType AND l.fuZeRen= :fuZeRen AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("eNum", eNum);
        query.setParameter("tType", tType);
        query.setParameter("fuZeRen", fuZeRen);
        System.out.println(10);
        return query.getResultList();
    }

    //查询设备，维修记录，负责人，开始时间
    public List<LTEquipNotes> sheBeiHeWeiXiufuZeRenKaiShiShiJian(Long eNum, Integer tType, String fuZeRen, Date dangQianBaoYangRiQi) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.eNum = :eNum AND l.tType = :tType AND l.fuZeRen = :fuZeRen AND l.dangQianBaoYangRiQi=;dangQianBaoYangRiQi AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("eNum", eNum);
        query.setParameter("tType", tType);
        query.setParameter("fuZeRen", fuZeRen);
        query.setParameter("dangQianBaoYangRiQi", dangQianBaoYangRiQi);
        System.out.println(11);
        return query.getResultList();
    }

    //查询设备，维修记录，负责人，开始和结束时间
    public List<LTEquipNotes> sheBeiHeWeiXiufuZeRenKaiShiJieShuShiJian(Long eNum, Integer tType, String fuZeRen, Date dangQianBaoYangRiQi, Date xiaCiBaoYangRiQi) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.eNum = :eNum AND l.tType = :tType AND l.fuZeRen = :fuZeRen AND l.dangQianBaoYangRiQi=;dangQianBaoYangRiQi AND l.xiaCiBaoYangRiQi = :xiaCiBaoYangRiQi AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("eNum", eNum);
        query.setParameter("tType", tType);
        query.setParameter("fuZeRen", fuZeRen);
        query.setParameter("dangQianBaoYangRiQi", dangQianBaoYangRiQi);
        query.setParameter("xiaCiBaoYangRiQi", xiaCiBaoYangRiQi);
        System.out.println(11);
        return query.getResultList();
    }

    //查询维修记录
    public List<LTEquipNotes> findByTType(Integer tType) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.tType = :tType AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("tType", tType);
        System.out.println(12);
        return query.getResultList();
    }

    //查询维修记录和负责人
    public List<LTEquipNotes> weiXiuHefuZeRen(Integer tType, String fuZeRen) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.tType = :tType AND l.fuZeRen = :fuZeRen AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("tType", tType);
        query.setParameter("fuZeRen", fuZeRen);
        System.out.println(13);
        return query.getResultList();
    }

    //查询维修记录，负责人，开始时间
    public List<LTEquipNotes> weiXiufuZeRenKaiShiShiJian(Integer tType, String fuZeRen, Date dangQianBaoYangRiQi) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.tType = :tType AND l.fuZeRen = :fuZeRen AND l.dangQianBaoYangRiQi = :dangQianBaoYangRiQi AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("tType", tType);
        query.setParameter("fuZeRen", fuZeRen);
        query.setParameter("dangQianBaoYangRiQi", dangQianBaoYangRiQi);
        System.out.println(14);
        return query.getResultList();

    }

    //查询维修记录，负责人，结束时间
    public List<LTEquipNotes> weiXiufuZeRenJieShuShiJian(Integer tType, String fuZeRen, Date xiaCiBaoYangRiQi) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.tType = :tType AND l.fuZeRen = :fuZeRen AND l.xiaCiBaoYangRiQ = :xiaCiBaoYangRiQi AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("tType", tType);
        query.setParameter("fuZeRen", fuZeRen);
        query.setParameter("xiaCiBaoYangRiQ", xiaCiBaoYangRiQi);
        System.out.println(14);
        return query.getResultList();
    }

    //查询维修记录，负责人，开始结束日期
    public List<LTEquipNotes> weiXiufuZeRenKaiShiJieShuShiJian(Integer tType, String fuZeRen, Date dangQianBaoYangRiQi, Date xiaCiBaoYangRiQi) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.tType = :tType AND l.fuZeRen = :fuZeRen AND l.dangQianBaoYangRiQi = :dangQianBaoYangRiQi AND l.xiaCiBaoYangRiQi = :xiaCiBaoYangRiQi AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("tType", tType);
        query.setParameter("fuZeRen", fuZeRen);
        query.setParameter("dangQianBaoYangRiQi", dangQianBaoYangRiQi);
        query.setParameter("xiaCiBaoYangRiQi", xiaCiBaoYangRiQi);
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

    //查询负责人和开始时间
    public List<LTEquipNotes> fuZeRenKaiShiShiJian(String fuZeRen, Date dangQianBaoYangRiQi) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.fuZeRen = :fuZeRen AND l.dangQianBaoYangRiQi = :dangQianBaoYangRiQi AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("fuZeRen", fuZeRen);
        query.setParameter("dangQianBaoYangRiQi", dangQianBaoYangRiQi);
        System.out.println(16);
        return query.getResultList();
    }

    //查询负责人和结束时间
    public List<LTEquipNotes> fuZeRenJieShuShiJian(String fuZeRen, Date xiaCiBaoYangRiQi) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.fuZeRen = :fuZeRen AND l.xiaCiBaoYangRiQi = :xiaCiBaoYangRiQi AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("fuZeRen", fuZeRen);
        query.setParameter("xiaCiBaoYangRiQi", xiaCiBaoYangRiQi);
        System.out.println(16);
        return query.getResultList();
    }
    //查询负责人，开始结束时间

    public List<LTEquipNotes> fuZeRenKaiShiJieShuShiJian(String fuZeRen, Date dangQianBaoYangRiQi, Date xiaCiBaoYangRiQi) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.fuZeRen = :fuZeRen AND l.dangQianBaoYangRiQi = :dangQianBaoYangRiQi AND l.xiaCiBaoYangRiQi = :xiaCiBaoYangRiQi AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("fuZeRen", fuZeRen);
        query.setParameter("dangQianBaoYangRiQi", dangQianBaoYangRiQi);
        query.setParameter("xiaCiBaoYangRiQi", xiaCiBaoYangRiQi);
        System.out.println(16);
        return query.getResultList();
    }

    //查询开始时间
    public List<LTEquipNotes> dangQianBaoYangRiQi(Date dangQianBaoYangRiQi) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.dangQianBaoYangRiQi = :dangQianBaoYangRiQi AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("dangQianBaoYangRiQi", dangQianBaoYangRiQi);
        System.out.println(17);
        return query.getResultList();
    }
    //查询结束时间

    public List<LTEquipNotes> xiaCiBaoYangRiQi(Date xiaCiBaoYangRiQi) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.xiaCiBaoYangRiQi = :xiaCiBaoYangRiQi AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("xiaCiBaoYangRiQi", xiaCiBaoYangRiQi);
        System.out.println(17);
        return query.getResultList();
    }

    //查询开始和结束时间
    public List<LTEquipNotes> dangQianBaoYangRiQiAndEndDate(Date dangQianBaoYangRiQi, Date xiaCiBaoYangRiQi) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipNotes l WHERE l.dangQianBaoYangRiQi = :dangQianBaoYangRiQi AND l.xiaCiBaoYangRiQi = :xiaCiBaoYangRiQi AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("dangQianBaoYangRiQi", dangQianBaoYangRiQi);
        query.setParameter("xiaCiBaoYangRiQi", xiaCiBaoYangRiQi);
        System.out.println(17);
        return query.getResultList();
    }

    public void chaXunWeiXiuBaoYang(SepE.WeiXiuBaoYang tType) {
     
    }

}
