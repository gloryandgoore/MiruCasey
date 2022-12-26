package com.example.mirucasey.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Anime implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    int id;
    public String animeName;

    public Anime(int id, String animeName) {
        this.id = id;
        this.animeName = animeName;
    }

    @Ignore public Anime(int id) {

        this.id = id;
    }



    protected Anime(Parcel in) {
        id = in.readInt();
        animeName = in.readString();

    }

    public static final Parcelable.Creator<Anime> CREATOR = new Parcelable.Creator<Anime>() {
        @Override
        public Anime createFromParcel(Parcel in) {
            return new Anime(in);
        }

        @Override
        public Anime[] newArray(int size) {
            return new Anime[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(animeName);
    }

    public int getId() {
        return id;
    }

    public String getAnimeName() {
        return animeName;
    }
}
