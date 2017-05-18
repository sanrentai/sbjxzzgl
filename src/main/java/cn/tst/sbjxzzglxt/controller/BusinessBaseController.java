package cn.tst.sbjxzzglxt.controller;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import cn.tst.sbjxzzglxt.common.BizConfig;
import cn.tst.sbjxzzglxt.common.CConst;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.controller.login.AccountManager;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 * 业务类基类
 *
 * @author ps_xy@pscp.co.jp
 */
public class BusinessBaseController extends BaseController {

    ///编辑模式
    protected SepE.EditMode editMode = SepE.EditMode.NONE;

    ///画面状态
    protected SepE.PageStatus pageStatus = SepE.PageStatus.INIT;

    @Inject
    private BizConfig bizConfig;

    @Inject
    protected AccountManager accountManager;

    /**
     * FaceMessageListにエラータイプを取得
     *
     * @param controlId フォームコントロールID
     * @return
     */
    private FacesMessage.Severity getFacesMessage(String controlId) {

        List<FacesMessage> messageList = this.getFacesContext().getMessageList("frmMain:" + controlId);

        if (messageList == null) {
            return null;
        }

        if (messageList.isEmpty()) {
            return null;
        }

        return messageList.get(0).getSeverity();
    }

    /**
     * エラーがあるかどうか
     *
     * @param controlId フォームコントロールID
     * @return
     */
    public boolean unValidFiled(String controlId) {
        return this.getFacesMessage(controlId) != null;
    }

    /**
     * Valid項目のメッセージを取得
     *
     * @param controlId フォームコントロールID
     * @param replaceStr 置換文字
     * @return
     */
    public String getFiledValidMessage(String controlId, String replaceStr) {
        if (this.unValidFiled(controlId)) {
            return isRequiredMessage(replaceStr);
        }
        return CConst.BLANK;
    }

    /**
     * バリデート結果CSSを返す
     *
     * @param controlId フォームコントロールID
     * @return
     */
    public String getValidateCSS(String controlId) {

        FacesMessage.Severity severity = this.getFacesMessage(controlId);

        if (severity == null) {
            return CConst.BLANK;
        }

        if (FacesMessage.SEVERITY_INFO.equals(severity)) {
            return CConst.BLANK;
        } else if (FacesMessage.SEVERITY_WARN.equals(severity)) {
            return CConst.BLANK;
        } else if (FacesMessage.SEVERITY_ERROR.equals(severity)) {
            return "error";
        } else {
            return CConst.BLANK;
        }
    }

    /**
     *
     * @param key
     * @return
     */
    public String getText(String key) {
        return bizConfig.getText(key);
    }

    /**
     * リソース内容を取得する関数
     *
     * @param key 鍵
     * @param messages 置換文字列
     * @return 値
     */
    public String getText(String key, Object... messages) {
        return bizConfig.getText(key, messages);
    }

    /**
     * EL表現式でMessageの置き換え
     *
     * @param formatStr　フォーマットString
     * @param messages　置換文字
     * @return
     */
    public String getTextWithReplace(String formatStr, Object... messages) {
        if (StringUtils.isEmpty(formatStr)) {
            return CConst.BLANK;
        }
        return MessageFormat.format(formatStr, messages);
    }

    /**
     * 必須入力のメッセージ
     *
     * @param messages 項目名
     * @return
     */
    public String isRequiredMessage(String messages) {
        return getTextWithReplace(this.getText("validate_is_required"), messages);
    }

    /**
     * 日付フォーマット不正のメッセージ
     *
     * @param messages 項目名
     * @return
     */
    public String dateUnvalidMessage(String messages) {
        return getTextWithReplace(this.getText("validate_date_format"), messages);
    }

    /**
     * num以上の数字のみのメッセージ
     *
     * @param messages 項目名
     * @param num
     * @return
     */
    public String isMustAbove(String messages, int num) {
        return getTextWithReplace(this.getText("validate_reg_isMustAbove"), messages, num);
    }

    /**
     * num以上の数字のみのメッセージ
     *
     * @param messages 項目名
     * @param num
     * @return
     */
    public String isMustAboveDouble(String messages, double num) {
        return getTextWithReplace(this.getText("validate_reg_isMustAbove"), messages, num);
    }

    /**
     * 数字だけのメッセージ
     *
     * @param messages 項目名
     * @return
     */
    public String numberOnly(String messages) {
        return getTextWithReplace(this.getText("validate_reg_numberonly"), messages);
    }

    /**
     * 初期状态
     *
     * return true:状态为初期
     *
     */
    public boolean isStatusInit() {
        return SepE.PageStatus.INIT == this.pageStatus;
    }

    /**
     * 編集中
     *
     * @return true:状态为编辑
     */
    public boolean isStatusEditing() {
        return SepE.PageStatus.EDITING == this.pageStatus;
    }

    /**
     * 只读状态
     *
     * @return true:状态为只读
     */
    public boolean isStatusReadOnly() {
        return SepE.PageStatus.READONLY == this.pageStatus;
    }

