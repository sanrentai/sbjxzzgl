package cn.tst.sbjxzzglxt.validator;

import java.math.BigDecimal;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import cn.tst.sbjxzzglxt.common.CConst;
import cn.tst.sbjxzzglxt.common.SepC;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * 0 以上验证器
 * <p>
 * 页面自定义验证器,对象框中只能输入0以上的数字
 * </p>
 *
 * @author ps_xy@pscp.co.jp
 */
@FacesValidator("AboveZeroValidator")
public class AboveZeroValidator extends BaseValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        String msgText = null;
        Map<String, Object> passThroughAttrs = null;

        ///验证是否为一个数字,不是数字则结束验证
        if (value != null && NumberUtils.isNumber(value.toString())) {

            BigDecimal num = BigDecimal.valueOf(Double.valueOf(value.toString()));

            ///0 or 0 以下的数值时显示错误
            if (num.compareTo(BigDecimal.ZERO) <= 0) {

                ///表示名のMessageIDを取得する
                passThroughAttrs = component.getPassThroughAttributes();

                ///取得错误信息
                msgText = this.bizConfig.getText(passThroughAttrs.get(SepC.S_MSG_KEY).toString());

                ///设置错误信息
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    CConst.BLANK,
                    msgText);

                ///抛出错误
                throw new ValidatorException(fm);
            }
        }
    }

}
