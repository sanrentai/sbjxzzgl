package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXinXiJiLu;

import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;

/**
 * 巡检信息记录定义
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
     * 巡检信息记录定义
     *
     * @param mode  执行模式
     * @param vm 视图
     * @return 実行結果
     */
    ExecuteResult onXunJianJiLu(SepE.ExecuteMode mode,ViewModel vm);

   

}
