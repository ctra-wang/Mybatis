package com.ctra.reflection;

import java.util.zip.CheckedOutputStream;

public class test06 {
    static{
        System.out.println("Main类被加载");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        // 1、 主动引用
//        Son s= new Son();
        // 反射也会产生主动引用
//        Class c1 = Class.forName("com.ctra.reflection.Son");

//        不会产生类的引用的方法
//        System.out.println(Son.b);

//        Son[] array = new Son[5];

        System.out.println(Son.M);
    }

}

class Father{
    static int b =2;
    static{
        System.out.println("父类被加载");
    }
}

class Son extends Father{
    static{
        System.out.println("子类被夹在");
        m =300;
    }
    static int m =100;
    static final int M=1;
}