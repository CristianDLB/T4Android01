package com.example.t4android01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.t4android01.Entidad.Animes;
import com.example.t4android01.Factor.RetroFactor;
import com.example.t4android01.Servicio.animeService;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Crear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);

        Button btnRegis = findViewById(R.id.btnRegistrando);
        EditText BtName = findViewById(R.id.intNombre);
        EditText BtDescr = findViewById(R.id.intDesc);
        EditText Bturl = findViewById(R.id.intUrl);

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retro = RetroFactor.Links();
                animeService service = retro.create(animeService.class);
                Animes anime1 = new Animes();

                anime1.nombre = String.valueOf(BtName.getText());
                anime1.descripcion = String.valueOf(BtDescr.getText());
                anime1.urlImg = String.valueOf(Bturl.getText());

                Call<Animes> call = service.posAnimes(anime1);

                call.enqueue(new Callback<Animes>() {
                    @Override
                    public void onResponse(Call<Animes> call, Response<Animes> response) {
                        Log.i("App_Anime","Hubo conectividad");
                        Log.i("App_Anime",new Gson().toJson(response.body()));
                        Log.i("App_Anime","Anime Registradoooo");
                    }

                    @Override
                    public void onFailure(Call<Animes> call, Throwable t) {
                        Log.e("App_Anime","No Hubo conectividad");
                    }
                });


            }
        });


    }
}