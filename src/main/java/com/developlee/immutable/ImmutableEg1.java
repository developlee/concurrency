package com.developlee.immutable;


import com.developlee.annotations.ThreadUnsafe;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Leson on 2018/6/27.
 */
@ThreadUnsafe
public class ImmutableEg1 {
    private final static Integer a = 1;
    private final static String b = "aha";
    private final static Map<Integer, Integer> map = new HashMap<>();
    static {
        map.put(1,2);
        map.put(3,4);
        //map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        //test();
    }

}
