package com.example.t4android01.Entidad;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "animesTabla")
public class Animes {
    public String nombre;
    public String descripcion;
    public String urlImg;
    @PrimaryKey(autoGenerate = true)
    public int id;

    public Animes() {
    }
    public Animes(String nombre, String descripcion, String urlImg, int id) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlImg = urlImg;
        this.id = id;
    }
}
