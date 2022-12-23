package com.example.mirucasey.model;

import java.util.List;

public class AllGenres {

    String genreTitle;
    Integer genreId;
    private List<GenreItem> genreItemList = null;

    public AllGenres(Integer genreId, String genreTitle, List<GenreItem> genreItemList) {
        this.genreId = genreId;
        this.genreTitle = genreTitle;
        this.genreItemList = genreItemList;
    }

    public List<GenreItem> getGenreItemList() {
        return genreItemList;
    }

    public void setGenreItemList(List<GenreItem> genreItemList) {
        this.genreItemList = genreItemList;
    }

    public String getGenreTitle() {
        return genreTitle;
    }

    public void setGenreTitle(String genreTitle) {
        this.genreTitle = genreTitle;
    }

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }
}
