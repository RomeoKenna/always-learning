package com.yfk.dbsync.service.impl;

import com.google.common.collect.Lists;
import com.yfk.dbsync.entity.DatabaseSqlInfo;
import com.yfk.dbsync.entity.DbInfo;
import com.yfk.dbsync.entity.Result;
import com.yfk.dbsync.entity.TableSqlInfo;
import com.yfk.dbsync.mapper.DbInfoMapper;
import com.yfk.dbsync.service.DbInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * ClassName:DbInfoServiceImpl
 * Author:yufukang
 * Version:1.0
 * Time:2022/8/24 17:28
 */
@Slf4j
@Service
public class DbInfoServiceImpl implements DbInfoService {

    @Resource
    private DbInfoMapper dbInfoMapper;

    @Override
    public Result<DbInfo> sync() {
        Result<DbInfo> result = null;
        try {
            List<String> dbNames = dbInfoMapper.getDbNames();
            DbInfo dbInfo = new DbInfo();
            List<DatabaseSqlInfo> databaseSqlInfoList = Lists.newLinkedList();
            for (String dbName : dbNames) {
                if ("shennong_activiti".equals(dbName) || "ass".equals(dbName) || "emr_edit".equals(dbName)) {
                    continue;
                }
                inputName(true, dbName, dbName);
                DatabaseSqlInfo dbInfos = dbInfoMapper.getDatabaseCreateSql(dbName);
                inputSQL(true, dbInfos.getCreateDatabase(), dbName);
                List<String> TableNames = dbInfoMapper.getTables(dbName);
                List<TableSqlInfo> tableSqlInfoList = Lists.newLinkedList();
                for (String tableName : TableNames) {
                    TableSqlInfo tableSqlInfo = dbInfoMapper.getTableCreateSql(dbName + "." + tableName);
                    if (null != tableSqlInfo) {
                        inputName(false, tableName, dbName);
                        inputSQL(false, tableSqlInfo.getCreateTable(), dbName);
                        tableSqlInfoList.add(tableSqlInfo);
                    }
                }
                dbInfos.setTableSqlInfoList(tableSqlInfoList);
                databaseSqlInfoList.add(dbInfos);
            }
            dbInfo.setDatabaseSqlInfos(databaseSqlInfoList);
            result = Result.success(dbInfo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.fail(e.getMessage(), null);
        }
        return result;
    }

    public void inputName(boolean flag,
                          String name,
                          String deName) {
        if (flag) {
            String databaseName = "-- ----------------------------\n" +
                    "-- DATABASE structure for " + name + "\n" +
                    "-- ----------------------------\n" +
                    "DROP DATABASE IF EXISTS `" + name + "`;\n";
            input(databaseName, deName);
        } else {
            String tableName = "-- ----------------------------\n" +
                    "-- Table structure for " + name + "\n" +
                    "-- ----------------------------\n" +
                    "DROP TABLE IF EXISTS `" + name + "`;\n";
            input(tableName, deName);
        }
    }

    public void inputSQL(boolean flag,
                         String sql,
                         String deName) {
        if (flag) {
            sql = sql + ";\nuse `" + deName + "`";
        }
        input(sql + ";\n\n", deName);
    }

    public void input(String s,
                      String deName) {
        try {
            File file = new File("dbsync/sql/shennong.sql");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fop = new FileOutputStream(file, true);
            fop.write(s.getBytes(StandardCharsets.UTF_8));
            fop.flush();
            //释放
            fop.close();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
