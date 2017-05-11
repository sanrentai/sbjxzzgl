package cn.tst.sbjxzzglxt.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.MstCaiDanXiangMu;

/**
 * 菜单项目Facade实现类
 *
 * @author ps_xy@pscp.co.jp
 */
@Stateless
public class MstCaiDanXiangMuFacade extends AbstractFacade<MstCaiDanXiangMu> {

    enum CaiDanSearchType {
        YUAN_GONG,
        ROLE
    }

    public MstCaiDanXiangMuFacade() {
        super(MstCaiDanXiangMu.class);
    }
    
    public MstCaiDanXiangMu findByXiangMuId(String xiangMuId) {
        Query q = this.getEntityManager().createQuery("SELECT m FROM MstCaiDanXiangMu m WHERE m.delFlg = :delFlg AND m.pk.xiangMuId = :xiangMuId ORDER BY m.paixu ASC");
        q.setParameter("delFlg", SepE.Flag.NO.getValue());
        q.setParameter("xiangMuId", xiangMuId);
        List<MstCaiDanXiangMu> list = q.getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    /**
     * 获取含有功能的菜单项
     *
     * @return 还有功能的菜单
     */
    public List<MstCaiDanXiangMu> findAllHasFunctionCaiDan() {

        StringBuilder sbSQL = new StringBuilder();
        sbSQL.append(" SELECT ");
        sbSQL.append("     t1.mo_kuai_id ");
        sbSQL.append("    ,t1.caidan_id ");
        sbSQL.append("    ,t1.xiang_mu_id ");
        sbSQL.append("    ,t1.xiang_mu_ming ");
        sbSQL.append("    ,t1.icon_name ");
        sbSQL.append("    ,t1.paixu ");
        sbSQL.append("    ,t1.ins_rep  ");
        sbSQL.append("    ,t1.ins_date ");
        sbSQL.append("    ,t1.upd_rep  ");
        sbSQL.append("    ,t1.upd_date ");
        sbSQL.append("    ,t1.del_flg  ");
        sbSQL.append("    ,t1.version  ");
        sbSQL.append(" FROM ");
        sbSQL.append("     mst_cai_dan_xiang_mu     AS t1 ");
        sbSQL.append(" WHERE ");
        sbSQL.append("     t1.del_flg = ?1 ");
        sbSQL.append(" and exists ( ");
        sbSQL.append("    SELECT ");
        sbSQL.append("        1 ");
        sbSQL.append("    FROM ");
        sbSQL.append("        mst_xi_tong_gong_neng AS t2 ");
        sbSQL.append("    WHERE ");
        sbSQL.append("        t1.xiang_mu_id = t2.hua_mian_id ");
        sbSQL.append("    and t2.del_flg = ?1 ");
        sbSQL.append(" ) ");
        sbSQL.append(" ORDER BY ");
        sbSQL.append("     t1.caidan_id ");
        sbSQL.append("    ,t1.xiang_mu_id ");

        Query q = this.getEntityManager().createNativeQuery(sbSQL.toString(), MstCaiDanXiangMu.class);
        q.setParameter(1, SepE.Flag.NO.getValue());
        return q.getResultList();
    }

    /**
     * 查询有权限的菜单
     *
     * @param yuanGongId 员工的ID
     * @return 可用的菜单
     */
    public List<MstCaiDanXiangMu> findMenuHasAuthoriy(String yuanGongId) {
        return this.findMenuByType(CaiDanSearchType.YUAN_GONG, yuanGongId);
    }

    /**
     * 查询角色设定的菜单
     *
     * @param roleId 角色ID
     * @return 角色设置的菜单
     */
    public List<MstCaiDanXiangMu> findMenuSetByRole(String roleId) {
        return this.findMenuByType(CaiDanSearchType.ROLE, roleId);
    }

    /**
     * 查询有权限的菜单
     *
     * @param type 分类类型
     * @param id 员工的ID or 角色ID
     * @return 可用的菜单
     */
    private List<MstCaiDanXiangMu> findMenuByType(CaiDanSearchType type, String id) {

        StringBuilder sbSQL = new StringBuilder();

        sbSQL.append(" SELECT ");
        sbSQL.append("     t1.mo_kuai_id ");
        sbSQL.append("    ,t1.caidan_id ");
        sbSQL.append("    ,t1.xiang_mu_id ");
        sbSQL.append("    ,t1.xiang_mu_ming ");
        sbSQL.append("    ,t1.icon_name ");
        sbSQL.append("    ,t1.paixu ");
        sbSQL.append("    ,t1.ins_rep  ");
        sbSQL.append("    ,t1.ins_date ");
        sbSQL.append("    ,t1.upd_rep  ");
        sbSQL.append("    ,t1.upd_date ");
        sbSQL.append("    ,t1.del_flg  ");
        sbSQL.append("    ,t1.version  ");
        sbSQL.append(" FROM ");
        sbSQL.append("     mst_cai_dan          AS t0 ");
        sbSQL.append(" INNER JOIN ");
        sbSQL.append("     mst_cai_dan_xiang_mu AS t1 ");
        sbSQL.append(" ON ");
        sbSQL.append("     t0.caidan_id = t1.caidan_id ");
        sbSQL.append(" INNER JOIN ");
        sbSQL.append("   ( ");
        sbSQL.append("       SELECT ");
        sbSQL.append("           Y.hua_mian_id ");
        sbSQL.append("       FROM ");
        sbSQL.append("           mst_gn_shi_yong_quan_xian AS X ");
        sbSQL.append("       INNER JOIN ");
        sbSQL.append("           mst_xi_tong_gong_neng     AS Y ");
        sbSQL.append("       ON ");
        sbSQL.append("           X.gong_neng_id = Y.gong_neng_id ");
        sbSQL.append("       INNER JOIN ");
        sbSQL.append("           dat_yuangong_role         AS Z ");
        sbSQL.append("       ON ");
        sbSQL.append("           Z.role_id        = X.role_id ");
        sbSQL.append("       AND Z.you_xiao       = '1' ");
        sbSQL.append("       WHERE ");
        sbSQL.append("           X.del_flg     = ?1 ");
        sbSQL.append("       AND Y.del_flg     = ?1 ");
        sbSQL.append("       AND Z.del_flg     = ?1 ");
        switch (type) {
            case YUAN_GONG:
                sbSQL.append("       AND Z.yuan_gong_id= ?2 ");
                break;
            case ROLE:
                sbSQL.append("       AND Z.role_id= ?2 ");
                break;
        }
        sbSQL.append("       AND X.quan_xian > 0 ");
        sbSQL.append("       GROUP BY ");
        sbSQL.append("           Y.hua_mian_id ");
        sbSQL.append(" ) AS t2 ");
        sbSQL.append(" ON ");
        sbSQL.append("     t1.xiang_mu_id = t2.hua_mian_id ");
        sbSQL.append(" AND t1.del_flg     = ?1 ");
        sbSQL.append(" ORDER BY ");
        sbSQL.append("    t0.paixu ");
        sbSQL.append("   ,t1.paixu ");

        Query q = this.getEntityManager().createNativeQuery(sbSQL.toString(), MstCaiDanXiangMu.class);
        q.setParameter(1, SepE.Flag.NO.getValue());
        q.setParameter(2, id);

        return q.getResultList();
    }

}
