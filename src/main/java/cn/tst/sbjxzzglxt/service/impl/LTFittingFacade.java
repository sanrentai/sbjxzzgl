/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.service.impl;

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
    
    public List<LTEquipFitting> findByENum(String ENum) {
        Query query = getEntityManager().createNamedQuery("LTEquipFitting.findByENum");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("eNum", ENum);
        return query.getResultList();
    }
}
