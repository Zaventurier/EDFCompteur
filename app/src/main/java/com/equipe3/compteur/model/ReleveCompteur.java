package com.equipe3.compteur.model;


public class ReleveCompteur {
    private int idReleveCompteur;
    private double releveCompteur;
    private String dateReleveCompteur;
    private int situationReleve;
    private int idCompteurClient;

    /*Getteurs*/
    public int getIdReleveCompteur(){
        return this.idReleveCompteur;
    }
    public double getReleveCompteur(){
        return this.releveCompteur;
    }
    public String getDateReleveCompteur(){
        return dateReleveCompteur;
    }
    public int getSituationReleve(){
        return this.situationReleve;
    }
    public int getIdCompteurClient(){return this.idCompteurClient;}

    /*Setteurs*/
    public void setIdReleveCompteur(int idReleveCompteur){
        this.idReleveCompteur = idReleveCompteur;
    }
    public void setReleveCompteur(double releveCompteur){
        this.releveCompteur = releveCompteur;
    }
    public void setDateReleveCompteur(String dateReleveCompteur){
        this.dateReleveCompteur = dateReleveCompteur;
    }
    public void setSituationReleve(int situationReleve){
        this.situationReleve = situationReleve;
    }
    public void setIdCompteurClient(int idCompteurClient){this.idCompteurClient = idCompteurClient;}

    /*Constructeurs*/
    /*Constructeur par défaut*/
    public ReleveCompteur(){

    }
    public ReleveCompteur(int idReleveCompteur, double releveCompteur, String dateReleveCompteur, int situationReleve, int idCompteurClient){
        this.idReleveCompteur = idReleveCompteur;
        this.releveCompteur = releveCompteur;
        this.dateReleveCompteur = dateReleveCompteur;
        this.situationReleve = situationReleve;
        this.idCompteurClient = idCompteurClient;
    }
}
