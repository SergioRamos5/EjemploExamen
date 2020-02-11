package com.example.ejemploexamen;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentRecycler extends Fragment {

    RecyclerView recyclerView;
    Adaptador adaptador;
    ArrayList<Ciudades> ciudades;
    SwipeDetector swipeDetector;
    int pos ;

    public FragmentRecycler(ArrayList<Ciudades> ciudades) {
        this.ciudades = ciudades;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler, container, false);

        adaptador = new Adaptador(ciudades);
        swipeDetector = new SwipeDetector();
        adaptador.setTouchListener(swipeDetector);
        adaptador.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (swipeDetector.swipeDetected())
                {
                    if (swipeDetector.getAction() == SwipeDetector.Action.LR)
                    {
                        Toast.makeText(getContext(), "Touck derecho", Toast.LENGTH_SHORT).show();
                    }
                    else if (swipeDetector.getAction() == SwipeDetector.Action.RL){
                        Toast.makeText(getContext(), "Touck izquierdo", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    pos = recyclerView.getChildAdapterPosition(v);

                    PopupMenu popupMenu = new PopupMenu(getContext(), v);
                    popupMenu.getMenuInflater().inflate(R.menu.menu_contextual, popupMenu.getMenu());

                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {

                            switch (item.getItemId())
                            {
                                case R.id.takePhoto:
                                    Intent intento = new Intent("android.media.action.IMAGE_CAPTURE");
                                    startActivityForResult(intento,1);
                                    break;
                                case R.id.openGalery:
                                    Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                                    startActivityForResult(gallery, 2);
                                    break;
                                case R.id.deletePhoto:
                                    Toast.makeText(getContext(), "Eliminar", Toast.LENGTH_SHORT).show();
                                    break;
                                case R.id.cancel:
                                    break;
                            }
                            return true;
                        }
                    });
                    popupMenu.show();
                }
            }
        });

        adaptador.setLongListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getContext(), "Long Click sobre la ciudad", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adaptador);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false));
        return v;
    }


}
