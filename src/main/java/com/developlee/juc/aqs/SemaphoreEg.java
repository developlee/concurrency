package com.developlee.juc.aqs;

import com.developlee.annotations.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Leson on 2018/7/4. 信号量控制
 */
@ThreadSafe
public class SemaphoreEg {
    private final static int threadCount = 200;

    private final static Logger logger = LoggerFactory.getLogger(CountDownLatchEg.class);

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Semaphore semaphore = new Semaphore(20);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            executorService.execute(() ->{
                try {
                    semaphore.acquire(3); //获取一（多）个许可
                    test(threadNum);
                    semaphore.release(3);//释放一（多）个许可
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {

                }
            });
        }
        executorService.shutdown();
    }

    public static void test(int threadNum) throws Exception {

        logger.info("{}",threadNum);
        Thread.sleep(100);
    }
}
