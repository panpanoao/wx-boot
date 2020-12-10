package com.guyu.bdcwxsubscription.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.guyu.bdcwxsubscription.entity.WxPersonnelEntity;
import com.guyu.bdcwxsubscription.constant.CommonParameters;
import com.guyu.bdcwxsubscription.utils.RedisCache;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @创建人 黄盼
 * @创建时间 2020/12/4 0004 15:32
 * @描述 配置自动装参
 **/
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Autowired
    private RedisCache redisCache;


    @Override
    public void insertFill(MetaObject metaObject) {
        WxPersonnelEntity wxPersonnel = redisCache.getCacheObject(CommonParameters.LOGIN);
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("delFlag", 0, metaObject);
        this.setFieldValByName("areaCode", wxPersonnel.getAreaCode(), metaObject);
        this.setFieldValByName("createMan", wxPersonnel.getUserName(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        WxPersonnelEntity wxPersonnel = redisCache.getCacheObject(CommonParameters.LOGIN);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("updateMan", wxPersonnel.getUserName(), metaObject);
    }
}
