package cn.tst.sbjxzzglxt.service.impl;

import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.entity.MstXiTongGongNeng;

/**
 *
 * @author 紀
 */
@Stateless
public class MstXiTongGongNengFacade extends AbstractFacade<MstXiTongGongNeng> {

    public MstXiTongGongNengFacade() {
        super(MstXiTongGongNeng.class);
    }
}
