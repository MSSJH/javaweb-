<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/11/27
  Time: 下午5:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<div style="height: 100vh; overflow: hidden; position: relative">
    <div style="width: 500px; height: 400px; background-color: white; border-radius: 10px;
        margin: 150px auto; padding:50px">
        <div style="margin: 30px; text-align: center; font-size: 30px; font-weight: bold; color: dodgerblue">注册</div>
<!--<div style="color: #2f4497;font-size: 20px;text-align: center">注册测试</div><br>-->
<div style="text-align: center">

    <form action="register" method="post" id="registerForm">
        姓名：<input type="text" name="uname1" id="uname1" size="medium" value="${messageModel.object.userName1}" style="border-radius: 5px;"><br>
        密码：<input type="password" name="upwd1" id="upwd1" size="medium" value="${messageModel.object.userPwd1}" style="border-radius: 5px;"><br>
        确定密码：<input type="password" name="upwd2" id="upwd2" size="medium" value="${messageModel.object.userPwd2}" style="border-radius: 5px;"><br>
        <span id="msg" style="font-size: 12px;color: red">${messageModel.msg}</span><br>
        <button type="button" id="registerBth" size="medium">注册</button>
        <div style="text-align: center;">
            返回到登录页面 <a href="http://localhost:8080/lp/login.jsp">登录</a>
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

    $("#registerBth").click(function (){
        //获取用户姓名和和密码的值
        var uname1 = $("#uname1").val();
        var upwd1 = $("#upwd1").val();
        var upwd2 = $("#upwd2").val();

        //如果姓名为空
        if(isEmpty(uname1)){
            //如果姓名为空，提示用户(span标签赋值)，并且return  html()
            $("#msg").html("用户姓名不能为空");
            return;
        }
        //判断密码是否为空
        if(isEmpty(upwd1)){
            //如果密码为空，提示用户(span标签赋值)，并且return   html()
            $("#msg").html("用户密码不能为空");
            return;
        }
        if(isEmpty(upwd2)){
            //如果密码为空，提示用户(span标签赋值)，并且return   html()
            $("#msg").html("用户密码不能为空");
            return;
        }
        if(upwd1!==upwd2){
            //如果密码为空，提示用户(span标签赋值)，并且return   html()
            $("#msg").html("两次密码不同");
            return;
        }
        //如果都不为空，则手动提交表单
        $("#registerForm").submit();
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
