package com.developlee.UnThreadSafe;

import com.developlee.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Leson on 2018/6/23.
 */

@ThreadSafe
public class AtomicReferenceExample {

    private static AtomicReference<Integer> count  = new AtomicReference<>(0);

    public static void main(String args[]){
        count.compareAndSet(0,1);//execute： yes
        count.compareAndSet(1,3);//yes
        count.compareAndSet(2,4);//no
        count.compareAndSet(3,6);//yes
        count.compareAndSet(4,5);//no
        System.out.println(count.get());//预计结果是6
    }
}
