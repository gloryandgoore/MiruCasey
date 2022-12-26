package com.example.mirucasey.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface AnimeDAO {
    //add to wish list
    @Insert
    void addNewWishAnime(Anime w);


    @Query("select * from Anime")
    Anime [] getAllAnimes();

    @Delete
    void deleteAnAnime(Anime w);

}
