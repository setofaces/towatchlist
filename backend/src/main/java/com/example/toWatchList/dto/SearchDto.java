package com.example.toWatchList.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class SearchDto {

    @Min(1900)
    @Max(2023)
    int year1;

    @Min(1900)
    @Max(2023)
    int year2;

    @Min(0)
    @Max(10)
    float rating1;

    @Min(0)
    @Max(10)
    float rating2;

    String genre;

    public SearchDto(int year1, int year2, float rating1, float rating2, String genre) {
        this.year1 = year1;
        this.year2 = year2;
        this.rating1 = rating1;
        this.rating2 = rating2;
        this.genre = genre;
    }

    public SearchDto() {
    }

    public int getYear1() {
        return year1;
    }

    public void setYear1(int year1) {
        this.year1 = year1;
    }

    public int getYear2() {
        return year2;
    }

    public void setYear2(int year2) {
        this.year2 = year2;
    }

    public float getRating1() {
        return rating1;
    }

    public void setRating1(float rating1) {
        this.rating1 = rating1;
    }

    public float getRating2() {
        return rating2;
    }

    public void setRating2(float rating2) {
        this.rating2 = rating2;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
