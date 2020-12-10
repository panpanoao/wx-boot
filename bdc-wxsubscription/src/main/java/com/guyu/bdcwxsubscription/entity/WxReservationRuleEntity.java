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
@TableName("wx_reservation_rule")
@TableReMarks("微信预约人员表")
public class WxReservationRuleEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 规则1春季，2夏季，3秋季，4冬季
     */
    private Integer dictval;

    /**
     * 开始时间点
     */
    private String startime;

    /**
     * 结束时间点
     */
    private String endtime;

    /**
     * 可预约数配置
     */
    private Integer srNum;

    /**
     * 版本号
     */
    private Integer version;


}
