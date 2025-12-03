package com.pluralsight;

public class Film {
    int filmid;
    String title;
    String description;

    public Film(int filmid, String title, String description) {
        this.filmid = filmid;
        this.title = title;
        this.description = description;
    }

    public int getFilmid() {
        return filmid;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

}
