<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/11/29
  Time: 下午11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注销</title>
</head>
<body>
<div style="color: #2f4497;font-size: 20px;text-align: center">注销测试</div><br>
<div style="text-align: center">

    <form action="logout" method="post" id="logoutForm">
        姓名：<input type="text" name="uname2" id="uname2" value="${messageModel.object.userName}" style="border-radius: 5px;"><br>
        密码：<input type="password" name="upwd2" id="upwd2" value="${messageModel.object.userPwd}" style="border-radius: 5px;"><br>
        <span id="msg" style="font-size: 12px;color: red">${messageModel.msg}</span><br>
        <button type="button" id="logoutBth">注销</button>

    </form>

</div>
</body>
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

    $("#logoutBth").click(function (){
        //获取用户姓名和和密码的值
        var uname2 = $("#uname2").val();
        var upwd2 = $("#upwd2").val();
        //如果姓名为空
        if(isEmpty(uname2)){
            //如果姓名为空，提示用户(span标签赋值)，并且return  html()
            $("#msg").html("用户姓名不能为空");
            return;
        }
        //判断密码是否为空
        if(isEmpty(upwd2)){
            //如果密码为空，提示用户(span标签赋值)，并且return   html()
            $("#msg").html("用户密码不能为空");
            return;
        }
        //如果都不为空，则手动提交表单
        $("#logoutForm").submit();
    });

    function isEmpty(str) {

        if (str==null || str.trim() == ""){
            return true;
        }
        return false;
    }
</script>
</html>
