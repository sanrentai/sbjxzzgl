package cn.tst.sbjxzzglxt.bizlogic;

import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.MST0007ViewModel;

/**
 * 角色信息业务逻辑层
 *
 * @author ps_xy@pscp.co.jp
 */
public interface MST0007BizLogic {

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void loadMST0007ViewModel(MST0007ViewModel vm);

    /**
     * 更新员工角色一览
     *
     * @param vm 视图模型
     */
    void refreshYuanGongRole(MST0007ViewModel vm);

    /**
     * 更新角色功能
     *
     * @param vm 视图模型
     */
    void refreshRoleGongNeng(MST0007ViewModel vm);

    /**
     * 保存员工角色
     *
     * @param vm 视图模型
     * @return 执行结果
     */
    ExecuteResult saveYuanGongRole(MST0007ViewModel vm);
}
