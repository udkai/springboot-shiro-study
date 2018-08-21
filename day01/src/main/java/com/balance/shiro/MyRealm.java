package com.balance.shiro;

import com.balance.domain.User;
import com.balance.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import java.util.List;

/**
 * Created by liukai on 2018/8/14.
 */
public class MyRealm extends AuthorizingRealm {
    private UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        添加授权
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
//        info.addStringPermission("product:add");
        Subject subject= SecurityUtils.getSubject();
        User dbUser=(User)subject.getPreviousPrincipals();
        List<String> perms=userService.findPermissionByUserId(dbUser.getId());
        if(perms!=null) {
            for (String perm : perms) {
                if (perm == null) {
                    info.addStringPermission(perm);
                }
            }
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg) throws AuthenticationException {
//        1.获取用户输入的账户信息
        UsernamePasswordToken token=(UsernamePasswordToken)arg;
//        String username="jack";
//        String password="123";
        User dbUser=userService.findByUsername(token.getUsername());
        if(dbUser!=null){
//            1用户不存在
            return null;
        }
//        User dbUser=new User();
//        dbUser.setUsername(username);
//        dbUser.setPassword(password);
//        返回密码
        return new SimpleAuthenticationInfo(dbUser,dbUser.getPassword(),"");
    }
}
