package cn.tst.sbjxzzglxt.bizlogic;

import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.EQP0001ViewModel;
import cn.tst.sbjxzzglxt.viewmodel.EQP0005ViewModel;
import cn.tst.sbjxzzglxt.viewmodel.EQP0006ViewModel;

/**
 * 仓库管理业务逻辑
 *
 * @author ps_xy@pscp.co.jp
 */
public interface EQP0005BizLogic {

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void loadEQP0005ViewModel(EQP0005ViewModel vm);

    /**
     * 设备提醒
     *
     * @param mode  执行模式
     * @param vm 视图
     * @return 実行結果
     */
    ExecuteResult onEquipWarn(SepE.ExecuteMode mode, EQP0005ViewModel vm);

   

}
