package com.example.gestion_consultation.servlet;

import com.example.gestion_consultation.Entity.Consultation;
import com.example.gestion_consultation.Entity.Files;
import com.example.gestion_consultation.Entity.Patient;
import com.example.gestion_consultation.service.ConsultationService;
import com.example.gestion_consultation.service.FileService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "files",value = "/files")
@MultipartConfig(
        maxFileSize = 1024*1024*10,
        maxRequestSize = 1024*1024*100
)
public class FilesServlet extends HttpServlet {

    private FileService fileService;
    public void init(){
        fileService = new FileService();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id")!=null){
            Consultation consultation = fileService.uploadImage(Integer.parseInt(request.getParameter("id")),getServletContext().getRealPath("/") + "file",request.getParts());
            response.sendRedirect("consultation?id_consult="+consultation.getId_Consultation());
        }
    }

    public void destroy(){
        fileService.end();
    }
}
