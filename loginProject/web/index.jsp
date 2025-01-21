
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/11/20
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>

</head>
<body>

<style type="text/css">
    body{
       /* background-image: url(./icon/img_1.png);*/

        background-size:cover;
    }
</style>

<!--<img src="./icon/图书馆.png" alt="" style="width: 40px; position: relative; top: 10px; left: 20px">-->
     <h2 > 欢迎${user.userName}登录成功！ </h2>
    <button onclick="window.location.href='http://localhost:8080/lp/LoginOut'">退出登录</button>
    <button onclick="window.location.href='http://localhost:8080/lp/logout.jsp '">注销账号</button>
    <button onclick="window.location.href='http://localhost:8080/lp/update.jsp '">修改密码</button>

</body>


</html>


