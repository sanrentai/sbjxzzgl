package cn.tst.sbjxzzglxt.bizlogic.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.bizlogic.EQP0001BizLogic;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipProperty;
import cn.tst.sbjxzzglxt.entity.MstBuMen;
import cn.tst.sbjxzzglxt.entity.MstYuanGong;
import cn.tst.sbjxzzglxt.facade.LTEquipBasicFacade;
import cn.tst.sbjxzzglxt.facade.LTEquipPropertyFacade;
import cn.tst.sbjxzzglxt.facade.MstBuMenFacade;
import cn.tst.sbjxzzglxt.facade.MstYuanGongFacade;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.EQP0001ViewModel;
import org.apache.log4j.Logger;

/**
 * 仓库信息业务逻辑实现类
 *
 * @author ps_xy@pscp.co.jp
 */
@Stateless
public class EQP0001BizLogicImpl extends BaseBizLogic implements EQP0001BizLogic {

    private static final Logger LOG = Logger.getLogger(EQP0001BizLogicImpl.class.getName());
    @EJB
    private LTEquipBasicFacade eqpService;

    @EJB
    private LTEquipPropertyFacade propertyDao;

    @EJB
    private MstYuanGongFacade yuanGongDao;

    @EJB
    private MstBuMenFacade buMenDao;

    @Override
    public void loadEQP0001ViewModel(EQP0001ViewModel vm) {
        List<LTEquipBasic> LTEquipBasicList = eqpService.findByCId(new Long(SepC.EQP_ROOT));
        vm.setEquipBasicList(LTEquipBasicList);
        List<MstYuanGong> yuanGongList = yuanGongDao.findAll();
        vm.setYuanGongList(yuanGongList);
        List<MstBuMen> buMenList = buMenDao.findAll();
        vm.setBuMenList(buMenList);
    }

    @Override
    public ExecuteResult onSaveEquipment(SepE.ExecuteMode mode, EQP0001ViewModel vm) {

        ExecuteResult result = new ExecuteResult(mode);
        LTEquipBasic target = vm.getEditingEquipBasic();
        try {
            switch (mode) {
                case INSERT:
//                    target.setId(UUID.randomUUID().toString());
                    eqpService.create(target);
                    break;
                case UPDATE:
                    eqpService.edit(target);
                    break;
                case DELETE:
                    LOG.info("删除开始");
                    if (target.getChildren() == null || target.getChildren().isEmpty()) {
                        LOG.info("正要删除");
                        eqpService.remove(target);
                    } else {
                        LOG.info("删除失败");
                        result.setSuccess(false);
                        return result;
                    }
                    LOG.info("删除结束");
                    break;
            }
            result.setSuccess(true);
            vm.setEquipBasicList(eqpService.findByCId(new Long(SepC.EQP_ROOT)));
        } catch (Exception e) {
            result.anylizeException(e);
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public ExecuteResult onSaveProperty(SepE.ExecuteMode mode, EQP0001ViewModel vm) {

        ExecuteResult result = new ExecuteResult(mode);
        LTEquipProperty target = vm.getEditingEquipProperty();
        try {
            switch (mode) {
                case INSERT:
//                    target.setId(UUID.randomUUID().toString());
                    propertyDao.create(target);
                    break;
                case UPDATE:
                    propertyDao.edit(target);
                    break;
                case DELETE:
                    propertyDao.remove(target);
                    break;
            }
            result.setSuccess(true);
            vm.setEquipPropertyList(propertyDao.findAll());
        } catch (Exception e) {
            result.anylizeException(e);
            result.setSuccess(false);
        }
        return result;
    }

}
