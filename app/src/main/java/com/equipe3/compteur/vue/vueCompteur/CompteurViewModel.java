package com.equipe3.compteur.vue.vueCompteur;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.equipe3.compteur.dao.Compteurdao.CompteurRepository;
import com.equipe3.compteur.model.Compteur;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CompteurViewModel extends AndroidViewModel {
    private CompteurRepository mCompteur;
    private final LiveData<List<Compteur>> mAllCompteur;
    public CompteurViewModel(Application application) {
        super(application);
        this.mCompteur = new CompteurRepository(application);
        this.mAllCompteur = mCompteur.getmAllClients();
    }

    public CompteurViewModel(@NonNull @NotNull Application application, LiveData<List<Compteur>> mAllCompteur) {
        super(application);
        this.mAllCompteur = mAllCompteur;
    }

    public LiveData<List<Compteur>> getmAllCompteur() {
        return mAllCompteur;
    }
    public void insert(Compteur compteur) {
        mCompteur.insert(compteur);
    }
    public void update(Compteur compteur) {
        mCompteur.update(compteur);
    }
    public void delete(Compteur compteur) {
        mCompteur.delete(compteur);
    }
}
