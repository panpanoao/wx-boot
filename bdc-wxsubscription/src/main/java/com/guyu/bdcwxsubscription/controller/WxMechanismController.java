package com.guyu.bdcwxsubscription.controller;


import com.guyu.bdcwxsubscription.controller.base.BaseController;
import com.guyu.bdcwxsubscription.entity.WxMechanismEntity;
import com.guyu.bdcwxsubscription.service.WxMechanismService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 机构表 前端控制器
 * </p>
 *
 * @author 黄盼
 * @since 2020-12-10
 */
@RestController
@RequestMapping("/wxMechanism")
@Slf4j
public class WxMechanismController extends BaseController<WxMechanismService, WxMechanismEntity> {

}

