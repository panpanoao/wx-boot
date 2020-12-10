package com.guyu.bdcwxsubscription.controller;


import com.guyu.bdcwxsubscription.controller.base.BaseController;
import com.guyu.bdcwxsubscription.entity.WxcmsAccountFansEntity;
import com.guyu.bdcwxsubscription.service.WxcmsAccountFansService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 黄盼
 * @since 2020-12-10
 */
@RestController
@RequestMapping("/wxcmsAccountFans")
@Slf4j
public class WxcmsAccountFansController extends BaseController<WxcmsAccountFansService, WxcmsAccountFansEntity> {

}

