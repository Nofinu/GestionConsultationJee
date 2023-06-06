package com.example.gestion_consultation.Entity;

import javax.persistence.*;

@Entity(name = "prescription")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Prescription;
    private String contenu;


    public Prescription(String contenu) {
        this.contenu = contenu;
    }

    public Prescription() {
    }

    public int getId_Prescription() {
        return id_Prescription;
    }

    public void setId_Prescription(int id_Prescription) {
        this.id_Prescription = id_Prescription;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

}
