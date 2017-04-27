package cn.tst.sbjxzzglxt.viewmodel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.entity.MstCaiDanXiangMu;
import cn.tst.sbjxzzglxt.entity.MstGnShiYongQuanXian;
import cn.tst.sbjxzzglxt.entity.MstRoleInfo;

/**
 * 权限管理ViewModel
 *
 * @author ps_xy@pscp.co.jp
 */
public class MST0005ViewModel extends BaseViewModel {

    private boolean checkAll = false;
    private boolean checkAllBIZ = false;
    private boolean checkAllARP = false;
    private boolean checkAllINV = false;
    private boolean checkAllSUP = false;
    private boolean checkAllMST = false;
    private boolean checkAllCAR = false;
    private boolean checkAllYOU = false;
    private boolean checkAllMEI = false;
    private boolean checkAllMET = false;
    private boolean checkAllWAI = false;
    private boolean checkAllCK = false;


    ///选中的部门
    private MstRoleInfo selectedRole;

    ///部门
    private List<MstRoleInfo> roleList;

    ///菜单项目一栏
    private List<MstCaiDanXiangMu> caiDanList;

    ///权限一览
    private Map<String, MstGnShiYongQuanXian> quanXianList;

    ///编辑中的权限
    private MstRoleInfo editingRole;

    /**
     * 初始化角色
     */
    public void initRole() {
        this.editingRole = new MstRoleInfo();
    }

    public MST0005ViewModel() {
        this.quanXianList = new HashMap<>();
    }

    public MstRoleInfo getSelectedRole() {
        return selectedRole;
    }

    public void setSelectedRole(MstRoleInfo selectedRole) {
        this.selectedRole = selectedRole;
    }

