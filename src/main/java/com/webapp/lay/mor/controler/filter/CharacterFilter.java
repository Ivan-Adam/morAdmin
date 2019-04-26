package com.webapp.lay.mor.controler.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebFilter(urlPatterns = {"/*"})
public class CharacterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        CharacterRequset characterRequest = new CharacterRequset(request);
        filterChain.doFilter(characterRequest,response);
    }

    @Override
    public void destroy() {

    }
}
class CharacterRequset extends HttpServletRequestWrapper{
    private HttpServletRequest request;
    public CharacterRequset(HttpServletRequest request){
        super(request);
        this.request=request;
    }
    public String getParameter (String name){
        String value = super.getParameter(name);
        if(value==null)
            return null;
        String method = super.getMethod();
        if("get".equalsIgnoreCase(method)){
            try{
                value = new String(value.getBytes("iso-8859-1"),"utf-8");
            }catch (UnsupportedEncodingException e){
                throw new RuntimeException(e);
            }
        }
        return value;
    }
}
