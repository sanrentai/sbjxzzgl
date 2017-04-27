package cn.tst.sbjxzzglxt.controller.master;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.sbjxzzglxt.bizlogic.MST0016BizLogic;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import cn.tst.sbjxzzglxt.entity.MstSystemConfig;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.MST0016ViewModel;
import org.apache.commons.lang3.StringUtils;

/**
 * 系统设定
 *
 * @author ps_lbin@pscp.co.jp
 */
@ViewScoped
@Named(SepC.ControllerID.MST0016)
public class MST0016Controller extends BusinessBaseController {

    private MST0016ViewModel vm;

    @EJB
    private MST0016BizLogic bizLogic;

    @PostConstruct
    public void init() {
        ///初始化视图模型
        this.vm = new MST0016ViewModel();

        this.bizLogic.loadMST0016ViewModel(vm);
    }

    /**
     * 开始编辑
     */
    public void onStartEditing() {
        this.vm.setEditingSystemConfig(new MstSystemConfig());
    }

    /**
     * 取消编辑
     */
    public void onCancelEditing() {
        this.vm.setEditingSystemConfig(null);
    }

    /**
     * 编辑用车记录
     *
     * @param row 选中的行
     */
    public void onEditSystemConfig(MstSystemConfig row) {
        ///设置编辑的对象
        this.vm.setEditingSystemConfig(row);
    }
    
    public void onDeleteSystemConfig(MstSystemConfig row) {
        SepE.ExecuteMode mode = SepE.ExecuteMode.DELETE;
        vm.setEditingSystemConfig(row);

        ///执行更新
        ExecuteResult result = this.bizLogic.saveSystemConfig(mode, vm);

        if (result.isSuccess()) {
            putInfoMessage("删除成功");
            onCancelEditing();
        } else {
            putErrorMessage("删除失败");
        }
    }

    /**
     * 保存系统设定
     */
    public void onSaveSystemConfig() {
        SepE.ExecuteMode mode = StringUtils.isEmpty(this.vm.getEditingSystemConfig().getInsRep())
            ? SepE.ExecuteMode.INSERT : SepE.ExecuteMode.UPDATE;

        ///执行更新
        ExecuteResult result = this.bizLogic.saveSystemConfig(mode, vm);

        this.addMessage(result.createMessage());

        if (result.isSuccess()) {
            onStartEditing();
        }
    }

    /**
     * 刷新数据
     */
    public void onRefreshData() {

    }

    public MST0016ViewModel getVm() {
        return vm;
    }
}
