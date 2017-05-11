package cn.tst.sbjxzzglxt.bizlogic.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.bizlogic.SystemConfigBizLogic;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.facade.MstSystemConfigFacade;
import cn.tst.sbjxzzglxt.viewmodel.SystemConfigViewModel;

/**
 * 系统配置实现类
 *
 * @author ps_xy@pscp.co.jp
 */
@Stateless
public class SystemConfigBizLogicImpl implements SystemConfigBizLogic {

    @EJB
    private MstSystemConfigFacade configService;

    @Override
    public void initSystem(SystemConfigViewModel vm) {
        vm.setConfig(configService.find(SepC.SYSTEM_ID));
    }

}
