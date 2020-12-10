package com.guyu.bdcwxsubscription.generate;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/**
 * @author 黄盼
 * @date 2020/6/22 21:06
 * @Desc 代码生成
 **/
public class CodeGenerator {
    public static void main(String[] args) {

        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 2、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("黄盼");
        gc.setOpen(true); //生成后是否打开资源管理器
        gc.setFileOverride(true); //重新生成时文件是否覆盖
        gc.setServiceName("%sService"); //去掉Service接口的首字母I
        gc.setEntityName("%sEntity");//生成实体名称
        gc.setIdType(IdType.AUTO); //主键策略
        gc.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型
        gc.setSwagger2(false);//开启Swagger2模式
        mpg.setGlobalConfig(gc);
        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/guyu?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);
        // 4、包配置
        PackageConfig pc = new PackageConfig();
        String path = System.getProperty("user.dir");
        pc.setParent("com.guyu.bdcwxsubscription");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);
        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名

        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射
        strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true)
        strategy.setLogicDeleteFieldName("del_flag");//逻辑删除字段名
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);//去掉布尔值的is_前缀
        strategy.setInclude(new String[]{"wxcms_account_fans","wx_config","wx_feedback","wx_authentication","wx_bs_guide","wx_reservation_item","wx_reservation_rule","wx_reservation_man","wx_mechanism",});//生成指定表名
        //自动填充
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill createMan = new TableFill("create_man", FieldFill.INSERT);
        TableFill delFlag = new TableFill("del_flag", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time", FieldFill.UPDATE);
        TableFill updateMan = new TableFill("update_man", FieldFill.UPDATE);
        TableFill areaCode = new TableFill("area_code", FieldFill.INSERT);

        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createTime);
        tableFills.add(createMan);
        tableFills.add(delFlag);
        tableFills.add(updateTime);
        tableFills.add(updateMan);
        tableFills.add(areaCode);
        strategy.setTableFillList(tableFills);
        strategy.setRestControllerStyle(true); //restful api风格控制器
        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符
        mpg.setStrategy(strategy);

        //设置BaseEntity(基类实体)
        strategy.setSuperEntityClass("com.guyu.bdcwxsubscription.BaseEntity");
        // 填写BaseEntity中的公共字段
        strategy.setSuperEntityColumns("id", "create_time", "create_man", "del_flag", "update_time", "update_man","area_code");
        // 6、执行
        mpg.execute();

    }


}