<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 07/06/2023
  Time: 08:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../includes/head.jsp" />
</head>
<body>
    <nav>
        <div>
            <a class="linkHeader" href="/Gestion_Consultation_war_exploded">Home</a>
        </div>
        <c:if test="${isLogged == false || isLogged == null}">
            <div>
                <a class="linkHeader"  href="login?type=register"> Register</a>
                <a class="linkHeader"  href="login?type=login"> Log In</a>
            </div>
        </c:if>
        <c:if test="${isLogged == true}">
            <div>
                <a class="linkHeader"  href="login?quit=true"> log Out</a>
            </div>
        </c:if>

    </nav>


</body>
</html>
