package cn.tst.sbjxzzglxt.bizlogic;

import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.EQP0001ViewModel;

/**
 * 仓库管理业务逻辑
 *
 * @author ps_xy@pscp.co.jp
 */
public interface EQP0001BizLogic {

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void loadEQP0001ViewModel(EQP0001ViewModel vm);

    /**
     * 保存设备
     *
     * @param mode  执行模式
     * @param vm 视图
     * @return 実行結果
     */
    ExecuteResult onSaveEquipment(SepE.ExecuteMode mode, EQP0001ViewModel vm);
    
        /**
     * 保存设备
     *
     * @param mode  执行模式
     * @param vm 视图
     * @return 実行結果
     */
    ExecuteResult onSaveProperty(SepE.ExecuteMode mode, EQP0001ViewModel vm);

}
