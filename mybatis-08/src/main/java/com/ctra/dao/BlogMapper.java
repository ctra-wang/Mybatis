package com.ctra.dao;

import com.ctra.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
//    插入数据
    int addBlog(Blog blog);
    List<Blog> queryBlogIF(Map map);

    List<Blog> queryBlogInclude(Map map);

    List<Blog> queryBlogWhere(Map map);

    List<Blog> queryBlogChose(Map map);

    int updateBlog(Map map);

    List<Blog> queryBlogForeach(Map map);
}

