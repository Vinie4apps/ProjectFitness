package com.vinie4apps.projectfitness.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.vinie4apps.projectfitness.R;
import com.vinie4apps.projectfitness.app.semana.ModelSemana;
import com.vinie4apps.projectfitness.app.semana.PageAdapterSemana;

import java.util.ArrayList;
import java.util.List;

public class estatistica extends AppCompatActivity {


    //import de objs
    private PageAdapter pageAdapter;
    private ViewPager viewPagers;
    List<ModelSemana> models;
    PageAdapterSemana adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estatistica_view);


        // config. do ViewHolder
        models = new ArrayList<>();
        models.add(new ModelSemana("TESTE"));
        adapter = (PageAdapterSemana) new PageAdapterSemana(models, this);

        // config. do ViewHolder
        viewPagers = findViewById(R.id.view_pagerEst);
        viewPagers.setAdapter((PagerAdapter) adapter);


      /*  // config. da Tabs
        TabLayout tabs = findViewById(R.id.tabsSemana);
        tabs.setupWithViewPager(viewPagers);
        tabs.setBackgroundColor(ContextCompat.getColor(this, R.color.azul));
        tabs.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.white));
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.azul));
        }


        viewPagers.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });


*/

    }


    }

