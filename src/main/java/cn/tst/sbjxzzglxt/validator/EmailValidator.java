package cn.tst.sbjxzzglxt.validator;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import cn.tst.sbjxzzglxt.common.CConst;
import cn.tst.sbjxzzglxt.common.SepC;
import org.apache.commons.lang3.StringUtils;

/**
 * Email バリデーター
 *
 * @作成者：パワースター　夏 曄
 */
@FacesValidator("EmailValidator")
public class EmailValidator extends BaseValidator implements Validator {

    private Pattern pattern = null;
    private Matcher matcher = null;

    public EmailValidator() {

        super();

        pattern = Pattern.compile(SepC.Regex.EMAIL_PATTERN);
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        String msgText = null;
        Map<String, Object> passThroughAttrs = null;

        //未入力の場合チェックしない
        if (StringUtils.isEmpty(value.toString())) {
            return;
        }

        //検証チェック
        matcher = pattern.matcher(value.toString());

        //メールアドレスフォーマット不正の場合
        if (!matcher.matches()) {

            //表示名のMessageIDを取得する
            passThroughAttrs = component.getPassThroughAttributes();

            msgText = this.bizConfig.getText(String.valueOf(passThroughAttrs.get(SepC.S_MSG_KEY)));

            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                CConst.BLANK,
                this.bizConfig.getText("validate_reg_format", msgText));

            throw new ValidatorException(fm);
        }
    }

}
