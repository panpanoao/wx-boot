package com.guyu.bdcwxsubscription.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.guyu.bdcwxsubscription.config.annotation.TableReMarks;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 业务指南表
 * </p>
 *
 * @author 黄盼
 * @since 2020-12-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("wx_bs_guide")
@TableReMarks("业务指南表")
public class WxBsGuideEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 业务名称
     */
    private String bsName;

    /**
     * 业务分组
     */
    private String bsGroup;

    /**
     * 业务简介
     */
    private String bsContent;

    /**
     * 业务状态
     */
    private Integer bsType;

    /**
     * 版本号
     */
    private Integer version;


    /**
     * 排序
     */
    private Integer sort;


}
