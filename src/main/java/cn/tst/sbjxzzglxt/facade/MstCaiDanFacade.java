package cn.tst.sbjxzzglxt.facade;

import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.entity.MstCaiDan;

/**
 * 菜单Facade实现类
 *
 * @author ps_xy@pscp.co.jp
 */
@Stateless
public class MstCaiDanFacade extends AbstractFacade<MstCaiDan> {

    public MstCaiDanFacade() {
        super(MstCaiDan.class);
    }
}
