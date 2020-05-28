import com.ctra.dao.BlogMapper;
import com.ctra.pojo.Blog;
import com.ctra.utils.IDutils;
import com.ctra.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {

    @Test
    public void addInitBlog(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("mybatis 如此简单");
        blog.setViews(998);
        blog.setAuthor("wanglei");
        blog.setCreateTime(new Date());

        mapper.addBlog(blog);
        session.commit();
        session.close();
    }

    @Test
    public void queryBlogIF(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("author","wanglei");
        List<Blog> blogs = mapper.queryBlogIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        session.close();
    }

    @Test
    public void queryBlogWhere(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
//        map.put("author","wanglei");
//        map.put("title","123");
        map.put("view",998);
        List<Blog> blogs = mapper.queryBlogChose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        session.close();
    }


    @Test
    public void updateBlog(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
//        map.put("author","wanglei");
        map.put("title","123");
        map.put("id","4b22ee4269654a04abf4bb49375f8446");
//        map.put("view",998);
        int result = mapper.updateBlog(map);
        session.commit();
        session.close();
    }

    @Test
    public void searchBlogIclude(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("author","wanglei");
        map.put("title","123");
//        map.put("id","4b22ee4269654a04abf4bb49375f8446");
//        map.put("view",998);
        List<Blog> blogs = mapper.queryBlogInclude(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        session.close();
    }

    @Test
    public void queryBlogForeach(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        map.put("ids",ids);

//        map.put("author","wanglei");
//        map.put("title","123");
//        map.put("id","4b22ee4269654a04abf4bb49375f8446");
//        map.put("view",998);
        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        session.close();
    }
}
