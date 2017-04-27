package cn.tst.sbjxzzglxt.viewmodel;

import java.util.List;
import cn.tst.sbjxzzglxt.entity.MstCaiDanXiangMu;

/**
 * 模板页务数据模型
 *
 * @author ps_xy@pscp.co.jp
 */
public class MasterPageViewModel {

    List<MstCaiDanXiangMu> caiDanXiangMuList;

    public MasterPageViewModel() {

    }

    public List<MstCaiDanXiangMu> getCaiDanXiangMuList() {
        return caiDanXiangMuList;
    }

    public void setCaiDanXiangMuList(List<MstCaiDanXiangMu> caiDanXiangMuList) {
        this.caiDanXiangMuList = caiDanXiangMuList;
    }
}
