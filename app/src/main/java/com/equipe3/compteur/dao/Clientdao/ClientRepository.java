package com.equipe3.compteur.dao.Clientdao;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.equipe3.compteur.dao.EDFdatabase;
import com.equipe3.compteur.model.Client;

import java.util.List;

public class ClientRepository {
    private IClientDao mClientDao;
    private LiveData<List<Client>> mAllClients;
    public ClientRepository(Application application){
        EDFdatabase db = EDFdatabase.getDatabase(application);
        mClientDao = db.clientdao();
    }

    public LiveData<List<Client>> getmAllClients(){
      mAllClients = mClientDao.getAlphabetizedClients();
      return mAllClients;
    }

    public void insert (Client client){
        EDFdatabase.databaseWriteExecutor.execute(() ->{
            mClientDao.insert(client);
        });
    }

    public void update(Client client){
        EDFdatabase.databaseWriteExecutor.execute(() ->{
            mClientDao.update(client);
        });
    }

    public void delete(Client client){
        EDFdatabase.databaseWriteExecutor.execute(() ->{
            mClientDao.delete(client);
        });
    }
}






