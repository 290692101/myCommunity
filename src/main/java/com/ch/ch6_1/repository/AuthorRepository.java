package com.ch.ch6_1.repository;


//文章与作者服务相关的数据访问层
//继承jpa接口

import com.ch.ch6_1.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    //根据文章标题包含的内容，查询作者
    //相当于JPQL语句
    /*select a
        from Author a
            inner join a.ArticleList t
                where t.title like %?1%
      */
    //自联结是on和where是等价的



    public List<Author> findByArticleList_titleContaining(String title);


}
