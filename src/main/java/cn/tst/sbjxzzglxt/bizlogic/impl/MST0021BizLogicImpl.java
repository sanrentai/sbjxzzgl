package cn.tst.sbjxzzglxt.bizlogic.impl;

import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.bizlogic.MST0021BizLogic;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.MstXunJianRole;
import cn.tst.sbjxzzglxt.facade.MstYuanGongFacade;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.MST0021ViewModel;

/**
 * 违章登记
 *
 * @author 曹春
 */
@Stateless
public class MST0021BizLogicImpl extends BaseBizLogic implements MST0021BizLogic {

    private final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(MST0021BizLogicImpl.class);
//
//    @EJB
//    private MstCheLiangFacade cheLiangDao;
//    
//    @EJB
//    private MstSiJiFacade mstSiJiDao;
//
//    @EJB
//    private MstXunJianRoleFacade cheWeiZhangDao;
//
//    @EJB
//    private MstYuanGongFacade mstYuanGongDao;

    @Override
    public void loadMST0021ViewModel(MST0021ViewModel vm) {
//        /// 所有内部车辆信息
//        List<MstCheLiang> cheLiangList = cheLiangDao.getNeiBuChe();
//        vm.setCheLiangList(cheLiangList);
//        
//        /// 所有内部司机信息
//        List<MstSiJi> siJiList = mstSiJiDao.findNeiBuSiJi();
//        vm.setSiJiList(siJiList);
//        /// 所有违章信息
//        List<MstXunJianRole> weiZhangList = cheWeiZhangDao.findAll();
//        vm.setWeiZhangList(weiZhangList);
//        refreshWeiZhang(vm);
    }

    @Override
    public void setToday(MST0021ViewModel vm) {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        vm.setStartDate(cal.getTime());   //设置开始日期 为今天0点
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        vm.setEndDate(cal.getTime());   //设置结束日期 为今天24点
    }

    @Override
    public void setThisWeek(MST0021ViewModel vm) {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        vm.setStartDate(cal.getTime());   //设置开始日期 本周一0点时间 
        cal.add(Calendar.DAY_OF_WEEK, 7);
        cal.add(Calendar.SECOND, -1);
        vm.setEndDate(cal.getTime());   //设置结束日期 本周日24点时间  
    }

    @Override
    public void setThisMonth(MST0021ViewModel vm) {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        vm.setStartDate(cal.getTime());   //设置开始日期 本月一日0点时间 
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.add(Calendar.SECOND, -1);
        vm.setEndDate(cal.getTime());   //设置结束日期 本月最后一日24点时间 
    }

    @Override
    public void setThisSeason(MST0021ViewModel vm) {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        int currentMonth = cal.get(Calendar.MONTH) + 1;  //当前月份
        if (currentMonth >= 1 && currentMonth <= 3) {
            cal.set(Calendar.MONTH, 0);
        } else if (currentMonth >= 4 && currentMonth <= 6) {
            cal.set(Calendar.MONTH, 3);
        } else if (currentMonth >= 7 && currentMonth <= 9) {
            cal.set(Calendar.MONTH, 6);
        } else if (currentMonth >= 10 && currentMonth <= 12) {
            cal.set(Calendar.MONTH, 9);
        }
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        vm.setStartDate(cal.getTime());   //设置开始日期 本季度第一日0点时间 
        cal.add(Calendar.MONTH, 3);
        cal.add(Calendar.SECOND, -1);
        vm.setEndDate(cal.getTime());   //设置开始日期 本季度最后一日24点时间 
    }

    @Override
    public void refreshWeiZhang(MST0021ViewModel vm) {
        /// 库存一览
//        List<DatKuCunXianZhuang> kuCunList = new ArrayList<>();
//        List<MstShiTiWuZiBianHao> youWuZiList = mstShiTiWuZiBianHaoDao.findByFenLeiId(SepC.FEN_LEI_MEI_ID);
//        for (MstShiTiWuZiBianHao wuZi : youWuZiList) {
//            List<DatKuCunXianZhuang> list = datKuCunXianZhuangDao.findByWuZiId(wuZi.getWuZiBianHao());
//            kuCunList.addAll(list);
//        }
//        vm.setMeiKuCunList(kuCunList);
    }

    @Override
    public ExecuteResult saveWeiZhangJiLu(SepE.ExecuteMode mode, MST0021ViewModel vm) {

        ExecuteResult result = new ExecuteResult(mode);
//
//        try {
//
//            MstXunJianRole target = vm.getEditingWeiZhang();
//
//            switch (mode) {
//                case INSERT:
//                    target = cheWeiZhangDao.create(target);
//                    break;
//                case UPDATE:
//                    /// 更新库存数
//                    cheWeiZhangDao.edit(target);
//                    break;
//                case DELETE:
//                    cheWeiZhangDao.remove(target);
//                    break;
//            }
//            vm.setWeiZhangList(cheWeiZhangDao.findAll());
//            result.setSuccess(true);
//        } catch (Exception e) {
//            result.anylizeException(e);
//            result.setSuccess(false);
//            e.printStackTrace();
//            LOG.error(e);
//        }
        return result;
    }

}
