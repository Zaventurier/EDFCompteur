package com.equipe3.compteur.dao;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.equipe3.compteur.model.Client;

import java.util.List;

public class ClientRepository {
    private IClientDao mClientDao;
    private LiveData<List<Client>> mAllClients;

    public ClientRepository(Application application){
        IClientDao db = IClientDao.getdatabase(application);
        mClientDao = db.clientDao();
    }

    public LiveData<List<Client>> getmAllClients
}






