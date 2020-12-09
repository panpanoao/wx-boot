package com.guyu.bdcwxsubscription.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guyu.bdcwxsubscription.entity.WxPersonnelEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 人员表 服务类
 * </p>
 *
 * @author 黄盼
 * @since 2020-12-04
 */
public interface WxPersonnelService extends IService<WxPersonnelEntity> {

    IPage<WxPersonnelEntity> findAll();


    int add(WxPersonnelEntity wxPersonnelEntity);

    WxPersonnelEntity login(String loginName, String password);


    Boolean outLogin(HttpServletRequest request, HttpServletResponse response);

    WxPersonnelEntity getUser();

}
