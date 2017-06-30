package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.SheBeiGuZhangDingYi;

import cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.LuRuRen.*;
import cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXiangMuGuanLi.*;
import cn.tst.sbjxzzglxt.bizlogic.impl.BaseBizLogic;
import cn.tst.sbjxzzglxt.common.EquipmentNodeData;
import cn.tst.sbjxzzglxt.common.EquipmentTree;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.GuZhangShiLi;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipCheckPoint;
import cn.tst.sbjxzzglxt.entity.LTEquipError;
import cn.tst.sbjxzzglxt.entity.LTEquipErrorMessage;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionItems;
import cn.tst.sbjxzzglxt.facade.GuZhangShiLiFacade;
import cn.tst.sbjxzzglxt.facade.LTEquipBasicFacade;
import cn.tst.sbjxzzglxt.facade.LTEquipCheckPointFacade;
import cn.tst.sbjxzzglxt.facade.LTEquipErrorFacade;
import cn.tst.sbjxzzglxt.facade.LTEquipErrorMessageFacade;
import cn.tst.sbjxzzglxt.facade.XunJianXiangMuFacade;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.apache.log4j.Logger;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.TreeNode;

/**
 * 项目管理Service
 *
 * @author Administrator
 */
@Stateless
public class SheBeiGuZhangDingYiBizLogicImplementation extends BaseBizLogic implements BizLogic {

    SysRoutingInspectionItems item = new SysRoutingInspectionItems();
    private static final Logger LOG = Logger.getLogger(SheBeiGuZhangDingYiBizLogicImplementation.class.getName());
    @EJB
    private LTEquipBasicFacade eqpService;
    @EJB
    private LTEquipCheckPointFacade checkPointFacade;
    @EJB
    private XunJianXiangMuFacade itemFacade;
    @EJB
    private GuZhangShiLiFacade guZhangShiLiFacade;
    @EJB
    private LTEquipErrorMessageFacade errorMessageFacade;
    @EJB
    private LTEquipErrorFacade errorFacade;

    @Override
    public void loadViewModel(ViewModel vm) {
        //初始化设备列表
        List<LTEquipBasic> equipList = eqpService.findAll();
        vm.setEquipBasicList(equipList);
        vm.setEquipError(new LTEquipError());
        vm.setErrorMessage(new LTEquipErrorMessage());
        vm.setErrorMessageList(errorMessageFacade.findAll());
        vm.setSelectedCheckPoint(new LTEquipCheckPoint());

    }

    /**
     * 功能作用：点击设备terr节点时，展示对应的巡检记录，同时创建巡检项目对象
     *
     */
    @Override
    public List<LTEquipError> chaGuZhangXinXi(ViewModel vm, Long eNum) {
        LOG.info(eNum);
        if (eNum != null) {
            
            return errorFacade.chaGuZhangLieBiao(eNum);
        } else {
            return null;
        }

    }

    //查询项目信息
    @Override
    public List<SysRoutingInspectionItems> chaXiangMu(Integer id) {
        List<SysRoutingInspectionItems> findAll = itemFacade.findByCheckPointId(id);
        return findAll;
    }

    //查询巡检点信息
    @Override
    public List<LTEquipCheckPoint> chaXinXi() {
        return checkPointFacade.findAll();
    }

    //显示全部故障信息
    @Override
    public void xuanZeGuZhang(ViewModel vm) {
        vm.setErrorMessageList(errorMessageFacade.findAll());
    }

    //增删改故障信息
    @Override
    public ExecuteResult onErrorMessage(SepE.ExecuteMode mode, ViewModel vm) {
        //先创建一个执行结果的对象，并把mode的放进去
        ExecuteResult result = new ExecuteResult(mode);
        //从视图中取出EquipWarn
        LTEquipErrorMessage target = vm.getErrorMessage();
        try {
            //判断执行模式，如果是INSERT就把数据添加，UPDATE就进行修改，DELETE进行修改。
            switch (mode) {
                case INSERT:
                    errorMessageFacade.create(target);
                    break;
                case UPDATE:
                    errorMessageFacade.edit(target);
                    break;
                case DELETE:
                    errorMessageFacade.remove(target);
                    break;
            }
            //执行结果如果是成功的，转化就设置为true。

            vm.setErrorMessageList(errorMessageFacade.findAll());
            result.setSuccess(true);

            //刷新数据后存储到EquipWarn中
        } catch (Exception e) {
            result.anylizeException(e);
            result.setSuccess(false);
        }
        return result;
    }

    //增删改故障记录
    @Override
    public ExecuteResult onEquipError(SepE.ExecuteMode mode, ViewModel vm) {
        //先创建一个执行结果的对象，并把mode的放进去
        ExecuteResult result = new ExecuteResult(mode);
        //从视图中取出EquipWarn
        LTEquipError target = vm.getEquipError();
        try {
            //判断执行模式，如果是INSERT就把数据添加，UPDATE就进行修改，DELETE进行修改。
            switch (mode) {
                case INSERT:
                    errorFacade.create(target);
                    break;
                case UPDATE:
                    errorFacade.edit(target);
                    break;
                case DELETE:
                    errorFacade.remove(target);
                    break;
            }
            //执行结果如果是成功的，转化就设置为true。

            Long id = target.getENum();
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
    public void baoCunGuZhang(cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.SheBeiGuZhangDingYi.ViewModel vm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LTEquipBasic findSelectedEqp(Long eNum) {
        Long id = eNum;
        return eqpService.find(id);

    }

    @Override
    public ExecuteResult onXiangMu(SepE.ExecuteMode mode, cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.SheBeiGuZhangDingYi.ViewModel vm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param id
     * @return
     */
     @Override
    public List<LTEquipErrorMessage> chaGuZhangLeiXing(Long id) {
      return errorMessageFacade.findByCId(id);
    }

}
