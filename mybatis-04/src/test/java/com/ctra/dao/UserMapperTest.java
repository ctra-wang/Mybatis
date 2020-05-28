package com.ctra.dao;

import com.ctra.pojo.User;
import com.ctra.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class UserMapperTest {
    Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void getUserById(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(2);
        System.out.println(userById);


        sqlSession.close();
    }

    @Test
    public  void testlog4j(){
        logger.info("info:进入了testLog4j方法");
        logger.debug("debug:进入了testLog4j方法");
        logger.error("error:进入了testLog4j方法");
    }

}
