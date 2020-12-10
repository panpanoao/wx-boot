package com.guyu.bdcwxsubscription.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.guyu.bdcwxsubscription.config.annotation.TableReMarks;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 人员表
 * </p>
 *
 * @author 黄盼
 * @since 2020-12-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("wx_personnel")
@TableReMarks("微信用户表")
public class WxPersonnelEntity extends BaseEntity {

    private static final long serialVersionUID=1L;

      /**
     * 用户名
     */
      private String userName;

      /**
     * 登录名
     */
      private String loginName;

      /**
     * 登录密码
     */
      private String password;

      /**
     * 联系方式
     */
      private Long phone;

      /**
     * 权限
     */
      private Integer type;

      /**
     * 版本号
     */
      private Integer version;



}
