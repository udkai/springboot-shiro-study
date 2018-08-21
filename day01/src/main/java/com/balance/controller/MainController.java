package com.balance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liukai on 2018/8/21.
 */
@Controller
public class MainController {
    @RequestMapping("/toLogin")
    public String login(){
        return "login";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/unAuth")
    public String unAuth(){
        return "unauth";
    }
}
