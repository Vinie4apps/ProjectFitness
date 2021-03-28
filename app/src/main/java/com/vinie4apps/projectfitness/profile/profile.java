package com.vinie4apps.projectfitness.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.vinie4apps.projectfitness.R;

public class profile extends AppCompatActivity {

    FirebaseAuth auth;
    DatabaseReference reference;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        name = findViewById(R.id.nome);




    }
}