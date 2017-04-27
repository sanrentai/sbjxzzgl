package cn.tst.sbjxzzglxt.exception;

/**
 * 物资属性信息实现类
 *
 * @author ps_xy@pscp.co.jp
 */
public class ExecuteException extends Exception {

    private String exceptionId;
    private String exceptionMessage;

    public ExecuteException(String exceptionId) {
        this.exceptionId = exceptionId;
    }

    public ExecuteException(String exceptionId, String exceptionMessage) {
        this.exceptionId = exceptionId;
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionId() {
        return exceptionId;
    }

    public void setExceptionId(String exceptionId) {
        this.exceptionId = exceptionId;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

}