    /**
     * 删除模式
     *
     * @return true:新建模式
     */
    public boolean isInsertMode() {
        return SepE.EditMode.INSERT == this.editMode;
    }

    /**
     * 删除模式
     *
     * @return true:新建模式
     */
    public boolean isUpdateMode() {
        return SepE.EditMode.UPDATE == this.editMode;
    }

    /**
     * 删除模式
     *
     * @return true:新建模式
     */
    public boolean isDeleteMode() {
        return SepE.EditMode.DELETE == this.editMode;
    }

    /**
     * 编辑模式: 无
     */
    public void switchEditMode2None() {
        this.editMode = SepE.EditMode.NONE;
    }

    /**
     * 编辑模式: 选择
     */
    public void switchEditMode2Select() {
        this.editMode = SepE.EditMode.SELECT;
    }

    /**
     * 编辑模式: 新建
     */
    public void switchEditMode2Insert() {
        this.editMode = SepE.EditMode.INSERT;
    }

    /**
     * 编辑模式: 新建
     */
    public void switchEditMode2Update() {
        this.editMode = SepE.EditMode.UPDATE;
    }

    /**
     * 编辑模式: 编辑
     */
    public void switchEditMode2Delete() {
        this.editMode = SepE.EditMode.DELETE;
    }

    /**
     * 编辑模式: 删除
     */
    public void switchStatus2Init() {
        this.pageStatus = SepE.PageStatus.INIT;
    }

    /**
     * 状态切换: 编辑中
     */
    public void switchStatus2Editing() {
        this.pageStatus = SepE.PageStatus.EDITING;
    }

    /**
     * 状态切换: 只读
     */
    public void switchStatus2ReadOnly() {
        this.pageStatus = SepE.PageStatus.READONLY;
    }

    /**
     * 添加错误消息到全局弹出框
     *
     * @param detailMessage 出错信息
     */
    protected void putErrorMessage(String detailMessage) {
        this.addToGlobalGrowl(new FacesMessage(FacesMessage.SEVERITY_ERROR, null, detailMessage));
    }

    /**
     * 添加警告消息到全局弹出框
     *
     * @param detailMessage 警告信息
     */
    protected void putWarnMessage(String detailMessage) {
        this.addToGlobalGrowl(new FacesMessage(FacesMessage.SEVERITY_WARN, null, detailMessage));
    }

    /**
     * 添加信息消息到全局弹出框
     *
     * @param detailMessage 信息
     */
    protected void putInfoMessage(String detailMessage) {
        this.addToGlobalGrowl(new FacesMessage(FacesMessage.SEVERITY_INFO, null, detailMessage));
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }

    public void doNothing() {

    }

    /**
     * 使用java正则表达式去掉小数多余的.与0
     *
     * @param num
     * @return
     */
    public static String subZeroAndDot(BigDecimal num) {
        return subZeroAndDot(num.toString());
    }

    /**
     * 使用java正则表达式去掉小数多余的.与0
     *
     * @param s
     * @return
     */
    public static String subZeroAndDot(String s) {
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");//去掉多余的0    
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉    
        }
        return s;
    }

    /**
     * 创建仓库树
     *
     * @param equipBasicList 传人设备列表
     * @return 返回设备树
     */
    public static DefaultTreeNode createEqpTree(List<LTEquipBasic> equipBasicList) {
        ///根节点
        DefaultTreeNode result = new DefaultTreeNode("Root", null);
        for (LTEquipBasic item : equipBasicList) {
            TreeNode subNode = new DefaultTreeNode(item, result);
            subNode.setExpanded(false);
            createRelationTree(subNode, item);
        }
        return result;
    }

    /**
     * 创建下一层节点
     *
     * @param node 品类关系节点
     * @param data 节点数据
     */
    static private void createRelationTree(TreeNode node, LTEquipBasic data) {
        createRelationTree(node, data, false);
    }

    /**
     * 创建下一层节点
     *
     * @param node 品类关系节点
     * @param data 节点数据
     * @param isNeedExpand 节点是否展开
     */
    static private void createRelationTree(TreeNode node, LTEquipBasic data, boolean isNeedExpand) {

        ///取得当前节点的所有子节点
        Set<LTEquipBasic> children = data.getChildren();

        ///如果存在子节点
        if (children != null && !children.isEmpty()) {
            ///遍历所有子节点
            children.forEach(c -> {

                ///当前节点ID
                String currentNodeId = c.getId().toString();

                ///如果不是根节点,怎创建子节点
                if (!SepC.EQP_ROOT.equals(currentNodeId)) {
                    TreeNode subNode = new DefaultTreeNode(c, node);
                    subNode.setExpanded(isNeedExpand);

//                    if (c.getPinLei().isLeibie()) {
//                        /// 设置假的子节点表示用于表示该节点下有品类
//                        long count = bizLogic.getChildrenCount(c);
//                        if (count != 0) {
//                            TreeNode tmpNode = new DefaultTreeNode(null, subNode);
//                            tmpNode.setExpanded(false);
//                        }
//                    }
                    ///递归展
                    createRelationTree(subNode, c, isNeedExpand);

                }
            });
        }
    }
}
