package com.ctra.reflection;

import java.lang.annotation.*;

public class Test12 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> c1 = Class.forName("com.ctra.reflection.Student2");

        // 通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }


        // 获得注解的 value 的值
        Table annotation = (Table) c1.getAnnotation(Table.class);
        String value = annotation.value();
        System.out.println(value);


        //  获得类指定的注解
        java.lang.reflect.Field f =  c1.getDeclaredField("name");
        Field annotation1 = f.getAnnotation(Field.class);
        System.out.println(annotation1.columnName());
        System.out.println(annotation1.length());
        System.out.println(annotation1.type());


    }
}

@Table("db_student")
class Student2{
    @Field(columnName = "db_age",type="int",length = 10)
    private int age;
    @Field(columnName = "db_id",type="int",length = 8)
    private int id;
    @Field(columnName = "db_name",type="int",length = 9)
    public String name;

    public Student2() {
    }

    public Student2(int age, int id, String name) {
        this.age = age;
        this.id = id;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "age=" + age +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table{
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Field{
    String columnName();
    String type();
    int length();
}