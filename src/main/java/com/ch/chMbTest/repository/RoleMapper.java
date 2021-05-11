package com.ch.chMbTest.repository;

import com.ch.chMbTest.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
//将mapper默认视为repository
//数据访问层

@Mapper
public interface RoleMapper {
    Role selectRoleById(int id);

    //根据用户id查找角色
    List<Role> selectRoleByUserId(int id);
}
