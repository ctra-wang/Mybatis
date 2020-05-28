package com.ctra.reflection;

public class Jvm {
    public static Jvm test = new Jvm();
    public static void main(String[] args) {
        Jvm demo =new Jvm();
        System.out.println(demo.add());
    }

    public int add(){
        int a=10;
        int b=20;
        return a+ b;
    }
}
