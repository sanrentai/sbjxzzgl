package cn.tst.sbjxzzglxt.lazymodel;

import cn.tst.sbjxzzglxt.common.SepE;

/**
 * 项目LazyMode检索条件
 *
 * @author ps_xy@pscp.co.jp
 */
public class XiangMuSearchCondition {

    private String xiangMuMing;
    
    private SepE.GuiJiXiangQuFen guiJiXiangQuFen;

    public SepE.GuiJiXiangQuFen getGuiJiXiangQuFen() {
        return guiJiXiangQuFen;
    }

    public void setGuiJiXiangQuFen(SepE.GuiJiXiangQuFen guiJiXiangQuFen) {
        this.guiJiXiangQuFen = guiJiXiangQuFen;
    }

    public String getXiangMuMing() {
        return xiangMuMing;
    }

    public void setXiangMuMing(String xiangMuMing) {
        this.xiangMuMing = xiangMuMing;
    }
}
