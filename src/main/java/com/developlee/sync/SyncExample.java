package com.developlee.sync;

import com.developlee.annotations.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Leson on 2018/6/24.
 */
@ThreadSafe
public class SyncExample {

    private static final Logger logger = LoggerFactory.getLogger(SyncExample.class);

    public static synchronized void test1() {
        for (int i = 0; i < 10; i++) {
            logger.info("test1 i = {}", i);
        }
    }

    public static synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            logger.info("test2 i = {}", i);
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            test1();
        });
        executorService.execute(() -> {
            test2();
        });

    }

}
