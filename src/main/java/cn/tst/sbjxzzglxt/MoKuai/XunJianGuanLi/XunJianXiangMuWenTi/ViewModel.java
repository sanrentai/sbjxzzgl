package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXiangMuWenTi;

import cn.tst.sbjxzzglxt.viewmodel.*;
import java.util.List;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipError;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionItems;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionProblem;
import org.primefaces.model.TreeNode;

/**
 * 巡检项目问题视图
 *
 * @author ps_xy@pscp.co.jp
 */
public class ViewModel extends BaseViewModel {

    private List<LTEquipBasic> equipBasicList;
    private List<SysRoutingInspectionProblem> routingInspectionProblemList;//巡检项目问题实体类集合
    private SysRoutingInspectionProblem routingInspectionProblem;//巡检项目问题实体类
    private List<SysRoutingInspectionItems> routingInspectionItemsList;

    public List<SysRoutingInspectionItems> getRoutingInspectionItemsList() {
        return routingInspectionItemsList;
    }

    public void setRoutingInspectionItemsList(List<SysRoutingInspectionItems> routingInspectionItemsList) {
        this.routingInspectionItemsList = routingInspectionItemsList;
    }

    

    public List<SysRoutingInspectionProblem> getRoutingInspectionProblemList() {
        return routingInspectionProblemList;
    }

    public void setRoutingInspectionProblemList(List<SysRoutingInspectionProblem> routingInspectionProblemList) {
        this.routingInspectionProblemList = routingInspectionProblemList;
    }

    public SysRoutingInspectionProblem getRoutingInspectionProblem() {
        return routingInspectionProblem;
    }

    public void setRoutingInspectionProblem(SysRoutingInspectionProblem routingInspectionProblem) {
        this.routingInspectionProblem = routingInspectionProblem;
    }

    public List<LTEquipBasic> getEquipBasicList() {
        return equipBasicList;
    }

    public void setEquipBasicList(List<LTEquipBasic> equipBasicList) {
        this.equipBasicList = equipBasicList;
    }

}
