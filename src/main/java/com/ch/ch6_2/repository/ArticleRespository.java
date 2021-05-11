package com.ch.ch6_2.repository;

import com.ch.ch6_1.entity.Article;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

//继承jpa类
//直接用6-1中的实体类
public interface ArticleRespository extends JpaRepository<Article,Integer> {
    //文章持久层用来查询文章

    //根据作者id 查询文章的标题与内容
    @Query("select new Map(a.title as title,a.content as content) from Article a where a.author.id=?1")
    public List<Map<String,Object>> findTitleAndContentByAuthorId(Integer id);

    //根据作者名和作者id查询文章信息
    @Query("select a from Article  a where a.author.aname=?1 and a.author.id=?2")
    public List<Article> findArticleByAuthorAnameAndId(String aname, Integer id, Sort sort);





}
