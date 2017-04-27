package cn.tst.sbjxzzglxt.bizlogic.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.bizlogic.MasterPageBizLogic;
import cn.tst.sbjxzzglxt.entity.MstCaiDanXiangMu;
import cn.tst.sbjxzzglxt.entity.MstCaiDanXiangMuPK;
import cn.tst.sbjxzzglxt.service.impl.MstCaiDanXiangMuFacade;
import cn.tst.sbjxzzglxt.viewmodel.MasterPageViewModel;

/**
 *
 * @author andysilver
 */
@Stateless
public class MasterPageBizLogicImpl implements MasterPageBizLogic {

    @EJB
    private MstCaiDanXiangMuFacade caiDanXiangMuService;

    @Override
    public void loadMasterPageBizLogic(MasterPageViewModel vm, String yuanGongId) {

        ///获取用户可以使用的菜单
        List<MstCaiDanXiangMu> caiDanXiangMuList = this.caiDanXiangMuService.findMenuHasAuthoriy(yuanGongId);

        ///设置数据模型
        vm.setCaiDanXiangMuList(caiDanXiangMuList);
    }

    @Override
    public MstCaiDanXiangMu getCurrentCaiDanXiangMu(String menuId, String menuItemId) {
//        return caiDanXiangMuService.find(new MstCaiDanXiangMuPK(menuId, menuItemId));
        return caiDanXiangMuService.findByXiangMuId(menuItemId);
    }

}
