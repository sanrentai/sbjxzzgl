package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXiangMuGuanLi;

import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import org.primefaces.event.NodeSelectEvent;

/**
 * 巡检项目
 *
 * @author ps_xy@pscp.co.jp
 */
public interface BizLogic {
    void loadViewModel(ViewModel vm);
    
    void onNodeSelect(ViewModel vm, NodeSelectEvent event);
    
    void onAddNewItem(ViewModel vm);
    
    void onXunJianFangShiChange(ViewModel vm);
}
