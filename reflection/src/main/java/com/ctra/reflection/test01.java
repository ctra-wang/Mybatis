package com.ctra.reflection;
//什么叫反射
public class test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("com.ctra.reflection.test01");

        Class c2 = Class.forName("com.ctra.reflection.test01");

        Class c3 = Class.forName("com.ctra.reflection.test01");
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());

        Class userClass = User.class;
        Class c = userClass.getClass();

    }
}

// 实体类：pojo entity
class User{
    private String name;
    private int id;
    private int age;

    public User() {
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void test(){}

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
