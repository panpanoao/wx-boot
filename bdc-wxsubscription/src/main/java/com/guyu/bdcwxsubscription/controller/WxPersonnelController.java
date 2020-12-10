package com.guyu.bdcwxsubscription.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.guyu.bdcwxsubscription.controller.base.BaseController;
import com.guyu.bdcwxsubscription.entity.WxPersonnelEntity;
import com.guyu.bdcwxsubscription.config.annotation.LoginUser;
import com.guyu.bdcwxsubscription.config.annotation.OperateLog;
import com.guyu.bdcwxsubscription.query.BaseQuery;
import com.guyu.bdcwxsubscription.service.WxPersonnelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 人员表 前端控制器
 * </p>
 *
 * @author 黄盼
 * @since 2020-12-04
 */
@RestController
@RequestMapping("/personnel")
@Validated
@Slf4j
public class WxPersonnelController extends BaseController<WxPersonnelService,WxPersonnelEntity> {


    @GetMapping("/pageList")
    @OperateLog(moduleName = "用户表查询")
    public R pageList(BaseQuery query, WxPersonnelEntity wxPersonnelEntity) {
        return R.ok(baseService.pageList(query, wxPersonnelEntity));
    }

    /**
     * 用户登录
     *
     * @param personnel 参数
     * @return 用户对象
     */
    @PostMapping("/submit")
    @OperateLog(moduleName = "进入系统")
    public R loginsubmit(@RequestBody WxPersonnelEntity personnel) {
        WxPersonnelEntity user = baseService.login(personnel.getUserName(), personnel.getPassword());
        if (user == null) {
            return R.failed("用户名或密码错误！");
        }
        return R.ok(user);
    }

    /**
     * 获取登录用户
     *
     * @return 用户对象
     */
    @GetMapping("getUser")
    public R getLoginUser(@LoginUser WxPersonnelEntity wxPersonnel) {
        return R.ok(wxPersonnel);
    }


}

