package cn.tst.sbjxzzglxt.controller.login;

import java.util.Enumeration;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author owner
 */
public class LoginSessionListener implements HttpSessionListener {
    
    @Inject
    GlobalLoginManager glbSessionManager;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("セッションの生成開始！！");
               Enumeration<String> nameEnums =  se.getSession().getAttributeNames();
        while(nameEnums.hasMoreElements()){
            System.out.println("属性名：" + nameEnums.nextElement());
        }
    }

    /**
     * セッション破棄する前の処理
     * @param se 
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("セッションの破棄を開始する・・・・・・・・・・・・・・・");
        HttpSession hs = se.getSession();
        System.out.println("セッションの破棄セッションハッシュコード:" + hs.hashCode());        
        String sessionId = hs.getId();
        System.out.println("セッションの破棄セッションID:" +sessionId);
        
        // セッション管理監視オブジェクトから取り除く
        glbSessionManager.removeSessionBySessionId(sessionId);
    }
}
