package cn.tst.sbjxzzglxt.bizlogic.impl;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

/**
 *
 * @author ZERO
 */
public class BizLogicInterceptor {
    
    @AroundInvoke
    public Object closeEm(InvocationContext ctx) throws Exception {
        System.out.println("*** BizLogicInterceptor intercepting");
        long start = System.currentTimeMillis();
        try {
            EntityManager em = ((BaseBizLogic) ctx.getTarget()).am.getEntityManager();
//            em.close();
//            em = em.getEntityManagerFactory().createEntityManager();
//            ((BaseBizLogic) ctx.getTarget()).am.setEntityManager(em);
            em.joinTransaction();
            Object o = ctx.proceed();
            return o;
        } catch (Exception e) {
            throw e;
        } finally {
            long time = System.currentTimeMillis() - start;
            System.out.println("用时:" + time + "ms");
            System.out.println(ctx.getClass().getSimpleName() + " " + ctx.getMethod().getName());
        }
    }
}
