package com.example.thebox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class CustomerMain extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_main);
        Toolbar toolbar = findViewById(R.id.activity_customer_main_toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.activity_customer_main_drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CustomerHome()).commit();
            navigationView.setCheckedItem(R.id.customer_home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case  R.id.customer_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CustomerHome()).commit();
                break;
            case  R.id.customer_boxes_fragment:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CustomerViewBoxes()).commit();
                break;
            case  R.id.customer_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CustomerProfile()).commit();
                break;
            case  R.id.customer_orders_fragment:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CustomerOrders()).commit();
                break;
            case  R.id.customer_schedule_fragment:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CustomerSchedule()).commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen((GravityCompat.START))){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}