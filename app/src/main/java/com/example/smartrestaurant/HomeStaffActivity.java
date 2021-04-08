package com.example.smartrestaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class HomeStaffActivity extends AppCompatActivity {

    NavigationView navigationView;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_staff);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId() ) {
                    case R.id.nav_home:
                    Fragment homeFragment = new HomeFragment();
                    FragmentTransaction transaction1 = getSupportFragmentManager()
                            .beginTransaction();

                    transaction1.replace(R.id.fContainer, homeFragment);
                    transaction1.addToBackStack(null);

                    transaction1.commit();
                    break;
                    case R.id.nav_profileStaff:
                        Fragment staffFragment = new StaffFragment();
                        FragmentTransaction transaction2 = getSupportFragmentManager()
                                .beginTransaction();

                        transaction2.replace(R.id.fContainer, staffFragment);
                        transaction2.addToBackStack(null);

                        transaction2.commit();
                        break;
                    case R.id.nav_menuFood:
                        Fragment menuFoodFragment = new MenuFoodFragment();
                        FragmentTransaction transaction3 = getSupportFragmentManager()
                                .beginTransaction();

                        transaction3.replace(R.id.fContainer, menuFoodFragment);
                        transaction3.addToBackStack(null);

                        transaction3.commit();

                        break;
                    case R.id.nav_revenue:
                        Fragment revenueFragment = new RevenueFragment();
                        FragmentTransaction transaction4 = getSupportFragmentManager()
                                .beginTransaction();

                        transaction4.replace(R.id.fContainer, revenueFragment);
                        transaction4.addToBackStack(null);

                        transaction4.commit();
                        break;
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerMain);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(this
                ,drawerLayout,toolbar
                ,R.string.navigation_drawer_open
                ,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }
int click = 0;
    @Override
    public void onBackPressed() {
        if(click<2){
            click++;
            return;
        }
        super.onBackPressed();
    }
}