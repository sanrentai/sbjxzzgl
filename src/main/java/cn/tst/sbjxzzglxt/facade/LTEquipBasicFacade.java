package cn.tst.sbjxzzglxt.facade;

import cn.tst.sbjxzzglxt.common.SepE;
import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import java.util.List;
import javax.persistence.Query;

/**
 * 设备实现类
 *
 * @author 曹春
 */
@Stateless
public class LTEquipBasicFacade extends AbstractFacade<LTEquipBasic> {

    public LTEquipBasicFacade() {
        super(LTEquipBasic.class);
    }

    public List<LTEquipBasic> findByCId(Long cId) {
        Query query = getEntityManager().createNamedQuery("LTEquipBasic.findByCId");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("cId", cId);
        return query.getResultList();
    }
}
