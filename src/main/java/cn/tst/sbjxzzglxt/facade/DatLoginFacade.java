package cn.tst.sbjxzzglxt.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.DatLoginInfo;

/**
 *
 * @author 紀
 */
@Stateless
public class DatLoginFacade extends AbstractFacade<DatLoginInfo> {

    public DatLoginFacade() {
        super(DatLoginInfo.class);
    }

    /**
     * 取得Login信息
     *
     * @param dbName
     * @param loginId 登录ID
     * @param password 密码
     * @return 登录者信息
     */
    public DatLoginInfo findLoginInfo(String dbName, String loginId, String password) {
        // ログインＩＤとパスワードにて、ＤＢから認証情報を取得する。
        Query qe = this.getEntityManager(dbName).createNamedQuery("DatLoginInfo.findByIdAndPw");
        qe.setParameter("delFlg", SepE.Flag.NO.getValue());
        qe.setParameter("loginId", loginId);
        qe.setParameter("md5passwd", password);
        List<DatLoginInfo> result = qe.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }
}
