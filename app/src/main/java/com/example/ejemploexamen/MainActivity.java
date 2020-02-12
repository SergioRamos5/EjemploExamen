package com.example.ejemploexamen;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.ejemploexamen.BaseDatos.MiRecyclerAdapter;
import com.example.ejemploexamen.BaseDatos.OHCategoria;
import com.example.ejemploexamen.RecyclerNormal.FragmentRecycler;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Ciudades> ciudades;
    DrawerLayout drawerLayout;
    AdaptadorSeleccion adaptador;
    RecyclerView recyclerView;
    private ActionModeCallback actionModeCallback = new ActionModeCallback();
    private androidx.appcompat.view.ActionMode actionMode;
    OHCategoria ohCategoria;
    TabLayout tabs;
    SQLiteDatabase sqLiteDatabase;
    MiRecyclerAdapter adapter;
    String[] from;
    int[] to;
    private Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_recycler);


        //CrearToolbar();
        //AddCiudades();
        //AñadirFragment();
        //IniciarNavigationView();
        //CrearSeleccionado();
        //HacerTabs();
        insertarDatosSqlLite();
        crearBaseDatosSqLite();

    }

    public void crearBaseDatosSqLite() {
        ohCategoria = new OHCategoria(this, "BBDContactos", null, 1);
        from = new String[]{"pais", "nombre", "poblacion"};
        to = new int[]{R.id.tv_pais, R.id.tv_nombre};
        sqLiteDatabase = ohCategoria.getReadableDatabase();

        if (sqLiteDatabase != null) {
            recyclerView = findViewById(R.id.recyclerView);
            if (c == null)
                c = sqLiteDatabase.rawQuery("select * from Contactos", null);
            adapter = new MiRecyclerAdapter(R.layout.hodler, c, from, to);
        }

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false));
    }

    public void addSqLite() {
        sqLiteDatabase = ohCategoria.getWritableDatabase();

       /* ContentValues cv = new ContentValues();
        cv.put("nombre", nombre.getText().toString());
        cv.put("apellidos",apellido.getText().toString());
        cv.put("telefono",telefono.getText().toString());
        cv.put("email",correo.getText().toString());
        String img = MainActivity.ConvertirImagenString(BitmapFactory.decodeResource(getResources(), R.drawable.cabeza));
        cv.put("imagen", img);
        cv.put("amigos",amigos.isChecked());
        cv.put("trabajo",trabajo.isChecked());
        cv.put("familia",familia.isChecked());
        sqLiteDatabase.insert("Contactos",null,cv);
        listenerAdd.onItemEdSelected(datos);*/
    }

    public void deleteSqlite() {
        /*public void onClick(DialogInterface dialog, int which) {

        String[] args = {String.valueOf(datos.getId())};

        sqLiteDatabase.delete("Contactos", "id=?", args );
        actualizar();
        recyclerView.setAdapter(mAdapter);
        }*/
    }

    public void actualizarCursor() {
        /*private void actualizar()
        {
            Cursor c = sqLiteDatabase.rawQuery("select * from Contactos", null);
            mAdapter = new MiRecyclerAdapter(R.layout.holder, c, from, to);
        }*/
    }

    public void editSqlite() {
        /*sqLiteDatabase = ohCategoria.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("nombre", nombre.getText().toString());
        cv.put("apellidos",apellido.getText().toString());
        cv.put("telefono",telefono.getText().toString());
        cv.put("email",correo.getText().toString());
        String img = MainActivity.ConvertirImagenString(BitmapFactory.decodeResource(getResources(), R.drawable.cabeza));
        cv.put("imagen", img);
        cv.put("amigos",amigos.isChecked());
        cv.put("trabajo",trabajo.isChecked());
        cv.put("familia",familia.isChecked());
        sqLiteDatabase.update("Contactos",cv,"id = " + datos.getId(),null);

        listenerEdit.onItemEdSelected(datos);*/
    }

    public void insertarDatosSqlLite() {
        sqLiteDatabase = ohCategoria.getWritableDatabase();
        String img;
        if (sqLiteDatabase != null) ;
        {
            ContentValues valores = new ContentValues();
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            valores.put("pais", "España");
            valores.put("nombre", "Alicante");
            valores.put("Poblacion", "676813768");
            sqLiteDatabase.insert("Contactos", null, valores);

            valores.put("pais", "España");
            valores.put("nombre", "Madrid");
            valores.put("Poblacion", "676813768");
            sqLiteDatabase.insert("Contactos", null, valores);
            /*img = ConvertirImagenString(BitmapFactory.decodeResource(getResources(), R.drawable.cabeza));
            valores.put("imagen", img);*/
            sqLiteDatabase.close();
        }
    }

    public void HacerTabs() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        tabs = findViewById(R.id.tablayout);
        tabs.addTab(tabs.newTab().setText("Telefonos"));
        tabs.addTab(tabs.newTab().setText("Tablets"));
        tabs.addTab(tabs.newTab().setText("Portatiles"));

        final ViewPager mviewPager = findViewById(R.id.viewPager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabs.getTabCount());
        mviewPager.setAdapter(adapter);
        mviewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mviewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    public class PagerAdapter extends FragmentStatePagerAdapter {

        int NumOfTabs;

        public PagerAdapter(@NonNull FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.NumOfTabs = NumOfTabs;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new TabFragmetUno();
                case 1:
                    return new TabFragmentDos();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return NumOfTabs;
        }
    }

    public void CrearSeleccionado() {
        recyclerView = findViewById(R.id.recyclerView);
        adaptador = new AdaptadorSeleccion() {
            @Override
            public void onClick(View v) {
                int position = recyclerView.getChildAdapterPosition(v);
                if (actionMode != null) {
                    if (intercambiarSeleccion(position)) {
                        ciudades.get(position).setSeleccionado(true);
                    } else
                        ciudades.get(position).setSeleccionado(false);
                } else
                    Toast.makeText(MainActivity.this, ciudades.get(position).getNombre(), Toast.LENGTH_SHORT).show();
            }

            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.hodler, parent, false);

                HolderSeleccion holder = new HolderSeleccion(v);
                v.setOnClickListener(this);
                v.setOnLongClickListener(this);

                return holder;
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                ((HolderSeleccion) holder).bind(ciudades.get(position), position);
            }

            @Override
            public int getItemCount() {
                return ciudades.size();
            }

            @Override
            public boolean onLongClick(View view) {
                int position = recyclerView.getChildAdapterPosition(view);
                if (actionMode == null) {
                    actionMode = startSupportActionMode(actionModeCallback);
                }
                if (intercambiarSeleccion(position)) {
                    ciudades.get(position).setSeleccionado(true);
                } else
                    ciudades.get(position).setSeleccionado(false);

                return true;
            }

        };

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adaptador);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false));
    }

    public class ActionModeCallback implements androidx.appcompat.view.ActionMode.Callback {


        @Override
        public boolean onCreateActionMode(androidx.appcompat.view.ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(androidx.appcompat.view.ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(androidx.appcompat.view.ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_remove:
                    mode.finish();
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(androidx.appcompat.view.ActionMode mode) {
            adaptador.clearSelection();

            actionMode = null;
        }
    }

    private boolean intercambiarSeleccion(int position) {
        boolean seleccionado = adaptador.toggleSelection(position);
        int count = adaptador.getSelectedItemCount();

        if (count == 0) {
            actionMode.finish();
        } else {
            actionMode.setTitle(String.valueOf(count));
            actionMode.invalidate();
        }
        return seleccionado;
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
        ciudades.add(new Ciudades("Alicante", "España", "121545", false));
        ciudades.add(new Ciudades("Londres", "Inglaterra", "5646456", false));
        ciudades.add(new Ciudades("Madrid", "España", "6566456", false));
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

    static public Bitmap convertirStringBitmap(String imagen) {
        byte[] decodedString = Base64.decode(imagen, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }

    static public String ConvertirImagenString(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream);
        byte[] byte_arr = stream.toByteArray();
        String image_str = Base64.encodeToString(byte_arr, Base64.DEFAULT);
        return image_str;
    }

}
