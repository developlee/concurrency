package com.developlee.singleton;

import com.developlee.annotations.Recommend;
import com.developlee.annotations.ThreadSafe;

/**
 * Created by Leson on 2018/6/26.
 * 枚举创建单例模式,安全，调用时才创建实例，推荐写法。
 */
@ThreadSafe
@Recommend
public class SingletonExample {
    private SingletonExample() {
    }


    public static SingletonExample getInstance(){
        return Singleton.INSTANCE.singletonExample;
    }

    private enum Singleton{
        INSTANCE;
        private SingletonExample singletonExample;

        //JVM保证这个方法绝对只被调用一次。
        Singleton(){
            singletonExample = new SingletonExample();
        }
        public SingletonExample getInstance(){
            return singletonExample;
        }
    }
}
