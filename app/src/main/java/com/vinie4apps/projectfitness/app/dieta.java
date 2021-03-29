package com.vinie4apps.projectfitness.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.vinie4apps.projectfitness.R;

public class dieta extends AppCompatActivity {


    //import de objs
    private PageAdapter pageAdapter;
    private ViewPager viewPager;
    private int[] layouts;
    FirebaseAuth auth;
    LinearLayout home, dieta, treino, estatistica;
    ImageView imgh;
    TextView txth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dieta_view);

        // Lin. button
        home = (LinearLayout) findViewById(R.id.homell);
        dieta = (LinearLayout) findViewById(R.id.dietall);
        treino = (LinearLayout) findViewById(R.id.treinoll);
        estatistica = (LinearLayout) findViewById(R.id.estatisticall);

        // definir color
        imgh = (ImageView) findViewById(R.id.imghome);
        txth = (TextView) findViewById(R.id.txthome);



    }
}