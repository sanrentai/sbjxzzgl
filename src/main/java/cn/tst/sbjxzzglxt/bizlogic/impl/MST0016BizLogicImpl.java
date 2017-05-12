package cn.tst.sbjxzzglxt.bizlogic.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.bizlogic.MST0016BizLogic;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.MstSystemConfig;
import cn.tst.sbjxzzglxt.facade.MstSystemConfigFacade;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.MST0016ViewModel;

/**
 * 系统设定
 *
 * @author ps_lbin@pscp.co.jp
 */
@Stateless
public class MST0016BizLogicImpl extends BaseBizLogic implements MST0016BizLogic {

    private final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(MST0016BizLogicImpl.class);

    @EJB
    private MstSystemConfigFacade mstSystemConfigDao;

    @Override
    public void loadMST0016ViewModel(MST0016ViewModel vm) {
        List<MstSystemConfig> systemConfigList = mstSystemConfigDao.findAll();
        vm.setSystemConfigList(systemConfigList);
    }

    @Override
    public ExecuteResult saveSystemConfig(SepE.ExecuteMode mode, MST0016ViewModel vm) {
        ExecuteResult result = new ExecuteResult(mode);
        try {
            MstSystemConfig target = vm.getEditingSystemConfig();
            switch (mode) {
                case INSERT:
                    mstSystemConfigDao.create(target);
                    break;
                case UPDATE:
                    mstSystemConfigDao.edit(target);
                    break;
                case DELETE:
                    mstSystemConfigDao.remove(target);
                    break;
            }
            /// 刷新
            loadMST0016ViewModel(vm);
            result.setSuccess(true);
        } catch (Exception e) {
            result.anylizeException(e);
            result.setSuccess(false);
            e.printStackTrace();
            LOG.error(e);
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }
}
