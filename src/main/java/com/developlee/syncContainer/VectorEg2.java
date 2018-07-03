package com.developlee.syncContainer;

import com.developlee.annotations.ThreadUnsafe;

import java.util.Vector;

/**
 * Created by Leson on 2018/7/2. 验证vector 某些情况下出现线程不安全的例子
 */
@ThreadUnsafe
public class VectorEg2 {

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }
            Thread thread1 = new Thread() {
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        vector.remove(i);
                    }

                }
            };
            Thread thread2 = new Thread() {
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        vector.get(i);
                    }
                }
            };

            thread1.start();
            thread2.start();
        }
    }

}
