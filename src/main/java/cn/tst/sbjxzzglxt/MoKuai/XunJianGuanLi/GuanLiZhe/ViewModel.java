/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.GuanLiZhe;

import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionMessage;
import java.util.List;

/**
 *
 * @author Aaron-PC-i3-4130
 */
public class ViewModel {
    private List<SysRoutingInspectionMessage> routingInspectionMessageList;

    public List<SysRoutingInspectionMessage> getRoutingInspectionMessageList() {
        return routingInspectionMessageList;
    }

    public void setRoutingInspectionMessageList(List<SysRoutingInspectionMessage> routingInspectionMessageList) {
        this.routingInspectionMessageList = routingInspectionMessageList;
    }
}
