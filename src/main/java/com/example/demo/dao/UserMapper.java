package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from  user")
    List<User> findall();

    @Insert("INSERT INTO user(name,age,sex,address,phone) VALUES (#{name}, #{age}, #{sex}, #{address}, #{phone})")
    int insert(User user);

    // 写了动态sql，那么这里的注解要删掉
    // @Update("update user set name=#{name},age=#{age},sex=#{sex},address=#{address},phone=#{phone} where id=#{id}")
    int update(User user);

    @Delete("delete from user where id = #{id}")
    Integer deleteById(@Param("id") Integer id);

    @Select("select * from user limit #{pageNum}, #{pageSize}")
    List<User> selectPage(Integer pageNum, Integer pageSize);

    @Select("select count(*) from user")
    Integer selectTotal();

    @Select("select * from user where name=#{name}")
    User searchByName(String name);
}
