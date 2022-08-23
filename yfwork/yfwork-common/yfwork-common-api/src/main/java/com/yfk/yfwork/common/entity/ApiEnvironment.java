package com.yfk.yfwork.common.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * ClassName:ApiEnvironment
 * Author:yufukang
 * Version:1.0
 * Time:2022/8/23 10:07
 */
@Data
@Slf4j
public class ApiEnvironment implements Serializable {
    private String url;
    private String port;
    private String user;
    private String password;
}
