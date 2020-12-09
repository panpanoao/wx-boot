package com.guyu.bdcwxsubscription.config.Xss;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @创建人 黄盼
 * @创建时间 2020/12/8 0008 14:16
 * @描述 xss以及sql注入过滤
 **/
@WebFilter("/*")
@Component
@Slf4j
public class XssFilter implements Filter {
    static List<String> WhiteList = new ArrayList<>();//不需要过滤的方法
    static List<String> staticFileList = new ArrayList<>();//不需要过滤的文件

    /**
     * 不需要过滤的方法
     */
    static {
        WhiteList.add("/file/upload");
        staticFileList.add(".jpg");
        staticFileList.add(".png");
        staticFileList.add(".jpeg");
        staticFileList.add(".txt");
        staticFileList.add(".js");
        staticFileList.add(".css");
        staticFileList.add(".docx");
        staticFileList.add(".pdf");
        staticFileList.add(".xls");
        staticFileList.add(".xlsx");
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //编码过滤
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        XssHttpServletRequestWrapper xssHttpServletRequestWrapper = new XssHttpServletRequestWrapper((HttpServletRequest) request);
        boolean IsthereUrl = false;
        //静态文件放行
        String url = xssHttpServletRequestWrapper.getServletPath();
        String suffixName = "";
        if (url.contains(".")) {
            suffixName = url.substring(url.lastIndexOf("."));
        }
        if (StringUtils.isBlank(suffixName)) {
            for (String suf : staticFileList) {
                if (suf.contains(suffixName)) {
                    IsthereUrl = true;
                    break;
                }
            }
        }
        if (!IsthereUrl) {
            for (String urls : WhiteList) {
                if (urls.equals(url)) {
                    IsthereUrl = true;
                    break;
                }
            }
        }
        if (IsthereUrl) {
            chain.doFilter(xssHttpServletRequestWrapper, response);
        } else {
            //跨域设置
            if (response instanceof HttpServletResponse) {
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                //通过在响应header中设置‘*’来允许来自所有域的跨域请求
                httpResponse.setHeader("Access-Control-Allow-Origin", "*");
                //设置请求方式
                httpResponse.setHeader("Access-Control-Allow-Methods", "*");
                httpResponse.setHeader("Access-Control-Max-Age", "86400");
                httpResponse.setHeader("Access-Control-Allow-Headers", "*");
            }
            //sql、xss过滤
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            log.info("CrosXssFilter----->orignal url:{},ParameterMap:{}", httpRequest.getRequestURI(), JSONObject.toJSONString(httpRequest.getParameterMap()));

            String param = getBodyString(xssHttpServletRequestWrapper.getReader());
            if (xssHttpServletRequestWrapper.checkSqlKeyWords(param)) {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.write("参数中不允许存在sql关键字");
                return;
            }
            chain.doFilter(xssHttpServletRequestWrapper, response);
            log.info("CrosXssFilter..........doFilter url:{},ParameterMap:{}", xssHttpServletRequestWrapper.getRequestURI(), JSONObject.toJSONString(xssHttpServletRequestWrapper.getParameterMap()));
        }
    }


    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    public static String getBodyString(BufferedReader br) {
        String inputLine;
        String str = "";
        try {
            while ((inputLine = br.readLine()) != null) {
                str += inputLine;
            }
            br.close();
        } catch (IOException e) {
            log.error("过滤参数异常：{}", e.getMessage());
        }
        return str;
    }
}
