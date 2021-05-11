package com.ch.ch6_1.repository;

import com.ch.ch6_1.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * 这里不需要使用@Repository注解数据访问层，
 * 因为Spring Boot自动配置了JpaRepository
 */
public interface UserRepository extends JpaRepository<MyUser, Integer>{
	//自定义的查询方法需要遵循命名规则
	public MyUser findByUname(String uname);
	public List<MyUser> findByUnameLike(String uname);
	public List<MyUser> deleteByUname(String uname);

}
