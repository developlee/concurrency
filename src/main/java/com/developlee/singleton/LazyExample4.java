package com.developlee.singleton;


/**
 * Created by Leson on 2018/6/26.
 * 懒汉模式
 */

import com.developlee.annotations.ThreadSafe;

@ThreadSafe
public class LazyExample4 {

    //私有构造函数
    private LazyExample4(){

    }

//使用volatile 限制指令重排， volatile + 双重检测 -> 禁止指令重排序。
    private volatile static LazyExample4 instance = null;

    //静态的工厂方法
    public static LazyExample4 getInstance(){
        if(instance == null){ //双重检测机制     线程B执行到这一步
            synchronized(LazyExample4.class){ //同步锁
                if(instance == null){
                    instance = new LazyExample4();  //线程A执行到这一步。 此时线程B认为instance已经存在了，如果拿到未初始化的instance调用 ，可能出现问题。
                }
            }
        }
        return instance;
    }
}
