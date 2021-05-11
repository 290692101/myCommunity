package com.bbs.controller;

import com.bbs.entity.Post;
import com.bbs.entity.Topic;
import com.bbs.res.JsonResult;
import com.bbs.res.ResultCode;
import com.bbs.res.ResultTool;
import com.bbs.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    @Autowired
   private PostService ps;
//    @Autowired
//    private ResultTool resultTool;
    final private Logger logger= LoggerFactory.getLogger(com.bbs.bbsApp.class);
/*
    //get方法  getTopics
    //@GetMapping(value = "/topics")
    //其实应该写一个根据页码和页数返回的逻辑
    //public List<Topic> topics(){
        public JsonResult topics(){
        //注意 controller层都是调用的分页的service
        //使用JsonResult来返回结果
        JsonResult result = ResultTool.success();
        result.setData(ps.selectTopics(0,10));
        return result;
       // return ps.selectTopics(0,10);
    }*/

    /**
     *浏览功能 浏览所有主题帖
     * @param page 页码 从第一页开始
     * @return
     */
    @GetMapping(value = "/topics")
    public JsonResult<List<Topic>> topics(Integer page){
        //设置一页的个数为7个
        //这个是加载前端页面是时候要用到
        //int pageNum=ps.getTopicPageNum(7);
        //return ResultTool.success(ps.selectTopics((page-1)*7,7));
        return ResultTool.success(ps.selectTopics((page-1)*7,7));


    }

    /**
     *浏览功能 浏览主题帖的子内容
     * @param topicId
     * @param lz 1为选定只看楼主 默认为0
     * @param desc 1为选定倒序查看 默认为0
     * @param page 页码 最小为1
     * @return
     */
    @GetMapping(value = "/posts")

    public JsonResult<List<Post>> topicPost(Integer topicId,Integer lz,Integer desc,Integer page){
        return ResultTool.success(ps.selectPosts((page-1)*7,7,topicId,lz,desc));

    }

    /**
     * 发帖功能 发布主题帖
     */
    @PostMapping(value = "/topics")
    public JsonResult createTopic(@RequestParam("title") String  title,
                                  @RequestParam("content") String content){
        //对传入service层数据的参数做检查
        if(title==null||content==null){
            return ResultTool.fail(ResultCode.PARAM_IS_BLANK);

        }
        if(title.length()>50||content.length()>200||title.length()==0||content.length()==0){
            return ResultTool.fail(ResultCode.PARAM_NOT_VALID);

        }




        //获取当前连接的用户
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currUser= (User) auth.getPrincipal();


       // logger.warn(currUser.getUsername());
        ps.createTopic(title, currUser.getUsername(), content);


        return ResultTool.success();

    }

    /**
     * 回帖功能 回复主题帖
     * @param topicId 主题帖id
     * @param content 回帖的内容
     * @return
     */
    @PostMapping(value = "/posts")
    public JsonResult replyTopic(@RequestParam("topicId") Integer topicId,
                                 @RequestParam("content") String content
                                 ){
        //对传入service层数据的参数做检查
        if(topicId==null||content==null){
            return ResultTool.fail(ResultCode.PARAM_IS_BLANK);

        }
        if(content.length()>200){
            return ResultTool.fail(ResultCode.PARAM_NOT_VALID);
        }


        //获取当前连接的用户
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currUser= (User) auth.getPrincipal();
        ps.replyTopic(topicId,currUser.getUsername(),content);
        return ResultTool.success();
    }


}
