package cn.tst.sbjxzzglxt.validator;

import java.util.Date;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import cn.tst.sbjxzzglxt.common.CConst;
import cn.tst.sbjxzzglxt.common.SepC;
import org.primefaces.component.calendar.Calendar;

/**
 * 日期范围验证器
 *
 * @author ps_xy@pscp.co.jp
 */
@FacesValidator("DateRangeValidator")
public class DateRangeValidator extends BaseValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        if (value == null) {
            return;
        }

        Date startDate = null;
        Date endDate = null;
        Map<String, Object> passThroughAttrs = null;

        //取得MessageID
        passThroughAttrs = component.getPassThroughAttributes();

        //日付開始コントロールID取得
        String startDateId = (String) passThroughAttrs.get("startDateId");

        //対象日付コントロールへ変換
        Calendar startCalendar = (Calendar) this.bizConfig.findComponent(startDateId);
//        Calendar startCalendar = (Calendar) context.getViewRoot()
//            .findComponent(this.bizConfig.getFaceMessageID(startDateId));

        Calendar endCalendar = (Calendar) component;

        /// 两个控件都通过验证才进行Check
        if (!startCalendar.isValid() || !endCalendar.isValid()) {
            return;
        }

        startDate = (Date) startCalendar.getValue();
        endDate = (Date) value;

        if (startDate == null || endDate == null) {
            return;
        }

        /// 如果开始日期 > 结束日期
        if (startDate.after(endDate)) {

            /// 获取错信息
            String msgText[] = String.valueOf(passThroughAttrs.get(SepC.S_MSG_KEY)).split(CConst.COMMA);
            String dateFrId = msgText[0];
            String dateToId = msgText[1];

            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                CConst.BLANK,
                this.bizConfig.getText("validate_is_startDateAfterEndDate",
                    this.bizConfig.getText(dateFrId),
                    this.bizConfig.getText(dateToId)));

            throw new ValidatorException(fm);
        }
    }

}
