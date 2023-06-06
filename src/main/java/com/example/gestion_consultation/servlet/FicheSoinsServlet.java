package com.example.gestion_consultation.servlet;

import com.example.gestion_consultation.Entity.Consultation;
import com.example.gestion_consultation.Entity.FicheSoins;
import com.example.gestion_consultation.service.ConsultationService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "fiche_soins",value = "/fiche_soins")
public class FicheSoinsServlet extends HttpServlet {
    private ConsultationService consultationService;
    public void init(){
        consultationService = new ConsultationService();
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response){
        if(request.getParameter("fiche_soins")!= null && request.getParameter("id")!=null){
            String contenu = request.getParameter("fiche_soins");
            int id = Integer.parseInt(request.getParameter("id"));
            Consultation consultation = consultationService.findById(id);
            if(consultation != null){
                FicheSoins ficheSoins = new FicheSoins(contenu);
                if(consultationService.createFicheSoins(ficheSoins)){
                    consultation.setFicheSoins(ficheSoins);
                    consultationService.update(consultation);
                }
            }
        }
    }

    public void destroy (){
        consultationService.end();
    }
}
