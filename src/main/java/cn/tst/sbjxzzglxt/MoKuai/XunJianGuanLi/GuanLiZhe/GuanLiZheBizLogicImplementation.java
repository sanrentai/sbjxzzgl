package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.GuanLiZhe;

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
public class GuanLiZheBizLogicImplementation extends BaseBizLogic implements BizLogic {

    SysRoutingInspectionItems item = new SysRoutingInspectionItems();
    private static final Logger LOG = Logger.getLogger(GuanLiZheBizLogicImplementation.class.getName());
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
        SysRoutingInspectionItems target = vm.getItemInEdit();
//        LOG.info(target.getPNmae());
//        LOG.info(target.getENum());
//        LOG.info(target.getPNum());
        try {
            //判断执行模式，如果是INSERT就把数据添加，UPDATE就进行修改，DELETE进行修改。
            switch (mode) {
                case INSERT:
                    itemFacade.create(target);
                    break;
                case UPDATE:
                    itemFacade.edit(target);
                    break;
                case DELETE:
                    itemFacade.remove(target);
                    break;
            }
            //执行结果如果是成功的，转化就设置为true。
            Long id = target.getSuoShuSheBeiId();
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
        List<LTEquipErrorMessage> list = errorMessageFacade.findAll();
        LOG.info(list);
        vm.getItemInEdit().setFaultMessageList(list);

    }

    //把项目ID和故障ID保存到故障实例的表里面
    @Override
    public void baoCunGuZhang(ViewModel vm) {

    }

    /**
     * 功能目的：用于保存页面新建的项目表单
     *
     * @param vm
     * @param id
     */
    @Override
    public void baoCunXiangMu(ViewModel vm) {
        Long id = vm.getItemInEdit().getId();
        GuZhangShiLi guZhangShiLi = new GuZhangShiLi();
        if (id == null) {

            SysRoutingInspectionItems target = vm.getItemInEdit();
            /// vm.getItemList() 升序排列
            if (vm.getItemList() == null || vm.getItemList().isEmpty()) {

            } else {
                for (SysRoutingInspectionItems item : vm.getItemList()) {
                    if (item.getXunJianShunXu() >= target.getXunJianShunXu()) {
                        item.setXunJianShunXu(item.getXunJianShunXu() + 1);
                    }
                }
                itemFacade.editList(vm.getItemList());

            }
            itemFacade.create(target);

            if (target.getId() != null && target.getDuiYingGuZhang() != null) {
                LOG.info(target.getId());
                LOG.info(target.getDuiYingGuZhang());
                guZhangShiLi.setXiangMuId(target.getId().intValue());
                guZhangShiLi.setGuZhangId(target.getDuiYingGuZhang());
                LOG.info(guZhangShiLi);
                guZhangShiLiFacade.create(guZhangShiLi);
            }

        } else {
            SysRoutingInspectionItems items = itemFacade.find(id);
            items.setSuoShuSheBeiId(vm.getItemInEdit().getSuoShuSheBeiId());
            items.setSuoShuXunJianDianId(vm.getItemInEdit().getSuoShuXunJianDianId());
            items.setXiangMuMingCheng(vm.getItemInEdit().getXiangMuMingCheng());
            items.setXunJianFangShi(SepE.XunJianFangShi.parse(vm.getXuanZe()));
            items.setBoDongShangXian(vm.getItemInEdit().getBoDongShangXian());
            items.setBoDongXiaXian(vm.getItemInEdit().getBoDongXiaXian());
            items.setDuiYingGuZhang(vm.getItemInEdit().getDuiYingGuZhang());
            items.setXiangMuShuoMing(vm.getItemInEdit().getXiangMuShuoMing());
            itemFacade.edit(items);
            if (items.getId() != null && items.getDuiYingGuZhang() != null) {
                LOG.info(items.getId());
                LOG.info(items.getDuiYingGuZhang());
               List<GuZhangShiLi> guZhangList = guZhangShiLiFacade.chaGuZhang(items.getId());
               for(GuZhangShiLi s:guZhangList){
                   GuZhangShiLi s1 = s;
                   s.setXiangMuId(items.getId().intValue());
                   s.setGuZhangId(items.getDuiYingGuZhang());
                   guZhangShiLiFacade.edit(s1);
               }
                
            }

        }
    }

//    @Override
//    public List<String> chaGuZhangMing(ArrayList list) {
//        ArrayList<String> linShiList = new ArrayList();
//        for(Object s : list){
//            Long id = (Long)s;
//            LOG.info(s);
//            LOG.info(id);
//            //根据每次遍历出来的ID查询故障名字
//            List<LTEquipErrorMessage> findById = errorMessageFacade.findById(id);
//            String guZhangMingCheng = findById.get(0).getGuZhangMingCheng();
//            linShiList.add(guZhangMingCheng);
//        } 
//        return linShiList;
//    }
}
