/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianJueSeGuanLi;

import cn.tst.sbjxzzglxt.bizlogic.impl.BaseBizLogic;
import cn.tst.sbjxzzglxt.common.EquipmentNodeData;
import cn.tst.sbjxzzglxt.common.EquipmentTree;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.MstXunJianRole;
import cn.tst.sbjxzzglxt.entity.XunJianDianQuanXian;
import cn.tst.sbjxzzglxt.entity.XunJianGuiZe;
import cn.tst.sbjxzzglxt.facade.LTEquipBasicFacade;
import cn.tst.sbjxzzglxt.facade.MstXunJianRoleFacade;
import cn.tst.sbjxzzglxt.facade.XunJianDianQuanXianFacade;
import cn.tst.sbjxzzglxt.facade.XunJianGuiZeFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.primefaces.model.TreeNode;

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
    @EJB
    private XunJianDianQuanXianFacade xunJianDianQuanXianFacade;

    private MstXunJianRole currentRole;

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
        guiZe.setXunHuanFangShi(SepE.XunJianXunHuanFangShi.NIAN.getValue());
        vm.setXunJianGuiZeInEdit(guiZe);
    }

    @Override
    public void onSubmitNewRole(ViewModel vm) {
        xunJianRoleFacade.create(vm.getRoleInEdit());
        vm.setRoleList(xunJianRoleFacade.findAll());
        vm.setRoleInEdit(null);
    }

    @Override
    public void onEditXunJianGuiZeDialogSubmit(ViewModel vm) {
        List<XunJianGuiZe> xunJianGuiZeList = xunJianGuiZeFacade.findByRoleId(vm.getCurrentRole().getRoleId());
        if (xunJianGuiZeList.isEmpty()) {
            XunJianGuiZe xunJianGuiZe = new XunJianGuiZe();
            xunJianGuiZe.setRoleId(vm.getCurrentRole().getRoleId());
            xunJianGuiZe.setXunHuanFangShi(vm.getXunJianGuiZeInEdit().getXunHuanFangShi());
            xunJianGuiZe.setKaiShiShiJian(vm.getXunJianGuiZeInEdit().getKaiShiShiJian());
            xunJianGuiZe.setJieShuShiJian(vm.getXunJianGuiZeInEdit().getJieShuShiJian());
            xunJianGuiZeFacade.create(xunJianGuiZe);
        } else {
            XunJianGuiZe xunJianGuiZe = xunJianGuiZeList.get(0);
            xunJianGuiZe.setXunHuanFangShi(vm.getXunJianGuiZeInEdit().getXunHuanFangShi());
            xunJianGuiZe.setKaiShiShiJian(vm.getXunJianGuiZeInEdit().getKaiShiShiJian());
            xunJianGuiZe.setJieShuShiJian(vm.getXunJianGuiZeInEdit().getJieShuShiJian());
            xunJianGuiZeFacade.edit(xunJianGuiZe);
        }
    }

    /* @调用时机 当编辑巡检范围对话框提交时的回调
     * @功能目标 将对话框里选中的多选框对应的roleId和checkPointId存入数据库
     * @步骤 1. 清除当前角色对应的所有巡检点权限
     *      2. 将选中的巡检点权限插入数据库
     */
    @Override
    public void onEditXunJianFanWeiDialogSubmit(ViewModel vm) {
        // 1. 清除当前角色对应的所有巡检点权限
        xunJianDianQuanXianFacade.removeByRoleId(currentRole.getRoleId());
        // 2. 将选中的巡检点权限插入数据库
        TreeNode root = vm.getEquipmentNodeRoot();
        for (TreeNode node : vm.getSelectedEquipmentNodeArray()) {
            if (node.getType().equals(EquipmentTree.CHECK_POINT_TYPE)) {
                XunJianDianQuanXian xunJianDianQuanXian = new XunJianDianQuanXian();
                xunJianDianQuanXian.setRoleId(((EquipmentNodeData) node.getData()).getRoleId());
                xunJianDianQuanXian.setCheckPointId(((EquipmentNodeData) node.getData()).getCheckPointId());
                xunJianDianQuanXianFacade.create(xunJianDianQuanXian);
            }
        }
    }

    /* @调用时机 开始编辑巡检范围时回调
    *  @功能目标 或得当前角色的各个巡检点的权限，并编辑权限
    *  @步骤 1. 创建设备节点树
    *        2. 从数据库中读取当前角色的所有巡检点权限，如果没读取到任何数据则对每个巡检点采用默认权限，即不巡检；
    *           如果读取到数据，则将结果反映到多选按钮
     */
    @Override
    public void onEditXunJianFanWei(ViewModel vm, MstXunJianRole currentRole) {
        this.currentRole = currentRole;
        // 创建设备节点树
        vm.setEquipmentNodeRoot(EquipmentTree.createEquipmentTreeNodeWithCheckPoint(equipmentFacade.findAll(), currentRole.getRoleId()));
        // 反映到多选按钮
        List<XunJianDianQuanXian> xunJianDianQuanXianList = xunJianDianQuanXianFacade.findByRoleId(currentRole.getRoleId());
        List<TreeNode> nodesSelectedList = new ArrayList();
        if (xunJianDianQuanXianList != null) {
            TreeNode rootNode = vm.getEquipmentNodeRoot();
            for (XunJianDianQuanXian xunJianDianQuanXian : xunJianDianQuanXianList) {
                TreeNode node = findTreeNodeByCheckPointId(rootNode, xunJianDianQuanXian.getCheckPointId());
                if (node != null) {
                    node.setSelected(true);
                    nodesSelectedList.add(node);
                }
            }
            TreeNode[] nodesSelectedArray = new TreeNode[nodesSelectedList.size()];
            for (int i = 0; i < nodesSelectedList.size(); ++i) {
                nodesSelectedArray[i] = nodesSelectedList.get(i);
            }
            vm.setSelectedEquipmentNodeArray(nodesSelectedArray);
        }
    }

    private TreeNode findTreeNodeByCheckPointId(TreeNode root, Integer checkPointId) {
        if (root.getType().equals(EquipmentTree.CHECK_POINT_TYPE)
                && ((EquipmentNodeData) root.getData()).getCheckPointId() == checkPointId) {
            return root;
        }
        if (root.isLeaf() || root.getChildCount() == 0) {
            return null;
        }
        TreeNode result = null;
        for (TreeNode child : root.getChildren()) {
            result = findTreeNodeByCheckPointId(child, checkPointId);
            if (result != null) {
                return result;
            }
        }
        return result;
    }

    @Override
    public void onDeleteRole(ViewModel vm, MstXunJianRole role) {
        xunJianDianQuanXianFacade.removeByRoleId(role.getRoleId());
        xunJianGuiZeFacade.removeByRoleId(role.getRoleId());
        xunJianRoleFacade.removeByRoleId(role.getRoleId());
        vm.setRoleList(xunJianRoleFacade.findAll());
    }
    /*
     * @调用时机 当点击当前巡检角色的编辑巡检规则按钮时调用
     * @功能目标 如果当前角色的巡检规则已经录入到数据库，则将数据反映到编辑对话框；如果没录入，则反映默认值
     * @步骤 1. 从数据库中读取出当前角色的规则
     *      2. 如果之前没录入规则，则设置为默认值，否则设置为录入的值
    */
    @Override
    public void onEditXunJianGuiZe(ViewModel vm) {
        List<XunJianGuiZe> xunJianGuiZeList = xunJianGuiZeFacade.findByRoleId(vm.getCurrentRole().getRoleId());
        XunJianGuiZe guiZe = new XunJianGuiZe();
        if (xunJianGuiZeList.isEmpty()) {
            guiZe.setXunHuanFangShi(SepE.XunJianXunHuanFangShi.NIAN.getValue());
        } else {
            guiZe.setXunHuanFangShi(xunJianGuiZeList.get(0).getXunHuanFangShi());
            guiZe.setKaiShiShiJian(xunJianGuiZeList.get(0).getKaiShiShiJian());
            guiZe.setJieShuShiJian(xunJianGuiZeList.get(0).getJieShuShiJian());
        }
        vm.setXunJianGuiZeInEdit(guiZe);
    }
    /*
     * @调用时机 当点击当前角色的编辑角色按钮时调用
    */
    @Override
    public void onEditRole(ViewModel vm) {
        vm.setRoleInEdit(vm.getCurrentRole());
    }
    @Override
    public void onEditRoleSubmit(ViewModel vm) {
        List<MstXunJianRole> roleList = xunJianRoleFacade.findByRoleId(vm.getRoleInEdit().getRoleId());
        MstXunJianRole role = roleList.get(0);
        role.setRoleName(vm.getRoleInEdit().getRoleName());
        role.setRoleDescription(vm.getRoleInEdit().getRoleDescription());
        vm.setRoleInEdit(null);
    }
}
