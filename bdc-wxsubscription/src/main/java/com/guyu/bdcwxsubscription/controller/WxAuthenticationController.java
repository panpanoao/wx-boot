package com.guyu.bdcwxsubscription.controller;


import com.guyu.bdcwxsubscription.controller.base.BaseController;
import com.guyu.bdcwxsubscription.entity.WxAuthenticationEntity;
import com.guyu.bdcwxsubscription.service.WxAuthenticationService;
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
@RequestMapping("/wxAuthentication")
@Slf4j
public class WxAuthenticationController extends BaseController<WxAuthenticationService, WxAuthenticationEntity> {

}

