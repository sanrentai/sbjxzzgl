package cn.tst.sbjxzzglxt.viewmodel;

/**
 * 编码变更ViewModel
 *
 * @author ps_liubin@pscp.co.jp
 */
public class ChangePasswordViewModel {

    private String password;
    private String passwordConfirm;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    /**
     * 判断两次数据如密码是否相同
     *
     * @return true: 相同 false:不同
     */
    public boolean isSameInputValueBetween2Password() {
        return password.equals(passwordConfirm);
    }

}
