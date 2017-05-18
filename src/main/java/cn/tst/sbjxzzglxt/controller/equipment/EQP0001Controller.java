package cn.tst.sbjxzzglxt.controller.equipment;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.sbjxzzglxt.bizlogic.EQP0001BizLogic;
import cn.tst.sbjxzzglxt.common.CConst;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipProRule;
import cn.tst.sbjxzzglxt.entity.LTEquipProperty;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.EQP0001ViewModel;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.primefaces.model.UploadedFile;

/**
 * 仓库管理
 *
 * @author ps_xy@pscp.co.jp
 */
@ViewScoped
@Named(SepC.ControllerID.EQP0001)
public class EQP0001Controller extends BusinessBaseController {

    private static final Logger LOG = Logger.getLogger(EQP0001Controller.class.getName());

    private final String T_ROOT = "T_ROOT";

    ///选中的节点
    private TreeNode selectedNode;

    ///视图模型
    private EQP0001ViewModel vm;
    
    ///图片上传目录
    private final String FILE_UPLOAD_PATH
        = this.getServletContext().getInitParameter(SepC.INIT_PARAM_UPLOAD_DIRECTORY) + "/pingmiantu";

    @EJB
    private EQP0001BizLogic bizLogic;

    @PostConstruct
    public void init() {

        ///初始化视图模型
        this.vm = new EQP0001ViewModel();

        this.bizLogic.loadEQP0001ViewModel(vm);

        ///初始化设备树
        vm.setEquipTreeRoot(createEqpTree(vm.getEquipBasicList()));
    }

    //*****************************************************************
    //                        公有函数定义
    //*****************************************************************
    /**
     * 选中节点时
     */
    public void onNodeSelect(NodeSelectEvent event) {

        this.selectedNode = event.getTreeNode();

        vm.setSelectedEquipBasic((LTEquipBasic) selectedNode.getData());
        vm.setSelectEquipBasicList(new ArrayList());
        vm.getSelectEquipBasicList().add(vm.getSelectedEquipBasic());
        for (LTEquipBasic item : vm.getSelectedEquipBasic().getChildren()) {
            vm.getSelectEquipBasicList().add(item);
        }

        ///是否为邮件菜单点击事件
//        this.onStartNodeEditing();
    }

    /**
     * 菜单右击选中
     *
     * @param type
     */
    public void onStartNodeEditing() {

        if (selectedNode == null) {
            return;
        }

        this.switchStatus2Editing();

    }

    /**
     * 删除节点
     *
     * @param type
     */
    public void onDeleteNode(String type) {

    }

    public void onEditEquip(LTEquipBasic row) {
        vm.setEditingEquipBasic(row);
    }

    public void onDeleteEquip(LTEquipBasic row) {
        ///删除模式
        SepE.ExecuteMode mode = SepE.ExecuteMode.DELETE;
        vm.setEditingEquipBasic(row);

        ///执行更新
        ExecuteResult result = this.bizLogic.onSaveEquipment(mode, vm);

        if (result.isSuccess()) {
            putInfoMessage("删除成功");

            onCancelEdit();
        } else {
            putErrorMessage("删除失败");
        }
    }

    public void onAddTargetData() {
        vm.setEditingEquipBasic(new LTEquipBasic());
        if (selectedNode == null) {
            vm.getEditingEquipBasic().setcId(new Long(SepC.EQP_ROOT));
        } else {
//            LTEquipBasic l = (LTEquipBasic) selectedNode.getData();
//            vm.getEditingEquipBasic().setcId(l.getId());
            vm.getEditingEquipBasic().setcId(vm.getSelectedEquipBasic().getId());
        }
    }

    public void onAddPorperty() {
        vm.setEditingEquipProperty(new LTEquipProperty());
    }

    /**
     * 編集取消
     */
    public void onCancelEdit() {

        ///初始化状态
//        this.switchStatus2Init();
        ///无模式
//        this.switchEditMode2None();
        vm.setEditingEquipBasic(null);
        selectedNode = null;
        vm.setEquipTreeRoot(createEqpTree(vm.getEquipBasicList()));
    }

