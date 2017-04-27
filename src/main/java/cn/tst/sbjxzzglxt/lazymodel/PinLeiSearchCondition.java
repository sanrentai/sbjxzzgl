package cn.tst.sbjxzzglxt.lazymodel;

import java.io.Serializable;

/**
 * 品类信息延时加载模型
 *
 * @author ps_xy@pscp.co.jp
 */
public class PinLeiSearchCondition implements Serializable {

    private String pinLeiMing;
    private boolean onlyWuPin = false;
    private boolean onlyLeiBie = false;

    public PinLeiSearchCondition(boolean onlyWuPin) {
        this.onlyWuPin = onlyWuPin;
    }

    public PinLeiSearchCondition(String pinLeiMing, boolean onlyWuPin) {
        this.pinLeiMing = pinLeiMing;
    }

    public String getPinLeiMing() {
        return pinLeiMing;
    }

    public void setPinLeiMing(String pinLeiMing) {
        this.pinLeiMing = pinLeiMing;
    }

    public boolean isOnlyWuPin() {
        return onlyWuPin;
    }

    public void setOnlyWuPin(boolean onlyWuPin) {
        this.onlyWuPin = onlyWuPin;
    }

    public boolean isOnlyLeiBie() {
        return onlyLeiBie;
    }

    public void setOnlyLeiBie(boolean onlyLeiBie) {
        this.onlyLeiBie = onlyLeiBie;
    }

}
