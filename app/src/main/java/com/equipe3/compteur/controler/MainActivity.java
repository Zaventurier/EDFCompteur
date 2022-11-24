package com.equipe3.compteur.controler;

import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.equipe3.compteur.R;

public class MainActivity extends AppCompatActivity {

    private LinearLayout midentifiantLinear;
    private LinearLayout mReleveCompteurLinear;
    private LinearLayout mImportDonnesLinear;
    private LinearLayout mSauvegardesLinear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        midentifiantLinear = findViewById(R.id.midentifiantLinear);
        mReleveCompteurLinear = findViewById(R.id.mReleveCompteurLinear);
        mImportDonnesLinear = findViewById(R.id.mImportDonnesLinear);
        mSauvegardesLinear = findViewById(R.id.mSauvegardesLinear);




    }



}