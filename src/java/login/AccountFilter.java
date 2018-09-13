package login;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;

import javax.inject.Inject;

import javax.servlet.Filter;

import javax.servlet.FilterChain;

import javax.servlet.FilterConfig;

import javax.servlet.ServletException;

import javax.servlet.ServletRequest;

import javax.servlet.ServletResponse;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

public class AccountFilter implements Filter {

    @Inject

    private AccountManager accountManager;

    @Override

    public void destroy() {}

    @Override

    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)

            throws IOException, ServletException {

        if(! this.accountManager.isLogin()) {

            // ログイン情報が存在しない場合、ログイン画面に強制遷移する。

            String contextPath = ((HttpServletRequest)request).getContextPath();

            ((HttpServletResponse)response).sendRedirect(contextPath + "/view/login/login.xhtml");

        }

        chain.doFilter(request, response);

    }

}