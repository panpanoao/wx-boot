package com.guyu.bdcwxsubscription.controller;


import com.guyu.bdcwxsubscription.controller.base.BaseController;
import com.guyu.bdcwxsubscription.entity.WxReservationItemEntity;
import com.guyu.bdcwxsubscription.entity.WxReservationManEntity;
import com.guyu.bdcwxsubscription.service.WxReservationItemService;
import com.guyu.bdcwxsubscription.service.WxReservationManService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 微信预约人员表 前端控制器
 * </p>
 *
 * @author 黄盼
 * @since 2020-12-10
 */
@RestController
@RequestMapping("/wxReservationMan")
@Slf4j
public class WxReservationManController extends BaseController<WxReservationManService, WxReservationManEntity> {

}

