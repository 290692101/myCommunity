package com.ch.chMbTest.repository;

import com.ch.chMbTest.entity.Privilege;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PrivilegeMapper {
    Privilege selectPrivilegeById(int id);
    List<Privilege> selectPrivilegeByRoleId(int id);
}
