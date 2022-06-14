<%--
  Created by IntelliJ IDEA.
  User: liushuai
  Date: 2021/12/4
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>login</title>
    <link rel="stylesheet" href="css/login.css" />

    <style>
        .liu{
            float: left;
            margin-top: 420px;
            margin-left: 600px;
            color: red;
        }
    </style>

</head>
<body>
<div class="top">
    <form action="${pageContext.request.contextPath}/login" method="get">
        <input type="text" name="uname" class="logion" />
        <label class="text">账号</label>
        <label class="underline"></label>
        <input type="password" name="pwd" class="logion1" />

        <label class="text1">密码</label>
        <label class="underline1"></label>
        <br />
        <input type="submit" value="登录" class="DL" />
    </form>
    <form action="registered/registered.html" method="post">
        <input type="submit" value="注册" class="DL" />
    </form>
</div>

<!--  自己写的代码-->
<div class="liu">
    <span><c:if test="${!empty requestScope.Tipe}">${requestScope.Tipe}</c:if></span>
</div>

</body>
</html>

