package com.ch.ch6_1.controller;

import com.ch.ch6_1.entity.Article;
import com.ch.ch6_1.entity.Author;
import com.ch.ch6_1.service.AuthorAndArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//直接返回json的控制器
@RestController
public class OneToManyController {
    //注入服务层
    @Autowired
    private AuthorAndArticleService authorAndArticleService;

    //对各种请求的处理
    @RequestMapping("/saveOneToMany")
    public String save() {
        authorAndArticleService.saveAll();
        return "作者和文章保存成功！";
    }

    @RequestMapping("/findArticleByAuthor_id")
    public List<Article> findByAuthor_Id(Integer id) {
        return authorAndArticleService.findByAuthor_Id(id);


    }

    @RequestMapping("/findByAuthor_Aname")
    public List<Article> findByAuthor_Aname(String aname) {
        return authorAndArticleService.findByAuthor_Aname(aname);

    }

    @RequestMapping("/findByArticleList_titleContaining")
    public List<Author> findByArticleList_titleContaining(String title) {
        return authorAndArticleService.findByArticleList_titleContaining(title);
    }
}


