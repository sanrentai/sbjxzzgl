package cn.tst.sbjxzzglxt.bizlogic;

import cn.tst.sbjxzzglxt.viewmodel.SystemConfigViewModel;

/**
 * 系统配置业务处理类
 *
 * @author ps_xy@pscp.co.jp
 */
public interface SystemConfigBizLogic {

    /**
     * 初始化系统配置
     *
     * @param vm 对象数据模型
     */
    void initSystem(SystemConfigViewModel vm);
    
}
