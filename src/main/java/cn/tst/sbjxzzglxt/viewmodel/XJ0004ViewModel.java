/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.viewmodel;

import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionItems;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionSite;

/**
 *  巡检点视图
 * @author Aaron-PC-i3-4130
 */
public class XJ0004ViewModel extends BaseViewModel {
   private SysRoutingInspectionSite SiteList;//巡检项目集合
   private SysRoutingInspectionSite Site;//巡检项目对象

    public SysRoutingInspectionSite getSiteList() {
        return SiteList;
    }

    public void setSiteList(SysRoutingInspectionSite SiteList) {
        this.SiteList = SiteList;
    }

    public SysRoutingInspectionSite getSite() {
        return Site;
    }

    public void setSite(SysRoutingInspectionSite Site) {
        this.Site = Site;
    }

   
    
}
