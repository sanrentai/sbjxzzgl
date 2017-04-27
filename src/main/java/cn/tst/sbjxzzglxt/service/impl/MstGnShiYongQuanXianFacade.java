package cn.tst.sbjxzzglxt.service.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.MstGnShiYongQuanXian;

/**
 *
 * @author 紀
 */
@Stateless
public class MstGnShiYongQuanXianFacade extends AbstractFacade<MstGnShiYongQuanXian> {

    public MstGnShiYongQuanXianFacade() {
        super(MstGnShiYongQuanXian.class);
    }

    /**
     * 根据部门,只能删除所有权限
     *
     * @param roleId 角色ID
     */
    public void removeAllByBuMenZhiNeng(String roleId) {
        Query q
            = getEntityManager()
            .createQuery("DELETE FROM MstGnShiYongQuanXian AS t "
                + "WHERE t.pk.roleId = :roleId");
        q.setParameter("roleId", roleId);
        q.executeUpdate();
    }

    /**
     * 查看可用权限
     *
     * @param roleId 角色ID
     * @return 权限一览
     */
    public List<MstGnShiYongQuanXian> findUsableQuanXian(String roleId) {
        Query q
            = getEntityManager()
            .createQuery("SELECT t FROM MstGnShiYongQuanXian AS t "
                + "WHERE t.pk.roleId = :roleId AND t.quanXian = :quanXian AND t.delFlg = :delFlg "
                + "ORDER BY t.pk.gongNengId ");
        q.setParameter("roleId", roleId);
        q.setParameter("delFlg", SepE.Flag.NO.getValue());
        q.setParameter("quanXian", 1);
        return q.getResultList();
    }
    
    /**
     * 查看可用权限
     *
     * @param yuanGongId 员工ID
     * @return 权限一览
     */
    public List<MstGnShiYongQuanXian> findByYuanGongId(String yuanGongId) {
        Query query = getEntityManager().createQuery("SELECT m FROM MstGnShiYongQuanXian m, DatYuangongRole d WHERE m.delFlg = :delFlg AND d.delFlg = :delFlg AND m.quanXian = :quanXian AND m.pk.roleId = d.pk.roleId AND d.pk.yuanGongId = :yuanGongId");
        query.setParameter("yuanGongId", yuanGongId);
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("quanXian", 1);
        return query.getResultList();
    }
    
    public boolean findByYuanGongIdAndHuaMianAndQuanXianMing(String yuanGongId, String huaMianId, String quanXianMing) {
        Query query = getEntityManager().createQuery("SELECT COUNT(d) FROM MstGnShiYongQuanXian m, DatYuangongRole d WHERE m.delFlg = :delFlg AND d.delFlg = :delFlg AND m.quanXian = :quanXian AND m.pk.roleId = d.pk.roleId AND d.pk.yuanGongId = :yuanGongId AND m.gongNeng.huaMianId = :huaMianId AND m.gongNeng.gaiYao = :quanXianMing");
        query.setParameter("yuanGongId", yuanGongId);
        query.setParameter("huaMianId", huaMianId);
        query.setParameter("quanXianMing", quanXianMing);
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("quanXian", 1);
        long count = (long) query.getSingleResult();
        return count != 0;
    }
}
