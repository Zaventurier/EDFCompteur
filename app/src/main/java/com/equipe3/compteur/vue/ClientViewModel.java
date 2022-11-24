package com.equipe3.compteur.vue;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.equipe3.compteur.dao.Clientdao.ClientRepository;
import com.equipe3.compteur.model.Client;
import java.util.List;

public class ClientViewModel extends AndroidViewModel {
    private ClientRepository mClient;
    private final LiveData<List<Client>> mAllClients;
    public ClientViewModel(Application application) {
        super(application);
        this.mClient = new ClientRepository(application);
        this.mAllClients = mClient.getmAllClients();
    }
    public LiveData<List<Client>> getmAllClients() {
        return mAllClients;
    }
    public void insert(Client client) {
        mClient.insert(client);
    }
    public void update(Client client) { mClient.update(client);}
    public void delete(Client client) { mClient.delete(client);}
}