package com.guyu.bdcwxsubscription.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.guyu.bdcwxsubscription.config.annotation.TableReMarks;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 微信预约人员表
 * </p>
 *
 * @author 黄盼
 * @since 2020-12-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("wx_reservation_man")
@TableReMarks("微信预约时间")
public class WxReservationManEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 预约项目id
     */
    private Long srId;

    /**
     * 项目名称
     */
    private String srItem;

    /**
     * 预约号
     */
    private Long srCode;

    /**
     * 预约人
     */
    private String srMan;

    /**
     * 身份证号码
     */
    private Long cardId;

    /**
     * 电话
     */
    private Long phone;

    /**
     * 预约状态0未预约1已预约2已过号
     */
    private Integer srType;

    /**
     * 预约时间
     */
    private Date srDate;

    /**
     * 预约结束时间
     */
    private Date srEndDate;

    /**
     * 预约时间段=对应规则表id
     */
    private Long ruleId;

    /**
     * 版本号
     */
    private Integer version;



}
