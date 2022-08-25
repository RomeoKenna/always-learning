package com.yfk.dbsync.service;

import com.yfk.dbsync.entity.DbInfo;
import com.yfk.dbsync.entity.Result;

/**
 * InterfaceName:DbInfoService
 * Author:yufukang
 * Version:1.0
 * Time:2022/8/24 17:27
 */
public interface DbInfoService {
    public Result<DbInfo> sync();
}
