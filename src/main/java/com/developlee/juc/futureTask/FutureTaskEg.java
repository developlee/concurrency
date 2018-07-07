package com.developlee.juc.futureTask;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by Leson on 2018/7/7.
 */
@Slf4j
public class FutureTaskEg {

    public static void main(String[] args) throws Exception {
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {

            @Override
            public String call() throws Exception {
                log.info("do something in callable");
                Thread.sleep(5000);
                return "Done!";
            }
        });
        new Thread(futureTask).start();
        log.info("do something in main!");
        Thread.sleep(1000);
        String result = futureTask.get();
        log.info("result is {}", result);
    }
}
