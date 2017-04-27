package cn.tst.sbjxzzglxt.filter;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.tst.sbjxzzglxt.common.CConst;
import cn.tst.sbjxzzglxt.common.SepC;
import cn.tst.sbjxzzglxt.controller.login.AccountManager;
import org.apache.commons.lang3.CharEncoding;

/**
 *
 * @author owner アノテーションの設定により、web.xmlに書かなくてもＯＫ<br />
 * ここでは [/*] を設定すると、login.xhtml画面その物もフィルタリンクされるため<br />
 * 無限ループになる可能性がある。
 *
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = {"/views/*"})
public class AuthenticationFilter implements Filter {

    // アカウントを注入する
    @Inject
    private AccountManager accountManager;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {

        // セッション保存チェック
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        req.setCharacterEncoding(CharEncoding.UTF_8);
        res.setCharacterEncoding(CharEncoding.UTF_8);

        try {

            String reqURI = req.getRequestURI();

            ///判断是否为资源文件
            final boolean IS_RESOURCES = reqURI.contains("resources")
                || reqURI.contains("javax.faces.resource");

            ///是否为登录画面
            final boolean IS_LOGIN_PAGE = reqURI.contains("login.xhtml");

            ///修改密码页面
            final boolean IS_CHANGE_PASSWORD_PAGE = reqURI.contains("changePassword.xhtml");

            ///是否已经登录
            final boolean HAS_LOGINED = this.accountManager != null && this.accountManager.isLoginIsSuccess();

            //エラーページからのリクエストかどうか
            final boolean IS_ERROR_PAGE = reqURI.contains(SepC.ErrorPagePathConst.CODE_404)
                || reqURI.contains(SepC.ErrorPagePathConst.CODE_403)
                || reqURI.contains(SepC.ErrorPagePathConst.CODE_500);

            if (IS_RESOURCES || IS_LOGIN_PAGE || IS_ERROR_PAGE) {
                chain.doFilter(request, response);
                return;
            }

            if (HAS_LOGINED) {

                ///如果是第一次登录,则跳转入密码变更画面
                if (!IS_CHANGE_PASSWORD_PAGE && accountManager.getLoginInfo().isIsFirstTimeLogin()) {
                    res.sendRedirect(req.getContextPath()
                        + "/views/changePassword.xhtml");
                    return;
                }

                chain.doFilter(request, response);

            } else {
                res.sendRedirect(req.getContextPath()
                    + CConst.SLASH
                    + "login.xhtml");
            }

        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void destroy() {
    }
}
