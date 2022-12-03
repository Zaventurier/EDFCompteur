package com.equipe3.compteur.controler;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.equipe3.compteur.R;
import com.equipe3.compteur.vue.vueClient.ClientListAdapter;
import com.equipe3.compteur.vue.vueClient.ClientViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NewClient extends AppCompatActivity {
    public static final String EXTRA_REPLY_IDCLIENT = "1";
    public static final String EXTRA_REPLY_NOMCLIENT = "Nom";
    public static final String EXTRA_REPLY_PRENOMCLIENT = "Prenom";
    public static final String EXTRA_REPLY_ADRESSECLIENT = "1 rue de nulle part";
    public static final String EXTRA_REPLY_CODEPOSTALCLIENT = "00000";
    public static final String EXTRA_REPLY_VILLECLIENT = "VILLE INEXISTANTE";

    private EditText medittext_id;
    private EditText medittext_nom;
    private EditText medittext_prenom;
    private EditText medittext_adresse;
    private EditText medittext_codepostal;
    private EditText medittext_ville;

    private View mCheckbuton;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newclient);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);



        mCheckbuton = findViewById(R.id.checkbuton);

        //medittext_id = findViewById(R.id.edittext_id);
        medittext_nom = findViewById(R.id.edittext_nom);
        medittext_prenom = findViewById(R.id.edittext_prenom);
        medittext_adresse = findViewById(R.id.edittext_adresse);
        medittext_codepostal = findViewById(R.id.edittext_codepostal);
        medittext_ville = findViewById(R.id.edittext_ville);

        final ClientListAdapter adapter = new ClientListAdapter(
                new ClientListAdapter.ClientDiff());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(recyclerView.getContext())
        );


        mCheckbuton.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (/*TextUtils.isEmpty(medittext_id.getText()) ||*/
                    TextUtils.isEmpty(medittext_nom.getText()) ||
                    TextUtils.isEmpty(medittext_prenom.getText())||
                    TextUtils.isEmpty(medittext_adresse.getText()) ||
                    TextUtils.isEmpty(medittext_codepostal.getText()) ||
                    TextUtils.isEmpty(medittext_ville.getText())){
                setResult(RESULT_CANCELED, replyIntent);
            }else{
                //replyIntent.putExtra(EXTRA_REPLY_IDCLIENT, medittext_id.getText().toString());
                replyIntent.putExtra(EXTRA_REPLY_NOMCLIENT,medittext_nom.getText().toString());
                replyIntent.putExtra(EXTRA_REPLY_PRENOMCLIENT,medittext_prenom.getText().toString());
                replyIntent.putExtra(EXTRA_REPLY_ADRESSECLIENT,medittext_adresse.getText().toString());
                replyIntent.putExtra(EXTRA_REPLY_CODEPOSTALCLIENT,medittext_codepostal.getText().toString());
                replyIntent.putExtra(EXTRA_REPLY_VILLECLIENT,medittext_ville.getText().toString());

                setResult(RESULT_OK, replyIntent);
            }

            finish();
        });

    }
}
