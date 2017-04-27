package cn.tst.sbjxzzglxt.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.sbjxzzglxt.bizlogic.GongZuoTaiBizLogic;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.viewmodel.GongZuoTaiViewModel;
import org.primefaces.context.RequestContext;

/**
 * 工作台控制器
 *
 * @author ps_lbin@pscp.co.jp
 */
@ViewScoped
@Named(SepC.ControllerID.GONG_ZUO_TAI)
public class GongZuoTaiController extends BusinessBaseController {

    private GongZuoTaiViewModel vm;

    @EJB
    private GongZuoTaiBizLogic bizLogic;


    /**
     * 页面初始化
     */
    @PostConstruct
    public void init() {

        this.vm = new GongZuoTaiViewModel();

        this.bizLogic.loadGongZuoTaiBizLogic(vm);
        
        /// 默认5秒刷新一次
        vm.setUpdateInterval(120);
    }
    
    public void update() {
        this.bizLogic.loadGongZuoTaiBizLogic(vm);
//        if (vm.isHasNew()) {
//            RequestContext req = RequestContext.getCurrentInstance();
//            req.execute("PF('frmMain:ovPnlGongZuoTai').show('#{component.clientId}')");
//            vm.setHasNew(false);
//        }
    }

    //***********************************************************************************************
    //                                  私有方法全部放在类的最下方
    //***********************************************************************************************

    public GongZuoTaiViewModel getVm() {
        return vm;
    }

    public void setVm(GongZuoTaiViewModel vm) {
        this.vm = vm;
    }

}
