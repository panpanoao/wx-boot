package com.guyu.bdcwxsubscription.controller;


import com.guyu.bdcwxsubscription.controller.base.BaseController;
import com.guyu.bdcwxsubscription.entity.WxReservationManEntity;
import com.guyu.bdcwxsubscription.entity.WxReservationRuleEntity;
import com.guyu.bdcwxsubscription.service.WxReservationManService;
import com.guyu.bdcwxsubscription.service.WxReservationRuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 黄盼
 * @since 2020-12-10
 */
@RestController
@RequestMapping("/wxReservationRule")
@Slf4j
public class WxReservationRuleController  extends BaseController<WxReservationRuleService, WxReservationRuleEntity> {

}

