/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.facade;

import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionMessage;
import javax.ejb.Stateless;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@Stateless
public class SysRoutingInspectionMessageFacade extends AbstractFacade<SysRoutingInspectionMessage> {
    public SysRoutingInspectionMessageFacade() {
        super(SysRoutingInspectionMessage.class);
    }
}
