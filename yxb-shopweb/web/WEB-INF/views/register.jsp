<%--
  Created by IntelliJ IDEA.
  User: BING
  Date: 2017/4/24
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <form:form modelAttribute="com.yxb.shop.viewmodel.VmRegister" method="post">
        username:<form:input path="username" /><br/>
        password:<form:input path="password" /><br/>
        <input type="submit" value="submit" />
    </form:form>
</body>
</html>
