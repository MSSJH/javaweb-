<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/11/20
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>用户登录</title>

</head>

<body>
<div style="height: 100vh; overflow: hidden; position: relative">

<div style="width: 500px; height: 400px; background-color: white; border-radius: 10px;
        margin: 150px auto; padding:50px">
    <div style="margin: 30px; text-align: center; font-size: 30px; font-weight: bold; color: dodgerblue">登 录</div>
<!--<div style="color: #2f4497;font-size: 20px;text-align: center">登录测试</div><br>-->
<div style="text-align: center">

    <form action="login" method="post" id="loginForm">
        姓名：<input type="text" name="uname" id="uname" size="medium" value="${messageModel.object.userName}" style="border-radius: 5px;"><br>
        密码：<input type="password" name="upwd" id="upwd" size="medium" value="${messageModel.object.userPwd}" style="border-radius: 5px;"><br>
        <span id="msg" style="font-size: 12px;color: red">${messageModel.msg}</span><br>
        <button type="button" id="loginBth"  size="medium" >登录</button>
        <div style="text-align: center;">
            还没有账号？请 <a href="http://localhost:8080/lp/register.jsp">注册</a>
        </div>
    </form>

</div>
    </div>
</div>
</body>
<%--引入jquery-3.4.1.js文件--%>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
    /**
     * 登录表单验证
     1.给登录按钮绑定点击事件（通过id选择器绑定）
     2.获取用户姓名和密码的值
     3.判断姓名是否为空
     如果姓名为空，提示用户(span标签赋值)，并且return
     4.判断密码是否为空
     如果密码为空，提示用户(span标签赋值)，并且return
     5.如果都不为空，则手动提交表单
     **/

    $("#loginBth").click(function (){
        //获取用户姓名和和密码的值
        var uname = $("#uname").val();
        var upwd = $("#upwd").val();
        //如果姓名为空
       if(isEmpty(uname)){
           //如果姓名为空，提示用户(span标签赋值)，并且return  html()
           $("#msg").html("用户姓名不能为空");
           return;
       }
        //判断密码是否为空
        if(isEmpty(upwd)){
            //如果密码为空，提示用户(span标签赋值)，并且return   html()
            $("#msg").html("用户密码不能为空");
            return;
        }
        //如果都不为空，则手动提交表单
        $("#loginForm").submit();
    });

    /*
    *判断是字符串否为空
    *       如果为空 返还ture
    *       如果不为空 返还false
    *  */
    function isEmpty(str) {

        if (str==null || str.trim() == ""){
            return true;
        }
        return false;
    }
</script>
</html>
