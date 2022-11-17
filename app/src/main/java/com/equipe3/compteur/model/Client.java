package com.equipe3.compteur.model;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "client")
public class Client {
@PrimaryKey(autoGenerate = true)
@NonNull
@ColumnInfo(name = "identifiantClient")
    private int identifiantClient;
@ColumnInfo(name = "nomClient")
    private String nomClient;
@ColumnInfo(name = "prenomClient")
    private String prenomClient;
@ColumnInfo(name = "adresseClient")
    private String adresseClient;
    @ColumnInfo(name = "codePostalClient")
    private String codePostalClient;
    @ColumnInfo(name = "villeClient")
    private String villeClient;

    /*Getteur*/

    public int getIdentifiantClient() {
        return this.identifiantClient;
    }
    public String getNomClient() {
        return this.nomClient;
    }
    public String getPrenomClient(){
        return this.prenomClient;
    }
    public String getCodePostalClient(){
        return this.codePostalClient;
    }
    public String getAdresseClient(){
        return this.adresseClient;
    }
    public String getVilleClient(){
        return this.villeClient;
    }
    /*Setteurs*/
    public void setIdentifiantClient(int idClient){
        this.identifiantClient = idClient;
    }
    public void setNomClient(String nomClient){
        this.nomClient = nomClient;
    }
    public void setPrenomClient(String prenomClient){
        this.prenomClient = prenomClient;
    }
    public void setAdresseClient(String adresseClient){
        this.adresseClient = adresseClient;
    }
    public void setCodePostalClient(String codePostalClient){
        this.codePostalClient = codePostalClient;
    }
    public void setVilleClient(String villeClient){
        this.villeClient = villeClient;
    }

    /*Constructeurs*/
    /*Constructeur par défaut*/
    public Client(){

    }

    /*Constructeur*/
    public Client(int idCient, String nomClient, String prenomClient, String adresseClient, String codePostalClient, String villeClient){
        this.identifiantClient = idCient;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.adresseClient = adresseClient;
        this.codePostalClient = codePostalClient;
        this.villeClient = villeClient;
    }
}
