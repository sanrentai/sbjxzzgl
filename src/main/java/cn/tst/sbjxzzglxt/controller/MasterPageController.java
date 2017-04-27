package cn.tst.sbjxzzglxt.controller;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.sbjxzzglxt.bizlogic.MasterPageBizLogic;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.entity.MstCaiDan;
import cn.tst.sbjxzzglxt.entity.MstCaiDanXiangMu;
import cn.tst.sbjxzzglxt.viewmodel.MasterPageViewModel;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 * 菜单控制器控制器
 *
 * @author ps_xy@pscp.co.jp
 */
@ViewScoped
@Named(SepC.ControllerID.MASTER)
public class MasterPageController extends BusinessBaseController {

    private MasterPageViewModel vm;

    @EJB
    private MasterPageBizLogic bizLogic;

    private String moKuaiId = SepC.MoKuaiCategory.WU_ZI;
    private String selectedFunctionId;        //选中的菜单项目ID
    private String contentURL;                //加载画面的URL
    private MenuModel wuZiMenuModel;              //菜单模型
    private MenuModel cheLiangMenuModel;
    private MenuModel nengYuanMenuModel;
    private MenuModel yongYouMenuModel;
    private MenuModel yongMeiMenuModel;
    private MenuModel weiWaiMenuModel;
    private MenuModel settingsMenuModel;

    public String getSelectedFunctionId() {
        return selectedFunctionId;
    }

    public String getContentURL() {
        return contentURL;
    }

    public MenuModel getMenus() {
        switch (this.moKuaiId) {
            case SepC.MoKuaiCategory.WU_ZI:
                return wuZiMenuModel;
            case SepC.MoKuaiCategory.CHE_LIANG:
                return cheLiangMenuModel;
            case SepC.MoKuaiCategory.NENG_YUAN:
                return nengYuanMenuModel;
            case SepC.MoKuaiCategory.YONG_YOU:
                return yongYouMenuModel;
            case SepC.MoKuaiCategory.YONG_MEI:
                return yongMeiMenuModel;
            case SepC.MoKuaiCategory.WEI_WAI:
                return weiWaiMenuModel;
            case SepC.MoKuaiCategory.SETTINGS:
                return settingsMenuModel;
            default:
                return wuZiMenuModel;
        }
//        return wuZiMenuModel;
    }

    public MenuModel getCheLiangMenuModel() {
        return cheLiangMenuModel;
    }

    public MenuModel getNengYuanMenuModel() {
        return nengYuanMenuModel;
    }
    
    public MenuModel getSettingsMenuModel() {
        return settingsMenuModel;
    }
    
    public void setMoKuaiId(String moKuaiId) {
        this.moKuaiId = moKuaiId;
    }

    /**
     * 页面初始化
     */
    @PostConstruct
    public void init() {

        this.vm = new MasterPageViewModel();

        this.bizLogic.loadMasterPageBizLogic(vm,
            this.accountManager.getLoginInfo().getYuanGong().getYuanGongId());

        ///菜单的做成
        this.createMenu();
    }

