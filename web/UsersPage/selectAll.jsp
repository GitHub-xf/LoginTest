<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/7
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <table align="center">
        <tr>
            <td colspan="5" align="center">
                <form action="/UsersServlet?method=selAll" method="post">
                    用户名<input type="text" name="names" value=""> <input type="submit" value="查询">
                </form>
            </td>
        </tr>
        <tr>
            <td>序号</td>
            <td>用户名</td>
            <td>用户类别</td>
            <td>用户状态</td>
            <td>最后修改时间</td>
        </tr>

        <c:choose>
            <c:when test="${requestScope.sss==null}">
                <c:forEach items="${requestScope.pages.list}" var="list">
                    <tr>
                        <td>${list.id}</td>
                        <td>${list.name}</td>
                        <c:choose>
                            <c:when test="${list.type_id==1}">
                                <td><b>白银会员</b></td>
                            </c:when>
                            <c:when test="${list.type_id==2}">
                                <td><b>黄金会员</b></td>
                            </c:when>
                        </c:choose>
                        <c:choose>
                            <c:when test="${list.status==1}">
                                <td><b>正常</b></td>
                            </c:when>
                            <c:when test="${list.status==0}">
                                <td><b>冻结</b></td>
                            </c:when>
                        </c:choose>
                        <td>${list.time}</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:when test="${requestScope.sss!=null}">
        <tr>
            <td colspan="5" align="center"><b>${requestScope.sss}</b></td></tr>
            </c:when>
        </c:choose>


    </table>
    <p align="center"> 当前页数:[${requestScope.pages.currentPage}/总共${requestScope.pages.totalPages}页]&nbsp;
        <a href="/UsersServlet?method=selAll&currentPage=1">首页</a>
        <c:if test="${requestScope.pages.currentPage>1}">
        <a href="/UsersServlet?method=selAll&method=selAll&currentPage=${requestScope.pages.currentPage-1}">上一页</a>&nbsp;
        </c:if>
        <c:if test="${requestScope.pages.currentPage<requestScope.pages.totalPages}">
        <a href="/UsersServlet?method=selAll&currentPage=${requestScope.pages.currentPage+1}">下一页</a>
        </c:if>
        <a href="/UsersServlet?method=selAll&currentPage=${requestScope.pages.totalPages}">末页</a>
    </p>
</div>
</body>
</html>
