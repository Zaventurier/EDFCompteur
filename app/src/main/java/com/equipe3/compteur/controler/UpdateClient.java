package com.equipe3.compteur.controler;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
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

public class UpdateClient extends AppCompatActivity {

    private String EXTRA_REPLY_IDCLIENT = "1";
    private String EXTRA_REPLY_NOMCLIENT = "Nom";
    private String EXTRA_REPLY_PRENOMCLIENT = "Prenom";
    private String EXTRA_REPLY_ADRESSECLIENT = "1 rue de nulle part";
    private String EXTRA_REPLY_CODEPOSTALCLIENT = "00000";
    private String EXTRA_REPLY_VILLECLIENT = "VILLE INEXISTANTE";

    private EditText medittext_id;
    private EditText medittext_nom;
    private EditText medittext_prenom;
    private EditText medittext_adresse;
    private EditText medittext_codepostal;
    private EditText medittext_ville;

    private View meditbuton;

    private View mdelbuton;


    private ClientViewModel mClientViewModel;

    @Override protected void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateclient);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);


        //medittext_id = findViewById(R.id.edittext_id);
        medittext_nom = findViewById(R.id.edittext_nom);
        medittext_prenom = findViewById(R.id.edittext_prenom);
        medittext_adresse = findViewById(R.id.edittext_adresse);
        medittext_codepostal = findViewById(R.id.edittext_codepostal);
        medittext_ville = findViewById(R.id.edittext_ville);

        meditbuton = findViewById(R.id.valider);

        mdelbuton = findViewById(R.id.sup);

        final ClientListAdapter adapter = new ClientListAdapter(
                new ClientListAdapter.ClientDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(recyclerView.getContext()));

        mClientViewModel = new ViewModelProvider(this).get(ClientViewModel.class);

        Intent intent = getIntent();

        EXTRA_REPLY_IDCLIENT = String.valueOf(intent.getIntExtra("idClient",0));
        EXTRA_REPLY_NOMCLIENT = intent.getStringExtra("nomClient");
        EXTRA_REPLY_PRENOMCLIENT = intent.getStringExtra("prenomClient");
        EXTRA_REPLY_ADRESSECLIENT = intent.getStringExtra("adresseClient");
        EXTRA_REPLY_CODEPOSTALCLIENT = intent.getStringExtra("codePostalClient");
        EXTRA_REPLY_VILLECLIENT = intent.getStringExtra("villeClient");

        //medittext_id.setText(EXTRA_REPLY_IDCLIENT);
        medittext_nom.setText(EXTRA_REPLY_NOMCLIENT);
        medittext_prenom.setText(EXTRA_REPLY_PRENOMCLIENT);
        medittext_adresse.setText(EXTRA_REPLY_ADRESSECLIENT);
        medittext_codepostal.setText(EXTRA_REPLY_CODEPOSTALCLIENT);
        medittext_ville.setText(EXTRA_REPLY_VILLECLIENT);


        meditbuton.setOnClickListener(View ->{
            Client client = inputOk();
            if(client != null) {
                EDFdatabase.databaseWriteExecutor.execute(() -> mClientViewModel.update(client));
                msgToast("Client enregistrer");
                finish();
            }else{
                ClientNonupdate("Mise a jour du client impossible \nVérifiez les champs");
            }

        });

        mdelbuton.setOnClickListener(View ->{
            if(EXTRA_REPLY_IDCLIENT != "") {
                EDFdatabase.databaseWriteExecutor.execute(() ->
                        mClientViewModel.delete(
                                new Client(Integer.parseInt(EXTRA_REPLY_IDCLIENT),
                                        "", "", "", "", "")));
                msgToast("Client supprimer");
                finish();
            }else{
                ClientNonupdate("Suppression impossible");
            }

        });

        //Debug(client);

    }

    private Client inputOk(){

        if(EXTRA_REPLY_IDCLIENT == "" ||
                TextUtils.isEmpty(medittext_nom.getText()) ||
                TextUtils.isEmpty(medittext_prenom.getText())||
                TextUtils.isEmpty(medittext_adresse.getText()) ||
                TextUtils.isEmpty(medittext_codepostal.getText()) ||
                TextUtils.isEmpty(medittext_ville.getText())){
            return null;
        }
        return new Client(Integer.parseInt(EXTRA_REPLY_IDCLIENT),
                String.valueOf(medittext_nom.getText()),
                String.valueOf(medittext_prenom.getText()),
                String.valueOf(medittext_adresse.getText()),
                String.valueOf(medittext_codepostal.getText()),
                String.valueOf(medittext_ville.getText()));
    }


    private void msgToast(String text){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

    private void ClientNonupdate(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Problème :")
                .setMessage(text)
                .setPositiveButton("Ok", (dialog, which) -> {})
                .setNegativeButton("Fermer",(dialog, which) -> {finish();})
                .create()
                .show();
    }

    private void Debug(Client client) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Problème :")
                .setMessage("ID : "+client.getIdentifiantClient()+"\n"+
                        "Nom : "+client.getNomClient()+"\n"+
                        "Prenom : "+client.getPrenomClient()
                        )
                .setPositiveButton("OK", (dialog, which) -> {})
                .create()
                .show();
    }

}
