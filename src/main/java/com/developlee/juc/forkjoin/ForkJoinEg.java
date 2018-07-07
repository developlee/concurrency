package com.developlee.juc.forkjoin;

import com.sun.org.apache.xpath.internal.functions.FuncTranslate;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Leson on 2018/7/7.
 */
@Slf4j
public class ForkJoinEg extends RecursiveTask<Integer> {


    private static final int threshold = 2;

    private int start;
    private int end;

    public ForkJoinEg(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        // 如果任务足够小就计算任务
        boolean canCompute = (end - start) <= threshold;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // 如果任务大于阈值 就分裂成两个子任务计算
            int middle = (start + end) / 2;
            ForkJoinEg leftTask = new ForkJoinEg(start, middle);
            ForkJoinEg rightTask = new ForkJoinEg(middle + 1, end);
            // 执行子任务
            leftTask.fork();
            rightTask.fork();
            // 等待任务执行结束合并其结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            // 合并子任务
            sum = leftResult + rightResult;
        }
        return sum;
    }


    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // 生成一个计算任务 计算 1+2+3+4
        ForkJoinEg task = new ForkJoinEg(1, 100);

        // 执行一个任务
        Future<Integer> result = forkJoinPool.submit(task);
        try {
            log.info("result: {}", result.get());
        } catch (Exception e) {
            log.info("Exception: ", e);
        }
    }
}
