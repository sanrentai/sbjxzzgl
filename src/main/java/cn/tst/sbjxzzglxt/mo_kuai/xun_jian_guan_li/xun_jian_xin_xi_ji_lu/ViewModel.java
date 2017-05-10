/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.mo_kuai.xun_jian_guan_li.xun_jian_xin_xi_ji_lu;

import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionItems;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionMessage;
import cn.tst.sbjxzzglxt.viewmodel.BaseViewModel;

/**
 *  巡检信息列表
 * @author Aaron-PC-i3-4130
 */
public class ViewModel extends BaseViewModel {
   private SysRoutingInspectionMessage messageList;//巡检信息列表集合
   private SysRoutingInspectionMessage message;//巡检信息列表对象

    public SysRoutingInspectionMessage getMessageList() {
        return messageList;
    }

    public void setMessageList(SysRoutingInspectionMessage messageList) {
        this.messageList = messageList;
    }

    public SysRoutingInspectionMessage getMessage() {
        return message;
    }

    public void setMessage(SysRoutingInspectionMessage message) {
        this.message = message;
    }

   
    
}
