<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 06/06/2023
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patients</title>
</head>
<body>
        <h1>Liste des patient</h1>
        <div>
            <c:forEach items="${patients}" var="patient">
            <div>Nom : ${patient.getNom()} ,Prenom : ${patient.getPrenom()} <a href="patient?id=${patient.getId_patient()}">Details</a></div>
            </c:forEach>
        </div>

        <form action="#" method="get">
            <label>nom du patient :</label>
            <input type="text" name="name" id="name">
            <button>rechercher</button>
        </form>
</body>
</html>
