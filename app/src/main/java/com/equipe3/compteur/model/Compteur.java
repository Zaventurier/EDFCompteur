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

    @ColumnInfo(name = "adresseCompteur")
    private String adresseCompteur;

    @ColumnInfo(name = "codePostalCompteur")
    private String codePostalCompteur;

    @ColumnInfo(name = "villeCompteur")
    private String villeCompteur;

    /*Getteurs*/
    public int getIdCompteur() {
        return this.idCompteur;
    }

    public int getIdClientCompteur() {
        return this.idClientCompteur;
    }

    public String getAdresseCompteur() {
        return adresseCompteur;
    }

    public String getCodePostalCompteur() {
        return codePostalCompteur;
    }

    public String getVilleCompteur() {
        return villeCompteur;
    }


    /*Setteurs*/
    public void setIdCompteur(int idCompteur) {
        this.idCompteur = idCompteur;
    }

    public void setIdClientCompteur(int idClientCompteur) {
        this.idClientCompteur = idClientCompteur;
    }

    public void setAdresseCompteur(String adresseCompteur) {
        this.adresseCompteur = adresseCompteur;
    }

    public void setCodePostalCompteur(String codePostalCompteur) {
        this.codePostalCompteur = codePostalCompteur;
    }

    public void setVilleCompteur(String villeCompteur) {
        this.villeCompteur = villeCompteur;
    }

    /*Constructeurs*/
    /*Constructeurs par défaut*/
    public Compteur() {

    }

    /*Constructeurs paramétrés*/

    public Compteur(int idCompteur, int idClientCompteur, String adresseCompteur, String codePostalCompteur, String villeCompteur) {
        this.idCompteur = idCompteur;
        this.idClientCompteur = idClientCompteur;
        this.adresseCompteur = adresseCompteur;
        this.codePostalCompteur = codePostalCompteur;
        this.villeCompteur = villeCompteur;
    }
}