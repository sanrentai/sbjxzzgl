package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXiangMu;

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
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionItems;
import cn.tst.sbjxzzglxt.facade.LTEquipBasicFacade;
import cn.tst.sbjxzzglxt.facade.LTEquipErrorFacade;
import cn.tst.sbjxzzglxt.facade.XunJianXiangMuFacade;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.EQP0001ViewModel;
import cn.tst.sbjxzzglxt.viewmodel.EQP0005ViewModel;
import cn.tst.sbjxzzglxt.viewmodel.EQP0006ViewModel;
import java.util.UUID;
import org.apache.log4j.Logger;

/**
 * 仓库信息业务逻辑实现类
 *
 * @author ps_xy@pscp.co.jp
 */
@Stateless
public class XiangMuBizLogicImplementation extends BaseBizLogic implements BizLogic {

    private static final Logger LOG = Logger.getLogger(XiangMuBizLogicImplementation.class.getName());
    @EJB
    private XunJianXiangMuFacade xiangMuFacade;
    @EJB
    private LTEquipBasicFacade eqpService;

    //这里是初始化视图，根据ID把记录信息查询出来，保存到集合内用于页面调用，否则会空
    @Override
    public void loadViewModel(ViewModel vm) {

        List<SysRoutingInspectionItems> equip = xiangMuFacade.findAll();
        vm.setRoutingInspectionItemsList(equip);
        List<LTEquipBasic> findAll = eqpService.findAll();
        vm.setEquipBasicList(findAll);
    }

    @Override
    public ExecuteResult onSaveEquipment(SepE.ExecuteMode mode, ViewModel vm) {

        ExecuteResult result = new ExecuteResult(mode);
        SysRoutingInspectionItems target = vm.getRoutingInspectionItems();
        try {
            switch (mode) {
                case INSERT:
//                    target.setId(UUID.randomUUID().toString());
                    xiangMuFacade.create(target);
                    break;
                case UPDATE:
                    xiangMuFacade.edit(target);
                    break;
                case DELETE:
                    LOG.info("删除开始");
                    xiangMuFacade.remove(target);
                    LOG.info("删除结束");
                    break;
            }
            vm.setRoutingInspectionItemsList(xiangMuFacade.findAll());
            result.setSuccess(true);
//              vm.setEquipErrorList(equipErrorFacade.findById(new Long(SepC.EQP_ROOT)));

        } catch (Exception e) {
            result.anylizeException(e);
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public ExecuteResult onXunJianXiangMu(SepE.ExecuteMode mode, ViewModel vm) {
        //先创建一个执行结果的对象，并把mode的放进去
        ExecuteResult result = new ExecuteResult(mode);
        //从视图中取出EquipWarn
        SysRoutingInspectionItems target = vm.getRoutingInspectionItems();

        try {
            //判断执行模式，如果是INSERT就把数据添加，UPDATE就进行修改，DELETE进行修改。
            switch (mode) {
                case INSERT:
                    xiangMuFacade.create(target);
                    break;
                case UPDATE:
                    xiangMuFacade.edit(target);
                    break;
                case DELETE:
                    xiangMuFacade.remove(target);
                    break;
            }
            //执行结果如果是成功的，转化就设置为true。

            vm.setRoutingInspectionItemsList(xiangMuFacade.findAll());
            result.setSuccess(true);
            //刷新数据后存储到EquipWarn中

        } catch (Exception e) {
            result.anylizeException(e);
            result.setSuccess(false);
        }
        return result;
    }

}
