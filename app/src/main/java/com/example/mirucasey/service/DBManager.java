package com.example.mirucasey.service;

import android.content.Context;
import android.os.Looper;

import androidx.room.Room;

import com.example.mirucasey.MyApp;
import com.example.mirucasey.model.Anime;
import com.example.mirucasey.model.AnimeDatabase;
import com.example.mirucasey.model.HeaderAnimes;

import android.os.Handler;
import java.util.logging.LogRecord;

public class DBManager {

    public interface DataBaseListener{
        void insertingAnimeCompleted();
        void gettingAnimeCompleted(Anime[] list);

    }

    public DataBaseListener listener;

    AnimeDatabase animeDB;
    Handler dbHandler = new Handler(Looper.getMainLooper());


    public AnimeDatabase getAnimeDB(Context context){
        if (animeDB == null)
            animeDB = Room.databaseBuilder(context,AnimeDatabase.class,"anime_db").build();

        return animeDB;
    }

    void insertNewAnimeAsync(Anime t){

        MyApp.executorService.execute(new Runnable() {
            @Override
            public void run() {
                animeDB.getDao().addNewWishAnime(t);
                dbHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        // notify main thread
                        listener.insertingAnimeCompleted();
                    }
                });
            }
        });
    }

    public void getAllAnimes(){
        MyApp.executorService.execute(new Runnable() {
            @Override
            public void run() {
                Anime[] list = animeDB.getDao().getAllAnimes();
                dbHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        // notify main thread
                        listener.gettingAnimeCompleted(list);
                    }
                });
            }
        });
    }
}

