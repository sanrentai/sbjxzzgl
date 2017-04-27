package cn.tst.sbjxzzglxt.bizlogic;

import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.MstBuMen;
import cn.tst.sbjxzzglxt.entity.MstZhiNeng;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.MST0013ViewModel;

/**
 * 部门与职能业务逻辑层
 *
 * @author ps_xy@pscp.co.jp
 */
public interface MST0013BizLogic {

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void loadMST0013ViewModel(MST0013ViewModel vm);

    /**
     * 保存数据
     *
     * @param mode 执行模式
     * @param vm 视图模型
     * @return 执行结果
     */
    ExecuteResult saveData(SepE.ExecuteMode mode, MST0013ViewModel vm);
    
    /**
     * 判断部门是否被使用
     * @param buMen
     * @return 
     */
    boolean isBuMenUsed(MstBuMen buMen);
    
    /**
     * 判断职能是否被使用
     * @param zhiNeng
     * @return 
     */
    boolean isZhiNengUsed(MstZhiNeng zhiNeng);
}
