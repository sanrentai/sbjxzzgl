package cn.tst.sbjxzzglxt.bizlogic;

import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.MST0021ViewModel;

/**
 * 违章登记业务逻辑层
 *
 * @author 曹春
 */
public interface MST0021BizLogic {

    /**
     * 初始化ViewModel
     *
     * @param vm 视图模型
     */
    void loadMST0021ViewModel(MST0021ViewModel vm);

    /**
     * 保存违章记录
     *
     * @param mode 执行模式
     * @param vm 视图模型
     * @return 执行结果
     */
    ExecuteResult saveWeiZhangJiLu(SepE.ExecuteMode mode, MST0021ViewModel vm);
    

    
    void refreshWeiZhang(MST0021ViewModel vm);
    
    
    /**
     *
     * @param vm 视图模型
     */
    public void setToday(MST0021ViewModel vm);

    /**
     *
     * @param vm 视图模型
     */
    public void setThisWeek(MST0021ViewModel vm);

    /**
     *
     * @param vm 视图模型
     */
    public void setThisMonth(MST0021ViewModel vm);

    /**
     *
     * @param vm 视图模型
     */
    public void setThisSeason(MST0021ViewModel vm);
}
