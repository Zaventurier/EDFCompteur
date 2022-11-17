package com.equipe3.compteur.dao;


import android.provider.ContactsContract;
import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.equipe3.compteur.model.Client;

import java.util.List;

@Dao
public interface Clientdao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Client client);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(Client client);

    @Delete
    void delete(Client client);

    @Query("DELETE FROM client")
    void deleteALL();

    @Query("SELECT * FROM client ORDER BY client.identifiantClient ASC")
    LiveData<List<Client>> getAlphabetizedClients();
}
