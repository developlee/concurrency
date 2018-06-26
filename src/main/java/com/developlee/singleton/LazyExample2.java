package com.developlee.singleton;

import com.developlee.annotations.ThreadSafe;
import com.developlee.annotations.ThreadUnsafe;
import com.developlee.annotations.UnRecommend;

/**
 * Created by Leson on 2018/6/26.
 * 懒汉模式 ----高并发情况下 静态工厂方法可能创建两个实例
 */

@ThreadSafe
@UnRecommend
public class LazyExample2 {

    //私有构造函数
    private LazyExample2(){

    }

    private static LazyExample2 instance = null;

    //静态的工厂方法 加了synchronized 保证了线程安全，但是会带来性能的下降。
    public static synchronized LazyExample2 getInstance(){
        if(instance == null){
            instance = new LazyExample2();
        }
        return instance;
    }
}
