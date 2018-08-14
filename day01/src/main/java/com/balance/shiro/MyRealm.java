package com.balance.shiro;

import com.balance.domain.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by liukai on 2018/8/14.
 */
public class MyRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg) throws AuthenticationException {
//        1.获取用户输入的账户信息
        UsernamePasswordToken token=(UsernamePasswordToken)arg;
        String username="jack";
        String password="123";
        if(!username.equals(token.getUsername())){
//            1用户不存在
            return null;
        }
        User dbUser=new User();
        dbUser.setUsername("name");
        dbUser.setPassword(password);
//        返回密码
        return new SimpleAuthenticationInfo(dbUser,dbUser.getPassword(),"");
    }
}
