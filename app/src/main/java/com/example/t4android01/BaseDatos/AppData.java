package com.example.t4android01.BaseDatos;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.t4android01.Entidad.Animes;

@Database(entities = {Animes.class}, version = 1)
public abstract class AppData extends RoomDatabase {
    public abstract AnimeBaseDatos userDao();

    public static AppData getDatabase (Context context){
        return Room.databaseBuilder(context,AppData.class,"databaseDB.animesDb").build();
    }


}
