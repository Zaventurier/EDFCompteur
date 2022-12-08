package com.equipe3.compteur.dao.Relevedao;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.equipe3.compteur.dao.Clientdao.IClientDao;
import com.equipe3.compteur.dao.EDFdatabase;
import com.equipe3.compteur.model.Client;
import com.equipe3.compteur.model.ReleveCompteur;

import java.util.List;

public class ReleveRepository {
    private IReleveDao mReleveDao;
    private LiveData<List<ReleveCompteur>> mAllReleves;

    public ReleveRepository(Application application){
        EDFdatabase db = EDFdatabase.getDatabase(application);
        mReleveDao = db.releveDao();
    }

    public LiveData<List<ReleveCompteur>> getmAllReleve(){
        mAllReleves = mReleveDao.getAlphabetizedReleveCompteur();
        return mAllReleves;
    }

    public void insert (ReleveCompteur releve){
        EDFdatabase.databaseWriteExecutor.execute(() ->{
            mReleveDao.insert(releve);
        });
    }

    public void update(ReleveCompteur releve){
        EDFdatabase.databaseWriteExecutor.execute(() ->{
            mReleveDao.update(releve);
        });
    }

    public void delete(ReleveCompteur releve){
        EDFdatabase.databaseWriteExecutor.execute(() ->{
            mReleveDao.delete(releve);
        });
    }
}
