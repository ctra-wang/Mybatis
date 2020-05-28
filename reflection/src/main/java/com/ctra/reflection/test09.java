package com.ctra.reflection;

import javax.jws.soap.SOAPBinding;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//动态的创建对象，通过反射
public class test09 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 获得 Class 对象
        Class c1 = Class.forName("com.ctra.reflection.User");

        // 构造一个对象
        // jdk9之后
        // User user1 = (User)c1.getDeclaredConstructor().newInstance();
        // jdk8
        //User user = (User)c1.newInstance(); // 本质是调用了类的无参构造器

        //System.out.println(user);

        // 此时注释掉 无参构造方法
        // 通过构造器创建对象    (调用有参构造函数）
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user2 = (User)constructor.newInstance("ctra", 001, 18);
        System.out.println(user2);


        // 通过反射调用普通方法
        User user3 = (User)c1.newInstance(); // 获取对象
        //通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        //  invoke：激活
        setName.invoke(user3,"ctra"); // （对象，方法的值）
        System.out.println(user3.getName());

        // 通过反射操作属性
        User user4 = (User)c1.newInstance();
        Field name = c1.getDeclaredField("name");
        // 不能直接操作私有属性，关闭程序安全监测可以
        name.setAccessible(true);
        name.set(user4,"CTRA_WL");
        System.out.println(user4.getName());

    }
}
