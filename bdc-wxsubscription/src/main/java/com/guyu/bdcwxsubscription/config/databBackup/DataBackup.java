package com.guyu.bdcwxsubscription.config.databBackup;

/**
 * @创建人 黄盼
 * @创建时间 2020/12/7 0007 12:00
 * @描述 定时备份数据库
 **/

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class DataBackup {
    /**
     * 每晚12点进行备份
     * @throws Exception
     */
    @Scheduled(cron = "0 0 12 * * ?")
    public void dump() throws Exception {
        log.info("备份数据库");
        String backName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
        dataBaseDump("root", "root", "guyu", backName);
    }

    /**
     * 数据备份方法
     * @param username 用户名
     * @param password 密码
     * @param databasename 数据库名
     * @param sqlname 文件名
     * @throws Exception 异常
     */
    public static void dataBaseDump(String username, String password, String databasename, String sqlname) throws Exception {
        String filepath = "c:/" + sqlname + ".sql";
        String cmd = "cmd /c mysqldump -u" + username + " -p" + password + " " + databasename + "> " + filepath;
        //拼接cmd命令
        Process exec = Runtime.getRuntime().exec(cmd);
        if (exec.waitFor() == 0) {
            System.out.println("数据库备份成功,备份路径为：" + filepath);
        }

    }


}
