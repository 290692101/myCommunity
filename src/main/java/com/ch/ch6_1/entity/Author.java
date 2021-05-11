package com.ch.ch6_1.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "author_table")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Author implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //作者名
    private String aname;
    //文章列表，作者与文章是一对多的关系
    @OneToMany(
            mappedBy = "author",
            cascade=CascadeType.ALL,
            targetEntity = Article.class,
            fetch=FetchType.LAZY
    )
    private List<Article> articleList;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAname() {
        return aname;
    }
    public void setAname(String aname) {
        this.aname = aname;
    }
    public List<Article> getArticleList() {
        return articleList;
    }
    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}
