package com.guyu.bdcwxsubscription.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.guyu.bdcwxsubscription.config.annotation.TableReMarks;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 机构表
 * </p>
 *
 * @author 黄盼
 * @since 2020-12-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("wx_mechanism")
@TableReMarks("机构表")
public class WxMechanismEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 机构名称
     */
    private String mcName;

    /**
     * 机构LOGO
     */
    private String mcLogo;

    /**
     * 机构简介
     */
    private String mcContent;

    private String mcBaunell;

    /**
     * 版本号
     */
    private Integer version;



}
