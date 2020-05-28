# 2.  MyBatis

 - MyBatis 是一个半自动化的持久化层框架
 - JDBC ：
 - 			SQL夹在Java代码块里，耦合度高导致硬编码内伤
 - 			维护不易且实际开发需求中sql是有变化，频繁修改的情况多见
 - Hibernate 和 JPA
 - 			长、难、复杂SQL，对于Hibernate而言处理也不容易
 - 			内部自动生产的SQL，不容易做特殊优化
 - 			基于全映射的全自动框架，大量字段的POJO进行部分映射时比较困难。导致数据库性能下降
 - 
 - 对开发人员而言，核心sql还是需要自己优化
 - <font color=red>sql和java编码分开，功能边界清晰，一个专注业务，一个专注数据</font>

### 2.1 搭建项目环境
###### 2.1.1	数据库搭建

```sql
create DATABASE `mybatis`;

USE `mybatis`;
create TABLE `user`(
	`id` int PRIMARY KEY not NULL,
	`name` varchar(30) DEFAULT null,
	`pwd` varchar(30) DEFAULT null
)ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT into `USER`(`id`,`name`,`pwd`) values(1,'wanglei',123456),(2,'wanglei',123456)
```

###### 2.1.2	新建项目

 1. 新建一个普通的maven项目
 2. 删除src目录 （此时创建好一个父工程）
 3. 倒入 maven 依赖
 

```java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <!--  父工程  -->
    <groupId>org.ctra</groupId>
    <artifactId>mybatis</artifactId>
    <version>1.0-SNAPSHOT</version>

    <!--  导入依赖  -->
    <dependencies>
        <!--  mysql驱动  -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.47</version>
        </dependency>
        <!--  mybatis  -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.2</version>
        </dependency>
        <!--  junit  -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
        </dependency>
    </dependencies>
</project>
```

### 2.2 创建模块
##### 2.2.1	编写mybatis的核心配置文件

```java
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<!-- configuration 核心配置文件-->
<configuration>
    <environments default="development">
        <environment id="development">
            <!-- 事务管理-->
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/mybatis?serverTimezone=UTC&amp;useSSL=false&amp;userUnicode=true&amp;characterEncoding=UTF-8"/>
                <property name="username" value="root"/>
                <property name="password" value="wl86662165"/>
            </dataSource>
        </environment>
    </environments>

</configuration>
```
从官网拿到核心配置文件（删除 mapper）
如下图：为url
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200421211809604.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmdsZWkxOTg5MTIxMA==,size_16,color_FFFFFF,t_70)
##### 2.2.2	编写mybatis的核心配置文件
编写mybatis的工具类

```java
package com.ctra.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

// sqlSessionFactory --> sqlSession
public class MybatisUtils {
    static SqlSessionFactory sqlSessionFactory;

    static {
        InputStream inputStream;
        try {
            // 使用mybatis第一步：获取 sqlSessionFactory 对象
            String resource = "mybatis-config.xml";
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    //    既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。
    //    SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}

```

##### 2.2.3	编写代码

 1. 实体类
 2. Dao接口
 3. 接口实现类

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200421110605613.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmdsZWkxOTg5MTIxMA==,size_16,color_FFFFFF,t_70)

### 1.2 创建项目


### 1.3 修改pom文件，添加相关依赖

```c
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.6.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.ctra</groupId>
    <artifactId>springbootmybatis</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>springbootmybatis</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
<!--  mybatis 启动器-->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.2</version>
        </dependency>
        <!--   数据库驱动坐标     -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.38</version>
        </dependency>

        <!--   Druid数据源依赖    -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.1.12</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
            <exclusions>
                <exclusion>
                    <groupId>org.junit.vintage</groupId>
                    <artifactId>junit-vintage-engine</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>

```

### 1.4 配置数据源信息




添加	DTDs  文件
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200421114414665.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dhbmdsZWkxOTg5MTIxMA==,size_16,color_FFFFFF,t_70)