<%@ page import="com.bdqn.pojo.Users" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/7
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>首页</title>
</head>
<style>
  .right{
    width: 80%;
    height: 80%;
  }


  .main{
    overflow: hidden;
    height: 500px;
  }
  .left{
    float:left;
  }

  .right{
    float: right;
  }
</style>

<body>
<h1>商务会员管理系统</h1>
<div>
  <div class="header">
    <table>
      <tr>
        <td>用户名${sessionScope.users.name}</td>
        <td>用户类型</td>
        <td><a href="">退出</a></td>
      </tr>
    </table>
  </div>
  <div class="main">
    <div class="left">
      <a href="/UsersPage/updatePwd.jsp" target="test">修改密码</a><br>
      <a href="/UsersServlet?method=selAll" target="test">查看所有会员</a>
    </div>
    <div class="right">
      <iframe src="/UsersPage/moren.jsp" width="100%" height="100%" name="test"></iframe>
    </div>
  </div>
</div>

</body>
</html>
