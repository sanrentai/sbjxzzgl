package cn.tst.sbjxzzglxt.facade;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import cn.tst.sbjxzzglxt.common.SepC;
import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author ps_lbin@pscp.co.jp
 */
public class EntityManagerFactoryUtils {
    private final Map<String, EntityManagerFactory> EMF_INSTANCE_MAP = new HashMap<>();
    
    private static final EntityManagerFactoryUtils INSTANCE = new EntityManagerFactoryUtils();
    
    public static EntityManagerFactoryUtils getInstance() {
        return INSTANCE;
    }
    
    public EntityManager getEntityManager(String persistenceUnitName) {
        if (StringUtils.isEmpty(persistenceUnitName)) {
            persistenceUnitName = SepC.PERSISTENCE_UNIT;
        }
        if (EMF_INSTANCE_MAP.get(persistenceUnitName) == null) {
            synchronized (EMF_INSTANCE_MAP) {
                if (EMF_INSTANCE_MAP.get(persistenceUnitName) == null) {
                    EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
                    EMF_INSTANCE_MAP.put(persistenceUnitName, emf);
                }
            }
        }
        return EMF_INSTANCE_MAP.get(persistenceUnitName).createEntityManager();
    }
}
