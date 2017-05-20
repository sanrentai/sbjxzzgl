package cn.tst.sbjxzzglxt.bizlogic.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.bizlogic.EQP0005BizLogic;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipWarn;
import cn.tst.sbjxzzglxt.facade.LTEquipBasicFacade;
import cn.tst.sbjxzzglxt.facade.LTEquipWarnFacade;
import cn.tst.sbjxzzglxt.viewmodel.EQP0001ViewModel;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.EQP0005ViewModel;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * 仓库信息业务逻辑实现类
 *
 * @author ps_xy@pscp.co.jp
 */
@Stateless
public class EQP0005BizLogicImpl extends BaseBizLogic implements EQP0005BizLogic {

    private static final Logger LOG = Logger.getLogger(EQP0005BizLogicImpl.class.getName());
    @EJB
    private LTEquipWarnFacade equipWarnFacade;

    @EJB
    private LTEquipBasicFacade eqpService;

    //这里是初始化视图，根据ID把记录信息查询出来，保存到集合内用于页面调用，否则会空
    @Override
    public void loadEQP0005ViewModel(EQP0005ViewModel vm) {
//        vm.setEquipErrorList(equipErrorFacade.findById(Long.MIN_VALUE));
        List<LTEquipWarn> equipWarn = equipWarnFacade.findAll();
        vm.setEquipWarnList(equipWarn);
        List<LTEquipBasic> findAll = eqpService.findAll();
        vm.setEquipBasicList(findAll);
    }

    public ExecuteResult onSaveEquipment(SepE.ExecuteMode mode, EQP0005ViewModel vm) {

        ExecuteResult result = new ExecuteResult(mode);
        LTEquipWarn target = vm.getEquipWarn();
        try {
            switch (mode) {
                case INSERT:
//                    target.setId(UUID.randomUUID().toString());
                    equipWarnFacade.create(target);
                    break;
                case UPDATE:
                    equipWarnFacade.edit(target);
                    break;
                case DELETE:
                    LOG.info("删除开始");
                    equipWarnFacade.remove(target);
                    LOG.info("删除结束");
                    break;
            }
            vm.setEquipWarnList(equipWarnFacade.findAll());
            result.setSuccess(true);
//              vm.setEquipErrorList(equipErrorFacade.findById(new Long(SepC.EQP_ROOT)));

        } catch (Exception e) {
            result.anylizeException(e);
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public ExecuteResult onEquipWarn(SepE.ExecuteMode mode, EQP0005ViewModel vm) {
        //先创建一个执行结果的对象，并把mode的放进去
        ExecuteResult result = new ExecuteResult(mode);
        //从视图中取出EquipWarn
        LTEquipWarn target = vm.getEquipWarn();
//        LOG.info(target.getPNmae());
//        LOG.info(target.getENum());
//        LOG.info(target.getPNum());
        try {
            //判断执行模式，如果是INSERT就把数据添加，UPDATE就进行修改，DELETE进行修改。
            switch (mode) {
                case INSERT:
                    equipWarnFacade.create(target);
                    break;
                case UPDATE:
                    equipWarnFacade.edit(target);
                    break;
                case DELETE:
                    equipWarnFacade.remove(target);
                    break;
            }
            //执行结果如果是成功的，转化就设置为true。
            Long id = target.getEId();
            vm.setSelectedEquipBasic(eqpService.find(id));
            result.setSuccess(true);
            //刷新数据后存储到EquipWarn中

        } catch (Exception e) {
            result.anylizeException(e);
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public LTEquipBasic findSelectedEqp(Long id) {
        return eqpService.find(id);
    }

}
