package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXinXiJiLu;

import cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXiangMuWenTi.*;
import cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXiangMu.*;
import cn.tst.sbjxzzglxt.bizlogic.impl.*;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.bizlogic.EQP0001BizLogic;
import cn.tst.sbjxzzglxt.bizlogic.EQP0006BizLogic;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipError;
import cn.tst.sbjxzzglxt.entity.LTEquipWarn;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionMessage;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionProblem;
import cn.tst.sbjxzzglxt.facade.LTEquipBasicFacade;
import cn.tst.sbjxzzglxt.facade.LTEquipErrorFacade;
import cn.tst.sbjxzzglxt.facade.XunJianXiangMuWenTiFacade;
import cn.tst.sbjxzzglxt.facade.XunJianXinXiJiLuFacade;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.EQP0001ViewModel;
import cn.tst.sbjxzzglxt.viewmodel.EQP0005ViewModel;
import cn.tst.sbjxzzglxt.viewmodel.EQP0006ViewModel;
import java.util.UUID;
import org.apache.log4j.Logger;

/**
 * 巡检信息记录接口实现类
 *
 * @author ps_xy@pscp.co.jp
 */
@Stateless
public class JiLuBizLogicImplementation extends BaseBizLogic implements BizLogic {

    private static final Logger LOG = Logger.getLogger(JiLuBizLogicImplementation.class.getName());
    @EJB
    private XunJianXinXiJiLuFacade xinXiJiLuFacade;
@EJB
    private LTEquipBasicFacade eqpService;
    //这里是初始化视图，根据ID把记录信息查询出来，保存到集合内用于页面调用，否则会空
 
    @Override
    public void loadViewModel(ViewModel vm) {
//        vm.setEquipErrorList(equipErrorFacade.findById(Long.MIN_VALUE));
        List<SysRoutingInspectionMessage> message = xinXiJiLuFacade.findAll();
        vm.setRoutingInspectionMessageList(message);
          List<LTEquipBasic> findAll = eqpService.findAll();
        vm.setEquipBasicList(findAll);
    }

    public ExecuteResult onSaveEquipment(SepE.ExecuteMode mode, ViewModel vm) {
       
        ExecuteResult result = new ExecuteResult(mode);
        SysRoutingInspectionMessage target = vm.getRoutingInspectionMessage();
       
        try {
            switch (mode) {
                case INSERT:
//                    target.setId(UUID.randomUUID().toString());
                   xinXiJiLuFacade.create(target);
                    break;
                case UPDATE:
                    xinXiJiLuFacade.edit(target);
                    break;
                case DELETE:
                    LOG.info("删除开始");
                   xinXiJiLuFacade.remove(target);
                    LOG.info("删除结束");
                    break;
            }
            vm.setRoutingInspectionMessageList(xinXiJiLuFacade.findAll());
            result.setSuccess(true);
//              vm.setEquipErrorList(equipErrorFacade.findById(new Long(SepC.EQP_ROOT)));

        } catch (Exception e) {
            result.anylizeException(e);
            result.setSuccess(false);
        }
        return result;
    }
    
    @Override
    public ExecuteResult onXunJianJiLu(SepE.ExecuteMode mode, ViewModel vm) {
        //先创建一个执行结果的对象，并把mode的放进去
        ExecuteResult result = new ExecuteResult(mode);
        //从视图中取出EquipWarn
        SysRoutingInspectionMessage target = vm.getRoutingInspectionMessage();
        
        try {
            //判断执行模式，如果是INSERT就把数据添加，UPDATE就进行修改，DELETE进行修改。
            switch (mode) {
                case INSERT:
                    xinXiJiLuFacade.create(target);
                    break;
                case UPDATE:
                   xinXiJiLuFacade.edit(target);
                    break;
                case DELETE:
                   xinXiJiLuFacade.remove(target);
                    break;
            }
            //执行结果如果是成功的，转化就设置为true。

            vm.setRoutingInspectionMessageList(xinXiJiLuFacade.findAll());
            result.setSuccess(true);
            //刷新数据后存储到EquipWarn中

        } catch (Exception e) {
            result.anylizeException(e);
            result.setSuccess(false);
        }
        return result;
    }

}
