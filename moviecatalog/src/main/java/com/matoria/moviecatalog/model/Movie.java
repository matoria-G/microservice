package com.matoria.moviecatalog.model;

public class Movie {
    private String id;

    public Movie() {
    }

    public Movie(String id, String desc, int rating) {
        this.id = id;
        this.desc = desc;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String desc;
    private int rating;

}
