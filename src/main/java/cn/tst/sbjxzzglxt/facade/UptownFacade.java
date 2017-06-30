/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.facade;

import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.Uptown;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@Stateless
public class UptownFacade extends AbstractFacade<Uptown> {
    public UptownFacade() {
        super(Uptown.class);
    }
    @Override
    public List<Uptown> findAll() {
        Query query = getEntityManager().createNamedQuery("Uptown.findAll");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        return query.getResultList();
    }
}
