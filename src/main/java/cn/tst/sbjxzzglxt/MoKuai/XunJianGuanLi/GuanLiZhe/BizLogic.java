package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.GuanLiZhe;

import cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.LuRuRen.*;
import cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXiangMuGuanLi.*;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipCheckPoint;
import cn.tst.sbjxzzglxt.entity.LTEquipErrorMessage;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionItems;
import cn.tst.sbjxzzglxt.viewmodel.EQP0005ViewModel;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.event.NodeSelectEvent;

/**
 * 巡检项目
 *
 * @author ps_xy@pscp.co.jp
 */
public interface BizLogic {

    void loadViewModel(ViewModel vm);

    /**
     * 当前选中设备
     *
     * @param id 设备id
     * @return
     */
    LTEquipBasic findSelectedEqp(Long id);

    /**
     * 查询巡检点记录
     *
     * @param vm
     * @param equipmentId
     * @return
     */
    List<LTEquipCheckPoint> chaXunJianDian(ViewModel vm, Long equipmentId);

    /**
     * 用于巡检项目的增删改
     *
     * @param mode
     * @param vm
     * @return
     */
    ExecuteResult onXiangMu(SepE.ExecuteMode mode, ViewModel vm);

    /**
     * 用于初始化项目列表
     *
     * @param id
     * @return
     */
    public List<SysRoutingInspectionItems> chaXiangMu(Integer id);

    /**
     * 用于判断新建状态
     *
     * @return
     */
    public List<LTEquipCheckPoint> chaXinXi();

    /**
     * 用于展示故障列表
     *
     * @param vm
     */
    public void xuanZeGuZhang(ViewModel vm);

    /**
     * 用于把故障弹窗的信息保存到故障实例
     *
     * @param vm
     */
    public void baoCunGuZhang(ViewModel vm);

    /**
     * 用于保存项目
     *
     * @param vm
     * @param mode
     *
     */
    public void baoCunXiangMu(ViewModel vm);

    /**
     * 用于查询故障名称
     *
     * @param list
     * @return 
     *
     */
//    public List chaGuZhangMing(ArrayList list);

}
