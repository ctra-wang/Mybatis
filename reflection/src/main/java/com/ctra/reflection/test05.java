package com.ctra.reflection;

public class test05 {
//    public static int test1(int i){
//        return 1;
//    }
//    public static double test1(double i){
//        return 1;
//    }


    public static void main(String[] args){
        test1(10);
        test2(20);
    }
    public static void test1(int v){}
    public static void test2(int v){
        test3(30);
    }
    public static void test3(int v){}


    public int add(){
        int a=10;
        int b=20;
        return a+ b;
    }
}
