package com.xxxx.mapper;

import com.sun.org.apache.xpath.internal.objects.XNull;
import com.xxxx.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/*用户接口*/
public interface UserMapper {
    public User queryUserByName (String userName);

    void updatePassword(@Param("newpwd") String newpwd, @Param("userName") String userName, @Param("oldpwd") String oldpwd);

    void insert(User u);

    void delete(User u);
}
