/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.service.impl;

import cn.tst.sbjxzzglxt.entity.LTEquipNotes;
import javax.ejb.Stateless;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@Stateless
public class LTEquipNotesFacade extends AbstractFacade<LTEquipNotes> {
    public LTEquipNotesFacade() {
        super(LTEquipNotes.class);
    }
}
