package cn.tst.sbjxzzglxt.viewmodel;

import java.util.List;
import java.util.stream.Collectors;
import cn.tst.sbjxzzglxt.common.CConst;
import cn.tst.sbjxzzglxt.entity.MstSystemConfig;
import org.apache.commons.lang3.StringUtils;

/**
 * 系统配置视图模型
 *
 * @author ps_xy@pscp.co.jp
 */
public class SystemConfigViewModel {

    ///菜单展开状态控制
    private boolean silmMenu;
    private MstSystemConfig config;

    public boolean isSilmMenu() {
        return silmMenu;
    }

    public void setSilmMenu(boolean silmMenu) {
        this.silmMenu = silmMenu;
    }

    public void swtichMenu() {
        this.silmMenu = !this.silmMenu;
    }

    public MstSystemConfig getConfig() {
        return config;
    }

    public void setConfig(MstSystemConfig config) {
        this.config = config;
    }

    /**
     * 系统颜色
     *
     * @return 返回系统颜色
     *
     */
    private String getTopBarColor() {
        return this.config.getColor() + "Topbar";
    }

    /**
     * 菜单类型
     *
     * @return 菜单类型字符串
     */
    private String getMenuType() {
        return this.silmMenu ? "SlimMenu" : "";
    }

    /**
     * 顶部菜单样式
     *
     * @return TopBar 样式
     */
    public String getTopBarStyle() {
        return StringUtils.join(new String[]{
            this.getTopBarColor(),
            this.getMenuType()
        }, CConst.SPACE);
    }
}
