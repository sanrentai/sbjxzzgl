package cn.tst.sbjxzzglxt.controller.master;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.sbjxzzglxt.bizlogic.MST0006BizLogic;
import cn.tst.sbjxzzglxt.common.SecurityUtils;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import cn.tst.sbjxzzglxt.entity.DatLoginInfo;
import cn.tst.sbjxzzglxt.entity.MstYuanGong;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.MST0006ViewModel;

/**
 * 系统用户管理
 *
 * @author ps_xy@pscp.co.jp
 */
@ViewScoped
@Named(SepC.ControllerID.MST0006)
public class MST0006Controller extends BusinessBaseController {

    private MST0006ViewModel vm;

    @EJB
    private MST0006BizLogic bizLogic;

    @PostConstruct
    public void init() {
        ///初始化视图模型对象
        this.vm = new MST0006ViewModel();

        this.bizLogic.loadMST0006ViewModel(vm);
    }

    public MST0006ViewModel getVm() {
        return vm;
    }

    /**
     * 打开员工选择菜单
     */
    public void onStartChooseYuanGong() {
        this.vm.getYuanGongList().setRowIndex(1);
    }

    /**
     * 员工选择时
     *
     * @param row 员工
     */
    public void onSelectYuanGong(MstYuanGong row) {

        ///选中的员工
        this.vm.setEditingYuanGong(row);

        ///如果不存在这个用户,但是用户对象实例不为空
        if (!row.isExistsLoginUser() && row.getLoginInfo() == null) {
            DatLoginInfo newLoginUser = new DatLoginInfo(null);
            ///为被锁定
            newLoginUser.setLock(SepE.Flag.NO.getValue());
            ///员工ID
            newLoginUser.setYuangongId(row.getYuanGongId());
            ///设置为初次登录
            newLoginUser.setFirstTimeLogin(SepE.Flag.YES.getValue());
            ///生成随机密码
            newLoginUser.setRandomTempPassword(row.getDefaultPassword());
            ///设置登录用密码(加密后)
            newLoginUser.setPassword(SecurityUtils.MD5(newLoginUser.getRandomTempPassword()));
            ///设置默认登录ID
            newLoginUser.setLoginId(row.getTempLoginId());
            ///添加员工ID
            row.setLoginInfo(newLoginUser);
        }
        
        ///设置修改前的密码
        vm.setLoginId(row.getLoginInfo().getLoginId());

        ///编辑模式
        this.switchStatus2Editing();
    }

    /**
     * 保存系统用户
     */
    public void onSaveLoginUser() {

        SepE.ExecuteMode mode = this.vm.getEditingYuanGong().getLoginInfo().getInsDate() != null
            ? SepE.ExecuteMode.UPDATE : SepE.ExecuteMode.INSERT;

        ///设置LoginID
//        vm.getEditingYuanGong().getLoginInfo().setLoginId(vm.getEditingYuanGong().getTempLoginId());

        ///判断登录ID是否重复
        if (mode == SepE.ExecuteMode.UPDATE) {
            if (!vm.getLoginId().equals(vm.getEditingYuanGong().getLoginInfo().getLoginId())) {
                boolean loginIdExist = bizLogic.isLoginIdExist(vm.getEditingYuanGong().getLoginInfo().getLoginId());
                if (loginIdExist) {
                    putErrorMessage("您输入的登录ID已经存在");
                    return;
                }
            }
        }

        ///更新操作
        ExecuteResult result = this.bizLogic.saveLoginUser(mode, vm);

        this.addMessage(result.createMessage());

        ///更新成功后
        if (result.isSuccess()) {

            ///发送邮件给对象用户
            this.vm.getEditingYuanGong().setLoginInfo(null);

            ///模式初始化
            this.switchStatus2Init();
            this.switchEditMode2None();

        } else {
            vm.getEditingYuanGong().getLoginInfo().setLoginId(null);
        }
    }

    /**
     * 重置密码
     */
    public void onResetPassword() {

        DatLoginInfo targetLoginUser = vm.getEditingYuanGong().getLoginInfo();

        ///生成随机密码
        targetLoginUser.setRandomTempPassword(SecurityUtils.generateRandomPassword());

        ///设置加密后的密码
        targetLoginUser.setPassword(SecurityUtils.MD5(targetLoginUser.getRandomTempPassword()));

        ///设置为初次登录
        targetLoginUser.setFirstTimeLogin(SepE.Flag.YES.getValue());

        ///更新操作
        ExecuteResult result = this.bizLogic.saveLoginUser(SepE.ExecuteMode.UPDATE, vm);

        ///更新成功后
        if (result.isSuccess()) {

            ///发送邮件给对象用户
            this.vm.getEditingYuanGong().setLoginInfo(null);

            ///模式初始化
            this.switchStatus2Init();
            this.switchEditMode2None();

        }
    }

    public void setVm(MST0006ViewModel vm) {
        this.vm = vm;
    }
}
