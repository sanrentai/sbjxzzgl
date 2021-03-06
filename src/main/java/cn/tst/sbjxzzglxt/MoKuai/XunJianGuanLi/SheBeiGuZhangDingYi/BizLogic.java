package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.SheBeiGuZhangDingYi;

import cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.LuRuRen.*;
import cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXiangMuGuanLi.*;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipCheckPoint;
import cn.tst.sbjxzzglxt.entity.LTEquipError;
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
     * @param eNum
     * @return
     */
    LTEquipBasic findSelectedEqp(Long eNum);

    /**
     * 查询故障信息
     *
     * @param vm
     * @param eNum
     * @return
     */
    List<LTEquipError> chaGuZhangXinXi(ViewModel vm, Long eNum);

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
     * 用于保存故障记录
     *
     * @param vm
     * @param mode
     * @return 
     *
     */
    public ExecuteResult onEquipError(SepE.ExecuteMode mode,ViewModel vm);
    /**
     * 用于保存故障信息
     *
     * @param vm
     * @param mode
     * @return 
     *
     */
    public ExecuteResult onErrorMessage(SepE.ExecuteMode mode, ViewModel vm);

    //用于显示故障列表中的故障类型
    public List<LTEquipErrorMessage> chaGuZhangLeiXing(Long id);

   

}
