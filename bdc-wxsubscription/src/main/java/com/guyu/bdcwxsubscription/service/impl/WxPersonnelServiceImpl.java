package com.guyu.bdcwxsubscription.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guyu.bdcwxsubscription.entity.WxPersonnelEntity;
import com.guyu.bdcwxsubscription.constant.CommonParameters;
import com.guyu.bdcwxsubscription.mapper.WxPersonnelMapper;
import com.guyu.bdcwxsubscription.query.BaseQuery;
import com.guyu.bdcwxsubscription.service.WxPersonnelService;
import com.guyu.bdcwxsubscription.utils.MyMD5Util;
import com.guyu.bdcwxsubscription.utils.RedisCache;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 人员表 服务实现类
 * </p>
 *
 * @author 黄盼
 * @since 2020-12-04
 */
@Service
public class WxPersonnelServiceImpl extends ServiceImpl<WxPersonnelMapper, WxPersonnelEntity> implements WxPersonnelService {


    @Autowired
    private RedisCache redisCache;


    @Override
    public IPage<WxPersonnelEntity> pageList(BaseQuery query,WxPersonnelEntity personnelEntity) {
        Page<WxPersonnelEntity> page=new Page<>(query.getPage(),query.getSize());
        QueryWrapper<WxPersonnelEntity> queryWrapper=new QueryWrapper<>();
        if(!StringUtils.isBlank(personnelEntity.getUserName())){
            queryWrapper.like("user_name",personnelEntity.getUserName());
        }
        queryWrapper.eq("area_code",getUser().getAreaCode());
        queryWrapper.orderByDesc("create_time");
        return baseMapper.selectPage(page,queryWrapper);
    }

    /**
     * 登录
     *
     * @param loginName 用户名
     * @param password  密码
     * @return
     */
    @Override
    public WxPersonnelEntity login(String loginName, String password) {
        QueryWrapper<WxPersonnelEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("login_name", loginName).eq("password", MyMD5Util.JM(password, loginName));
        WxPersonnelEntity personnel = baseMapper.selectOne(queryWrapper);
        if (personnel == null) {
            return null;
        }
        //存入redis
        redisCache.setCacheObject(CommonParameters.LOGIN, personnel);
        redisCache.expire(CommonParameters.LOGIN, 30);//30分钟
        return personnel;
    }


    /**
     * 用户登出
     * @return
     */
    @Override
    public Boolean outLogin() {
        redisCache.deleteObject(CommonParameters.LOGIN);
        return true;
    }

    @Override
    public WxPersonnelEntity getUser() {
        return redisCache.getCacheObject(CommonParameters.LOGIN);
    }
}
