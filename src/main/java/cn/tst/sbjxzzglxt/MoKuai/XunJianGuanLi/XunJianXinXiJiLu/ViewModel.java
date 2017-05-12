package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXinXiJiLu;

import cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXiangMuWenTi.*;
import cn.tst.sbjxzzglxt.viewmodel.*;
import java.util.List;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipError;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionMessage;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionProblem;
import org.primefaces.model.TreeNode;

/**
 * 巡检信息记录视图
 *
 * @author ps_xy@pscp.co.jp
 */
public class ViewModel extends BaseViewModel {
  private List<LTEquipBasic> equipBasicList;
    private List<SysRoutingInspectionMessage> routingInspectionMessageList;//巡检记录实体类集合
    private SysRoutingInspectionMessage routingInspectionMessage;//巡检记录实体类

    public List<SysRoutingInspectionMessage> getRoutingInspectionMessageList() {
        return routingInspectionMessageList;
    }

    public void setRoutingInspectionMessageList(List<SysRoutingInspectionMessage> routingInspectionMessageList) {
        this.routingInspectionMessageList = routingInspectionMessageList;
    }

    public SysRoutingInspectionMessage getRoutingInspectionMessage() {
        return routingInspectionMessage;
    }

    public void setRoutingInspectionMessage(SysRoutingInspectionMessage routingInspectionMessage) {
        this.routingInspectionMessage = routingInspectionMessage;
    }

    public List<LTEquipBasic> getEquipBasicList() {
        return equipBasicList;
    }

    public void setEquipBasicList(List<LTEquipBasic> equipBasicList) {
        this.equipBasicList = equipBasicList;
    }

   

  

   


}
