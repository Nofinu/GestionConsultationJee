package com.example.gestion_consultation.servlet;

import com.example.gestion_consultation.Entity.Consultation;
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
        patientService = new PatientService();
    }

    public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id_consult")!=null){
            int id = Integer.parseInt(request.getParameter("id_consult"));
            Consultation consultation = consultationService.findById(id);
            if(consultation != null){
                request.setAttribute("consultation",consultation);
                request.getRequestDispatcher(Description.PATH_VIEWS+"ConsultationDetails.jsp").forward(request,response);
            }
        }else{
            request.getRequestDispatcher(Description.PATH_VIEWS+"consultationAdd.jsp").forward(request,response);
        }
    }
    public void doPost (HttpServletRequest request , HttpServletResponse response){
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        int id = Integer.parseInt(request.getParameter("id"));
        Patient patient = patientService.findById(id);
        if(patient != null){
            Consultation consultation = new Consultation(date,patient);
            consultationService.create(consultation);
        }
    }

    public void destroy(){
        patientService.end();
        consultationService.end();
    }
}
