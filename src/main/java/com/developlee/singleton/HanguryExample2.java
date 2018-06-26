package com.developlee.singleton;

import com.developlee.annotations.ThreadSafe;

/**
 * 饿汉模式： 考虑两个因素：1. 饿汉模式创建单例，私有函数不能做过多操作，否则带来性能问题，
 * 2.不能带来资源的浪费。
 * Created by Leson on 2018/6/26.
 * 类加载时创建。
 */
@ThreadSafe
public class HanguryExample2 {
    //私有构造函数
    private HanguryExample2(){

    }

    private static HanguryExample2 instance = null;

    static {
        instance = new HanguryExample2();
    }

    //静态的工厂方法
    public static HanguryExample2 getInstance(){
        return instance;
    }
}
