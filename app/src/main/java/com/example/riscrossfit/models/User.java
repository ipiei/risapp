package com.example.riscrossfit.models;

import java.io.Serializable;

public class User implements Serializable {
    private String id;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String email;
    private String password;
    private Object numeroTelephone;
    private String dateInscription;
    private Object idAdresse;
    private String roles;
    private String isVerified;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(Object numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(String dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Object getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(Object idAdresse) {
        this.idAdresse = idAdresse;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(String isVerified) {
        this.isVerified = isVerified;
    }
}
