package com.example.gestion_consultation.servlet;

import com.example.gestion_consultation.Entity.Patient;
import com.example.gestion_consultation.Entity.User;
import com.example.gestion_consultation.service.ConsultationService;
import com.example.gestion_consultation.service.PatientService;
import com.example.gestion_consultation.service.UserService;
import com.example.gestion_consultation.util.Description;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import javax.persistence.Persistence;
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
        HttpSession session = request.getSession();
        boolean isLogged = (session.getAttribute("isLogged")!= null)? (boolean) session.getAttribute("isLogged"):false;
        request.setAttribute("isLogged",isLogged);

        if(request.getParameter("id")!=null){
            int id = Integer.parseInt(request.getParameter("id"));
            Patient patient = patientService.findById(id);
            if(patient != null){
                session.setAttribute("idPatient",patient.getId_patient());
                request.setAttribute("patient", patient);
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

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {

        if(request.getParameter("nameEntry")!= null && request.getParameter("firstname")!=null){
            String name = request.getParameter("nameEntry");
            String firstName = request.getParameter("firstname");
            Patient patient = new Patient(name,firstName);
            if(patientService.create(patient)){
                response.sendRedirect("patient");
            }
        }
    }

    public void destroy(){
        patientService.end();
        consultationService.end();
    }
}
