package com.example.gestion_consultation.Entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_patient;
    private String nom;
    private String prenom;
    @OneToMany(mappedBy = "patient",fetch = FetchType.EAGER)
    private List<Consultation> consultations;

    public Patient(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Patient() {
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
