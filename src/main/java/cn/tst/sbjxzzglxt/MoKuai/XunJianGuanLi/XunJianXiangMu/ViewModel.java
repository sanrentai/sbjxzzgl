package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXiangMu;

import cn.tst.sbjxzzglxt.viewmodel.*;
import java.util.List;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
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
  
    private SysRoutingInspectionSite site;//用于取巡检点信息
    private List<SysRoutingInspectionSite> siteList;//用于取巡检点信息
    private List<LTEquipBasic> equipBasicList;//用于取设备名称;
    private List<LTEquipBasic> selectEquipBasicList;//用于选中节点
    private LTEquipBasic equipBasic;//在视图内添加设备实体类，用于xhml前端取设备名称
    private List<SysRoutingInspectionItems> routingInspectionItemsList;//巡检项目实体类集合
    private SysRoutingInspectionItems routingInspectionItems;//巡检项目实体类
    private TreeNode equipTreeRoot;//页面左侧Tree结构的对象
    ///选中的节点
    private TreeNode selectedNode;

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
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
  
    
    public TreeNode getEquipTreeRoot() {
        return equipTreeRoot;
    }

    public void setEquipTreeRoot(TreeNode equipTreeRoot) {
        this.equipTreeRoot = equipTreeRoot;
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

  

   


}
