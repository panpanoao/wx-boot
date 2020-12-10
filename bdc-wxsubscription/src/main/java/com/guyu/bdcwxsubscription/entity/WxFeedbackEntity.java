package com.guyu.bdcwxsubscription.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.guyu.bdcwxsubscription.config.annotation.TableReMarks;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

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
@TableName("wx_feedback")
@TableReMarks("反馈信息")
public class WxFeedbackEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 反馈人ID
     */
    private String fbManId;

    /**
     * 反馈标题
     */
    private String fbTitle;

    /**
     * 反馈类型
     */
    private String fbType;

    /**
     * 反馈内容
     */
    private String fbContent;

    /**
     * 反馈状态
     */
    private Integer fbState;

    private String fbPhone;

    private String fbEmail;

    /**
     * 处理人
     */
    private String hdMan;

    /**
     * 处理人ID
     */
    private Long hdManId;

    /**
     * 回复内容
     */
    private String hdContent;

    /**
     * 处理时间
     */
    private Date hdTime;


    /**
     * 版本号
     */
    private Integer version;


}
