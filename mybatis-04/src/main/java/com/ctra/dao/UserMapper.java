package com.ctra.dao;

import com.ctra.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //    查询全部用户
    List<User> getUserList();
    //  根据ID查询用户
    User getUserById(int id);

    //
    User getUserById2(Map<String, Object> map);

    //    添加用户
    int addUser(User user);

    // 万能map
    int addUser2(Map<String, Object> map);

    //    修改用户
    int updateUser(User user);

    int deleteUser(int id);
}
