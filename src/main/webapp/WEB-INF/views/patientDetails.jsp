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
</head>
<body>
      <div>nom : ${patient.getNom()}</div>
      <div>nom : ${patient.getPrenom()}</div>

      <h3>Consultation</h3>
      <c:forEach items="${patient.getConsultations()}" var="consultation">
        <div>
            id: ${consultation.getId_Consultation()}
          ,Date : ${consultation.getDate()}
            <a href="consultation?id_consult=${consultation.getId_Consultation()}">Details</a>
        </div>
      </c:forEach>
      <a href="consultation?id=${patient.getId_patient()}">Ajout d'une consultation</a>

</body>
</html>
