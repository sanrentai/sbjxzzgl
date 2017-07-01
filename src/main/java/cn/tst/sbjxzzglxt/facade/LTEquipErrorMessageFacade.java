package cn.tst.sbjxzzglxt.facade;

import cn.tst.sbjxzzglxt.common.SepE;
import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipError;
import cn.tst.sbjxzzglxt.entity.LTEquipErrorMessage;
import cn.tst.sbjxzzglxt.entity.LTEquipWarn;
import java.util.List;
import javax.persistence.Id;
import javax.persistence.Query;

/**
 * 故障内容表
 *
 * @author 曹春
 */
@Stateless
public class LTEquipErrorMessageFacade extends AbstractFacade<LTEquipErrorMessage> {

    public LTEquipErrorMessageFacade() {
        super(LTEquipErrorMessage.class);
    }

    //这个其实是DAO层，用于处理查询数据记录，返回给EQP0006BizLogicImpl(这个其实就是Service层，用于处理业务逻辑的)
    public List<LTEquipErrorMessage> findByCId(Long id) {
        Query query = getEntityManager().createNamedQuery("LTEquipErrorMessage.findById");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("id", id);
        return query.getResultList();
    }


}
