package com.yfk.dbsync.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName:DbInfo
 * Author:yufukang
 * Version:1.0
 * Time:2022/8/24 16:12
 */
@Data
public class DbInfo implements Serializable {
    private List<DatabaseSqlInfo> databaseSqlInfos;
}
