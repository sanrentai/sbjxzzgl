package cn.tst.sbjxzzglxt.converter;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import cn.tst.sbjxzzglxt.entity.MstBuMen;
import cn.tst.sbjxzzglxt.service.impl.MstBuMenFacade;
import org.apache.commons.lang3.StringUtils;

/**
 * 部门转换器
 *
 * @author ps_xy@pscp.co.jp
 */
//@FacesConverter(forClass = MstBuMen.class, value = "BuMenConverter")
@FacesConverter(value = "BuMenConverter")
public class BuMenConverter implements Converter {

    @EJB
    private MstBuMenFacade buMenService;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (!StringUtils.isEmpty(value)) {
            return buMenService.find(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value == null ? null : ((MstBuMen) value).getBuMenId();
    }

}
