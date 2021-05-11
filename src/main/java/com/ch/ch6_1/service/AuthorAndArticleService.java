package com.ch.ch6_1.service;
//定义service层的接口

import com.ch.ch6_1.entity.Article;
import com.ch.ch6_1.entity.Author;

import java.util.List;

public interface AuthorAndArticleService {
    public void saveAll();
    public List<Article> findByAuthor_Id(Integer id);
    public List<Article> findByAuthor_Aname(String aname);
    public List<Author> findByArticleList_titleContaining(String title);


}
