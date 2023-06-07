<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 06/06/2023
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>details patient</title>
    <jsp:include page="../includes/head.jsp" />
</head>
<body>
        <jsp:include page="../includes/header.jsp" />

      <div class="patientInfo">nom : ${patient.getNom()} prenom : ${patient.getPrenom()}</div>

      <h3>Consultation</h3>
      <c:forEach items="${patient.getConsultations()}" var="consultation">
        <div class="patientDiv">
            <b>Date : </b>${consultation.getDate()}
            <a href="consultation?id_consult=${consultation.getId_Consultation()}" class="link">Details</a>
        </div>
      </c:forEach>
      <a href="consultation" class="linkButton">Ajout d'une consultation</a>

</body>
</html>
