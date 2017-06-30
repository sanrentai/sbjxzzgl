/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.facade;

import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.LTEquipCheckPoint;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@Stateless
public class LTEquipCheckPointFacade extends AbstractFacade<LTEquipCheckPoint> {
    public LTEquipCheckPointFacade() {
        super(LTEquipCheckPoint.class);
    }
    
    public List<LTEquipCheckPoint> findByEquipmentId(Long equipmentId) {
        Query query = getEntityManager().createNamedQuery("LTEquipCheckPoint.findByEquipmentId");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("equipmentId", equipmentId);
        return query.getResultList();
    }
    
    public List<LTEquipCheckPoint> findById(Integer id) {
        Query query = getEntityManager().createNamedQuery("LTEquipCheckPoint.findById");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("id", id);
        return query.getResultList();
    }

     public List<LTEquipCheckPoint> chaXunJianDianLieBiao(Long equipmentId) {
        Query query = getEntityManager().createQuery("SELECT l FROM LTEquipCheckPoint l WHERE l.equipmentId = :equipmentId AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("equipmentId", equipmentId);
        return query.getResultList();
    }
}
