package com.developlee.aqs.locks;

import com.developlee.unThreadSafe.ConcurrencyTest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Leson on 2018/7/5. 实现悲观锁。写的时候禁止任何读锁
 */
@Slf4j
public class LockEg2 {

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();


    private final Map<String, Data> map = new TreeMap<>();

    private final Lock readLock = lock.readLock();

    private final Lock writeLock = lock.writeLock();


    public Data get(String key){
        readLock.lock();
        try {
            return map.get(key);
        }finally {
            readLock.unlock();
        }
    }

    public Set<String> getAllKeys(){
        readLock.lock();
        try {
            return map.keySet();
        }finally {
            readLock.unlock();
        }
    }

    public Data put(String key, Data data){
        writeLock.lock();
        try {
            return map.put(key, data);
        }finally {
            writeLock.unlock();
        }
    }
}
