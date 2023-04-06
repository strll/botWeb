package com.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static com.baomidou.mybatisplus.annotation.FieldFill.INSERT_UPDATE;

/**
 * <p>
 * 
 * </p>
 *
 * @author wxt
 * @since 2023-04-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Root implements Serializable {

    private static final long serialVersionUID=1L;

    private String account;

    private String password;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField(fill = FieldFill.INSERT)
    private  String permissions;


}
