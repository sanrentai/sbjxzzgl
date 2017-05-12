package cn.tst.sbjxzzglxt.facade;

import java.util.List;
import javax.inject.Inject;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import cn.tst.sbjxzzglxt.common.CConst;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.controller.login.AccountManager;
import cn.tst.sbjxzzglxt.entity.BaseEntity;
import cn.tst.sbjxzzglxt.entity.MstSystemConfig;
import org.apache.commons.lang3.StringUtils;

/**
 * 持久化访问抽象类
 *
 * @author ps_xy@pscp.co.jp
 * @param <T>
 */
//@Interceptors(AbstractFacadeInterceptor.class)
public abstract class AbstractFacade<T extends BaseEntity> {

    @Inject
    private AccountManager am;

    private final Class<T> entityClass;

    @ExcludeClassInterceptors
    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @PersistenceContext(unitName = SepC.PERSISTENCE_UNIT)
    private EntityManager em1;
    
//    @PersistenceContext(unitName = SepC.PERSISTENCE_UNIT2)
    private EntityManager em2;
    
//    private String persistenceUnitName = null;

//    @ExcludeClassInterceptors
//    public EntityManager getEntityManager() {
//        String persistenceUnitName;
//        if (am == null || am.getSystemConfig() == null) {
//            persistenceUnitName = SepC.PERSISTENCE_UNIT;
//        } else {
//            persistenceUnitName = am.getSystemConfig().getDbName();
//        }
//        if (em != null && persistenceUnitName.equals(this.persistenceUnitName)) {
//            em.joinTransaction();
//            return em;
//        }
//        this.persistenceUnitName = persistenceUnitName;
//        closeEntityManager();
//        em = EntityManagerFactoryUtils.getInstance().getEntityManager(persistenceUnitName);
//        return em;
//    }
//    
//    @ExcludeClassInterceptors
//    public EntityManager getEntityManager(String persistenceUnitName) {
//        if (em != null && persistenceUnitName.equals(this.persistenceUnitName)) {
//            em.joinTransaction();
//            return em;
//        }
//        this.persistenceUnitName = persistenceUnitName;
//        closeEntityManager();
//        em = EntityManagerFactoryUtils.getInstance().getEntityManager(persistenceUnitName);
//        return em;
//    }
    
//    public EntityManager getEntityManager() {
//        em = am.getEntityManager();
//        return em;
//    }
//    
//    public EntityManager getEntityManager(String persistenceUnitName) {
//        em = am.getEntityManager(persistenceUnitName);
//        return em;
//    }
    
//    @ExcludeClassInterceptors
//    private void createEntityManager() {
//        if (em == null) {
//            em = getEntityManager();
//        }
//    }
    
//    @ExcludeClassInterceptors
//    public void closeEntityManager() {
//        if (em != null) {
//            em.close();
//            em = null;
//            System.out.println("jp.co.pscp.material.materialmg.service.impl.AbstractFacade.closeEntityManager()");
//        }
//    }
    
    public EntityManager getEntityManager() {
        MstSystemConfig gongSi = am.getSystemConfig();
        if (gongSi == null) {
            return em1;
        }
        return getEntityManager(gongSi.getDbName());
    }
    
    public EntityManager getEntityManager(String persistenceUnitName) {
        if (StringUtils.isEmpty(persistenceUnitName)) {
            return em1;
        }
        
        switch (persistenceUnitName) {
            case SepC.PERSISTENCE_UNIT:
                return em1;
            case SepC.PERSISTENCE_UNIT2:
                return em2;
            default:
                return em1;
        }
    }
    
    /**
     * 将数据插入db
     *
     * @param entity
     * @return
     */
    public void create(T entity) {
//        am.getLoginInfo().getYuanGong().getYuangongRoleList()
        EntityManager em = getEntityManager();
        entity.setCreateInfo(am.getLoginInfo().getYuanGong().getYuanGongId());
        em.persist(entity);
        em.flush();
//        em.clear();
//        return (T) keyIdReset(entity);
    }

    /**
     * 批量插入DB
     *
     * @param list list
     * @return
     */
    public List createList(List<T> list) {
        EntityManager em = getEntityManager();
        for (T e : list) {
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
    public T edit(T entity) {
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
    public T merge(T entity) {
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
    public List editList(List<T> list) {
        EntityManager em = getEntityManager();
        for (T e : list) {
            merge(e);
        }
        return list;
    }

    /**
     * 从db中删除记录（理论删除）
     *
     * @param entity
     */
    public void remove(T entity) {
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
    public void removeList(List<T> entityList) {
        EntityManager em = getEntityManager();
        for (T e : entityList) {
            remove(e);
        }
    }

    /**
     * 从db中删除记录（物理删除）
     *
     * @param entity
     */
    public void forceRemove(T entity) {
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
    public void forceRemoveList(List<T> entityList) {
        EntityManager em = getEntityManager();
        for (T e : entityList) {
            forceRemove(e);
        }
    }
    
    /**
     * 刷新记录
     * @param e
     * @return 
     */
    public T refresh(T e) {
        EntityManager em = getEntityManager();
        em.refresh(e);
        return e;
    }

    public T find(Object id) {
        EntityManager em = getEntityManager();
        return em.find(entityClass, id);
    }

    public List<T> findAll() {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery q = cb.createQuery(entityClass);
        Root c = q.from(entityClass);
        q.select(c);
        q.where(cb.equal(c.get("delFlg"), SepE.Flag.NO.getValue()));
//        q.orderBy(cb.desc(c.get(BaseEntity_.updDate)));
        Query query = em.createQuery(q);
        return query.getResultList();
    }

    public List<T> findRange(int[] range) {
        EntityManager em = getEntityManager();
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        EntityManager em = getEntityManager();
        javax.persistence.criteria.CriteriaBuilder builder = em.getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery cq = builder.createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(em.getCriteriaBuilder().count(rt));
        cq.where(builder.equal(rt.get("delFlg"), SepE.Flag.NO.getValue()));
        javax.persistence.Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    /**
     * 自動プライマリキーを生成するエンティティ―が永久化直後にこのメソッドを呼び出し、<br />
     * DBに自動生成されたプロマリキ―をエンティティ―オブジェクトに設定する。
     *
     * @param em
     * @param entityObj
     * @return
     */
    @ExcludeClassInterceptors
    private Object keyIdReset(Object entityObj) {
        EntityManager em = getEntityManager();

        if (entityObj == null) {
            return null;
        }

        // オリジナルエンティティ―に初期化する。
        Object resultObj = entityObj;

        // エンティティ―クラス名の取得
        String[] pkAry = entityObj.getClass().getName().split("\\.");
        String entityClassName = pkAry[pkAry.length - 1];

        for (String[] AUTO_ID_ENTITY : CConst.AUTO_ID_ENTITY) {
            if (!entityClassName.equals(AUTO_ID_ENTITY[0])) {
                continue;
            }

            // 汎用キーID
            String keyId = em.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(entityObj).toString();
            if (keyId.contains(AUTO_ID_ENTITY[1])) {
                break;
            }
            resultObj = em.find(entityObj.getClass(),
                String.format(AUTO_ID_ENTITY[1] + "%0" + AUTO_ID_ENTITY[2] + "d", Long.parseLong(keyId)));
        }
        return resultObj;
    }
}
