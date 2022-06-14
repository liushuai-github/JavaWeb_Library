<%--
  Created by IntelliJ IDEA.
  User: liushuai
  Date: 2021/12/2
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Book return system</title>

    <!-- Bootstrap -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
<%--    <link rel="stylesheet" href="./css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">--%>
    <!--    这个是必须的连接，可以改成本地导包更快-->

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>-->
    <!--    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>-->
    <!--    这两条是针对ie浏览器的，不需要-->
    <!--[endif]-->

    <link href="../css/book.css">



    <title>Title</title>
    <style>
        body{
            /*border-color: black;*/
            /*background-color: #fbc2eb;*/
            /*background-image: linear-gradient(to top, #fbc2eb 0%, #a6c1ee 100%);*/

        }

        td{
            text-align: center;
            /*border: 1px red solid;*/
        }

        #inputHelpBlock{
            width: 400px;
            display: inline-block;
        }

        #div1{
            /*border: 1px red solid;*/
        }

        #div2{
            /*border: 1px red solid;*/
            width: 100%;
            position: relative;
            margin-top: -20px;
            border-top: #d4d4d4 1px solid;
        }

        span{
            position: relative;
            float: right;
            top: 30px;
            margin-right: 1000px;
            font-size: 30px;
        }

        ul{
            display: inline-block;
            /*border: 1px black solid;*/
        }

        body{
            background-image: linear-gradient(to top, #cfd9df 0%, #e2ebf0 100%);
        }

        html,body{
            height: 100%;
        }

    </style>

    <%
        String mess=(String) request.getSession().getAttribute("msg");
        request.getSession().setAttribute("msg","");
        if("".equals(mess)  || mess==null){

        }
        else{%>
    <script type="text/javascript">
        alert("<%=mess%>");
    </script>
    <%
        }
    %>

</head>
<body>
<div id="div1">
<table class="table table-hover">
    <form action="${pageContext.request.contextPath}/yijieshuji_byid" method="post">
    <tr>
        <td>欢迎您:<%= request.getSession().getAttribute("uname")%></td>
        <td colspan="">图书归还系统</td>
        <%--            跳转登录界面，并清除session，如果不做filter可不用跳转servlet做清除--%>
        <td><a href="${pageContext.request.contextPath}/logout" class="btn btn-default">退出登录</a></td>
        <%--            修该session中的uname--%>
        <td><a href="${pageContext.request.contextPath}/modify" class="btn btn-default">修改用户信息</a></td>
    </tr>

    <tr>

        <td>所借图书如下</td>
        <td colspan="">
            <input type="text" id="inputHelpBlock" class="form-control" aria-describedby="helpBlock" name="name" value="${requestScope.name}">
            <input class="btn btn-default" type="submit" value="提交">
        </td>
        <td></td>
        <td></td>
<%--        <td><a target="_blank" href="" class="btn btn-default" >图书类别查看</a></td>--%>
<%--        <td><a target="_blank" href="" class="btn btn-default" >已借书籍</a></td>--%>
    </tr>
    <tr><td>图书序号</td><td>图书名称</td><td></td><td></td></tr>

<%--        通过page的list集合遍历--%>
        <c:forEach items="${requestScope.page.list}" var="library" varStatus="s" >

            <tr>
            <td>${s.count}</td>
            <td>${library.name}</td>
<%--            <td><a href="${pageContext.request.contextPath}/jieshu?library_id=${library.library_id}" class="btn btn-default" >借出</a></td>--%>
            <td></td>
            <td><a href="${pageContext.request.contextPath}/yijieshuju_huanshu?library_id=${library.library_id}&name=${requestScope.name}" class="btn btn-default" >还书</a></td>
            </tr>

        </c:forEach>

    </form>



</table>
</div>

<div id="div2">
<u class="pagination">

    <li>
        <a href="${pageContext.request.contextPath}/yijieshuji_byid?currentPage=${requestScope.page.currentPage-1}&rows=7">&laquo;</a>
    </li>

<%--    获取总页数，并从1开始遍历，i代表第几页--%>
    <c:forEach begin="1" end="${requestScope.page.totalCount}" var="i">
        <c:if test="${requestScope.page.currentPage == i}">
        <li class="active" >
            <a href="${pageContext.request.contextPath}/yijieshuji_byid?currentPage=${i}&rows=7&name=${requestScope.name}">${i}</a>
        </li>
        </c:if>

        <c:if test="${requestScope.page.currentPage != i}">
            <li>
                <a  href="${pageContext.request.contextPath}/yijieshuji_byid?currentPage=${i}&rows=7&name=${requestScope.name}">${i}</a>
            </li>
        </c:if>
    </c:forEach>

    <li>
        <a href="${pageContext.request.contextPath}/yijieshuji_byid?currentPage=${requestScope.page.currentPage+1}&rows=7&name=${requestScope.name}">&raquo;</a>
    </li>

</u>

    <span>总共${requestScope.page.totalCount}页,一共${requestScope.page.count}条数据</span>
</div>



<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
<%--<script src="./js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>--%>
<!--同样改成本地的导入-->

</body>
</html>
