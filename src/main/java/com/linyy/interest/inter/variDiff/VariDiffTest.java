package com.linyy.interest.inter.variDiff;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 同样在多线程中使用变量，为什么接口可以直接定义变量，继承需要使用内部类
 */
public class VariDiffTest {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4, 3,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 1; i <= 10; i++) {
            threadPool.execute(new VariDiffInter());
        }
        for (int i = 1; i <= 10; i++) {
            threadPool.execute(new VariDiffExtend());
        }
        threadPool.shutdown();
        // 结论：感觉没必要，继承Thread的类也可以直接定义内部变量，供线程访问
    }
}
