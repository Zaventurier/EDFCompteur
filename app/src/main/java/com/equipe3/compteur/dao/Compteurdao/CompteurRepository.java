package com.equipe3.compteur.dao.Compteurdao;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.equipe3.compteur.dao.Clientdao.IClientDao;
import com.equipe3.compteur.dao.EDFdatabase;
import com.equipe3.compteur.model.Client;
import com.equipe3.compteur.model.Compteur;

import java.util.List;

public class CompteurRepository {
    private ICompteurDao mCompteurDao;
    private LiveData<List<Compteur>> mAllCompteur;

    public CompteurRepository(Application application){
        EDFdatabase db = EDFdatabase.getDatabase(application);
        mCompteurDao = db.compteurDao();
    }

    public LiveData<List<Compteur>> getmAllClients(){
        mAllCompteur = mCompteurDao.getAlphabetizedCompteur();
        return mAllCompteur;
    }

    public void insert (Compteur compteur){
        EDFdatabase.databaseWriteExecutor.execute(() ->{
            mCompteurDao.insert(compteur);
        });
    }

    public void update(Compteur compteur){
        EDFdatabase.databaseWriteExecutor.execute(() ->{
            mCompteurDao.update(compteur);
        });
    }

    public void delete(Compteur compteur){
        EDFdatabase.databaseWriteExecutor.execute(() ->{
            mCompteurDao.delete(compteur);
        });
    }
}