package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXiangMu;

import cn.tst.sbjxzzglxt.viewmodel.*;
import java.util.List;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipCheckPoint;
import cn.tst.sbjxzzglxt.entity.LTEquipError;
import cn.tst.sbjxzzglxt.entity.LTEquipGraphic;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionItems;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionSite;
import org.primefaces.model.TreeNode;

/**
 * 巡检项目视图
 *
 * @author ps_xy@pscp.co.jp
 */
public class ViewModel extends BaseViewModel {

    private List<LTEquipError> equipErrorList;//用于取故障名称
    private SysRoutingInspectionSite site;//用于取巡检点信息
    private List<SysRoutingInspectionSite> siteList;//用于取巡检点信息
    private List<LTEquipBasic> equipBasicList;//用于取设备名称;
    private List<LTEquipBasic> selectEquipBasicList;//用于选中节点
    private LTEquipBasic equipBasic;//在视图内添加设备实体类，用于xhml前端取设备名称
    private List<SysRoutingInspectionItems> routingInspectionItemsList;//巡检项目实体类集合
    private SysRoutingInspectionItems routingInspectionItems;//巡检项目实体类
    private List<LTEquipError> selectErrorList;//用于弹窗选择故障
    private LTEquipError selectequipError;//用于弹窗选择故障
    private LTEquipBasic selectedEquipBasic;
    private List<LTEquipCheckPoint> checkPointList;//巡检点
    private List<LTEquipCheckPoint> selectCheckPointList;//项目巡检信息表
    private LTEquipCheckPoint selectCheckPoint;

    public LTEquipCheckPoint getSelectCheckPoint() {
        return selectCheckPoint;
    }

    public void setSelectCheckPoint(LTEquipCheckPoint selectCheckPoint) {
        this.selectCheckPoint = selectCheckPoint;
    }

   
    
    
    private String currentError;//当前选中故障

    public List<LTEquipCheckPoint> getSelectCheckPointList() {
        return selectCheckPointList;
    }

    public void setSelectCheckPointList(List<LTEquipCheckPoint> selectCheckPointList) {
        this.selectCheckPointList = selectCheckPointList;
    }

    
    
    public List<LTEquipCheckPoint> getCheckPointList() {
        return checkPointList;
    }

    public void setCheckPointList(List<LTEquipCheckPoint> checkPointList) {
        this.checkPointList = checkPointList;
    }
    
    
    
    
    public String getCurrentError() {
        return currentError;
    }

    public void setCurrentError(String currentError) {
        this.currentError = currentError;
    }

    public LTEquipBasic getSelectedEquipBasic() {
        return selectedEquipBasic;
    }

    public void setSelectedEquipBasic(LTEquipBasic selectedEquipBasic) {
        this.selectedEquipBasic = selectedEquipBasic;
    }

    public List<LTEquipError> getSelectErrorList() {
        return selectErrorList;
    }

    public void setSelectErrorList(List<LTEquipError> selectErrorList) {
        this.selectErrorList = selectErrorList;
    }

    public LTEquipError getSelectequipError() {
        return selectequipError;
    }

    public void setSelectequipError(LTEquipError selectequipError) {
        this.selectequipError = selectequipError;
    }

    public SysRoutingInspectionSite getSite() {
        return site;
    }

    public void setSite(SysRoutingInspectionSite site) {
        this.site = site;
    }

    public List<LTEquipBasic> getSelectEquipBasicList() {
        return selectEquipBasicList;
    }

    public void setSelectEquipBasicList(List<LTEquipBasic> selectEquipBasicList) {
        this.selectEquipBasicList = selectEquipBasicList;
    }

    public List<SysRoutingInspectionItems> getRoutingInspectionItemsList() {
        return routingInspectionItemsList;
    }

    public void setRoutingInspectionItemsList(List<SysRoutingInspectionItems> routingInspectionItemsList) {
        this.routingInspectionItemsList = routingInspectionItemsList;
    }

    public SysRoutingInspectionItems getRoutingInspectionItems() {
        return routingInspectionItems;
    }

    public void setRoutingInspectionItems(SysRoutingInspectionItems routingInspectionItems) {
        this.routingInspectionItems = routingInspectionItems;
    }

    public LTEquipBasic getEquipBasic() {
        return equipBasic;
    }

    public void setEquipBasic(LTEquipBasic equipBasic) {
        this.equipBasic = equipBasic;

    }

    public List<LTEquipBasic> getEquipBasicList() {
        return equipBasicList;
    }

    public void setEquipBasicList(List<LTEquipBasic> equipBasicList) {
        this.equipBasicList = equipBasicList;
    }

    public List<SysRoutingInspectionSite> getSiteList() {
        return siteList;
    }

    public void setSiteList(List<SysRoutingInspectionSite> siteList) {
        this.siteList = siteList;
    }

    public List<LTEquipError> getEquipErrorList() {
        return equipErrorList;
    }

    public void setEquipErrorList(List<LTEquipError> equipErrorList) {
        this.equipErrorList = equipErrorList;

    }
 
}
