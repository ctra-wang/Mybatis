package com.ctra.annotation;

import javax.xml.bind.annotation.XmlType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 自定义注解
public class test03 {
    // 注解可以显示赋值，如果没有默认值，我们就必须给注解赋值
    @MyAnnotation(age=12)
    public void test(){}

    @MyAnnotation2(1)
    public void test2(){}
}

@Target({ElementType.TYPE,ElementType.METHOD}) //作用域
@Retention(RetentionPolicy.RUNTIME) //作用范围
@interface MyAnnotation{
//    注解的参数： 参数类型 + 参数名();
    String name() default "";
    int age()  ;
    int id() default -1;
    String[] schools() default {"a","b"};
}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    int value();
}