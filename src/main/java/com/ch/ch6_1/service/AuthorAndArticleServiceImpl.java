package com.ch.ch6_1.service;
//服务层的具体实现
//使用service注解

import com.ch.ch6_1.entity.Article;
import com.ch.ch6_1.entity.Author;
import com.ch.ch6_1.repository.ArticleRespository;
import com.ch.ch6_1.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AuthorAndArticleServiceImpl implements AuthorAndArticleService{
    //注入两个持久层实体
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private ArticleRespository articleRespository;





    @Override
    public void saveAll() {
        //初始化
        //先保存1的一端
        //设置作者们
        Author a1=new Author();
        a1.setAname("lch");
        Author a2=new Author();
        a2.setAname("jxl");

        //向持久层存入对象
        ArrayList<Author> allAuthor=new ArrayList<Author>();
        allAuthor.add(a1);
        allAuthor.add(a2);

        authorRepository.saveAll(allAuthor);

        //保存多的一端
        //设置文章们

        Article at1=new Article();
        at1.setTitle("java");
        at1.setContent("java is not good");
        //设置对应的关系
        at1.setAuthor(a1);

        Article at2=new Article();
        at2.setTitle("python");
        at2.setContent("python is better");
        at2.setAuthor(a1);

        Article at3=new Article();
        //标题最短为2

        at3.setTitle("cyuyan");
        at3.setContent("c is difficult");
        at3.setAuthor(a2);

        Article at4=new Article();
        at4.setTitle("c++");
        at4.setContent("c++ is better than c but is also difficult");
        at3.setAuthor(a2);

        //保存文章对象
        ArrayList<Article> allAt=new ArrayList<Article>();

        allAt.add(at1);
        allAt.add(at2);
        allAt.add(at3);
        allAt.add(at4);

        //存入持久层
        articleRespository.saveAll(allAt);


    }

    //剩下的查询方法直接调库就好了

    @Override
    public List<Article> findByAuthor_Id(Integer id) {
        return articleRespository.findByAuthor_Id(id);
    }

    @Override
    public List<Article> findByAuthor_Aname(String aname) {
        return articleRespository.findByAuthor_Aname(aname);
    }

    @Override
    public List<Author> findByArticleList_titleContaining(String title) {
        return authorRepository.findByArticleList_titleContaining(title);
    }


}
