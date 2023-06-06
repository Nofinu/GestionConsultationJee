package com.example.gestion_consultation.servlet;

import com.example.gestion_consultation.Entity.Consultation;
import com.example.gestion_consultation.Entity.Prescription;
import com.example.gestion_consultation.service.ConsultationService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "prescription",value = "/prescription")
public class PrescriptionServlet extends HttpServlet {
    private ConsultationService consultationService;
    public void init(){
        consultationService = new ConsultationService();
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(request.getParameter("prescription")!= null && request.getParameter("id")!=null){
            String contenu = request.getParameter("prescription");
            int id = Integer.parseInt(request.getParameter("id"));
            Consultation consultation = consultationService.findById(id);
            if(consultation != null){
                Prescription prescription = new Prescription(contenu);
                if(consultationService.createPrescription(prescription)){
                    consultation.setPrescription(prescription);
                    if(consultationService.update(consultation)){
                        response.sendRedirect("consultation?id_consult="+consultation.getId_Consultation());
                    }
                }
            }
        }
    }

    public void destroy (){
        consultationService.end();
    }
}
