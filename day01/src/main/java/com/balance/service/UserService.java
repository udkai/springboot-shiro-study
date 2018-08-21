package com.balance.service;

import com.balance.dao.UserMapper;
import com.balance.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liukai on 2018/8/21.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public List<String> findPermissionByUserId(int id){
        return userMapper.findPermissionByUserId(id);
    }
    public User findByUsername(String username){
        return userMapper.findByName(username);
    }
}
