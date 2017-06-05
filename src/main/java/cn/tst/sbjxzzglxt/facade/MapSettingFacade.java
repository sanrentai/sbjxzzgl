/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.facade;

import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.MapSetting;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@Stateless
public class MapSettingFacade extends AbstractFacade<MapSetting> {
    public MapSettingFacade() {
        super(MapSetting.class);
    }
    @Override
    public List<MapSetting> findAll() {
        Query query = getEntityManager().createNamedQuery("MapSetting.findAll");
        query.setParameter("delFlg", SepE.Flag.NO.getValue());
        return query.getResultList();
    }
}
