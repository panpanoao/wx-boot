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
@TableName("wx_reservation_item")
@TableReMarks("微信项目表")
public class WxReservationItemEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 项目名称
     */
    private String srItem;

    /**
     * 上级编号
     */
    private Integer pid;

    /**
     * 预约时间点，1 一小时，24 一天 168 一周
     */
    private Integer srTime;

    /**
     * 可预约次数
     */
    private Integer srNum;

    /**
     * 版本号
     */
    private Integer version;



}
