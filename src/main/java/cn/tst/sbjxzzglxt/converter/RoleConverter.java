package cn.tst.sbjxzzglxt.converter;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import cn.tst.sbjxzzglxt.entity.MstRoleInfo;
import cn.tst.sbjxzzglxt.facade.MstRoleInfoFacade;
import org.apache.commons.lang3.StringUtils;

/**
 * 角色转换器
 *
 * @author ps_xy@pscp.co.jp
 */
//@FacesConverter(forClass = MstRoleInfo.class, value = "RoleConverter")
@FacesConverter(value = "RoleConverter")
public class RoleConverter implements Converter {

    @EJB
    private MstRoleInfoFacade roleService;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (!StringUtils.isEmpty(value)) {
            return roleService.find(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value == null ? null : ((MstRoleInfo) value).getRoleId();
    }

}
