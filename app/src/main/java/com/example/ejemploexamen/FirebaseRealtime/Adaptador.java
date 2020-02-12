package com.example.ejemploexamen.FirebaseRealtime;

/*import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.ejemploexamen.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class Adaptador extends FirebaseRecyclerAdapter<Prediccion, PrediccionHolder> implements View.OnClickListener {

    private View.OnClickListener listener;

    public Adaptador(@NonNull FirebaseRecyclerOptions<Prediccion> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PrediccionHolder holder, int position, @NonNull Prediccion model) {
        holder.bind(model);
    }

    @NonNull
    @Override
    public PrediccionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder, parent, false);
        view.setOnClickListener(this);
        return new PrediccionHolder(view);
    }
    void onClickListener(View.OnClickListener listener)
    {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null)
            listener.onClick(v);
    }


}*/
