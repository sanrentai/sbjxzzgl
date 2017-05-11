package cn.tst.sbjxzzglxt.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.DatLoginInfo;

/**
 * Login Facade
 *
 * @author ps_xy@pscp.co.jp
 */
@Stateless
public class DatLoginInfoFacade extends AbstractFacade<DatLoginInfo> {

    public DatLoginInfoFacade() {
        super(DatLoginInfo.class);
    }
    
    public DatLoginInfo findByLoginId(String loginId) {
        List<DatLoginInfo> result = null;
        Query qe = this.getEntityManager().createNamedQuery("DatLoginInfo.findByLoginId");
        qe.setParameter("delFlg", SepE.Flag.NO.getValue());
        qe.setParameter("loginId", loginId);
        result = qe.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }
}
