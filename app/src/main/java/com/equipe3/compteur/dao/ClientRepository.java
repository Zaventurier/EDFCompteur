package com.equipe3.compteur.dao;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.equipe3.compteur.model.Client;

import java.util.List;

public class ClientRepository {
    private IClientDao mClientDao;
    private LiveData<List<Client>> mAllClients;

    public ClientRepository(Application application){
        Clientdatabase db = Clientdatabase.getDatabase(application);
        mClientDao = db.clientdao();
    }

    public LiveData<List<Client>> getmAllClients(){
      mAllClients = mClientDao.getAlphabetizedClients();
      return mAllClients;
    }

    public void insert (Client client){
        Clientdatabase.databaseWriteExecutor.execute(() ->{
            mClientDao.insert(client);
        });
    }

    public void update(Client client){
        Clientdatabase.databaseWriteExecutor.execute(() ->{
            mClientDao.update(client);
        });
    }

    public void delete(Client client){
        Clientdatabase.databaseWriteExecutor.execute(() ->{
            mClientDao.delete(client);
        });
    }
}






