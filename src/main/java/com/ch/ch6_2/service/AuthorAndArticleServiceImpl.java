package com.ch.ch6_2.service;

import com.ch.ch6_1.entity.Article;
import com.ch.ch6_1.entity.Author;
import com.ch.ch6_2.repository.ArticleRespository;
import com.ch.ch6_2.repository.AuthorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class AuthorAndArticleServiceImpl implements AuthorAndArticleService{
    @Autowired
    ArticleRespository articleRespository;
    @Autowired
    AuthorRespository authorRespository;

    @Override
    public List<Map<String, Object>> findTitleAndContentByAuthorId(Integer id) {
        return articleRespository.findTitleAndContentByAuthorId(id);
    }

    @Override
    public List<Article> findArticleByAuthorAnameAndId(String aname, Integer id, Sort sort) {


        return articleRespository.findArticleByAuthorAnameAndId(aname,id,sort);
    }

    @Override
    public Author findAuthorByArticleListTitleContaing(String title) {
        return authorRespository.findAuthorByArticleListTitleContaing(title);
    }

    @Override
    public int deleteAuthorByAuthorId(int id) {
        return authorRespository.deleteAuthorByAuthorId(id);
    }
}

