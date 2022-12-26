package com.example.mirucasey.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(version =1, entities = {Anime.class})
public abstract class AnimeDatabase extends RoomDatabase {
    public abstract AnimeDAO getDao();

}
