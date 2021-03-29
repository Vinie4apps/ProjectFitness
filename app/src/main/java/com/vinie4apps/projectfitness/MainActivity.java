package com.vinie4apps.projectfitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import android.widget.ViewSwitcher;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.vinie4apps.projectfitness.app.dieta;
import com.vinie4apps.projectfitness.app.semana.ModelSemana;
import com.vinie4apps.projectfitness.app.semana.PageAdapterSemana;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //import de objs
    private ViewPager viewPager;
    private int[] layouts;
    FirebaseAuth auth;
    LinearLayout home, dieta, treino, estatistica;
    ViewFlipper VF;
    ImageView imgh, dietaimg, treinoimg, estaimg;
    TextView txth, dietatxt, treinotxt, estatxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // declaração de layout e layout manager
        home = (LinearLayout) findViewById(R.id.homell);
        dieta = (LinearLayout) findViewById(R.id.dietall);
        treino = (LinearLayout) findViewById(R.id.treinoll);
        estatistica = (LinearLayout) findViewById(R.id.estatisticall);
        VF = (ViewFlipper) findViewById(R.id.ViewFlipper01);

        // bnt click
        home.setOnClickListener(testebnt);
        dieta.setOnClickListener(testebnt);
        treino.setOnClickListener(testebnt);
        estatistica.setOnClickListener(testebnt);

        // declaração botoes e txt
        imgh = findViewById(R.id.imghome);
        txth = findViewById(R.id.txthome);
        dietaimg = findViewById(R.id.dietaimg);
        dietatxt = findViewById(R.id.dietatxt);
        treinoimg = findViewById(R.id.treinoimg);
        treinotxt = findViewById(R.id.treinotxt);
        estaimg = findViewById(R.id.estaimg);
        estatxt = findViewById(R.id.estatxt);

        imgh.setImageResource(R.drawable.ic_baseline_home_24_click);
        txth.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.amarelo));

        auth = FirebaseAuth.getInstance();

        // config. da toolbar
        Toolbar toolbar = findViewById(R.id.toolbarmain);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Project Fitness");
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));



        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.azul));
        }



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menulogout) {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Fazer logout ?")
                    .setMessage("aaaa !")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            auth.signOut();
                        }
                    })

                    .setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();


        }
        return super.onOptionsItemSelected(item);
    }
    private View.OnClickListener testebnt = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.homell:
                    VF.setDisplayedChild(0);
                    changebntcolorHome();
                    break;
                case R.id.dietall:
                    VF.setDisplayedChild(1);
                    changebntcolorDieta();
                    break;
                case R.id.treinoll:
                    VF.setDisplayedChild(2);
                    changebntcolorTreino();
                    break;
                case R.id.estatisticall:
                    VF.setDisplayedChild(3);
                    changebntcolorEsta();
                    break;
            }
        }
    };
    private void changebntcolorHome(){
        imgh.setImageResource(R.drawable.ic_baseline_home_24_click);
        txth.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.amarelo));
        dietaimg.setImageResource(R.drawable.ic_baseline_food_bank_24);
        dietatxt.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
        treinoimg.setImageResource(R.drawable.ic_baseline_fitness_center_24);
        treinotxt.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
        estaimg.setImageResource(R.drawable.ic_baseline_data_usage_24);
        estatxt.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
    }
    private void changebntcolorDieta(){
        imgh.setImageResource(R.drawable.ic_baseline_home_24);
        txth.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
        dietaimg.setImageResource(R.drawable.ic_baseline_food_bank_24_click);
        dietatxt.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.amarelo));
        treinoimg.setImageResource(R.drawable.ic_baseline_fitness_center_24);
        treinotxt.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
        estaimg.setImageResource(R.drawable.ic_baseline_data_usage_24);
        estatxt.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
    }
    private void changebntcolorTreino(){
        imgh.setImageResource(R.drawable.ic_baseline_home_24);
        txth.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
        dietaimg.setImageResource(R.drawable.ic_baseline_food_bank_24);
        dietatxt.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
        treinoimg.setImageResource(R.drawable.ic_baseline_fitness_center_24_click);
        treinotxt.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.amarelo));
        estaimg.setImageResource(R.drawable.ic_baseline_data_usage_24);
        estatxt.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
    }
    private void changebntcolorEsta(){
        imgh.setImageResource(R.drawable.ic_baseline_home_24);
        txth.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
        dietaimg.setImageResource(R.drawable.ic_baseline_food_bank_24);
        dietatxt.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
        treinoimg.setImageResource(R.drawable.ic_baseline_fitness_center_24);
        treinotxt.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
        estaimg.setImageResource(R.drawable.ic_baseline_data_usage_24_click);
        estatxt.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.amarelo));
    }
}