package cn.tst.sbjxzzglxt.bizlogic.impl;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.bizlogic.MST0004BizLogic;
import cn.tst.sbjxzzglxt.common.CConst;
import cn.tst.sbjxzzglxt.common.PinyinUtils;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.DatYuanGongSuoShu;
import cn.tst.sbjxzzglxt.entity.DatYuanGongSuoShuPK;
import cn.tst.sbjxzzglxt.entity.MstBuMen;
import cn.tst.sbjxzzglxt.entity.MstYuanGong;
import cn.tst.sbjxzzglxt.entity.MstZhiNeng;
import cn.tst.sbjxzzglxt.lazymodel.MstYuanGongLazyModel;
import cn.tst.sbjxzzglxt.service.impl.DatLoginInfoFacade;
import cn.tst.sbjxzzglxt.service.impl.DatYuanGongSuoShuFacade;
import cn.tst.sbjxzzglxt.service.impl.MstBuMenFacade;
import cn.tst.sbjxzzglxt.service.impl.MstYuanGongFacade;
import cn.tst.sbjxzzglxt.service.impl.MstZhiNengFacade;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.MST0004ViewModel;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.primefaces.model.LazyDataModel;

/**
 * 员工信息
 *
 * @author ps_xy@pscp.co.jp
 */
@Stateless
public class MST0004BizLogicImpl extends BaseBizLogic implements MST0004BizLogic {

    private final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(MST0004BizLogicImpl.class);

    ///员工信息Facade
    @EJB
    private MstYuanGongFacade yuanGongService;
    
    @EJB
    private DatLoginInfoFacade datLoginInfoDao;

    ///部门信息Facade
    @EJB
    private MstBuMenFacade buMenService;

    ///职能信息Facade
    @EJB
    private MstZhiNengFacade zhiNengService;

    ///所属信息Facade
    @EJB
    private DatYuanGongSuoShuFacade suoShuService;

    @Override
    public void loadMST0004ViewModel(MST0004ViewModel vm) {

        ///取得所有员工信息
        LazyDataModel<MstYuanGong> yuanGongList = new MstYuanGongLazyModel(this.yuanGongService);

        ///获取所有部门
        List<MstBuMen> buMenList = buMenService.findAll();

        ///职能一览
        List<MstZhiNeng> zhiNengList = zhiNengService.findAll();

        vm.setYuanGongList(yuanGongList);
        vm.setBuMenList(buMenList);
        vm.setZhiNengList(zhiNengList);
    }

    @Override
    public void refreshZhiNengData(MST0004ViewModel vm) {

        String yuanGongId = vm.getEditingYuanGong().getYuanGongId();

        List<DatYuanGongSuoShu> suoShuList = suoShuService.findAllYuanSuoShu(yuanGongId);

        vm.setSuoShuList(suoShuList);

        ///设置编辑所属的员工ID
        vm.initSuoShu(yuanGongId);
    }

    @Override
    public ExecuteResult saveYuanGong(SepE.ExecuteMode mode, MstYuanGong obj) {

        ExecuteResult result = new ExecuteResult(mode);

        try {

            ///姓转拼音
            obj.setXingFayin(PinyinUtils.convert2PingYin(obj.getXing()));
            ///名转拼音
            obj.setMingFayin(PinyinUtils.convert2PingYin(obj.getMing()));
            ///去除右边的格式
            obj.setYouBian(obj.getYouBian().replace(CConst.HYPHEN, CConst.BLANK));
            ///别名,如果别名没有输入则用用户姓名
            if (StringUtils.isEmpty(obj.getBieMing())) {
                obj.setBieMing(obj.getName());
            }

            switch (mode) {
                case INSERT:
                    ///插入数据
                    this.yuanGongService.create(obj);
                    break;
                case UPDATE:
                    this.yuanGongService.edit(obj);
                    break;
                case DELETE:
                    break;
            }

            result.setSuccess(true);

        } catch (Exception ex) {
            result.anylizeException(ex);
            result.setSuccess(false);
        }

        return result;
    }

    @Override
    public boolean checkZaiRenRiqiBeforeLastData(MST0004ViewModel vm) {

        DatYuanGongSuoShuPK pk = vm.getEditingSuoShu().getPk();

        return this.suoShuService
            .findZaiRenRiqiBeforeHistory(
                pk.getYuanGongId(),
                pk.getBuMenId(),
                pk.getZhiNengId(),
                pk.getShangRenRq()) >= 1;
    }

    @Override
    public ExecuteResult saveSuoShu(SepE.ExecuteMode mode, DatYuanGongSuoShu obj) {

        ExecuteResult result = new ExecuteResult(mode);

        try {

            if (mode != SepE.ExecuteMode.DELETE) {
                ///更新最近一天数据的卸任日期和在任状态
                DatYuanGongSuoShu lastData = this.suoShuService.findLastZaiRenRiqiHistory(obj.getPk().getYuanGongId(),
                    obj.getPk().getBuMenId(),
                    obj.getPk().getZhiNengId());

                if (lastData != null) {
                    ///去除当前提交数据的上任日期 - 1 作为最新数据的卸任日期
                    Date xieRenRq = DateUtils.addDays(obj.getPk().getShangRenRq(), -1);
                    lastData.setZaiZhiZt(SepE.Flag.NO.getValue());
                    lastData.setXieRenRq(xieRenRq);
                    this.suoShuService.edit(lastData);
                }
            }

            switch (mode) {
                case INSERT:
                    ///插入数据
                    this.suoShuService.create(obj);
                    /// TODO 将部门作为工程添加到员工的负责工程中
                    break;
                case UPDATE:
                    ///更新当前数据
                    this.suoShuService.edit(obj);
                    break;
                case DELETE:
                    this.suoShuService.remove(obj);
                    break;
            }

            result.setSuccess(true);

        } catch (Exception ex) {
            result.anylizeException(ex);
            result.setSuccess(false);
        }

        return result;
    }

    @Override
    public void liZhi(MST0004ViewModel vm, MstYuanGong yuanGong) {
        yuanGongService.remove(yuanGong);
        datLoginInfoDao.remove(yuanGong.getLoginInfo());
    }

}
