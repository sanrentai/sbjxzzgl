package cn.tst.sbjxzzglxt.controller.master;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.sbjxzzglxt.bizlogic.MST0004BizLogic;
import cn.tst.sbjxzzglxt.common.CConst;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.common.SepE.ExecuteMode;
import cn.tst.sbjxzzglxt.controller.BusinessBaseController;
import cn.tst.sbjxzzglxt.entity.DatYuanGongSuoShu;
import cn.tst.sbjxzzglxt.entity.DatYuanGongSuoShuPK;
import cn.tst.sbjxzzglxt.entity.MstYuanGong;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.MST0004ViewModel;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 * 员工信息管理
 *
 * @author ps_xy@pscp.co.jp
 */
@ViewScoped
@Named(SepC.ControllerID.MST0004)
public class MST0004Controller extends BusinessBaseController {

    ///图片上传目录
    private final String FILE_UPLOAD_PATH
        = this.getServletContext().getInitParameter(SepC.INIT_PARAM_UPLOAD_DIRECTORY) + "/profile";

    private MST0004ViewModel vm;

    @EJB
    private MST0004BizLogic bizLogic;

    @PostConstruct
    public void init() {

        ///初始化视图模型对象
        this.vm = new MST0004ViewModel();

        this.bizLogic.loadMST0004ViewModel(vm);

    }
    
    public void liZhi(MstYuanGong row) {
        bizLogic.liZhi(vm, row);
        putInfoMessage("修改成功");
    }

    /**
     * 开始编辑
     */
    public void onStartEditing() {

        this.vm.initYuanGong();

        ///新建模式
        this.switchEditMode2Insert();

        ///开始编辑
        this.switchStatus2Editing();
    }

    /**
     * 刷新数据
     */
    public void onRefreshData() {
        this.bizLogic.loadMST0004ViewModel(vm);
    }

    /**
     * 取消编辑
     */
    public void onCancelEditing() {
        ///初始模式
        this.switchStatus2Init();

        ///编辑模式
        this.switchEditMode2None();

        ///初试化员工对象
        this.vm.setEditingYuanGong(null);
    }

    /**
     * 保存编辑的员工
     */
    public void onSaveYuanGong() {

        SepE.ExecuteMode mode = StringUtils.isEmpty(this.vm.getEditingYuanGong().getYuanGongId())
            ? SepE.ExecuteMode.INSERT : SepE.ExecuteMode.UPDATE;

        ///执行新建 or 更新
        ExecuteResult result = this.bizLogic.saveYuanGong(mode, this.vm.getEditingYuanGong());

        ///添加消息
        this.addToGlobalGrowl(result.createMessage());

        ///如果更新活新建成功后
        if (result.isSuccess()) {
            ///初试化编辑的对象
            this.vm.initYuanGong();

            this.switchStatus2Editing();
        }
    }

    /**
     * 员工照片上传时
     */
    public void onFileUploaded(FileUploadEvent event) {

        UploadedFile yuGongPhoto = event.getFile();

        if (yuGongPhoto == null) {
            return;
        }
        try {

            ///源文件的扩展名
            final String EXTENSION_NAME = FilenameUtils.getExtension(yuGongPhoto.getFileName());

            ///上传后的文件名
            final String FILE_NAME = UUID.randomUUID().toString().concat(CConst.DOT).concat(EXTENSION_NAME);

            ///只存照片名字,不存路径
            this.vm.getEditingYuanGong().setZhaoPianLuJing(FILE_NAME);

            ///压缩后图片保存路径
            Path originFilePath = Paths.get(this.FILE_UPLOAD_PATH, SepC.UploadFileType.ORIGIN, FILE_NAME);

            ///压缩后图片保存路径
            Path compressedFilePath = Paths.get(this.FILE_UPLOAD_PATH, SepC.UploadFileType.COMPRESSION, FILE_NAME);

            ///压缩后图片保存路径
            Path previewFilePath = Paths.get(this.FILE_UPLOAD_PATH, SepC.UploadFileType.PREVIEW, FILE_NAME);

            ///预览用后图片保存路径
            ///压缩图片
            Thumbnails.of(yuGongPhoto.getInputstream()).size(512, 400).toFile(new File(originFilePath.toString()));
            Thumbnails.of(yuGongPhoto.getInputstream()).size(400, 320).toFile(new File(compressedFilePath.toString()));
            Thumbnails.of(yuGongPhoto.getInputstream()).size(160, 100).toFile(new File(previewFilePath.toString()));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 编辑员工
     *
     * @param row 选中的行
     */
    public void onEditYuanGong(MstYuanGong row) {

        ///设置编辑的对象
        this.vm.setEditingYuanGong(row);

        ///开始编辑
        this.switchStatus2Editing();

        ///更新模式
        this.switchEditMode2Update();

        ///获取职能历史
        this.bizLogic.refreshZhiNengData(this.vm);
    }

    /**
     * 保存所属关系
     */
    public void onSaveSuoShu() {

        ExecuteResult result = null;
        DatYuanGongSuoShu editingYGSH = this.vm.getEditingSuoShu();
        DatYuanGongSuoShuPK pk = editingYGSH.getPk();

        ///设置部门ID
        pk.setBuMenId(editingYGSH.getBuMen().getBuMenId());

        ///设置职能ID
        pk.setZhiNengId(editingYGSH.getZhiNeng().getZhiNengId());

        ///验证数据是否交错
        if (this.bizLogic.checkZaiRenRiqiBeforeLastData(vm)) {
            this.addMessage(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                null,
                "相同部门,相同职能的在任日期必须小于过去的历史"));
            return;
        }

        ///只能更新
        ExecuteMode mode = StringUtils.isEmpty(editingYGSH.getInsRep())
            ? SepE.ExecuteMode.INSERT : SepE.ExecuteMode.UPDATE;

        result = this.bizLogic.saveSuoShu(mode, editingYGSH);

        this.addMessage(result.createMessage());

        if (result.isSuccess()) {
            this.bizLogic.refreshZhiNengData(vm);
        }
    }

    /**
     * 取消编辑职能信息
     */
    public void onCloseSuoShuDialog() {
        ///获取职能历史
        this.bizLogic.refreshZhiNengData(this.vm);
    }

    /**
     * 编辑所属关系
     *
     * @param row 选中的行
     */
    public void onEditSuoShu(DatYuanGongSuoShu row) {
        this.vm.setEditingSuoShu(row);
    }

    /**
     * 删除所属
     *
     * @param row 选中的行
     */
    public void onDeleteSuoShu(DatYuanGongSuoShu row) {

        this.vm.setEditingSuoShu(row);

        ExecuteResult result = null;

        ///删除职能
        result = this.bizLogic.saveSuoShu(SepE.ExecuteMode.DELETE, this.vm.getEditingSuoShu());

        this.addMessage(result.createMessage());

        if (result.isSuccess()) {
            this.bizLogic.refreshZhiNengData(vm);
        }

    }

    public MST0004ViewModel getVm() {
        return vm;
    }

    public void setVm(MST0004ViewModel vm) {
        this.vm = vm;
    }
}