    //***********************************************************************************************
    //                                  私有方法全部放在类的最下方
    //***********************************************************************************************
    private void createMenu() {

        ///创建Menu模型
        this.wuZiMenuModel = new DefaultMenuModel();
        this.cheLiangMenuModel = new DefaultMenuModel();
        this.nengYuanMenuModel = new DefaultMenuModel();
        this.settingsMenuModel = new DefaultMenuModel();
        this.yongYouMenuModel = new DefaultMenuModel();
        this.yongMeiMenuModel = new DefaultMenuModel();
        this.weiWaiMenuModel = new DefaultMenuModel();

        ///通过明细行groupBy转换成Header -> Detail
        Map<MstCaiDan, List<MstCaiDanXiangMu>> groupByMenus
            = this.vm.getCaiDanXiangMuList().stream()
            .collect(Collectors.groupingBy(MstCaiDanXiangMu::getMenu))
            .entrySet()
            .stream()
            .sorted((v1, v2) -> Integer.compare(v1.getKey().getPaixu(), v2.getKey().getPaixu()))
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));

        convertMapToMenu(SepC.MoKuaiCategory.WU_ZI, groupByMenus, wuZiMenuModel);
        convertMapToMenu(SepC.MoKuaiCategory.CHE_LIANG, groupByMenus, cheLiangMenuModel);
        convertMapToMenu(SepC.MoKuaiCategory.YONG_YOU, groupByMenus, yongYouMenuModel);
        convertMapToMenu(SepC.MoKuaiCategory.YONG_MEI, groupByMenus, yongMeiMenuModel);
        convertMapToMenu(SepC.MoKuaiCategory.WEI_WAI, groupByMenus, weiWaiMenuModel);
        convertMapToMenu(SepC.MoKuaiCategory.NENG_YUAN, groupByMenus, nengYuanMenuModel);
        convertMapToMenu(SepC.MoKuaiCategory.SETTINGS, groupByMenus, settingsMenuModel);

        System.out.println(this.wuZiMenuModel);
    }
    
    private void convertMapToMenu(String moKuaiId, Map<MstCaiDan, List<MstCaiDanXiangMu>> groupByMenus, MenuModel menuModel) {
        groupByMenus.forEach((k, v) -> {
            DefaultSubMenu titleItem = new DefaultSubMenu();
            final String pageFunctionPath;

            switch (k.getCaidanId()) {
                case "BIZ":
                    pageFunctionPath = "business/";
                    break;
                case "ARP":
                    pageFunctionPath = "approval/";
                    break;
                case "SUP":
                    pageFunctionPath = "supply/";
                    break;
                case "INV":
                    pageFunctionPath = "inventory/";
                    break;
                case "MST":
                    pageFunctionPath = "master/";
                    break;
                case "CAR":
                    pageFunctionPath = "car/";
                    break;
                case "YOU":
                    pageFunctionPath = "inventory/";
                    break;
                case "MEI":
                    pageFunctionPath = "inventory/";
                    break;
                case "WAI":
                    pageFunctionPath = "weiwai/";
                    break;
                case "MET":
                    pageFunctionPath = "meter/";
                    break;
                default:
                    return;
            }

            ///创建子菜单
            v.stream().filter(e -> e.getPk().getMoKuaiId().equals(moKuaiId)).forEach(subMenu -> {
                DefaultMenuItem menuItem = new DefaultMenuItem();

                String commandName = MessageFormat.format("#'{' {0}.transfer2Page(''{1}'',''{2}'') '}'",
                        SepC.ControllerID.MASTER,
                        subMenu.getPk().getXiangMuId(),
                        pageFunctionPath);

                ///子菜单项目名
                menuItem.setValue(subMenu.getXiangMuMing());
                ///Ajax请求
                menuItem.setAjax(true);
                ///设置为异步的
                menuItem.setAsync(false);
                ///设置Ajax请求命令
                menuItem.setCommand(commandName);
                ///不做任何验证
                menuItem.setImmediate(true);
                ///重置所有值
                menuItem.setResetValues(true);
                ///直提交自己
                menuItem.setProcess("@this");
                ///PageLoad 动画效果
                menuItem.setOnstart("restartPace();");
                ///更新页面内容
                menuItem.setUpdate("frmMain:sub_content");
                ///添加子菜单
                titleItem.addElement(menuItem);
            });
            if (titleItem.getElementsCount() != 0) {
                titleItem.setLabel(k.getCaidanName());
                ///添加菜单
                menuModel.addElement(titleItem);
            }
        });
    }
    
    /**
     * 物资申请审批
     */
    public void showARP0001(){
        transfer2Page("ARP0001", "approval/");
        setShowGZT(true);
    }
    
    /*
    购买申请审批
    */
    public void showARP0002(){
        transfer2Page("ARP0002", "approval/");
        setShowGZT(true);
    }
    
    /**
     * 采购计划审批
     */
    public void showARP0003(){
        transfer2Page("ARP0003", "approval/");
        setShowGZT(true);
    }
    /**
     * 采购支付计划审批
     */
    public void showARP0009(){
        transfer2Page("ARP0009", "approval/");
        setShowGZT(true);
    }
    
    /**
     * 物资申请受理
     */
    public void showINV0011(){
        transfer2Page("INV0011", "inventory/");
        setShowGZT(true);
    }
    /**
     * 物资调配
     */
    public void showINV0001(){
        transfer2Page("INV0001", "inventory/");
        setShowGZT(true);
    }
    
    /**
     * 备货确认
     */
    public void showINV0007(){
        transfer2Page("INV0007", "inventory/");
        setShowGZT(true);
    }

    /**
     * 购买申请一栏
     */
    public void showINV0008(){
        transfer2Page("INV0008", "inventory/");
        setShowGZT(true);
    }
    /**
     * 采购计划制定
     */
    public void showSUP0001(){
        transfer2Page("SUP0001", "supply/");
        setShowGZT(true);
    }
    /**
     * 分配采购任务
     */
    public void showSUP0002(){
        transfer2Page("SUP0002", "supply/");
        setShowGZT(true);
    }
    /**
     * 采购计划执行
     */
    public void showSUP0003(){
        transfer2Page("SUP0003", "supply/");
        setShowGZT(true);
    }
    /**
     * 物资入库
     */
    public void showINV0004(){
        transfer2Page("INV0004", "inventory/");
        setShowGZT(true);
    }
    /**
     * 物资出库
     */
    public void showINV0005(){
        transfer2Page("INV0005", "inventory/");
        setShowGZT(true);
    }
    /**
     * 物资调拨申请受理
     */
    public void showINV0009(){
        transfer2Page("INV0009", "inventory/");
        setShowGZT(true);
    }
    /**
     * 物资申请
     */
    public void showBIZ0001(){
        transfer2Page("BIZ0001", "business/");
        setShowGZT(true);
    }
    /**
     * 请求领货
     */
    public void showBIZ0004(){
        transfer2Page("BIZ0004", "business/");
        setShowGZT(true);
    }

    /**
     * 是否显示工作台
    */
    private boolean showGZT;

    
    public boolean getShowGZT() {
        return showGZT;
    }

    public void setShowGZT(boolean showGZT) {
        this.showGZT = showGZT;
    }
    /**
     * Ajax页面跳转
     *
     * @param menuItemId 菜单ID
     * @param pageFunctionPath 跳转页面路径
     */
    public void transfer2Page(String menuItemId, String pageFunctionPath) {

        ///设置嵌入页面的URL
        this.contentURL = "/views/" + pageFunctionPath + menuItemId + ".xhtml";

        ///从视图种删除不相关的控制器
        this.removeUnsedControllerFromViewMap("ctrl" + menuItemId);
    }

    /**
     * 删除未使用的控制器ID
     *
     * @param currentControllerId 当前控制器ID
     */
    private void removeUnsedControllerFromViewMap(String currentControllerId) {

        ///删除不需要加载的对象控制器
        this.getViewMap().entrySet().removeIf(entry -> {
            ///要规避的ID 这些控制器不能删除 !!!
            return !SepC.ControllerID.LOGIN.equals(entry.getKey())
                && !SepC.ControllerID.MASTER.equals(entry.getKey())
                && !SepC.ControllerID.SYSTEM_CONFIG.equals(entry.getKey())
                && !SepC.ControllerID.GONG_ZUO_TAI.equals(entry.getKey())
                && !currentControllerId.equals(entry.getKey());
        });

        //测试LOG
        this.getViewMap().forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });

        ///强制回收内存
        System.gc();
    }

    /**
     * 创建页面Title
     *
     * @param menuId 菜单ID
     * @param menuItemId 菜单项目ID
     * @return 页面Title内容
     */
    public String createPageTitle(String menuId, String menuItemId) {

        ///获取当前是使用的项目ID
        MstCaiDanXiangMu current = this.bizLogic.getCurrentCaiDanXiangMu(menuId, menuItemId);

        return current.getMenu().getCaidanName() + " > " + current.getXiangMuMing() + "(" + menuItemId + ")";
    }

    public MasterPageViewModel getVm() {
        return vm;
    }

    public void setVm(MasterPageViewModel vm) {
        this.vm = vm;
    }

}
