package com.example.t4android01.BaseDatos;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.t4android01.Entidad.Animes;

import java.util.List;

@Dao
public interface AnimeBaseDatos {

    @Query("SELECT * FROM animesTabla")
    List<Animes> getTodo();

}
