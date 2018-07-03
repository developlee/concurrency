package com.developlee.concurrent;

import com.developlee.annotations.ThreadSafe;
import com.developlee.annotations.ThreadUnsafe;
import com.developlee.unThreadSafe.ConcurrencyTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by Leson on 2018/7/1.
 */
@ThreadSafe
public class ConcurrentHashMapEg {
    private final static Logger logger = LoggerFactory.getLogger(ConcurrencyTest.class);

    private static Map<Integer, Integer> map = new ConcurrentHashMap<>();

    //请求总数
    public static int clientTotal = 5000;

    //同时并发执行的线程总数
    public static int threadTotal = 200;

    public static void main(String args[]) throws InterruptedException {
        //新建一个线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //定义信号量（定义允许并发的数目）
        final Semaphore semaphore = new Semaphore(threadTotal);
        //
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            //请求放入线程池内
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();//引入信号量
                    update(count);
                    semaphore.release(); //释放
                } catch (InterruptedException e) {
                    logger.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown(); //关闭
        logger.info("size {}", map.size());
    }

    private static void update(int i) {
        map.put(i, i);
    }
}
