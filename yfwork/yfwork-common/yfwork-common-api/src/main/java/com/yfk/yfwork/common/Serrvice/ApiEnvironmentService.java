package com.yfk.yfwork.common.Serrvice;

import com.yfk.yfwork.common.entity.ApiEnvironment;
import com.yfk.yfwork.common.entity.Result;

/**
 * InterfaceName:ApiEnvironmentService
 * Author:yufukang
 * Version:1.0
 * Time:2022/8/23 10:10
 */
public interface ApiEnvironmentService {
    Result<ApiEnvironment> getEnvironment(String environmentString);
}
