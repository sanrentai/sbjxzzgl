package cn.tst.sbjxzzglxt.bizlogic;

import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionMessage;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.EQP0001ViewModel;
import cn.tst.sbjxzzglxt.viewmodel.EQP0005ViewModel;
import cn.tst.sbjxzzglxt.viewmodel.EQP0006ViewModel;
import cn.tst.sbjxzzglxt.viewmodel.XJ0002ViewModel;

/**
 * 巡检信息列表
 *
 * @author ps_xy@pscp.co.jp
 */
public interface XJ0002BizLogic {

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void loadXJ0002ViewModel(XJ0002ViewModel vm);

    /**
     *设备提醒
     * @param mode  执行模式
     * @param vm 视图
     * @return 実行結果
     */
    ExecuteResult onRoutingInspectionMessage(SepE.ExecuteMode mode, XJ0002ViewModel vm);

   

}
