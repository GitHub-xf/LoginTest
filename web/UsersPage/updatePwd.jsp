<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/10
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<script type="text/javascript">
    <c:if test="${!empty sessionScope.meg}">
    alert('${sessionScope.meg}');
    </c:if>
</script>
<head>
    <title>Title</title>
</head>
<body>
<h1>修改密码</h1>
<form action="/UsersServlet?method=updatePWD" method="post" onsubmit="return check()">
    <label> 原始密码 </label>
    <input type="text" name="oldPwd" value="${sessionScope.users.password}" class="login_input" /><br>
    <label> 新密码 </label>
    <input type="text" name="newPwd" value="" class="login_input" /><br>
    <label> 确认密码 </label>
    <input type="text" name="oldPwds" value="" class="login_input" /><br>
    <input type="submit" class="login_sub" value="修改" />
    <label id="error"> </label>

</form>
</body>
</html>
