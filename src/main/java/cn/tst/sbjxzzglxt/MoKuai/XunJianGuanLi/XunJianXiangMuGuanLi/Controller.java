package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXiangMuGuanLi;

import cn.tst.sbjxzzglxt.common.EquipmentNodeData;
import cn.tst.sbjxzzglxt.common.EquipmentTree;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import cn.tst.sbjxzzglxt.entity.LTEquipCheckPoint;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionItems;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.TreeNode;

@ViewScoped
@Named(SepC.ControllerID.XUN_JIAN_XIANG_MU_GUAN_LI_CONTROLLER_NAME)
public class Controller extends BusinessBaseController {

    private static final Logger LOG = Logger.getLogger(Controller.class.getName());
    private ViewModel vm;
    ///选中的节点
    private TreeNode selectedNode;
    @EJB
    private BizLogic bizLogic;

    @PostConstruct
    public void init() {
        this.vm = new ViewModel();
        this.bizLogic.loadViewModel(vm);
        //初始化树结构并把设备的值挂在树节点上
        vm.setEquipTreeRoot(EquipmentTree.createEqpTree(vm.getEquipBasicList()));
    }

    /**
     * 选中节点时
     *
     * @param event
     */
    public void onNodeSelect(NodeSelectEvent event) {
        //选择的设备节点
        this.selectedNode = event.getTreeNode();
        //得到设备信息
        Long equipmentId = ((EquipmentNodeData) selectedNode.getData()).getEquipment().getId();
        vm.setSelectedEquipBasic(bizLogic.findSelectedEqp(equipmentId));
        //得到巡检点信息表
        List<LTEquipCheckPoint> list = bizLogic.chaXunJianDian(vm, equipmentId);
        vm.setSelectedCheckPointList(list);
        vm.setGuZhangId(null);

    }

    /**
     * 修改巡检项目
     *
     *
     * @param item
     */
    public void xiuGaiXiangMu(SysRoutingInspectionItems item) {
        vm.getItemInEdit().setId(item.getId());
    }

    /**
     * 删除巡检项目
     *
     *
     * @param item
     */
    public void ShanChuXiangMu(SysRoutingInspectionItems item) {
        ///删除模式
        SepE.ExecuteMode mode = SepE.ExecuteMode.DELETE;
        vm.setItemInEdit(item);
      

        ///执行更新
        ExecuteResult result = this.bizLogic.onXiangMu(mode, vm);

        if (result.isSuccess()) {
            putInfoMessage("删除成功");
            vm.setItemInEdit(null);
            vm.setItemList(bizLogic.chaXiangMu(vm.getXunJianDianId()));
        } else {
            putErrorMessage("删除失败");
        }
    }

    //巡检方式监听事件
    public void onXunJianFangShi() {
        //从选择方式按钮取到值
        int xuanze = vm.getXuanZe();
        LOG.info(xuanze);
        if (xuanze == 0) {
            vm.setXuanZeFangShi(0);
        } else if (xuanze == 1) {
            vm.setXuanZeFangShi(1);
        }
        bizLogic.xuanZeGuZhang(vm);

    }

    //保存巡检项目
    public void onSaveData() {
        vm.getItemInEdit().setId(vm.getItemInEdit().getId());
        vm.getItemInEdit().setSuoShuSheBeiId(vm.getSelectedEquipBasic().getId());
        vm.getItemInEdit().setSuoShuXunJianDianId(vm.getXunJianDianId());
        vm.getItemInEdit().setBoDongShangXian(vm.getBoDongShangXian());
        vm.getItemInEdit().setBoDongXiaXian(vm.getBoDongXiaXian());
        vm.getItemInEdit().setXiangMuShuoMing(vm.getXiangMuShuoMing());
        vm.getItemInEdit().setDuiYingGuZhang(vm.getGuZhangId());
//        vm.setXuanZe();
        vm.getItemInEdit().setXunJianFangShi(SepE.XunJianFangShi.parse(vm.getXuanZe()));
        LOG.info(vm.getItemInEdit().getXunJianShunXu());
        bizLogic.baoCunXiangMu(vm);
        vm.setItemList(bizLogic.chaXiangMu(vm.getXunJianDianId()));
        vm.setItemInEdit(null);
        vm.setGuZhangId(null);

    }

    //取消巡检项目
    public void onCancelEdit() {
        vm.setItemList(null);
    }

    //设置项目
    public void onSettings(LTEquipCheckPoint checkPoint) {
        String name = checkPoint.getName();
        Integer id = checkPoint.getId();
        LOG.info(name);
        vm.setName(name);
        vm.setXunJianDianId(id);
        vm.setSelectedCheckPointList(null);
        vm.setItemList(bizLogic.chaXiangMu(id));

    }

    //保存故障
    public void baoCunGuZhang() {
        //通过字符串拼接，形成想要的ID字符串
        StringBuilder sb = new StringBuilder();
        //取出页面存储故障ID的集合
        ArrayList list = vm.getGuZhangJiHe();
        LOG.info(list);
        //每次循环的时候，把字符串遍历出来的字符串进行拼接
        for (int k = 0; k <= list.size() - 1; k++) {
            //通过字符串截取，截取到“=”后面的数字，然后在进行拼接
            sb.append(StringUtils.substringBetween(list.get(k).toString(), "=", "]"));
            if (k < list.size() - 1) {
                sb.append(",");
            }
        }

        LOG.info(sb.toString());
        //把拼接好的字符串存入到VM当中，页面选择故障会调用
        vm.setGuZhangId(sb.toString());
     
    }

//    public void guZhang(){
//     //通过字符串拼接，形成想要的ID字符串
//        StringBuilder sb = new StringBuilder();
//        //取出页面存储故障ID的集合
//        ArrayList list = vm.getGuZhangJiHe();
//        
//        //查询故障名称
//        List<String> nameList= bizLogic.chaGuZhangMing(list);
//        for(int i=0;i<=nameList.size()-1;i++){
//            LOG.info(i);
//            sb.append(nameList.get(i));
//            if (i < list.size() - 1) {
//                sb.append(",");
//            }
//        }
//         LOG.info(sb.toString());
//         vm.setGuZhangMingChen(sb.toString());
//    }
    
    //取消故障
    public void quXiaoGuZhang() {
        StringBuilder sb = new StringBuilder();
        vm.setGuZhangId(sb.toString());
    }

    public ViewModel getVm() {
        return vm;
    }

    public void setVm(ViewModel vm) {
        this.vm = vm;
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

}
