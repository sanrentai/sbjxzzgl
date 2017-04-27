package cn.tst.sbjxzzglxt.service.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.controller.login.AccountManager;
import cn.tst.sbjxzzglxt.entity.MstSystemConfig;

/**
 * 系统配置
 *
 * @author ps_xy@pscp.co.jp
 */
@Stateless
public class MstSystemConfigFacade {

    @PersistenceContext(unitName = SepC.PERSISTENCE_UNIT)
    private EntityManager em;
    
    @Inject
    private AccountManager am;
    
    /**
     * 将数据插入db
     *
     * @param entity
     * @return
     */
    public MstSystemConfig create(MstSystemConfig entity) {
        EntityManager em = getEntityManager();
        entity.setCreateInfo(am.getLoginInfo().getYuanGong().getYuanGongId());
        em.persist(entity);
        em.flush();
//        em.clear();
        return entity;
    }

    /**
     * 批量插入DB
     *
     * @param list list
     * @return
     */
    public List createList(List<MstSystemConfig> list) {
        EntityManager em = getEntityManager();
        for (MstSystemConfig e : list) {
            e.setCreateInfo(am.getLoginInfo().getYuanGong().getYuanGongId());
            em.persist(e);
//            em.flush();
//            em.refresh(e);
        }
//        em.flush();
//        em.clear();
        return list;
    }

    /**
     * 修改
     *
     * @param entity
     */
    public MstSystemConfig edit(MstSystemConfig entity) {
        EntityManager em = getEntityManager();
        entity.setUpdateInfo(am.getLoginInfo().getYuanGong().getYuanGongId());
        entity = em.merge(entity);
//        em.flush();
//        em.clear();
//        em.flush();
//        em.refresh(entity);
        return entity;
    }

    /**
     * 更新数据后返回更新的对象
     *
     * @param entity
     * @return
     */
    public MstSystemConfig merge(MstSystemConfig entity) {
        EntityManager em = getEntityManager();
        entity.setUpdateInfo(am.getLoginInfo().getYuanGong().getYuanGongId());
        entity = em.merge(entity);
//        em.flush();
//        em.clear();
//        em.refresh(entity);
//        em.flush();
        return entity;
    }

    /**
     * 批量修改
     *
     * @param list
     * @return
     */
    public List editList(List<MstSystemConfig> list) {
        EntityManager em = getEntityManager();
        for (MstSystemConfig e : list) {
            merge(e);
        }
        return list;
    }

    /**
     * 从db中删除记录（理论删除）
     *
     * @param entity
     */
    public void remove(MstSystemConfig entity) {
        EntityManager em = getEntityManager();
        if (entity.getDelFlg().equals(SepE.Flag.NO)) {
            /// 删除flag为false时，将删除flag置为true
            entity.setDelFlg(SepE.Flag.YES);
            edit(entity);
//        } else {
//            /// 删除flag为true时，将这条记录删除
//            em.remove(em.merge(entity));
        }
//        em.flush();
//        em.clear();
    }

    /**
     * 批量从db中删除记录（理论删除）
     *
     * @param entityList
     */
    public void removeList(List<MstSystemConfig> entityList) {
        EntityManager em = getEntityManager();
        for (MstSystemConfig e : entityList) {
            remove(e);
        }
    }

    /**
     * 从db中删除记录（物理删除）
     *
     * @param entity
     */
    public void forceRemove(MstSystemConfig entity) {
        EntityManager em = getEntityManager();
        /// 将这条记录删除
        em.remove(em.merge(entity));
//        em.flush();
//        em.clear();
    }

    /**
     * 批量从db中删除记录（物理删除）
     *
     * @param entityList
     */
    public void forceRemoveList(List<MstSystemConfig> entityList) {
        EntityManager em = getEntityManager();
        for (MstSystemConfig e : entityList) {
            forceRemove(e);
        }
    }
    
    /**
     * 刷新记录
     * @param e
     * @return 
     */
    public MstSystemConfig refresh(MstSystemConfig e) {
        EntityManager em = getEntityManager();
        em.refresh(e);
        return e;
    }

    public MstSystemConfig find(Object id) {
        return em.find(MstSystemConfig.class, id);
    }
    
    public List<MstSystemConfig> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery q = cb.createQuery(MstSystemConfig.class);
        Root c = q.from(MstSystemConfig.class);
        q.select(c);
        q.where(cb.equal(c.get("delFlg"), SepE.Flag.NO.getValue()));
//        q.orderBy(cb.desc(c.get(BaseEntity_.updDate)));
        Query query = em.createQuery(q);
        return query.getResultList();
    }
    
    private EntityManager getEntityManager() {
        return em;
    }
}
