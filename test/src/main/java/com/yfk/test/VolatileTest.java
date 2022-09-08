package com.yfk.test;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

/**
 * ClassName:VolatileTest
 * Author:yufukang
 * Version:1.0
 * Time:2022/9/8 16:07
 */
//@JCStressTest // 标记此类为一个并发测试类
//@Outcome(id = {"0"}, expect = Expect.ACCEPTABLE_INTERESTING, desc = "wrong result") // 描述测试结果
//@Outcome(id = {"10"}, expect = Expect.ACCEPTABLE, desc = "normal result") // 描述测试结果
//@State //标记此类是有状态的
@Slf4j
public class VolatileTest {
    static boolean run = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (run) {
                System.out.println("1");
            }
        });
        t.start();
        sleep(1);
        run = false;
    }
}
