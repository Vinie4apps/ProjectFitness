package com.vinie4apps.projectfitness.profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.vinie4apps.projectfitness.MainActivity;
import com.vinie4apps.projectfitness.R;
import com.google.firebase.database.DatabaseReference;

public class login extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseAuth.AuthStateListener authStateListener;
    EditText txtemail, txtpass, emailforget;
    TextView forget, mTextViewS;
    Button enviforget;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent i = new Intent(login.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };

        //login E-mail e senha Padrão

        txtemail = (EditText) findViewById(R.id.edit_email_login);
        txtpass = (EditText) findViewById(R.id.edit_password_login);
        forget = (TextView) findViewById(R.id.txt_esqueceu);
        enviforget = (Button) findViewById(R.id.bntenviar);
        emailforget = (EditText) findViewById(R.id.editTextTextEmailAddress);

        auth = FirebaseAuth.getInstance();


    }
    public void loginUsers(View view) {

        String email = txtemail.getText().toString();
        String pass = txtpass.getText().toString();

        if (email == null || email.isEmpty() || pass == null || pass.isEmpty()) {
            Toast.makeText(login.this, "Email e senha devem ser preenchidos", Toast.LENGTH_SHORT).show();
            return;
        }
        auth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Intent intent = new Intent(login.this, MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        } else {
                            Toast.makeText(login.this, "Email ou senha estão incorretos !", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    public void gotoReg(View view) {
        Intent i = new Intent(login.this, register.class);
        startActivity(i);
        finish();
    }
    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authStateListener);
    }
    @Override
    protected void onStop() {
        super.onStop();

        if (authStateListener != null){
            auth.removeAuthStateListener(authStateListener);
        }
    }
}