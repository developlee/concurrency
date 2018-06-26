package com.developlee.singleton;

import com.developlee.annotations.ThreadUnsafe;

/**
 * Created by Leson on 2018/6/26.
 * 懒汉模式 ----高并发情况下 静态工厂方法可能创建两个实例
 */
@ThreadUnsafe
public class LazyExample3 {

    //私有构造函数
    private LazyExample3(){

    }


    /**
     * 为什么说是线程不安全的呢？
     * 看一下CPU指令执行过程
     * 1. memory = allocate() -> 分配对象的内存空间
     * 2. ctorInstance() -> 初始化对象
     * 3. instance = memory  -> 设置instance指向刚刚创建的内存
     **/
    /**
     * 可能发生的情况：
     * JVM和CPU优化，发生指令重排序，导致第二步和第三步互换。
     */


    private static LazyExample3 instance = null;

    //静态的工厂方法
    public static LazyExample3 getInstance(){
        if(instance == null){ //双重检测机制     线程B执行到这一步
            synchronized(LazyExample3.class){ //同步锁
                if(instance == null){
                    instance = new LazyExample3();  //线程A执行到这一步。 此时线程B认为instance已经存在了，如果拿到未初始化的instance调用 ，可能出现问题。
                }
            }
        }
        return instance;
    }
}
