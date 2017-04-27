package cn.tst.sbjxzzglxt.bizlogic;

import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.MST0016ViewModel;

/**
 * 系统设定业务逻辑层
 *
 * @author ps_lbin@pscp.co.jp
 */
public interface MST0016BizLogic {

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void loadMST0016ViewModel(MST0016ViewModel vm);

    /**
     * 保存系统设定
     *
     * @param mode 执行模式
     * @param vm 视图模型
     * @return 执行结果
     */
    ExecuteResult saveSystemConfig(SepE.ExecuteMode mode, MST0016ViewModel vm);
}
