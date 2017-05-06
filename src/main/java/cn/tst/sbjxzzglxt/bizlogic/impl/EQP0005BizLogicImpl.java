package cn.tst.sbjxzzglxt.bizlogic.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.sbjxzzglxt.bizlogic.EQP0005BizLogic;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.common.SepE;
import cn.tst.sbjxzzglxt.entity.LTEquipWarn;
import cn.tst.sbjxzzglxt.service.impl.LTEquipWarnFacade;
import cn.tst.sbjxzzglxt.viewmodel.ExecuteResult;
import cn.tst.sbjxzzglxt.viewmodel.EQP0005ViewModel;
import java.util.List;

/**
 * 仓库信息业务逻辑实现类
 *
 * @author ps_xy@pscp.co.jp
 */
@Stateless
public class EQP0005BizLogicImpl extends BaseBizLogic implements EQP0005BizLogic {
    //注入service实体类
    @EJB
    private LTEquipWarnFacade equipWarnFacade;
    

    public void loadEQP0005ViewModel(EQP0005ViewModel vm) {
        //把全部数据放进数据库
      List<LTEquipWarn> equip = equipWarnFacade.findAll();
      vm.setEquipWarnList(equip);
    }

  
    public ExecuteResult onEquipWarn(SepE.ExecuteMode mode, EQP0005ViewModel vm) {
        //先创建一个执行结果的对象，并把mode的放进去
        ExecuteResult result = new ExecuteResult(mode);
        //从视图中取出EquipWarn
        LTEquipWarn target =  vm.getEquipWarn();
        try {
            //判断执行模式，如果是INSERT就把数据添加，UPDATE就进行修改，DELETE进行修改。
            switch (mode) {
                case INSERT:
//                    target.setId(UUID.randomUUID().toString());
                    equipWarnFacade.create(target);
                    break;
                case UPDATE:
                    equipWarnFacade.edit(target);
                    break;
                case DELETE:
                    equipWarnFacade.remove(target);
                    break;
            }
            //执行结果如果是成功的，转化就设置为true。
            result.setSuccess(true);
            //刷新数据后存储到EquipWarn中
           
        } catch (Exception e) {
            result.anylizeException(e);
            result.setSuccess(false);
        }
        return result;
    }

}
