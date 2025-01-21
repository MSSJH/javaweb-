package com.xxxx.test;

import com.xxxx.entity.User;
import com.xxxx.entity.vo.MessageModel;
import com.xxxx.mapper.UserMapper;
import com.xxxx.service.UserService;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        //获取SqlSession对象
         SqlSession session = GetSqlSession.createSqlSession();
        //得到对应的mapper
        UserMapper userMapper = session.getMapper(UserMapper.class);
        //调用方法，返还用户对象
        User user = userMapper.queryUserByName("mjh");
        System.out.println(user);
        //插入
        User u=new User();
        u.setUserName("admin");
        u.setUserPwd("admin");
        userMapper.insert(u);
        System.out.println(u);
        //删除
        userMapper.delete(u);
        User user1 = userMapper.queryUserByName("admin");
        System.out.println(user1);
        //修改

        UserService userService = new UserService();
        MessageModel messageModel1 = userService.userlogin("mjh","123");
        System.out.println(messageModel1.getCode());

       // MessageModel messageModel2=userService.updatePasswold("456","mjh","123");
        userMapper.updatePassword("123","mjh","456");
        session.commit();
        MessageModel messageModel2 = userService.userlogin("mjh","123");
        System.out.println(messageModel2.getCode());

    }
}
