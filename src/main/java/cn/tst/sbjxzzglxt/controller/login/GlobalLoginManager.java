package cn.tst.sbjxzzglxt.controller.login;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author owner
 */
@ApplicationScoped
public class GlobalLoginManager implements Serializable {

    // キー：ログインユーザ、値：セッション
    private final Map loginSessionMap = new HashMap();

    private final Map loginIDMap = new HashMap();

    /**
     *
     */
    public void saveLoginId(String sessionId, String loginId) {
        loginIDMap.put(sessionId, loginId);
    }

    /**
     * ログイン成功後にセッションを登録する。
     *
     * @param user
     * @param session
     */
    public void saveLoginSession(String user, HttpSession session) {

        System.out.println("成功されたログインユーザの追加！！");
        loginSessionMap.put(user, session);
    }

    /**
     * セッションＩＤによりセッション間接に取り除く
     *
     * @param sessionId
     */
    public void removeSessionBySessionId(String sessionId) {
        String userId = (String) loginIDMap.get(sessionId);
        if (userId != null) {
            removeSessionByUserId(userId);

            // セッションIDに対応するユーザの取り除く
            this.loginIDMap.remove(sessionId);
        }
    }

    /**
     * ユーザＩＤにより、セッションを取り除く
     *
     * @param userId
     */
    public void removeSessionByUserId(String userId) {
        try {
            this.loginSessionMap.remove(userId);
        } catch (Exception e) {

        }
    }

    /**
     * 別の場所に同時に同じＩＤでログインし作業の有無チェック
     *
     * @param user
     * @return
     */
    public boolean loginInApplication(String user) {
        HttpSession oldSession = (HttpSession) loginSessionMap.get(user);
        if (oldSession != null) {
            System.out.println("別場所のセッション：" + oldSession.hashCode());
            return true;
        }
        return false;
    }

    /**
     * システムから別の場所の処理をログアウトする。
     *
     * @param user
     */
    public boolean deleteOtherSession(String user) {

        boolean isDeleted = false;

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

        // ログイン成功セッションを共通管理マネージャに登録
        HttpSession currentSession = request.getSession();

        HttpSession oldSession = (HttpSession) loginSessionMap.get(user);

        String sessionId = oldSession.getId();

        loginIDMap.remove(sessionId);

        // グルーバルセッション管理マップからトロ除く
        loginSessionMap.remove(user);

        if (oldSession == null) {
            return isDeleted;
        }

        // 違うセッションの場合破棄する
        if (oldSession.hashCode() != currentSession.hashCode()) {
            try {
                oldSession.invalidate();
                isDeleted = true;
            } catch (Exception e) {
                System.out.println("旧セッションすでに存在していない！");
            }
            System.out.println("旧セッションを破棄した");
        } else {
        }
        return isDeleted;
    }
}
