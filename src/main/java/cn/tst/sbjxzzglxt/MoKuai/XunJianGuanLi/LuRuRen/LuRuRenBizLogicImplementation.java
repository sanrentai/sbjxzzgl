package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.LuRuRen;

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
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionMessage;
import cn.tst.sbjxzzglxt.facade.GuZhangShiLiFacade;
import cn.tst.sbjxzzglxt.facade.LTEquipBasicFacade;
import cn.tst.sbjxzzglxt.facade.LTEquipCheckPointFacade;
import cn.tst.sbjxzzglxt.facade.LTEquipErrorMessageFacade;
import cn.tst.sbjxzzglxt.facade.XunJianXiangMuFacade;
import cn.tst.sbjxzzglxt.facade.XunJianXinXiJiLuFacade;
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
public class LuRuRenBizLogicImplementation extends BaseBizLogic implements BizLogic {

    SysRoutingInspectionItems item = new SysRoutingInspectionItems();
    private static final Logger LOG = Logger.getLogger(LuRuRenBizLogicImplementation.class.getName());
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
    private XunJianXinXiJiLuFacade xunJianXinXiJiLuFacade;

    @Override
    public void loadViewModel(ViewModel vm) {
        //初始化设备列表
        List<LTEquipBasic> equipList = eqpService.findAll();
        vm.setEquipBasicList(equipList);
        vm.setSelectedCheckPoint(new LTEquipCheckPoint());

    }

    /**
     * 功能作用：点击设备terr节点时，展示对应的巡检记录，同时创建巡检项目对象
     *
     * @param equipmentId
     */
    @Override
    public List<LTEquipCheckPoint> chaXunJianDian(ViewModel vm, Long equipmentId) {
        LOG.info(equipmentId);
        if (equipmentId != null) {
            SysRoutingInspectionItems item = new SysRoutingInspectionItems();
            vm.setItemInEdit(item);
            return checkPointFacade.chaXunJianDianLieBiao(equipmentId);
        } else {
            return null;
        }

    }

    @Override
    public ExecuteResult onXiangMu(SepE.ExecuteMode mode, ViewModel vm) {
        //先创建一个执行结果的对象，并把mode的放进去
        ExecuteResult result = new ExecuteResult(mode);
        //从视图中取出EquipWarn
        LOG.info(vm.getPatrolRecord().getLuRuRen());
        LOG.info(vm.getPatrolRecord().getXunJianDianId());
        LOG.info(vm.getPatrolRecord().getSuoshushebeiID());
        LOG.info(vm.getPatrolRecord().getXunJianDianXiangMuId());
        LOG.info(vm.getPatrolRecord().getXunJianShiJian());
        LOG.info(vm.getPatrolRecord().getXunJianWenTi());
        LOG.info(vm.getPatrolRecord().getXunJianZhuangTai());
        SysRoutingInspectionMessage target = vm.getPatrolRecord();
        LOG.info(target.getLuRuRen());
        LOG.info(target.getXunJianDianId());
        LOG.info(target.getSuoshushebeiID());
        LOG.info(target.getXunJianDianXiangMuId());
        LOG.info(target.getXunJianShiJian());
        LOG.info(target.getXunJianWenTi());
        LOG.info(target.getXunJianZhuangTai());
        LOG.info(target);
        try {
            //判断执行模式，如果是INSERT就把数据添加，UPDATE就进行修改，DELETE进行修改。
            switch (mode) {
                case INSERT:
                    xunJianXinXiJiLuFacade.create(target);
                    break;
                case UPDATE:
                    xunJianXinXiJiLuFacade.edit(target);
                    break;
                case DELETE:
                    xunJianXinXiJiLuFacade.remove(target);
                    break;
            }
            //执行结果如果是成功的，转化就设置为true。
            Long id = target.getSuoshushebeiID();
            vm.setSelectedEquipBasic(eqpService.find(id));
            result.setSuccess(true);
            //刷新数据后存储到EquipWarn中

        } catch (Exception e) {
            result.anylizeException(e);
            result.setSuccess(false);
        }
        return result;
    }

    //查询设备信息
    @Override
    public LTEquipBasic findSelectedEqp(Long id) {
        return eqpService.find(id);
    }

    //查询项目信息
    @Override
    public List<SysRoutingInspectionItems> chaXiangMu(Integer suoShuXunJianDianId) {
        List<SysRoutingInspectionItems> findAll = itemFacade.findByCheckPointId(suoShuXunJianDianId);
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
        List<LTEquipErrorMessage> list = errorMessageFacade.findAll();
        LOG.info(list);
        vm.getItemInEdit().setFaultMessageList(list);

    }

    @Override
    public void chaGuZhangShiLi(ViewModel vm, Long xiangMuId) {
        
        List< LTEquipErrorMessage> message = new ArrayList();
        //根据项目ID查询故障实例
        List<GuZhangShiLi> chaGuZhang = guZhangShiLiFacade.chaGuZhang(xiangMuId);
        //遍历得到故障实例的对象
        for (GuZhangShiLi g : chaGuZhang) {
            String guZhangId = g.getGuZhangId();
            LOG.info(guZhangId);
            //对字符串进行截取
            String[] split = guZhangId.split(",");
            LOG.info(split);
            for (int i = 0; i < split.length; i++) {
                //把故障ID字符串转化成Long类型
                Long id = Long.parseLong(split[i].trim());
                LOG.info(id);
                //根据故障ID查询故障,把查询结果放到集合中
                List<LTEquipErrorMessage> findByCId = errorMessageFacade.findByCId(id);
                message.add(findByCId.get(0));
            }
           vm.setErrorMessageList(message);
        }
    }

    @Override
    public void baoCunXiangMu(ViewModel vm) {
    
        
    }

  

}
