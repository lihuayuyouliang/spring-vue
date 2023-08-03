package com.example.demo.controller;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAll(){
        return userMapper.findall();
    }

    @GetMapping("/search/{name}")
    public User search(@PathVariable String name){
        return userMapper.searchByName(name);
    }

    @PostMapping("/add")
    public Integer save(@RequestBody User user){
        // 新增或更新
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id){
        return userMapper.deleteById(id);
    }

    @GetMapping("/page")
    public Map<String,Object> findPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        pageNum=(pageNum-1)*pageSize;
        List<User>data=userMapper.selectPage(pageNum,pageSize);
        Integer total=userMapper.selectTotal();
        Map<String, Object>res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}
