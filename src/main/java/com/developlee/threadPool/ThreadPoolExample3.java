package com.developlee.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Leson on 2018/7/9.
 */
@Slf4j
public class ThreadPoolExample3 {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

        for (int i = 0; i <10 ; i++) {
            final int index = i;
            executorService.schedule(new Runnable() {
                @Override
                public void run() {
                    log.info("task {}", index);
                }
            },3, TimeUnit.SECONDS);

        }
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                log.info("task run ");
            }
        },1,3,TimeUnit.SECONDS);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.info("timer run");
            }
        },new Date(),5*1000);
    }
}
