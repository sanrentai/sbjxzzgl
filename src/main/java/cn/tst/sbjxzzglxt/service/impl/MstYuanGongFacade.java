package cn.tst.sbjxzzglxt.service.impl;

import java.util.List;
import org.apache.log4j.Logger;
import javax.ejb.Stateless;
import javax.persistence.Query;
import cn.tst.sbjxzzglxt.common.CStringUtils;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.common.SepE.SearchContentTypeEnum;
import cn.tst.sbjxzzglxt.entity.MstYuanGong;
import cn.tst.sbjxzzglxt.lazymodel.YuanGongSearchCondition;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author zero
 */
@Stateless
public class MstYuanGongFacade extends AbstractFacade<MstYuanGong> {

    private static final Logger LOG = Logger.getLogger(MstYuanGongFacade.class.getName());

    public MstYuanGongFacade() {
        super(MstYuanGong.class);
    }
    
    public List<MstYuanGong> findAllYouGuiJiYuanGong() {
        Query query = getEntityManager().createNamedQuery("MstYuanGong.findAllYouGuiJiYuanGong");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        return query.getResultList();
    }
    
    public List<MstYuanGong> findAllWuGuiJiYuanGong() {
        List<MstYuanGong> allYuanGong = this.findAll();
        List<MstYuanGong> youGuiJiYuanGongList = this.findAllYouGuiJiYuanGong();
        allYuanGong.removeAll(youGuiJiYuanGongList);
        return allYuanGong;
    }

    //2016/06/22 ロ 追加
    public List<MstYuanGong> findByYuanGongIdList(List<String> yuanGongIdList) {
        Query query = getEntityManager().createNamedQuery("MstYuanGong.findByInYuanGongIdList");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("yuanGongIdList", yuanGongIdList);
        return query.getResultList();
    }
    
    // 用角色查找员工信息
    public List<MstYuanGong> findByroleId(String roleId) {
        Query query = getEntityManager().createNamedQuery("MstYuanGong.findByRoleId");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        query.setParameter("roleId", roleId);
        return query.getResultList();
    }

    /**
     * 检索所有员工数据(改页)
     *
     * @param pageNo 当前页No
     * @param pageSize 页面Size
     * @param condition 查询条件
     * @return 查询结果
     */
    public List<MstYuanGong> findYuanGongLazyData(int pageNo, int pageSize, YuanGongSearchCondition condition) {

        ///创建查询列的SQL语句
        StringBuilder sbSQL = this.createYuanGongListLazySQL(SearchContentTypeEnum.COLUMNS);

        ///创建查询对象
        Query q = this.createYuanGongListLazyQuery(SearchContentTypeEnum.COLUMNS, sbSQL, condition);

        ///设置分页条件
        q.setParameter(97, pageNo);
        q.setParameter(98, pageSize);

        ///返回查询结果
        return q.getResultList();
    }

    /**
     * 检索所有员工件数(改页)
     *
     * @param condition 查询条件
     * @return 对象数据件数
     */
    public int findYuanGongLazyCount(YuanGongSearchCondition condition) {
        ///YuanGongSearchCondition
        StringBuilder sbSQL = this.createYuanGongListLazySQL(SearchContentTypeEnum.COUNT);

        ///创建查询对象
        Query q = this.createYuanGongListLazyQuery(SearchContentTypeEnum.COUNT, sbSQL, condition);

        ///返回得到的符合查询条件的总件数
//        return ((Long) q.getSingleResult()).intValue();
        return (int)q.getSingleResult();
    }

