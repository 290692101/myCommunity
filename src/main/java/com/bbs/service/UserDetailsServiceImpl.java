package com.bbs.service;

import com.bbs.dao.UserMapper;
import com.bbs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
/** 用户接入模块
 * */
public class UserDetailsServiceImpl implements UserDetailsService {
    //注入用户对应的DAO层
    @Autowired
    private UserMapper um;


    @Override
    /**
     * 返回的UserDetails是一个接口
     * 我们使用security已有的实现了该接口的user类作为返回类型
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*构造一个user返回*/
        /*String username：用户名
String password： 密码
boolean enabled： 账号是否可用
boolean accountNonExpired：账号是否过期
boolean credentialsNonExpired：密码是否过期
boolean accountNonLocked：账号是否锁定
Collection<? extends GrantedAuthority> authorities)：用户权限列表
*/
    /*
    * */
        //先是对入参进行特判
        if(username==null||"".equals(username)){
            throw new RuntimeException("用户名不能为空");
        }
        User res=um.selectUserByUsername(username);


        //四个布尔值统一用字段中的一个status来指代
        int status=res.getStatus();
        boolean enabled=false;
        boolean accountNonExpired=false;
        boolean credentialsNonExpired=false;
        boolean accountNonLocked=false;
        if(status==1){
            enabled=true;
            accountNonExpired=true;
            credentialsNonExpired=true;
            accountNonLocked=true;
        }



        //使用这个包装类将已有的字段属性映射为人家承认的权限
        //这里以后可以将type设置为枚举类 然后在mybatis层实现映射
        //现在先在service层映射 因为用户类别不多。只有用户和管理员
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        int type=res.getType();
        GrantedAuthority grantedAuthority= new SimpleGrantedAuthority("普通用户");
        grantedAuthorities.add(grantedAuthority);
        if(type==1) {
            GrantedAuthority grantedAuthority2 = new SimpleGrantedAuthority("管理员");
            grantedAuthorities.add(grantedAuthority2);
        }
        //return null;
        return new org.springframework.security.core.userdetails.User(res.getUsername(),
                res.getPassword(),
                enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,
                grantedAuthorities);
    }
}
