package cn.tst.sbjxzzglxt.bizlogic;

import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.MST0021ViewModel;

/**
 * 巡检角色登记业务逻辑层
 *
 * @author 曹春
 */
public interface MST0021BizLogic {

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void loadMST0021ViewModel(MST0021ViewModel vm);

    /**
     * 保存巡检角色记录
     *
     * @param mode 执行模式
     * @param vm 视图模型
     * @return 执行结果
     */
    ExecuteResult saveXunJianRoleJiLu(SepE.ExecuteMode mode, MST0021ViewModel vm);
    
    void chaXunXunJianDian(MST0021ViewModel vm);
    
    void refreshXunJianRole(MST0021ViewModel vm);
    
}
