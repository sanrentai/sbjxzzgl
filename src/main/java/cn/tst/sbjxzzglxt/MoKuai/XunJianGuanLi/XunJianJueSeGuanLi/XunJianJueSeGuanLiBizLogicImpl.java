/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianJueSeGuanLi;

import cn.tst.sbjxzzglxt.bizlogic.impl.BaseBizLogic;
import cn.tst.sbjxzzglxt.common.EquipmentTree;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.XunJianGuiZe;
import cn.tst.sbjxzzglxt.facade.LTEquipBasicFacade;
import cn.tst.sbjxzzglxt.facade.MstXunJianRoleFacade;
import cn.tst.sbjxzzglxt.facade.XunJianGuiZeFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@Stateless
public class XunJianJueSeGuanLiBizLogicImpl extends BaseBizLogic implements BizLogic {
    @EJB
    private MstXunJianRoleFacade xunJianRoleFacade;
    @EJB
    private XunJianGuiZeFacade xunJianGuiZeFacade;
    @EJB
    private LTEquipBasicFacade equipmentFacade;

    public XunJianGuiZeFacade getXunJianGuiZeFacade() {
        return xunJianGuiZeFacade;
    }

    public void setXunJianGuiZeFacade(XunJianGuiZeFacade xunJianGuiZeFacade) {
        this.xunJianGuiZeFacade = xunJianGuiZeFacade;
    }

    public MstXunJianRoleFacade getXunJianRoleFacade() {
        return xunJianRoleFacade;
    }

    public void setXunJianRoleFacade(MstXunJianRoleFacade xunJianRoleFacade) {
        this.xunJianRoleFacade = xunJianRoleFacade;
    }
    
    @Override
    public void loadViewModel(ViewModel vm) {
        vm.setRoleList(xunJianRoleFacade.findAll());
        XunJianGuiZe guiZe = new XunJianGuiZe();
        guiZe.setXunHuanFangShi(SepE.XunJianXunHuanFangShi.NIAN);
        vm.setXunJianGuiZeInEdit(guiZe);
        vm.setEquipmentNodeRoot(EquipmentTree.createEquipmentTreeNodeWithCheckPoint(equipmentFacade.findAll()));
    }
    @Override 
    public void onSubmitNewRole(ViewModel vm) {
        xunJianRoleFacade.create(vm.getRoleInEdit());
        
        XunJianGuiZe guiZe = new XunJianGuiZe();
        guiZe.setRoleId(vm.getRoleInEdit().getRoleId());
        xunJianGuiZeFacade.create(guiZe);
        
        vm.setRoleList(xunJianRoleFacade.findAll());
        vm.setRoleInEdit(null);
    }
    @Override
    public void onEditXunJianGuiZeDialogSubmit(ViewModel vm) {
        System.out.println("RoleID: " + vm.getRoleInEdit().getRoleId());
        XunJianGuiZe xunJianGuiZe = xunJianGuiZeFacade.findByRoleId(vm.getRoleInEdit().getRoleId()).get(0);
        xunJianGuiZe.setXunHuanFangShi(vm.getXunJianGuiZeInEdit().getXunHuanFangShi());
        xunJianGuiZe.setKaiShiShiJian(vm.getXunJianGuiZeInEdit().getKaiShiShiJian());
        xunJianGuiZe.setJieShuShiJian(vm.getXunJianGuiZeInEdit().getJieShuShiJian());
        xunJianGuiZeFacade.edit(xunJianGuiZe);
    }
}
