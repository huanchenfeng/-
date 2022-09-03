package com.meng.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.meng.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    //路径匹配器支持通配符
    public static final AntPathMatcher PATH_MATCHER=new AntPathMatcher();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        String requestURI =request.getRequestURI();
        //不需要处理的请求路径
        String[] urls=new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**"
        };
        //判断本次请求是否需要处理
        boolean check=check(urls,requestURI);

        //判断是否需要处理
        if (check){
            filterChain.doFilter(request,response);
            log.info("直接放行的:{}",request.getRequestURI());
            return;
        }
        //是否登录成功
        if (request.getSession().getAttribute("employee")!=null){
            filterChain.doFilter(request,response);
            log.info("登陆成功的{}",request.getSession().getAttribute("employee"));
            return;
        }
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        log.info("被拦截{}",request.getRequestURI());
        return;
    }
    public boolean check (String[] urls,String requestURI){
        for (String url : urls) {
            if(PATH_MATCHER.match(url,requestURI)){
                log.info("匹配上了");
                return true;
            }
        }
        return false;
    }
}
