import com.ctra.dao.StudentMapper;
import com.ctra.dao.TeacherMapper;
import com.ctra.pojo.Student;
import com.ctra.pojo.Teacher;
import com.ctra.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class test {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
//        Teacher teacher =mapper.getTeacher(1);

        Teacher teacher =mapper.getTeacher2(1);

        System.out.println(teacher);
        sqlSession.close();

    }


}
