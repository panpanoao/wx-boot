package com.guyu.bdcwxsubscription.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guyu.bdcwxsubscription.entity.WxPersonnelEntity;
import com.guyu.bdcwxsubscription.query.BaseQuery;

import javax.management.Query;
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

    IPage<WxPersonnelEntity> pageList(BaseQuery query, WxPersonnelEntity wxPersonnelEntity);

    WxPersonnelEntity login(String loginName, String password);

    Boolean outLogin();

    WxPersonnelEntity getUser();

}
