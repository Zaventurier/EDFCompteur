package com.equipe3.compteur.model;

public class Compteur {
    private int idCompteur;
    private int idClientCompteur;

    /*Getteurs*/
    public int getIdCompteur(){
        return this.idCompteur;
    }
    public int getIdClientCompteur() {
        return this.idClientCompteur;
    }

    /*Setteurs*/
    public void setIdCompteur(int idCompteur){
        this.idCompteur = idCompteur;
    }
    public void setIdClientCompteur(int idClientCompteur){
        this.idClientCompteur = idClientCompteur;
    }

    /*Constructeurs*/
    /*Constructeurs par défaut*/
    public Compteur(){

    }

    /*Constructeurs paramétrés*/
    public Compteur (int idCompteur, int idClientCompteur){
        this.idCompteur = idCompteur;
        this.idClientCompteur = idClientCompteur;
    }

}
