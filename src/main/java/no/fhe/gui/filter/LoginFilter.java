package no.fhe.gui.filter;

import no.fhe.gui.dao.CustomerDao;
import no.fhe.gui.vo.Customer;
import org.apache.commons.codec.digest.DigestUtils;
import org.skife.jdbi.v2.DBI;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class LoginFilter implements Filter {

    private DBI jdbi;
    private CustomerDao customerDao;
    private static final String FHE_LOGIN_KEY = "fhe_login_key";
    private static final String FHE_LOGIN_EMAIL = "fhe_login_email";
    private static final String COOKIE_PATH = "fhe";

    public LoginFilter(DBI jdbi) {
        this.jdbi = jdbi;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.customerDao = jdbi.onDemand(CustomerDao.class);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        String url = (((HttpServletRequest)req).getRequestURL()).toString();

        if(!url.contains("assets")) {
            if (!isLoggedIn((HttpServletRequest) req)) {
                if (!login(req)) {
                    customerDao.updateFailedLogin();
                    req.getRequestDispatcher("login").forward(req, res);
                } else {
                    String key = UUID.randomUUID().toString();
                    addLoginCookies(key, req.getParameter("email"), (HttpServletResponse) res);
                    customerDao.updateLoginKey(key);
                }
            }
        }
        chain.doFilter(req, res);
    }

    private void addLoginCookies(String key, String email, HttpServletResponse response){
        addCookie(FHE_LOGIN_KEY, key, response);
        addCookie(FHE_LOGIN_EMAIL, email, response);
    }

    private void addCookie(String key, String value, HttpServletResponse response) {
        Cookie cookie = new Cookie(key, value);
//        cookie.setSecure(true);
        cookie.setMaxAge(10 * 60 * 60 * 24);
        cookie.setPath(COOKIE_PATH);
        response.addCookie(cookie);
    }

    private boolean isLoggedIn(HttpServletRequest req){
        Cookie[] cookies = req.getCookies();
        if(cookies == null){
            return false;
        }

        String email = null;
        String key = null;
        for(Cookie cookie : cookies){
            switch(cookie.getName()){
                case FHE_LOGIN_EMAIL: email = cookie.getValue(); break;
                case FHE_LOGIN_KEY: key = cookie.getValue(); break;
            }
        }
        if(email != null && key != null){
            Customer customer = customerDao.isLoggedIn(key, email);
            if(customer != null) return true;
        }
        return false;
    }

    private boolean login(ServletRequest req){
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if(email == null || "".equals(email) || password == null || "".equals(password)){
            return false;
        }
        String md5Password = DigestUtils.md5Hex(password);
        Customer customer = customerDao.customerLogin(email, md5Password);
        if(customer == null){
            return false;
        }
        return true;
    }

    @Override
    public void destroy() {
        jdbi = null;
        customerDao = null;
    }
}
