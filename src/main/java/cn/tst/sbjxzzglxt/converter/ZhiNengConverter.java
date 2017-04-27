package cn.tst.sbjxzzglxt.converter;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import cn.tst.sbjxzzglxt.entity.MstZhiNeng;
import cn.tst.sbjxzzglxt.service.impl.MstZhiNengFacade;
import org.apache.commons.lang3.StringUtils;

/**
 * 只能转换器
 *
 * @author ps_xy@pscp.co.jp
 */
//@FacesConverter(forClass = MstZhiNeng.class, value = "ZhiNengConverter")
@FacesConverter(value = "ZhiNengConverter")
public class ZhiNengConverter implements Converter {

    @EJB
    private MstZhiNengFacade zhiNengService;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (!StringUtils.isEmpty(value)) {
            return zhiNengService.find(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value == null ? null : ((MstZhiNeng) value).getZhiNengId();
    }

}
