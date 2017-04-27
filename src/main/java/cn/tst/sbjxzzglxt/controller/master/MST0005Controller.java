package cn.tst.sbjxzzglxt.controller.master;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.sbjxzzglxt.bizlogic.MST0005BizLogic;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import cn.tst.sbjxzzglxt.entity.MstCaiDanXiangMu;
import cn.tst.sbjxzzglxt.entity.MstGnShiYongQuanXian;
import cn.tst.sbjxzzglxt.entity.MstXiTongGongNeng;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.MST0005ViewModel;
import org.apache.commons.lang.StringUtils;

/**
 * 权限管理
 *
 * @author ps_xy@pscp.co.jp
 */
@ViewScoped
@Named(SepC.ControllerID.MST0005)
public class MST0005Controller extends BusinessBaseController {

    private MST0005ViewModel vm;

    @EJB
    private MST0005BizLogic bizLogic;

    @PostConstruct
    public void init() {

        ///初始化视图模型
        this.vm = new MST0005ViewModel();

        this.bizLogic.loadMST0005ViewModel(vm);
    }

    /**
     * 获取对应的部门与职能权限
     */
    public void onLoadQuanXian() {

        ///编辑模式
        this.switchStatus2Editing();

        ///更新模式
        this.switchEditMode2Update();

        ///更新数据模型
        this.bizLogic.refreshAllQuanXian(vm);
    }

    /**
     * 取消编辑
     */
    public void onCancel() {

        ///无模式
        this.switchEditMode2None();

        ///初始模式
        this.switchStatus2Init();

        ///清除权限集合
        this.vm.getQuanXianList().clear();

        ///清除权限标志
        this.vm.switchAllCheck(false);
    }

    /**
     * 保存数据
     */
    public void onSaveAuthority() {

        ExecuteResult result = this.bizLogic.saveQuanXianData(vm);

        this.addMessage(result.createMessage());

        if (result.isSuccess()) {

            this.switchEditMode2None();

            this.switchStatus2Init();

            ///更新候选值输入框,更新明细
            this.bizLogic.loadMST0005ViewModel(vm);
        }
    }

    /**
     * 保存权限数据
     */
    public void onSaveRole() {

        ///如果角色ID为空则为新建,否则为更新
        SepE.ExecuteMode mode = StringUtils.isEmpty(vm.getEditingRole().getRoleId())
                ? SepE.ExecuteMode.INSERT : SepE.ExecuteMode.UPDATE;

        ExecuteResult result = this.bizLogic.saveRoleData(mode, vm);

        this.addMessage(result.createMessage());

        if (result.isSuccess()) {

            this.switchEditMode2None();

            this.switchStatus2Init();

            ///更新候选值输入框,更新明细
            this.bizLogic.loadMST0005ViewModel(vm);
        }
    }

    /**
     * 开始追加角色
     */
    public void onAddNewRole() {
        this.vm.initRole();
    }

    /**
     * 全选按钮Check
     *
     * @param category 分类
     */
    public void onCheckAll(String category) {

        List<MstCaiDanXiangMu> targetCaiDan = null;
        boolean flg = false;

        switch (category) {
            case SepC.MenuCategory.BIZ:
                targetCaiDan = this.vm.getCaiDanListBIZ();
                flg = this.vm.isCheckAllBIZ();
                break;
            case SepC.MenuCategory.ARP:
                targetCaiDan = this.vm.getCaiDanListARP();
                flg = this.vm.isCheckAllARP();
                break;
            case SepC.MenuCategory.INV:
                targetCaiDan = this.vm.getCaiDanListINV();
                flg = this.vm.isCheckAllINV();
                break;
            case SepC.MenuCategory.SUP:
                targetCaiDan = this.vm.getCaiDanListSUP();
                flg = this.vm.isCheckAllSUP();
                break;
            case SepC.MenuCategory.MST:
                targetCaiDan = this.vm.getCaiDanListMST();
                flg = this.vm.isCheckAllMST();
                break;
            case SepC.MenuCategory.CAR:
                targetCaiDan = this.vm.getCaiDanListCAR();
                flg = this.vm.isCheckAllCAR();
                break;
            case SepC.MenuCategory.YOU:
                targetCaiDan = this.vm.getCaiDanListYOU();
                flg = this.vm.isCheckAllYOU();
                break;
            case SepC.MenuCategory.MEI:
                targetCaiDan = this.vm.getCaiDanListMEI();
                flg = this.vm.isCheckAllMEI();
                break;
            case SepC.MenuCategory.WAI:
                targetCaiDan = this.vm.getCaiDanListWAI();
                flg = this.vm.isCheckAllWAI();
                break;
            case SepC.MenuCategory.MET:
                targetCaiDan = this.vm.getCaiDanListMET();
                flg = this.vm.isCheckAllMET();
                break;
            default:
                targetCaiDan = this.vm.getCaiDanList();
                flg = this.vm.isCheckAll();
                this.vm.switchAllCheck(flg);
        }

        for (MstCaiDanXiangMu cd : targetCaiDan) {
            for (MstXiTongGongNeng gn : cd.getGongNengList()) {
                MstGnShiYongQuanXian qx = this.vm.getQuanXianList().get(gn.getGongNengId());
                if (qx != null) {
                    qx.setQuanXianB(flg);
                }
            }
        }
    }


    public MST0005ViewModel getVm() {
        return vm;
    }

    public void setVm(MST0005ViewModel vm) {
        this.vm = vm;
    }
}
