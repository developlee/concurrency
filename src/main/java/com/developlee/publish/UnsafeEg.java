package com.developlee.publish;

import com.developlee.annotations.ThreadUnsafe;
import com.developlee.annotations.UnRecommend;

/**
 * Created by Leson on 2018/6/24.
 */
@ThreadUnsafe
@UnRecommend
public class UnsafeEg {

    private String args[] = {"a", "b", "c"};


    public String[] getArgs() {
        return args;
    }

    public static void main(String[] args) {
        UnsafeEg unsafeEg = new UnsafeEg();

        unsafeEg.getArgs()[0] = "d";

        System.out.println(unsafeEg.getArgs()[0]);
    }
    /**
     * 执行后，结果是d, UnsafeEg的私有数组被无情的修改了，所以说 这种写法，是非线程安全的。
     */
}
