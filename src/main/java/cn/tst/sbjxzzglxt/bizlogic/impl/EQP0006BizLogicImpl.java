package cn.tst.sbjxzzglxt.bizlogic.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.bizlogic.EQP0001BizLogic;
import cn.tst.sbjxzzglxt.bizlogic.EQP0006BizLogic;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipError;
import cn.tst.sbjxzzglxt.entity.LTEquipWarn;
import cn.tst.sbjxzzglxt.service.impl.LTEquipBasicFacade;
import cn.tst.sbjxzzglxt.service.impl.LTEquipErrorFacade;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.EQP0001ViewModel;
import cn.tst.sbjxzzglxt.viewmodel.EQP0005ViewModel;
import cn.tst.sbjxzzglxt.viewmodel.EQP0006ViewModel;
import java.util.UUID;

/**
 * 仓库信息业务逻辑实现类
 *
 * @author ps_xy@pscp.co.jp
 */
@Stateless
public class EQP0006BizLogicImpl extends BaseBizLogic implements EQP0006BizLogic {

    @EJB
    private LTEquipErrorFacade equipError;

    @Override
    public void loadEQP0006ViewModel(EQP0006ViewModel vm) {
         List<LTEquipError> equip = equipError.findAll();
         vm.setEquipErrorList(equip);
        
    }

  
    public ExecuteResult onSaveEquipError(SepE.ExecuteMode mode, EQP0006ViewModel vm) {

        ExecuteResult result = new ExecuteResult(mode);
        LTEquipError target = vm.getEquipError();
        try {
            switch (mode) {
                case INSERT:
//                    target.setId(UUID.randomUUID().toString());
                    equipError.create(target);
                    break;
                case UPDATE:
                    equipError.edit(target);
                    break;
                case DELETE:
                    equipError.remove(target);
                    break;
            }
            result.setSuccess(true);
         
        } catch (Exception e) {
            result.anylizeException(e);
            result.setSuccess(false);
        }
        return result;
    }

    public ExecuteResult onEquipError(SepE.ExecuteMode mode, EQP0006ViewModel vm) {
        //先创建一个执行结果的对象，并把mode的放进去
        ExecuteResult result = new ExecuteResult(mode);
        //从视图中取出EquipWarn
        LTEquipError target = vm.getEquipError();
        try {
            //判断执行模式，如果是INSERT就把数据添加，UPDATE就进行修改，DELETE进行修改。
            switch (mode) {
                case INSERT:
//                    target.setId(UUID.randomUUID().toString());
                    equipError.create(target);
                    break;
                case UPDATE:
                    equipError.edit(target);
                    break;
                case DELETE:
                   equipError.remove(target);
                    break;
            }
            //执行结果如果是成功的，转化就设置为true。

            vm.setEquipErrorList(equipError.findAll());
            result.setSuccess(true);
            //刷新数据后存储到EquipWarn中

        } catch (Exception e) {
            result.anylizeException(e);
            result.setSuccess(false);
        }
        return result;
    }

   

   



}
