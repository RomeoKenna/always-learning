package com.yfk.yfwork.common.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.yfk.yfwork.common.Serrvice.ApiEnvironmentService;
import com.yfk.yfwork.common.entity.ApiEnvironment;
import com.yfk.yfwork.common.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * ClassName:ApiEnvironmentServiceImpl
 * Author:yufukang
 * Version:1.0
 * Time:2022/8/23 10:11
 */
@Slf4j
@Service
public class ApiEnvironmentServiceImpl implements ApiEnvironmentService {
    static String KAIFA_JSON = "[{\"key\": \"url\",\"value\": \"192.168.5.126:8082\",\"type\": \"default\",\"enabled\": true},{\"key\": \"port\",\"value\": \"/api/\",\"enabled\": true},{\"key\": \"user\",\"value\": \"admin\",\"enabled\": true},{\"key\": \"password\",\"value\": \"111aaa\",\"enabled\": true}]";
    static String SHIZUISHAN_JSON = "[{\"key\": \"url\",\"value\": \"gateway.shennong.sn:9955\",\"type\": \"default\",\"enabled\": true},{\"key\": \"port\",\"value\": \"/api/\",\"enabled\": true},{\"key\": \"user\",\"value\": \"90002\",\"enabled\": true},{\"key\": \"password\",\"value\": \"111aaa\",\"enabled\": true}]";
    static String LUFENG_JSON = "[{\"key\": \"url\",\"value\": \"gateway.shennong.sn:9955\",\"enabled\": true},{\"key\": \"port\",\"value\": \"/api/\",\"enabled\": true},{\"key\": \"user\",\"value\": \"6440\",\"enabled\": true},{\"key\": \"password\",\"value\": \"Sesan@123\",\"enabled\": true}]";
    static String TRANSFORM_JSON = "[{\"key\": \"url\",\"value\": \"localhost:\",\"type\": \"default\",\"enabled\": true},{\"key\": \"port\",\"value\": \"8078/\",\"enabled\": true},{\"key\": \"user\",\"value\": \"admin\",\"enabled\": true},{\"key\": \"password\",\"value\": \"123456\",\"enabled\": true}]";
    static String REIMBURSEMENT_JSON = "[{\"key\": \"url\",\"value\": \"localhost:\",\"enabled\": true},{\"key\": \"port\",\"value\": \"8099/\",\"enabled\": true},{\"key\": \"user\",\"value\": \"admin\",\"enabled\": true},{\"key\": \"password\",\"value\": \"123456\",\"enabled\": true}]";
    static String DRUG_PHARMACY_JSON = "[{\"key\": \"url\",\"value\": \"localhost:\",\"type\": \"default\",\"enabled\": true},{\"key\": \"port\",\"value\": \"8885/\",\"enabled\": true},{\"key\": \"user\",\"value\": \"admin\",\"enabled\": true},{\"key\": \"password\",\"value\": \"123456\",\"enabled\": true}]";
    private static final Map<String, String> JSON_ARRAY_MAP = Maps.newHashMap();

    static {
        JSON_ARRAY_MAP.put("KAIFA_JSON", KAIFA_JSON);
        JSON_ARRAY_MAP.put("SHIZUISHAN_JSON", SHIZUISHAN_JSON);
        JSON_ARRAY_MAP.put("LUFENG_JSON", LUFENG_JSON);
        JSON_ARRAY_MAP.put("TRANSFORM_JSON", TRANSFORM_JSON);
        JSON_ARRAY_MAP.put("REIMBURSEMENT_JSON", REIMBURSEMENT_JSON);
        JSON_ARRAY_MAP.put("DRUG_PHARMACY_JSON", DRUG_PHARMACY_JSON);
    }

    @Override
    public Result<ApiEnvironment> getEnvironment(String environmentString) {

        Result<ApiEnvironment> result;
        try {
            JSONArray jsonArray = JSONArray.parseArray(JSON_ARRAY_MAP.get(environmentString));
            ApiEnvironment apiEnvironment = new ApiEnvironment();
            for (int i = 0, l = jsonArray.size(); i < l; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                PropertyUtils.setProperty(apiEnvironment, (String) jsonObject.get("key"), jsonObject.get("value"));
            }
            result = Result.success(apiEnvironment);
        } catch (Exception e) {
            log.error(String.valueOf(e));
            return Result.fail(e.getMessage(), null);
        }
        return result;
    }
}
