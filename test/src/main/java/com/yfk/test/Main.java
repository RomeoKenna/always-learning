package com.yfk.test;

import com.google.common.base.CharMatcher;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        String s = " /*!40100 DEFAULT CHARACTER 00SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;";
        s = CharMatcher.anyOf("/*!40100").removeFrom(s);

        System.out.println(s);
    }

    public static void inputName(boolean flag,
                                 String name) {
        if (flag) {
            String databaseName = "-- DATABASE:" + name + "\n";
            input(name);
        } else {
            String tableName = "-- \tTABLE:" + name + "\n";
            input(name);
        }
    }

    public static void inputSQL(String sql) {
        input(sql + "\n\n");
    }

    public static void input(String s) {
        try (RandomAccessFile file = new RandomAccessFile("./data.sql", "rw")) {
            FileChannel channel = file.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(100);
            do {
                // 向 buffer 写入
                int len = channel.read(buffer);
                log.info("读到字节数：{}", len);
                if (len == -1) {
                    break;
                }
                // 切换 buffer 读模式
                buffer.flip();
                while (buffer.hasRemaining()) {
                    log.info("{}", (char) buffer.get());
                }
                // 切换 buffer 写模式
                buffer.clear();
            } while (true);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
