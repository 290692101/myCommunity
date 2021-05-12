package com.bbs.controller;

import com.bbs.res.JsonResult;
import com.bbs.res.ResultCode;
import com.bbs.res.ResultTool;
import com.bbs.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerContorller {
    @Autowired
    ManagerService ms;

//    @Autowired
//    private ResultTool resultTool;
//    @Bean
//    public PasswordEncoder getCoder(){
//    return new BCryptPasswordEncoder();
//}
//    @Autowired
//    PasswordEncoder passwordEncoder;


    /**
     * 用户注册
     * @param username
     * @param password
     * @return
     */
    @PostMapping(value = "/users")
    public JsonResult register(@RequestParam("username") String username, @RequestParam("password") String password){
        if(username.length()==0||username.length()>45||
                password.length()==0||password.length()>45){
            return ResultTool.fail(ResultCode.PARAM_IS_BLANK);

        }
        if(ms.getUserByUsername(username)!=null){
            //查看同名用户是否存在

            return ResultTool.fail(ResultCode.USER_ACCOUNT_ALREADY_EXIST);
        }
         if(ms.insertUser(username,password)){
             return ResultTool.success();
         };
         return ResultTool.fail(ResultCode.PARAM_NOT_VALID);

    }

    /**
     * 修改用户密码
     * @param password
     * @return
     */
    @PutMapping(value = "/users")
    public JsonResult updateUserPassword(@RequestParam("password") String password){
        //参数检查
        if(password.length()==0){
            return ResultTool.fail(ResultCode.PARAM_IS_BLANK);
        }
        if(password.length()>45){
            return ResultTool.fail(ResultCode.PARAM_NOT_VALID);

        }

        //获取当前连接的用户
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currUser= (User) auth.getPrincipal();
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        boolean flag=passwordEncoder.matches(password,
                ms.getUserByUsername(currUser.getUsername()).getPassword());
        if(flag){
            return ResultTool.fail(ResultCode.PARAM_NOT_VALID);

        }
        //从context中保存的用户对象获取用户id
        Integer currUserId=ms.getUserByUsername(currUser.getUsername()).getId();
        if(ms.updateUserPassword(currUserId,password)){

            return ResultTool.success();
        }
        return  ResultTool.fail();



    }


}
