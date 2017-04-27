package cn.tst.sbjxzzglxt.lazymodel;

import java.io.Serializable;
import cn.tst.sbjxzzglxt.common.SepE;

/**
 * 供应商检索条件
 *
 * @author ps_xy@pscp.co.jp
 */
public class GongYingShangSearchCondition implements Serializable {

    /// 供应商名
    private String gongYingShangMing;
    /// 品类名
    private String pinLeiMing;
    /// 提供物资类型
    private SepE.TiGongFuWuLeiXing leiXing;

    public SepE.TiGongFuWuLeiXing getLeiXing() {
        return leiXing;
    }

    public void setLeiXing(SepE.TiGongFuWuLeiXing leiXing) {
        this.leiXing = leiXing;
    }

    public String getGongYingShangMing() {
        return gongYingShangMing;
    }

    public void setGongYingShangMing(String gongYingShangMing) {
        this.gongYingShangMing = gongYingShangMing;
    }

    public String getPinLeiMing() {
        return pinLeiMing;
    }

    public void setPinLeiMing(String pinLeiMing) {
        this.pinLeiMing = pinLeiMing;
    }

}
