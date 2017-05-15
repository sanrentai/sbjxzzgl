package cn.tst.sbjxzzglxt.controller.master;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.sbjxzzglxt.bizlogic.MST0021BizLogic;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import cn.tst.sbjxzzglxt.entity.MstXunJianRole;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.MST0021ViewModel;
import org.apache.commons.lang3.StringUtils;

/**
 * 检修角色管理
 *
 * @author 曹春
 */
@ViewScoped
@Named(SepC.ControllerID.MST0021)
public class MST0021Controller extends BusinessBaseController {

    private MST0021ViewModel vm;

    @EJB
    private MST0021BizLogic bizLogic;

    @PostConstruct
    public void init() {
        ///初始化视图模型
        this.vm = new MST0021ViewModel();

        this.bizLogic.loadMST0021ViewModel(vm);
    }
    
    public void changeRiQi() {
        switch (vm.getRiQiFanWei()) {
            case "today":
                bizLogic.setToday(vm);
                break;
            case "thisWeek":
                bizLogic.setThisWeek(vm);
                break;
            case "thisMonth":
                bizLogic.setThisMonth(vm);
                break;
            case "thisSeason":
               bizLogic.setThisSeason(vm);
                break;
        }
    }

    /**
     * 开始编辑
     */
    public void onStartEditing() {
        this.vm.setEditingWeiZhang(new MstXunJianRole());
    }

    /**
     * 取消编辑
     */
    public void onCancelEditing() {
        this.vm.setEditingWeiZhang(null);
    }

    /**
     * 编辑违章记录
     *
     * @param row 选中的行
     */
    public void onEditWeiZhang(MstXunJianRole row) {
        ///设置编辑的对象
        this.vm.setEditingWeiZhang(row);
    }
    
    public void onDeleteWeiZhang(MstXunJianRole row) {
        ///删除模式
        SepE.ExecuteMode mode = SepE.ExecuteMode.DELETE;
        vm.setEditingWeiZhang(row);

        ///执行更新
        ExecuteResult result = this.bizLogic.saveWeiZhangJiLu(mode, vm);

        if (result.isSuccess()) {
            putInfoMessage("删除成功");
            
            onCancelEditing();
        } else {
            putErrorMessage("删除失败");
        }
    }

    /**
     * 保存违章记录
     */
    public void onSaveWeiZhang() {

        SepE.ExecuteMode mode = this.vm.getEditingWeiZhang().getRoleId()==null
            ? SepE.ExecuteMode.INSERT : SepE.ExecuteMode.UPDATE;

        ///执行更新
        ExecuteResult result = this.bizLogic.saveWeiZhangJiLu(mode, vm);

        this.addMessage(result.createMessage());

        if (result.isSuccess()) {
            onCancelEditing();
        }
    }
   
    
    /**
     * 刷新数据
     */
    public void onRefreshData() {

    }

    public MST0021ViewModel getVm() {
        return vm;
    }

    public void setVm(MST0021ViewModel vm) {
        this.vm = vm;
    }
    
}
