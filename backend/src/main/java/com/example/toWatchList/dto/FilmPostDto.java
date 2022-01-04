package com.example.toWatchList.dto;


import com.example.toWatchList.entity.Film;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class FilmPostDto {

    @NotBlank
    private String name;

    @Min(1800)
    @Max(2022)
    private int year;

    @Min(0)
    @Max(10)
    private float rating;

    @NotBlank
    private String genre;


    public FilmPostDto(String name, int year, float rating, String genre) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.genre = genre;
    }

    public FilmPostDto(Film film) {
        this.year = film.getYear();
        this.rating = film.getRating();
        this.genre = film.getGenre();
        this.name = film.getName();
    }

    public FilmPostDto() {
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
