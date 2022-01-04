package com.example.toWatchList.dto;


import com.example.toWatchList.entity.Film;

public class FilmGetDto {

    private int id;

    private String name;

    private int year;

    private float rating;

    private String genre;


    public FilmGetDto(int id, String name, int year, float rating, String genre) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.genre = genre;
    }

    public FilmGetDto(Film film) {
        this.id= film.getId();
        this.year = film.getYear();
        this.rating = film.getRating();
        this.genre = film.getGenre();
        this.name = film.getName();
    }

    public FilmGetDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
