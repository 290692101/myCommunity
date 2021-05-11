package com.ch.ch6_1.repository;

import com.ch.ch6_1.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRespository extends JpaRepository<Article,Integer> {
    /*
     * 根据作者id查询 文章信息
     * 相当于JPQL语句：
     * select a
     * from Article a
     * where a.author.id=?1
     *
     * */
    //Articcle和author是有对应关系的 所以才有两个点

    public List<Article> findByAuthor_Id(Integer id);
    /*
    * 根据作者名查询 文章信息
     * 相当于JPQL语句：
     * select a from Article a
     *  where a.author.aname=?1
    * */
    public List<Article> findByAuthor_Aname(String aname);




}
