/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianJueSeGuanLi;

import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.MstXunJianRole;
import cn.tst.sbjxzzglxt.entity.XunJianGuiZe;
import java.util.List;

/**
 *
 * @author Aaron-PC-i3-4130
 */
public class ViewModel {
    private List<MstXunJianRole> roleList;
    
    private MstXunJianRole roleInEdit;
    
    private XunJianGuiZe xunJianGuiZeInEdit;

    public XunJianGuiZe getXunJianGuiZeInEdit() {
        return xunJianGuiZeInEdit;
    }

    public void setXunJianGuiZeInEdit(XunJianGuiZe xunJianGuiZeInEdit) {
        this.xunJianGuiZeInEdit = xunJianGuiZeInEdit;
    }

    public MstXunJianRole getRoleInEdit() {
        return roleInEdit;
    }

    public void setRoleInEdit(MstXunJianRole roleInEdit) {
        this.roleInEdit = roleInEdit;
    }

    public List<MstXunJianRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<MstXunJianRole> roleList) {
        this.roleList = roleList;
    }
    
    public SepE.XunJianXunHuanFangShi[] getXunJianXunHuanFangShi() {
        return SepE.XunJianXunHuanFangShi.values();
    }
}
