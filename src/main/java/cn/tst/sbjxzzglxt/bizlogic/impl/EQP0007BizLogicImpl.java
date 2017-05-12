/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.bizlogic.impl;

import cn.tst.sbjxzzglxt.bizlogic.EQP0007BizLogic;
import cn.tst.sbjxzzglxt.common.CConst;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.entity.LTEquipGraphic;
import cn.tst.sbjxzzglxt.facade.LTEquipBasicFacade;
import cn.tst.sbjxzzglxt.facade.LTEquipGraphicFacade;
import cn.tst.sbjxzzglxt.viewmodel.EQP0007ViewModel;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@Stateless
public class EQP0007BizLogicImpl implements EQP0007BizLogic {
    @EJB
    private LTEquipBasicFacade equipmentDao;
    @EJB
    private LTEquipGraphicFacade equipmentGraphicFacade;
    @Override
    public void loadViewModel(EQP0007ViewModel vm) {
        vm.setEquipmentList(equipmentDao.findAll());
        vm.setSelectEquipGraphicList(equipmentGraphicFacade.findAll());
    }

    public LTEquipBasicFacade getEquipmentDao() {
        return equipmentDao;
    }

    public void setEquipmentDao(LTEquipBasicFacade equipmentDao) {
        this.equipmentDao = equipmentDao;
    }

    public LTEquipGraphicFacade getEquipmentGraphicFacade() {
        return equipmentGraphicFacade;
    }

    public void setEquipmentGraphicFacade(LTEquipGraphicFacade equipmentGraphicFacade) {
        this.equipmentGraphicFacade = equipmentGraphicFacade;
    }
    @Override
    public void onFileUploaded(FileUploadEvent event, String fileUploadPath, EQP0007ViewModel vm) {
        UploadedFile file = event.getFile();
        final String EXTENSION_NAME = FilenameUtils.getExtension(file.getFileName());
        final String FILE_NAME_ON_SERVER = UUID.randomUUID().toString().concat(CConst.DOT).concat(EXTENSION_NAME);
        try {
            Path originFilePath = Paths.get(fileUploadPath, SepC.UploadFileType.ORIGIN, FILE_NAME_ON_SERVER);
            Path compressedFilePath = Paths.get(fileUploadPath, SepC.UploadFileType.COMPRESSION, FILE_NAME_ON_SERVER);
            Path previewFilePath = Paths.get(fileUploadPath, SepC.UploadFileType.PREVIEW, FILE_NAME_ON_SERVER);

            Thumbnails.of(file.getInputstream()).scale(1, 1).toFile(new File(originFilePath.toString()));
            Thumbnails.of(file.getInputstream()).size(400, 320).toFile(new File(compressedFilePath.toString()));
            Thumbnails.of(file.getInputstream()).size(160, 100).toFile(new File(previewFilePath.toString()));
        } catch (IOException ex) {

        }
        vm.getEquipGraphicEntityInEdit().setFOriginalName(file.getFileName());
        vm.getEquipGraphicEntityInEdit().setFNameOnServer(FILE_NAME_ON_SERVER);
        List<LTEquipGraphic> list = equipmentGraphicFacade.findByOriginalName(file.getFileName());
        vm.getEquipGraphicEntityInEdit().setFVer(list.toArray().length + 1);
    }
    
    @Override
    public void onSaveData(EQP0007ViewModel vm) {
        equipmentGraphicFacade.create(vm.getEquipGraphicEntityInEdit());
        loadViewModel(vm);
    }
}
