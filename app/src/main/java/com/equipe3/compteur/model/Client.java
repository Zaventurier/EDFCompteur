package com.equipe3.compteur.model;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


/**
 * La class Client du dossier Model permet de récupérer les informations du client présente dans la base de données
 *
 * @author Jérémy Patapy
 */
@Entity(tableName = "client")
public class Client {

    /**
     * Ici, on définit à quelle champs de la base de données correspond chaque variable
     */
    @PrimaryKey(autoGenerate = false)
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

    /**
     * retourne l'indentifiant du client
     *
     * @return identifiantClient
     * @author Jéramy Patapy
     */

    public int getIdentifiantClient() {
        return this.identifiantClient;
    }

    /**
     * Retourne le nom du client
     *
     * @return NomClient
     * @author Jérémy Patapy
     */
    public String getNomClient() {
        return this.nomClient;
    }

    /**
     * Retourne le prénom du client
     *
     * @return prenomClient
     * @author Jérémy Patapy
     */
    public String getPrenomClient(){
        return this.prenomClient;
    }

    /**
     * Retourne le code postal du client
     *
     * @return codePostalClient
     * @author Jérémy Patapy
     */
    public String getCodePostalClient(){
        return this.codePostalClient;
    }

    /**
     * Retourne l'adresse du client
     *
     * @return adresseClient
     * @author Jérémy Patapy
     */
    public String getAdresseClient(){
        return this.adresseClient;
    }

    /**
     * Retourne la ville du client
     *
     *
     * @return villeClient
     * @author Jérémy Patapy
     */
    public String getVilleClient(){
        return this.villeClient;
    }
    /*Setteurs*/


    /**
     * Met à jour l'identifiant du client
     *
     * @param idClient
     * @author Jérémy Patapy
     */
    public void setIdentifiantClient(int idClient){
        this.identifiantClient = idClient;
    }

    /**
     * Met à jour le nom du client
     *
     * @param nomClient
     * @author Jérémy Patapy
     */
    public void setNomClient(String nomClient){
        this.nomClient = nomClient;
    }

    /**
     * Met à jour le prénom du client
     *
     * @param prenomClient
     * @author Jérémy Patapy
     */
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