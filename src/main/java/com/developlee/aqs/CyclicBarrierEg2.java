package com.developlee.aqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * Created by Leson on 2018/7/4.
 */
public class CyclicBarrierEg2 {
    private final static Logger logger = LoggerFactory.getLogger(CyclicBarrierEg2.class);

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
        logger.info("callback is running");
    });

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            executorService.execute(() -> {
                try {
                    rance(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }

    private static void rance (int threadNum) throws Exception {

        Thread.sleep(1000);
        logger.info("{} is ready", threadNum);
        //cyclicBarrier.await();
        try {
            cyclicBarrier.await(2000, TimeUnit.MILLISECONDS);
        }catch (BrokenBarrierException e){
            logger.warn("BrokenBarrierException ",e);
        }catch (TimeoutException e){
            logger.warn("TimeoutException", e);
        }
        logger.info("{} continue" , threadNum);
    }

}
