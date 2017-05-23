/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.facade;

import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.XunJianDianQuanXian;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@Stateless
public class XunJianDianQuanXianFacade extends AbstractFacade<XunJianDianQuanXian> {
    public XunJianDianQuanXianFacade() {
        super(XunJianDianQuanXian.class);
    }
    
    public List<XunJianDianQuanXian> findByRoleId(Integer roleId) {
        Query query = getEntityManager().createNamedQuery("XunJianDianQuanXian.findByRoleId");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("roleId", roleId);
        return query.getResultList();
    }
    
    public void removeByRoleId(Integer roleId) {
        this.removeList(this.findByRoleId(roleId));
    }
}
