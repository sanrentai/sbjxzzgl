/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.facade;

import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.LTEquipFitting;
import javax.ejb.Stateless;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@Stateless
public class LTFittingFacade extends AbstractFacade<LTEquipFitting> {
    public LTFittingFacade() {
        super(LTEquipFitting.class);
    }
    
    public List<LTEquipFitting> findById(Long id) {
        Query query = getEntityManager().createNamedQuery("LTEquipFitting.findById");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("id", id);
        return query.getResultList();
    }
}
