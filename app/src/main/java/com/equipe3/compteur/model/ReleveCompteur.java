package com.equipe3.compteur.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "relevecompteur")
public class ReleveCompteur {
    @PrimaryKey(autoGenerate = true)
    @NonNull

    @ColumnInfo(name = "idReleveCompteur")
    private int idReleveCompteur;
    @ColumnInfo(name = "releveCompteur")
    private double releveCompteur;
    @ColumnInfo(name = "dateReleveCompteur")
    private String dateReleveCompteur;
    @ColumnInfo(name = "situationReleve")
    private int situationReleve;
    @ColumnInfo(name = "idCompteurClient")
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
