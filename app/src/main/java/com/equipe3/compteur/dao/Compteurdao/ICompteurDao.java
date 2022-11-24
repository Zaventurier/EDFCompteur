package com.equipe3.compteur.dao.Compteurdao;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.equipe3.compteur.model.Client;
import com.equipe3.compteur.model.Compteur;

import java.util.List;

@Dao
public interface ICompteurDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Compteur compteur);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(Compteur compteur);

    @Delete
    void delete(Compteur compteur);

    @Query("DELETE FROM compteur")
    void deleteALL();

    @Query("SELECT * FROM compteur ORDER BY idCompteur ASC")
    LiveData<List<Compteur>> getAlphabetizedCompteur();
}
