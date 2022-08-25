package com.yfk.dbsync.mapper;

import com.yfk.dbsync.entity.DatabaseSqlInfo;
import com.yfk.dbsync.entity.TableSqlInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * InterfaceName:DbInfoMapper
 * Author:yufukang
 * Version:1.0
 * Time:2022/8/24 16:38
 */
@Mapper
public interface DbInfoMapper {
    List<String> getDbNames();

    DatabaseSqlInfo getDatabaseCreateSql(@Param("dbName") String dbName);

    List<String> getTables(@Param("dbName") String dbName);

    TableSqlInfo getTableCreateSql(@Param("tableName") String tableName);


}
