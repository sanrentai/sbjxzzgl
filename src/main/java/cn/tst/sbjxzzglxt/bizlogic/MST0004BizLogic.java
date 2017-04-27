package cn.tst.sbjxzzglxt.bizlogic;

import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.DatYuanGongSuoShu;
import cn.tst.sbjxzzglxt.entity.MstYuanGong;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.MST0004ViewModel;

/**
 * 员工信息业务逻辑层
 *
 * @author ps_xy@pscp.co.jp
 */
public interface MST0004BizLogic {

    /**
     * 初始化ViewModel
     *
     * @param vm 数据模型
     */
    void loadMST0004ViewModel(MST0004ViewModel vm);

    /**
     * 获取只能信息
     *
     * @param vm 数据模型
     */
    void refreshZhiNengData(MST0004ViewModel vm);

    /**
     * 保存员工
     *
     * @param mode 编辑模式
     * @param obj 员工对象
     * @return 执行结果
     */
    ExecuteResult saveYuanGong(SepE.ExecuteMode mode, MstYuanGong obj);

    /**
     * 保存员工所属历史
     *
     * @param mode 编辑模式
     * @param obj 员工所属历史对象
     * @return 执行结果
     */
    ExecuteResult saveSuoShu(SepE.ExecuteMode mode, DatYuanGongSuoShu obj);

    /**
     * 添加的数据在任日期比当前在任日期最新数据要早<br/>
     * 例: 现有数据 2016/08/01 -> 新增: 2016/07/26
     *
     * @return true: 输入的数据异常, false: 输入数据OK
     */
    boolean checkZaiRenRiqiBeforeLastData(MST0004ViewModel vm);
    
    void liZhi(MST0004ViewModel vm, MstYuanGong yuanGong);
}
