package com.example.gestion_consultation.servlet;

import com.example.gestion_consultation.Entity.Consultation;
import com.example.gestion_consultation.Entity.FicheSoins;
import com.example.gestion_consultation.Entity.Patient;
import com.example.gestion_consultation.Entity.Prescription;
import com.example.gestion_consultation.service.ConsultationService;
import com.example.gestion_consultation.service.PatientService;
import com.example.gestion_consultation.util.Description;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "patient",value = "/patient")
public class PatientServlet extends HttpServlet {
    private PatientService patientService;
    private ConsultationService consultationService;

    public void init(){
        patientService = new PatientService();
        consultationService = new ConsultationService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if(request.getParameter("id")!=null){
            int id = Integer.parseInt(request.getParameter("id"));
            Patient patient = patientService.findById(id);
            if(patient != null){
                request.setAttribute("patient", patient);
                for (Consultation c:patient.getConsultations()) {
                    System.out.println(c.getId_Consultation());
                }
                request.getRequestDispatcher(Description.PATH_VIEWS+"patientDetails.jsp").forward(request,response);
            }


        } else if (request.getParameter("name")!=null) {
            String name = request.getParameter("name");
            System.out.println(name);
            List<Patient>patients = patientService.findByName(name);
            request.setAttribute("patients",patients);
            request.getRequestDispatcher(Description.PATH_VIEWS+"patient.jsp").forward(request,response);
        }
        else{
            List<Patient> patients = patientService.findAll();
            request.setAttribute("patients",patients);
            request.getRequestDispatcher(Description.PATH_VIEWS+"patient.jsp").forward(request,response);
        }

    }

    public void destroy(){
        patientService.end();
        consultationService.end();
    }
}
