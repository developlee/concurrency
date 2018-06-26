package com.developlee.publish;

/**
 * Created by Leson on 2018/6/24.
 * 一种错误的发布，当一个对象还没有构造完成时，就使它被其他线程所见。
 */
public class UnsafeEg2 {

    private Integer  isCanBeEscape = 1;// 是否能逸出

    public UnsafeEg2(){
        new Escape();
    }



    //创建一个内部类
    private class Escape {
        //构造方法来一个
        public Escape(){
            //做个输出isCanBeEscape
            System.out.println(UnsafeEg2.this.isCanBeEscape);
        }
    }

    //

    public static void main(String[] args) {
        new UnsafeEg2();

    }

    //对象未完成构造前，不可以将其发布。
}
