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
    <jsp:include page="../includes/head.jsp" />
</head>
<body>
        <jsp:include page="../includes/header.jsp" />

        <h1>Liste des patient</h1>

        <c:forEach items="${patients}" var="patient">
            <div class="patientDiv"><div>Nom : ${patient.getNom()}</div> <div>Prenom : ${patient.getPrenom()}</div>  <a href="patient?id=${patient.getId_patient()}" class="link">Details</a></div>
        </c:forEach>


        <form action="#" method="get">
            <label for="name">nom du patient :</label>
            <input type="text" name="name" id="name">
            <button>rechercher</button>
        </form>

        <c:if test="${isLogged}">
            <form action="#" method="post" class="formAddPatient">
                <div>Ajout d'un Patient :</div>
                <div class="divForm">
                    <label for="nameEntry" >Nom :</label>
                    <input type="text" name="nameEntry" id="nameEntry">
                </div>
                <div class="divForm">
                    <label for="firstname">Prenom :</label>
                    <input type="text" name="firstname" id="firstname">
                </div>
                <button class="btnForm">Ajouter</button>
            </form>
        </c:if>

</body>
</html>
