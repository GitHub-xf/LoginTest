<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/7
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript">
    <c:if test="${!empty sessionScope.meg}">
        alert('${sessionScope.meg}');
    </c:if>
</script>
<h1>商务会员管理系统</h1>
<form action="/UsersServlet?method=Login" method="post">
    <label> 登录名 </label>
    <input type="text" name="uname" value="" class="login_input" /><br>
    <label> 密&#160;&#160;码 </label>
    <input type="password" name="upwd" value="" class="login_input" /><br>
    <input type="submit" class="login_sub" value="登录" />
    <label id="error"> </label>

</form>
</body>
</html>
