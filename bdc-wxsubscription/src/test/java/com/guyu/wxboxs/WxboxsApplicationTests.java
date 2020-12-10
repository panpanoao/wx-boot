package com.guyu.wxboxs;


import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class WxboxsApplicationTests {


    @Test
    void contextLoads() {
        String tx="";
        if(StringUtils.isBlank(tx)){
            System.out.println("1");
        }

     /*   System.out.println("11");
     redisCache.setCacheObject("aa","123");
        String aa=redisCache.getCacheObject("aa");
        System.out.println("测试成功"+aa);*/
     /*   TimeString ts = new TimeString();
        System.out.println("111"+ts.getTimeString());*/
//        File path = new File(ResourceUtils.getURL("classpath:").getPath());
//        String relativelyPath=System.getProperty("user.dir")+"src/main/resource/upload";
//        System.out.println("aa"+relativelyPath);
//        System.out.println("path:"+path.getAbsolutePath());
//        System.out.println(path);
    }

}
