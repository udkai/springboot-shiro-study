package com.balance.controller;

import com.balance.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liukai on 2018/8/14.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request, Model model){
//        使用shiro进行登录
        Subject subject= SecurityUtils.getSubject();
        AuthenticationToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try {
            subject.login(token);
            User user1=(User) subject.getPrincipal();
            request.getSession().setAttribute("username",user1.getUsername());
            return "redirect:/index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "login";
        }

    }
}
