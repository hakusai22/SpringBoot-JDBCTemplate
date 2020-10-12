package com.xizi.springbootjdbctemplate.service;


import com.xizi.springbootjdbctemplate.pojo.User;
import com.xizi.springbootjdbctemplate.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    //注入UserRepository
    @Resource
    private UserRepository userRepository;

    public Integer insertUser(){
        return userRepository.insertUser();
    }

    public User selectByUsername(String username){
        return userRepository.selectByUsername(username);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findUserById(Integer id){
        return userRepository.findUserById(id);
    }

    public void update(User user){
        userRepository.update(user);
    }

    public void delete(Integer id){
        userRepository.delete(id);
    }
}

