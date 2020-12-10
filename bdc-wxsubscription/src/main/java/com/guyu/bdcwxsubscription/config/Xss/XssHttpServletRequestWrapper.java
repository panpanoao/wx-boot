package com.guyu.bdcwxsubscription.config.Xss;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

/**
 * @创建人 黄盼
 * @创建时间 2020/12/8 0008 14:13
 * @描述 xss以及sql注入过滤配置
 **/
@Slf4j
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {


    private static String key = "and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+";
    private static Set<String> notAllowedKeyWords = new HashSet<>(0);
    private static String replacedString = "INVALID";
    private final byte[] body; //用于保存读取body中数据
    private String currentUrl;

    static {
        String keyStr[] = key.split("\\|");
        for (String str : keyStr) {
            notAllowedKeyWords.add(str);
        }
    }

    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        currentUrl = request.getRequestURI();
        try {
            body = StreamUtils.copyToByteArray(request.getInputStream());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    /**
     * @Description 覆盖getParameter方法，将参数和参数值做xss过滤
     * @Date 2020/5/20 9:57
     */
    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return cleanXss(value);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> values = super.getParameterMap();
        if (null == values) {
            return null;
        }
        Map<String, String[]> result = new HashMap<>();
        for (String key : values.keySet()) {
            String encodedKey = cleanXss(key);
            int count = values.get(key).length;
            String[] encodedValues = new String[count];
            for (int i = 0; i < count; i++) {
                encodedValues[i] = cleanXss(values.get(key)[i]);
            }
            result.put(encodedKey, encodedValues);
        }
        return result;
    }

    @Override
    public String getHeader(String name) {
        String value = super.getHeader(name);
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return cleanXss(value);
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if (StringUtils.isEmpty(values)) {
            return null;
        }
        int count = values.length;
        String[] encodedValues = new String[count];
        for (int i = 0; i < count; i++) {
            encodedValues[i] = cleanXss(values[i]);
        }
        return encodedValues;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream bais = new ByteArrayInputStream(body);
        return new ServletInputStream() {

            @Override
            public int read() throws IOException {
                return bais.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener arg0) {

            }
        };
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    /**
     * @Description 解析参数
     * @Date 2020/5/20 10:01
     */
    private String cleanXss(String valueP) {
        String value = valueP.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
        value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
        value = value.replaceAll("'", "& #39;");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        value = value.replaceAll("script", "");
        value = cleanSqlKeyWords(value);
        return value;
    }

    /**
     * @Description 解析参数SQL关键字
     * @Date 2020/5/20 10:01
     */
    private String cleanSqlKeyWords(String value) {
        String paramValue = value;
        for (String keyWord : notAllowedKeyWords) {
            if (paramValue.length() > keyWord.length() + 4
                    && (paramValue.contains(" " + keyWord)
                    || paramValue.contains(keyWord + " ")
                    || paramValue.contains(" " + keyWord + " "))) {
                paramValue = StringUtils.replace(paramValue, keyWord, replacedString);
                log.error(this.currentUrl + "已被过滤，因为参数中包含不允许sql的关键词(" + keyWord + ");参数：" + value + "；过滤后的参数：" + paramValue);
            }
        }
        return paramValue;
    }

    public boolean checkSqlKeyWords(String value) {
        String paramValue = value;
        for (String keyword : notAllowedKeyWords) {
            if (paramValue.length() > keyword.length() + 4
                    && (paramValue.contains(" " + keyword) || paramValue.contains(keyword + " ") || paramValue.contains(" " + keyword + " "))) {
                log.error(this.getRequestURI() + "参数中包含不允许sql的关键词(" + keyword
                        + ")");
                return true;
            }
        }
        return false;
    }
}
