/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.facade;

import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.XunJianGuiZe;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@Stateless
public class XunJianGuiZeFacade extends AbstractFacade<XunJianGuiZe> {
    public XunJianGuiZeFacade() {
        super(XunJianGuiZe.class);
    }
    
    public List<XunJianGuiZe> findByRoleId(Integer roleId) {
        Query query = getEntityManager().createNamedQuery("XunJianGuiZe.findByRoleId");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("roleId", roleId);
        return query.getResultList();
    }
}
