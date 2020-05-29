import com.ctra.dao.UserMapper;
import com.ctra.pojo.User;
import com.ctra.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void test1(){
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);
        System.out.println("=============");
        // 进行 增删改 操作
//        mapper.updateUser(new User(1,"kill","test"));
        // 手动清理一级缓存
        session.clearCache();

        System.out.println("=============");
        User user1 = mapper.queryUserById(1);
        System.out.println(user1);
        session.close();
    }

    @Test
    public void test2(){
        SqlSession session = MybatisUtils.getSqlSession();
        SqlSession session2 = MybatisUtils.getSqlSession();

        UserMapper mapper = session.getMapper(UserMapper.class);



        User user = mapper.queryUserById(1);
        System.out.println(user);
        session.close();

        UserMapper mapper2 = session2.getMapper(UserMapper.class);
        User user1 = mapper2.queryUserById(1);
        System.out.println(user1);

        System.out.println(user==user1);
        session2.close();

    }
}
