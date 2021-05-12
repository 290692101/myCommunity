package com.bbs.service;

import com.bbs.dao.PostMapper;
import com.bbs.dao.TopicMapper;
import com.bbs.dao.UserMapper;
import com.bbs.entity.Topic;
import com.bbs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台管理模块
 */
@Service
public class ManagerService {
    //依赖注入dao
    @Autowired
    private PostMapper pm;
    @Autowired
    private TopicMapper tm;
    @Autowired
    private UserMapper um;

    /**用户注册服务
     *
     * @param username 用户名
     * @param password 密码
     * @return 统一返回值
     */
    public boolean insertUser(String username,String password){
        //检查用户名和密码的长度是否合法

        //开始进入注册用户阶段
        User u1=new User();
        u1.setCreateTime(new Date());
        //logger.warn("自动获取到的时间为"+u1.getCreateTime());
        u1.setUsername(username);
        u1.setEmail("");
        u1.setCredit(0);
        u1.setStatus(0);
        u1.setType(0);
        PasswordEncoder bp=new BCryptPasswordEncoder();
        u1.setPassword(bp.encode(password));

       // logger.warn("开始写入数据库");
        int res=um.insertUser(u1);
        //logger.warn("插入后返回的数据为"+res);
        //logger.warn("主键为"+u1.getId());
        return true;
    }

    /**
     * 修改密码服务
     *
     * 0511通过测试
     * @param userId 用户id
     * @param npassword 新的用户密码
     * @return
     */
    public boolean updateUserPassword(Integer userId,String npassword){
        Map<String,Object> map=new HashMap<>();
        map.put("id",userId);
        //密码的哈希编码器
        PasswordEncoder bp=new BCryptPasswordEncoder();

        map.put("password",bp.encode(npassword));
        int res=um.updateUserByMap(map);
        if(res==1) {
            return true;
        }
        return false;
    }

    /**
     * 删除主题帖及其讨论帖的所有内容
     * @param topicId 主题帖id
     * @return 是否删除成功
     */
    public boolean deleteTopic(int topicId){
        return true;
    }

    /**
     * 删除楼层
     * @param postId 回复帖id
     * @return 是否删除成功
     */
    public boolean deletePost(int postId){
        return true;
    }

    /**
     * 管理功能 查看某个用户的主题帖
     * 通过测试
     * */
    public List<Topic> selectTopics(int offset, int limit,int userId){
        List<Topic> res=tm.selectTopics(offset,limit,userId);
        return res;
    }

    /**
     * 根据用户名获取User实体类对象
     * 通过测试
     */
    public User getUserByUsername(String username){
        return um.selectUserByUsername(username);

    }


}
