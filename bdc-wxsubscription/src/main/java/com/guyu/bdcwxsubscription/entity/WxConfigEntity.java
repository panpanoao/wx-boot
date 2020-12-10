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
@TableName("wx_config")
@TableReMarks("基本配置")
public class WxConfigEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 配置名称
     */
    private String configName;

    /**
     * 配置数值
     */
    private String configVal;

    /**
     * 配置信息
     */
    private String cofigMsg;

    /**
     * 版本号
     */
    private Integer version;



}
