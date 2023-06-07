<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 07/06/2023
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../includes/head.jsp" />
</head>
<body>
    <jsp:include page="../includes/header.jsp" />
    <form action="login?type=${type}" method="post" class="formLogin">
        <div>${type} :</div>
        <div class="divLogin">
            <label >Username :</label>
            <input type="text" name="username" id="username" required class="">
        </div>

        <div class="divLogin">
            <label >Password :</label>
            <input type="password" name="password" id="password" required>
        </div>

        <button class="btnFormLogin">${type}</button>
    </form>
</body>
</html>
