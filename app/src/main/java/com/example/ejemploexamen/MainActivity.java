package com.example.ejemploexamen;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Ciudades> ciudades;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CrearToolbar();
        AddCiudades();
        AñadirFragment();
        IniciarNavigationView();

    }

    public void CrearToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.activityMain);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_launcher_foreground);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public void AñadirFragment() {
        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        Fragment fragment = new FragmentRecycler(ciudades);
        FT.replace(R.id.fragment_container, fragment);
        FT.commit();
    }

    public void AddCiudades() {
        ciudades = new ArrayList<>();
        ciudades.add(new Ciudades("Alicante", "España", "121545"));
        ciudades.add(new Ciudades("Londres", "Inglaterra", "5646456"));
        ciudades.add(new Ciudades("Madrid", "España", "6566456"));
    }

    public void IniciarNavigationView() {
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.Familia:
                        Toast.makeText(MainActivity.this, "Familia", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Trabajo:
                        Toast.makeText(MainActivity.this, "Trabajo", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Amigos:
                        Toast.makeText(MainActivity.this, "Amigos", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Todos:
                        Toast.makeText(MainActivity.this, "Todos", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.opcSubMenu1:
                break;
            case R.id.opcmenu2:
                break;
            case R.id.navigationView:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
