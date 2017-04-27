package cn.tst.sbjxzzglxt.bizlogic;

import cn.tst.sbjxzzglxt.entity.MstCaiDanXiangMu;
import cn.tst.sbjxzzglxt.viewmodel.MasterPageViewModel;

/**
 * 模板页务逻辑层
 *
 * @author ps_xy@pscp.co.jp
 */
public interface MasterPageBizLogic {

    /**
     * 初始化ViewModel
     *
     * @param vm 数据模型
     * @param yuanGongId 员工ID
     */
    void loadMasterPageBizLogic(MasterPageViewModel vm, String yuanGongId);

    /**
     * 获取当前菜单项目
     *
     * @param menuId 菜单ID
     * @param menuItemId 项目ID
     * @return
     */
    MstCaiDanXiangMu getCurrentCaiDanXiangMu(String menuId, String menuItemId);

}
