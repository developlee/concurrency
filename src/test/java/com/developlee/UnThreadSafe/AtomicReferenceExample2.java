package com.developlee.UnThreadSafe;

import com.developlee.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Created by Leson on 2018/6/23.
 *
 * AtomicReferenceFieldUpdater
 */
@ThreadSafe
public class AtomicReferenceExample2 {
    private static AtomicIntegerFieldUpdater<AtomicReferenceExample2> updater =  AtomicIntegerFieldUpdater.newUpdater(AtomicReferenceExample2.class,"count");
    private volatile int count = 100;

    public int getCount(){
        return this.count;
    }

    public static void main(String args[]){
        AtomicReferenceExample2 example = new AtomicReferenceExample2();
        updater.compareAndSet(example,100,120);
        if(updater.compareAndSet(example, 100, 150)){
            System.out.println(example.getCount());
        }else{
            System.out.println("update Failed!" + example.getCount());
        }
    }
}
