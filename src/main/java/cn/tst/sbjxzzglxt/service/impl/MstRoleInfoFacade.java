package cn.tst.sbjxzzglxt.service.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.MstRoleInfo;

/**
 * 角色基本信息
 *
 * @author ps_xy@pscp.co.jp
 */
@Stateless
public class MstRoleInfoFacade extends AbstractFacade<MstRoleInfo> {

    public MstRoleInfoFacade() {
        super(MstRoleInfo.class);
    }
    
    public List<MstRoleInfo> findByYuanGongId(String yuanGongId) {
        Query q = getEntityManager().createQuery("SELECT d.role FROM DatYuangongRole d WHERE d.delFlg = :delFlg AND d.pk.yuanGongId = :yuanGongId");
        q.setParameter("delFlg", SepE.Flag.NO.getValue());
        q.setParameter("yuanGongId", yuanGongId);
        return q.getResultList();
    }
}
