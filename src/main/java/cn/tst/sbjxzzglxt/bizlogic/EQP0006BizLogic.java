package cn.tst.sbjxzzglxt.bizlogic;

import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.EQP0001ViewModel;
import cn.tst.sbjxzzglxt.viewmodel.EQP0006ViewModel;

/**
 * 仓库管理业务逻辑
 *
 * @author ps_xy@pscp.co.jp
 */
public interface EQP0006BizLogic {

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void loadEQP0006ViewModel(EQP0006ViewModel vm);

    /**
     * 设备故障定义
     *
     * @param mode  执行模式
     * @param vm 视图
     * @return 実行結果
     */
    ExecuteResult onSaveEquipError(SepE.ExecuteMode mode, EQP0006ViewModel vm);

   

}