    /**
     * 取消树选择
     */
    public void onCancelShuXuanZhe() {
        vm.setSelectedEquipBasic(null);
        selectedNode = null;
    }
    
    /**
     * 上传图片
     * @param event 
     */
    
    public void onFileUploaded(FileUploadEvent event) {

        UploadedFile pingMianTu = event.getFile();

        if (pingMianTu == null) {
            return;
        }
        try {

            ///源文件的扩展名
            final String EXTENSION_NAME = FilenameUtils.getExtension(pingMianTu.getFileName());

            ///上传后的文件名
            final String FILE_NAME = UUID.randomUUID().toString().concat(CConst.DOT).concat(EXTENSION_NAME);
            
            ///原图片
            Path originFilePath = Paths.get(this.FILE_UPLOAD_PATH, SepC.UploadFileType.ORIGIN, FILE_NAME);

            ///压缩后图片保存路径
            Path compressedFilePath = Paths.get(this.FILE_UPLOAD_PATH, SepC.UploadFileType.COMPRESSION, FILE_NAME);

            ///压缩后图片保存路径
            Path previewFilePath = Paths.get(this.FILE_UPLOAD_PATH, SepC.UploadFileType.PREVIEW, FILE_NAME);

            ///预览用后图片保存路径
            ///压缩图片
            Thumbnails.of(pingMianTu.getInputstream()).size(400, 320).toFile(new File(compressedFilePath.toString()));
            Thumbnails.of(pingMianTu.getInputstream()).size(160, 100).toFile(new File(previewFilePath.toString()));
            ///原图片
            Thumbnails.of(pingMianTu.getInputstream()).scale(1.0f).toFile(new File(originFilePath.toString()));

            ///只存照片名字,不存路径
            this.vm.getEditingEquipBasic().setPingMianTu(FILE_NAME);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 保存数据
     *
     */
    public void onSaveData() {

        SepE.ExecuteMode mode = this.vm.getEditingEquipBasic().getId() == null
                ? SepE.ExecuteMode.INSERT : SepE.ExecuteMode.UPDATE;

        ExecuteResult result = this.bizLogic.onSaveEquipment(mode, vm);

        this.addMessage(result.createMessage());

        if (result.isSuccess()) {
            onCancelEdit();
        }
    }

    public void onSaveProperty() {

        SepE.ExecuteMode mode = this.vm.getEditingEquipProperty().getId() == null
                ? SepE.ExecuteMode.INSERT : SepE.ExecuteMode.UPDATE;

        ExecuteResult result = this.bizLogic.onSaveProperty(mode, vm);

        this.addMessage(result.createMessage());

        if (result.isSuccess()) {
            vm.setEditingEquipProperty(null);
        }
    }

    public void changeCanShuSelection(LTEquipProperty item) {
        LTEquipBasic selectedEquipBasic = vm.getSelectedEquipBasic();
        if (selectedEquipBasic.getEquipProRuleList() == null) {
            selectedEquipBasic.setEquipProRuleList(new ArrayList<>());
        } else {

            LTEquipProRule newProRule = new LTEquipProRule();
            newProRule.setENum(vm.getSelectedEquipBasic().getENum());
            newProRule.setPId(item.getId());
            newProRule.setEquipProperty(item);
            selectedEquipBasic.getEquipProRuleList().add(newProRule);
        }
    }

    public void onDeleteCanShu(LTEquipProRule row) {
        vm.getSelectedEquipBasic().getEquipProRuleList().remove(row);
    }

    //*****************************************************************
    //                        私有函数定义
    //*****************************************************************

    //*****************************************************************
    //                        Getter Setter
    //*****************************************************************

    public EQP0001ViewModel getVm() {
        return vm;
    }

    public void setVm(EQP0001ViewModel vm) {
        this.vm = vm;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

}
