<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 06/06/2023
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajout d'une consultation</title>
    <jsp:include page="../includes/head.jsp" />
</head>
<body>
        <jsp:include page="../includes/header.jsp" />

        <h1>Ajout d'une consultation</h1>
      <form action="#" method="post">
        <input type="date" name="date" id="date" required class="input">
          <button class="buttonSendDate"> send</button>
      </form>
</body>
</html>
