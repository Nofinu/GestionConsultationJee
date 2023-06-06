package com.example.gestion_consultation.Entity;

import javax.persistence.*;

@Entity
public class FicheSoins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_ficheSoins;
    private String contenu;

    public FicheSoins(String contenu) {
        this.contenu = contenu;
    }

    public FicheSoins() {
    }

    public int getId_ficheSoins() {
        return id_ficheSoins;
    }

    public void setId_ficheSoins(int id_ficheSoins) {
        this.id_ficheSoins = id_ficheSoins;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

}
