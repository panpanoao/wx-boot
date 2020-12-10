package com.guyu.bdcwxsubscription.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.guyu.bdcwxsubscription.config.annotation.TableReMarks;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author 黄盼
 * @since 2020-12-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("wxcms_account_fans")
@TableReMarks("微信用户信息")
public class WxcmsAccountFansEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 微信唯一标识
     */
    private String openId;

    /**
     * 订阅状态
     */
    private Integer subscribeStatus;

    /**
     * 订阅时间
     */
    private String subscribeTime;

    /**
     * 昵称
     */
    private byte[] nickName;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 语言
     */
    private String language;

    /**
     * 国家
     */
    private String country;

    /**
     * 省
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 头像
     */
    private String headImgUrl;

    /**
     * 用户状态
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 微信号
     */
    private String wxId;

    /**
     * 账号
     */
    private String account;



}
