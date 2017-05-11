package cn.tst.sbjxzzglxt.facade;

import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.entity.MstZhiNeng;

/**
 *
 * @author 紀
 */
@Stateless
public class MstZhiNengFacade extends AbstractFacade<MstZhiNeng> {

    public MstZhiNengFacade() {
        super(MstZhiNeng.class);
    }
}
