package cn.tst.sbjxzzglxt.bizlogic;

import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.EQP0001ViewModel;
import cn.tst.sbjxzzglxt.viewmodel.EQP0002ViewModel;
import cn.tst.sbjxzzglxt.viewmodel.EQP0006ViewModel;

/**
 * 装备配件定义
 *
 * @author ps_xy@pscp.co.jp
 */
public interface EQP0002BizLogic {

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void loadEQP0002ViewModel(EQP0002ViewModel vm);

    /**
     * 当前选中设备
     *
     * @param id 设备id
     */
    LTEquipBasic findSelectedEqp(Long id);

    /**
     * 装备配件定义
     *
     * @param mode 执行模式
     * @param vm 视图
     * @return 実行結果
     */
    ExecuteResult onSaveEquipFitting(SepE.ExecuteMode mode, EQP0002ViewModel vm);

}
