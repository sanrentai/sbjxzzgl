package cn.tst.sbjxzzglxt.facade;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.DatYuanGongSuoShu;

/**
 *
 * @author 紀
 */
@Stateless
public class DatYuanGongSuoShuFacade extends AbstractFacade<DatYuanGongSuoShu> {

    public DatYuanGongSuoShuFacade() {
        super(DatYuanGongSuoShu.class);
    }
    
    /**
     * 获取员工所属
     *
     * @param dbName
     * @param yuanGongId 员工ID
     * @return 员工所属对象
     */
    public DatYuanGongSuoShu findYuanGongSuoShu(String dbName, String yuanGongId) {
        // 社員所属情報リストを検索する。
        Query q = this.getEntityManager(dbName).createNamedQuery("DatYuanGongSuoShu.findByYuanGongIdZaiZhiZt");
        q.setParameter("delFlg", SepE.Flag.NO.getValue());
        q.setParameter("yuanGongId", yuanGongId);
        q.setParameter("zaiZhiZt", SepE.ZaiZhiZhuangTai.ZAI_ZHI.getValue());  // 在職状態

        List<DatYuanGongSuoShu> result = q.getResultList();

        return result.isEmpty() ? null : result.get(0);
    }

    /**
     * 获取员工所属
     *
     * @param yuanGongId 员工ID
     * @return 员工所属对象
     */
    public DatYuanGongSuoShu findYuanGongSuoShu(String yuanGongId) {
        return findYuanGongSuoShu(null, yuanGongId);
    }

    /**
     * 所属历史一览
     *
     * @param yuanGongId 员工ID
     * @return 员工所属历史一览
     */
    public List<DatYuanGongSuoShu> findAllYuanSuoShu(String yuanGongId) {

        // 社員所属情報リストを検索する。
        Query q = this.getEntityManager()
            .createQuery("SELECT t FROM DatYuanGongSuoShu AS t "
                + " WHERE t.pk.yuanGongId = :yuanGongId"
                + " AND t.delFlg = :delFlg"
                + " ORDER BY t.xieRenRq DESC");

        q.setParameter("delFlg", SepE.Flag.NO.getValue());
        q.setParameter("yuanGongId", yuanGongId);

        return q.getResultList();
    }

    /**
     * 添加的数据在任日期比当前在任日期最新数据要早<br/>
     * 例: 现有数据 2016/08/01 -> 新增: 2016/07/26
     *
     * @param yuanGongId 员工ID
     * @param buMenId 部门ID
     * @param zhiNengId 职能ID
     * @param shangRenRiQi 上任日期
     * @return 对象数据件数
     */
    public int findZaiRenRiqiBeforeHistory(String yuanGongId, String buMenId, String zhiNengId, Date shangRenRq) {
        Query q
            = this.getEntityManager()
            .createQuery("SELECT COUNT(t) FROM DatYuanGongSuoShu AS t "
                + " WHERE"
                + "     t.pk.buMenId = :buMenId"
                + " AND t.pk.zhiNengId  = :zhiNengId "
                + " AND t.pk.yuanGongId = :yuanGongId "
                + " AND t.pk.shangRenRq > :shangRenRq ");

        q.setParameter("buMenId", buMenId);
        q.setParameter("zhiNengId", zhiNengId);
        q.setParameter("yuanGongId", yuanGongId);
        q.setParameter("shangRenRq", shangRenRq, TemporalType.DATE);

        return ((Long) q.getSingleResult()).intValue();
    }

    /**
     * 获取相同部门,职能最近的一条数据
     *
     * @param yuanGongId 员工ID
     * @param buMenId 部门ID
     * @param zhiNengId 职能ID
     * @return
     */
    public DatYuanGongSuoShu findLastZaiRenRiqiHistory(String yuanGongId, String buMenId, String zhiNengId) {

        List<DatYuanGongSuoShu> result = null;

        Query q = this.getEntityManager()
            .createQuery("SELECT t FROM DatYuanGongSuoShu  AS t "
                + " WHERE"
                + "     t.pk.buMenId = :buMenId"
                + " AND t.pk.zhiNengId  = :zhiNengId "
                + " AND t.pk.yuanGongId = :yuanGongId "
                + " ORDER BY t.pk.shangRenRq DESC ");

        q.setParameter("buMenId", buMenId);
        q.setParameter("zhiNengId", zhiNengId);
        q.setParameter("yuanGongId", yuanGongId);

        q.setFirstResult(0);
        q.setMaxResults(1);

        result = q.getResultList();

        return result.isEmpty() ? null : result.get(0);
    }
}
