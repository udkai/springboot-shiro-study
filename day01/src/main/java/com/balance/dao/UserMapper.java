package com.balance.dao;

import com.balance.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by liukai on 2018/8/21.
 */
@Mapper
public interface UserMapper {
    @Select("select * from t_user")
   public   User findByName(String username);
    @Select("select ")
    public List<String> findPermissionByUserId(int id);
}
