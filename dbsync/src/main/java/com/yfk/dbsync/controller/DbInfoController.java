package com.yfk.dbsync.controller;

import com.yfk.dbsync.entity.DbInfo;
import com.yfk.dbsync.entity.Result;
import com.yfk.dbsync.service.DbInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName:DbInfoController
 * Author:yufukang
 * Version:1.0
 * Time:2022/8/25 8:56
 */
@RestController
@RequestMapping("/dbInfo")
public class DbInfoController {
    @Resource
    private DbInfoService dbInfoService;

    @GetMapping("/sync")
    public Result<DbInfo> sync() {
        return dbInfoService.sync();
    }
}
