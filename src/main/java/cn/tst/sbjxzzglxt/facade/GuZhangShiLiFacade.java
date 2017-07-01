package cn.tst.sbjxzzglxt.facade;

import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.GuZhangShiLi;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.entity.LTEquipWarn;
import java.util.List;
import javax.persistence.Query;

/**
 * 设备实现类
 *
 * @author 曹春
 */
@Stateless
public class GuZhangShiLiFacade extends AbstractFacade<GuZhangShiLi> {

    public GuZhangShiLiFacade() {
        super(GuZhangShiLi.class);
    }

    public List<GuZhangShiLi> chaGuZhang(Long xiangMuId) {
        Query query = getEntityManager().createQuery("SELECT g FROM GuZhangShiLi g WHERE g.xiangMuId = :xiangMuId AND g.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("xiangMuId", xiangMuId);
        return query.getResultList();
    }

}
