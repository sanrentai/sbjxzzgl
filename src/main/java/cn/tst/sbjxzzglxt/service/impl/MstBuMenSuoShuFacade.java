package cn.tst.sbjxzzglxt.service.impl;

import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.entity.MstBuMenSuoShu;

/**
 *
 * @author 紀
 */
@Stateless
public class MstBuMenSuoShuFacade extends AbstractFacade<MstBuMenSuoShu> {

    public MstBuMenSuoShuFacade() {
        super(MstBuMenSuoShu.class);
    }

}
