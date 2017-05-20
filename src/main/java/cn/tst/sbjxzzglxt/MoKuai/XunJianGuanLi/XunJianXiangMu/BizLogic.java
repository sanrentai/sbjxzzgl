package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXiangMu;

import cn.tst.sbjxzzglxt.bizlogic.*;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.EQP0001ViewModel;
import cn.tst.sbjxzzglxt.viewmodel.EQP0006ViewModel;

/**
 * 巡检项目
 *
 * @author ps_xy@pscp.co.jp
 */
public interface BizLogic {

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void loadViewModel(ViewModel vm);
/**
     * 当前选中设备
     *
     * @param id 设备id
     * @return 
     */
    LTEquipBasic findSelectedEqp(Long id);
    /**
     * 巡检项目定义
     *
     * @param mode  执行模式
     * @param vm 视图
     * @return 実行結果
     */
    ExecuteResult onXunJianXiangMu(SepE.ExecuteMode mode, ViewModel vm);

    public ExecuteResult onSaveEquipment(SepE.ExecuteMode mode, ViewModel vm);

   

}
