package cn.tst.sbjxzzglxt.exception;

/**
 *
 * @author owner
 */
public class LoginException extends Exception {

    private String errorCode;
    private String errorMessage;

    public LoginException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
