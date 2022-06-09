package com.example.t4android01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.t4android01.Adaptador.animeAdapter;
import com.example.t4android01.Entidad.Animes;
import com.example.t4android01.Factor.RetroFactor;
import com.example.t4android01.Servicio.animeService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Mostrar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        Retrofit retro = RetroFactor.Links();
        animeService animeSer = retro.create(animeService.class);
        Call<List<Animes>> call = animeSer.getAnimess();

        call.enqueue(new Callback<List<Animes>>() {
            @Override
            public void onResponse(Call<List<Animes>> call, Response<List<Animes>> response) {
                if (!response.isSuccessful()){
                    Log.e("App_Anime","ERROR APP");
                }else{
                    Log.i("App_Anime","Me Conecteeee :)");
                    List<Animes> an = response.body();
                    animeAdapter adapter = new animeAdapter(an);

                    RecyclerView rv = findViewById(R.id.RvMostrando);
                    rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rv.setHasFixedSize(true);
                    rv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Animes>> call, Throwable t) {
                Log.e("App_Anime","No Hubo conectividad");
            }
        });





    }
}