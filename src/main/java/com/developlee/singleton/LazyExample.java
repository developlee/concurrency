package com.developlee.singleton;

import com.developlee.annotations.ThreadUnsafe;

/**
 * Created by Leson on 2018/6/26.
 * 懒汉模式 ----高并发情况下 静态工厂方法可能创建两个实例
 */
@ThreadUnsafe
public class LazyExample {

    //私有构造函数
    private LazyExample(){

    }

    private static LazyExample instance = null;

    //静态的工厂方法
    public static LazyExample getInstance(){
        if(instance == null){
            instance = new LazyExample();
        }
        return instance;
    }
}
