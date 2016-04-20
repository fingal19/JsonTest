package com.example.fx50j.redrocktest;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar mtoolbar;
    private DrawerLayout mdrawerLayout;
    private NavigationView mnavigation;
    private ViewPager mviewpager;
    private TabLayout mtablayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_view();

    }

    private void init_view() {
        mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);

        mdrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mnavigation = (NavigationView) findViewById(R.id.navigation);
        ActionBarDrawerToggle drawertoggle = new ActionBarDrawerToggle(this,mdrawerLayout,mtoolbar,R.string.close,R.string.open);
        mdrawerLayout.setDrawerListener(drawertoggle);
        drawertoggle.syncState();

        mviewpager = (ViewPager) findViewById(R.id.viewpager);
        FragmentAdapter madapter = new FragmentAdapter(getSupportFragmentManager());
        mviewpager.setAdapter(madapter);

        mtablayout = (TabLayout) findViewById(R.id.tab);
        mtablayout.setupWithViewPager(mviewpager);

    }
}
