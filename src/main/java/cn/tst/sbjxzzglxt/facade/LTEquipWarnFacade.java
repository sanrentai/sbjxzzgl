package cn.tst.sbjxzzglxt.facade;

import cn.tst.sbjxzzglxt.common.SepE;
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
public class LTEquipWarnFacade extends AbstractFacade<LTEquipWarn> {

    public LTEquipWarnFacade() {
        super(LTEquipWarn.class);
    }
    
    //查询下拉列表所对应的年月日对应的数据数据类型
   public List<LTEquipWarn> findByEId(Long eId) {
        Query query = getEntityManager().createNamedQuery("LTEquipWarn.findByEId");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("eId", eId);
        return query.getResultList();
    }

}
