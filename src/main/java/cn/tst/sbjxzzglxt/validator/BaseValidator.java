package cn.tst.sbjxzzglxt.validator;

import cn.tst.sbjxzzglxt.common.BizConfig;

/**
 * 验证器抽象积累
 *
 * @author ps_xy@pscp.co.jp
 */
public class BaseValidator {

    protected final BizConfig bizConfig;

    public BaseValidator() {
        bizConfig = new BizConfig();
    }
}
