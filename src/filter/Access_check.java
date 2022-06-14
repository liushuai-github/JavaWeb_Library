package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class Access_check implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

//        判断是否是login.jsp
        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
        String servletPath = httpServletRequest.getServletPath();
//        System.out.println(servletPath);

        if (servletPath.equals("/login.jsp")||servletPath.equals("/login")){
//            System.out.println(httpServletRequest.getSession().getAttribute("uid"));
//            System.out.println(servletPath+"已放行");
            filterChain.doFilter(servletRequest,servletResponse);
        }
        else {
//            判断session中的uid是否为null
            if(httpServletRequest.getSession().getAttribute("uid")==null){
//                System.out.println(httpServletRequest.getServletPath()+"的uid:"+httpServletRequest.getSession().getAttribute("uid"));
                servletRequest.getRequestDispatcher("login.jsp").forward(servletRequest,servletResponse);
//                filterChain.doFilter(servletRequest,servletResponse);
            }
            else {
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }

    }

    @Override
    public void destroy() {

    }
}
