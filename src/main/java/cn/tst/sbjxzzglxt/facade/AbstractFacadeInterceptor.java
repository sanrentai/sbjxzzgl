package cn.tst.sbjxzzglxt.facade;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author ZERO
 */
public class AbstractFacadeInterceptor {
    
    @AroundInvoke
    public Object closeEm(InvocationContext ctx) throws Exception {
        System.out.println("*** AbstractFacadeInterceptor intercepting");
        long start = System.currentTimeMillis();
        try {
            return ctx.proceed();
        } catch (Exception e) {
            throw e;
        } finally {
//            ((AbstractFacade) ctx.getTarget()).closeEntityManager();
            long time = System.currentTimeMillis() - start;
            System.out.println("用时:" + time + "ms");
            System.out.println(ctx.getClass().getSimpleName() + " " + ctx.getMethod().getName());
        }
    }
}
