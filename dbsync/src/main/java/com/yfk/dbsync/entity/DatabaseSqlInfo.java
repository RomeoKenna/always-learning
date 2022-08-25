package com.yfk.dbsync.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName:DatabaseInfo
 * Author:yufukang
 * Version:1.0
 * Time:2022/8/24 17:15
 */
@Data
public class DatabaseSqlInfo implements Serializable {
    private String database;
    private String createDatabase;
    private List<TableSqlInfo> tableSqlInfoList;
}
