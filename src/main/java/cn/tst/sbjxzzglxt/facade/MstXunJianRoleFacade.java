/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.facade;

import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.entity.MstXunJianRole;
import org.apache.log4j.Logger;

/**
 *
 * @author 曹春
 */
@Stateless
public class MstXunJianRoleFacade extends AbstractFacade<MstXunJianRole> {

    private static final Logger LOG = Logger.getLogger(MstXunJianRole.class.getName());

    public MstXunJianRoleFacade() {
        super(MstXunJianRole.class);
    }
}
