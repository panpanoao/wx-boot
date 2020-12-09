package com.guyu.wxboxs;

import com.guyu.bdcwxsubscription.utils.RedisCache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;

@SpringBootTest
class WxboxsApplicationTests {
    @Autowired
    RedisCache redisCache;

    @Test
    void contextLoads(HttpServletRequest request) throws FileNotFoundException {
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
