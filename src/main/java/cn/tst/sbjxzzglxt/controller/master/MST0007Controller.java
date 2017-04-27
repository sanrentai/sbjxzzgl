package cn.tst.sbjxzzglxt.controller.master;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.sbjxzzglxt.bizlogic.MST0007BizLogic;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import cn.tst.sbjxzzglxt.entity.DatYuangongRole;
import cn.tst.sbjxzzglxt.entity.MstYuanGong;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.MST0007ViewModel;

/**
 * 用户角色分配
 *
 * @author ps_xy@pscp.co.jp
 */
@ViewScoped
@Named(SepC.ControllerID.MST0007)
public class MST0007Controller extends BusinessBaseController {

    private MST0007ViewModel vm;

    @EJB
    private MST0007BizLogic bizLogic;

    @PostConstruct
    public void init() {
        ///初始化数据模型
        this.vm = new MST0007ViewModel();

        this.bizLogic.loadMST0007ViewModel(vm);
    }

    /**
     * 打开员工选择菜单
     */
    public void onStartChooseYuanGong() {
        this.vm.getYuanGongList().setRowIndex(1);
    }

    /**
     * 查看角色详细
     *
     * @param row 选中的角色
     */
    public void onSelectGongNengRole(DatYuangongRole row) {

        ///更新选中的角色
        this.vm.setSelectedYuanGongRole(row);

        ///更新角色功能
        this.bizLogic.refreshRoleGongNeng(vm);
    }

    /**
     * 选择员工时
     *
     * @param row 选中的员工
     */
    public void onSelectYuanGong(MstYuanGong row) {

        ///设置选中的员工
        this.vm.setEditingYuanGong(row);

        ///加载角色信息
        this.bizLogic.refreshYuanGongRole(vm);

        ///更新模式
        this.switchEditMode2Update();

        ///编辑中
        this.switchStatus2Editing();
    }

    /**
     * 保存员工角色
     */
    public void onSaveYuanGongRole() {

        ///执行更新
        ExecuteResult result = this.bizLogic.saveYuanGongRole(vm);

        ///输出错误信息
        this.addMessage(result.createMessage());

        if (result.isSuccess()) {
            this.switchStatus2Init();
            this.switchEditMode2None();
        }
    }

    public MST0007ViewModel getVm() {
        return vm;
    }

    public void setVm(MST0007ViewModel vm) {
        this.vm = vm;
    }

}
