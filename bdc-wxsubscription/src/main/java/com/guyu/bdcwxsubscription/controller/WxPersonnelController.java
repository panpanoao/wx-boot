package com.guyu.bdcwxsubscription.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.guyu.bdcwxsubscription.entity.WxPersonnelEntity;
import com.guyu.bdcwxsubscription.config.annotation.LoginUser;
import com.guyu.bdcwxsubscription.config.annotation.OperateLog;
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
public class WxPersonnelController {

    @Autowired
    private WxPersonnelService wxPersonnelService;

    @GetMapping("/findAll")
    @OperateLog(moduleName = "人员")
    public R test() {
        return R.ok(wxPersonnelService.findAll());
    }

    @PostMapping("/add")
    public R addpersion(@RequestBody WxPersonnelEntity personnel) {
        return R.ok(wxPersonnelService.save(personnel));
    }

    @GetMapping("/del")
    public R del(@NotNull(message = "id不能为空") Long id) {
        return R.ok(wxPersonnelService.removeById(id));
    }

    @PostMapping("/update")
    public R updatepersion(@RequestBody @Valid WxPersonnelEntity personnel) {
        return R.ok(wxPersonnelService.updateById(personnel));
    }

    /**
     * 用户登录
     * @param personnel 参数
     * @return 用户对象
     */
    @PostMapping("/submit")
    public R loginsubmit(@RequestBody WxPersonnelEntity personnel) {
        WxPersonnelEntity user = wxPersonnelService.login(personnel.getUserName(), personnel.getPassword());
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

