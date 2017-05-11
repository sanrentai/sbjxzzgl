package cn.tst.sbjxzzglxt.bizlogic.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.bizlogic.MST0006BizLogic;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.DatLoginInfo;
import cn.tst.sbjxzzglxt.entity.MstYuanGong;
import cn.tst.sbjxzzglxt.lazymodel.MstYuanGongLazyModel;
import cn.tst.sbjxzzglxt.facade.DatLoginInfoFacade;
import cn.tst.sbjxzzglxt.facade.MstYuanGongFacade;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.MST0006ViewModel;
import org.primefaces.model.LazyDataModel;

/**
 * 系统用户注册,修改,删除
 *
 * @author ps_xy@pscp.co.jp
 */
@Stateless
public class MST0006BizLogicImpl extends BaseBizLogic implements MST0006BizLogic {

    private final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(MST0006BizLogicImpl.class);

    ///员工信息Facade
    @EJB
    private MstYuanGongFacade yuanGongService;

    @EJB
    private DatLoginInfoFacade loginService;

    @Override
    public void loadMST0006ViewModel(MST0006ViewModel vm) {

        ///取得所有员工信息
        LazyDataModel<MstYuanGong> yuanGongList = new MstYuanGongLazyModel(this.yuanGongService);

        vm.setYuanGongList(yuanGongList);
    }

    @Override
    public ExecuteResult saveLoginUser(SepE.ExecuteMode mode, MST0006ViewModel vm) {

        DatLoginInfo targetLoginUser = vm.getEditingYuanGong().getLoginInfo();
        ExecuteResult result = new ExecuteResult();

        try {

            switch (mode) {
                case INSERT:

                    loginService.create(targetLoginUser);

                    ///发送邮件 该功能占时不用使用
//                    successSendMail = MailUtils.sendCreateNewLoginUser(targetLoginUser.getLoginId(),
//                        targetLoginUser.getLoginId(),
//                        vm.getEditingYuanGong().getNameZ(),
//                        targetLoginUser.getRandomTempPassword());
//
//                    if (!successSendMail) {
//                        throw new Exception("邮件发送失败");
//                    }
                    break;
                case UPDATE:
                    loginService.edit(targetLoginUser);

//                    ///发送邮件
//                    successSendMail = MailUtils.sendResetPassword(targetLoginUser.getLoginId(),
//                        vm.getEditingYuanGong().getNameZ(),
//                        targetLoginUser.getRandomTempPassword());
//
//                    if (!successSendMail) {
//                        throw new Exception("邮件发送失败");
//                    }

                    break;
                case DELETE:
                    break;
            }

            result.setSuccess(true);

        } catch (Exception e) {
            result.anylizeException(e);
            result.setSuccess(false);
            LOG.error(e);
        }

        return result;
    }

    @Override
    public boolean isLoginIdExist(String loginId) {
        DatLoginInfo find = this.loginService.findByLoginId(loginId);
        return find != null;
    }
}
