package com.example.gestion_consultation.servlet;

import com.example.gestion_consultation.Entity.Patient;
import com.example.gestion_consultation.service.ConsultationService;
import com.example.gestion_consultation.service.PatientService;
import com.example.gestion_consultation.util.Description;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "consultation",value = "/consultation")
public class ConsultationServlet extends HttpServlet {

    private PatientService patientService;
    private ConsultationService consultationService;

    public void init(){
        consultationService = new ConsultationService();
        consultationService.start();
        patientService = new PatientService();
        patientService.start();
    }

    public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(Description.PATH_VIEWS+"consultationAdd.jsp").forward(request,response);
    }
    public void doPost (HttpServletRequest request , HttpServletResponse response){
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        int id = Integer.parseInt(request.getParameter("id"));
        Patient patient = patientService.findById(id);

    }

    public void destroy(){
        patientService.end();
        consultationService.end();
    }
}
