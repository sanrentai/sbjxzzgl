package cn.tst.sbjxzzglxt.facade;

import cn.tst.sbjxzzglxt.common.SepE;
import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipError;
import cn.tst.sbjxzzglxt.entity.LTEquipWarn;
import java.util.List;
import javax.persistence.Id;
import javax.persistence.Query;

/**
 * 设备实现类
 *
 * @author 曹春
 */
@Stateless
public class LTEquipErrorFacade extends AbstractFacade<LTEquipError> {

    public LTEquipErrorFacade() {
        super(LTEquipError.class);
    }

    //这个其实是DAO层，用于处理查询数据记录，返回给EQP0006BizLogicImpl(这个其实就是Service层，用于处理业务逻辑的)
    public List<LTEquipError> findById(Long id) {
        Query query = getEntityManager().createNamedQuery("LTEquipError.findById");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("id", id);
        return query.getResultList();
    }

    public List<LTEquipError> chaGuZhangLieBiao(Long eNum) {
       Query query = getEntityManager().createQuery("SELECT l FROM LTEquipError l  WHERE l.eNum = :eNum AND l.delFlg = :delFlg");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("eNum", eNum);
        return query.getResultList();
    }

}
