package cn.tst.sbjxzzglxt.service.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.MstBuMen;

/**
 *
 * @author 紀
 */
@Stateless
public class MstBuMenFacade extends AbstractFacade<MstBuMen> {

    public MstBuMenFacade() {
        super(MstBuMen.class);
    }

    @Override
    public List<MstBuMen> findAll() {
        Query query = getEntityManager().createNamedQuery("MstBuMen.findAll");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        return query.getResultList();
    }
    
    public List<MstBuMen> findAllByGongSi(String persistenceUnitName) {
        Query query = this.getEntityManager(persistenceUnitName).createNamedQuery("MstBuMen.findAll");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        return query.getResultList();
    }
    
    public List<MstBuMen> findAllYouGuiJiBuMen() {
        Query query = getEntityManager().createNamedQuery("MstBuMen.findAllYouGuiJiYuanGong");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        return query.getResultList();
    }
    
    public List<MstBuMen> findAllWuGuiJiBuMen() {
        List<MstBuMen> allList = this.findAll();
        List<MstBuMen> youGuiJiBuMenList = findAllYouGuiJiBuMen();
        allList.removeAll(youGuiJiBuMenList);
        return allList;
    }

}
