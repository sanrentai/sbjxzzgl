package cn.tst.sbjxzzglxt.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.DatYuangongRole;

/**
 * 角色信息管理
 *
 * @author ps_xy@pscp.co.jp
 */
@Stateless
public class DatYuangongRoleFacade extends AbstractFacade<DatYuangongRole> {

    public DatYuangongRoleFacade() {
        super(DatYuangongRole.class);
    }

    /**
     * 取得员工角色一览信息
     *
     * @param yuanGongId 员工ID
     * @return 员工角色一览信息
     */
    public List<DatYuangongRole> findYuanGongRoles(String yuanGongId) {

        StringBuilder sbSQL = new StringBuilder();
        sbSQL.append(" SELECT ");
        sbSQL.append("     t1.role_id ");
        sbSQL.append("    ,?2 as yuan_gong_id ");
        sbSQL.append("    ,coalesce(t2.you_xiao,'0') AS you_xiao ");
        sbSQL.append("    ,t2.ins_rep ");
        sbSQL.append("    ,t2.ins_date ");
        sbSQL.append("    ,t2.upd_rep ");
        sbSQL.append("    ,t2.upd_date ");
        sbSQL.append("    ,t2.del_flg ");
        sbSQL.append("    ,t2.version ");
        sbSQL.append(" FROM ");
        sbSQL.append("     mst_role_info     AS t1 ");
        sbSQL.append(" LEFT JOIN ");
        sbSQL.append("     dat_yuangong_role AS t2 ");
        sbSQL.append(" ON ");
        sbSQL.append("     t1.role_id = t2.role_id ");
        sbSQL.append(" AND t2.yuan_gong_id = ?2 ");
        sbSQL.append(" AND t2.del_flg = ?1 ");
        sbSQL.append(" WHERE ");
        sbSQL.append("     t1.del_flg = ?1 ");

        Query q = getEntityManager().createNativeQuery(sbSQL.toString(), DatYuangongRole.class);

        q.setParameter(1, SepE.Flag.NO.getValue());
        q.setParameter(2, yuanGongId);

        return q.getResultList();
    }

    /**
     * 删除员工全部角色
     *
     * @param yuanGongId 员工ID
     */
    public void removeAllRoleByYuanGong(String yuanGongId) {
        Query q
            = getEntityManager()
            .createQuery("DELETE FROM DatYuangongRole as t WHERE t.pk.yuanGongId = :yuanGongId");

        q.setParameter("yuanGongId", yuanGongId);
        q.executeUpdate();
    }
}
