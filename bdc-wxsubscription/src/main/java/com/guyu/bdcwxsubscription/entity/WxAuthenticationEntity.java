package com.guyu.bdcwxsubscription.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.guyu.bdcwxsubscription.config.annotation.TableReMarks;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

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
@TableName("wx_authentication")
@TableReMarks("微信用户")
public class WxAuthenticationEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String openId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证号
     */
    private String cardId;

    /**
     * 身份证正面照
     */
    private String cardFront;

    /**
     * 身份证反面照
     */
    private String cardReverse;

    /**
     * 审核状态0未认证/1已认证
     */
    private Integer statusType;

    /**
     * 相似度
     */
    private BigDecimal score;

    /**
     * 版本号
     */
    private Integer version;

}
