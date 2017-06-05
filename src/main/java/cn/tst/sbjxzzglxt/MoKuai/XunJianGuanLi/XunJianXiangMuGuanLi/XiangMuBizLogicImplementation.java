package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXiangMuGuanLi;

import cn.tst.sbjxzzglxt.bizlogic.impl.BaseBizLogic;
import cn.tst.sbjxzzglxt.common.EquipmentNodeData;
import cn.tst.sbjxzzglxt.common.EquipmentTree;
import cn.tst.sbjxzzglxt.entity.LTEquipCheckPoint;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionItems;
import cn.tst.sbjxzzglxt.facade.LTEquipBasicFacade;
import cn.tst.sbjxzzglxt.facade.LTEquipCheckPointFacade;
import cn.tst.sbjxzzglxt.facade.XunJianXiangMuFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.TreeNode;

@Stateless
public class XiangMuBizLogicImplementation extends BaseBizLogic implements BizLogic {

    @EJB
    private LTEquipBasicFacade equipmentFacade;
    @EJB
    private LTEquipCheckPointFacade checkPointFacade;
    @EJB
    private XunJianXiangMuFacade itemFacade;

    @Override
    public void loadViewModel(ViewModel vm) {
        vm.setEquipmentTreeRootNode(EquipmentTree.createEquipmentTreeNodeWithCheckPoint(equipmentFacade.findAll(), -1));
    }

    @Override
    public void onNodeSelect(ViewModel vm, NodeSelectEvent event) {
        TreeNode nodeSelected = event.getTreeNode();
        if (nodeSelected.getType().equals(EquipmentTree.CHECK_POINT_TYPE)) {
            int checkPointId = ((EquipmentNodeData) nodeSelected.getData()).getCheckPointId();
            List<LTEquipCheckPoint> checkPointList = checkPointFacade.findById(checkPointId);
            if (!checkPointList.isEmpty()) {
                vm.setSelectedCheckPoint(checkPointList.get(0));
                vm.setItemList(itemFacade.findByCheckPointId(checkPointId));
            }
        } else {
            vm.setSelectedCheckPoint(null);
            vm.setItemList(null);
        }
    }
    
    @Override
    public void onAddNewItem(ViewModel vm) {
        SysRoutingInspectionItems item = new SysRoutingInspectionItems();
        item.setSuoShuXunJianDianId(vm.getSelectedCheckPoint().getId());
        vm.setItemInEdit(item);
    }
}
