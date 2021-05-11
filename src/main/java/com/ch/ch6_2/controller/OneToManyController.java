package com.ch.ch6_2.controller;

import com.ch.ch6_1.entity.Author;
import com.ch.ch6_2.service.AuthorAndArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class OneToManyController {


    @Autowired
    private AuthorAndArticleService authorAndArticleService;

    @RequestMapping("/deleteAuthorByAuthorId")
    public int deleteAuthorByAuthorId(Integer id){
        return authorAndArticleService.deleteAuthorByAuthorId(id);
    }

    @RequestMapping("/findArticleByAuthorAnameAndId")
    public java.util.List<com.ch.ch6_1.entity.Article> findArticleByAuthorAnameAndId(String name, Integer id){
        //传入一个Sort对象作为降序

        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        //Sort sortx = new Sort(new Sort.Order(Sort.Direction.DESC,"id"));


        return authorAndArticleService.findArticleByAuthorAnameAndId(name,id,sort);
    }

    @RequestMapping("/findAuthorByArticleListTitleContaing")
    public Author findAuthorByArticleListTitleContaing(String title){
        return authorAndArticleService.findAuthorByArticleListTitleContaing(title);
    }

    @RequestMapping("/findTitleAndContentByAuthorId")
    public List<Map<String,Object>> findTitleAndContentByAuthorId(Integer id){
        return authorAndArticleService.findTitleAndContentByAuthorId(id);
    }



}
