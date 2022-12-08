package com.equipe3.compteur.dao.Relevedao;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.equipe3.compteur.model.Client;
import com.equipe3.compteur.model.ReleveCompteur;

import java.util.List;
@Dao
public interface IReleveDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ReleveCompteur releve);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(ReleveCompteur releve);

    @Delete
    void delete(ReleveCompteur releve);

    @Query("DELETE FROM relevecompteur")
    void deleteALL();

    @Query("SELECT * FROM relevecompteur ORDER BY releveCompteur.idReleveCompteur ASC")
    LiveData<List<ReleveCompteur>> getAlphabetizedReleveCompteur();





}

