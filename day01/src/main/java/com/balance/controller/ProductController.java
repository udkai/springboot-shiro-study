package com.balance.controller;

import com.balance.dao.UserMapper;
import com.balance.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liukai on 2018/8/13.
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/toList")
    public String toList(){
        User user=userMapper.findByName("jack");
        System.out.println(user);
        return "product/list";
    }
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "product/add";
    }
    @RequestMapping("/toUpdate")
    public String toUpdate(){
        return "product/update";
    }
}
