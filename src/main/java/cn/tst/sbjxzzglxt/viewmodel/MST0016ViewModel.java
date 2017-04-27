package cn.tst.sbjxzzglxt.viewmodel;

import java.util.List;
import cn.tst.sbjxzzglxt.entity.MstSystemConfig;

/**
 * 系统设定视图模型
 *
 * @author ps_lbin@pscp.co.jp
 */
public class MST0016ViewModel extends BaseViewModel {

    ///编辑中的系统设置
    private MstSystemConfig editingSystemConfig;

    ///系统设置一览
    private List<MstSystemConfig> systemConfigList;

    public MST0016ViewModel() {
    }

    public MstSystemConfig getEditingSystemConfig() {
        return editingSystemConfig;
    }

    public void setEditingSystemConfig(MstSystemConfig editingSystemConfig) {
        this.editingSystemConfig = editingSystemConfig;
    }

    public List<MstSystemConfig> getSystemConfigList() {
        return systemConfigList;
    }

    public void setSystemConfigList(List<MstSystemConfig> systemConfigList) {
        this.systemConfigList = systemConfigList;
    }

}
