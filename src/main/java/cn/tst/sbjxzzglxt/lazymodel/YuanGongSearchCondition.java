package cn.tst.sbjxzzglxt.lazymodel;

import java.io.Serializable;

/**
 * 员工信息延时加载模型
 *
 * @author ps_xy@pscp.co.jp
 */
public class YuanGongSearchCondition implements Serializable {

    private String empName;
    private String sex;
    private String email;
    private String cellPhoneNumber;
    private String address;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
