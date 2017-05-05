package cn.tst.sbjxzzglxt.service.impl;

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
   public List<LTEquipBasic> findByCId(Long cId) {
        Query query = getEntityManager().createNamedQuery("LTEquipBasic.findByCId");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("cId", cId);
        return query.getResultList();
    }

}
