package com.developlee.syncContainer;

import com.developlee.annotations.ThreadUnsafe;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Leson on 2018/7/2.
 */
@ThreadUnsafe
public class VectorEg3 {


    private static Vector<Integer> vector = new Vector<>();

    //success
    public static void test1() {
        for (Integer i = 0; i < vector.size(); i++) {
            if (i.equals(3)) {
                vector.remove(i);
            }
        }
    }

    //java.util.ConcurrentModificationException
    public static void test2() {
        for (Integer i : vector) {
            if (i.equals(3)) {
                vector.remove(i);
            }
        }
    }

    //java.util.ConcurrentModificationException
    public static void test3() {
        Iterator<Integer> iterator = vector.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i.equals(3)) {
                vector.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        vector.add(1);
        vector.add(2);
        vector.add(3);
        test3();
    }

}
