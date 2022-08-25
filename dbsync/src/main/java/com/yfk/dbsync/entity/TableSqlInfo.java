package com.yfk.dbsync.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName:TableSqlInfo
 * Author:yufukang
 * Version:1.0
 * Time:2022/8/24 17:17
 */
@Data
public class TableSqlInfo implements Serializable {

    private String table;

    private String createTable;
}
