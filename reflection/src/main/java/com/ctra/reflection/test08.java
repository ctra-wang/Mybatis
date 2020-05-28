package com.ctra.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("com.ctra.reflection.User");

        // 获得类的名字
        System.out.println("================获得类的名字 Simple & 非Simple============");
        System.out.println(c1.getName()); // 包名+类名
        System.out.println(c1.getSimpleName());//获得类名

        // 获得类的属性
        System.out.println("=============获得类的属性 Declared &非Declared===============");
        Field[] fields = c1.getFields(); // 只能找到 public属性
        for (Field field : fields) {
            System.out.println(field);
        }

        Field[] declaredFields = c1.getDeclaredFields(); // 找到全部的属性
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

//        Field name = c1.getField("name");
//        System.out.println(name);

        // 获得指定属性
        System.out.println("=============获得类的属性 getDeclaredField===============");
        Field name1 = c1.getDeclaredField("name");
        System.out.println(name1);

        // 获得类的方法
        System.out.println("==============获得类的方法 Declared &非Declared============");
        Method[] methods = c1.getMethods(); // 获得奔雷及其弗雷德全部 public 方法

        for (Method method : methods) {
            System.out.println("正常的："+method);
        }

        methods = c1.getDeclaredMethods(); // 获得本类的所有方法
        for (Method method : methods) {
            System.out.println("getDeclaredMethods:"+method);
        }


        // 获得指定方法
        // 重载
        System.out.println("=================获得 重载 get、set===================");
        Method getName = c1.getMethod("getName", null);
        System.out.println(getName);

        Method setName = c1.getMethod("setName", String.class);
        System.out.println(setName);


        // 获得指定的构造器
        System.out.println("=================获得指定的构造器 Declared &非Declared ===================");
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("#"+constructor);
        }


        // 获得指定的构造器
        System.out.println("===================获得指定的构造器=================");
        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println("指定："+declaredConstructor);
    }
}
