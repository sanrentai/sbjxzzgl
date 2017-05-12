/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.facade;

import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.LTEquipGraphic;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@Stateless
public class LTEquipGraphicFacade extends AbstractFacade<LTEquipGraphic> {
    public LTEquipGraphicFacade() {
        super(LTEquipGraphic.class);
    }
    
    public List<LTEquipGraphic> findByOriginalName(String originalName) {
        Query query = getEntityManager().createNamedQuery("LTEquipGraphic.findByOriginalName");
        query.setParameter("fOriginalName", originalName);
        return query.getResultList();
    }
}
