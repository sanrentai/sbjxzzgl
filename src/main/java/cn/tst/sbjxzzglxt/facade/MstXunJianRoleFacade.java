/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.facade;

import cn.tst.sbjxzzglxt.common.SepE;
import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.entity.MstXunJianRole;
import cn.tst.sbjxzzglxt.entity.XunJianGuiZe;
import java.util.List;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author 曹春
 */
@Stateless
public class MstXunJianRoleFacade extends AbstractFacade<MstXunJianRole> {
    private static final Logger LOG = Logger.getLogger(MstXunJianRole.class.getName());

    public MstXunJianRoleFacade() {
        super(MstXunJianRole.class);
    }
    
    public List<MstXunJianRole> findByRoleId(Integer roleId) {
        Query query = getEntityManager().createNamedQuery("MstXunJianRole.findByRoleId");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("roleId", roleId);
        return query.getResultList();
    }
    
    public void removeByRoleId(Integer roleId) {
        this.removeList(this.findByRoleId(roleId));
    }
}
