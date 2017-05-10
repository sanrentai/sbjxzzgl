/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.viewmodel;

import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionItems;

/**
 *  巡检项目视图
 * @author Aaron-PC-i3-4130
 */
public class XJ0001ViewModel extends BaseViewModel {
   private SysRoutingInspectionItems itemsList;//巡检项目集合
   private SysRoutingInspectionItems items;//巡检项目对象

    public SysRoutingInspectionItems getItemsList() {
        return itemsList;
    }

    public void setItemsList(SysRoutingInspectionItems itemsList) {
        this.itemsList = itemsList;
    }

    public SysRoutingInspectionItems getItems() {
        return items;
    }

    public void setItems(SysRoutingInspectionItems items) {
        this.items = items;
    }
    
}
