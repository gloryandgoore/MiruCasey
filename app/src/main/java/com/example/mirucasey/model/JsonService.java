package com.example.mirucasey.model;

import android.os.Parcel;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonService {
    public static ArrayList<Anime> fromJSONToList(String jsonString){
        ArrayList<Anime> list = new ArrayList<>(0);
        try {
            JSONArray jsonArray = new JSONArray(jsonString);

            for (int i = 0 ; i< jsonArray.length(); i++){
                Log.d("miru", jsonArray.getString(i));
                list.add(new Anime(jsonArray.getInt(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static AnimeObject fromJsonToAnime(String jsonString){
        AnimeObject obj = new AnimeObject();

        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray animeArray = jsonObject.getJSONArray("data");
            obj.id =  animeArray.getJSONObject(0).getInt("_id");
            obj.animeName =  animeArray.getJSONObject(0).getString("title");
            obj.imageUrl = animeArray.getJSONObject(0).getString("image");
            obj.synopsis =  animeArray.getJSONObject(0).getString("synopsis");
            obj.animeGenres = animeArray.getJSONObject(0).getJSONArray("genres");

//            this.id = id;
//            this.animeName = animeName;
//            this.imageUrl = imageUrl;
//            this.synopsis = synopsis;
//            this.animeGenres = animeGenres;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
