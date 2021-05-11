package com.ch.ch6_2.service;
//service层接口

import com.ch.ch6_1.entity.Article;
import com.ch.ch6_1.entity.Author;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;

public interface AuthorAndArticleService {
    public List<Map<String,Object>> findTitleAndContentByAuthorId(Integer id);
    public List<Article> findArticleByAuthorAnameAndId(String aname, Integer id, Sort sort);
    public Author findAuthorByArticleListTitleContaing(String title);
    public int deleteAuthorByAuthorId(int id);
}
