/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.SheBeiGuanLi.WenDangJiTuPianGuanLi;

import cn.tst.sbjxzzglxt.bizlogic.impl.BaseBizLogic;
import cn.tst.sbjxzzglxt.common.CConst;
import cn.tst.sbjxzzglxt.common.EquipmentTree;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipGraphic;
import cn.tst.sbjxzzglxt.facade.LTEquipBasicFacade;
import cn.tst.sbjxzzglxt.facade.LTEquipGraphicFacade;
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
public class WenDangJiTuPianGuanLiBizLogicImpl extends BaseBizLogic implements BizLogic {
    @EJB
    private LTEquipBasicFacade equipmentFacade;
    @EJB
    private LTEquipGraphicFacade equipmentGraphicFacade;
    @Override
    public void loadViewModel(ViewModel vm) {
        vm.setEquipmentList(equipmentFacade.findAll());
        vm.setEquipmentTreeRoot(EquipmentTree.createEqpTree(vm.getEquipmentList()));
    }

    public LTEquipBasicFacade getEquipmentFacade() {
        return equipmentFacade;
    }

    public void setEquipmentFacade(LTEquipBasicFacade equipmentFacade) {
        this.equipmentFacade = equipmentFacade;
    }

    public LTEquipGraphicFacade getEquipmentGraphicFacade() {
        return equipmentGraphicFacade;
    }

    public void setEquipmentGraphicFacade(LTEquipGraphicFacade equipmentGraphicFacade) {
        this.equipmentGraphicFacade = equipmentGraphicFacade;
    }
    
    private void uploadFile(ViewModel vm) {
        String fileUploadPath = Controller.FILE_UPLOAD_PATH;
        UploadedFile file = vm.getCurrentUploadedFile();
        final String EXTENSION_NAME = FilenameUtils.getExtension(file.getFileName());
        final String FILE_NAME_ON_SERVER = UUID.randomUUID().toString().concat(CConst.DOT).concat(EXTENSION_NAME);
        try {
            Path originFilePath = Paths.get(fileUploadPath, SepC.UploadFileType.ORIGIN, FILE_NAME_ON_SERVER);
            Path compressedFilePath = Paths.get(fileUploadPath, SepC.UploadFileType.COMPRESSION, FILE_NAME_ON_SERVER);
            Path previewFilePath = Paths.get(fileUploadPath, SepC.UploadFileType.PREVIEW, FILE_NAME_ON_SERVER);

            Thumbnails.of(file.getInputstream()).scale(1, 1).toFile(new File(originFilePath.toString()));
            Thumbnails.of(file.getInputstream()).size(400, 320).toFile(new File(compressedFilePath.toString()));
            Thumbnails.of(file.getInputstream()).size(85, 100).toFile(new File(previewFilePath.toString()));
        } catch (IOException ex) {

        }
        vm.getEquipmentDocumentInEdit().setFOriginalName(file.getFileName());
        vm.getEquipmentDocumentInEdit().setFNameOnServer(FILE_NAME_ON_SERVER);
//        List<LTEquipGraphic> list = equipmentGraphicFacade.findByOriginalName(file.getFileName());
//        vm.getEquipmentDocumentInEdit().setFVer(list.toArray().length + 1);
    }
    
    @Override
    public void onEditNewDocumentSubmit(ViewModel vm) {
        uploadFile(vm);
        equipmentGraphicFacade.create(vm.getEquipmentDocumentInEdit());
        loadViewModel(vm);
        vm.setEquipmentDocumentInEdit(null);
        vm.setSelectedEquipmentDocumentList(vm.getCurrentEquipment().getGraphicList());
    }
    @Override
    public void onEquipmentNodeSelect(ViewModel vm, LTEquipBasic equipment) {
        vm.setCurrentEquipment(equipment);
        vm.setSelectedEquipmentDocumentList(equipment.getGraphicList());
    }
    /*
     * 调用时机 当点击新建按钮的时候调用
     * 功能目标 创建一个正在编辑的文档对象
     * 步骤 创建一个默认的文档对象，将它的设备编号设置为当前设备的编号，然后将该对象赋给vm的当前编辑的文档对象
    */
    @Override
    public void onEditNewDocument(ViewModel vm) {
        LTEquipGraphic document = new LTEquipGraphic();
        document.seteNum(vm.getCurrentEquipment().getENum());
        document.setfVer(1);
        vm.setEquipmentDocumentInEdit(document);
    }
    @Override
    public void onFileSelectToUpload(ViewModel vm, FileUploadEvent event) {
        vm.setCurrentUploadedFile(event.getFile());
        vm.getEquipmentDocumentInEdit().setFOriginalName(event.getFile().getFileName());
    }
    /*
     * @调用时机 当点击更新按钮的时候调用
     * @功能目标 将vm的当前编辑的文档设置为被选中的文档
    */
    @Override
    public void onEditDocumentToUpdate(ViewModel vm, LTEquipGraphic document) {
        vm.setEquipmentDocumentInEdit(document);
        vm.getEquipmentDocumentInEdit().setFOriginalName("");
    }
    @Override
    public void onEditDocumentToUpdateSubmit(ViewModel vm) {
        uploadFile(vm);
        vm.getEquipmentDocumentInEdit().setfVer(vm.getEquipmentDocumentInEdit().getfVer() + 1);
        equipmentGraphicFacade.edit(vm.getEquipmentDocumentInEdit());
        loadViewModel(vm);
        vm.setEquipmentDocumentInEdit(null);
        vm.setSelectedEquipmentDocumentList(vm.getCurrentEquipment().getGraphicList());
    }
}
