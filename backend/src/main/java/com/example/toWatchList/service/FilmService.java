package com.example.toWatchList.service;

import com.example.toWatchList.dto.FilmPostDto;
import com.example.toWatchList.dto.SearchDto;
import com.example.toWatchList.response.Response;

public interface FilmService {
    public Response getAllFilms();
    public Response getFilmById(int id);
    public Response getFilmsByParams( SearchDto searchDto);
    public Response saveFilm(FilmPostDto filmPostDto);
    public void deleteFilm(int id);

}
