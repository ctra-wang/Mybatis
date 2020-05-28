package com.ctra.reflection;

public class test07 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 获取系统类加载器的父类加载器-->拓展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        // 获取拓展类加载器的父类加载器-->根加载器（C++）
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        // 测试当前类是哪个加载器加载的
        ClassLoader classLoader = Class.forName("com.ctra.reflection.test07").getClassLoader();
        System.out.println(classLoader);

        // 测试 JDK 内置的类 是谁加载  由于根加载器，无法加载
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);


        System.out.println(System.getProperty("java.class.path"));
        /*
        * D:\Program Files\Java\jdk1.8.0_211\jre\lib\charsets.jar;
        * D:\Program Files\Java\jdk1.8.0_211\jre\lib\deploy.jar;
        * D:\Program Files\Java\jdk1.8.0_211\jre\lib\ext\access-bridge-64.jar;
        * D:\Program Files\Java\jdk1.8.0_211\jre\lib\ext\cldrdata.jar;
        * D:\Program Files\Java\jdk1.8.0_211\jre\lib\ext\dnsns.jar;
        * D:\Program Files\Java\jdk1.8.0_211\jre\lib\ext\jaccess.jar;
        * D:\Program Files\Java\jdk1.8.0_211\jre\lib\ext\jfxrt.jar;
        * D:\Program Files\Java\jdk1.8.0_211\jre\lib\ext\localedata.jar;
        * D:\Program Files\Java\jdk1.8.0_211\jre\lib\ext\nashorn.jar;
        * D:\Program Files\Java\jdk1.8.0_211\jre\lib\ext\sunec.jar;
        * D:\Program Files\Java\jdk1.8.0_211\jre\lib\ext\sunjce_provider.jar;
        * D:\Program Files\Java\jdk1.8.0_211\jre\lib\ext\sunmscapi.jar;
        * D:\Program Files\Java\jdk1.8.0_211\jre\lib\ext\sunpkcs11.jar;
        * D:\Program Files\Java\jdk1.8.0_211\jre\lib\ext\zipfs.jar;
        * D:\Program Files\Java\jdk1.8.0_211\jre\lib\javaws.jar;
        * D:\Program Files\Java\jdk1.8.0_211\jre\lib\jce.jar;
        * D:\Program Files\Java\jdk1.8.0_211\jre\lib\jfr.jar;
        * D:\Program Files\Java\jdk1.8.0_211\jre\lib\jfxswt.jar;
        * D:\Program Files\Java\jdk1.8.0_211\jre\lib\jsse.jar;
        * D:\Program Files\Java\jdk1.8.0_211\jre\lib\management-agent.jar;
        * D:\Program Files\Java\jdk1.8.0_211\jre\lib\plugin.jar;
        * D:\Program Files\Java\jdk1.8.0_211\jre\lib\resources.jar;
        * D:\Program Files\Java\jdk1.8.0_211\jre\lib\rt.jar;
        * E:\idea\mybatis\reflection\target\classes;
        * C:\Users\Administrator\.m2\repository\mysql\mysql-connector-java\5.1.47\mysql-connector-java-5.1.47.jar;
        * C:\Users\Administrator\.m2\repository\org\mybatis\mybatis\3.5.2\mybatis-3.5.2.jar;
        * C:\Users\Administrator\.m2\repository\junit\junit\4.12\junit-4.12.jar;
        * C:\Users\Administrator\.m2\repository\org\hamcrest\hamcrest-core\2.1\hamcrest-core-2.1.jar;
        * C:\Users\Administrator\.m2\repository\org\hamcrest\hamcrest\2.1\hamcrest-2.1.jar;
        * D:\Program Files\JetBrains\IntelliJ IDEA 2019.3.3\lib\idea_rt.jar
        * */

    }
}
