package com.example.gestion_consultation.Entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity (name = "consultation")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Consultation;
    private LocalDate date;
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "id_patient")
    private Patient patient;

    @OneToOne(fetch = FetchType.EAGER)
    private Prescription prescription;

    @OneToOne
    private FicheSoins ficheSoins;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Files> files ;

    public Consultation(Patient patient, Prescription prescription, FicheSoins ficheSoins) {
        this.patient = patient;
        this.prescription = prescription;
        this.ficheSoins = ficheSoins;
    }

    public Consultation(LocalDate date, Patient patient) {
        this.date = date;
        this.patient = patient;
    }

    public Consultation() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getId_Consultation() {
        return id_Consultation;
    }

    public void setId_Consultation(int id_Consultation) {
        this.id_Consultation = id_Consultation;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public FicheSoins getFicheSoins() {
        return ficheSoins;
    }

    public void setFicheSoins(FicheSoins ficheSoins) {
        this.ficheSoins = ficheSoins;
    }

    public List<Files> getFiles() {
        return files;
    }

    public void setFiles(List<Files> files) {
        this.files = files;
    }

    public void addFile (Files file){
        if(file !=null){
            this.files.add(file);
        }
    }
}
