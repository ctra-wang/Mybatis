package com.ctra.dao;

import com.ctra.pojo.User;
import com.ctra.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.List;

public class UserDaoTest {

    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
        stringObjectHashMap.put("index",0);
        stringObjectHashMap.put("pagesize",2);

        List<User> userList = mapper.getUserByLimit(stringObjectHashMap);
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}
