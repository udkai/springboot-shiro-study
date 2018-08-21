package com.balance.test;

import com.balance.Day01Application;
import com.balance.dao.UserMapper;
import com.balance.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by liukai on 2018/8/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Day01Application.class)
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;
    @Test
    public void testFindByName(){
        System.out.println(userMapper.toString());
        User user =userMapper.findByName("jack");
        System.out.println(user);
    }
}
