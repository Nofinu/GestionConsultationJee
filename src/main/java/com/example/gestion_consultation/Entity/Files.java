package com.example.gestion_consultation.Entity;

import javax.persistence.*;

@Entity(name = "files")
public class Files {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String url;
    private String filename;

    @ManyToOne
    private Consultation consultation;


    public Files(String url, String filename,Consultation consultation) {
        this.url = url;
        this.consultation = consultation;
        this.filename = filename;
    }

    public Files() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
