package com.example.t4android01.Servicio;

import com.example.t4android01.Entidad.Animes;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface animeService {

    @GET("animes")
    Call<List<Animes>>getAnimess();

    @GET("animes/{id}")
    Call<Animes> idEtidAnimes(@Path("id")int id);

    @POST("animes")
    Call<Animes> posAnimes(@Body Animes anime);

}
