package com.developlee.threadLocal;

/**
 * Created by Leson on 2018/7/1.
 */
public class RequestHolder {

    private final static ThreadLocal<Long> resultHolder = new ThreadLocal<>();

    public static void add(Long id){
        resultHolder.set(id);
    }

    public static Long getId(){
        return resultHolder.get();
    }

    public static void remove(){
        resultHolder.remove();
    }
}
