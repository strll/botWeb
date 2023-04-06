package com.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * app端的用户表
 * </p>
 *
 * @author wxt
 * @since 2023-04-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AppUser implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    @TableField("Mail")
    private String Mail;

    private String createDate;


}
