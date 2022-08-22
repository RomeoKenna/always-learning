package com.yfk.yfwork.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName:Student
 * Author:yufukang
 * Version:1.0
 * Time:2022/8/8 10:57
 */
@Data
@Slf4j
public class Student implements Serializable {
    /**
     * 唯一标识
     */
    @TableId(value = "id")
    private Integer id;
    /**
     * 姓名
     */
    @TableField(value = "name")
    private String name;
    /**
     * 年龄
     */
    @TableField(value = "age")
    private Integer age;
    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;
    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;
    /**
     * 电话
     */
    @TableField(value = "phone")
    private String phone;
    /**
     * 地址
     */
    @TableField(value = "address")
    private String address;
    /**
     * 出生日期
     */
    private Date birthDate;
}
