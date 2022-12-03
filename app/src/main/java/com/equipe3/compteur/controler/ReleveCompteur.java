package com.equipe3.compteur.controler;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.equipe3.compteur.R;
import com.equipe3.compteur.dao.EDFdatabase;
import com.equipe3.compteur.model.Client;

import com.equipe3.compteur.vue.vueClient.ClientListAdapter;
import com.equipe3.compteur.vue.vueClient.ClientViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Optional;

public class ReleveCompteur extends AppCompatActivity {
    private ClientViewModel mClientViewModel;

    private String nextClient;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listcardclient);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final ClientListAdapter adapter = new ClientListAdapter(
                new ClientListAdapter.ClientDiff());
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(
                        new LinearLayoutManager(recyclerView.getContext()));

                mClientViewModel = new ViewModelProvider(this).get(ClientViewModel.class);
                mClientViewModel.getmAllClients().observe(this, adapter::submitList);

                FloatingActionButton fab = findViewById(R.id.fab);
                fab.setOnClickListener(view -> {
                    Intent intent = new Intent(ReleveCompteur.this, NewClient.class);
                    NewClientActivityResultLauncher.launch(intent);
                });


    }

    ActivityResultLauncher<Intent> NewClientActivityResultLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override public void onActivityResult(ActivityResult result) {
                            if (result.getResultCode() == RESULT_OK) {
                                assert result.getData() != null;
                                //Integer.parseInt(result.getData().getStringExtra(NewClient.EXTRA_REPLY_IDCLIENT))

                                Client client = new Client(
                                        getNextClient(),
                                        result.getData().getStringExtra(NewClient.EXTRA_REPLY_NOMCLIENT),
                                        result.getData().getStringExtra(NewClient.EXTRA_REPLY_PRENOMCLIENT),
                                        result.getData().getStringExtra(NewClient.EXTRA_REPLY_ADRESSECLIENT),
                                        result.getData().getStringExtra(NewClient.EXTRA_REPLY_CODEPOSTALCLIENT),
                                        result.getData().getStringExtra(NewClient.EXTRA_REPLY_VILLECLIENT));

                                EDFdatabase.databaseWriteExecutor.execute(() -> mClientViewModel.insert(client));
                                msgToast("Client inséré dans la BD");

                            } else {
                                clientNonInsere();
                            }
                        }
                    });
    private void clientInsere() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Résultat :")
                .setMessage("Client inséré dans la BD")
                .setPositiveButton("OK", (dialog, which) -> {})
                .create()
                .show();
    }

    private void clientNonInsere() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Problème :")
                .setMessage("Client non inséré dans la BD")
                .setPositiveButton("OK", (dialog, which) -> {})
                .create()
                .show();
    }

    private void msgToast(String text){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

    private int getNextClient(){
        List<Client> clients = mClientViewModel.getmAllClients().getValue();

        int maxId = 0;

        for (Client client:clients) {
            if(maxId < client.getIdentifiantClient()){
                maxId = client.getIdentifiantClient();
            }
        }

        maxId++;

        return maxId;
    }

    private void Debug(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Problème :")
                .setMessage("Value : ")
                .setPositiveButton("OK", (dialog, which) -> {})
                .create()
                .show();
    }
}