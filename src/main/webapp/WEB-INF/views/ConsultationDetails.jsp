<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 06/06/2023
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details de la consultation</title>
    <jsp:include page="../includes/head.jsp" />
</head>
<body>
        <jsp:include page="../includes/header.jsp" />

      <h1>consultation du ${consultation.getDate()}</h1>
      <h3 class="titleConsultationDetails">Prescription :</h3>
      <c:choose>
          <c:when test="${consultation.getPrescription() != null}">
              <div>${consultation.getPrescription().getContenu()}</div>
          </c:when>
          <c:when test="${consultation.getPrescription() == null}">
              <form action="prescription?id=${consultation.getId_Consultation()}" method="post" class="formulaireConsultationDetails">
                  <label for="prescription">prescription :</label>
                  <textarea name="prescription" id="prescription" cols="30" rows="10" class="textBox" required></textarea>
                  <button class="btnForm">ajouter</button>
              </form>
          </c:when>
      </c:choose>


      <h3 class="titleConsultationDetails">Fiche de soins :</h3>
      <c:choose>
          <c:when test="${consultation.getFicheSoins() != null}">
              <div>${consultation.getFicheSoins().getContenu()}</div>
          </c:when>
          <c:when test="${consultation.getFicheSoins() == null}">
              <form action="fiche_soins?id=${consultation.getId_Consultation()}" method="post" class="formulaireConsultationDetails">
                  <label for="fiche_soins">Fiche de soins :</label>
                  <textarea name="fiche_soins" id="fiche_soins" cols="30" rows="10" class="textBox" required></textarea>
                  <button class="btnForm">ajouter</button>
              </form>
          </c:when>
      </c:choose>



</body>
</html>
