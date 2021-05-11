package com.ch.ch6_2.repository;

import com.ch.ch6_1.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRespository extends JpaRepository<Author,Integer> {
    //查询
    //根据文章标题的内容查找作者
    @Query("select a from Author a inner join a.articleList t where t.title like %?1%")
    public Author  findAuthorByArticleListTitleContaing(String title);


    //删除
    //根据作者id删除作者
    @Modifying
    @Query("delete from Author a where a.id=?1")
    public int deleteAuthorByAuthorId(int id);





}
