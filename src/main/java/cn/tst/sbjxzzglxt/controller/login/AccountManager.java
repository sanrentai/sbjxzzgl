package cn.tst.sbjxzzglxt.controller.login;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.entity.MstSystemConfig;
import cn.tst.sbjxzzglxt.service.impl.EntityManagerFactoryUtils;

@Named
@SessionScoped
public class AccountManager implements Serializable {
    
    /// 公司信息
    private MstSystemConfig systemConfig;
    
    private EntityManager em = null;
    
    private final Map<String, EntityManager> emMap = new HashMap<>();

    /// 登录信息
    LoginInfo loginInfo = new LoginInfo();

    private boolean loginIsSuccess;
    private String multiLoginMsg;

    public void setMultiLoginMsg(String msg) {
        this.multiLoginMsg = msg;
    }

    public String getMultiLoginMsg() {
        return multiLoginMsg;
    }

    public LoginInfo getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    public boolean isLoginIsSuccess() {
        return loginIsSuccess;
    }

    public void setLoginIsSuccess(boolean loginIsSuccess) {
        this.loginIsSuccess = loginIsSuccess;
    }

    public MstSystemConfig getSystemConfig() {
        return systemConfig;
    }

    public void setSystemConfig(MstSystemConfig systemConfig) {
        this.systemConfig = systemConfig;
//        em = getEntityManager(systemConfig.getDbName());
    }
    
    public EntityManager getEntityManager(String persistenceUnitName) {
        if (emMap.get(persistenceUnitName) == null) {
            emMap.put(persistenceUnitName, EntityManagerFactoryUtils.getInstance().getEntityManager(persistenceUnitName));
        }
        return emMap.get(persistenceUnitName);
    }

    public EntityManager getEntityManager() {
        if (em == null) {
            String persistenceUnitName;
            if (systemConfig == null) {
                persistenceUnitName = SepC.PERSISTENCE_UNIT;
            } else {
                persistenceUnitName = systemConfig.getDbName();
            }
            em = getEntityManager(persistenceUnitName);
        }
        return em;
    }
    
    public EntityManager getNewEntityManager() {
        if (em != null) {
            em.close();
        }
        em = EntityManagerFactoryUtils.getInstance().getEntityManager(systemConfig.getDbName());
        return em;
    }

//    public void setEntityManager(EntityManager em) {
//        this.em = em;
//    }
    
//    @PreDestroy
//    public void destoryEntityManager() {
//        if (em != null) {
//            em.close();
//        }
//        for (Map.Entry<String, EntityManager> entry : emMap.entrySet()) {
//            EntityManager value = entry.getValue();
//            value.close();
//        }
//    }
    
    public boolean isAdmin() {
        if (this.getLoginInfo() == null || this.getLoginInfo().getLoginId() == null) {
            return false;
        }
        
        return "admin".equals(this.getLoginInfo().getLoginId());
    }
}
