<%@ page import="java.util.List" %>
<%@ page import="entity.library" %><%--
  Created by IntelliJ IDEA.
  User: liushuai
  Date: 2021/12/1
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <tr><td>类别id</td><td>类别名称</td></tr>
    <c:forEach items="${requestScope.list}" var="leibie" varStatus="s" >
    <tr><td>${leibie.leibie_id}</td><td>${leibie.name}</td></tr>
    </c:forEach>
</table>

</body>
</html>
