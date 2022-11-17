package com.equipe3.compteur.model;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "compteur")

public class Compteur {
    @PrimaryKey(autoGenerate = true)
    @NonNull

    @ColumnInfo(name = "idCompteur")
    private int idCompteur;
    @ColumnInfo(name = "idClientCompteur")
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
