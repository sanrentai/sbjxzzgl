package cn.tst.sbjxzzglxt.bizlogic;

import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.MST0006ViewModel;

/**
 * 系统用户信息业务逻辑层
 *
 * @author ps_xy@pscp.co.jp
 */
public interface MST0006BizLogic {

    /**
     * 初始化ViewModel
     *
     * @param vm 数据模型
     */
    void loadMST0006ViewModel(MST0006ViewModel vm);

    /**
     * 保存用户
     *
     * @param mode 执行模式
     * @param vm 数据模型
     * @return 执行结果
     */
    ExecuteResult saveLoginUser(SepE.ExecuteMode mode, MST0006ViewModel vm);
    
    boolean isLoginIdExist(String loginId);
}
