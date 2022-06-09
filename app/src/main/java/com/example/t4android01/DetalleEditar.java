package com.example.t4android01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.t4android01.Entidad.Animes;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class DetalleEditar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_editar);

        String animeJson2 = getIntent().getStringExtra("ANIMES");
        Animes animes = new Gson().fromJson(animeJson2,Animes.class);

        ImageView tvAvatar = findViewById(R.id.detalleAvatar);
        TextView tvNombre = findViewById(R.id.detalleNombre);
        TextView tvDecri = findViewById(R.id.detalleDescrip);

        Picasso.get().load(animes.urlImg).into(tvAvatar);
        tvNombre.setText(animes.nombre);
        tvDecri.setText(animes.descripcion);

    }
}