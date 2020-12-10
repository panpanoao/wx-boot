package com.guyu.bdcwxsubscription.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @创建人 黄盼
 * @创建时间 2020/12/4 0004 15:18
 * @描述 基类
 **/
@Data
public class BaseEntity implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @NotNull(message = "id不能为空")
    private Long id;
    /**
     * 创建人
     */
    @TableField(value = "create_man",fill= FieldFill.INSERT)
    private String createMan;
    /**
     * <p>创建时间</p>
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "create_time",fill=FieldFill.INSERT)
    private Date createTime;
    /**
     * 修改人
     */
    @TableField(value = "update_man",fill =FieldFill.UPDATE )
    private String updateMan;
    /**
     * <p>修改时间</p>
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "update_time",fill =FieldFill.UPDATE)
    private Date updateTime;
    /**
     * <p>是否删除 0否1是</p>
     */
    @TableField(value = "del_flag",fill= FieldFill.INSERT,select = false)
    @TableLogic
    private Integer delFlag;

    /**
     * 地区识别码
     */
    @TableField(value = "area_code",fill= FieldFill.INSERT)
    private String areaCode;


}
