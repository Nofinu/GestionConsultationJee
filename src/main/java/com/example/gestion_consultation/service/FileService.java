package com.example.gestion_consultation.service;

import com.example.gestion_consultation.Entity.Consultation;
import com.example.gestion_consultation.Entity.Files;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class FileService {
    private ConsultationService consultationService;

    public Consultation uploadImage(int idConsultation, String uploadPath, Collection<Part> parts) throws IOException {
        consultationService = new ConsultationService();
        Consultation consultation = consultationService.findById(idConsultation);
        File uploadDir = new File(uploadPath);
        if(!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        if(consultation != null){
            for(Part part : parts) {
                String name = part.getSubmittedFileName();
                part.write(uploadPath + File.separator + name);
                Files file = new Files("file" + File.separator + name,name,consultation);

                if(consultationService.createFiles(file)){
                    consultation.addFile(file);
                    consultationService.update(consultation);
                }
            }
        }
        return consultation;
    }

    public void end(){
        consultationService.end();
    }
}
