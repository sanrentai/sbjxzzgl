package cn.tst.sbjxzzglxt.viewmodel;

import javax.ejb.TransactionRolledbackLocalException;
import javax.faces.application.FacesMessage;
import javax.persistence.OptimisticLockException;
import cn.tst.sbjxzzglxt.common.BizConfig;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.exception.ExecuteException;

/**
 * 执行结果类 返回新建,修改,删除的结果
 *
 * @author ps_xy@pscp.co.jp
 */
public class ExecuteResult {

    private final BizConfig _bizConfig = new BizConfig();

    private final SepE.ExecuteMode executeMode;

    ///実行成功フラグ
    private boolean success = false;
    ///ErrorMessageId
    private String errorMsgId;
    ///SuccessMessageId
    private String successMsgId;

    /**
     * 构造函数
     */
    public ExecuteResult() {
        this.executeMode = SepE.ExecuteMode.UPDATE;
        this.initMessage(this.executeMode);
    }

    /**
     * 构造函数
     *
     * @param mode 编辑模式
     */
    public ExecuteResult(SepE.ExecuteMode mode) {
        this.executeMode = mode;
        this.initMessage(this.executeMode);
    }

    /**
     * 创建更新的消息
     *
     * @return JSF消息对象
     */
    public FacesMessage createMessage() {

        if (this.success) {
            return new FacesMessage(FacesMessage.SEVERITY_INFO, "信息", _bizConfig.getText(this.successMsgId));
        } else {
            return new FacesMessage(FacesMessage.SEVERITY_ERROR, "信息", _bizConfig.getText(this.errorMsgId));
        }
    }

    /**
     * 分析异常信息
     *
     * @param e 异常对象
     */
    public void anylizeException(Exception e) {

        if (e instanceof ExecuteException) {
            this.errorMsgId = ((ExecuteException) e).getExceptionId();
            return;
        }

        if (e.getCause() instanceof TransactionRolledbackLocalException) {

            TransactionRolledbackLocalException trExp = (TransactionRolledbackLocalException) e.getCause();

            //排他异常
            if (trExp.getCausedByException() instanceof OptimisticLockException) {
                this.errorMsgId = "msg_e_00005";
            }
        }
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsgId() {
        return errorMsgId;
    }

    public void setErrorMsgId(String errorMsgId) {
        this.errorMsgId = errorMsgId;
    }

    public String getSuccessMsgId() {
        return successMsgId;
    }

    public void setSuccessMsgId(String successMsgId) {
        this.successMsgId = successMsgId;
    }

    private void initMessage(SepE.ExecuteMode mode) {

        switch (mode) {
            case INSERT:
                this.successMsgId = "msg_i_00001";
                this.errorMsgId = "msg_e_00001";
                break;
            case UPDATE:
                this.successMsgId = "msg_i_00002";
                this.errorMsgId = "msg_e_00002";
                break;
            case DELETE:
                this.successMsgId = "msg_i_00003";
                this.errorMsgId = "msg_e_00003";
                break;
        }
    }
}
