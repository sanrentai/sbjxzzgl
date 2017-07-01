package cn.tst.sbjxzzglxt.facade;

import cn.tst.sbjxzzglxt.common.SepE;
import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipCheckPoint;
import cn.tst.sbjxzzglxt.entity.LTEquipError;
import cn.tst.sbjxzzglxt.entity.LTEquipWarn;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionItems;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * 设备实现类
 *
 * @author 曹春
 */
@Stateless
public class XunJianXiangMuFacade extends AbstractFacade<SysRoutingInspectionItems> {

    public XunJianXiangMuFacade() {
        super(SysRoutingInspectionItems.class);
    }

    //这个其实是DAO层，用于处理查询数据记录，返回给EQP0006BizLogicImpl(这个其实就是Service层，用于处理业务逻辑的)
    public List<SysRoutingInspectionItems> findById(Long id) {
        Query query = getEntityManager().createNamedQuery("SysRoutingInspectionItems.findById");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("ID", id);
        return query.getResultList();
    }

    public List<SysRoutingInspectionItems> findByCheckPointId(Integer suoShuXunJianDianId) {
        Query query = getEntityManager().createQuery("SELECT s FROM SysRoutingInspectionItems s WHERE s.suoShuXunJianDianId = :suoShuXunJianDianId AND s.delFlg=:delFlg ORDER BY s.xunJianShunXu ASC");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("suoShuXunJianDianId", suoShuXunJianDianId);
        
        return query.getResultList();
    }

    public void chaXiangMu(Long id) {

    }

    public void xiuGaiXiangMu(Integer xunJianShunXu) {
        EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("SysRoutingInspectionItems");
        EntityManager entity = entityFactory.createEntityManager();
        entity.getTransaction().begin();
        Query query = entity.createQuery("update SysRoutingInspectionItems l set l.xunJianShunXu = xunJianShunXu+1 where l.xunJianShunXu >= :xunJianShunXu");
        query.setParameter("xunJianShunXu", xunJianShunXu);
        query.executeUpdate();
        entity.getTransaction().commit();
        entity.close();
        entityFactory.close();

    }

}
