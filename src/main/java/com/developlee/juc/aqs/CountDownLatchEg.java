package com.developlee.juc.aqs;

import com.developlee.annotations.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Leson on 2018/7/4.
 */
@ThreadSafe
public class CountDownLatchEg {
    private final static int threadCount = 200;

    private final static Logger logger = LoggerFactory.getLogger(CountDownLatchEg.class);

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            executorService.execute(() ->{
                try {
                    test(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();//执行完成计数减一
                }
            });
        }
        //countDownLatch.await();
        countDownLatch.await(100, TimeUnit.MILLISECONDS);//推荐写法，避免死等待。
        executorService.shutdown();
    }

    public static void test(int threadNum) throws Exception {
        Thread.sleep(100);
        logger.info("{}",threadNum);
    }

}
