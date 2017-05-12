package cn.tst.sbjxzzglxt.facade;

import cn.tst.sbjxzzglxt.common.SepE;
import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.entity.LTEquipProperty;
import java.util.List;
import javax.persistence.Query;

/**
 * 设备实现类
 *
 * @author 曹春
 */
@Stateless
public class LTEquipPropertyFacade extends AbstractFacade<LTEquipProperty> {

    public LTEquipPropertyFacade() {
        super(LTEquipProperty.class);
    }

}
