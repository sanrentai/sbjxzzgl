/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.facade;

import cn.tst.sbjxzzglxt.entity.BaseEntity;
import cn.tst.sbjxzzglxt.entity.RoutingInspectionStatisticsResult;
import java.util.List;

/**
 *
 * @author Aaron-PC-i3-4130
 */
public class RoutingInspectionStatisticsResultFacade extends AbstractFacade<BaseEntity> {
    public RoutingInspectionStatisticsResultFacade() {
        super(BaseEntity.class);
    }
    
    public List<RoutingInspectionStatisticsResult> getResult() {
        return null;
    }
}
