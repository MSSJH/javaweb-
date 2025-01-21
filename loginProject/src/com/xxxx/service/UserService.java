package com.xxxx.service;

import com.xxxx.entity.User;
import com.xxxx.entity.vo.MessageModel;
import com.xxxx.mapper.UserMapper;
import com.xxxx.util.GetSqlSession;
import com.xxxx.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * 业务逻辑
 * **/

public class UserService {
    /** 1.参数的非空判断
        如果参数为空
          将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
     2.调用dao层的查询方法，通过用户名查询用户对象
     3.判断用户对象是否为空
         如果为空，将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
     4.判断数据库中查询到的用户密码与前台传递过来的密码作比较
          如果不相等，将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
     5.登录成功，成功状态、提示信息、用户对象设置消息模型对象，并return
     **/
    public MessageModel userlogin(String uname, String upwd) {
        MessageModel messageModel = new MessageModel();

        User u=new User();
        u.setUserName(uname);
        u.setUserPwd(upwd);
        messageModel.setObject(u);

        //1.参数的非空判断
        if (StringUtil.isEmpty(uname) || StringUtil.isEmpty(upwd)){
            //将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
            messageModel.setCode(0);
            messageModel.setMsg("用户姓名与密码不能为空");
            //回显数据
            return messageModel;
        }
        //2.调用dao层的查询方法，通过用户名查询用户对象
        SqlSession session= GetSqlSession.createSqlSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        User user= userMapper.queryUserByName(uname);

        //3.判断用户对象是否为空
        if(user==null){
            //将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
            messageModel.setCode(0);
            messageModel.setMsg("用户名不存在！");
            //回显数据
            return messageModel;
        }
        //4.判断数据库中查询到的用户密码与前台传递过来的密码作比较
        if(!upwd.equals(user.getUserPwd())){
            //如果不相等，将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
            messageModel.setCode(0);
            messageModel.setMsg("用户密码不正确");
            return messageModel;
        }
        //登录成功，将用户对象设置消息模型中
        messageModel.setObject(user);

        return messageModel;
    }


        public MessageModel userregister(String uname1, String upwd1, String upwd2) {
            MessageModel messageModel = new MessageModel();
            User u = new User();
            u.setUserName(uname1);

            // 修复密码设置逻辑，先验证两次密码是否一致，一致再设置密码
            if (!upwd1.equals(upwd2)) {
                messageModel.setCode(0);
                messageModel.setMsg("两次密码不同");
                return messageModel;
            }
            u.setUserPwd(upwd1);

            // 参数为空验证
            if (StringUtil.isEmpty(uname1) || StringUtil.isEmpty(upwd1) || StringUtil.isEmpty(upwd2)) {
                messageModel.setCode(0);
                messageModel.setMsg("用户姓名与密码不能为空");
                return messageModel;
            }

            SqlSession session = GetSqlSession.createSqlSession();
            UserMapper userMapper = session.getMapper(UserMapper.class);

            // 用户名重复性检查
            User user = userMapper.queryUserByName(uname1);
            if (user!= null) {
                messageModel.setCode(0);
                messageModel.setMsg("用户名存在,重新起名！");
                return messageModel;
            }

            try {
                // 将新用户信息插入数据库，调用UserMapper的insert方法
                userMapper.insert(u);
                session.commit(); // 提交事务，确保插入操作成功

                messageModel.setCode(1); // 假设1代表操作成功
                messageModel.setMsg("注册成功");
                messageModel.setObject(u); // 设置包含新插入用户信息的u对象到messageModel中
            } catch (Exception e) {
                session.rollback(); // 出现异常则回滚事务
                messageModel.setCode(0);
                messageModel.setMsg("注册失败，数据库操作出现异常");
                e.printStackTrace();
            } finally {
                session.close(); // 关闭SqlSession，释放资源
            }

            return messageModel;

    }
    // 注销用户的业务方法
    public MessageModel logoutUser(String uname, String upwd) {
        MessageModel messageModel = new MessageModel();
        User u = new User();
        u.setUserName(uname);
        u.setUserPwd(upwd);

        // 参数为空验证
        if (StringUtil.isEmpty(uname) || StringUtil.isEmpty(upwd) ) {
            messageModel.setCode(0);
            messageModel.setMsg("用户姓名与密码不能为空");
            return messageModel;
        }

        SqlSession session = GetSqlSession.createSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        // 用户名重复性检查
        User user = userMapper.queryUserByName(uname);

        if (user == null) {
            messageModel.setCode(0);
            messageModel.setMsg("无此用户！");
            return messageModel;
        }
        
        if(!upwd.equals(user.getUserPwd())){
            //如果不相等，将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
            messageModel.setCode(0);
            messageModel.setMsg("用户密码不正确");
            return messageModel;
        }

        try {
            // 将新用户信息插入数据库，调用UserMapper的insert方法
            userMapper.delete(u);
            session.commit(); // 提交事务，确保插入操作成功

            messageModel.setCode(1); // 假设1代表操作成功
            messageModel.setMsg("注销成功");
            messageModel.setObject(u); // 设置包含新插入用户信息的u对象到messageModel中
        } catch (Exception e) {
            session.rollback(); // 出现异常则回滚事务
            messageModel.setCode(0);
            messageModel.setMsg("注销失败，数据库操作出现异常");
            e.printStackTrace();
        } finally {
            session.close(); // 关闭SqlSession，释放资源
        }

        return messageModel;

    }

    //修改密码
    public MessageModel updatePasswold(String newpwd, String name,String oldpwd) {

        MessageModel messageModel = new MessageModel();
        User u = new User();
        u.setUserName(name);
        u.setUserPwd(oldpwd);
        if (StringUtil.isEmpty(name) || StringUtil.isEmpty(oldpwd)|| StringUtil.isEmpty(newpwd)) {
            messageModel.setCode(0);
            messageModel.setMsg("用户姓名与密码不能为空");
            return messageModel;
        }
        SqlSession session = GetSqlSession.createSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.queryUserByName(name);
        if (user == null) {
            messageModel.setCode(0);
            messageModel.setMsg("用户不存在，请注册");
            return messageModel;
        }
        if(!oldpwd.equals(user.getUserPwd())){

            messageModel.setCode(0);
            messageModel.setMsg("用户密码不正确");
            return messageModel;
        }
        try {
            // 将新用户信息插入数据库，调用UserMapper的insert方法
            userMapper.updatePassword(newpwd,name,oldpwd);
            session.commit(); // 提交事务，确保插入操作成功

            messageModel.setCode(1); // 假设1代表操作成功
            messageModel.setMsg("修改成功");
            messageModel.setObject(u); // 设置包含新插入用户信息的u对象到messageModel中
        } catch (Exception e) {
            session.rollback(); // 出现异常则回滚事务
            messageModel.setCode(0);
            messageModel.setMsg("注册失败，数据库操作出现异常");
            e.printStackTrace();
        } finally {
            session.close(); // 关闭SqlSession，释放资源
        }

        return messageModel;
    }


}
