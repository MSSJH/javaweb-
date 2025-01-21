package com.xxxx.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;


public class GetSqlSession {
    /*
    * 获取SqlSession对象
    * */

    public static SqlSession createSqlSession() {

        SqlSessionFactory sqlSessionFactory = null;
        InputStream input = null;
        SqlSession Session = null;

        try{
            //获得mybatis的环境配置文件
            String resource = "mybatis-config.xml";
            //以引流的方式获取 resource(mybatis的环境配置文件)
            input = Resources.getResourceAsStream(resource);
            //创建会话工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
            //通过工厂获得SqlSession
            Session = sqlSessionFactory.openSession();
            return Session;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(createSqlSession());
    }
}
