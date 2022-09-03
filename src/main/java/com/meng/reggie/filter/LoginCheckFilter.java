package com.meng.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.meng.reggie.common.BaseContext;
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

            return;
        }
        //是否登录成功
        if (request.getSession().getAttribute("employee")!=null){
            long id=Thread.currentThread().getId();
            log.info("线程id为:{}",id);
            Long empID =(Long) request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(empID);
            filterChain.doFilter(request,response);
            return;
        }
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));

        return;
    }
    public boolean check (String[] urls,String requestURI){
        for (String url : urls) {
            if(PATH_MATCHER.match(url,requestURI)){
                return true;
            }
        }
        return false;
    }
}
