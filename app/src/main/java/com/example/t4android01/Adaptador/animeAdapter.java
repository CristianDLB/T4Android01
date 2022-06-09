package com.example.t4android01.Adaptador;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t4android01.DetalleEditar;
import com.example.t4android01.Entidad.Animes;
import com.example.t4android01.Factor.RetroFactor;
import com.example.t4android01.R;
import com.example.t4android01.Servicio.animeService;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class animeAdapter extends RecyclerView.Adapter<animeAdapter.animeHolder> {


    List<Animes> anime;
    public animeAdapter(List<Animes> anime){
        this.anime=anime;
    }

    @NonNull
    @Override
    public animeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.mostrar_animes,parent,false);
        animeHolder holder = new animeHolder(vista);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull animeHolder holder, int position) {
        View view = holder.itemView;
        Animes animes = anime.get(position);
        TextView TvNombre = view.findViewById(R.id.nombre);
        TextView TvDescripcion = view.findViewById(R.id.descripcion);
        ImageView imgAvatar = view.findViewById(R.id.imgAvatar);

        TvNombre.setText(animes.nombre);
        TvDescripcion.setText(animes.descripcion);

        Picasso.get().load(animes.urlImg).into(imgAvatar);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retro = RetroFactor.Links();
                animeService service = retro.create(animeService.class);
                Call<Animes> call = service.idEtidAnimes(animes.id);

                call.enqueue(new Callback<Animes>() {
                    @Override
                    public void onResponse(Call<Animes> call, Response<Animes> response) {
                        if (!response.isSuccessful()){
                            Log.e("App_Anime","ERROR APP");
                        }else{
                            Log.i("App_Anime","Voy a Editar");
                            Log.i("App_Anime",new Gson().toJson(response.body()));
                            Intent intent = new Intent(view.getContext(), DetalleEditar.class);

                            String animeJSON =new Gson().toJson(animes);
                            intent.putExtra("ANIMES", animeJSON);

                            view.getContext().startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<Animes> call, Throwable t) {
                        Log.e("App_Anime","No Hubo conectividad");
                    }
                });


            }
        });


    }

    @Override
    public int getItemCount() {
        return anime.size();
    }

    class animeHolder extends RecyclerView.ViewHolder{

        public animeHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
