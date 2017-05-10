/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.viewmodel;

import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionItems;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionProblem;

/**
 * 巡检项目问题视图
 * @author Aaron-PC-i3-4130
 */
public class XJ0003ViewModel extends BaseViewModel {
   private SysRoutingInspectionProblem roblemList;//巡检项目问题集合
   private SysRoutingInspectionProblem problem;//巡检项目问题对象

    public SysRoutingInspectionProblem getRoblemList() {
        return roblemList;
    }

    public void setRoblemList(SysRoutingInspectionProblem roblemList) {
        this.roblemList = roblemList;
    }

    public SysRoutingInspectionProblem getProblem() {
        return problem;
    }

    public void setProblem(SysRoutingInspectionProblem problem) {
        this.problem = problem;
    }

  
    
}
