package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.SheBeiGuZhangDingYi;

import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.EQP0001ViewModel;
import cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.SheBeiGuZhangDingYi.ViewModel;

/**
 * 设备故障定义
 *
 * @author ps_xy@pscp.co.jp
 */
public interface BizLogic {

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void loadEQP0006ViewModel(ViewModel vm);
 /**
     * 当前选中设备
     *
     * @param id 设备id
     * @return 
     */
    LTEquipBasic findSelectedEqp(Long id);
    /**
     * 设备故障定义
     *
     * @param mode  执行模式
     * @param vm 视图
     * @return 実行結果
     */
    ExecuteResult onEquipError(SepE.ExecuteMode mode, ViewModel vm);
    
        /**
     * 设备故障内容定义
     *
     * @param mode  执行模式
     * @param vm 视图
     * @return 実行結果
     */
    ExecuteResult onErrorMessage(SepE.ExecuteMode mode, ViewModel vm);

   

}
