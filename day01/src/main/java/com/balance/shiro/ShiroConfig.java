package com.balance.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liukai on 2018/8/13.
 */
@Configuration
public class ShiroConfig {
    /**
     * 1.创建ShiroFilterFactory
     */
    @Bean
    public ShiroFilterFactoryBean ShiroFilterFactoryBean(DefaultWebSecurityManager manager){
        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
//        关联SecturyManager
        bean.setSecurityManager(manager);
        Map<String, String> filterMap=new HashMap<>();

//        认证过滤器
//        filterMap.put("/**","authc");
//        filterMap.put("/index","anon");
        filterMap.put("/product/toAdd","anon");
//        放行登录页面
        filterMap.put("/user/login","anon");
//        授权过滤器
        filterMap.put("/product/toAdd","perms[product:add]");
        filterMap.put("/product/toUpdate","perms[product:update]");
        filterMap.put("/**","authc");

//        添加shiro过滤器
        bean.setFilterChainDefinitionMap(filterMap);
        bean.setLoginUrl("/toLogin");
//       添加未授权提示页面
        bean.setUnauthorizedUrl("/unAuth");
        return bean;
    }
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(MyRealm myRealm){
        DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
        manager.setRealm(myRealm);
        return manager;
    }
    @Bean
    public MyRealm myRealm(){
        MyRealm myRealm=new MyRealm();
        return myRealm;
    }
}
