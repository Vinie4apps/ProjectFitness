package com.vinie4apps.projectfitness.profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.vinie4apps.projectfitness.MainActivity;
import com.vinie4apps.projectfitness.R;

public class register extends AppCompatActivity {

    EditText txtemail, txtpass, txtnome;

    FirebaseAuth auth;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtemail = (EditText) findViewById(R.id.edit_email_singup);
        txtpass = (EditText) findViewById(R.id.edit_password_singup);
        txtnome = (EditText) findViewById(R.id.edit_username);

        auth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference().child("Users");
    }

    public void gotoLogin(View view) {
        Intent i = new Intent(register.this, login.class);
        startActivity(i);
        finish();
    }

    public void RegUsers(View view) {

        final String email = txtemail.getText().toString();
        final String pass = txtpass.getText().toString();
        final String nome = txtnome.getText().toString();

        if (nome == null || nome.isEmpty() || email == null || email.isEmpty() || pass == null || pass.isEmpty()) {
            Toast.makeText(register.this, "Nome, senha e email devem ser preenchidos", Toast.LENGTH_SHORT).show();
            return;
        }
        auth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser firebaseUser = auth.getCurrentUser();
                            User u = new User();
                            u.setEmail(email);
                            u.setName(nome);


                            reference.child(firebaseUser.getUid()).setValue(u)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Intent intent = new Intent(register.this, MainActivity.class);
                                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                startActivity(intent);
                                                finish();
                                            } else {
                                                Toast.makeText(register.this, "Erro, não foi possivel criar sua conta. Tente novamente mais tarde !", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                        }
                    }
                });

    }
}