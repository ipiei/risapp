package com.example.riscrossfit.models;

public class Evenement {

    private String id;
    private String titre;
    private String description;
    private String image;
    private String lieu;
    private String date_debut;
    private String date_fin;
    private String date_fin_inscriptioin;
    private String id_adresse;

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public void setDate_fin_inscriptioin(String date_fin_inscriptioin) {
        this.date_fin_inscriptioin = date_fin_inscriptioin;
    }

    public void setId_adresse(String id_adresse) {
        this.id_adresse = id_adresse;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public String getDate_fin_inscriptioin() {
        return date_fin_inscriptioin;
    }

    public String getId_adresse() {
        return id_adresse;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setDateDebut(String dateDebut) {
        this.date_debut = dateDebut;
    }

    public void setDateFin(String dateFin) {
        this.date_fin = dateFin;
    }

    public void setDateFinInscription(String dateFinInscription) {
        this.dateFinInscription = dateFinInscription;
    }

    public void setIdAdresse(String idAdresse) {
        this.idAdresse = idAdresse;
    }

    private String dateFinInscription;
    private String idAdresse;

    public String getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getLieu() {
        return lieu;
    }

    public String getDateDebut() {
        return date_debut;
    }

    public String getDateFin() {
        return date_fin;
    }

    public String getDateFinInscription() {
        return dateFinInscription;
    }

    public String getIdAdresse() {
        return idAdresse;
    }
}
