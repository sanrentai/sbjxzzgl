package cn.tst.sbjxzzglxt.bizlogic;

import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.MST0005ViewModel;

/**
 * 员工信息业务逻辑层
 *
 * @author ps_xy@pscp.co.jp
 */
public interface MST0005BizLogic {

    /**
     * 初始化ViewModel
     *
     * @param vm 数据模型
     */
    void loadMST0005ViewModel(MST0005ViewModel vm);

    /**
     * 获取所有权限一览
     *
     * @param vm 数据模型
     */
    void refreshAllQuanXian(MST0005ViewModel vm);

    /**
     * 保存权限信息
     *
     * @param vm 数据模型
     * @return 执行结果
     */
    ExecuteResult saveQuanXianData(MST0005ViewModel vm);

    /**
     * 保存角色信息
     *
     * @param mode 执行模式
     * @param vm 数据模型
     * @return 执行结果
     */
    ExecuteResult saveRoleData(SepE.ExecuteMode mode, MST0005ViewModel vm);
}
