package cn.tst.sbjxzzglxt.facade;

import cn.tst.sbjxzzglxt.common.SepE;
import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipError;
import cn.tst.sbjxzzglxt.entity.LTEquipWarn;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionProblem;
import java.util.List;
import javax.persistence.Id;
import javax.persistence.Query;

/**
 * 设备实现类
 *
 * @author 曹春
 */
@Stateless
public class XunJianXiangMuWenTiFacade extends AbstractFacade<SysRoutingInspectionProblem> {

    public XunJianXiangMuWenTiFacade() {
        super(SysRoutingInspectionProblem.class);
    }

    //这个其实是DAO层，用于处理查询数据记录，返回给EQP0006BizLogicImpl(这个其实就是Service层，用于处理业务逻辑的)
    public List<SysRoutingInspectionProblem> findById(Long id) {
        Query query = getEntityManager().createNamedQuery("SysRoutingInspectionProblem.findBySuoShuSheBeiId");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("id", id);
        return query.getResultList();
    }

}