    public List<MstRoleInfo> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<MstRoleInfo> roleList) {
        this.roleList = roleList;
    }

    public List<MstCaiDanXiangMu> getCaiDanList() {
        return caiDanList;
    }

    public void setCaiDanList(List<MstCaiDanXiangMu> caiDanList) {
        this.caiDanList = caiDanList;
    }

    public Map<String, MstGnShiYongQuanXian> getQuanXianList() {
        return quanXianList;
    }

    public void setQuanXianList(Map<String, MstGnShiYongQuanXian> quanXianList) {
        this.quanXianList = quanXianList;
    }

    public boolean isCheckAll() {
        return checkAll;
    }

    public void setCheckAll(boolean checkAll) {
        this.checkAll = checkAll;
    }

    public boolean isCheckAllBIZ() {
        return checkAllBIZ;
    }

    public void setCheckAllBIZ(boolean checkAllBIZ) {
        this.checkAllBIZ = checkAllBIZ;
    }

    public boolean isCheckAllARP() {
        return checkAllARP;
    }

    public void setCheckAllARP(boolean checkAllARP) {
        this.checkAllARP = checkAllARP;
    }

    public boolean isCheckAllINV() {
        return checkAllINV;
    }

    public void setCheckAllINV(boolean checkAllINV) {
        this.checkAllINV = checkAllINV;
    }

    public boolean isCheckAllSUP() {
        return checkAllSUP;
    }

    public void setCheckAllSUP(boolean checkAllSUP) {
        this.checkAllSUP = checkAllSUP;
    }

    public boolean isCheckAllMST() {
        return checkAllMST;
    }

    public void setCheckAllMST(boolean checkAllMST) {
        this.checkAllMST = checkAllMST;
    }

    public boolean isCheckAllCAR() {
        return checkAllCAR;
    }

    public void setCheckAllCAR(boolean checkAllCAR) {
        this.checkAllCAR = checkAllCAR;
    }

    public boolean isCheckAllYOU() {
        return checkAllYOU;
    }

    public void setCheckAllYOU(boolean checkAllYOU) {
        this.checkAllYOU = checkAllYOU;
    }

    public boolean isCheckAllMEI() {
        return checkAllMEI;
    }

    public void setCheckAllMEI(boolean checkAllMEI) {
        this.checkAllMEI = checkAllMEI;
    }

    public boolean isCheckAllMET() {
        return checkAllMET;
    }

    public void setCheckAllMET(boolean checkAllMET) {
        this.checkAllMET = checkAllMET;
    }

    public boolean isCheckAllWAI() {
        return checkAllWAI;
    }

    public void setCheckAllWAI(boolean checkAllWAI) {
        this.checkAllWAI = checkAllWAI;
    }

    public boolean isCheckAllCK() {
        return checkAllCK;
    }

    public void setCheckAllCK(boolean checkAllCK) {
        this.checkAllCK = checkAllCK;
    }

    public MstRoleInfo getEditingRole() {
        return editingRole;
    }

    public void setEditingRole(MstRoleInfo editingRole) {
        this.editingRole = editingRole;
    }

    /**
     * 申请
     *
     * @return 菜单集合
     */
    public List<MstCaiDanXiangMu> getCaiDanListBIZ() {
        return this.splitCaiDanList(SepC.MenuCategory.BIZ);
    }

    /**
     * 库存
     *
     * @return 菜单集合
     */
    public List<MstCaiDanXiangMu> getCaiDanListINV() {
        return this.splitCaiDanList(SepC.MenuCategory.INV);
    }

    /**
     * 审批
     *
     * @return 菜单集合
     */
    public List<MstCaiDanXiangMu> getCaiDanListARP() {
        return this.splitCaiDanList(SepC.MenuCategory.ARP);
    }

    /**
     * 供应商
     *
     * @return 菜单集合
     */
    public List<MstCaiDanXiangMu> getCaiDanListSUP() {
        return this.splitCaiDanList(SepC.MenuCategory.SUP);
    }

    /**
     * 系统管理
     *
     * @return 菜单集合
     */
    public List<MstCaiDanXiangMu> getCaiDanListMST() {
        return this.splitCaiDanList(SepC.MenuCategory.MST);
    }

    /**
     * 车辆管理
     *
     * @return 菜单集合
     */
    public List<MstCaiDanXiangMu> getCaiDanListCAR() {
        return this.splitCaiDanList(SepC.MenuCategory.CAR);
    }

    /**
     * 用油管理
     *
     * @return 菜单集合
     */
    public List<MstCaiDanXiangMu> getCaiDanListYOU() {
        return this.splitCaiDanList(SepC.MenuCategory.YOU);
    }

    /**
     * 用煤管理
     *
     * @return 菜单集合
     */
    public List<MstCaiDanXiangMu> getCaiDanListMEI() {
        return this.splitCaiDanList(SepC.MenuCategory.MEI);
    }

    /**
     * 委外加工管理
     *
     * @return 菜单集合
     */
    public List<MstCaiDanXiangMu> getCaiDanListWAI() {
        return this.splitCaiDanList(SepC.MenuCategory.WAI);
    }

    /**
     * 能源管理
     *
     * @return 菜单集合
     */
    public List<MstCaiDanXiangMu> getCaiDanListMET() {
        return this.splitCaiDanList(SepC.MenuCategory.MET);
    }

    /**
     * 清除选择的内容
     *
     * @param flg
     */
    public void switchAllCheck(boolean flg) {
        this.checkAll
                = this.checkAllBIZ
                = this.checkAllARP
                = this.checkAllINV
                = this.checkAllSUP
                = this.checkAllMST
                = this.checkAllCAR
                = this.checkAllYOU
                = this.checkAllMEI
                = this.checkAllMET
                = this.checkAllWAI
                = this.checkAllCK
                = flg;
    }

    /**
     * 分割菜单数据
     *
     * @param split 分割单位
     * @return
     */
    private List<MstCaiDanXiangMu> splitCaiDanList(String split) {
        return this.caiDanList
                .stream()
                .filter(cd -> split.equals(cd.getPk().getCaidanId()))
                .collect(Collectors.toList());
    }
}