    /**
     * 检索所有员工数据(改页) 查询用 Query
     *
     * @param type 类型
     * @param sqlQuery 执行用SQL语句
     * @param condition 查询条件
     * @return Query对象
     */
    private Query createYuanGongListLazyQuery(SearchContentTypeEnum type, StringBuilder sqlQuery,
        YuanGongSearchCondition condition) {

        Query q = null;

        final boolean IS_ADD_EMPNAME = !StringUtils.isBlank(condition.getEmpName());
        final boolean IS_ADD_SEX = !StringUtils.isBlank(condition.getSex());
        final boolean IS_ADD_EMAIL = !StringUtils.isBlank(condition.getEmail());
        final boolean IS_ADD_CELLPHONENUMBER = !StringUtils.isBlank(condition.getCellPhoneNumber());
        final boolean IS_ADD_ADDRESS = !StringUtils.isBlank(condition.getAddress());

        sqlQuery.append(" and t1.del_flg = ?1 ");

        /// 员工名
        if (IS_ADD_EMPNAME) {
            sqlQuery.append(" and ( ");
            sqlQuery.append("     (t1.xing || t1.ming) like '%")
                .append(CStringUtils.removeSpecialCharater(condition.getEmpName())).append("%'");
            sqlQuery.append(" or ");
            sqlQuery.append("     (t1.xing_fayin || t1.ming_fayin) like '%")
                .append(CStringUtils.removeSpecialCharater(condition.getEmpName())).append("%'");
            sqlQuery.append(" ) ");
        }

        ///性别 ?3
        if (IS_ADD_SEX) {
            sqlQuery.append(" and t1.xing_bie = ?2 ");
        }

        ///邮箱  ?4
        if (IS_ADD_EMAIL) {
            sqlQuery.append(" and t1.email like '%").append(
                CStringUtils.removeSpecialCharater(condition.getEmail())).append("%'");
        }

        ///电话号码  ?5
        if (IS_ADD_CELLPHONENUMBER) {
            sqlQuery.append(" and t1.dian_hua like '")
                .append(CStringUtils.removeSpecialCharater(condition.getCellPhoneNumber())).append("%'");
        }

        if (IS_ADD_ADDRESS) {
            sqlQuery.append(" and t1.zhu_zhi like '%")
                .append(CStringUtils.removeSpecialCharater(condition.getAddress())).append("%'");
        }

        switch (type) {
            case COLUMNS:
//                sqlQuery.append(" order by ");
//                sqlQuery.append("     1 ");
//                sqlQuery.append("\n").append(" OFFSET ?97 LIMIT ?98 ");
                q = getEntityManager()
                    .createNativeQuery(sqlQuery.toString(),
                        MstYuanGong.class);
                break;
            case COUNT:
                q = getEntityManager()
                    .createNativeQuery(sqlQuery.toString());
                break;
        }

        q.setParameter(1, SepE.Flag.NO.getValue());

        if (IS_ADD_SEX) {
            q.setParameter(2, condition.getSex());
        }

        return q;
    }

    /**
     * 检索所有员工数据(改页) 查询用 SQL语句
     *
     * @param type 类型
     * @return SQL语句
     */
    private StringBuilder createYuanGongListLazySQL(SearchContentTypeEnum type) {

        StringBuilder sbSQL = new StringBuilder();

        sbSQL.append(" select ");
        switch (type) {
            case COUNT:
                sbSQL.append(" count(1) CNT ");
                break;
            case COLUMNS:
                sbSQL.append("  yuan_gong_id ");
                sbSQL.append(" ,xing ");
                sbSQL.append(" ,xing_fayin ");
                sbSQL.append(" ,ming ");
                sbSQL.append(" ,ming_fayin ");
                sbSQL.append(" ,bie_ming ");
                sbSQL.append(" ,you_bian ");
                sbSQL.append(" ,shen_fen_zheng ");
                sbSQL.append(" ,zhu_zhi ");
                sbSQL.append(" ,xing_bie ");
                sbSQL.append(" ,chu_sheng_ri_qi ");
                sbSQL.append(" ,dian_hua ");
                sbSQL.append(" ,email ");
                sbSQL.append(" ,zhao_pian_lu_jing ");
                sbSQL.append(" ,ins_rep ");
                sbSQL.append(" ,ins_date ");
                sbSQL.append(" ,upd_rep ");
                sbSQL.append(" ,upd_date ");
                sbSQL.append(" ,del_flg ");
                sbSQL.append(" ,version ");
                break;
        }
        sbSQL.append(" from ");
        sbSQL.append("     mst_yuan_gong as t1 ");
        sbSQL.append(" where ");
        sbSQL.append("     1 = 1 ");

        return sbSQL;
    }
}
