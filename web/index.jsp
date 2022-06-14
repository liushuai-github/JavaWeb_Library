<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/1
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    HttpSession session1 = request.getSession();
    session1.setAttribute("uid","1");
  %>

  <a href="${pageContext.request.contextPath}/user_library_byid"> 显示所有图书信息</a><br>
  <a href="${pageContext.request.contextPath}/user_leibie_all"> 显示所有图书类别信息</a>
  </body>
</html>
