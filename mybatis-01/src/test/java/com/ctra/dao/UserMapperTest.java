package com.ctra.dao;

import com.ctra.pojo.User;
import com.ctra.utils.MybatisUtils;
import com.sun.javafx.collections.MappingChange;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.xml.bind.SchemaOutputResolver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    public  void test(){
        // 第一步：获得sqlsession 对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一： getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        List<User> userList = userDao.getUserList();

        //方式二： getMapper 老版本不推荐
        List<User> userList = sqlSession.selectList("com.ctra.dao.UserMapper.getUserList");

        for (User user : userList){
            System.out.println(user);
        }

        //  关闭 sqlsession
        sqlSession.close();
    }

    @Test
    public void getUserById(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(2);
        System.out.println(userById);


        sqlSession.close();
    }
    //    增删改查需要提交事务
    @Test // 添加用户
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.addUser(new User(3, "zhangsan", "999"));
        if(res>0){
            System.out.println("插入成功");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test // 添加用户
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //        (#{userId},#{userName},#{userPwd})
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId",7);
//        map.put("userName","ooo");
        map.put("userPwd","1234988");

       int res= mapper.addUser2(map);
       if(res>0){
           System.out.println("插入成功");
       }
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.updateUser(new User(1, "wangll", "8989"));
        if (res>0){
            System.out.println("修改成功");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.deleteUser(3);
        if(res>0){
            System.out.println("删除成功！");
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
